package com.ideal.spdb.thirdinfo.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ideal.spdb.thirdinfo.dao.ISocialsecurityDao;
import com.ideal.spdb.thirdinfo.model.ThirdinfoModel;
import com.ideal.spdb.thirdinfo.model.ZfbzxModel;
import com.ideal.spdb.thirdinfo.service.IZfbzxService;
import com.ideal.spdb.thirdinfo.work.util.AppConfigFile;
import com.ideal.spdb.thirdinfo.work.util.FileOperateUtil;
import com.ideal.spdb.thirdinfo.work.util.FtpUtil;
import com.ideal.spdb.thirdinfo.work.util.InfoOperateUtil;
import com.ideal.spdb.utils.BaseServiceImpl;
@Service
public class ZfbzxServiceImpl extends BaseServiceImpl<ZfbzxModel> implements IZfbzxService{
	private static  Logger log = Logger.getLogger(ZfbzxServiceImpl.class);
	@Inject
	ISocialsecurityDao SocialsecuritDao;
	@Override
	public boolean doservice(int ftpType,String type,String txt) {
		boolean flag = false;
		log.info("==================开始生成zfb相关txt文件======================");
		// 生成文件的路径+文件名
		String filePathAndName = "";
		// 生成文件的文件名
		String fileName = "";
		// 生成文件的路径
		String fileFolder = "";
		fileFolder = AppConfigFile.getInstance().getValue("LOCAL_FOLDER_" + type);
		fileName = getFileName(type);
		filePathAndName = fileFolder + File.separator + fileName;
		log.info("==========创建了文件名==============filePathAndName：" + filePathAndName);
//		flag = FileOperateUtil.bluidTxtFile(filePathAndName, list);
		try {
			FileUtils.writeStringToFile(new File(filePathAndName), txt,"GBK");
			flag = true;
		} catch (IOException e) {
			log.error(e);
			flag = false;
		}
		// 生成ok文件
		if (flag) {
			flag = FileOperateUtil.getInstance().bliudSignalFile(filePathAndName + ".ok");
		} else {
			return flag;
		}
		// 上传功能
		FtpUtil ftpUtil = new FtpUtil();
		ftpUtil.initFtpUtil(ftpType);
		// 审批上传
		String ftpTagertFolder = AppConfigFile.getInstance().getValue("FTP_FOLDER_" + type) + File.separator;
		log.info("=========社保上传目标文件夹==============ftpTagertFolder：" + ftpTagertFolder);
		// 上传txt文件
		flag = ftpUtil.upload(filePathAndName, ftpTagertFolder + fileName);
		// 上传信号文件
		flag = ftpUtil.upload(filePathAndName + ".ok", ftpTagertFolder + fileName + ".ok");

		return flag;
	}
	

	private String getFileName(String type){
		StringBuffer sb = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		sb.append(AppConfigFile.getInstance().getValue("LOCAL_NAME_" + type));
		Date d = new Date();
//		sb.append(sdf.format(d));
		//获取批次号
		String xuHao = "";
		xuHao = SocialsecuritDao.getXuHao(type).get("out_system_seq");
//		xuHao = "900001";
		sb.append(xuHao);
		sb.append(".txt");
		return sb.toString().trim().replaceAll("YYYYMMDD", sdf.format(d));
		
	}

	
	
}
