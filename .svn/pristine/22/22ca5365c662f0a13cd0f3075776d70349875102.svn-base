package com.ideal.spdb.thirdinfo.work;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.ideal.spdb.thirdinfo.dao.IApprovalIdcheckDao;
import com.ideal.spdb.thirdinfo.dao.IEucVehicleExcelDao;
import com.ideal.spdb.thirdinfo.model.ApprovalIdcheckModel;
import com.ideal.spdb.thirdinfo.model.ThirdinfoModel;
import com.ideal.spdb.thirdinfo.service.IApprovalIdcheckService;
import com.ideal.spdb.thirdinfo.work.util.RequestIp;
import com.ideal.spdb.thirdinfo.writemodel.ApprovalIdcheckWriteModel;

public class ApprovalIdcheckWork {
	private static final Logger log = Logger.getLogger(ApprovalIdcheckWork.class);
	@Inject
	private IEucVehicleExcelDao dao;
	@Inject
	private IApprovalIdcheckService service;
	@Inject
	private IApprovalIdcheckDao approvalIdcheckDao;
	
	public void everydayupload() throws Exception{
		log.info("=========ApprovalIdcheckWork.everydayupload()开始执行=============");
		long start = System.currentTimeMillis();
		String localhostIp = RequestIp.getLocalhostIp();
		String serverIp = this.dao.getConfigIP("SERVER_IP");
		if(localhostIp.equals(serverIp)){
			List<ApprovalIdcheckModel> list = null;
			list = approvalIdcheckDao.getNeedExportInfo("approval.getNeedIdcheckList");
			if(list == null || list.size() == 0){
				log.info("没有需要上传的信息，不生成文件");
				return;
			}
			boolean flag = service.doservice(list);
			if(flag){
				log.info("文件生成成功..开始修改上传状态");
				for(ApprovalIdcheckModel ApprovalIdcheckModel:list){
					approvalIdcheckDao.updateInstinctFlag(ApprovalIdcheckModel, "approval.updataIdcheckFlag");
				}
			}else{
				log.info("文件生成失败..不修改上传状态");
			}
		}
		long end = System.currentTimeMillis();
		log.info("ApprovalIdcheckWork.everydayupload()执行完成..用时：" + (end - start) + "m");
	}
	
	
}
