package com.ideal.spdb.thirdinfo.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

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
import org.springframework.stereotype.Service;

import com.ideal.spdb.thirdinfo.dao.ISZOverdueDao;
import com.ideal.spdb.thirdinfo.model.EduImportModel;
import com.ideal.spdb.thirdinfo.model.SZOverdueModel;
import com.ideal.spdb.thirdinfo.service.ISZOverdueService;
import com.ideal.spdb.thirdinfo.util.DownloadFtpFile;
import com.ideal.spdb.thirdinfo.work.util.FileOperateUtil;
import com.ideal.spdb.thirdinfo.work.util.FtpUtil;
import com.ideal.spdb.utils.AppConfigFile;

@Service
public class SZOverdueServiceImpl implements ISZOverdueService {
	private static final Logger log = Logger.getLogger(SZOverdueServiceImpl.class);
	@Inject
	ISZOverdueDao dao;

	@Override
	public boolean downSZOverdueList() {
		boolean flag = true;
		log.info("开始执行downSZOverdueList...");
		try {
			String serverFolder = AppConfigFile.getInstance().getValue("FTP_SZOVERDUE");
			// 下载文件存放位置
			String loacalDownSaveFolder = AppConfigFile.getInstance().getValue("LOCAL_ROOT")+File.separator + "DOWN" +File.separator  +"SZOVERDUE";
			// 下载文件
			FtpUtil ftpUtil = new FtpUtil();
			ftpUtil.initFtpUtil();
			if(DownloadFtpFile.downloadByOK(ftpUtil, serverFolder, loacalDownSaveFolder)){
				File [] files=new File(loacalDownSaveFolder).listFiles(new FilenameFilter() {
					@Override
					public boolean accept(File dir, String name) {
						return name.endsWith(".xls")||name.endsWith(".xlsx");
					}
				});
				for (File file : files) {
					List<SZOverdueModel> datalist = parseExcelData(file.getPath());
					DownloadFtpFile.moveLocalFile2Bak(file, loacalDownSaveFolder + File.separator +"BAK");
					for (SZOverdueModel model : datalist) {
						// 存入本地数据库备份，同时获取序列作为主流程的申请书编号（流水号），和大流程一起处理，processtype为4，来源为深圳逾期客户，后期大平台导出社保信息过滤该批数据
						dao.insertIntoData(model);
						// 插入生产表
						dao.insertApp(model);
						// 初始化处理表，优先级为2
						dao.initprocess(model);
					}
				}
			}
			
		} catch (Exception e) {
			log.info(e);
			flag = false;
		}
		return flag;
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
				serverFileName = temp.substring(temp.lastIndexOf(File.separator) + 1, temp.length());
				long ds = ftpUtil.downloadFile(serverFolder + serverFileName, loacalDownSaveFolder + serverFileName);
				ret = ds >= 0 ? true : false;
				log.info("serverFileName = " + serverFileName);
			}
		}
		ftpUtil.closeServer();
		return serverFileName;
	}

	/**
	 * 下载完成后删除文件
	 */
	private void deleteFile(String fileName) {
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
	private List<SZOverdueModel> parseExcelData(String filePath) throws FileNotFoundException, IOException {
		log.info("《=======开始解析所下载的excel数据=========》" + filePath);
		List<SZOverdueModel> list = new ArrayList<SZOverdueModel>();
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
				SZOverdueModel mes = new SZOverdueModel();
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
							mes.setOverdueIdentity(value);
						} else if (columnIndex == 1) {
							// 列为1，以下依次类推
							mes.setOverdueName(value);
						}
					}
				}
				if (mes.getOverdueIdentity() != null && !"".equals(mes.getOverdueIdentity()) && mes.getOverdueName() != null && !"".equals(mes.getOverdueName())) {
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
				SZOverdueModel mes = new SZOverdueModel();
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
							mes.setOverdueIdentity(value);
						} else if (columnIndex == 1) {
							// 列为1，以下依次类推
							mes.setOverdueName(value);
						}
					}
				}

				if (mes.getOverdueIdentity() != null && !"".equals(mes.getOverdueIdentity()) && mes.getOverdueName() != null && !"".equals(mes.getOverdueName())) {
					list.add(mes);
				}
			}
		}
		return list;
	}
	
}
