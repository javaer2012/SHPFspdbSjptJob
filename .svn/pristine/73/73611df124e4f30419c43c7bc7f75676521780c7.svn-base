package com.ideal.spdb.thirdinfo.work.rucang;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ideal.spdb.thirdinfo.dao.IRucangDao;
import com.ideal.spdb.thirdinfo.model.RucangFileModel;
import com.ideal.spdb.thirdinfo.model.RucangModel;
import com.ideal.spdb.thirdinfo.service.IRucangService;

@Service
public class RucangServer {
	private static final Logger log = Logger.getLogger(RucangServer.class);
	@Inject
	IRucangService rucangService;
	@Inject
	IRucangDao rucangDao;
//	private static final int POOL_SIZE = 4;
//	private static final ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(POOL_SIZE);
	public void doserver(String type,String querysql,String updatesql) {
		RucangFileModel rfm = rucangService.getRfModel(type);
		boolean flag = true;
		List<RucangModel> rucangList = null;
		String title = rucangService.getRucangTitle();
		rucangService.writeTxtToFile(title, rfm);
		while (flag) {
			rucangList = rucangService.getList(querysql);
			if (rucangList != null && rucangList.size() != 0) {
				String txt = "";
				txt = rucangService.modelToTxt(rucangList);
				rucangService.writeTxtToFile(txt, rfm);
				rucangService.updateRucangFlag(updatesql, rucangList);
			} else {
				flag = false;
			}
		}
		rucangService.uploadFileToFTP(rfm);
	}

}
