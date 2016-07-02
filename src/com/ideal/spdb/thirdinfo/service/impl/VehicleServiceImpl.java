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

import com.ideal.spdb.thirdinfo.dao.IVehicleDao;
import com.ideal.spdb.thirdinfo.model.Vehicle;
import com.ideal.spdb.thirdinfo.service.IVehicleService;
import com.ideal.spdb.thirdinfo.work.util.FileOperateUtil;
import com.ideal.spdb.thirdinfo.work.util.FtpUtil;
import com.ideal.spdb.thirdinfo.work.util.InfoOperateUtil;
import com.ideal.spdb.thirdinfo.work.util.MakeTxtUtil;
import com.ideal.spdb.thirdinfo.writemodel.VehicleWriteModel;
import com.ideal.spdb.utils.AppConfigFile;
import com.ideal.spdb.utils.BaseServiceImpl;

@Service
public class VehicleServiceImpl extends BaseServiceImpl<Vehicle> implements IVehicleService{
	@Inject
	IVehicleDao ThirdCarInfodao;
	
	public static final Logger log = Logger.getLogger(VehicleServiceImpl.class);

	public boolean uploadCarInfo() {
		boolean flag = false;
		// 生成文件的路径+文件名
		String filePathAndName = "";
		// 生成文件的文件名
		String fileName = "";
		// 生成文件的路径
		String fileFolder = "";
		log.info("-------------------开始查询需要的车辆信息----------------------------");
		List<Vehicle> amList = new ArrayList<Vehicle>();
		try {
			amList=ThirdCarInfodao.getNeedExportCarInfo();
		} catch (Exception e) {
			 flag = false;
			 log.error("getNeedExportCarInfo()方法异常"+e);
		}
		if(amList == null || amList.size() == 0){
			log.info("没有需要上传的信息");
			return true;
		}

		//生成文件名
		log.info("==================开始生成需要的车辆txt文件======================");
		int type = InfoOperateUtil.THIRDCARINFO;
		log.info("========拿到了type=========type："+type);
//		fileName = InfoOperateUtil.getInstance().getBluidFileName(type);
		fileName = getFileName();
		
		fileFolder = InfoOperateUtil.getInstance().getFolderName(type);
		log.info("========拿到了fileFolder=========fileFolder："+fileFolder);
		filePathAndName = fileFolder+"/"+fileName;
		log.info("========创建了文件名=========filePathAndName："+filePathAndName);
		//生成txt文件 
		flag = bluidTxtFile(filePathAndName, amList);
		log.info("--------------------车辆txt文件生成成功 --------------------");
		
		//生成ok文件
		if(flag){
			flag = FileOperateUtil.getInstance().bliudSignalFile(
					filePathAndName + ".ok");
		}else{
			return flag;
		}
		//上传文件 测试注销
		
		 //4.上传文件
		 //获取信号文件
		log.info("---开始上传txt及.ok文件------------------");
		 FtpUtil ftpUtil=new FtpUtil();
		 ftpUtil.initFtpUtil();
//		 String ftpTagertFolder = FileOperateUtil.getInstance().getFolderName(FileOperateUtil.FTP_ROOT_FOLDER)+"\\WZXS\\CHELIANG\\";
		 String ftpTagertFolder = AppConfigFile.getInstance().getValue("FTP_CHELIANG") + File.separator;
		log.info("---目标路径-----------ftpTagertFolder："+ftpTagertFolder);
		 //上传txt文件
		 flag = ftpUtil.upload(filePathAndName,ftpTagertFolder+fileName);
		 //上传信号文件
		 flag = ftpUtil.upload(filePathAndName+".ok",ftpTagertFolder+fileName+".ok");
		log.info("--------------------车辆信息文件上传成功 --------------------");
		log.info("--------------------更改上传信息的状态 --------------------");
		 for(Vehicle tci : amList){
			 ThirdCarInfodao.updateFlag(tci);
		 }
		 log.info("--------------------车辆信息状态更改成功 --------------------");
		return flag;
		
				
	}
	
	
	public boolean bluidTxtFile(String filepathAndName,List<Vehicle> amList){
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
				Vehicle tci = amList.get(i);
				VehicleWriteModel writeModel = new VehicleWriteModel();
				writeModel = (VehicleWriteModel) MakeTxtUtil.getInstance().getTxtWriteModel(tci,writeModel);
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
		sb.append("carinfo_auto_");
		Date d = new Date();
		sb.append(sdf.format(d));
		//获取批次号
		String xuHao = "";
		xuHao = ThirdCarInfodao.getXuHao(1).get("out_system_seq");
		sb.append(xuHao);
		sb.append(".txt");
		return sb.toString().trim();
		
	}
}
