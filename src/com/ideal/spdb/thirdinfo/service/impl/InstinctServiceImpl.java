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
import com.ideal.spdb.thirdinfo.model.ThirdinfoModel;
import com.ideal.spdb.thirdinfo.service.IInstinctService;
import com.ideal.spdb.thirdinfo.work.util.AppConfigFile;
import com.ideal.spdb.thirdinfo.work.util.FileOperateUtil;
import com.ideal.spdb.thirdinfo.work.util.FtpUtil;
import com.ideal.spdb.thirdinfo.work.util.InfoOperateUtil;
import com.ideal.spdb.thirdinfo.work.util.MakeTxtUtil;
import com.ideal.spdb.thirdinfo.writemodel.ThirdInfoWriteModel;
import com.ideal.spdb.utils.BaseServiceImpl;
@Service
public class InstinctServiceImpl extends BaseServiceImpl<ThirdinfoModel> implements IInstinctService {
	private static Logger log = Logger.getLogger(InstinctServiceImpl.class);

	@Inject
	ISocialsecurityDao SocialsecuritDao;

	public boolean upload(List<ThirdinfoModel> list,int i) {
		boolean flag = false;
		log.info("==================开始生成Instinct相关txt文件======================");
		// 生成文件的路径+文件名
		String filePathAndName = "";
		// 生成文件的文件名
		String fileName = "";
		// 生成文件的路径
		String fileFolder = "";
		int type = InfoOperateUtil.SOCIALSECURITY;
		fileFolder = InfoOperateUtil.getInstance().getFolderName(type);
		fileName = getFileName(i);
		filePathAndName = fileFolder + File.separator + fileName;
		log.info("==========创建了文件名==============filePathAndName：" + filePathAndName);
		flag = FileOperateUtil.bluidTxtFile(filePathAndName, list);
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
//		String ftpTagertFolder = FileOperateUtil.getInstance().getFolderName(FileOperateUtil.FTP_ROOT_FOLDER)+"\\instinct\\szsb\\";
		String ftpTagertFolder = AppConfigFile.getInstance().getValue("FTP_INSTINCT") + File.separator;
		log.info("=========Instinct上传目标文件夹==============ftpTagertFolder：" + ftpTagertFolder);
		// 上传txt文件
		flag = ftpUtil.upload(filePathAndName, ftpTagertFolder + fileName);
		// 上传信号文件
		flag = ftpUtil.upload(filePathAndName + ".ok", ftpTagertFolder + fileName + ".ok");

		return flag;
	}
	private String getFileName(int i){
		StringBuffer sb = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		sb.append("thirdInfo_instinct_");
		Date d = new Date();
		sb.append(sdf.format(d));
		//获取批次号
		String xuHao = "";
		xuHao = SocialsecuritDao.getXuHao(i).get("out_system_seq");
//		xuHao = "900001";
		sb.append(xuHao);
		sb.append(".txt");
		return sb.toString().trim();
		
	}
}
