package com.ideal.spdb.thirdinfo.work;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

import com.ideal.spdb.datadictionary.model.SysDatadictionarModel;
import com.ideal.spdb.datadictionary.service.ISysDatadictionarService;
import com.ideal.spdb.datamanager.model.ApplicationModel;
import com.ideal.spdb.datamanager.service.ApplicationService;
import com.ideal.spdb.manuallyManager.model.ManuallyModel;
import com.ideal.spdb.manuallyManager.service.ManuallyManageService;
import com.ideal.spdb.thirdinfo.dao.IEucVehicleExcelDao;
import com.ideal.spdb.thirdinfo.util.DownloadFtpFile;
import com.ideal.spdb.thirdinfo.work.util.FtpUtil;
import com.ideal.spdb.thirdinfo.work.util.RequestIp;
import com.ideal.spdb.utils.AppConfigFile;
import com.ideal.spdb.utils.StringUtils;

public class BairongWork {
	private static final Logger log = Logger.getLogger(BairongWork.class);
	@Inject
	ISysDatadictionarService sysDatadictionarService;
	@Inject
	private IEucVehicleExcelDao vehicleDao;
	@Inject
	private ApplicationService applicationService;    //申请件业务类
	@Inject
	private ManuallyManageService manuallyManageService;  //流程处理业务
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	/**
	 * 批量上挂数据
	 */
	public void everydayQueryAllBairongByXLS(){
		log.info("=========BairongWork.everydayQueryAllBairongByXLS()开始执行=============");
		try {
			long start = System.currentTimeMillis();
			String localhostIp = RequestIp.getLocalhostIp();
			String serverIp = this.vehicleDao.getConfigIP("SERVER_IP");
			log.info("localhostIp = " + localhostIp);
			log.info("serverIp = " + serverIp);
			if (localhostIp.equals(serverIp)) {
				// 1.下载文件
				// ftp文件路径
				String filePath = AppConfigFile.getInstance().getValue("BAIRONG");
				// 本地文件路径
				String newPath = AppConfigFile.getInstance().getValue("LOCAL_BAIRONG");
				
				if(StringUtils.isEmpty(filePath) || StringUtils.isEmpty(newPath)){
					log.info("BAIRONG或LOCAL_BAIRONG配置未找到");
					return;
				}
				
				// 下载
//				this.downFtpServerFile(filePath, newPath);
				FtpUtil ftpUtil = new FtpUtil();
				ftpUtil.initFtpUtil();
				if(DownloadFtpFile.downloadByOK(ftpUtil, filePath, newPath)){
					File folder = new File(newPath);
					for (File file : folder.listFiles()) {
						if(!file.isDirectory()){
							String filepath = file.getPath();
							
							List<ManuallyModel> list = null;
							try {
								list = this.parseExcelData(filepath);
							} catch (Exception e) {
								log.info("百融文件解析错误:" + filePath);
							}
							
							//备份文件
							File old = new File(filepath);
							File bakPath = new File(newPath + "//" + "BAK" + "//" + sdf.format(new Date()));
							if(!bakPath.exists()){
								bakPath.mkdirs();
							}
							log.info("备份本地: from " + old.getAbsolutePath() + " to " + newPath + "//" + "BAK" + "//" + sdf.format(new Date()) + "//" + old.getName() );
							FileUtils.moveFile(old, new File(newPath + "//" + "BAK" + "//" + sdf.format(new Date()) + "//" + old.getName()+UUID.randomUUID()));
							
							if(list != null){
								log.info("百融导入" + list.size() + "条数据");
								for (ManuallyModel manuallyModel : list) {
									ApplicationModel application = new ApplicationModel();
									application.setShenqingshucode(manuallyModel.getShenqingshucode());
									
									manuallyModel.setSearchType("1");
									
									//获取需要处理的数据项
									SysDatadictionarModel data2 = new SysDatadictionarModel("ManuallyCode");
							        List<SysDatadictionarModel> datas2 = sysDatadictionarService.getAllList("sysDatadictionar.findCostValue",data2);
							        
							        for(int i = 1; i <= datas2.size(); i++){
							        	for (SysDatadictionarModel sysDatadictionarModel : datas2) {
											if(sysDatadictionarModel.getChildCostValue().equals(""+i)){
												if("14".equals(""+i)){
													manuallyModel.setFlow(manuallyModel.getFlow() == null?"1":manuallyModel.getFlow() + "1");
													manuallyModel.setProcess_finish(manuallyModel.getProcess_finish() == null?"0":manuallyModel.getProcess_finish() + "0");
												}else{
													manuallyModel.setFlow(manuallyModel.getFlow() == null?"0":manuallyModel.getFlow() + "0");
													manuallyModel.setProcess_finish(manuallyModel.getProcess_finish() == null?"1":manuallyModel.getProcess_finish() + "1");
												}
											}
										}
							        }
									
									application = applicationService.queryApplicationInfoById(application);
									try {
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
									} catch (Exception e) {
										log.info("百融插入" + manuallyModel.getShenqingshucode() + "错误" + e);
									}
								}
								log.info("百融批量文件" + filePath + "导入结束");
							}
							
						}
					}
				}
				
				long end = System.currentTimeMillis();
				log.info("执行完成..用时：" + (end - start) + "m");
			}
		} catch (Exception e) {
			log.error("BairongWork.everydayQueryAllBairongByXLS()方法异常" + e);
		}
	}
	
	/**
	 * 检查ftp上文件夹是否存在
	 * @param type
	 */
	public void checkFtpDir(String path){
		FtpUtil ftpUtil = new FtpUtil();
		ftpUtil.initFtpUtil();
		
		String date = sdf.format(new Date());
		ftpUtil.initFtpUtil();
		
		if(!ftpUtil.isDirExist(path + "\\" + "BAK")){
			ftpUtil.createDir(path + "\\" + "BAK");
		}
		
		if(!ftpUtil.isDirExist(path + "\\" + "BAK" + "\\" + date)){
			ftpUtil.createDir(path + "\\" + "BAK" + "\\" + date);
		}
		ftpUtil.closeServer();
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
		List serverFileList = ftpUtil.getFileList(serverFolder, new String[] { ".xls" });
		checkFtpDir(serverFolder);
		if (serverFileList != null && serverFileList.size() > 0) {
			for (int i = 0; i < serverFileList.size(); i++) {
				String temp = (String) serverFileList.get(i);
				serverFileName = "\\" + temp.substring(temp.lastIndexOf(File.separatorChar) + 1, temp.length());
				log.info("百融download: from " + serverFolder + serverFileName + " to " + loacalDownSaveFolder + temp.substring(temp.lastIndexOf("\\") + 1, temp.length()));
				long ds = ftpUtil.downloadFile(serverFolder + serverFileName, loacalDownSaveFolder + "/" + temp.substring(temp.lastIndexOf("\\") + 1, temp.length()));
				ret = ds >= 0 ? true : false;
				//备份文件
				try {
					log.info("百融move: from " + serverFolder + serverFileName + " to " + serverFolder + "\\" + "BAK" + "\\" + sdf.format(new Date()) + "\\" + serverFileName);
					ftpUtil.moveFtpServerFile(serverFolder + serverFileName,serverFolder + "\\" + "BAK" + "\\" + sdf.format(new Date()) + "\\" + serverFileName);
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
					value = value.trim();
					
					switch (columnIndex) {
					case 0:
						if(value.getBytes().length > 16){
							continue;
						}
						mes.setShenqingshucode(value);
						break;
					case 1:
						if(value.getBytes().length > 30){
							continue;
						}
						mes.setShenqingrenzhongwenminchen(value);
						break;
					case 2:
						if(value.getBytes().length > 19){
							continue;
						}
						mes.setShengqingrencardnumber(value);
						break;
					case 3:
						if(value.getBytes().length > 12){
							continue;
						}
						mes.setShenqingrenmobilenumber(value);
						break;
					case 4:
						if(value.getBytes().length > 40){
							continue;
						}
						mes.setEmail(value);
						break;
					case 5:
						if(value.getBytes().length > 10){
							continue;
						}
						mes.setApprovalcode(value);
						break;
					default:
						break;
					}
				}
			}
			
			if (!StringUtils.isEmpty(mes.getShenqingshucode())) {
				list.add(mes);
			}
		}
		return list;
	}
}
