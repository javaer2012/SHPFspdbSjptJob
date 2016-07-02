package com.ideal.spdb.thirdinfo.work.batchimport;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;
import com.ideal.spdb.thirdinfo.dao.IEucVehicleExcelDao;
import com.ideal.spdb.thirdinfo.model.MobileNumberModel;
import com.ideal.spdb.thirdinfo.service.MobileNumberService;
import com.ideal.spdb.thirdinfo.util.DownloadFtpFile;
import com.ideal.spdb.thirdinfo.work.util.FtpUtil;
import com.ideal.spdb.thirdinfo.work.util.RequestIp;
import com.ideal.spdb.utils.AppConfigFile;

public class MobileNumberWork {

	private static final Logger log = Logger.getLogger(MobileNumberWork.class);
	@Autowired
	private IEucVehicleExcelDao vehicleDao;
	@Autowired
	private MobileNumberService mobileNumberService;

	public void importMobileNumber() throws Exception {
		log.info("开始importMobileNumber执行");
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
			String serverFolder = ftproot+ AppConfigFile.getInstance().getValue("SJGSD_INPUT");
			// 下载文件存放位置
			String loacalDownSaveFolder = AppConfigFile.getInstance().getValue("SJGSD_INPUT_LOCAL");
			FtpUtil ftpUtil = new FtpUtil();
			ftpUtil.initFtpUtil();
			if (DownloadFtpFile.downloadByOK(ftpUtil, serverFolder, loacalDownSaveFolder)) {
				passFile(loacalDownSaveFolder);
			}
		}
		long end = System.currentTimeMillis();
		log.info("importMobileNumber执行完成..用时：" + (end - start) + "m");
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
				return name.endsWith(".mdb");
			}
		});

		for (File file : files) {
			Database db = DatabaseBuilder.open(file);
			Table table = db.getTable("Dm_Mobile");
			List<MobileNumberModel> list = new ArrayList<MobileNumberModel>();
			MobileNumberModel mobile = null;
			for (Row row : table) {
				mobile = new MobileNumberModel();
				mobile.setMobileNumber(row.getString("MobileNumber"));
				mobile.setMobileArea(row.getString("MobileArea"));
				mobile.setMobileType(row.getString("MobileType"));
				mobile.setAreaCode(row.getString("AreaCode"));
				mobile.setPostCode(row.getString("PostCode"));
				list.add(mobile);
			}
			db.close();
			mobileNumberService.batchUpdate(list);
			FileUtils.moveFile(file, new File(bakFolder
					+ File.separator + file.getName() + Math.random()));
		}
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
				new String[] { ".mdb" });
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
