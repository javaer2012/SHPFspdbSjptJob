package com.ideal.spdb.thirdinfo.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;
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

import com.ideal.spdb.datadictionary.service.ISysDatadictionarService;
import com.ideal.spdb.thirdinfo.dao.IApprovalDao;
import com.ideal.spdb.thirdinfo.dao.IEduImportDao;
import com.ideal.spdb.thirdinfo.dao.IEucVehicleExcelDao;
import com.ideal.spdb.thirdinfo.dao.impl.ApprovalDaoImpl;
import com.ideal.spdb.thirdinfo.model.AppInfoModel;
import com.ideal.spdb.thirdinfo.model.EduImportModel;
import com.ideal.spdb.thirdinfo.model.EucVehicleModel;
import com.ideal.spdb.thirdinfo.model.TencentModel;
import com.ideal.spdb.thirdinfo.service.IEduImportService;
import com.ideal.spdb.thirdinfo.util.DownloadFtpFile;
import com.ideal.spdb.thirdinfo.work.util.FileOperateUtil;
import com.ideal.spdb.thirdinfo.work.util.FtpUtil;
import com.ideal.spdb.utils.AppConfigFile;
import com.ideal.spdb.utils.BaseServiceImpl;

@Service
public class EduImportServiceImpl extends BaseServiceImpl<EduImportModel> implements IEduImportService {
	private static final Logger log = Logger.getLogger(EduImportServiceImpl.class);
	@Inject
	private IEduImportDao dao; // 操作dao

	@Inject
	private IApprovalDao appdap;

	@Override
	public boolean importEduInfo() {
		boolean flag = true;
		try {
			log.info("开始处理学历批量导入！！");
			// ftp存放excel文件的目录
			String serverFolder = AppConfigFile.getInstance().getValue("FTP_EDUIMPORT");
			// 下载文件存放位置
			String loacalDownSaveFolder = AppConfigFile.getInstance().getValue("LOCAL_ROOT") + File.separator + "DOWN" + File.separator + "XUELI";
			// 下载文件
			FtpUtil ftpUtil = new FtpUtil();
			ftpUtil.initFtpUtil();
			if (DownloadFtpFile.downloadByOK(ftpUtil, serverFolder, loacalDownSaveFolder)) {
				File[] files = new File(loacalDownSaveFolder).listFiles(new FilenameFilter() {
					@Override
					public boolean accept(File dir, String name) {
						return name.endsWith(".xls") || name.endsWith(".xlsx");
					}
				});
				for (File file : files) {
					// 备份到bak
					List<EduImportModel> datalist = parseExcelData(file.getPath());
					DownloadFtpFile.moveLocalFile2Bak(file, loacalDownSaveFolder + File.separator + "BAK");
					// 初始化查询情况
					initProcess(datalist);
				}
			}

		} catch (Exception e) {
			log.error(e);
			flag = false;
		}
		return flag;
	}

	private void initProcess(List<EduImportModel> datalist) {
		dao.insertOrUpdate(datalist);
		// 初始化处理表
		dao.initProcess(datalist);
		for (EduImportModel eduImportModel : datalist) {
			AppInfoModel model = new AppInfoModel(eduImportModel.getShenqingshucode(), null, 
					eduImportModel.getAppname(), eduImportModel.getAppno(), eduImportModel.getApprovalcode(), "1");
			appdap.insertOrUpdateAppInfo(model);
		}

	}

	/**
	 * 从ftp下载excel文件
	 * 
	 * @return
	 */
	private synchronized List<String> downFtpServerFile(String serverFolder, String loacalDownSaveFolder) {
		FtpUtil ftpUtil = new FtpUtil();
		ftpUtil.initFtpUtil();
		List<String> list = ftpUtil.queryOkFile(serverFolder, loacalDownSaveFolder);
		ftpUtil.closeServer();
		return list;
	}

	private List<EduImportModel> parseExcelData(String filePath) throws FileNotFoundException, IOException {
		log.info("《=======开始解析所下载的excel数据=========》" + filePath);
		List<EduImportModel> list = new ArrayList<EduImportModel>();
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
				EduImportModel mes = new EduImportModel();
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
							mes.setAppname(value);
						} else if (columnIndex == 2) {
							mes.setAppno(value);
						} else if (columnIndex == 3) {
							mes.setApprovalcode(value);
						}
					}
					if (mes.getShenqingshucode() != null && !"".equals(mes.getShenqingshucode()) && mes.getAppname() != null && !"".equals(mes.getAppname()) && mes.getAppno() != null
							&& !"".equals(mes.getAppno())) {
						list.add(mes);
					}
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
				EduImportModel mes = new EduImportModel();
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
							mes.setAppname(value);
						} else if (columnIndex == 2) {
							mes.setAppno(value);
						} else if (columnIndex == 3) {
							mes.setApprovalcode(value);
						}
					}

				}
				if (StringUtils.isNotEmpty(mes.getShenqingshucode()) && StringUtils.isNotEmpty(mes.getAppname()) && StringUtils.isNotEmpty(mes.getAppno())) {
					list.add(mes);
				}
			}
		}
		return list;
	}

	void moveToBak(String loacalDownSaveFolder, String fileName) {
		SimpleDateFormat sdf = new SimpleDateFormat("hhmmss");
		String bakFolderName = FileOperateUtil.getInstance().getFolderName(FileOperateUtil.getInstance().LOCAL_DOWN_FOLDER_BAK);
		String newName = fileName + sdf.format(new Date());
		FileOperateUtil.copyFile(loacalDownSaveFolder + fileName, bakFolderName + File.separator + newName);
		FileOperateUtil.copyFile(loacalDownSaveFolder + fileName + ".ok", bakFolderName + File.separator + newName + ".ok");
		FileOperateUtil.forceDelete(new File(loacalDownSaveFolder + fileName));
		FileOperateUtil.forceDelete(new File(loacalDownSaveFolder + fileName + ".ok"));
	}
}
