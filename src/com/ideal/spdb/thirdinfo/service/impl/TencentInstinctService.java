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
import com.ideal.spdb.thirdinfo.dao.ITencentInstinctDao;
import com.ideal.spdb.thirdinfo.model.ThirdinfoModel;
import com.ideal.spdb.thirdinfo.service.ITencentInstinctService;
import com.ideal.spdb.thirdinfo.work.util.FileOperateUtil;
import com.ideal.spdb.thirdinfo.work.util.FtpUtil;
import com.ideal.spdb.thirdinfo.work.util.InfoOperateUtil;
import com.ideal.spdb.thirdinfo.work.util.MakeTxtUtil;
import com.ideal.spdb.thirdinfo.writemodel.ThirdInfoWriteModel;
import com.ideal.spdb.utils.AppConfigFile;
@Service
public class TencentInstinctService implements ITencentInstinctService{
	public static final Logger log = Logger.getLogger(TencentInstinctService.class);
	@Inject
	ITencentInstinctDao dao;
	@Inject
	ISocialsecurityDao SocialsecuritDao;
	
	public boolean uploadTencentInstinct(){
		boolean flag = false;
		// 生成文件的路径+文件名
		String filePathAndName = "";
		// 生成文件的文件名
		String fileName = "";
		// 生成文件的路径
		String fileFolder = "";
		log.info("-------------------开始查询需要的腾讯信息----------------------------");
		List<ThirdinfoModel> amList = new ArrayList<ThirdinfoModel>();
		try {
			amList=dao.getNeedExportInfo();
		} catch (Exception e) {
			 flag = false;
			 log.error("uploadTencentInstinct()方法异常"+e);
		}
		if(amList == null || amList.size() == 0){
			log.info("没有需要上传的信息，不生成文件");
			return true;
		}

		//生成文件名
		log.info("==================开始生成腾讯信息txt文件======================");
		int type = InfoOperateUtil.SOCIALSECURITY;
		fileFolder = InfoOperateUtil.getInstance().getFolderName(type);
		fileName = getFileName();
		filePathAndName = fileFolder+File.separator+fileName;
		log.info("==========创建了文件名==============filePathAndName："+filePathAndName);
		flag = bluidTxtFile(filePathAndName, amList);
		if(flag){
			flag = FileOperateUtil.getInstance().bliudSignalFile(
			filePathAndName + ".ok");
		}else{
			return flag;
		}
		//上传功能
		 FtpUtil ftpUtil=new FtpUtil();
		 ftpUtil.initFtpUtil();
		 //审批上传
//		 String ftpTagertFolder = FileOperateUtil.getInstance().getFolderName(FileOperateUtil.FTP_ROOT_FOLDER)+"\\instinct\\szsb\\";
		 String ftpTagertFolder = AppConfigFile.getInstance().getValue("FTP_TENCENTINSTINCT") + File.separator;
		 log.info("=========腾讯上传目标文件夹==============ftpTagertFolder："+ftpTagertFolder);
		 //上传txt文件
		 flag = ftpUtil.upload(filePathAndName,ftpTagertFolder+fileName);
		 //上传信号文件
		 flag = ftpUtil.upload(filePathAndName+".ok",ftpTagertFolder+fileName+".ok");
		 
		 
		 log.info("=========腾讯文件上传成功，开始更改上传信息状态=============");
		 for(ThirdinfoModel ssm : amList){
			 dao.updateFlag(ssm);
		 }
		
		return flag;
	}
	
	private String getFileName(){
		StringBuffer sb = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		sb.append("thirdInfo_instinct_");
		Date d = new Date();
		sb.append(sdf.format(d));
		//获取批次号
		String xuHao = "";
		xuHao = SocialsecuritDao.getXuHao(3).get("out_system_seq");
//		xuHao = "800001";
		sb.append(xuHao);
		sb.append(".txt");
		return sb.toString().trim();
		
	}
	
	
	public boolean bluidTxtFile(String filepathAndName,List<ThirdinfoModel> amList){
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
				ThirdinfoModel sm = amList.get(i);
				ThirdInfoWriteModel writeModel= new ThirdInfoWriteModel();
				writeModel= (ThirdInfoWriteModel) MakeTxtUtil.getInstance().getTxtWriteModel(sm,writeModel);
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
	public static void main(String[] args) {
		 String ftpTagertFolder = FileOperateUtil.getInstance().getFolderName(FileOperateUtil.FTP_ROOT_FOLDER)+"\\instinct\\szsb\\";
		 System.out.println(ftpTagertFolder);
		 String a = AppConfigFile.getInstance().getValue("FTP_TENCENTINSTINCT") + File.separator;
		 System.out.println(a);
	}
}
