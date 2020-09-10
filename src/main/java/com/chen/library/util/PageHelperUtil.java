package com.chen.library.util;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
/**
 * PageHelper 分页
 * @author dev-2
 *
 */
public class PageHelperUtil {
	
	/**
	 * 获取Page
	 * @param param
	 * @return
	 */
	public static void getPageHelper(JSONObject param){
		//获取当前页面索引page
		String page = param.getString("page");
		//获取当前页面数据展示条数limit
		String limit = param.getString("limit");
		//判断分页参数是否为空
		if(!StringUtil.isEmpty(page) && !StringUtil.isEmpty(limit)){
			// PageHelper分页
			PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
		}
	}
	/**
	 * 获取Page带排序
	 * @param param
	 * @return
	 */
	public static void getPageHelperByOrder(JSONObject param){
		//获取当前页面索引page
		String page = param.getString("page");
		//获取当前页面数据展示条数limit
		String limit = param.getString("limit");
		//判断分页参数是否为空
		if(!StringUtil.isEmpty(page) && !StringUtil.isEmpty(limit)){
			//排序参数
			String orderParam = "";
			if (!StringUtil.isEmpty(param.getString("sort"))) {
				orderParam = StringUtil.toOrderBy(param.get("sort").toString());
			}
			// PageHelper分页
			PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit), orderParam);
		}
	}

}
