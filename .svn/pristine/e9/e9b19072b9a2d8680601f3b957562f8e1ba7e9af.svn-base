package com.ideal.spdb.thirdinfo.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ideal.spdb.thirdinfo.dao.IApprovalIdcheckDao;
import com.ideal.spdb.thirdinfo.dao.ISocialsecurityDao;
import com.ideal.spdb.thirdinfo.model.ApprovalIdcheckModel;
import com.ideal.spdb.thirdinfo.service.IApprovalIdcheckService;
import com.ideal.spdb.thirdinfo.work.util.AppConfigFile;
import com.ideal.spdb.thirdinfo.work.util.FileOperateUtil;
import com.ideal.spdb.thirdinfo.work.util.FtpUtil;
import com.ideal.spdb.thirdinfo.work.util.MakeTxtUtil;
import com.ideal.spdb.thirdinfo.writemodel.ApprovalIdcheckWriteModel;
import com.ideal.spdb.utils.BaseServiceImpl;
@Service
public class ApprovalIdcheckServiceImpl extends BaseServiceImpl<ApprovalIdcheckModel> implements IApprovalIdcheckService {
	private static final Logger log = Logger.getLogger(ApprovalIdcheckServiceImpl.class);
	@Inject
	private IApprovalIdcheckDao approvalIdcheckDao;
@Inject
private ISocialsecurityDao dao;
	@Override
	public boolean doservice(List<ApprovalIdcheckModel> list) {
		log.info("==================开始生成Approval相关txt文件======================");
		boolean flag = false;
		// 生成文件的路径+文件名
		String filePathAndName = "";
		// 生成文件的文件名
		String fileName = getFileName();
		// 生成文件的路径
		String fileFolder = AppConfigFile.getInstance().getValue("APPROVAL_DICHECK_FOLDER");
		filePathAndName = fileFolder + File.separator + fileName;
		flag = bluidTxtFile(filePathAndName, list);
		// 生成ok文件
		if (flag) {
			flag = FileOperateUtil.getInstance().bliudSignalFile(filePathAndName + ".ok");
		} else {
			return flag;
		}
		// 上传功能
		FtpUtil ftpUtil = new FtpUtil();
		ftpUtil.initFtpUtil();
		// 审批上传
		String ftpTagertFolder = AppConfigFile.getInstance().getValue("APPROVAL_DICHECK_FTP_FOLDER") + File.separator;
		log.info("=========社保上传目标文件夹==============ftpTagertFolder：" + ftpTagertFolder);
		// 上传txt文件
		flag = ftpUtil.upload(filePathAndName, ftpTagertFolder + fileName);
		// 上传信号文件
		flag = ftpUtil.upload(filePathAndName + ".ok", ftpTagertFolder + fileName + ".ok");
		return flag;
	}

	public static boolean bluidTxtFile(String filepathAndName, List<ApprovalIdcheckModel> amList) {
		log.info("进入了bluidTxtFile方法准备开始创建txt");
		boolean ret = false;
		if (amList == null) {
			return ret;
		}
		// 生成TXT文件
		try {
			File f = new File(filepathAndName);
			FileOutputStream fop = new FileOutputStream(f);
			OutputStreamWriter writer = new OutputStreamWriter(fop, "gbk");
			log.info("开始生成writeString并做成txt");
			for (int i = 0; i < amList.size(); i++) {
				ApprovalIdcheckModel sm = amList.get(i);
				ApprovalIdcheckWriteModel writeModel = new ApprovalIdcheckWriteModel();
				writeModel = (ApprovalIdcheckWriteModel) MakeTxtUtil.getInstance().getTxtWriteModel(sm, writeModel);
				String writeString = "";
				log.info("--------------创建写入字符串----------------");
				writeString = MakeTxtUtil.getInstance().bulidComplementASpace(writeModel);
				writer.append(writeString);
			}
			writer.close();
			fop.close();
			ret = true;

		} catch (Exception e) {
			ret = false;
			log.error("bluidTxtFile方法异常" + e);
		}
		return ret;
	}

	private String getFileName() {
		StringBuffer sb = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		sb.append("310290099996");
		Date d = new Date();
		sb.append(sdf.format(d));
		sb.append("013");
		// 获取批次号
		String xuHao = "";
		xuHao = dao.getXuHao(7).get("out_system_seq");
		// xuHao = "900001";
		sb.append(xuHao);
		sb.append(".txt");
		return sb.toString().trim();
	}
}
