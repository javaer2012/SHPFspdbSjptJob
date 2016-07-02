/**  
 *@Copyright:Copyright (c) 2011 - 2100  
 *@Company:FBI
 */
package com.ideal.spdb.thirdinfo.work.util;

import java.util.List;
import org.apache.log4j.Logger;

/**
 *@Author: AlexHe
 *@CrateDate:2012-8-11
 *@Version:1.1.0
 *@FunctionName:
 *@Description :
 *@Modify History: ----------------------------------
 * 
 */
public class FtpService {
	private static final Logger log = Logger.getLogger(FtpService.class);

	public static FtpService initFtpService = null;
	private FtpService() {
	}

	public synchronized static FtpService getFtpService() {
		if(initFtpService == null){
			return initFtpService = new FtpService();
		}
		return initFtpService;
	}


	/**
	 * @param args
	 * @Description:
	 */
	public static void main(String[] args) {
		
		FtpUtil s = new FtpUtil();
		s.initFtpUtil();
		boolean result = s.upload("D://TEST//1.doc", "x1.doc");
		System.out.println(result ? "上传成功！" : "上传失败！");		
		System.out.println(s);		
		List list = s.getFileList("\\");
		for (int i = 0; i < list.size(); i++) {
			String name = list.get(i).toString();
			System.out.println(name);
		}		
		FtpUtil x =s;
		System.out.println(x);
		List list1 = s.getFileList("\\");
		for (int i = 0; i < list1.size(); i++) {
			String name = list1.get(i).toString();
			System.out.println(name);
		}
		x.closeServer();
		s.closeServer();
		
		System.out.println(s);
	}

}
