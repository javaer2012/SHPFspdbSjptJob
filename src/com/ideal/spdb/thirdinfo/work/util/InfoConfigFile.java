package com.ideal.spdb.thirdinfo.work.util;

import java.io.InputStream;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;


public class InfoConfigFile {
	private static final Logger log = Logger.getLogger(InfoConfigFile.class);
	private static final String INFO_CONFIG_FILE = "info.properties";
	public static PropertiesConfiguration propertiesConfig = null;

	private static InputStream propIn = null;
	public static InfoConfigFile instance = null;
	public InfoConfigFile() {
		
	}
	
	public synchronized static InfoConfigFile getInstance() {
		if (instance == null) {
			init();
			return instance = new InfoConfigFile();
		}
		return instance;
	}
	
	public static void init() {
		ClassLoader cl = AppConfigFile.class.getClassLoader();
		propIn = cl.getResourceAsStream(INFO_CONFIG_FILE);
		propertiesConfig = new PropertiesConfiguration();
	}
	/**
	 * 从配置文件中获取对应的值
	 * @param strName 对应的字段名称
	 * @return
	 */
	public String getValue(String strName) {

		// 1.配置文件

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

}
