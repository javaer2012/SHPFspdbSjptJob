package com.ideal.spdb.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**    
 * 上传文件的管理
 * @author wls  
 * @date 2012-8-11
 * @version V1.0   
 */
public class UploadFileUtil {
	
	public static boolean DeleteFolder(HttpServletRequest request,String sPath) {
		boolean flag = false;  
	    File file = new File(sPath);  
	    // 判断目录或文件是否存在  
	    if (!file.exists()) {  // 不存在返回 false  
	        return flag;  
	    } else {  
	        // 判断是否为文件  
	        if (file.isFile()) {  // 为文件时调用删除文件方法  
	            return deleteFile(sPath);  
	        } 
	    }
		return flag;  
	}  
	
	private static boolean deleteFile(String sPath) {  
	    boolean flag = false;  
	    File file = new File(sPath);  
	    // 路径为文件且不为空则进行删除  
	    if (file.isFile() && file.exists()) {  
	        file.delete();  
	        flag = true;  
	    }  
	    return flag;  
	}

	public static boolean checkImgPostfix(String postfix) {
		boolean flag = false;
		String judgePostfix = AppConfigFile.getInstance().getValue("IMG_POSTFIX");
		List<String> postfixList = Arrays.asList(judgePostfix.split(","));
		for (Iterator iterator = postfixList.iterator(); iterator.hasNext();) {
			String temp = (String) iterator.next();
			if(temp.equalsIgnoreCase(postfix)){
				flag=true;
				break;
			}
		}
		return flag;  
	}  
	
	public static boolean checkImgFileSize(FileInputStream size) {
		boolean flag = true;
		int maxSize = 1024 * 1024 * Integer.parseInt(AppConfigFile.getInstance().getValue("IMG_SIZE"));
		try {
			if(maxSize < size.available()){
				flag=false;
				return false;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;  
	} 
	
	
	public static boolean checkVideoPostfix(String postfix) {
		boolean flag = true;
		String judgePostfix = AppConfigFile.getInstance().getValue("VIDEO_POSTFIX");
		List<String> postfixList = Arrays.asList(judgePostfix.split(","));
		for (Iterator iterator = postfixList.iterator(); iterator.hasNext();) {
			String temp = (String) iterator.next();
			if(temp.equalsIgnoreCase(postfix)){
				flag=true;
				break;
			}
		}
		return flag;  
	}  
	
	public static boolean checkVideoFileSize(FileInputStream size) {
		boolean flag = true;
		int maxSize = 1024 * 1024 * Integer.parseInt(AppConfigFile.getInstance().getValue("VIDEO_SIZE"));
		try {
			if(maxSize < size.available()){
				flag=false;
				return false;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;  
	} 
	
	public static boolean checkTxtFileSize(FileInputStream size) {
		boolean flag = true;
		int maxSize = 1024 * 1024 * Integer.parseInt(AppConfigFile.getInstance().getValue("TXTFILE_SIZE"));
		try {
			if(maxSize < size.available()){
				flag=false;
				return false;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;  
	}
	/**
	 * 判断上传文件的格式是不是.txt格式
	 * @param postfix
	 * @return
	 */
	public static boolean checkTxtPostfix(String postfix) {
		boolean flag = false;
		String judgePostfix = AppConfigFile.getInstance().getValue("TXT_POSTFIX");
		List<String> postfixList = Arrays.asList(judgePostfix.split(","));
		for (Iterator iterator = postfixList.iterator(); iterator.hasNext();) {
			String temp = (String) iterator.next();
			if(temp.equalsIgnoreCase(postfix)){
				flag=true;
				break;
			}
		}
		return flag;  
	}
}
