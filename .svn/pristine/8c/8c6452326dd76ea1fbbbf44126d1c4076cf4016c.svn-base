package com.ideal.spdb.thirdinfo.work.batchimport;

import javax.inject.Inject;

import org.apache.log4j.Logger;


import com.ideal.spdb.datadictionary.service.ISysDatadictionarService;
import com.ideal.spdb.thirdinfo.dao.IEucVehicleExcelDao;
import com.ideal.spdb.thirdinfo.service.IEucVehicleExcelService;
import com.ideal.spdb.thirdinfo.work.util.RequestIp;

/**
 * 处理eucExcel文件定时任务类    
 * @author uatmy06136
 *
 */
public class EucVehicleExcelWork {
	 @Inject
	 IEucVehicleExcelService service;
	 @Inject
	 ISysDatadictionarService sysDatadictionarService;
	 @Inject
	 IEucVehicleExcelDao dao;
	private static final Logger log = Logger.getLogger(EucVehicleExcelWork.class);
	public void EucHandleExcel()throws Exception{
		log.info("<<<<<<<<<<<===开始EucVehicleExcelWork执行===>>>>>>>>>>>>");
		long start = System.currentTimeMillis();
		String localhostIp = RequestIp.getLocalhostIp();
		String serverIp = this.dao.getConfigIP("SERVER_IP");
		log.info("localhostIp = " + localhostIp );
		log.info("serverIp = " + serverIp);
		if(localhostIp.equals(serverIp)){
			try{
				log.info("IP比较相同,执行" + localhostIp + "服务器程序");
				this.service.handleEucExcel(); //处理excel文件
			} catch (Exception e) {
				log.error("执行当即切换,所报的错误信息-->"+e);
			}
			
		}
		long end = System.currentTimeMillis();
		log.info("EucVehicleExcelWork执行完成..用时：" + (end - start) + "m");
	}
}
