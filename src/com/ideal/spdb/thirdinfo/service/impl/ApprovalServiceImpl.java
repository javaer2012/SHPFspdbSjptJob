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

import com.ideal.spdb.thirdinfo.dao.ISocialsecurityDao;
import com.ideal.spdb.thirdinfo.model.ApprovalZmxyIvsModel;
import com.ideal.spdb.thirdinfo.model.ThirdinfoModel;
import com.ideal.spdb.thirdinfo.service.IApprovalService;
import com.ideal.spdb.thirdinfo.work.util.AppConfigFile;
import com.ideal.spdb.thirdinfo.work.util.FileOperateUtil;
import com.ideal.spdb.thirdinfo.work.util.FtpUtil;
import com.ideal.spdb.thirdinfo.work.util.InfoOperateUtil;
import com.ideal.spdb.thirdinfo.work.util.MakeTxtUtil;
import com.ideal.spdb.thirdinfo.writemodel.ApprovalZmxyIvsWriteModel;
import com.ideal.spdb.utils.BaseServiceImpl;
@Service
public class ApprovalServiceImpl extends BaseServiceImpl<ThirdinfoModel> implements IApprovalService{
	private static Logger log = Logger.getLogger(ApprovalServiceImpl.class);

	@Inject
	ISocialsecurityDao SocialsecuritDao;
	
	public boolean upload(List<ThirdinfoModel> list) {
		boolean flag = false;
		log.info("==================开始生成Approval相关txt文件======================");
		// 生成文件的路径+文件名
		String filePathAndName = "";
		// 生成文件的文件名
		String fileName = "";
		// 生成文件的路径
		String fileFolder = "";

		int type = InfoOperateUtil.SOCIALSECURITY;
		fileFolder = InfoOperateUtil.getInstance().getFolderName(type);
		fileName = getFileName();
		filePathAndName = fileFolder + File.separator + fileName;
		log.info("==========创建了文件名==============filePathAndName：" + filePathAndName);
		flag = FileOperateUtil.bluidTxtFile(filePathAndName, list);
		// 生成ok文件
		if (flag) {
			flag = FileOperateUtil.getInstance().bliudSignalFile(filePathAndName + ".ok");
		} else {
			return flag;
		}
		//上传功能
		 FtpUtil ftpUtil=new FtpUtil();
		 ftpUtil.initFtpUtil();
		 //审批上传
		 String ftpTagertFolder =  AppConfigFile.getInstance().getValue("FTP_APPROVAL") + File.separator;
		 log.info("=========Approval上传目标文件夹==============ftpTagertFolder："+ftpTagertFolder);
		 //上传txt文件
		 flag = ftpUtil.upload(filePathAndName,ftpTagertFolder+fileName);
		 //上传信号文件
		 flag = ftpUtil.upload(filePathAndName+".ok",ftpTagertFolder+fileName+".ok");

		return flag;
	}
	
	private String getFileName(){
		StringBuffer sb = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		sb.append("thirdInfo_auto_");
		Date d = new Date();
		sb.append(sdf.format(d));
		//获取批次号
		String xuHao = "";
		xuHao = SocialsecuritDao.getXuHao(2).get("out_system_seq");
//		xuHao = "900001";
		sb.append(xuHao);
		sb.append(".txt");
		return sb.toString().trim();
		
	}

	@Override
	public boolean uploadZmxyIvs(List<ApprovalZmxyIvsModel> list) {
		boolean flag = false;
		log.info("==================开始生成ZmxyIvs相关txt文件======================");
		// 生成文件的路径+文件名
		String filePathAndName = "";
		// 生成文件的文件名
		String fileName = "";
		// 生成文件的路径
		String fileFolder = "";
		fileFolder = AppConfigFile.getInstance().getValue("APPROVAL_ZMXYIVS_LOCAL_FOLDER");
		fileName = getZmxyFileName();
		filePathAndName = fileFolder + File.separator + fileName;
		log.info("==========创建了文件名==============filePathAndName：" + filePathAndName);
		flag = bluidTxtFile(filePathAndName, list);
		// 生成ok文件
		if (flag) {
			flag = FileOperateUtil.getInstance().bliudSignalFile(filePathAndName + ".ok");
		} else {
			log.info("==========生成ZmxyIvs文件失败==============");
			return flag;
		}
		//上传功能
		 FtpUtil ftpUtil=new FtpUtil();
		 ftpUtil.initFtpUtil();
		 //审批上传
		 String ftpTagertFolder =  AppConfigFile.getInstance().getValue("APPROVAL_ZMXYIVS_FTP_FOLDER") + File.separator;
		 log.info("=========ZmxyIvs上传目标文件夹==============ftpTagertFolder："+ftpTagertFolder);
		 //上传txt文件
		 flag = ftpUtil.upload(filePathAndName,ftpTagertFolder+fileName);
		 //上传信号文件
		 flag = ftpUtil.upload(filePathAndName+".ok",ftpTagertFolder+fileName+".ok");

		return flag;
	}
	
	private String getZmxyFileName(){
		StringBuffer sb = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		sb.append(AppConfigFile.getInstance().getValue("APPROVAL_ZMXYIVS_FILENAME"));
		Date d = new Date();
		sb.append(sdf.format(d));
		sb.append("_");
		//获取批次号
		String xuHao = "";
		xuHao = SocialsecuritDao.getXuHao("ZMXYIVS").get("out_system_seq");
		sb.append(xuHao);
		sb.append(".txt");
		return sb.toString().trim();
	}
	
	public static boolean bluidTxtFile(String filepathAndName,List<ApprovalZmxyIvsModel> amList){
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
			for(int i = 0; i < amList.size(); i++){
				ApprovalZmxyIvsModel sm = amList.get(i);
				ApprovalZmxyIvsWriteModel writeModel= new ApprovalZmxyIvsWriteModel();
				writeModel= (ApprovalZmxyIvsWriteModel) MakeTxtUtil.getInstance().getTxtWriteModel(sm,writeModel);
				String writeString = "";
				writeString =MakeTxtUtil.getInstance().bulidComplementASpace(writeModel);
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
}
