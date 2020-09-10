package com.chen.library.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;


public class FileUtil {

	private static Logger log = LoggerFactory.getLogger(FileUtil.class);
	public static final String fileServerPath = PropertiesUtil.getValue("application.properties", "file.workpath");
	public static final String fileallpath = PropertiesUtil.getValue("application.properties", "file.fileserver");

	/**
	 * 
	 * @param file
	 * @param ftppath
	 * @param eprifileid
	 * @param epriUserid
	 * @param epriUploadType
	 * @return
	 * @throws IOException
	 */
	public static FileUploadEntity upfileToFileServer(MultipartFile file, String fileContentPath,
			String eprifileid, String epriUserid, String epriUploadType, boolean synchronizeFlag) throws IOException {

		FileUploadEntity fileUploadEntity = new FileUploadEntity();
		String fileid = "";
		TimestampID stampID = new TimestampID(5, 4);
		if (eprifileid == null || eprifileid.equals("")) {
			fileid = String.valueOf(stampID.nextId());
		} else {
			fileid = eprifileid;
		}

		// 获取文件的后缀
		String orgfileSuffixName = file.getOriginalFilename().substring((file.getOriginalFilename().lastIndexOf(".")));
		// 获取文件名（去掉后缀)
		String orgfileName = file.getOriginalFilename().substring(0, (file.getOriginalFilename().lastIndexOf(".")));

		// 上传位置
		String path = fileServerPath + "/" + fileContentPath ; // 设定文件保存的目录
		File uploadFiles = new File(path);
		if (!uploadFiles.exists())
			uploadFiles.mkdirs();

		// 获得原始文件名
		String fileName = file.getOriginalFilename();
		log.debug("原始文件名:" + fileName);
		// 新文件名
		// 构建文件名称(UUID+日期+后缀）
		String newFileName = "";
		if(synchronizeFlag){
			newFileName = fileName;
		}else{
			newFileName = fileid + orgfileSuffixName;
		}

		if (!file.isEmpty()) {
			File newFile=new File(path + "/" + newFileName);
			file.transferTo(newFile);
		}
		log.debug("上传图片到:" + uploadFiles.getAbsolutePath() + "/" + newFileName);

		File uploadFile = null;
		try {
			uploadFile = new File(path + "/" + newFileName);
			// 设置文件实体对象
			fileUploadEntity.setEpriFiledowns(0);// 文件下载次数
			fileUploadEntity.setEpriFileid(String.valueOf(fileid));// 附件表主键Id
			fileUploadEntity.setEpriFileorigname(orgfileName);// 原始文件名
			fileUploadEntity.setEpriFileexttype(orgfileSuffixName);// 文件类型
			fileUploadEntity.setEpriFilepath(fileContentPath + "/" + uploadFile.getName());// 文件相对路径
			fileUploadEntity.setEpriFilesize(String.valueOf(uploadFile.length()));// 文件大小
			fileUploadEntity.setEpriFileuploadname(String.valueOf(fileid));// 文件上传后的名称
			fileUploadEntity.setEpriFileuse(epriUploadType);// 上传类型
			fileUploadEntity.setEpriUserid(epriUserid);// 用户id
			fileUploadEntity.setEpriFileAllPath(fileallpath + "/" + fileContentPath + "/" + uploadFile.getName());// 文件http地址

		} catch (Exception e) {
			e.printStackTrace();
			log.debug("上传文件服务器失败,原因为" + e.getLocalizedMessage());
		} finally {
			log.debug("设置文件实体对象" + fileUploadEntity.toString());
			if (uploadFile != null)
				uploadFile = null;
		}

		return fileUploadEntity;
	}
	
	/**
	 * 删除文件夹下所有的文件
	 * 
	 * @param path
	 * @return
	 */
	public static String fileDelect(String path) {
		try {
			File f = new File(path);
			if (f.isDirectory()) {
				String dirname = f.getName();
				File[] s = f.listFiles();
				for (int i = 0; i < s.length; i++) {
					if (s[i].isFile()) {
						String fileName = s[i].getName();
						boolean delete = s[i].delete();
						log.debug("删除文件:" + fileName + ",delete:" + delete);
					}
				}
				f.delete();
				log.debug("删除文件夹:" + dirname);
				if (f.exists())
					log.debug("文件存在:" + f.getName());
			} else if (f.isFile()) {
				f.delete();
				log.debug("删除单个文件");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "删除完毕";
	}

    /**
     * 删除文件夹下所有的文件夹及文件
     * @param path
     * @return
     */
    public static void delectAllFile(String path) {
        try {
            File f = new File(path);
            if (f.isDirectory()) {
                File[] s = f.listFiles();
                //判断目录是否为空
                if (s != null && s.length > 0){
                    for (int i = 0; i < s.length; i++) {
                        if (s[i].isFile()) {
                            String fileName = s[i].getName();
                            boolean delete = s[i].delete();
                            log.debug("删除文件:" + fileName + ",delete:" + delete);
                        } else{
                            delectAllFile(s[i].getAbsolutePath());
                        }
                    }
                }
                //获取目录名称
                String dirname = f.getName();
                //删除文件夹
                f.delete();
                log.debug("删除文件夹:" + dirname);
            } else if (f.isFile()) {
                f.delete();
                log.debug("删除单个文件");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	/**
	 * 创建目录
	 * 
	 * @param destDirName 目标目录名
	 * @return 目录创建成功返回true，否则返回false
	 */
	public static boolean createDir(String destDirName) {
		File dir = new File(destDirName);
		if (dir.exists()) {
			return false;
		}
		if (!destDirName.endsWith(File.separator)) {
			destDirName = destDirName + File.separator;
		}
		// 创建单个目录
		if (dir.mkdirs()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 删除文件
	 * 
	 * @param filePathAndName String 文件路径及名称 如c:/fqf.txt
	 * @param fileContent     String
	 * @return boolean
	 */
	public static void delFile(String filePathAndName) {
		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			File myDelFile = new File(filePath);
			myDelFile.delete();

		} catch (Exception e) {
			log.debug("删除文件操作出错");
			e.printStackTrace();

		}

	}

	/**
	 * 读取到字节数组0
	 * 
	 * @param filePath //路径
	 * @throws IOException
	 */
	public static byte[] getContent(String filePath) throws IOException {
		File file = new File(filePath);
		long fileSize = file.length();
		if (fileSize > Integer.MAX_VALUE) {
			log.debug("file too big...");
			return null;
		}
		FileInputStream fi = new FileInputStream(file);
		byte[] buffer = new byte[(int) fileSize];
		int offset = 0;
		int numRead = 0;
		while (offset < buffer.length && (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {
			offset += numRead;
		}
		// 确保所有数据均被读取
		if (offset != buffer.length) {
			throw new IOException("Could not completely read file " + file.getName());
		}
		fi.close();
		return buffer;
	}

	/**
	 * 读取到字节数组1
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static byte[] toByteArray(String filePath) throws IOException {

		File f = new File(filePath);
		if (!f.exists()) {
			throw new FileNotFoundException(filePath);
		}
		ByteArrayOutputStream bos = new ByteArrayOutputStream((int) f.length());
		BufferedInputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(f));
			int buf_size = 1024;
			byte[] buffer = new byte[buf_size];
			int len = 0;
			while (-1 != (len = in.read(buffer, 0, buf_size))) {
				bos.write(buffer, 0, len);
			}
			return bos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			bos.close();
		}
	}

	/**
	 * 读取到字节数组2
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static byte[] toByteArray2(String filePath) throws IOException {

		File f = new File(filePath);
		if (!f.exists()) {
			throw new FileNotFoundException(filePath);
		}

		FileChannel channel = null;
		FileInputStream fs = null;
		try {
			fs = new FileInputStream(f);
			channel = fs.getChannel();
			ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
			while ((channel.read(byteBuffer)) > 0) {
				// do nothing
				// log.debug("reading");
			}
			return byteBuffer.array();
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (channel != null) {
					channel.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (fs != null) {
					fs.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Mapped File way MappedByteBuffer 可以在处理大文件时，提升性能
	 * 
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static byte[] toByteArray3(String filePath) throws IOException {

		FileChannel fc = null;
		RandomAccessFile rf = null;
		try {
			rf = new RandomAccessFile(filePath, "r");
			fc = rf.getChannel();
			MappedByteBuffer byteBuffer = fc.map(MapMode.READ_ONLY, 0, fc.size()).load();
			// log.debug(byteBuffer.isLoaded());
			byte[] result = new byte[(int) fc.size()];
			if (byteBuffer.remaining() > 0) {
				// log.debug("remain");
				byteBuffer.get(result, 0, byteBuffer.remaining());
			}
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (rf != null) {
					rf.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (fc != null) {
				fc.close();
			}
		}
	}

	// inputStream转outputStream
	public static void InputStreamToOutStream(InputStream in, OutputStream out) throws Exception {
		if (in != null && out != null) {
			int byteRead = 0;
			byte[] buffer = new byte[8192];
			while ((byteRead = in.read(buffer, 0, 8192)) != -1) {
				out.write(buffer, 0, byteRead);
			}
		}

	}



	/**
	 * 将文件名解析成文件的上传路径
	 * 
	 * @param fileName
	 * @return 上传到服务器的文件名
	 */
	public static String transPath(String fileName, String path) {
		createDir(path);
		Date date = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMddhhmmssSSS");// 定义到毫秒
		String nowStr = dateformat.format(date);
		String filenameStr = fileName.substring(0, fileName.lastIndexOf("."));// 去掉后缀的文件名
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);// 后缀
		if (fileName.trim() != "") {// 如果名称不为"",说明该文件存在，否则说明该文件不存在
			path += "\\" + filenameStr + nowStr + "." + suffix;// 定义上传路径
		}
		return path;
	}


	/**
	 * 下载
	 * 
	 * @param request
	 * @param response
	 * @param filename
	 * @return
	 */
	public static void fileDownload(HttpServletRequest request, HttpServletResponse response, String filename) {

		// 得到要下载的文件名
		String fileName = filename.substring(4);
		try {
			fileName = new String(fileName.getBytes("iso8859-1"), "UTF-8");
			// 获取上传文件的目录
			ServletContext sc = request.getSession().getServletContext();
			// 上传位置
			String fileSaveRootPath = sc.getRealPath("/upload");

			log.debug(fileSaveRootPath + "\\" + fileName);
			// 得到要下载的文件
			File file = new File(fileSaveRootPath + "\\" + fileName);

			// 如果文件不存在
			if (!file.exists()) {
				log.debug("您要下载的资源已被删除！！" + file.getName());
				return;
			}
			// 处理文件名
			String realname = fileName.substring(fileName.indexOf("_") + 1);
			// 设置响应头，控制浏览器下载该文件
			response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname, "UTF-8"));
			// 读取要下载的文件，保存到文件输入流
			FileInputStream in = new FileInputStream(fileSaveRootPath + "\\" + fileName);
			// 创建输出流
			OutputStream out = response.getOutputStream();
			// 创建缓冲区
			byte buffer[] = new byte[1024];
			int len = 0;
			// 循环将输入流中的内容读取到缓冲区当中
			while ((len = in.read(buffer)) > 0) {
				// 输出缓冲区的内容到浏览器，实现文件下载
				out.write(buffer, 0, len);
			}
			// 关闭文件输入流
			in.close();
			// 关闭输出流
			out.close();
		} catch (Exception e) {
		}
	}




    /**
     * 根据文件路径下载文件,并删除临时文件和zip文件
     * @param response
     * @param filePath  文件路径
     * @return
     */
    public static void downloadFileByPath(HttpServletResponse response, String filePath,String tempPath) {
        File file = null;
        try {
            //获取要下载的文件
            file = new File(filePath);

            //如果文件不存在
            if (!file.exists()) {
                log.debug("文件==>" + file.getName() + "不存在！");
                return;
            }

            InputStream in = new BufferedInputStream(new FileInputStream(file));
            //创建缓冲区
            byte[] buffer = new byte[in.available()];
            in.read(buffer);
            in.close();

            //处理文件名
            String fileName = file.getName();
            //清空response
            response.reset();
            response.setCharacterEncoding("UTF-8");
            // 设置响应头，控制浏览器下载该文件
            response.setHeader("content-disposition", "attachment;filename=" + new String(fileName.getBytes("UTF-8"),"ISO8859-1"));
			response.setContentType("application/octet-stream;charset=UTF-8");
            // 读取要下载的文件，保存到文件输入流
            //File testFile = new File("C:\\Users\\dev-2\\Desktop\\课件.zip");// 测试下载压缩文件到本地
            // 创建输出流
            //OutputStream out = new BufferedOutputStream(new FileOutputStream(testFile));

            OutputStream out = new BufferedOutputStream(response.getOutputStream());
            out.write(buffer);

            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //删除临时zip文件
            file.delete();

            //删除临时文件夹及目录
            FileUtil.delectAllFile(tempPath);
        }
    }
}
