package com.ideal.spdb.thirdinfo.work;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.ideal.spdb.thirdinfo.dao.IEucVehicleExcelDao;
import com.ideal.spdb.thirdinfo.service.ITencentInstinctService;
import com.ideal.spdb.thirdinfo.work.util.RequestIp;

public class TencentInstinctWork {
	 @Inject
	 private IEucVehicleExcelDao vehicleDao;
	 @Inject
	 ITencentInstinctService service;
	 
	private static final Logger log = Logger.getLogger(TencentInstinctWork.class);
	
	public void tencentInstinctJob()throws Exception{
		log.info("<<<<<<<<<<<===开始TencentInstinctWork执行===>>>>>>>>>>>>");
		long start = System.currentTimeMillis();
		String localhostIp = RequestIp.getLocalhostIp();
		String serverIp =vehicleDao.getConfigIP("SERVER_IP");
		log.info("localhostIp = " + localhostIp);
		log.info("serverIp = " + serverIp);
		if(localhostIp.equals(serverIp)){
			try{
				log.info("IP比较相同,执行" + localhostIp + "服务器程序");
				service.uploadTencentInstinct();
				
			} catch (Exception e) {
				log.error("执行当即切换,所报的错误信息-->"+e);
			}
		}
		long end = System.currentTimeMillis();
		log.info("TencentWork执行完成..用时：" + (end - start) + "m");
	}
}
