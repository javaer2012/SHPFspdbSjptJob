package com.ideal.spdb.thirdinfo.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ideal.spdb.thirdinfo.dao.ISocialsecurityDao;
import com.ideal.spdb.thirdinfo.model.SocialsecurityModel;
import com.ideal.spdb.thirdinfo.service.ISocialsecurityService;
import com.ideal.spdb.thirdinfo.work.util.AppConfigFile;
import com.ideal.spdb.thirdinfo.work.util.FileOperateUtil;
import com.ideal.spdb.thirdinfo.work.util.FtpUtil;
import com.ideal.spdb.thirdinfo.work.util.InfoOperateUtil;
import com.ideal.spdb.thirdinfo.work.util.MakeTxtUtil;
import com.ideal.spdb.thirdinfo.writemodel.SocialsecurityWriteModel;


@Service()
public class SocialsecurityServiceImpl implements ISocialsecurityService{
	@Inject
	ISocialsecurityDao SocialsecuritDao;
//	@Inject
//	IEducationTxtDao EducationTxtdao;
	public static final Logger log = Logger.getLogger(SocialsecurityServiceImpl.class);
	public boolean uploadSocialsecurity() {
		boolean flag = false;
		
		// 生成文件的路径+文件名
		String filePathAndName = "";
		// 生成文件的文件名
		String fileName = "";
		// 生成文件的路径
		String fileFolder = "";
		log.info("-------------------开始查询需要的社保信息----------------------------");
		
		List<SocialsecurityModel> amList = new ArrayList<SocialsecurityModel>();
		
		try {
			amList=SocialsecuritDao.getNeedExportSocialsecurity();
		} catch (Exception e) {
			 flag = false;
			 log.error("getNeedExportSocialsecurity()方法异常"+e);
		}
		if(amList == null || amList.size() == 0){
			log.info("没有需要上传的信息，不生成文件");
			return true;
		}

			
		//生成文件名
		log.info("==================开始生成社保信息txt文件======================");
		int type = InfoOperateUtil.SOCIALSECURITY;
//		fileName = InfoOperateUtil.getInstance().getBluidFileName(type);
		fileName = getFileName();
		fileFolder = InfoOperateUtil.getInstance().getFolderName(type);
		filePathAndName = fileFolder+"/"+fileName;
		

		log.info("==========创建了文件名==============filePathAndName："+filePathAndName);
		//生成txt文件 
		
		flag = bluidTxtFile(filePathAndName, amList);
		
		//生成ok文件
		if(flag){
			flag = FileOperateUtil.getInstance().bliudSignalFile(
			filePathAndName + ".ok");
		}else{
			return flag;
		}
		
		
		//上传功能
		 FtpUtil ftpUtil=new FtpUtil();
		 ftpUtil.initFtpUtil();
//		 String ftpTagertFolder = FileOperateUtil.getInstance().getFolderName(FileOperateUtil.FTP_ROOT_FOLDER)+"\\WZXS\\SHEBAO\\";
		 String ftpTagertFolder =  AppConfigFile.getInstance().getValue("FTP_SHEBAO") + File.separator;
		 log.info("=========社保上传目标文件夹==============ftpTagertFolder："+ftpTagertFolder);
		 //上传txt文件
		 flag = ftpUtil.upload(filePathAndName,ftpTagertFolder+fileName);
		 //上传信号文件
		 flag = ftpUtil.upload(filePathAndName+".ok",ftpTagertFolder+fileName+".ok");
		 log.info("=========社保文件上传成功，开始更改上传信息状态=============");
		 for(SocialsecurityModel ssm : amList){
			 SocialsecuritDao.updateFlag(ssm);
		 }
		
		return flag;
	}
	
	
	public boolean bluidTxtFile(String filepathAndName,List<SocialsecurityModel> amList){
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
				SocialsecurityModel sm = amList.get(i);
				SocialsecurityWriteModel writeModel= new SocialsecurityWriteModel();
				writeModel= (SocialsecurityWriteModel) MakeTxtUtil.getInstance().getTxtWriteModel(sm,writeModel);
				String writeString = "";
				log.info("--------------创建写入字符串----------------");
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
	private String getFileName(){
		StringBuffer sb = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		sb.append("socialinfo_auto_");
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
}
