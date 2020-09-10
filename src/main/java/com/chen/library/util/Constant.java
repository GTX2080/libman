package com.chen.library.util;

public class Constant {
    /**
     * 1 = 年
     */
    public static final String YEAR = "1";
    /**
     * 2 = 季度
     */
    public static final String SEASON = "2";
    /**
     * 3 = 月
     */
    public static final String MONTH = "3";
    /**
     * 4 = 时间段
     */
    public static final String DATE = "4";

    /** 上午*/
    public static final String AM = "上午";
    /** 中午*/
    public static final String NOON = "中午";
    /** 下午*/
    public static final String PM = "下午";

    /**
     * 没有数据不能发布
     */
    public static final int NO_DATA_UNRELEASE = -514;

    /**
     * 状态
     */
    /** 成功 */
    public static final int SUCCESS = 200;
    /** 失败 */
    public static final int FAIL = -200;
    /** 已经审核过了 */
    public static final int AUDITED = -5;
    /** 没有数据不能操作 */
    public static final int NO_DATA_CAN_T_CONTINUE = -7;
    /** 可以操作 */
    public static final int OPERABLE = 201;
    /** 不能操作 */
    public static final int UNOPERATION = -506;
    /** 字典错误 */
    public static final int DICT_ERROR = -520;
    /** 数据重复*/
    public static final int DATA_REPEAT = -519;
    /** 已经上报无法修改*/
    public static final int REPORT_ED = 521;
    /** 权限不足*/
    public static final int PERMISSION_LESS = 522;
    /** 无对应数据  513*/
    public static final int NO_RETRUN_DATA = 513;
    /** 数据错误  514*/
    public static final int DATA_ERROR = 514;

    /**
     * 异常
     */
    public static final String NO_FIND = "701";

    /**
	 * 文件同步状态<br>
	 * 0：未处理
     */
    public static final String FILE_SYNCHRO_TODO= "0";

    /**
	 * 文件同步状态<br>
	 * 1：已上传
     */
    public static final String FILE_SYNCHRO_UPLOAD = "1";

    /**
	 * 文件同步状态<br>
	 * 2：已下载
     */
    public static final String FILE_SYNCHRO_DOWNLOAD = "2";

    /**
	 * 文件清理状态<br>
	 * 0：未清理
     */
    public static final String FILE_CLEAN_NO = "0";

    /**
	 * 文件清理状态<br>
	 * 1：已清理
     */
    public static final String FILE_CLEAN_YES = "1";

    /**
	 * 文件传输方向<br>
	 * 0：外网到内网
     */
    public static final String FILE_TRANSFER_OUT_TO_IN= "0";

    /**
	 * 文件传输方向<br>
	 * 1：内网到外网
     */
    public static final String FILE_TRANSFER_IN_TO_OUT= "1";

    /**
     * FTP上传文件(外网到网闸)
     */
    public static final String UPLOAD_FILE_OUT_TO_GATE = "ftp/uploadFileOutToGate";

    /**
     * FTP上传文件(内网到网闸)
     */
    public static final String UPLOAD_FILE_IN_TO_GATE = "ftp/uploadFileInToGate";

    /**
     * FTP下载文件(网闸到内网)
     */
    public static final String DOWNLOAD_FILE_GATE_TO_IN = "ftp/downloadFileGateToIn";

    /**
     * FTP下载文件(网闸到外网)
     */
    public static final String DOWNLOAD_FILE_GATE_TO_OUT = "ftp/downloadFileGateToOut";

    /**
     * FTP删除文件(内网到外网)
     */
    public static final String DELETE_FILE_IN_TO_OUT = "ftp/deleteFileInToOut";

    /**
     * FTP删除文件(外网到内网)
     */
    public static final String DELETE_FILE_OUT_TO_IN = "ftp/deleteFileOutToIn";
}
