package com.ideal.spdb.thirdinfo.work;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ideal.spdb.datamanager.model.ApplicationModel;
import com.ideal.spdb.datamanager.service.ApplicationService;
import com.ideal.spdb.juxinliBlackList.model.JuxinliBlackListRecordModel;
import com.ideal.spdb.juxinliBlackList.service.JuxinliBlackListRecordService;
import com.ideal.spdb.manuallyManager.model.ManuallyModel;
import com.ideal.spdb.manuallyManager.service.ManuallyManageService;
import com.ideal.spdb.thirdinfo.dao.IEucVehicleExcelDao;
import com.ideal.spdb.thirdinfo.dao.ISocialsecurityDao;
import com.ideal.spdb.thirdinfo.model.JuxinliBlackListExportModel;
import com.ideal.spdb.thirdinfo.util.DownloadFtpFile;
import com.ideal.spdb.thirdinfo.work.util.FileOperateUtil;
import com.ideal.spdb.thirdinfo.work.util.FtpUtil;
import com.ideal.spdb.thirdinfo.work.util.InfoOperateUtil;
import com.ideal.spdb.thirdinfo.work.util.MakeTxtUtil;
import com.ideal.spdb.thirdinfo.work.util.RequestIp;
import com.ideal.spdb.thirdinfo.writemodel.JuxinliBlackListWriteModel;
import com.ideal.spdb.utils.AppConfigFile;
import com.ideal.spdb.utils.DataToExcelModel;

public class JuxinliBlackListWork {
	private static final Logger log = Logger.getLogger(JuxinliBlackListWork.class);
	
	@Inject
	ISocialsecurityDao SocialsecuritDao;
	
	@Inject
	private IEucVehicleExcelDao vehicleDao;
	
	@Inject
	private JuxinliBlackListRecordService service;
	
	@Inject
	private ApplicationService applicationService;    //申请件业务类
	
	@Inject
	private ManuallyManageService manuallyManageService;  //流程处理业务
	
	/**
	 * 导出数据到审批系统
	 */
	public void everydayUploadJuxinliBlackList(){
		log.info("=========JuxinliBlackListWork.everydayUploadJuxinliBlackList()开始执行=============");
		try {
			long start = System.currentTimeMillis();
			String localhostIp = RequestIp.getLocalhostIp();
			String serverIp = this.vehicleDao.getConfigIP("SERVER_IP");
			log.info("localhostIp = " + localhostIp);
			log.info("serverIp = " + serverIp);
			if (localhostIp.equals(serverIp)) {
			
				int type = InfoOperateUtil.PUBLICSECURITY;
				String localFilePath = InfoOperateUtil.getInstance().getFolderName(type);
				List<JuxinliBlackListRecordModel> list = (List<JuxinliBlackListRecordModel>) service.queryJuxinliBlackListInfo();
				if(list.size() > 0){
					String fileName = getFileName();

					String fileFolder = localFilePath +File.separatorChar;
					String filePathAndName = fileFolder + fileName;
					
					bluidTxtFile(filePathAndName, list);
					createTxt(filePathAndName + ".ok");
					// 3.上传
					FtpUtil ftpUtil = new FtpUtil();
					// ftpUtil.initFtpUtil(8);
					String ftpTagetFolder = FileOperateUtil.getInstance()
							.getFolderName(FileOperateUtil.FTP_ROOT_FOLDER_PUBLICSECURITY);
					ftpUtil.initFtpUtil();

					File ftpSrcFile = new File(filePathAndName);
					// 检查信息文件是否生成
					if (!ftpSrcFile.exists()) {
						log.info("==========JuxinliBlackListWork本地文件生成失败================");
					}
					try {
						String ftpTargetFilePath = ftpTagetFolder + fileName;
						if (!ftpUtil.upload(filePathAndName, ftpTargetFilePath)) {
							log.error("==============" + this.getClass().getName()
									+ "==========JuxinliBlackListWork:上传失败==========");
						}
						// 生成.ok文件
						if (!ftpUtil.upload(filePathAndName + ".ok",
								ftpTargetFilePath + ".ok")) {
							log.error("==============" + this.getClass().getName()
									+ "==========JuxinliBlackListWork:上传失败==========");
						}
					} catch (Exception e) {
						log.error("============" + this.getClass().getName()
								+ "==========JuxinliBlackListWork:上传失败============");
						throw new RuntimeException("文件上传失败"+e);
					} finally {
						ftpUtil.closeServer();
						if (ftpSrcFile.exists()) {
							ftpSrcFile.delete();
							(new File(filePathAndName + ".ok")).delete();
						}
					}
					
					//更改记录状态为已上传状态
					for (JuxinliBlackListRecordModel juxinlibalcklist : list) {
						juxinlibalcklist.setFlag("1");
						service.updateJuxinliBlackListInfoStatus(juxinlibalcklist);
					}

					long end = System.currentTimeMillis();
					log.info("执行完成..用时：" + (end - start) + "m");
				}
			}
		} catch (Exception e) {
			log.error("everydayUploadJuxinliBlackList方法异常" + e);
		}
	}
	
	/**
	 * 单独导出中黑名单的数据
	 */
	public void everydayUploadJuxinliBlackListXLS(){
		log.info("=========JuxinliBlackListWork.everydayUploadJuxinliBlackListXLS()开始执行=============");
		try {
			long start = System.currentTimeMillis();
			String localhostIp = RequestIp.getLocalhostIp();
			String serverIp = this.vehicleDao.getConfigIP("SERVER_IP");
			log.info("localhostIp = " + localhostIp);
			log.info("serverIp = " + serverIp);
			if (localhostIp.equals(serverIp)) {
				List<JuxinliBlackListExportModel> list = (List<JuxinliBlackListExportModel>) service.queryJuxinliBlackListInfoExport();
				
				StringBuffer sb = new StringBuffer();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				sb.append("HMD");
				sb.append(sdf.format(new Date()));
				sb.append("000001.xls");
				String fileName = sb.toString();
				
				String fileFolder = AppConfigFile.getInstance().getValue("JUXINLIBLACKLIST_LOCAL") + File.separatorChar;
				String filePathAndName = fileFolder + fileName;
				
				File f = new File(filePathAndName);
				FileOutputStream fop;
				
				fop = new FileOutputStream(f);
				
				BufferedOutputStream bos = new BufferedOutputStream(fop);
				DataToExcelModel.getInstance().JobdataToExcelUtil(list, "com.ideal.spdb.thirdinfo.model.JuxinliBlackListExportModel", fileName, bos, "聚信力黑名单");
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
		        String ftpTagetFolder = FileOperateUtil.getInstance().getFolderName(FileOperateUtil.FTP_ROOT_FOLDER_JUXINLIBLACKLIST);
		        File ftpSrcFile = new File(filePathAndName);
		        //检查信息excel是否生成
		        if(!ftpSrcFile.exists()){
		        	log.info("==========聚信力黑名单报表本地文件生成失败================");
		        }
		        try{
		            String ftpTargetFilePath=ftpTagetFolder+fileName;
		            if(!ftpUtil.upload(filePathAndName,ftpTargetFilePath)){
		                 log.error("==============" + this.getClass().getName() + "==========聚信力黑名单报表:上传失败==========");
		            }
		        }catch(Exception e){
		             log.error("============" + this.getClass().getName() + "==========聚信力黑名单报表:上传失败============");
		        }finally{
		            ftpUtil.closeServer();
		            if(ftpSrcFile.exists()){
		              ftpSrcFile.delete();
		            }
		        }
				
				long end = System.currentTimeMillis();
				log.info("执行完成..用时：" + (end - start) + "m");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("everydayUploadJuxinliBlackListXLS方法异常" + e);
		}
	}
	
	/**
	 * 批量上挂数据
	 */
	public void everydayQueryAllJuxinliBlackListByXLS(){
		log.info("=========JuxinliBlackListWork.everydayQueryAllJuxinliBlackListByXLS()开始执行=============");
		try {
			long start = System.currentTimeMillis();
			String localhostIp = RequestIp.getLocalhostIp();
			String serverIp = this.vehicleDao.getConfigIP("SERVER_IP");
			log.info("localhostIp = " + localhostIp);
			log.info("serverIp = " + serverIp);
			if (localhostIp.equals(serverIp)) {
				// 1.下载文件
				// ftp文件路径
				String filePath = AppConfigFile.getInstance().getValue("JXL_INPUT");
				// 本地文件路径
				String newPath = AppConfigFile.getInstance().getValue("JXL_INPUT_LOCAL");
				// 下载
//				this.downFtpServerFile(filePath, newPath);
				FtpUtil ftpUtil = new FtpUtil();
				ftpUtil.initFtpUtil();
				if(DownloadFtpFile.downloadByOK(ftpUtil, filePath, newPath)){
					File folder = new File(newPath);
					for (File file : folder.listFiles()) {
						if(!file.isDirectory()){
							String filepath = file.getPath();
							List<ManuallyModel> list = this.parseExcelData(filepath);
							for (ManuallyModel manuallyModel : list) {
								ApplicationModel application = new ApplicationModel();
								application.setShenqingshucode(manuallyModel.getShenqingshucode());
								
								manuallyModel.setSearchType("1");
								
								manuallyModel.setFlow("0000100000");
								manuallyModel.setProcess_finish("0000000000");
								
								application = applicationService.queryApplicationInfoById(application);
								if(null!=application){
									//更新申请件表
									manuallyManageService.updateApplicationInfoById(manuallyModel);
								}else{
									//添加信息到申请件
									manuallyManageService.addApplicationInfoById(manuallyModel);
								}
								//添加信息到记录表
								manuallyManageService.addPf_process(manuallyModel);
								manuallyManageService.insertOrUpdateInfo(manuallyModel);
							}
							//备份文件
							File old = new File(filepath);
							FileUtils.moveFile(old, new File(newPath + File.separatorChar + "BAK" + File.separatorChar +old.getName()+UUID.randomUUID()));
						}
					}
				}
				long end = System.currentTimeMillis();
				log.info("执行完成..用时：" + (end - start) + "m");
			}
		} catch (Exception e) {
			log.error("everydayQueryAllJuxinliBlackListByXLS方法异常" + e);
		}
	}
	
	//黑名单实时自动导入审批Caps系统
	/**
	 * 黑名单定义：聚信立黑名单为Y、公安网命中BL类- BL01、BL02、BL11、BL12
	 */
	public void OutputBlackListInfo(){
		log.info("=========JuxinliBlackListWork.OutputBlackListInfo()开始执行=============");
		try {
			long start = System.currentTimeMillis();
			String localhostIp = RequestIp.getLocalhostIp();
			String serverIp = this.vehicleDao.getConfigIP("SERVER_IP");
			log.info("localhostIp = " + localhostIp);
			log.info("serverIp = " + serverIp);
			if (localhostIp.equals(serverIp)) {
			
				int type = InfoOperateUtil.PUBLICSECURITY;
				String localFilePath = InfoOperateUtil.getInstance().getFolderName(type);
				
				List<JuxinliBlackListRecordModel> list = service.getAllList("juxinliBlackList.queryOutPutBlackListInfo", null);
				
				if(list.size() > 0){
//					String fileName = getFileName();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
					String fileName = "blklist"+sdf.format(new Date())+".txt";
					String fileFolder = localFilePath +File.separatorChar;
					String filePathAndName = fileFolder + fileName ;
					
					
//					bluidTxtFile(filePathAndName, list);
					
					try {
						File f = new File(filePathAndName);
						FileOutputStream fop = new FileOutputStream(f);
						OutputStreamWriter writer = new OutputStreamWriter(fop, "gbk");
						log.info("开始生成txt");
						for (JuxinliBlackListRecordModel juxinliBlackListRecordModel : list) {
							writer.append(juxinliBlackListRecordModel.getRemark() + "\n");
						}
						writer.close();
						fop.close();
					} catch (Exception e) {
						log.error("生成txt方法异常" + e);
						e.printStackTrace();
						return;
					}
					
					// 3.上传
					FtpUtil ftpUtil = new FtpUtil();
					// ftpUtil.initFtpUtil(8);
					String ftpTagetFolder = FileOperateUtil.getInstance().getFolderName(FileOperateUtil.FTP_ROOT_FOLDER_OUTPUTBLACKLISTCAPS);
					ftpUtil.initFtpUtil();

					File ftpSrcFile = new File(filePathAndName);
					// 检查信息文件是否生成
					if (!ftpSrcFile.exists()) 
						log.info("==========JuxinliBlackListWork.OutputBlackListInfo本地文件生成失败================");
					try {
						String ftpTargetFilePath = ftpTagetFolder + fileName;
						if (!ftpUtil.upload(filePathAndName, ftpTargetFilePath)) 
							log.error("==============" + this.getClass().getName() + "==========JuxinliBlackListWork.OutputBlackListInfo:上传失败==========");
					} catch (Exception e) {
						log.error("============" + this.getClass().getName() + "==========JuxinliBlackListWork.OutputBlackListInfo:上传失败============");
					} finally {
						ftpUtil.closeServer();
						if (ftpSrcFile.exists()) 
							ftpSrcFile.delete();
					}
					
					//更改记录状态为已上传状态
					for (JuxinliBlackListRecordModel juxinlibalcklist : list) {
						service.edit("juxinliBlackList.updateOutPutBlackListInfoStatus", juxinlibalcklist);
					}

					long end = System.currentTimeMillis();
					log.info("执行完成..用时：" + (end - start) + "m");
				}
			}
		} catch (Exception e) {
			log.error("OutputBlackListInfo方法异常" + e);
		}
	}

	public boolean bluidTxtFile(String filepathAndName,List<JuxinliBlackListRecordModel> amList){
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
				JuxinliBlackListRecordModel etm = amList.get(i);
				JuxinliBlackListWriteModel writeModel = new JuxinliBlackListWriteModel();
				writeModel= (JuxinliBlackListWriteModel) MakeTxtUtil.getInstance().getTxtWriteModelNoCase(etm,writeModel);
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
	
	/**
	 * 从ftp下载excel文件
	 * 
	 * @return
	 */
	private synchronized String downFtpServerFile(String serverFolder, String loacalDownSaveFolder) {
		FtpUtil ftpUtil = new FtpUtil();
		boolean ret = false;
		ftpUtil.initFtpUtil();
		String serverFileName = "";
		List serverFileList = ftpUtil.getFileList(serverFolder, new String[] { ".xls", ".xlsx" });
		if (serverFileList != null && serverFileList.size() > 0) {
			for (int i = 0; i < serverFileList.size(); i++) {
				String temp = (String) serverFileList.get(i);
				serverFileName = File.separatorChar + temp.substring(temp.lastIndexOf(File.separatorChar) + 1, temp.length());
				long ds = ftpUtil.downloadFile(serverFolder + serverFileName, loacalDownSaveFolder + serverFileName);
				ret = ds >= 0 ? true : false;
				//备份文件
				try {
					ftpUtil.moveFtpServerFile(serverFolder + serverFileName,serverFolder + File.separatorChar+"BAK"+File.separatorChar + serverFileName);
					deleteFtpFile(serverFolder + serverFileName);
				} catch (Exception e) {
					log.info("文件备份失败");
				}
				log.info("serverFileName = " + serverFileName);
			}
		}
		ftpUtil.closeServer();
		return serverFileName;
	}

	/**
	 * 下载完成后删除文件
	 */
	public static void deleteFtpFile(String fileName) {
		FtpUtil ftpUtil = new FtpUtil();
		ftpUtil.initFtpUtil();
		ftpUtil.deleteFile(fileName);
		ftpUtil.closeServer();
	}
	
	/**
	 * 解析所下载的excel文件数据
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private List<ManuallyModel> parseExcelData(String filePath) throws FileNotFoundException, IOException {
		log.info("《=======开始解析所下载的excel数据=========》" + filePath);
		List<ManuallyModel> list = new ArrayList<ManuallyModel>();
		if (filePath.indexOf("xlsx") > 0) {
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(filePath));
			XSSFSheet st = wb.getSheetAt(0);
			XSSFCell cell = null;
			if (st == null) {
				return null;
			}
			for (int rowIndex = 1; rowIndex <= st.getLastRowNum(); rowIndex++) {
				XSSFRow row = st.getRow(rowIndex);
				if (row == null) {
					continue;
				}
				ManuallyModel mes = new ManuallyModel();
				for (int columnIndex = 0, size = row.getLastCellNum(); columnIndex <= size; columnIndex++) {
					cell = row.getCell(columnIndex);
					String value = "";
					if (cell != null) {
						switch (cell.getCellType()) {
						case HSSFCell.CELL_TYPE_STRING:
							value = cell.getStringCellValue();
							break;
						case HSSFCell.CELL_TYPE_NUMERIC:
							if (HSSFDateUtil.isCellDateFormatted(cell)) {
								Date date = cell.getDateCellValue();
								if (date != null) {
									value = new SimpleDateFormat("yyyyMMdd").format(date);
								} else {
									value = "";
								}
							} else {
								value = new DecimalFormat("0").format(cell.getNumericCellValue());
							}
							break;
						case HSSFCell.CELL_TYPE_FORMULA:
							if (!cell.getStringCellValue().equals("")) {
								value = cell.getStringCellValue();
							} else {
								value = cell.getStringCellValue() + "";
							}
							break;
						case HSSFCell.CELL_TYPE_BLANK:
							break;
						case HSSFCell.CELL_TYPE_ERROR:
							value = "";
							break;
						case HSSFCell.CELL_TYPE_BOOLEAN:
							value = (cell.getBooleanCellValue() == true ? "Y" : "N");
							break;
						default:
							value = "";
						}
						// 每次循环输出：第几行的第几列的值（如：0,0，第一行第一列）
						System.out.println(rowIndex + "," + columnIndex + ":" + value);

						value = value.trim();
						if (columnIndex == 0) {
							// 列为0
							mes.setShenqingshucode(value);
						} else if (columnIndex == 1) {
							// 列为1，以下依次类推
							mes.setShenqingrenzhongwenminchen(value);
						}else if (columnIndex == 2) {
							// 列为2，以下依次类推
							mes.setShengqingrencardnumber(value);
						}else if (columnIndex == 3) {
							// 列为2，以下依次类推
							mes.setApprovalcode(value);
						}
					}
				}
				if (mes.getShenqingshucode() != null && !"".equals(mes.getShenqingshucode()) 
						&& mes.getShenqingrenzhongwenminchen() != null && !"".equals(mes.getShenqingrenzhongwenminchen())
						&& mes.getShengqingrencardnumber() != null && !"".equals(mes.getShengqingrencardnumber())) {
					list.add(mes);
				}
			}
		} else {
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(new File(filePath)));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFCell cell = null;
			HSSFSheet st = wb.getSheetAt(0);
			for (int rowIndex = 1; rowIndex <= st.getLastRowNum(); rowIndex++) {
				HSSFRow row = st.getRow(rowIndex);
				if (row == null) {
					continue;
				}
				ManuallyModel mes = new ManuallyModel();
				for (int columnIndex = 0, size = row.getLastCellNum(); columnIndex <= size; columnIndex++) {
					cell = row.getCell(columnIndex);
					String value = "";
					if (cell != null) {
						switch (cell.getCellType()) {
						case HSSFCell.CELL_TYPE_STRING:
							value = cell.getStringCellValue();
							break;
						case HSSFCell.CELL_TYPE_NUMERIC:
							if (HSSFDateUtil.isCellDateFormatted(cell)) {
								Date date = cell.getDateCellValue();
								if (date != null) {
									value = new SimpleDateFormat("yyyyMMdd").format(date);
								} else {
									value = "";
								}
							} else {
								value = new DecimalFormat("0").format(cell.getNumericCellValue());
							}
							break;
						case HSSFCell.CELL_TYPE_FORMULA:
							if (!cell.getStringCellValue().equals("")) {
								value = cell.getStringCellValue();
							} else {
								value = cell.getStringCellValue() + "";
							}
							break;
						case HSSFCell.CELL_TYPE_BLANK:
							break;
						case HSSFCell.CELL_TYPE_ERROR:
							value = "";
							break;
						case HSSFCell.CELL_TYPE_BOOLEAN:
							value = (cell.getBooleanCellValue() == true ? "Y" : "N");
							break;
						default:
							value = "";
						}
						// 每次循环输出：第几行的第几列的值（如：0,0，第一行第一列）
						System.out.println(rowIndex + "," + columnIndex + ":" + value);

						value = value.trim();
						if (columnIndex == 0) {
							// 列为0
							mes.setShenqingshucode(value);
						} else if (columnIndex == 1) {
							// 列为1，以下依次类推
							mes.setShenqingrenzhongwenminchen(value);
						}else if (columnIndex == 2) {
							// 列为2，以下依次类推
							mes.setShengqingrencardnumber(value);
						}else if (columnIndex == 3) {
							// 列为2，以下依次类推
							mes.setApprovalcode(value);
						}
					}
				}
				if (mes.getShenqingshucode() != null && !"".equals(mes.getShenqingshucode()) 
						&& mes.getShenqingrenzhongwenminchen() != null && !"".equals(mes.getShenqingrenzhongwenminchen())
						&& mes.getShengqingrencardnumber() != null && !"".equals(mes.getShengqingrencardnumber())) {
					list.add(mes);
				}
			}
		}
		return list;
	}
}
