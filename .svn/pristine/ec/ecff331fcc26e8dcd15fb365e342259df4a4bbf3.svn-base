package com.ideal.spdb.thirdinfo.work.approvalwork;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.ideal.spdb.thirdinfo.dao.IApprovalDao;
import com.ideal.spdb.thirdinfo.dao.IEucVehicleExcelDao;
import com.ideal.spdb.thirdinfo.model.ThirdinfoModel;
import com.ideal.spdb.thirdinfo.service.IApprovalService;
import com.ideal.spdb.thirdinfo.work.util.RequestIp;

public class ApprovalTencentWork {
	private static final Logger log = Logger.getLogger(ApprovalTencentWork.class);
	@Inject
	private IEucVehicleExcelDao vehicleDao;
	@Inject
	private IApprovalDao approvalDao;
	@Inject
	private IApprovalService approvalService;

	public void everydayUploadApproval() {
		log.info("=========ApprovalTencentWork.everydayUploadApproval()开始执行=============");
		long start = System.currentTimeMillis();
		try {
			String localhostIp = RequestIp.getLocalhostIp();
			String serverIp = this.vehicleDao.getConfigIP("SERVER_IP");
			log.info("localhostIp = " + localhostIp);
			log.info("serverIp = " + serverIp);
			if (localhostIp.equals(serverIp)) {
				List<ThirdinfoModel> list = null;
				list = approvalDao.getNeedExportInfo("approval.getNeedTencentList");
				if(list == null || list.size() == 0){
					log.info("没有需要上传的信息，不生成文件");
					return;
				}
				boolean flag = approvalService.upload(list);
				if(flag){
					log.info("文件生成成功..开始修改上传状态");
					for(ThirdinfoModel thirdinfoModel:list){
						approvalDao.updateApprovalFlag(thirdinfoModel, "approval.updataTencentFlag");
					}
				}else{
					log.info("文件生成失败..不修改上传状态");
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
		long end = System.currentTimeMillis();
		log.info("PublicSecurityWork.everydayUploadApproval()执行完成..用时：" + (end - start) + "m");
	}

}
