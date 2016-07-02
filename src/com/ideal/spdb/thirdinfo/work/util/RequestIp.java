package com.ideal.spdb.thirdinfo.work.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

/**    
 * @author wls  
 * @date 2012-9-23
 * @version V1.0   
 */
public class RequestIp {

	private static final Logger log = Logger.getLogger(RequestIp.class);
	
	public synchronized static String getLocalhostIp(){
		String ip = "";
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
			log.info("本机IP = " + ip);
		} catch (UnknownHostException e) {
			log.error("getLocalhostIp方法异常"+e);
		}
		return ip;
	}
}
