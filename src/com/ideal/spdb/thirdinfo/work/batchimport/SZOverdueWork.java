package com.ideal.spdb.thirdinfo.work.batchimport;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.ideal.spdb.thirdinfo.dao.IEucVehicleExcelDao;
import com.ideal.spdb.thirdinfo.service.ISZOverdueService;
import com.ideal.spdb.thirdinfo.work.util.RequestIp;

/**
 * 深圳逾期客户信息下载
 * @author uatyingkl
 *
 */
public class SZOverdueWork {
	 @Inject
	 IEucVehicleExcelDao dao;
	 @Inject
	 ISZOverdueService service;
	private static final Logger log = Logger.getLogger(SZOverdueWork.class);
	public void SZOverdueExcel() throws Exception{
		log.info("<<<<<<<<<<<===开始SZOverdueExcel执行===>>>>>>>>>>>>");
		long start = System.currentTimeMillis();
		String localhostIp = RequestIp.getLocalhostIp();
		String serverIp = this.dao.getConfigIP("SERVER_IP");
		log.info("localhostIp = " + localhostIp);
		log.info("serverIp = " + serverIp);
		if(localhostIp.equals(serverIp)){
			try{
				log.info("IP比较相同,执行" + localhostIp + "服务器程序");
				service.downSZOverdueList();
			} catch (Exception e) {
				log.error("执行当即切换,所报的错误信息-->"+e);
			}
			
		}
		long end = System.currentTimeMillis();
		log.info("SZOverdueExcel执行完成..用时：" + (end - start) + "m");
		
	}
}
