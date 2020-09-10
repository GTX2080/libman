package com.chen.library.util;
/**
 * 常量定义
 */
public class DataUtil {
	
	private static final long serialVersionUID = 1L;
	
	//测试
	public static final String DATA_TEST = "hello";

	/** 没有权限  401*/
	public static final Integer NOPERMISS = 401;
	/** 权限不足  402*/
	public static final Integer PERMISSION_LESS = 402;
	/** 会话ing 299 */
	public static final Integer LOGING = 299;
	/** 会话失效 400 */
	public static final Integer LOGINOUT = 400;
	/** 多地登录 401 */
	public static final Integer MORE_LOGINOUT = 401;
	/** 非法登录 */
	public static final Integer ERROR_REQUEST = 402;
	/** 操作成功 200*/
	public static final Integer OPERATIONSUCCESS = 200;
	/** 数据不允许此操作 506*/
	public static final Integer DATAEERROR = 506;
	/** 操作失败 500*/
	public static final Integer OPERATIONERROR = 500;
	/** 请求超时 505*/
	public static final Integer TIMEOUT = 505;
	/** 查询成功  201*/
	public static final Integer FINDSUCCESS = 201;
	/** 查询失败 501 */
	public static final Integer FINDERROR = 501;
	/** 保存成功 202 */
	public static final Integer SAVESUCCESS = 202;
	/** 保存失败 502 */
	public static final Integer SAVEERROR = 502;
	/** 修改成功 203 */
	public static final Integer UPDATESUCCESS = 203;
	/** 修改失败 503 */
	public static final Integer UPDATEERROR = 503;
	/** 删除成功 203 */
	public static final Integer REMOVESUCCESS = 203;
	/** 删除失败 503 */
	public static final Integer REMOVEERROR = 503;
	/** 用户不存在 504 */
	public static final Integer USER_NULL = 504;
	/** 用户不存在 504 */
	public static final Integer USER_HAVE = -504;
	/** 退出成功 204 */
	public static final Integer TOLOGINOUT = 204;
	/** 程序异常 510 */
	public static final Integer EXCEPTIONERROR = 510;
	/** 缺少必填项 511 */
	public static final Integer LACKVALUE = 511;
	/** 字段重复  512*/
	public static final Integer DUPLICATIONERROR = 512;
	/** 无对应数据  513*/
	public static final Integer NORETRUNDATA = 513;
	/** 默认状态  251*/
	public static final Integer DEFAULT = 251;
	/** 无任何数据 无法发布  514*/
	public static final Integer NODATAUNPUBLISH = 514;
	/** 对应数据有误 操作无法继续 515*/
	public static final Integer NODATAUBABLECONTINUE = 515;
	/** 文件或图片未同步*/
	public static final Integer ImageNotSychonized = 516;
	/** 文件或图片未同步*/
	public static final Integer FileNotSychonized = 517;
	/** 文件不存在*/
	public static final Integer FileNotFoundERROR = 518;
	/** 数据重复 519*/
	public static final Integer FINDREPEAT = 519;
	/** 数据不重复 */
	public static final Integer NOTREPEAT = 219;
	/** 字典错误*/
	public static final Integer DICTERROR = 520;
	/** 您无权修改此数据*/
	public static final Integer DONOTHAVEPERMISSION = 522;
	/** 验证失败，请刷新页面重试*/
	public static final Integer CHECKFAIL = 523;
	/** 数据导入失败*/
	public static final Integer IMPORT_DATA_ERROR = 524;
	/** 可以操作的数据*/
	public static final Integer OPERATIONALDATA = 220;


	public static final String ERROR = "数据有误,请联系管理员!";
	/** 文件或图片未同步*/
	public static final String ImageNotSychonized_ERROE = "图片未同步";
	/** 文件或图片未同步*/
	public static final String FileNotSychonized_ERROR = "文件未同步";
	/** 文件不存在*/
	public static final String FileNotFound_ERROR = "文件不存在";

	public static final String FIND_REPEAT = "数据重复";
	public static final String NOT_REPEAT = "数据不重复";
	public static final String ISACHIVESTATE_YES = "该检查单已归档";

	public static final String ERROE = "程序出错了,请联系管理员!";
	
	public static final String NO_PERMISSIONS = "权限不足";
	public static final String LOGIN_OUT = "会话失效，请重新登录！";
	public static final String MORE_LOGIN_OUT = "其他地方已登录用户，您被迫下线！";
 
	public static final String ADD_SUCCESS = "新增成功";
	public static final String ADD_FAULT = "新增失败";
	public static final String ADD_REPEAT = "新增数据重复";
	public static final String SUBMIT_YES = "该数据已提交，不能重复提交";
	
	
	public static final String DATA_REPEAT = "数据重复";
	
	
	public static final String SAVE_SUCCESS = "保存成功";
	public static final String SAVE_FAULT = "保存失败";
	
	public static final String REMOVE_SUCCESS = "删除成功";
	public static final String REMOVE_FAULT = "删除失败";
	public static final String DEL_FAULT = "含有不允许删除的数据";
	public static final String REMOVE_FAULT_NULL = "删除数据为空";
	public static final String REMOVE_FAULT_SUBMIT = "删除数据已提交";
	public static final String FAULT_NULL = "数据为空";
	
	public static final String UPDATE_SUCCESS = "更新成功";
	public static final String UPDATE_FAULT = "更新失败";
	public static final String DATA_ERROR = "数据不允许修改";
	public static final String DATA_ROLE_ERROR = "系统暂不支持ISC用户修改密码，请联系管理员修改！";
	public static final String DO_NOT_HAVE_PERMISSION = "您无权修改此数据";

	public static final String FIND_SUCCESS = "查询成功";
	public static final String FIND_FAULT = "查询失败";
	public static final String FIND_ERROR = "数据有误，请联系管理员";
	public static final String FIND_NULL = "未找到数据";
	public static final String NO_DATA_UBABLE_CONTINUE = "对应数据有误 操作无法继续";

	public static final String INPUT_ERROR = "数据填写错误";
	public static final String INPUT_REPEAT = "数据填写重复";
	public static final String INPUT_NULL = "请填写必要信息";
	
	public static final String NAME_REPEAT = "名称重复";
	public static final String SUB_REPEAT = "请勿重复提交";

	public static final String SAVE_FAC_FAULT="请正确填写信息";
	public static final String USER_REPEAT="用户已存在";
	public static final String USER_REPEAT_RELATION="关联用户已存在";

	public static final String USER_INVALID="用户不在有效期";
	public static final String USER_DISABLE="用户已禁用";
	public static final String USER_PASSWORD_WRONG="账号或密码输入错误";
	public static final String USER_PASSWORD_ERROR="登录失败，请联系管理员";
	public static final String LLLEGAL_OPERATION="非法操作！";
	public static final String PASSWORD_WRONG="账号或密码输入错误";
	public static final String PASSWORD_INPUT_WRONG="原密码输入错误";
	public static final String PASSWORD_WRONGNUM_MORE="密码输入错误次数过多，请稍后再试";

	public static final String REGISTER_SUCCESS="注册成功";
	public static final String REGISTER_FAIL="注册失败";
	public static final String LOGINOUT_SUCCESS="注销成功";
	public static final String LOGINOUT_FAIL="注销失败";
	
	public static final String OPERATION_SUCCESS="操作成功";
	public static final String OPERATION_FAULT="操作失败";
	
	public static final String PARENTNAME_NULL="功能未开通";

	public static final String DICT_ERROR="字典错误，请联系管理员";
	public static final String REPORT_ED="已经上报无法修改";
	public static final String CHECK_FAIL="验证失败，请刷新页面重试";


	public static final String IMPORT_DATA_SUCCESS="数据导入成功";
	public static final String IMPORT_DATA_FAIL="数据导入失败";
	public static final String IMPORT_NO_DATA="无数据导入";
	
	public static final String EXPORT_DATA_SUCCESS="数据导出成功";
	public static final String EXPORT_DATA_FAIL="数据导出失败";

	public static final String OPERATIONAL_DATA="可以操作的数据";
	
	public static final String PARAMETER_FAIL="参数不正确";
	
	// 有效
	public static final String ISVALID="0";
	// 无效
	public static final String ISNOVALID="1";
	//用户注册状态
	public static final String REGISTER="2";
	
	
	public static final String BEARER_AUTHENTICATION = "bearer";
	public static final String HEADER_AUTHENTICATION = "token";

}
