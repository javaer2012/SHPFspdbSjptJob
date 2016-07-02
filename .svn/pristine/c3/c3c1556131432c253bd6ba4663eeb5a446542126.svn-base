package com.ideal.spdb.thirdinfo.work.batchimport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import com.ideal.spdb.thirdinfo.dao.IEucVehicleExcelDao;
import com.ideal.spdb.thirdinfo.model.IdentityCardModel;
import com.ideal.spdb.thirdinfo.service.IdentityCardService;
import com.ideal.spdb.thirdinfo.util.DownloadFtpFile;
import com.ideal.spdb.thirdinfo.work.util.FtpUtil;
import com.ideal.spdb.thirdinfo.work.util.RequestIp;
import com.ideal.spdb.utils.AppConfigFile;

public class IdentityCardWork {

	private static final Logger log = Logger.getLogger(IdentityCardWork.class);
	@Autowired
	private IEucVehicleExcelDao vehicleDao;
	@Autowired
	private IdentityCardService identityCardService;

	public void importIdentityCar() throws Exception {
		log.info("开始importIdentityCar执行");
		long start = System.currentTimeMillis();
		String localhostIp = RequestIp.getLocalhostIp();
		String serverIp = vehicleDao.getConfigIP("SERVER_IP");
		log.info("localhostIp = " + localhostIp);
		log.info("serverIp = " + serverIp);
		if (localhostIp.equals(serverIp)) {
			log.info("IP比较相同,执行" + localhostIp + "服务器程序");
			// ftp根目录
			String ftproot = AppConfigFile.getInstance().getValue("FTP_ROOT");
			// ftp存放文件的目录
			String serverFolder = ftproot+ AppConfigFile.getInstance().getValue("SFZGSD_INPUT");
			// 下载文件存放位置
			String loacalDownSaveFolder = AppConfigFile.getInstance().getValue("SFZGSD_INPUT_LOCAL");
			FtpUtil ftpUtil = new FtpUtil();
			ftpUtil.initFtpUtil();
			if (DownloadFtpFile.downloadByOK(ftpUtil, serverFolder, loacalDownSaveFolder)) {
				passFile(loacalDownSaveFolder);
			}
		}
		long end = System.currentTimeMillis();
		log.info("importIdentityCar执行完成..用时：" + (end - start) + "m");
	}

	private void passFile(String loacalDownSaveFolder) throws IOException {
		String localBakFolder = loacalDownSaveFolder + File.separator+ "BAK";
		File bakFolder = new File(localBakFolder);
		if (!bakFolder.exists()) {
			bakFolder.mkdir();
		}
		
		File local = new File(loacalDownSaveFolder);
		File[] files = local.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".xlsx")||name.endsWith(".xls");
			}
		});

		for (File file : files) {
			try {
				List<IdentityCardModel> list=passExcelData(file);
				identityCardService.batchUpdate(list);
				FileUtils.moveFile(file, new File(bakFolder
						+ File.separator + file.getName() + Math.random()));
			} catch (Exception e) {
				log.error("异常:"+e);
			}
		}
	}
	
	private List<IdentityCardModel> passExcelData(File file) throws Exception{
		List<IdentityCardModel> list=new ArrayList<IdentityCardModel>();
		String fileName=file.getName();
		if (fileName.endsWith(".xlsx")) {
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
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
				IdentityCardModel model = new IdentityCardModel();
				for (int columnIndex = 0, size = row.getLastCellNum(); columnIndex <= size; columnIndex++) {
					cell = row.getCell(columnIndex);
					String value = "";
					if (cell != null) {
						switch (cell.getCellType()) {
						case HSSFCell.CELL_TYPE_STRING:
							value = cell.getStringCellValue();
							break;
						case HSSFCell.CELL_TYPE_NUMERIC:
							value = new DecimalFormat("0").format(cell.getNumericCellValue());
							break;
						default:
							value = "";
						}
						// 每次循环输出：第几行的第几列的值（如：0,0，第一行第一列）
						log.info(rowIndex + "," + columnIndex + ":" + value);

						value = value.trim();
						if (columnIndex == 0) {
							model.setCode(value);// 申请书编号
						} else if (columnIndex == 1) {
							model.setAddress(value);// 中文名
						}
					}
				}
				if (StringUtils.isNotEmpty(model.getCode())
						&& StringUtils.isNotEmpty(model.getAddress())) {
					list.add(model);
				}
			}
		} else {
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(file));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFCell cell = null;
			HSSFSheet st = wb.getSheetAt(0);
			for (int rowIndex = 1; rowIndex <= st.getLastRowNum(); rowIndex++) {
				HSSFRow row = st.getRow(rowIndex);
				if (row == null) {
					continue;
				}
				IdentityCardModel model = new IdentityCardModel();
				for (int columnIndex = 0, size = row.getLastCellNum(); columnIndex <= size; columnIndex++) {
					cell = row.getCell(columnIndex);
					String value = "";
					if (cell != null) {
						switch (cell.getCellType()) {
						case HSSFCell.CELL_TYPE_STRING:
							value = cell.getStringCellValue();
							break;
						case HSSFCell.CELL_TYPE_NUMERIC:
							value = new DecimalFormat("0").format(cell.getNumericCellValue());
							break;
						default:
							value = "";
						}
						// 每次循环输出：第几行的第几列的值（如：0,0，第一行第一列）
						log.info(rowIndex + "," + columnIndex + ":" + value);
						value = value.trim();
						if (columnIndex == 0) {
							model.setCode(value);// 申请书编号
						} else if (columnIndex == 1) {
							model.setAddress(value);// 中文名
						}
					}
				}
				if (StringUtils.isNotEmpty(model.getCode())
						&& StringUtils.isNotEmpty(model.getAddress())) {
					list.add(model);
				}
			}
		}
		return list;
	}

	private boolean downloadFile(String serverFolder,
			String loacalDownSaveFolder) {
		
		String serverBakFolder = serverFolder + File.separator + "BAK";
		// 下载文件
		FtpUtil ftpUtil = new FtpUtil();
		ftpUtil.initFtpUtil();

		File local = new File(loacalDownSaveFolder);
		if (!local.exists()) {
			local.mkdir();
		}
		String serverFileName = "";
		List serverFileList = ftpUtil.getFileList(serverFolder,
				new String[] { ".xlsx",".xls" });
		if (serverFileList != null && serverFileList.size() > 0) {
			for (int i = 0; i < serverFileList.size(); i++) {
				String temp = (String) serverFileList.get(i);
				serverFileName = temp.substring(
						temp.lastIndexOf(File.separator) + 1, temp.length());
				ftpUtil.downloadFile(serverFolder + File.separator
						+ serverFileName, loacalDownSaveFolder + File.separator
						+ serverFileName);
				log.info("serverFileName = " + serverFileName);

				ftpUtil.moveFtpServerFile(serverFolder + File.separator
						+ serverFileName, serverBakFolder + File.separator
						+ serverFileName);
			}
		}
		ftpUtil.closeServer();
		return serverFileList != null &&serverFileList.size() > 0;
	}

}
