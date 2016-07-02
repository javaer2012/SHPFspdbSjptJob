package com.ideal.spdb.thirdinfo.work.batchimport;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sound.sampled.Line;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.ideal.spdb.thirdinfo.dao.IEucVehicleExcelDao;
import com.ideal.spdb.thirdinfo.model.CapsBlackListModel;
import com.ideal.spdb.thirdinfo.service.ICapsBlackListService;
import com.ideal.spdb.thirdinfo.util.DownloadFtpFile;
import com.ideal.spdb.thirdinfo.work.util.FtpUtil;
import com.ideal.spdb.thirdinfo.work.util.RequestIp;
import com.ideal.spdb.utils.AppConfigFile;

public class CapsBlackListWork {
	@Inject
	IEucVehicleExcelDao dao;
	@Inject
	ICapsBlackListService service;
	private static final Logger log = Logger.getLogger(CapsBlackListWork.class);

	public void CapsListImport() throws Exception {
		log.info("<<<<<<<<<<<===开始CapsListImport执行===>>>>>>>>>>>>");
		long start = System.currentTimeMillis();
		String localhostIp = RequestIp.getLocalhostIp();
		String serverIp = this.dao.getConfigIP("SERVER_IP");
		log.info("localhostIp = " + localhostIp);
		log.info("serverIp = " + serverIp);
		if (localhostIp.equals(serverIp)) {
			try {
				log.info("IP比较相同,执行" + localhostIp + "服务器程序");

				log.info("开始处理批量导入！！");
				// ftp存放excel文件的目录
				String serverFolder = AppConfigFile.getInstance().getValue("FTP_CAPSLIST");
				// 下载文件存放位置
				String loacalDownSaveFolder = AppConfigFile.getInstance().getValue("LOCAL_CAPSLIST");
				String loacalBakSaveFolder = AppConfigFile.getInstance().getValue("LOCAL_CAPSLIST_BAK");
				// 下载文件
				FtpUtil ftpUtil = new FtpUtil();
				ftpUtil.initFtpUtil();
				if (DownloadFtpFile.downloadByOK(ftpUtil, serverFolder, loacalDownSaveFolder)) {
					File[] files = new File(loacalDownSaveFolder).listFiles(new FilenameFilter() {
						@Override
						public boolean accept(File dir, String name) {
							return name.endsWith(".txt");
						}
					});
					
					ftpUtil.closeServer();
					for (File file : files) {
						
						List<CapsBlackListModel> datalist = service.parseTxtData(file);
						DownloadFtpFile.moveLocalFile2Bak(file, loacalBakSaveFolder);
						if (datalist.isEmpty()) {
							log.info("没有需要插入的数据");
							continue;
						}
						List<String> list = service.initProcess(datalist);
						
						uploadRptFile(ftpUtil, datalist.size(), list, loacalBakSaveFolder + File.separator + "rpt" + file.getName(), serverFolder + File.separator + "bak"  + File.separator + "rpt" + file.getName());
					}
				}

			} catch (Exception e) {
				log.error("执行当即切换,所报的错误信息-->" + e);
			}
		}
		long end = System.currentTimeMillis();
		log.info("CapsListImport执行完成..用时：" + (end - start) + "m");
	}

	private static void uploadRptFile(FtpUtil ftpUtil, int count, List<String> list, String loacalRptFile, String serverRptFile) {
		ftpUtil.initFtpUtil();
		StringBuffer sb = new StringBuffer();
		sb.append("导入成功数：");
		sb.append(count - list.size());
		sb.append("\r\n");
		sb.append("导入失败数：");
		sb.append(list.size());
		sb.append("\r\n");
		if (list.size() > 0) {
			sb.append("失败身份证号：");
			for (int i = 0; i < list.size(); i++) {
				sb.append("\r\n");
				sb.append(list.get(i));
			}
		}
		File f = new File(loacalRptFile);
		try {
			FileUtils.writeStringToFile(f, sb.toString() ,"GBK");
		} catch (IOException e) {
			log.error("生成 rpt文件错误：" + e);
		}
		ftpUtil.upload(loacalRptFile, serverRptFile);

	}

}
