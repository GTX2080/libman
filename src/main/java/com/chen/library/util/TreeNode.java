package com.chen.library.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @Description:树工具类
 * @class: TreeNode
 * @date: 2018/3/27
 * @author: xcwang
 * @since 1.0
 */
public class TreeNode implements Serializable {
	// 序列化VersionUID
	private static final long serialVersionUID = 1L;
	private String id;//主键ID
	private String pid;//父级ID
	private String flag;//菜单\按钮类型
	private String label;//菜单\按钮名称
	private String rank;//菜单\按钮的url
	private String perms;//权限标识
	private String sort;//排序
	private String display;//按钮是否显示
    private String time;//创建时间
    private String desc;//描述
	private List<TreeNode> children;
	
	
	//字典的构造
	public TreeNode(String id, String pid, String label ) {
		this.id = id;
		this.pid = pid;
		this.label = label;
	}
		
	//登录的构造
	public TreeNode(String id, String pid, String label , String flag) {
		this.id = id;
		this.pid = pid;
		this.label = label;
		this.flag = flag;
	}
	//菜单的构造
	public TreeNode(String id, String pid, String label , String flag,String rank,String sort,String perms) {
		this.id = id;
		this.pid = pid;
		this.label = label;
		this.flag = flag;
		this.rank = rank;
		this.sort = sort;
		this.perms = perms;
	}
	//菜单的构造
	public TreeNode(String id, String pid, String label , String flag,String rank,String sort,String perms,String display) {
		this.id = id;
		this.pid = pid;
		this.label = label;
		this.flag = flag;
		this.rank = rank;
		this.sort = sort;
		this.perms = perms;
		this.display = display;
	}
	//菜单的构造
		public TreeNode(String id, String pid, String label , String flag,String rank,String sort) {
			this.id = id;
			this.pid = pid;
			this.label = label;
			this.flag = flag;
			this.rank = rank;
			this.sort = sort;
		}
	
	//菜单的构造
		public TreeNode(String id, String pid, String label , String flag,String rank) {
			this.id = id;
			this.pid = pid;
			this.label = label;
			this.flag = flag;
			this.rank = rank; 
		}
		
	public String getPerms() {
			return perms;
		}
		public void setPerms(String perms) {
			this.perms = perms;
		}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

}
