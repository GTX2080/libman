package com.chen.library.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 通过FTP上传文件
 */
public class FTPTools {

	// 用于打印日志
	private static final Logger log = Logger.getLogger(FTPTools.class);
	public static final String fileServerPath = PropertiesUtil.getValue("application.properties", "ftp.workpath");
	public static final String fileallpath = PropertiesUtil.getValue("application.properties", "file.fileserver");

	public static final String ftpHostName = PropertiesUtil.getValue("application.properties", "ftp.hostname");
	public static final Integer ftpPort = Integer
			.valueOf(PropertiesUtil.getValue("application.properties", "ftp.port"));
	public static final String ftpUserName = PropertiesUtil.getValue("application.properties", "ftp.username");
	public static final String ftpPassword = PropertiesUtil.getValue("application.properties", "ftp.password");

	// 设置私有不能实例化
	private FTPTools() {
	}

	/**
	 * Description: ftp连接
	 * 
	 * @param hostname
	 *            ip或域名地址
	 * @param port
	 *            端口
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 */
	private static FTPClient getConnect(String host, int port, String username, String password) {
		FTPClient ftp = new FTPClient();
		int reply;
		try {
			ftp.connect(host, port);// 连接FTP服务器
			// 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
			ftp.login(username, password);// 登录
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return null;
			}
			log.info("------------->FTP连接成功！");
		} catch (IOException e) {
			log.error("------------->FTP连接失败！");
			e.printStackTrace();
		}
		return ftp;
	}

	/**
	 * 断开连接
	 * 
	 * @param ftpClient
	 * @throws Exception
	 */
	private static void disConnect(FTPClient ftp) {
		if (ftp.isConnected()) {
			try {
				ftp.disconnect();
				log.info("------------->FTP关闭成功！");
			} catch (IOException ioe) {
				log.info("------------->FTP关闭失败！");
				ioe.printStackTrace();
			}
		}
	}

	/**
	 * Description: ftp文件上传返回文件实体集合
	 * 
	 * @param files
	 *            文件数组
	 * @param fileContentPath
	 *            上传路径
	 * @param epriUserid
	 *            用户id
	 * @param epriUploadType
	 *            上传类型
	 * @return List<FileUploadEntity>
	 * 
	 * @throws IOException
	 */
	public static List<FileUploadEntity> uploadFileByFtp(MultipartFile[] files, String fileContentPath,
			String eprifileid, String epriUserid, String epriUploadType) throws IOException {
		
		InputStream inputStream = null;
		FTPClient ftpClient = null;
		List<FileUploadEntity> list = new ArrayList<FileUploadEntity>();
		
		long start1 = System.currentTimeMillis();
		ftpClient = getConnect(ftpHostName, ftpPort, ftpUserName, ftpPassword);
		
		for (MultipartFile file : files) {
			FileUploadEntity fileUploadEntity = new FileUploadEntity();
			String fileid = "";
			TimestampID stampID = new TimestampID(5, 4);
			if (eprifileid == null || eprifileid.equals("")) {
				fileid = String.valueOf(stampID.nextId());
			} else {
				fileid = eprifileid;
			}

			// 获取文件的后缀
			String orgfileSuffixName = file.getOriginalFilename()
					.substring((file.getOriginalFilename().lastIndexOf(".")));
			// 获取文件名（去掉后缀)
			String orgfileName = file.getOriginalFilename().substring(0, (file.getOriginalFilename().lastIndexOf(".")));
			// 上传路径 注意：ftp连接成功后默认就切到ftp的默认路径下（fileServerPath），所以changeWorkingDirectory只能到fileServerPath下的文件夹
			String path = fileServerPath + "/" + fileContentPath ; // 设定文件保存的目录
			// 获得原始文件名
			String fileName = file.getOriginalFilename();
			log.info("原始文件名:" + fileName);
			//文件大小
			//long fileSize = file.getSize();
			// 构建文件名称(UUID+日期+后缀）
			String newFileName = fileid + orgfileSuffixName;

			if (!file.isEmpty()) {
				if (ftpClient == null) {
					return null;
				}
				if (!ftpClient.changeWorkingDirectory(path)) {
					// 如果目录不存在创建目录
					/*String[] dirs = fileContentPath.split("/");
					String tempPath = "";
					for (String dir : dirs) {
						if (StringUtils.isBlank(dir))
							continue;
						tempPath += "/" + dir;
						if (!ftpClient.changeWorkingDirectory(tempPath)) {
							if (!ftpClient.makeDirectory(tempPath)) {
								return null;
							} else {
								ftpClient.changeWorkingDirectory(tempPath);
							}
						}
					}*/
					if (!ftpClient.makeDirectory(fileContentPath)) {
						return null;
					}else{
						if(!ftpClient.changeWorkingDirectory(path)){
							return null;
						}
					}
				}
				// 设置为被动模式
				ftpClient.enterLocalPassiveMode();
				// 设置上传文件的类型为二进制类型
				ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
				ftpClient.setBufferSize(1024*1024);
				// 上传文件
				inputStream = file.getInputStream();
				BufferedInputStream input = new BufferedInputStream(inputStream);
				if (!ftpClient.storeFile(newFileName, input)) {
					return null;
				}
				log.info("FTP文件上传到---------->" + path + "/" + newFileName);
				inputStream.close();
			}

			File uploadFile = null;
			try {
				uploadFile = new File(path + "/" + newFileName);
				// 设置文件实体对象
				fileUploadEntity.setEpriFiledowns(0);// 文件下载次数
				fileUploadEntity.setEpriFileid(String.valueOf(fileid));// 附件表主键Id
				fileUploadEntity.setEpriFileorigname(orgfileName);// 原始文件名
				fileUploadEntity.setEpriFileexttype(orgfileSuffixName);// 文件类型
				fileUploadEntity.setEpriFilepath(fileContentPath + "/" + uploadFile.getName());// 文件FTP相对路径
				fileUploadEntity.setEpriFilesize(String.valueOf(uploadFile.length()));// 文件大小
				fileUploadEntity.setEpriFileuploadname(String.valueOf(fileid));// 文件上传后的名称
				fileUploadEntity.setEpriFileuse(epriUploadType);// 上传类型
				fileUploadEntity.setEpriUserid(epriUserid);// 用户id
				fileUploadEntity.setEpriFileAllPath(fileallpath + "/" + fileContentPath + "/" + uploadFile.getName());// 文件http地址

			} catch (Exception e) {
				e.printStackTrace();
				log.error("上传文件服务器失败,原因为" + e.getLocalizedMessage());
			} finally {
				if (uploadFile != null)
					uploadFile = null;
			}

			list.add(fileUploadEntity);
		}
		disConnect(ftpClient);
		long end1 = System.currentTimeMillis();
		log.info("======================>FTP文件完成，总共耗时："+(end1-start1)+"毫秒。");
		return list;
	}

	/**
	 * Description: 从FTP服务器下载文件
	 * 
	 * @param host
	 *            FTP服务器hostname
	 * @param port
	 *            FTP服务器端口
	 * @param username
	 *            FTP登录账号
	 * @param password
	 *            FTP登录密码
	 * @param remotePath
	 *            FTP服务器上的相对路径
	 * @param fileName
	 *            要下载的文件名
	 * @param localPath
	 *            下载后保存到本地的路径
	 */
	public static boolean downloadFile(String host, int port, String username, String password, String remotePath,
			String fileName, String localPath) {
		boolean result = false;
		FTPClient ftp = getConnect(host, port, username, password);
		try {
			if (ftp == null) {
				return result;
			}
			ftp.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录
			try {
				FTPFile[] fs = ftp.listFiles();
				for (FTPFile ff : fs) {
					if (ff.getName().equals(fileName)) {
						File localFile = new File(localPath + "/" + ff.getName());
						OutputStream is = new FileOutputStream(localFile);
						ftp.retrieveFile(ff.getName(), is);
						is.close();
					}
				}
				ftp.logout();
				result = true;
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			disConnect(ftp);
		}
		return result;
	}

	/**
	 * @Description: 删除文件夹中的文件
	 * @param remotePath
	 *            要删除的文件夹
	 */
	public static boolean delFolder(String host, int port, String username, String password, String uploadPath,
			String remotePath) {
		boolean result = false;
		if (!remotePath.contains(uploadPath)) {
			remotePath = uploadPath + "/" + remotePath;
		}
		FTPClient ftp = getConnect(host, port, username, password);
		try {
			if (ftp == null) {
				return result;
			}
			ftp.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录
			FTPFile[] fs = ftp.listFiles();
			for (FTPFile ff : fs) {
				// 循环删除文件
				delFile(host, port, username, password, remotePath + "/" + ff.getName());
			}
			ftp.logout();
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			disConnect(ftp);
		}
		return result;
	}

	/**
	 * @Description: 删除文件
	 * 
	 * @param filePath
	 *            删除文件的物理路径
	 * @param host
	 *            FTP服务器hostname
	 * @param port
	 *            FTP服务器端口
	 * @param username
	 *            FTP登录账号
	 * @param password
	 *            FTP登录密码
	 * 
	 */
	public static boolean delFile(String host, int port, String username, String password, String filePath) {
		boolean result = false;
		FTPClient ftp = getConnect(host, port, username, password);
		if (ftp == null || StringUtils.isEmpty(filePath)) {
			return result;
		}
		try {
			ftp.deleteFile(filePath);
			ftp.logout();
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			disConnect(ftp);
		}
		return result;
	}

}
