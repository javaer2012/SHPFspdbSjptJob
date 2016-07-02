package com.ideal.spdb.thirdinfo.work.rucang;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.ideal.spdb.thirdinfo.dao.IEucVehicleExcelDao;
import com.ideal.spdb.thirdinfo.work.util.RequestIp;

public class RucangWork {
	private static final Logger log = Logger.getLogger(RucangWork.class);
	// /** 线程池大小 **/
	// private static final int POOL_SIZE = 4;

	// @Inject
	// RucangAppWork RucangAppWork;
	// @Inject
	// RucangBjwtWork RucangBjwtWork;
	// @Inject
	// RucangCarWork RucangCarWork;
	// @Inject
	// RucangEduWork RucangEduWork;
	// @Inject
	// RucangGZmobileWork RucangGZmobileWork;
	// @Inject
	// RucangJxlblacklistWork RucangJxlblacklistWork;
	// @Inject
	// RucangJxlreportWork RucangJxlreportWork;
	// @Inject
	// RucangPublicWork RucangPublicWork;
	// @Inject
	// RucangSzWork RucangSzWork;
	// @Inject
	// RucangTencentWork RucangTencentWork;
	// @Inject
	// RucangUPblacklistWork RucangUPblacklistWork;
	// @Inject
	// RucangWhWork RucangWhWork;
	// @Inject
	// RucangYellowWork RucangYellowWork;
	// @Inject
	// RucangZmxyWork RucangZmxyWork;
	// @Inject
	// RucangIdcheckWork RucangIdcheckWork;
	// @Inject
	// RucangBairongWork RucangBairongWork;
	@Inject
	IEucVehicleExcelDao dao;

	@Inject
	RucangServer server;

	public void doservice() throws IOException {
		log.info("<<<<<<<<<<<===开始RucangWork.doservice执行===>>>>>>>>>>>>");
		long start = System.currentTimeMillis();
		String localhostIp = RequestIp.getLocalhostIp();
		String serverIp = "";
		try {
			serverIp = this.dao.getConfigIP("SERVER_IP");
		} catch (Exception e) {
			log.error("没有获取跑批IP");
		}

		log.info("localhostIp = " + localhostIp);
		log.info("serverIp = " + serverIp);

		if (localhostIp.equals(serverIp)) {
			for (RucangEnum em : RucangEnum.values()) {
				server.doserver(em.name(), em.getQuerysql(), em.getUpdatesql());
			}
		}
		long end = System.currentTimeMillis();
		log.info("RucangWork执行完成..用时：" + (end - start) + "m");
	}

}
