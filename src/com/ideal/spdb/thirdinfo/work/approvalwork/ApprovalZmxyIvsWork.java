package com.ideal.spdb.thirdinfo.work.approvalwork;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.ideal.spdb.thirdinfo.dao.IApprovalDao;
import com.ideal.spdb.thirdinfo.dao.IEucVehicleExcelDao;
import com.ideal.spdb.thirdinfo.model.ApprovalZmxyIvsModel;
import com.ideal.spdb.thirdinfo.service.IApprovalService;
import com.ideal.spdb.thirdinfo.work.util.RequestIp;

public class ApprovalZmxyIvsWork {
	private static final Logger log = Logger.getLogger(ApprovalZmxyIvsWork.class);
	@Inject
	private IEucVehicleExcelDao vehicleDao;
	@Inject
	private IApprovalDao approvalDao;
	@Inject
	private IApprovalService approvalService;

	public void everydayUploadApproval() {
		log.info("=========ApprovalZmxyIvsWork.everydayUploadApproval()开始执行=============");
		long start = System.currentTimeMillis();
		try {
			String localhostIp = RequestIp.getLocalhostIp();
			String serverIp = this.vehicleDao.getConfigIP("SERVER_IP");
			log.info("localhostIp = " + localhostIp);
			log.info("serverIp = " + serverIp);
			if (localhostIp.equals(serverIp)||true) {
				List<ApprovalZmxyIvsModel> list = null;
				list = approvalDao.getNeedZmxyIvsAppInfo("approval.getNeedZmxyIvsAppList");
				if(list == null || list.size() == 0){
					log.info("没有需要上传的信息，不生成文件");
					return;
				}
				boolean flag = approvalService.uploadZmxyIvs(list);
				if(flag){
					log.info("文件生成成功..开始修改上传状态");
					for(ApprovalZmxyIvsModel model:list){
						approvalDao.updateZmxyIvsAppFlag(model, "approval.updataZmxyIvsAppFlag");
					}
				}else{
					log.info("文件生成失败..不修改上传状态");
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
		long end = System.currentTimeMillis();
		log.info("ApprovalZmxyIvsWork.everydayUploadApproval()执行完成..用时：" + (end - start) + "m");
	}
}
