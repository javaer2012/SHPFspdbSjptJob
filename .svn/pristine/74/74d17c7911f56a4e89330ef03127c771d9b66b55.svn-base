package com.ideal.spdb.thirdinfo.work;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.ideal.spdb.datadictionary.service.ISysDatadictionarService;
import com.ideal.spdb.thirdinfo.dao.IEucVehicleExcelDao;
import com.ideal.spdb.thirdinfo.service.TencentService;
import com.ideal.spdb.thirdinfo.work.util.RequestIp;

public class TencentWork {
	 @Inject
	 private TencentService tencentService;
	 @Inject
	 private IEucVehicleExcelDao vehicleDao;
	 
	private static final Logger log = Logger.getLogger(TencentWork.class);
	
	public void tencentJob()throws Exception{
		log.info("<<<<<<<<<<<===开始TencentWork执行===>>>>>>>>>>>>");
		long start = System.currentTimeMillis();
		String localhostIp = RequestIp.getLocalhostIp();
		String serverIp =vehicleDao.getConfigIP("SERVER_IP");
		log.info("localhostIp = " + localhostIp);
		log.info("serverIp = " + serverIp);
		if(localhostIp.equals(serverIp)){
			try{
				log.info("IP比较相同,执行" + localhostIp + "服务器程序");
				tencentService.creditExcel(); //处理excel文件
				tencentService.fraudExcel(); //处理excel文件
			} catch (Exception e) {
				log.error("执行当即切换,所报的错误信息-->"+e);
			}
			
		}
		long end = System.currentTimeMillis();
		log.info("TencentWork执行完成..用时：" + (end - start) + "m");
	}
	
	/**
	 * 上传腾讯征信信息至审批
	 * @throws Exception
	 */
	public void tencentUploadApprovalJob()throws Exception{
		log.info("<<<<<<<<<<<===开始TencentUploadApprovalWork执行===>>>>>>>>>>>>");
		long start = System.currentTimeMillis();
		String localhostIp = RequestIp.getLocalhostIp();
		String serverIp =vehicleDao.getConfigIP("SERVER_IP");
		log.info("localhostIp = " + localhostIp);
		log.info("serverIp = " + serverIp);
		if(localhostIp.equals(serverIp)){
			try{
				log.info("IP比较相同,执行" + localhostIp + "服务器程序");
				tencentService.uploadReportToApproval();
			} catch (Exception e) {
				log.error("执行当即切换,所报的错误信息-->"+e);
			}
		}
		long end = System.currentTimeMillis();
		log.info("TencentUploadApprovalWork执行完成..用时：" + (end - start) + "m");
	}
	
	/**
	 * 上传反欺诈信息至审批
	 * @throws Exception
	 */
	public void tencentFraudUploadApprovalJob()throws Exception{
		log.info("<<<<<<<<<<<===开始TencentFraudUploadApprovalWork执行===>>>>>>>>>>>>");
		long start = System.currentTimeMillis();
		String localhostIp = RequestIp.getLocalhostIp();
		String serverIp =vehicleDao.getConfigIP("SERVER_IP");
		log.info("localhostIp = " + localhostIp);
		log.info("serverIp = " + serverIp);
		if(localhostIp.equals(serverIp)){
			try{
				log.info("IP比较相同,执行" + localhostIp + "服务器程序");
				tencentService.uploadFraudReportToApproval();
			} catch (Exception e) {
				log.error("执行当即切换,所报的错误信息-->"+e);
			}
		}
		long end = System.currentTimeMillis();
		log.info("TencentFraudUploadApprovalWork执行完成..用时：" + (end - start) + "m");
	}
}
