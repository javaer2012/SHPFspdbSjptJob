package com.ideal.spdb.thirdinfo.work.others;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.ideal.spdb.thirdinfo.dao.IEucVehicleExcelDao;
import com.ideal.spdb.thirdinfo.service.ITencentInstinctService;
import com.ideal.spdb.thirdinfo.service.TencentService;
import com.ideal.spdb.thirdinfo.work.TencentInstinctWork;
import com.ideal.spdb.thirdinfo.work.util.RequestIp;

public class TencentCRMWork {
	 @Inject
	 private IEucVehicleExcelDao vehicleDao;
	 @Inject
	 private TencentService tencentService;
	 
	private static final Logger log = Logger.getLogger(TencentCRMWork.class);
	
	public void tencentCRMJob()throws Exception{
		log.info("<<<<<<<<<<<===开始TencentCRMWork执行===>>>>>>>>>>>>");
		long start = System.currentTimeMillis();
		String localhostIp = RequestIp.getLocalhostIp();
		String serverIp =vehicleDao.getConfigIP("SERVER_IP");
		log.info("localhostIp = " + localhostIp);
		log.info("serverIp = " + serverIp);
		if(localhostIp.equals(serverIp)){
			try{
				log.info("IP比较相同,执行" + localhostIp + "服务器程序");
				tencentService.uploadReoprt2CRM();
			} catch (Exception e) {
				log.error("执行当即切换,所报的错误信息-->"+e);
			}
		}
		long end = System.currentTimeMillis();
		log.info("TencentCRMWork执行完成..用时：" + (end - start) + "m");
	}
}
