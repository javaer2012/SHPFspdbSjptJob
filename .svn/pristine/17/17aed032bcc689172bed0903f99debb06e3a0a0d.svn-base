package com.ideal.spdb.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


/**
 * 
 * <p>Title:  浦发五星项目</p>
 * <p>Description:加载loadProperties</p>
 * <p>Company: 上海理想信息产业(集团)有限公司</p>
 * @author dinghui
 * create date: 2012-2-24
 * @version 1.0
 */
public class PropertiesUtil {
	
	/**
	 * 加载配置文件
	 * 
	 * @param separator
	 *            系统路径
	 * @return 返回Properties对象
	 * @throws FileNotFoundException
	 *             抛出异常
	 * @throws IOException
	 *             抛出异常
	 */
	public  Properties loadProperties(String fileName )
			{
		//得到bin路径
		String path=null;
		Properties props=null;
		try {
			path = (getClass().getClassLoader().getResource("").toURI()).getPath();
			props = new Properties();
			//拼装路径
			StringBuilder sb = new StringBuilder();
			sb.append(path);
		    sb.append(fileName);
			props.load(new FileInputStream(sb.toString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return props;
	}
	
	public static void main(String[] args) {
			 String ip=Constants.pro.getProperty("QUEUE_MANAGE_IP");
			 String port=Constants.pro.getProperty("QUEUE_MANAGE_PORT");
			 System.out.println("ip="+ip+"port-"+port);
		
			
		
	}

}
