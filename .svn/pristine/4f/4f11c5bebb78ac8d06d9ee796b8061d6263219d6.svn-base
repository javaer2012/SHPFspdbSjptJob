package com.ideal.spdb.thirdinfo.work.approvalwork;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.ideal.spdb.bairong.to.BairongRecord;
import com.ideal.spdb.thirdinfo.dao.IApprovalDao;
import com.ideal.spdb.thirdinfo.dao.IEucVehicleExcelDao;
import com.ideal.spdb.thirdinfo.model.ThirdinfoModel;
import com.ideal.spdb.thirdinfo.service.IApprovalService;
import com.ideal.spdb.thirdinfo.work.util.RequestIp;

public class ApprovalBairongWork {
	private static final Logger log = Logger.getLogger(ApprovalBairongWork.class);
	@Inject
	private IEucVehicleExcelDao vehicleDao;
	@Inject
	private IApprovalDao approvalDao;
	@Inject
	private IApprovalService approvalService;
	public void everydayUploadApproval() {
		log.info("=========ApprovalBairongWork.everydayUploadApproval()开始执行=============");
		long start = System.currentTimeMillis();
		try {
			String localhostIp = RequestIp.getLocalhostIp();
			String serverIp = this.vehicleDao.getConfigIP("SERVER_IP");
			log.info("localhostIp = " + localhostIp);
			log.info("serverIp = " + serverIp);
			if (localhostIp.equals(serverIp)) {
				List<ThirdinfoModel> initList = null;
				initList = approvalDao.getNeedExportInfo("approval.getNeedBrList");
				if(initList == null || initList.size() == 0){
					log.info("没有需要上传的信息，不生成文件");
					return;
				}
				List<ThirdinfoModel> list = parseList(initList);
				boolean flag = approvalService.upload(list);
				if(flag){
					log.info("文件生成成功..开始修改上传状态");
					for(ThirdinfoModel thirdinfoModel:list){
						approvalDao.updateApprovalFlag(thirdinfoModel, "approval.updataBrFlag");
					}
				}else{
					log.info("文件生成失败..不修改上传状态");
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
		long end = System.currentTimeMillis();
		log.info("ApprovalBairongWork.everydayUploadApproval()执行完成..用时：" + (end - start) + "m");
	}
	
	private List<ThirdinfoModel> parseList(List<ThirdinfoModel> list) {
		List<ThirdinfoModel> newList = new ArrayList<ThirdinfoModel>();
		for(ThirdinfoModel tm:list){
			BairongRecord brmodel = JSONObject.parseObject(tm.getRemark(), BairongRecord.class);
			StringBuffer sb = new StringBuffer();
			sb.append("百融通用信用评分-");
			sb.append( brmodel.getScore()==null?"":(brmodel.getScore().getBankpfpoint() ==null ?"":brmodel.getScore().getBankpfpoint()));
			sb.append(";通过身份证查询小贷/P2P网贷失联用户-");
			sb.append( brmodel.getSpecialList_c()==null?"":(brmodel.getSpecialList_c().getId()==null?"":brmodel.getSpecialList_c().getId().getP2p_bad() + brmodel.getSpecialList_c().getId().getP2p_fraud() + brmodel.getSpecialList_c().getId().getP2p_lost() + brmodel.getSpecialList_c().getId().getP2p_overdue() + brmodel.getSpecialList_c().getId().getP2p_refuse()));
			sb.append(";通过手机号查询小贷/P2P网贷失联用户-");
			sb.append( brmodel.getSpecialList_c()==null?"":(brmodel.getSpecialList_c().getCell()==null?"":brmodel.getSpecialList_c().getCell().getP2p_bad() + brmodel.getSpecialList_c().getCell().getP2p_fraud() + brmodel.getSpecialList_c().getCell().getP2p_lost() + brmodel.getSpecialList_c().getCell().getP2p_overdue() + brmodel.getSpecialList_c().getCell().getP2p_refuse()));
			sb.append(";通过GID查询小贷/P2P网贷失联用户-");
			sb.append( brmodel.getSpecialList_c()==null?"":(brmodel.getSpecialList_c().getGid()==null?"":brmodel.getSpecialList_c().getGid().getP2p_bad() + brmodel.getSpecialList_c().getGid().getP2p_fraud() + brmodel.getSpecialList_c().getGid().getP2p_lost() + brmodel.getSpecialList_c().getGid().getP2p_overdue() + brmodel.getSpecialList_c().getGid().getP2p_refuse()));
			sb.append(";通过身份证查询近3个月申请过的非银行机构数-");
			sb.append( brmodel.getApplyLoan()==null?"":( brmodel.getApplyLoan().getMonth3()==null?"":( brmodel.getApplyLoan().getMonth3().getId()==null?"":(brmodel.getApplyLoan().getMonth3().getId().getNotbank()==null?"":(brmodel.getApplyLoan().getMonth3().getId().getNotbank().getOrgnumber()==null?"":brmodel.getApplyLoan().getMonth3().getId().getNotbank().getOrgnumber())))));
			sb.append(";通过手机号查询近3个月申请过的非银行机构数-");
			sb.append( brmodel.getApplyLoan()==null?"":( brmodel.getApplyLoan().getMonth3()==null?"":( brmodel.getApplyLoan().getMonth3().getCell()==null?"":(brmodel.getApplyLoan().getMonth3().getCell().getNotbank()==null?"":(brmodel.getApplyLoan().getMonth3().getCell().getNotbank().getOrgnumber()==null?"":brmodel.getApplyLoan().getMonth3().getCell().getNotbank().getOrgnumber())))));
			sb.append(";通过GID查询近3个月申请过的非银行机构数-");
			sb.append( brmodel.getApplyLoan()==null?"":( brmodel.getApplyLoan().getMonth3()==null?"":( brmodel.getApplyLoan().getMonth3().getGid()==null?"":(brmodel.getApplyLoan().getMonth3().getGid().getNotbank()==null?"":(brmodel.getApplyLoan().getMonth3().getGid().getNotbank().getOrgnumber()==null?"":brmodel.getApplyLoan().getMonth3().getGid().getNotbank().getOrgnumber())))));
			sb.append(";过去12个月总消费次数-");
			sb.append( brmodel.getConsumption_c()==null?"":(brmodel.getConsumption_c().getTotal()==null?"":(brmodel.getConsumption_c().getTotal().getMonth12()==null?"":(brmodel.getConsumption_c().getTotal().getMonth12().getNumber()==null?"":brmodel.getConsumption_c().getTotal().getMonth12().getNumber()))));
			sb.append(";过去12个月总消费总数-");
			sb.append( brmodel.getConsumption_c()==null?"":(brmodel.getConsumption_c().getTotal()==null?"":(brmodel.getConsumption_c().getTotal().getMonth12()==null?"":(brmodel.getConsumption_c().getTotal().getMonth12().getPay()==null?"":brmodel.getConsumption_c().getTotal().getMonth12().getPay()))));
			sb.append(";过去1-3个月信用卡收入金额-");
			sb.append( brmodel.getAccountchange()==null?"":( brmodel.getAccountchange().getM1m3()==null?"":( brmodel.getAccountchange().getM1m3().getCreditcard()==null?"":( brmodel.getAccountchange().getM1m3().getCreditcard().getIncome()==null?"": brmodel.getAccountchange().getM1m3().getCreditcard().getIncome()))));
			sb.append(";过去1-3个月储蓄卡收入金额-");
			sb.append( brmodel.getAccountchange()==null?"":( brmodel.getAccountchange().getM1m3()==null?"":( brmodel.getAccountchange().getM1m3().getDebitcard()==null?"":( brmodel.getAccountchange().getM1m3().getDebitcard().getIncome()==null?"": brmodel.getAccountchange().getM1m3().getDebitcard().getIncome()))));
			sb.append(";过去4-6个月信用卡收入金额-");
			sb.append( brmodel.getAccountchange()==null?"":( brmodel.getAccountchange().getM4m6()==null?"":( brmodel.getAccountchange().getM4m6().getCreditcard()==null?"":( brmodel.getAccountchange().getM4m6().getCreditcard().getIncome()==null?"": brmodel.getAccountchange().getM4m6().getCreditcard().getIncome()))));
			sb.append(";过去4-6个月储蓄卡收入金额-");
			sb.append( brmodel.getAccountchange()==null?"":( brmodel.getAccountchange().getM4m6()==null?"":( brmodel.getAccountchange().getM4m6().getDebitcard()==null?"":( brmodel.getAccountchange().getM4m6().getDebitcard().getIncome()==null?"": brmodel.getAccountchange().getM4m6().getDebitcard().getIncome()))));
			System.out.println(sb.toString());
			tm.setRemark(sb.toString());
			newList.add(tm);
		}
		return newList;
	}
}
