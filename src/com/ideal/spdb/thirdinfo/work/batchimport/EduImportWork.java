package com.ideal.spdb.thirdinfo.work.batchimport;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.ideal.spdb.datadictionary.service.ISysDatadictionarService;
import com.ideal.spdb.thirdinfo.dao.IEucVehicleExcelDao;
import com.ideal.spdb.thirdinfo.service.IEduImportService;
import com.ideal.spdb.thirdinfo.service.IEucVehicleExcelService;
import com.ideal.spdb.thirdinfo.work.util.RequestIp;

/**
 * 学历批量导入
 * @author uatyingkl
 *
 */
public class EduImportWork {
	 @Inject
	 IEucVehicleExcelDao dao;
	 @Inject
	 IEduImportService service;
	private static final Logger log = Logger.getLogger(EduImportWork.class);
	public void eduImportInfo()throws Exception{
		log.info("<<<<<<<<<<<===开始EduImportWork执行===>>>>>>>>>>>>");
		long start = System.currentTimeMillis();
		String localhostIp = RequestIp.getLocalhostIp();
		String serverIp = this.dao.getConfigIP("SERVER_IP");
		log.info("localhostIp = " + localhostIp);
		log.info("serverIp = " + serverIp);
		if(localhostIp.equals(serverIp)){
			try{
				log.info("IP比较相同,执行" + localhostIp + "服务器程序");
				this.service.importEduInfo();
			} catch (Exception e) {
				log.error("执行当即切换,所报的错误信息-->"+e);
			}
			
		}
		long end = System.currentTimeMillis();
		log.info("EduImportWork执行完成..用时：" + (end - start) + "m");
	}
}
