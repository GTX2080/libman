package com.chen.library.util;

import java.io.InputStream;
import java.util.Properties;

/**
 * 读取properties工具类
 * 
 * @author xcwang
 *
 */
public class PropertiesUtil {

	/**
	 * 读取配置文件方法
	 * 
	 * @param properties
	 * @return
	 */
	private static Properties getProperties(String properties) {
		try {
			InputStream inStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(properties);
			Properties prop = new Properties();
			prop.load(inStream);
			return prop;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获取配置文件方法
	 * 
	 * @param properties 配置文件名称
	 * @param key        配置文件中的键
	 * @return 键对应的内容
	 */
	public static String getValue(String properties, String key) {
		Properties prop = getProperties(properties);
		return prop.getProperty(key);
	}
	 
}
