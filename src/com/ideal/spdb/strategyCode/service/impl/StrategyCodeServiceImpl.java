package com.ideal.spdb.strategyCode.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ideal.spdb.strategyCode.model.StrategyCodeModel;
import com.ideal.spdb.strategyCode.service.StrategyCodeService;
import com.ideal.spdb.thirdinfo.dao.ISocialsecurityDao;
import com.ideal.spdb.thirdinfo.work.util.FileOperateUtil;
import com.ideal.spdb.thirdinfo.work.util.FtpUtil;
import com.ideal.spdb.thirdinfo.work.util.InfoOperateUtil;
import com.ideal.spdb.utils.BaseServiceImpl;
/**
 * 策略编码业务类
 * @author uatyangxh
 */
@Service
public class StrategyCodeServiceImpl extends BaseServiceImpl<StrategyCodeModel> implements StrategyCodeService {

	private static final Logger log = Logger.getLogger(StrategyCodeServiceImpl.class);
	
	@Inject
	ISocialsecurityDao SocialsecuritDao;
	
	/**
	 * 导出文件方法
	 * @throws Exception 
	 */
	@Override
	public void ExportStrategyCodeFile() throws Exception {
		// TODO Auto-generated method stub
		String localFilePath = InfoOperateUtil.getInstance().getFolderName(InfoOperateUtil.PUBLICSECURITY);
		List<StrategyCodeModel> list = this.getAllList("strategycode.getNeetExportData", null);
		if(list.size() > 0){
			String fileName = getFileName();

			String fileFolder = localFilePath + "\\";
			String filePathAndName = fileFolder + fileName;
			
			bluidTxtFile(filePathAndName, list);
			createTxt(filePathAndName + ".ok");
			// 3.上传
			FtpUtil ftpUtil = new FtpUtil();
			String ftpTagetFolder = FileOperateUtil.getInstance().getFolderName(FileOperateUtil.FTP_ROOT_FOLDER_STRATEGYCODE);
			ftpUtil.initFtpUtil();

			File ftpSrcFile = new File(filePathAndName);
			// 检查信息文件是否生成
			if (!ftpSrcFile.exists()) 
				log.info("==========doExportStrategyCodeFileWork本地文件生成失败================");
			try {
				String ftpTargetFilePath = ftpTagetFolder + fileName;
				if (!ftpUtil.upload(filePathAndName, ftpTargetFilePath)) 
					log.error("==============" + this.getClass().getName() + "==========doExportStrategyCodeFileWork:上传失败==========");
				// 生成.ok文件
				if (!ftpUtil.upload(filePathAndName + ".ok", ftpTargetFilePath + ".ok")) 
					log.error("==============" + this.getClass().getName() + "==========doExportStrategyCodeFileWork:上传失败==========");
			} catch (Exception e) {
				log.error("============" + this.getClass().getName() + "==========doExportStrategyCodeFileWork:上传失败============");
				throw new Exception("上传文件失败！");
			} finally {
				ftpUtil.closeServer();
				if (ftpSrcFile.exists()) {
					ftpSrcFile.delete();
					(new File(filePathAndName + ".ok")).delete();
				}
			}
			//更改记录状态为已上传状态
			for (StrategyCodeModel strategyCodeModel : list) {
				strategyCodeModel.setFlag("1");
				this.edit("strategycode.updateTacticscode",strategyCodeModel);
			}
		}
	}
	
	public boolean bluidTxtFile(String filepathAndName,List<StrategyCodeModel> amList){
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
				StrategyCodeModel etm = amList.get(i);
				StringBuffer sb = new StringBuffer();
				sb.append(StringUtils.isNotEmpty(etm.getAppid())?etm.getAppid():"            ");
				sb.append(",");
				sb.append(StringUtils.isNotEmpty(etm.getOutputcode())?getCode(etm.getOutputcode()):"     ");
				sb.append(StringUtils.isNotEmpty(etm.getIdCheck())?etm.getIdCheck():" ");
				sb.append(StringUtils.isNotEmpty(etm.getBlackList())?etm.getBlackList():" ");
				sb.append(StringUtils.isNotEmpty(etm.getYellowPage())?etm.getYellowPage():" ");
				sb.append(StringUtils.isNotEmpty(etm.getPboc1())?etm.getPboc1():" ");
				sb.append(StringUtils.isNotEmpty(etm.getPboc2())?etm.getPboc2():" ");
				sb.append(StringUtils.isNotEmpty(etm.getSocialSecurity())?etm.getSocialSecurity():" ");
				sb.append(StringUtils.isNotEmpty(etm.getEducation())?etm.getEducation():" ");
				sb.append(StringUtils.isNotEmpty(etm.getTencent())?etm.getTencent():" ");
				sb.append(StringUtils.isNotEmpty(etm.getInternal())?etm.getInternal():" ");
				sb.append(StringUtils.isNotEmpty(etm.getVehicle())?etm.getVehicle():" ");
				sb.append(StringUtils.isNotEmpty(etm.getLocalpeople())?etm.getLocalpeople():" ");
				sb.append(StringUtils.isNotEmpty(etm.getMobile())?etm.getMobile():" ");
				sb.append("   ");
				writer.append(sb.toString() + "\n");
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
	
	private static String getCode(String code){
		StringBuilder sb = new StringBuilder(code);
			
		if(code.length()>5){
			sb = new StringBuilder(code.substring(0, 5));
		}else if (code.length() < 5){
			while(true){
				sb.append(" ");
				if(sb.length() == 5)break;
			}
		}
		return sb.toString();
	}
	
	public static void createTxt(String filePath) {
		String s1 = new String();// 内容更新
		try {
			File f = new File(filePath);
			System.out.println("创建输出文件！");
			if (f.exists()) {
				f.delete();
			}
			f.createNewFile();// 不存在则创建

			BufferedWriter output = new BufferedWriter(new FileWriter(f));
			output.write(s1);
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
	}
	
	private String getFileName(){
		StringBuffer sb = new StringBuffer();
		sb.append("matchRule_auto_");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date d = new Date();
		sb.append(sdf.format(d));
		//获取批次号
		String xuHao = "";
		xuHao = SocialsecuritDao.getXuHao(1).get("out_system_seq");
		sb.append("_");
		sb.append(xuHao);
		sb.append(".txt");
		return sb.toString().trim();
		
	}
	
	
}
