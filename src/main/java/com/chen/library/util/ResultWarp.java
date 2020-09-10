package com.chen.library.util;

import java.io.Serializable;

/**
 * json返回结果的包装类
 * 
 * @author
 *
 */

public class ResultWarp implements Serializable {
	
	private Boolean success;// 返回成功失败
	private String msg;// 返回提示消息
	private Object list;
	private int flag;// 返回结果的编码
	private long total;// 结果集总数
  
  
	/**
	 * @return the list
	 */
	public Object getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(Object list) {
		this.list = list;
	}


	/**
	 * @return the total
	 */
	public long getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(long total) {
		this.total = total;
	}

	/**
	 * @return the success
	 */
	public Boolean getSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(Boolean success) {
		this.success = success;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the flag
	 */
	public int getFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(int flag) {
		this.flag = flag;
	}

	public ResultWarp(Boolean success, String msg, int flag) {
		super();
		this.success = success;
		this.flag = flag;
		this.msg = msg;

	}

	public ResultWarp() {
		super();
	}
 
	//修改resultWarp的值的功能
	public void setResultWarp(String msg, int flag, Boolean success){
		this.setFlag(flag);
		this.setMsg(msg);
		this.setSuccess(success);
	}
	public void setResultWarp(String msg, int flag, Boolean success, Object object){
		this.setFlag(flag);
		this.setMsg(msg);
		this.setSuccess(success);
		this.setList(object);
	}
	public void setResultWarp(String msg, int flag, Boolean success, Object object, long total){
		this.setFlag(flag);
		this.setMsg(msg);
		this.setSuccess(success);
		this.setList(object);
		this.setTotal(total);
 
	}
}
