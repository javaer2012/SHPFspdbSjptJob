package com.ideal.spdb.thirdinfo.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ideal.spdb.thirdinfo.dao.IRucangDao;
import com.ideal.spdb.thirdinfo.model.RucangFileModel;
import com.ideal.spdb.thirdinfo.model.RucangModel;
import com.ideal.spdb.thirdinfo.service.IRucangService;
import com.ideal.spdb.thirdinfo.work.util.AppConfigFile;
import com.ideal.spdb.thirdinfo.work.util.FileOperateUtil;
import com.ideal.spdb.thirdinfo.work.util.FtpUtil;
import com.ideal.spdb.utils.BaseServiceImpl;

@Service
public class RucangServiceImpl extends BaseServiceImpl<RucangModel> implements IRucangService {

	@Override
	public List<RucangModel> getList(String querySql) {
		return rucangDao.getNeedExportInfo(querySql);
	}

	@Override
	public String modelToTxt(List<RucangModel> rucangList) {
		StringBuffer sb = new StringBuffer();
		String line = System.getProperty("line.separator");// 换行符
//		if(txt == null || "".equals(txt)){
//			sb.append("APPL_ID|ID_TYPE|ID|NAME|DATE" + line);
//		}
			
		for (RucangModel rm : rucangList) {
			sb.append(rm.getAppId() == null ? "" : rm.getAppId());
			sb.append("|");
			sb.append(rm.getIdType() == null ? "" : rm.getIdType());
			// sb.append("01");
			sb.append("|");
			sb.append(rm.getIdno() == null ? "" : rm.getIdno());
			sb.append("|");
			sb.append(rm.getUsername() == null ? "" : rm.getUsername());
			sb.append("|");
			sb.append(rm.getResdata() == null ? "" : rm.getResdata().replace("\r", "").replace("\n", ""));
			sb.append(line);
		}
		return sb.toString();
	}

	private static final Logger log = Logger.getLogger(RucangServiceImpl.class);

	@Override
	public boolean writeTxtToFile(String txt, RucangFileModel rfm) {
		log.info("入仓服务准备开始创建txt");
		boolean ret = false;
		FileOutputStream fileOutputStream = null ;
		OutputStreamWriter outputStreamWriter =null;
		BufferedWriter bufferedWriter = null;
		if ("".equals(txt)) {
			return ret;
		}
		try {
			fileOutputStream = new FileOutputStream(rfm.getFileFolder() + File.separator + rfm.getFileName(),true); 
			outputStreamWriter = new OutputStreamWriter(fileOutputStream,"GB2312");   
			bufferedWriter = new BufferedWriter(outputStreamWriter); 
			bufferedWriter.write(txt);
			ret = true;
			bufferedWriter.close();
			outputStreamWriter.close();
			fileOutputStream.close();
		} catch (Exception e) {
			log.error(e);
		}
		
		if(ret){
			FileOperateUtil.getInstance().bliudSignalFile(rfm.getFileFolder() + File.separator + rfm.getFileName() + ".ok");
		}
		return ret;
	}

	@Override
	public void uploadFileToFTP( RucangFileModel rfm) {
//		FtpUtil ftpUtil = new FtpUtil();
//		ftpUtil.initFtpUtil(2);
//		boolean flag = false;
//		// 上传txt文件
//		flag = ftpUtil.upload(rfm.getFileFolder() + File.separator + rfm.getFileName(), 
//				rfm.getFtpTagertFolder() + File.separator + rfm.getFileName());
//		// 上传信号文件
//		flag = ftpUtil.upload(rfm.getFileFolder() + File.separator + rfm.getFileName() + ".ok", 
//				rfm.getFtpTagertFolder() + File.separator + rfm.getFileName() + ".ok");
		
		FtpUtil ftpUtil = new FtpUtil();
		ftpUtil.uploadApache(rfm.getFileFolder() + File.separator + rfm.getFileName(), 
				rfm.getFtpTagertFolder() + File.separator + rfm.getFileName(), 2);
		ftpUtil.uploadApache(rfm.getFileFolder() + File.separator + rfm.getFileName() + ".ok", 
				rfm.getFtpTagertFolder() + File.separator + rfm.getFileName() + ".ok", 2);
		File f = new File(rfm.getFileFolder() + File.separator + rfm.getFileName());
		if(f.exists()){
			try {
				FileUtils.forceDelete(f);
				FileUtils.forceDelete(new File(rfm.getFileFolder() + File.separator + rfm.getFileName() + ".ok"));
			} catch (IOException e) {
				log.error(e);
			}
		}
	}

	@Inject
	IRucangDao rucangDao;

	@Override
	public boolean everyDayRucang(String sql1, String sql2, RucangFileModel rfm) {
		log.info("=========everyDayRucang()开始执行=============");
		List<RucangModel> list = null;
		list = rucangDao.getNeedExportInfo(sql1);
		if (list == null || list.size() == 0) {
			log.info("没有需要上传的信息，不生成文件");
			return true;
		}
		boolean flag = upload(list, rfm);
		if (flag) {
			log.info("文件生成成功..开始修改上传状态");
			for (RucangModel rucangModel : list) {
				rucangDao.updateInstinctFlag(rucangModel, sql2);
			}
		} else {
			log.info("文件生成失败..不修改上传状态");
		}
		log.info("=========everyDayRucang()执行结束=============");
		return true;
	}

	@Override
	public void updateRucangFlag(String sql, List<RucangModel> rucangList) {
		for (RucangModel rucangModel : rucangList) {
			updateFlag(sql, rucangModel);
		}
	}

	public void updateFlag(String sql, RucangModel model) {
		rucangDao.updateInstinctFlag(model, sql);
	}

	private boolean upload(List<RucangModel> list, RucangFileModel rfm) {
		boolean flag = false;
		log.info("==================开始生成入仓相关txt文件======================");
		String fileName = rfm.getFileName();
		String fileFolder = rfm.getFileFolder();
		String filePathAndName = fileFolder + File.separator + fileName;
		if ("".equals(fileName) || "".equals(fileFolder)) {
			log.info("没有找到文件名及目录，文件生成失败");
			return flag;
		}
		flag = bluidTxtFile(filePathAndName, list);
		if (flag) {
			flag = FileOperateUtil.getInstance().bliudSignalFile(filePathAndName + ".ok");
		} else {
			return flag;
		}
		FtpUtil ftpUtil = new FtpUtil();
		ftpUtil.initFtpUtil(2);
		// 审批上传
		String ftpTagertFolder = rfm.getFtpTagertFolder();
		log.info("=========上传目标文件夹==============ftpTagertFolder：" + ftpTagertFolder);
		// 上传txt文件
		flag = ftpUtil.upload(filePathAndName, ftpTagertFolder + File.separator + fileName);
		// 上传信号文件
		flag = ftpUtil.upload(filePathAndName + ".ok", ftpTagertFolder + File.separator + fileName + ".ok");
		return flag;
	}

	private boolean bluidTxtFile(String filePathAndName, List<RucangModel> list) {
		log.info("入仓服务准备开始创建txt");
		boolean ret = false;
		if (list == null) {
			return ret;
		}
		try {
			FileUtils.writeStringToFile(new File(filePathAndName), makeString(list), "GB2312");
			ret = true;
		} catch (IOException e) {
			log.error(e);
		}
		return ret;
	}

	private String makeString(List<RucangModel> list) {
		StringBuffer sb = new StringBuffer();
		String line = System.getProperty("line.separator");// 换行符
		sb.append("APPL_ID|ID_TYPE|ID|NAME|DATE" + line);
		for (RucangModel rm : list) {
			sb.append(rm.getAppId() == null ? "" : rm.getAppId());
			sb.append("|");
			sb.append(rm.getIdType() == null ? "" : rm.getIdType());
			// sb.append("01");
			sb.append("|");
			sb.append(rm.getIdno() == null ? "" : rm.getIdno());
			sb.append("|");
			sb.append(rm.getUsername() == null ? "" : rm.getUsername());
			sb.append("|");
			sb.append(rm.getResdata() == null ? "" : rm.getResdata().replace("\r", "").replace("\n", ""));
			sb.append(line);
		}
		return sb.toString();
	}

	@Override
	public RucangFileModel getRfModel(String type) {
		RucangFileModel rfm = new RucangFileModel();
		rfm.setFileFolder(AppConfigFile.getInstance().getValue("RC_LOCAL_FOLDER_" + type));
		rfm.setFileName(AppConfigFile.getInstance().getValue("RC_NAME_" + type) + new SimpleDateFormat("yyyyMMdd").format(new Date()) + ".txt");
		rfm.setFtpTagertFolder(AppConfigFile.getInstance().getValue("RC_FTP_FOLDER_" + type));
		return rfm;
	}

	@Override
	public String getRucangTitle() {
		StringBuffer sb = new StringBuffer();
		String line = System.getProperty("line.separator");// 换行符
		sb.append("APPL_ID|ID_TYPE|ID|NAME|DATE" + line);
		return sb.toString();
	}

}
