package com.ideal.spdb.thirdinfo.work;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.ideal.spdb.datadictionary.service.ISysDatadictionarService;
import com.ideal.spdb.thirdinfo.dao.IEucVehicleExcelDao;
import com.ideal.spdb.thirdinfo.dao.IVehicleDao;
import com.ideal.spdb.thirdinfo.service.IVehicleService;
import com.ideal.spdb.thirdinfo.work.util.RequestIp;



public class VehicleWork {
	@Inject
	ISysDatadictionarService sysDatadictionarService;
	@Inject
	IVehicleService ThirdCarInfoService;
	@Inject
	IEucVehicleExcelDao dao;
	
	private static final Logger log = Logger.getLogger(VehicleWork.class);
	
	public void everydayUploadCarInfo() throws Exception{
		log.info("=========ThirdCarInfoWork.everydayUploadCarInfo()开始执行=============");
		long start = System.currentTimeMillis();
		String localhostIp = RequestIp.getLocalhostIp();
		String serverIp = this.dao.getConfigIP("SERVER_IP");
		log.info("localhostIp = " + localhostIp);
		log.info("serverIp = " + serverIp);
		if(localhostIp.equals(serverIp)){
			try{
				log.info("IP比较相同,执行" + localhostIp + "服务器程序");
				
				ThirdCarInfoService.uploadCarInfo();
				
			} catch (Exception e) {
				log.error("执行当即切换,所报的错误信息-->"+e);
			}
		}
		long end = System.currentTimeMillis();
		log.info("ThirdCarInfoWork.everydayUploadCarInfo()执行完成..用时：" + (end - start) + "m");
	}
	
}
