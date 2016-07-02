package com.ideal.spdb.utils;

import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

/**
 * 生成系统流水号
 * @author zhiqiao.he
 *
 */
public class SystemSeqUtil {
	
	private static Logger log = Logger.getLogger(SystemSeqUtil.class);
	static int tradeNumver = 0; 

	public synchronized static String createSystemSeq() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss"); 
			String tradeTime = sdf.format(new java.util.Date());
 
			tradeNumver ++;
			if (tradeNumver > 999999) {
				tradeNumver = 1;
			}
			String tradeNum_str = String.valueOf(tradeNumver);
			int tradeNum_str_length = tradeNum_str.length();
			for (int i = 0; i < 6 - tradeNum_str_length; i++) {
				tradeNum_str = "0" + tradeNum_str;
			}
			return tradeTime + tradeNum_str;
		} catch (Exception e) {
			log.error("生成系统流水号异常", e);
		} 
		return "";
	}
	
}
