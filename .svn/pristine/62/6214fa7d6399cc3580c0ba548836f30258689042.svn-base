package com.ideal.spdb.thirdinfo.work.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InfoOperateUtil  {
	public static InfoOperateUtil instance = null;
	
	public static int EDUCATIONTXT = 1;
	
	public static int SOCIALSECURITY = 2;
	
	public static int THIRDCARINFO = 3;
	
	public static int ECIFQUERY = 4;
	
	public static int PUBLICSECURITY = 5;
	
	public InfoOperateUtil() {
		
	};
	
	public synchronized static InfoOperateUtil getInstance() {
		if (instance == null) {
			return instance = new InfoOperateUtil();
		}
		return instance;

	}
	/**
	 * 创建文件名
	 * @param type 
	 * @return
	 */
	public String getBluidFileName(int type){
		StringBuffer sb = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		if(type == 1){
			sb.append("eduinfo_auto_");
		}
		if(type == 2){
			sb.append("socialinfo_auto_");
		}
		if(type == 3){
			sb.append("carinfo_auto_");
		}
		if(type == 4){
			sb.append("ecifquery_auto_");
		}
		Date d = new Date();
		sb.append(sdf.format(d));
		sb.append("000000");
		sb.append(".txt");
		return sb.toString().trim();
	}
	/**
	 * 获得文件目录
	 * @param type 
	 * @return
	 */
	public synchronized String getFolderName(int type){
		String strPath = "";
		if(type == 1){
			strPath = InfoConfigFile.getInstance().getValue("EDUCATIONTXT");
			return strPath;
		}
		if(type == 2){
			strPath = InfoConfigFile.getInstance().getValue("SOCIALSECURITY");
			return strPath;
		}
		if(type == 3){
			strPath = InfoConfigFile.getInstance().getValue("THIRDCARINFO");
			return strPath;
		}
		if(type == 4){
			strPath = InfoConfigFile.getInstance().getValue("ECIFQUERY");
			return strPath;
		}
		if(type == 5){
			strPath = InfoConfigFile.getInstance().getValue("PUBLICSECURITY");
			return strPath;
		}
		return strPath;
	}
	/**
	 * 获得文件上传目录(暂时没用)
	 * @param type
	 * @return
	 */
	public synchronized String getFtpFolderName(int type){
		String strPath = "";
		if(type == 1){
			strPath = InfoConfigFile.getInstance().getValue("EDUCATIONTXT_FTP");
			return strPath;
		}
		if(type == 2){
			strPath = InfoConfigFile.getInstance().getValue("SOCIALSECURITY_FTP");
			return strPath;
		}
		if(type == 3){
			strPath = InfoConfigFile.getInstance().getValue("THIRDCARINFO_FTP");
			return strPath;
		}
		if(type == 4){
			strPath = InfoConfigFile.getInstance().getValue("ECIFQUERY_FTP");
			return strPath;
		}
		if(type == 5){
			strPath = InfoConfigFile.getInstance().getValue("PUBLICSECURITY_FTP");
			return strPath;
		}
		return strPath;
	}
	
	
	
}
