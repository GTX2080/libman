package com.chen.library.util;

import java.io.Serializable;

/**
 * 附件上传实体类
 * 
 * @author xcwang
 * 
 */
public class FileUploadEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	// 主键ID
	private String epriFileid;
	// 文件上传前原始名
	private String epriFileorigname;
	// 文件上传后保存名
	private String epriFileuploadname;
	// 文件类型(扩展名)
	private String epriFileexttype;
	// 文件路径
	private String epriFilepath;
	// 文件大小(byte)
	private String epriFilesize;
	// 上传用户ID
	private String epriUserid;
	// 描述
	private String epriFiledesc;
	// 文件用途
	private String epriFileuse;
	// 下载次数
	private long epriFiledowns;
	// 创建日期（上传日期）
	private String epriCreatedate;
	// 状态（0有效，1无效）
	private String epriFilestat;
	// 文件全路径
	private String epriFileAllPath;
	
	//原始文件全名
	private String epriOrigAllName;

	/**
	 * @return the epriFileAllPath
	 */
	public String getEpriFileAllPath() {
		return epriFileAllPath;
	}

	/**
	 * @param epriFileAllPath the epriFileAllPath to set
	 */
	public void setEpriFileAllPath(String epriFileAllPath) {
		this.epriFileAllPath = epriFileAllPath;
	}

	/**
	 * @return the epriFileid
	 */
	public String getEpriFileid() {
		return epriFileid;
	}

	/**
	 * @param epriFileid the epriFileid to set
	 */
	public void setEpriFileid(String epriFileid) {
		this.epriFileid = epriFileid;
	}

	/**
	 * @return the epriFileorigname
	 */
	public String getEpriFileorigname() {
		return epriFileorigname;
	}

	/**
	 * @param epriFileorigname the epriFileorigname to set
	 */
	public void setEpriFileorigname(String epriFileorigname) {
		this.epriFileorigname = epriFileorigname;
	}

	/**
	 * @return the epriFileuploadname
	 */
	public String getEpriFileuploadname() {
		return epriFileuploadname;
	}

	/**
	 * @param epriFileuploadname the epriFileuploadname to set
	 */
	public void setEpriFileuploadname(String epriFileuploadname) {
		this.epriFileuploadname = epriFileuploadname;
	}

	/**
	 * @return the epriFileexttype
	 */
	public String getEpriFileexttype() {
		return epriFileexttype;
	}

	/**
	 * @param epriFileexttype the epriFileexttype to set
	 */
	public void setEpriFileexttype(String epriFileexttype) {
		this.epriFileexttype = epriFileexttype;
	}

	/**
	 * @return the epriFilepath
	 */
	public String getEpriFilepath() {
		return epriFilepath;
	}

	/**
	 * @param epriFilepath the epriFilepath to set
	 */
	public void setEpriFilepath(String epriFilepath) {
		this.epriFilepath = epriFilepath;
	}

	/**
	 * @return the epriFilesize
	 */
	public String getEpriFilesize() {
		return epriFilesize;
	}

	/**
	 * @param epriFilesize the epriFilesize to set
	 */
	public void setEpriFilesize(String epriFilesize) {
		this.epriFilesize = epriFilesize;
	}

	/**
	 * @return the epriUserid
	 */
	public String getEpriUserid() {
		return epriUserid;
	}

	/**
	 * @param epriUserid the epriUserid to set
	 */
	public void setEpriUserid(String epriUserid) {
		this.epriUserid = epriUserid;
	}

	/**
	 * @return the epriFiledesc
	 */
	public String getEpriFiledesc() {
		return epriFiledesc;
	}

	/**
	 * @param epriFiledesc the epriFiledesc to set
	 */
	public void setEpriFiledesc(String epriFiledesc) {
		this.epriFiledesc = epriFiledesc;
	}

	/**
	 * @return the epriFileuse
	 */
	public String getEpriFileuse() {
		return epriFileuse;
	}

	/**
	 * @param epriFileuse the epriFileuse to set
	 */
	public void setEpriFileuse(String epriFileuse) {
		this.epriFileuse = epriFileuse;
	}

	/**
	 * @return the epriFiledowns
	 */
	public long getEpriFiledowns() {
		return epriFiledowns;
	}

	/**
	 * @param epriFiledowns the epriFiledowns to set
	 */
	public void setEpriFiledowns(long epriFiledowns) {
		this.epriFiledowns = epriFiledowns;
	}

	/**
	 * @return the epriCreatedate
	 */
	public String getEpriCreatedate() {
		return epriCreatedate;
	}

	/**
	 * @param epriCreatedate the epriCreatedate to set
	 */
	public void setEpriCreatedate(String epriCreatedate) {
		this.epriCreatedate = epriCreatedate;
	}

	/**
	 * @return the epriFilestat
	 */
	public String getEpriFilestat() {
		return epriFilestat;
	}

	/**
	 * @param epriFilestat the epriFilestat to set
	 */
	public void setEpriFilestat(String epriFilestat) {
		this.epriFilestat = epriFilestat;
	}

	
	
	public String getEpriOrigAllName() {
		return epriFileorigname + epriFileexttype;
	}

	public void setEpriOrigAllName(String epriOrigAllName) {
		this.epriOrigAllName = epriFileorigname + epriFileexttype;
	}

	/**
	 * 封装字条 串拼接结果
	 */

	public String toString() {
		return "FileUploadEntity contents:[epriFileid:" + epriFileid + "," + "epriFileorigname:" + epriFileorigname
				+ "," + "epriFileuploadname:" + epriFileuploadname + "," + "epriFileexttype:" + epriFileexttype + ","
				+ "epriFilepath:" + epriFilepath + "," + "epriFilesize:" + epriFilesize + "," + "epriUserid:"
				+ epriUserid + "," + "epriFiledesc:" + epriFiledesc + "," + "epriFileuse:" + epriFileuse + ","
				+ "epriFiledowns:" + epriFiledowns + "," + "epriCreatedate:" + epriCreatedate + "," + "epriFilestat:"
				+ epriFilestat + ","+"epriFileAllPath:"+epriFileAllPath+"]";

	}

}
