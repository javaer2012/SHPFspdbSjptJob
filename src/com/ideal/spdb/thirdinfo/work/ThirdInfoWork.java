package com.ideal.spdb.thirdinfo.work;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.ideal.spdb.thirdinfo.dao.IEucVehicleExcelDao;
import com.ideal.spdb.thirdinfo.service.IThirdInfoService;
import com.ideal.spdb.thirdinfo.work.util.RequestIp;

public class ThirdInfoWork {
	@Inject
	IEucVehicleExcelDao dao;
	@Inject
	IThirdInfoService thirdinfoService;
	private static final Logger log = Logger.getLogger(ThirdInfoWork.class);
	
	public void everydayUploadSocialsecurity() throws Exception{
		log.info("=========SocialsecurityWork.everydayUploadSocialsecurity()开始执行=============");
		long start = System.currentTimeMillis();
		String localhostIp = RequestIp.getLocalhostIp();
		String serverIp = this.dao.getConfigIP("SERVER_IP");
		log.info("localhostIp = " + localhostIp);
		log.info("serverIp = " + serverIp);
		if(localhostIp.equals(serverIp)){
			try{
				log.info("IP比较相同,执行" + localhostIp + "服务器程序");
				thirdinfoService.uploadThirdInfo();
			} catch (Exception e) {
				log.error("执行当即切换,所报的错误信息-->"+e);
			}
			
		}
		long end = System.currentTimeMillis();
		log.info("SocialsecurityWork.everydayUploadSocialsecurity()执行完成..用时：" + (end - start) + "m");
	}
	@Test
	public void gogogo(){
		thirdinfoService.uploadThirdInfo();
	}
}