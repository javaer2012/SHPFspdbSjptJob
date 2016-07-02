package com.ideal.spdb.thirdinfo.work;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.log4j.Logger;


import com.ideal.spdb.thirdinfo.dao.IEucVehicleExcelDao;
import com.ideal.spdb.thirdinfo.model.Num;
import com.ideal.spdb.thirdinfo.model.SheBaoInfoExcelModel;
import com.ideal.spdb.thirdinfo.service.IThirdInfoService;
import com.ideal.spdb.thirdinfo.work.util.AppConfigFile;
import com.ideal.spdb.thirdinfo.work.util.FileOperateUtil;
import com.ideal.spdb.thirdinfo.work.util.FtpUtil;
import com.ideal.spdb.thirdinfo.work.util.RequestIp;
import com.ideal.spdb.utils.DataToExcelModel;


/**
 * 社保数据返回work
 * @author uatguansl
 *
 */
public class SheBaoDataReturnWork {
	private static Logger log = Logger.getLogger(SheBaoDataReturnWork.class);
	@Inject
	IEucVehicleExcelDao dao;
	@Inject
	IThirdInfoService thirdinfoService;
	
	/**
	 * 社保数据返回work
	 */
	public void goWork(){
		try {
			log.info("==========开始执行社保调用返回数据报表================");
			long start = System.currentTimeMillis();
			String localhostIp = RequestIp.getLocalhostIp();
			String serverIp = this.dao.getConfigIP("SERVER_IP");
			log.info("localhostIp = " + localhostIp);
			log.info("serverIp = " + serverIp);
			if (localhostIp.equals(serverIp) || localhostIp.equals("172.30.64.227")) {
				List<SheBaoInfoExcelModel> list =this.thirdinfoService.getSheBaoReturnList();
				if(list!=null&&list.size()>0){
					StringBuffer sb = new StringBuffer();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
					sb.append(sdf.format(new Date()));
					Num.count=Num.count+1;
					log.info("文件编号为=："+Num.count);
					sb.append("("+Num.count+")");
					sb.append(".xls");
					String fileName = sb.toString();
					String fileFolder = AppConfigFile.getInstance().getValue("SHEBAORETURNDATA_LOCAL") + "\\";
					String filePathAndName = fileFolder + fileName;
					File f = new File(filePathAndName);
					FileOutputStream fop = new FileOutputStream(f);
					BufferedOutputStream bos = new BufferedOutputStream(fop);
					DataToExcelModel.getInstance().JobdataToExcelUtil(list, "com.ideal.spdb.thirdinfo.model.SheBaoInfoExcelModel", fileName, bos, "社保调用返回数据列表");
					if (null != bos) {
						bos.flush();
						bos.close();
						bos = null;
					}
					if (null != fop) {
						fop.close();
						fop = null;
					}
					// 3.上传
					FtpUtil ftpUtil=new FtpUtil();
			        ftpUtil.initFtpUtil();
			        String ftpTagetFolder = FileOperateUtil.getInstance().getFolderName(FileOperateUtil.FTP_ROOT_FOLDER)+"\\PYZX\\"+"\\RESULT\\";
			        File ftpSrcFile = new File(filePathAndName);
			        //检查信息excel是否生成
			        if(!ftpSrcFile.exists()){
			        	log.info("==========社保调用返回数据报表本地文件生成失败================");
			        }
			        try{
			            String ftpTargetFilePath=ftpTagetFolder+fileName;
			            if(ftpUtil.upload(filePathAndName,ftpTargetFilePath)){
			            	for(SheBaoInfoExcelModel model:list){
			            		this.thirdinfoService.updateFlagTo1(model);//更新标识为1
			            	}
			            }else{
			            	log.error("==============" + this.getClass().getName() + "==========社保调用返回数据报表:上传失败==========");
			            }
			        }catch(Exception e){
			             log.error("============" + this.getClass().getName() + "==========社保调用返回数据报表:上传失败============");
			        }finally{
			            ftpUtil.closeServer();
			            if(ftpSrcFile.exists()){
			              ftpSrcFile.delete();
			            }
			        }
				}
				long end = System.currentTimeMillis();
				log.info("执行社保调用返回数据报表完成..用时：" + (end - start) + "m");
			}
			log.info("==========结束执行社保调用返回数据报表================");
		} catch (Exception e) {
			log.error("社保调用返回数据报表出错", e);
		} finally {
			
		}
	}
	
}
