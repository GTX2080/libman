package com.chen.library.util;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/*import com.sgcc.sqsc.mapper.base.EnteMapper;
import com.sgcc.sqsc.mapper.base.SysDictMapper;
import com.sgcc.sqsc.model.FileUploadEntity;
import com.sgcc.sqsc.service.base.CommFileDealService;*/

/**
 * 导入工具类
 * 
 * @author xxzx-liulei
 *
 */
@Component
public class ImportUtils {

	/*// 系统字典Mapper
	private static SysDictMapper sysDictMapper;

	// 企业信息Mapper
	private static EnteMapper enteMapper;

	// 通用文件处理Service
	private static CommFileDealService commFileDealService;

	@Autowired
	public void setSysDictMapper(SysDictMapper sysDictMapper) {
		ImportUtils.sysDictMapper = sysDictMapper;
	}

	@Autowired
	public void setEnteMapper(EnteMapper enteMapper) {
		ImportUtils.enteMapper = enteMapper;
	}

	@Autowired
	public void setCommFileDealService(CommFileDealService commFileDealService) {
		ImportUtils.commFileDealService = commFileDealService;
	}*/

	/**
	 * 根据名称检索对应的字典ID
	 * 
	 * @param dictName     字典名称
	 * @param dictFatherId 字典父ID
	 * @return
	 */
/*	public static String getDictIdByName(String dictName, String dictFatherId) {

		// 字典ID
		String dictId = null;

		// 名称不为空时
		if (!StringUtils.isEmpty(dictName)) {

			// 获取字典ID
			dictId = sysDictMapper.searchDictIdByName(dictName, dictFatherId);

			// 如果取不到数据
			if (StringUtils.isEmpty(dictId)) {
				return dictId;
			}
		}

		return dictId;
	}*/

	/**
	 * 根据名称检索对应的企业ID
	 * 
	 * @param name 企业名称
	 * @return
	 */
	/*public static String getEnterpriseIdByName(String name) {

		// 企业ID
		String enterpriseId = null;

		// 名称不为空时
		if (!StringUtils.isEmpty(name)) {

			// 获取企业ID
			enterpriseId = enteMapper.searchEnteIdByName(name);

			// 如果取不到数据
			if (StringUtils.isEmpty(enterpriseId)) {
				return enterpriseId;
			}
		}

		return enterpriseId;
	}*/

	/**
	 * 获取用户类型ID
	 * 
	 * @param userTypeName 用户类型名称
	 * @return
	 */
	/*public static String getUserTypeId(String userTypeName) {

		// 0 其他
		if (DictData.USER_TYPE_NAME_OTHER.equals(userTypeName)) {
			return DictData.USER_TYPE_OTHER;

			// 1 专家
		} else if (DictData.USER_TYPE_NAME_SPEC.equals(userTypeName)) {
			return DictData.USER_TYPE_SPEC;

			// 2总部人员
		} else if (DictData.USER_TYPE_NAME_HEADER.equals(userTypeName)) {
			return DictData.USER_TYPE_HEADER;

			// 3省公司人员
		} else if (DictData.USER_TYPE_NAME_PROVINCE.equals(userTypeName)) {
			return DictData.USER_TYPE_PROVINCE;
		}

		// 默认 0 其他
		return DictData.USER_TYPE_OTHER;
	}*/

	/**
	 * 创建临时目录
	 * 
	 * @param dir 临时目录
	 * @return
	 */
	public static String createTempDir(String dir) {

		// 设定文件保存的目录
		String path = ImportUtils.class.getClassLoader().getResource("").getPath() + dir + File.separator;
		File uploadFiles = new File(path);
		if (!uploadFiles.exists()) {
			uploadFiles.mkdirs();
		}
		return path;
	}

	/**
	 * 保存图片
	 * 
	 * @param filePath 存储路径
	 * @param data     图片数据
	 * @throws Exception
	 */
	public static void saveImage(String filePath, byte[] data) throws Exception {
		// 图片保存路径
		FileOutputStream out = new FileOutputStream(filePath);
		out.write(data);
		out.close();
	}

	/**
	 * 上传文件到服务器
	 * 
	 * @param uploadFile     上传的文件
	 * @param uploadFilePath 文件存储路径
	 * @param uploadFileId   附件表主键ID
	 * @param uploadUserId   上传用户ID
	 * @param upLoadType     上传类型
	 * @return
	 * @throws Exception
	 */
	/*@Transactional
	public static boolean uploadFileToServer(File uploadFile, String uploadFilePath, String uploadFileId,
			String uploadUserId, String upLoadType) throws Exception {

		// 上传文件
		FileUploadEntity fileUploadEntity = FileUtil.upfileFileSever(uploadFile, uploadFilePath, uploadFileId,
				uploadUserId, upLoadType);

		// 附件表新增记录数
		int uploadFiles = 0;
		// 附件扩展表新增记录数
		int uploadFilesExtend = 0;

		// 记录至附件表
		uploadFiles = commFileDealService.addUploadFiles(fileUploadEntity);

		// 如果附件表上传成功
		if (uploadFiles > 0) {

			// 记录至附件扩展表
			uploadFilesExtend = commFileDealService.addUploadFilesExtend(fileUploadEntity);
		}

		// 如果附件扩展表上传成功
		if (uploadFilesExtend > 0) {
			return true;
		}

		// 文件上传失败
		return false;
	}*/
}
