/**  
 *@Copyright:Copyright (c) 2011 - 2100  
 *@Company:FBI
 */
package com.ideal.spdb.utils;

import java.io.InputStream;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;

/**
 *@Author: AlexHe
 *@CrateDate:2012-8-16
 *@Version:1.1.0
 *@FunctionName:
 *@Description : 配置文件读取类
 *@Modify History: ----------------------------------
 * 
 */
public class AppConfigFile {
	private static final Logger log = Logger.getLogger(AppConfigFile.class);

	private static final String APP_CONFIG_FILE = "app.properties";
	public static PropertiesConfiguration propertiesConfig = null;

	private static InputStream propIn = null;

	public static AppConfigFile instance = null;

	public AppConfigFile() {
	}

	public synchronized static AppConfigFile getInstance() {
		if (instance == null) {
			init();
			return instance = new AppConfigFile();
		}
		return instance;

	}

	public String getValue(String strName) {

		// 1.读取ftp配置文件

		String value = "";
		try {
			if (propertiesConfig == null) {
				init();
			}
			propertiesConfig.load(propIn);
			value = propertiesConfig.getString(strName);

		} catch (ConfigurationException e) {
			log.error("getValue发生异常"+e);
		}
		return value;
	}

	public static void init() {
		ClassLoader cl = AppConfigFile.class.getClassLoader();
		propIn = cl.getResourceAsStream(APP_CONFIG_FILE);
		propertiesConfig = new PropertiesConfiguration();
	}

	/**
	 * @param args
	 * @Description:
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sfzLimit = "20120809";
		String Certificatelimit = sfzLimit.substring(0, 4) + "__年"
		+ sfzLimit.substring(5, 6) + "__月"
		+ sfzLimit.substring(7, 8) + "__日";
		System.out.print(Certificatelimit);
	}

}
