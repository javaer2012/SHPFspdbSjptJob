package com.ideal.spdb.thirdinfo.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.sound.midi.Sequence;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ideal.spdb.thirdinfo.dao.IEducationTxtDao;
import com.ideal.spdb.thirdinfo.model.EducationTxtModel;
import com.ideal.spdb.thirdinfo.service.IEducationTxtService;
import com.ideal.spdb.thirdinfo.work.util.AppConfigFile;
import com.ideal.spdb.thirdinfo.work.util.FileOperateUtil;
import com.ideal.spdb.thirdinfo.work.util.FtpUtil;
import com.ideal.spdb.thirdinfo.work.util.InfoOperateUtil;
import com.ideal.spdb.thirdinfo.work.util.MakeTxtUtil;
import com.ideal.spdb.thirdinfo.writemodel.EducationTxtWriteModel;

@Service
public class EducationTxtServiceImpl  implements IEducationTxtService{
	@Inject
	IEducationTxtDao EducationTxtdao;
	public static final Logger log = Logger.getLogger(IEducationTxtService.class);
	public boolean uploadEducation() {
		boolean flag = false;
		// 生成文件的路径+文件名
		String filePathAndName = "";
		// 生成文件的文件名
		String fileName = "";
		// 生成文件的路径
		String fileFolder = "";
		log.info("-------------------开始查询需要的学历----------------------------");
		List<EducationTxtModel> amList = new ArrayList<EducationTxtModel>();
		try {
			amList=EducationTxtdao.getNeedExportEducation();
		} catch (Exception e) {
			 flag = false;
			 log.error("uploadEducation()方法异常"+e);
		}
		//如果当天没有相关文件就直接返回
	
		//生成文件名
		log.info("==================开始生成学历txt文件======================");
		int type = InfoOperateUtil.EDUCATIONTXT;
		fileName = getFileName();
		fileFolder = InfoOperateUtil.getInstance().getFolderName(type);
		filePathAndName = fileFolder+File.separator+fileName;
		


		log.info("===============创建了文件名===========filePathAndName："+filePathAndName);
		//生成txt文件 
		flag = bluidTxtFile(filePathAndName, amList);
		log.info("--------------------学历信息文件生成成功 --------------------");
		
		//生成ok文件
		if(flag){
			flag = FileOperateUtil.getInstance().bliudSignalFile(
					filePathAndName + ".ok");
		}else{
			return flag;
		}
		
		
		 //4.上传文件

		
		 FtpUtil ftpUtil=new FtpUtil();
		 ftpUtil.initFtpUtil();
		 String ftpTagertFolder = AppConfigFile.getInstance().getValue("FTP_EDUTXT") + File.separator;
		 log.info("------------学历信息文件上传目标文件夹生成-----ftpTagertFolder："+ftpTagertFolder);
		 //上传txt文件
		 flag = ftpUtil.upload(filePathAndName,ftpTagertFolder+fileName);
		 //上传信号文件
		 flag = ftpUtil.upload(filePathAndName+".ok",ftpTagertFolder+fileName+".ok");
		 log.info("------------学历信息文件上传成功，开始更改上传信息状态-------");
		 //将信息上传状态改为1
		 for(EducationTxtModel etm : amList){
			 EducationTxtdao.updateFlag(etm);
		 }
		
		 
		
		
		return flag;
	}
	
	public boolean bluidTxtFile(String filepathAndName,List<EducationTxtModel> amList){
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
				EducationTxtModel etm = amList.get(i);
				EducationTxtWriteModel writeModel = new EducationTxtWriteModel();
				writeModel= (EducationTxtWriteModel) MakeTxtUtil.getInstance().getTxtWriteModel(etm,writeModel);
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
	private String getFileName(){
		StringBuffer sb = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		sb.append("eduinfo_auto_");
		Date d = new Date();
		sb.append(sdf.format(d));
		//获取批次号
		String xuHao = "";
		xuHao = EducationTxtdao.getXuHao(1).get("out_system_seq");
		sb.append(xuHao);
		sb.append(".txt");
		return sb.toString().trim();
		
	}
}
