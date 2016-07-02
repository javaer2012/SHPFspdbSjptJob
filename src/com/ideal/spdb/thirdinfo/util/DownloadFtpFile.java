package com.ideal.spdb.thirdinfo.util;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.ideal.spdb.thirdinfo.work.util.FtpUtil;

public class DownloadFtpFile {
	private static final Logger log = Logger.getLogger(DownloadFtpFile.class);
	/**
	 * 根据.ok下载文件
	 * @param ftpUtil
	 * @param serverFolderPath 服务器目录
	 * @param loacalFolderPath 本地目录
	 * @return
	 */
	public static boolean downloadByOK(FtpUtil ftpUtil,
			String serverFolderPath, String loacalFolderPath) {
		boolean flag = false;
		if (downloadBySuffix(ftpUtil, serverFolderPath, loacalFolderPath,
				new String[] { ".ok" })) {
			File[] okFiles = new File(loacalFolderPath).listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.endsWith(".ok");
				}
			});
			String serverBakFolderPath=serverFolderPath + File.separator + "BAK";
			for (File OkFile : okFiles) {
				downloadServerFile(ftpUtil, serverFolderPath, serverBakFolderPath, loacalFolderPath, getFileNameByOK(OkFile));
				log.info(OkFile.getPath()+"文件下载完毕.OK文件删除");
				OkFile.delete();
			}
			flag=true;
		}
		return flag;
	}

	/**
	 * 根据后缀下载文件
	 * @param ftpUtil
	 * @param serverFolderPath 服务器目录
	 * @param loacalFolderPath 本地目录
	 * @param suffixs 文件后缀
	 * @return
	 */
	public static boolean downloadBySuffix(FtpUtil ftpUtil,
			String serverFolderPath, String loacalFolderPath, String[] suffixs) {
		boolean flag = false;
		if (ftpUtil == null) {
			throw new RuntimeException("FtpUtil不能为空!");
		}
		if (StringUtils.isEmpty(serverFolderPath)) {
			throw new RuntimeException("serverFolderPath不能为空!");
		}
		if (StringUtils.isEmpty(loacalFolderPath)) {
			throw new RuntimeException("loacalFolderPath不能为空!");
		}
		if (suffixs == null || suffixs.length == 0) {
			throw new RuntimeException("suffixs不能为空!");
		}
		File loacalFolder = new File(loacalFolderPath);
		if (!loacalFolder.exists()) {
			loacalFolder.mkdirs();
		}
		serverFolderPath=File.separator+serverFolderPath;
		loacalFolderPath=File.separator+loacalFolderPath;
		
		String serverBakFolderPath=serverFolderPath + File.separator + "BAK";
		@SuppressWarnings("unchecked")
		List<String> serverFileList = ftpUtil.getFileList(serverFolderPath,suffixs);
		if (serverFileList != null && serverFileList.size() > 0) {
			for (String temp : serverFileList) {
				downloadServerFile(ftpUtil, serverFolderPath, serverBakFolderPath, loacalFolderPath, temp.substring(temp.lastIndexOf(File.separator) + 1, temp.length()));
			}
			flag = true;
		}
		return flag;
	}
	/**
	 * 下载文件
	 * @param ftpUtil
	 * @param serverFolderPath
	 * @param serverBakFolderPath
	 * @param loacalFolderPath
	 * @param serverFileName
	 */
	private static void downloadServerFile(FtpUtil ftpUtil,String serverFolderPath,String serverBakFolderPath,String loacalFolderPath,String serverFileName){
		ftpUtil.downloadFile(serverFolderPath +File.separator+ serverFileName,loacalFolderPath +File.separator+serverFileName);
		moveServerFile2Bak(ftpUtil, serverFolderPath, serverBakFolderPath, serverFileName);
	}
	
	/**
	 * 移动文件到BAK目录
	 * @param ftpUtil
	 * @param serverFolderPath
	 * @param serverBakFolderPath
	 * @param fileName
	 */
	private static void moveServerFile2Bak(FtpUtil ftpUtil, String serverFolderPath,String serverBakFolderPath,String fileName) {
		if (!ftpUtil.isDirExist(serverBakFolderPath)) {// 判断服务器是否存在此目录，不存在创建
			ftpUtil.createDir(serverBakFolderPath);
		}
		ftpUtil.moveFtpServerFile(serverFolderPath + File.separator+ fileName, serverBakFolderPath + File.separator+ fileName);
	}
	/**
	 * 移动文件到BAK目录
	 * @param ftpUtil
	 * @param serverFolderPath
	 * @param serverBakFolderPath
	 * @param fileName
	 */
	public static void moveLocalFile2Bak(File srcFile,String localBakFolder) {
		try {
			FileUtils.moveFile(srcFile, new File(localBakFolder+ File.separator + srcFile.getName() + Math.random()));
		} catch (IOException e) {
			log.error("moveLocalFile2Bak错误", e);
		}
	}

	/**
	 * 根据.OK文件获取文件名
	 * @param OkFile
	 * @return
	 */
	private static String getFileNameByOK(File OkFile){
		String okFileName=OkFile.getName();
		return okFileName.substring(0,okFileName.lastIndexOf(".ok"));
	}
	
	public static void main(String[] args) {
		FtpUtil ftpUtil = new FtpUtil();
		ftpUtil.initFtpUtil();
		downloadByOK(ftpUtil, "\\SJPT\\INPUT\\Tencent_Credit", "D:\\MYTEST\\TEST");
	}
}
