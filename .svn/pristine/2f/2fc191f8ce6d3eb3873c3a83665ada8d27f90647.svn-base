package com.ideal.spdb.strategyCode.work;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.ideal.spdb.strategyCode.service.StrategyCodeService;
import com.ideal.spdb.thirdinfo.dao.IEucVehicleExcelDao;
import com.ideal.spdb.thirdinfo.work.util.RequestIp;

public class StrategyCodeWork {
	private static final Logger log = Logger.getLogger(StrategyCodeWork.class);
	
	@Inject
	private IEucVehicleExcelDao vehicleDao;
	
	@Inject
	private StrategyCodeService strategyCodeService;
	
	public void doExportStrategyCodeFileWork(){
		log.info("=========StrategyCodeWork.doExportStrategyCodeFileWork()开始执行=============");
		long start = System.currentTimeMillis();
		try {
			String localhostIp = RequestIp.getLocalhostIp();
			String serverIp = this.vehicleDao.getConfigIP("SERVER_IP");
			log.info("localhostIp = " + localhostIp);
			log.info("serverIp = " + serverIp);
			if (localhostIp.equals(serverIp)) {
				//导出文件方法
				strategyCodeService.ExportStrategyCodeFile();
			}
		} catch (Exception e) {
			log.error("doExportStrategyCodeFileWork上传文件失败");
		}
		long end = System.currentTimeMillis();
		log.info("StrategyCodeWork.doExportStrategyCodeFileWork()执行完成..用时：" + (end - start) + "m");
	}
	
}
