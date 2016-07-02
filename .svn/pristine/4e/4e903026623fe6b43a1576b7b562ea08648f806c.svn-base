package com.ideal.spdb.thirdinfo.work;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.ideal.spdb.thirdinfo.dao.IEucVehicleExcelDao;
import com.ideal.spdb.thirdinfo.service.IEducationTxtService;
import com.ideal.spdb.thirdinfo.work.util.RequestIp;

public class EducationTxtWork {
	 @Inject
	 IEucVehicleExcelDao dao;
	 @Inject
	 IEducationTxtService service;
	private static final Logger log = Logger.getLogger(EducationTxtWork.class);
	public void everyDayUploadEducation() throws Exception{
		log.info("<<<<<<<<<<<===开始everyDayUploadEducation执行===>>>>>>>>>>>>");
		long start = System.currentTimeMillis();
		String localhostIp = RequestIp.getLocalhostIp();
		String serverIp = this.dao.getConfigIP("SERVER_IP");
		log.info("localhostIp = " + localhostIp);
		log.info("serverIp = " + serverIp);
		if(localhostIp.equals(serverIp)){
			try{
				log.info("IP比较相同,执行" + localhostIp + "服务器程序");
				service.uploadEducation();
			} catch (Exception e) {
				log.error("执行当即切换,所报的错误信息-->"+e);
			}
		}
		long end = System.currentTimeMillis();
		log.info("everyDayUploadEducation执行完成..用时：" + (end - start) + "m");
	}
}
