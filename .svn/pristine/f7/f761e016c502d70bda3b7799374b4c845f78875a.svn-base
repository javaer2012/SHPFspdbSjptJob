/**  
 *@Copyright:Copyright (c) 2011 - 2100  
 *@Company:FBI
 */
package com.ideal.spdb.thirdinfo.work.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Vector;


import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;

import com.ideal.spdb.thirdinfo.model.ThirdinfoModel;
import com.ideal.spdb.thirdinfo.writemodel.ThirdInfoWriteModel;

/**
 *@Author: AlexHe
 *@CrateDate:2012-8-13
 *@Version:1.1.0
 *@FunctionName:
 *@Description :
 *@Modify History: ----------------------------------
 * 
 */
public class FileOperateUtil {

	private static Logger log = Logger.getLogger(FileOperateUtil.class);

	public static FileOperateUtil instance = null;

	public static PropertiesConfiguration propertiesConfig = null;

	public static int LOCAL_ROOT_FOLDER = 0;// 本地根目录
	public static int LOCAL_DOWN_FOLDER = 1;// 下载文件后保存的本地目录
	public static int LOCAL_DOWN_FOLDER_BAK = 2;// 下载后的文件分析后 移动到备份目录
	public static int LOCAL_ROOT_FOLDER_TEMPIANGE=520;//本地临时存放图片
	public static int FTP_ROOT_FOLDER = 3;// FTP根目录

	public static int FTP_DOWN_FOLDER_APWX = 4;// FTP服务器上的需要下载的文件的 APWX目录
	public static int FTP_DOWN_FOLDER_APWX_BAK = 5;// FTP服务器上的需要下载的文件的 APWX目录
	// 的备份目录

	public static int FTP_DOWN_FOLDER_APDS = 6;// FTP服务器上的需要下载的文件的 APDS目录
	public static int FTP_DOWN_FOLDER_APDS_BAK = 7;// FTP服务器上的需要下载的文件的APDS目录
	// 的备份目录

	public static int FTP_DOWN_FOLDER_APPD = 19;// FTP服务器上的需要下载的文件的 APPD目录
	public static int FTP_DOWN_FOLDER_APPD_BAK = 20;// FTP服务器上的需要下载的文件的 APPD目录
	// 的备份目录

	public static int FTP_DOWN_FOLDER_APQF = 28;// FTP服务器上的需要下载的文件的 APQF目录
	public static int FTP_DOWN_FOLDER_APQF_BAK = 29;// FTP服务器上的需要下载的文件的 APQF目录
	// 的备份目录
	
	public static int FTP_DOWN_FOLDER_APZX = 31;// FTP服务器上的需要下载的文件的 APZX目录
	public static int FTP_DOWN_FOLDER_APZX_BAK = 32;// FTP服务器上的需要下载的文件的 APZX目录
	
	public static int FTP_DOWN_FOLDER_APZX_FHSP = 311;// FTP服务器上的需要下载的文件的 网站分行目录
	public static int FTP_DOWN_FOLDER_APZX_FHSP_BAK = 322;// FTP服务器上的需要下载的文件的网站分行目录
	// 的备份目录
	
	public static int FTP_DOWN_FOLDER_FHSP = 41;// FTP服务器上的需要下载的文件的 FHSP目录
	public static int FTP_DOWN_FOLDER_FHSP_BAK = 42;// FTP服务器上的需要下载的文件的 FHSP目录
	
	public static int LOCAL_ROOT_FOLDER_BAK = 8;// 本地根目录下的备份目录
	public static int LOCAL_ROOT_FOLDER_YUYUE=333;//预约
	public static int LOCAL_ROOT_FOLDER_TEMPLETE = 9;// 模版文件路径
	public static int LOCAL_ROOT_FOLDER_TEMPLETE_BAK = 25;// 模版文件路径的备份

	public static int LOCAL_ROOT_FOLDER_TEMP = 10;// 临时目录

	public static int LOCAL_ROOT_FOLDER_TIF = 11;// tif目录（通用的）
	public static int LOCAL_ROOT_FOLDER_WXTIF = 26;// tif目录（五星的）
	public static int LOCAL_ROOT_FOLDER_TIFBAK = 12;// tif目录
	public static int LOCAL_ROOT_FOLDER_WZTIF = 36;//tif目录（网站的）
	public static int LOCAL_ROOT_FOLDER_QFTIF = 37;//汽车的tif目录
	public static int LOCAL_ROOT_FOLDER_CMTIF = 43;//CMTIF的tif目录

	public static int LOACAL_FOLDER_APP_FILE_APWX = 14;// 本地生成的文件目录
	public static int LOACAL_FOLDER_APP_FILE_APDS = 15;// APDS文件目录
	public static int LOACAL_FOLDER_APP_FILE_APPD = 21;// APPD文件目录
	public static int LOACAL_FOLDER_APP_FILE_APQF = 27;//汽车的文件目录
	public static int LOACAL_FOLDER_APP_FILE_APZX = 30;//网站的文件目录
	public static int LOACAL_FOLDER_APP_FILE_FHSP = 44;//FHSP文件目录

	public static int FTP_ROOT_FOLDER_DOWN_ZIP_RESULT = 16;// 下载zip 以及影响文件的分析结果
	public static int FTP_ROOT_FOLDER_ZIP = 13;// FTP（五星） 上存放 zip 的目录
	public static int FTP_ROOT_FOLDER_ZIP_ERROR = 17;// FTP 上存放 zip 的目录
	public static int FTP_ROOT_FOLDER_DOWN_ZIP_RESULT_WXBAK = 18;// FTP 上存放 ERROR文件夹的备份

	public static int FTP_ROOT_FOLDER_DOWN_ZIP_RESULT_PD = 23;// 下载zip 以及影响文件的分析结果
	public static int FTP_ROOT_FOLDER_ZIP_PD = 22;// FTP(普通进件) 上存放 zip 的目录
	public static int FTP_ROOT_FOLDER_DOWN_ZIP_RESULT_PDBAK_PD = 24;// FTP(PD) 上存放 ERROR文件夹的备份
	//第三方网站 
	public static int FTP_ROOT_FOLDER_DOWN_ZIP_RESULT_ZX = 34;// 下载zip 以及影响文件的分析结果
	public static int FTP_ROOT_FOLDER_ZIP_ZX = 33;// FTP(网站) 上存放 zip 的目录
	public static int FTP_ROOT_FOLDER_DOWN_ZIP_RESULT_PDBAK_ZX = 35;// FTP(PD) 上存放 ERROR文件夹的备份
   //ftp汽车tif
	public static int FTP_ROOT_FOLDER_DOWN_ZIP_RESULT_QF = 38;// 下载zip 以及影响文件的分析结果
	public static int FTP_ROOT_FOLDER_ZIP_QF = 39;// FTP(汽车) 上存放 zip 的目录
	public static int FTP_ROOT_FOLDER_DOWN_ZIP_RESULT_PDBAK_QF = 40;// FTP(汽车) 上存放 ERROR文件夹的备份
	//万用金FTP上传目录
	public static int FTP_ROOT_FOLDER_WANYONJIN_UP = 46;
	//万用金FTP上传目录
	public static int FTP_ROOT_FOLDER_WUKAURL_UP = 47;
	//公安网信息
	public static int FTP_ROOT_FOLDER_PUBLICSECURITY = 48;
	
	public static int FTP_ROOT_FOLDER_JUXINLIBLACKLIST = 49;
	//黑名单实时自动导入审批Caps系统
	public static int FTP_ROOT_FOLDER_OUTPUTBLACKLISTCAPS = 50;
	//策略编码上传
	public static int FTP_ROOT_FOLDER_STRATEGYCODE = 51;

	
	// public static int FILE_APDS_NAME = 001;// APDS文件名
	// public static int FILE_APWX_NAME = 002;// APWX文件名
	// public static int FILE_XLS_NAME = 003;// APWX文件名
	
	//word转tif的共享图片目录
	//pat
	public static String LOACAL_FTP_WORD = "\\\\172.19.191.30\\msmsappserv$\\share\\myRecieveFiles\\unZip\\";
	//uat
	//public static String  LOACAL_FTP_WORD="\\\\172.30.112.100\\share1\\myRecieveFiles\\unZip\\";
	public FileOperateUtil() {
	};

	public synchronized static FileOperateUtil getInstance() {
		if (instance == null) {
			return instance = new FileOperateUtil();
		}
		return instance;

	}


	/**
	 * @param i
	 *            LOCAL_ROOT_FOLDER LOCAL_DOWN_FOLDER
	 * @return
	 * @Description:
	 */
	public synchronized String getFolderName(int i) {
		String strPath = "";
		if (i == LOCAL_ROOT_FOLDER) {
			strPath = AppConfigFile.getInstance().getValue("LOCAL_ROOT");
			return strPath;
		}
		if (i == LOCAL_DOWN_FOLDER) {
			strPath = AppConfigFile.getInstance().getValue("LOCAL_ROOT");
			return strPath + "/DOWN/";
		}
		if (i == LOCAL_DOWN_FOLDER_BAK) {
			strPath = AppConfigFile.getInstance().getValue("LOCAL_ROOT");
			return strPath + "/DOWN/BAK/";
		}
		
		if (i == LOCAL_ROOT_FOLDER_BAK) {
			strPath = AppConfigFile.getInstance().getValue("LOCAL_ROOT");
			return strPath + "/BAK/";
		}
		if (i == LOCAL_ROOT_FOLDER_TEMPIANGE) {
			strPath = AppConfigFile.getInstance().getValue("LOCAL_ROOT");
			return strPath + "/TEMPIANGE/";
		}
		if (i == LOCAL_ROOT_FOLDER_TEMPLETE) {
			strPath = AppConfigFile.getInstance().getValue("LOCAL_ROOT");
			return strPath + "/TEMPLETE/";
		}
		if (i == LOCAL_ROOT_FOLDER_YUYUE) {
			strPath = AppConfigFile.getInstance().getValue("LOCAL_ROOT");
			return strPath + "/YUYUE_BAK/";
		}
		if (i == LOCAL_ROOT_FOLDER_TEMPLETE_BAK) {
			strPath = AppConfigFile.getInstance().getValue("LOCAL_ROOT");
			return strPath + "/TEMPLETE_BAK/";
		}

		if (i == LOCAL_ROOT_FOLDER_TEMP) {
			strPath = AppConfigFile.getInstance().getValue("LOCAL_ROOT");
			return strPath + "/TEMP/";
		}
		if (i == LOCAL_ROOT_FOLDER_TIF) {
			strPath = AppConfigFile.getInstance().getValue("LOCAL_ROOT");
			return strPath + "/TIF/";
		}
		if (i == LOCAL_ROOT_FOLDER_WXTIF) {
			strPath = AppConfigFile.getInstance().getValue("LOCAL_ROOT");
			return strPath + "/WXTIF/";
		}

		if (i == LOCAL_ROOT_FOLDER_WZTIF) {
			strPath = AppConfigFile.getInstance().getValue("LOCAL_ROOT");
			return strPath + "/WZTIF/";
		}
		if (i == LOCAL_ROOT_FOLDER_TIFBAK) {
			strPath = AppConfigFile.getInstance().getValue("LOCAL_ROOT");
			return strPath + "/TIF_BAK/";
		}

		if (i == LOCAL_ROOT_FOLDER_QFTIF) {
			strPath = AppConfigFile.getInstance().getValue("LOCAL_ROOT");
			return strPath + "/QFTIF/";
		}
		
		if (i == LOCAL_ROOT_FOLDER_CMTIF) {
			strPath = AppConfigFile.getInstance().getValue("LOCAL_ROOT");
			return strPath + "/CMTIF/";
		}
		if (i == LOACAL_FOLDER_APP_FILE_APDS) {
			strPath = AppConfigFile.getInstance().getValue("LOCAL_ROOT");
			return strPath + "/APP_FILE_APDS/";
		}

		if (i == LOACAL_FOLDER_APP_FILE_APWX) {
			strPath = AppConfigFile.getInstance().getValue("LOCAL_ROOT");
			return strPath + "/APP_FILE_APWX/";
		}
		if (i == LOACAL_FOLDER_APP_FILE_APPD) {
			strPath = AppConfigFile.getInstance().getValue("LOCAL_ROOT");
			return strPath + "/APP_FILE_APPD/";
		}
		if (i == LOACAL_FOLDER_APP_FILE_APQF) {
			strPath = AppConfigFile.getInstance().getValue("LOCAL_ROOT");
			return strPath + "/APP_FILE_APQF/";

		}
		if (i == LOACAL_FOLDER_APP_FILE_APZX) {
			strPath = AppConfigFile.getInstance().getValue("LOCAL_ROOT");
			log.info("====LOCAL_ROOT==="+strPath);
			return strPath + "/APP_FILE_APZX/";
		}
		if (i == LOACAL_FOLDER_APP_FILE_FHSP) {
			strPath = AppConfigFile.getInstance().getValue("LOCAL_ROOT");
			return strPath + "/APP_FILE_FHSP/";
		}

		if (i == FTP_ROOT_FOLDER) {
			return strPath = AppConfigFile.getInstance().getValue("FTP_ROOT");
		}
		if (i == FTP_DOWN_FOLDER_APWX) {
			strPath = AppConfigFile.getInstance().getValue("FTP_ROOT");
			return strPath + "/APWX/";
		}
		if (i == FTP_DOWN_FOLDER_APWX_BAK) {
			strPath = AppConfigFile.getInstance().getValue("FTP_ROOT");
			return strPath + "/APWX/APWX_BAK/";
		}
		if (i == FTP_DOWN_FOLDER_APPD) {
			strPath = AppConfigFile.getInstance().getValue("FTP_ROOT");
			return strPath + "/APPD/";
		}
		if (i == FTP_DOWN_FOLDER_APPD_BAK) {
			strPath = AppConfigFile.getInstance().getValue("FTP_ROOT");
			return strPath + "/APWX/APPD_BAK/";
		}
		if (i == FTP_DOWN_FOLDER_APQF) {
			strPath = AppConfigFile.getInstance().getValue("FTP_ROOT");
			return strPath + "/APQF/";
		}
		if (i == FTP_DOWN_FOLDER_APQF_BAK) {
			strPath = AppConfigFile.getInstance().getValue("FTP_ROOT");
			return strPath + "/APQF/APQF_BAK/";
		}
		if (i == FTP_DOWN_FOLDER_APZX) {
			strPath = AppConfigFile.getInstance().getValue("FTP_ROOT");
			return strPath + "/APWZ/";
		}
		if (i == FTP_DOWN_FOLDER_APZX_FHSP) {
			strPath = AppConfigFile.getInstance().getValue("FTP_ROOT");
			return strPath + "/APWZ/FHSP/";
		}
		if (i == FTP_DOWN_FOLDER_APZX_FHSP_BAK) {
			strPath = AppConfigFile.getInstance().getValue("FTP_ROOT");
			return strPath + "/APWZ/FHSP/FHSP_BAK/";
		}
		if (i == FTP_DOWN_FOLDER_APZX_BAK) {
			strPath = AppConfigFile.getInstance().getValue("FTP_ROOT");
			return strPath + "/APWZ/APWZ_BAK/";
		}

		if (i == FTP_DOWN_FOLDER_APDS) {
			strPath = AppConfigFile.getInstance().getValue("FTP_ROOT");
			return strPath + "/APDS/";
		}
		if (i == FTP_DOWN_FOLDER_APDS_BAK) {
			strPath = AppConfigFile.getInstance().getValue("FTP_ROOT");
			return strPath + "/APDS/APDS_BAK/";
		}
		if (i == FTP_DOWN_FOLDER_FHSP) {
			strPath = AppConfigFile.getInstance().getValue("FTP_ROOT");
			return strPath + "/APQF/FHSP/";
		}
		if (i == FTP_DOWN_FOLDER_FHSP_BAK) {
			strPath = AppConfigFile.getInstance().getValue("FTP_ROOT");
			return strPath + "/APQF/FHSP/FHSP_BAK/";
		}
		
		// 影像文件在另外的FTP(WX)
		if (i == FTP_ROOT_FOLDER_ZIP) {
			strPath = "/FIVESTAR_ZIP";
			return strPath + "/";
		}

		if (i == FTP_ROOT_FOLDER_DOWN_ZIP_RESULT) {
			strPath = "/FIVESTAR_ZIP_RET";
			return strPath + "/";
		}

		if (i == FTP_ROOT_FOLDER_DOWN_ZIP_RESULT_WXBAK) {
			strPath = "/WXBAK";
			return strPath + "/";
		}

		// 影像文件在另外的FTP(PD)
		if (i == FTP_ROOT_FOLDER_ZIP_PD) {
			strPath = "/CARISMT_ZIP";
			return strPath + "/";
		}
		
		if (i == FTP_ROOT_FOLDER_DOWN_ZIP_RESULT_PD) {
			strPath = "/CARISMT_ZIP_RET";
			return strPath + "/";
		}

		if (i == FTP_ROOT_FOLDER_DOWN_ZIP_RESULT_PDBAK_PD) {
			strPath = "/CARISMT_ZIP_BAK";
			return strPath + "/";
		}
		
		//		 影像文件在另外的FTP(ZX)
		if (i == FTP_ROOT_FOLDER_ZIP_ZX) {
			strPath = "/WECHAT_ZIP";
			return strPath + "/";
		}

		if (i == FTP_ROOT_FOLDER_DOWN_ZIP_RESULT_ZX) {
			strPath = "/WECHAT_ZIP_RET";
			return strPath + "/";
		}
		
		if (i == FTP_ROOT_FOLDER_DOWN_ZIP_RESULT_PDBAK_ZX) {
			strPath = "/WZBAK";
			return strPath + "/";
		}
		
		//汽车
		if (i == FTP_ROOT_FOLDER_ZIP_QF) {
			strPath = "/CARISMT_ZIP";
			return strPath + "/";
		}

		if (i == FTP_ROOT_FOLDER_DOWN_ZIP_RESULT_QF) {
			strPath = "/CARISMT_ZIP_RET";
			return strPath + "/";
		}
		
		if (i == FTP_ROOT_FOLDER_DOWN_ZIP_RESULT_PDBAK_QF) {
			strPath = "/CARISMT_ZIP_BAK";
			return strPath + "/";
		}
		
		if (i == FTP_ROOT_FOLDER_WANYONJIN_UP) {
			strPath = "/DEFQ";
			return strPath + "/";
		}
		
		if (i == FTP_ROOT_FOLDER_WUKAURL_UP) {
//			strPath = AppConfigFile.getInstance().getValue("FTP_WUKA_IMG");
			strPath = "/wukafenqi";
			return strPath + "/";
		}
		
		if (i ==  FTP_ROOT_FOLDER_PUBLICSECURITY) {
//			strPath = AppConfigFile.getInstance().getValue("FTP_WUKA_IMG");
			strPath = "/WZXS/TONGYONG";
			return strPath + "/";
		}
		
		if(i == FTP_ROOT_FOLDER_JUXINLIBLACKLIST){
			strPath = "/SJPT/ONPUT/HMD";
			return strPath + "/";
		}
		
		if(i == FTP_ROOT_FOLDER_OUTPUTBLACKLISTCAPS){
			strPath = "/cip/cip";
			return strPath + "/";
		}
		
		if (i ==  FTP_ROOT_FOLDER_STRATEGYCODE) {
//			strPath = AppConfigFile.getInstance().getValue("FTP_WUKA_IMG");
			strPath = "/COM/CELVBIANMA";
			return strPath + "/";
		}
		
		return strPath;
	}

	public String getRandomNumber() {
		Random random = new Random();
		int n = Math.abs(random.nextInt()) % 10;
		return String.valueOf(n);
	}

	// public List getArrayFileList(String folder) {
	// List list = new ArrayList();
	//
	// }

	/**
	 * @param outFileLists
	 * @param filePath
	 * @param subFolderFlag
	 * @return
	 * @Description: 获取目录下的文件.
	 */
	public boolean getFileList(Vector<String> outFileLists, String filePath, boolean subFolderFlag) {
		if (outFileLists == null) {
			outFileLists = new Vector<String>();
		}
		File file = new File(filePath);
		if (file.exists()) {
			File files[] = file.listFiles();
			if (subFolderFlag) {
				for (int i = 0; i < files.length; i++) {
					if (files[i].isFile()) {
						outFileLists.add(filePath + files[i].getName());
					} else if (files[i].isDirectory()) {
						getFileList(outFileLists, filePath + "//" + files[i].getName(), subFolderFlag);
					}
				}
			} else {
				for (int i = 0; i < files.length; i++) {
					if (files[i].isFile()) {
						outFileLists.add(files[i].getName());
					}
				}
			}
		} else {
			return false;
		}
		return true;
	}



	/**
	 * @param filePathAndName
	 *            文件路径+名称
	 * @return
	 * @Description: 生成信号文件
	 */
	public boolean bliudSignalFile(String filePathAndName) {
		boolean ret = false;

		if (filePathAndName != null && !"".equals(filePathAndName)) {

			try {

				FileWriter fw = new FileWriter(filePathAndName);

				// 写入文件 （信号文件 内容为空）
				fw.write("");

				if (fw != null) {
					fw.close();
				}
				ret = true;
			} catch (IOException e) {
				log.error("bliudSignalFile方法异常" + e);
			}

		}

		return ret;
	}

	/**
	 * @param path
	 *            文件路径
	 * @param suffix
	 *            后缀名, 为空则表示所有文件
	 * @param isdepth
	 *            是否遍历子目录
	 * @param zipMaxCount
	 * 			  集合的最大个数
	 * @return list
	 */
	public static List<String> getListFiles(String path, String suffix, boolean isdepth, int zipMaxCount) {
		List<String> lstFileNames = new ArrayList<String>();
		File file = new File(path);
		return FileOperateUtil.listFile(lstFileNames, file, suffix, isdepth, zipMaxCount);
	}

	/**
	 * @param path
	 *            文件路径
	 * @param suffix
	 *            后缀名, 为空则表示所有文件
	 * @param isdepth
	 *            是否遍历子目录
	 * @return list
	 */
	public static List<String> getListFiles(String path, String suffix, boolean isdepth) {
		List<String> lstFileNames = new ArrayList<String>();
		File file = new File(path);
		return FileOperateUtil.listFile(lstFileNames, file, suffix, isdepth, 0);
	}

	private static List<String> listFile(List<String> lstFileNames, File f, String suffix, boolean isdepth, int zipMaxCount) {
		List<String> tempList = null;
		// 若是目录, 采用递归的方法遍历子目录
		if (f.isDirectory()) {
			File[] t = f.listFiles();

			for (int i = 0; i < t.length; i++) {
				if (isdepth || t[i].isFile()) {
					tempList = listFile(lstFileNames, t[i], suffix, isdepth, zipMaxCount);
					if (zipMaxCount > 0 && tempList.size() >= zipMaxCount)
						return tempList;
				}
			}
		} else {
			String filePath = f.getAbsolutePath();
			if (!suffix.equals("")) {
				if (filePath.length() > suffix.length()) {
					// 获取ftp上文件的后缀
					String x = filePath.substring(filePath.length() - suffix.length(), filePath.length());
					// 判断后缀是否吻合
					if (x != null && x.equals(suffix)) {
						lstFileNames.add(filePath);
					}
					// int begIndex = filePath.lastIndexOf("."); //
					// 最后一个.(即后缀名前面的.)的索引
					// String tempsuffix = "";
					//
					// if (begIndex != -1) {
					// tempsuffix = filePath.substring(begIndex + 1, filePath
					// .length());
					// if (tempsuffix.equals(suffix)) {
					// lstFileNames.add(filePath);
					// }
					// }
				} else {
					lstFileNames.add(filePath);
				}
			}
		}
		return lstFileNames;
	}

	/**
	 * @param srcFile
	 * @return
	 * @Description: 移动文件到备份目录
	 */
	public static boolean moveToBakFolder(String srcFile) {
		String destPath = FileOperateUtil.getInstance().getFolderName(
				LOCAL_ROOT_FOLDER_BAK);
		return move(srcFile, destPath);
	}

	/**
	 * @param srcFile
	 *            要移动的源文件
	 * @param destPath
	 *            移动到目标文件夹
	 * @return
	 * @Description: 移动文件
	 */
	public static boolean move(String srcFile, String destPath) {
		// 目标文件如果存在，则重命名目标文件,删除目标文件后进行move;
		bakToBak(srcFile, destPath);
		// File (or directory) to be moved
		File file = new File(srcFile);
		// Destination directory
		File dir = new File(destPath);
		// Move file to new directory
		boolean success = file.renameTo(new File(dir, file.getName()));
		String retString = "";
		if (success) {
			retString = "成功";
		} else {
			retString = "失败";
		}
		//log.info("移动文件：" + srcFile + "到:" + destPath + ":::" + retString);
		if (!success) {
			//log.info("删除文件：" + srcFile + ":::" + file.delete());
		
		}

		return success;
	}

	/**
	 * @param srcFile
	 *            要移动的源文件
	 * @param destPath
	 *            移动到目标文件夹
	 * @Description: 目标文件如果存在，则重命名目标文件 然后删除目标文件
	 */
	public static boolean bakToBak(String srcFile, String destPath) {
		boolean ret = false;
		String destPathFile = "";
		// 获取目标文件的名称和路径
		if (srcFile.lastIndexOf("\\") > -1) {
			destPathFile = srcFile.substring(srcFile.lastIndexOf("\\") + 1, srcFile.length());
		}
		File file = new File(destPath + destPathFile);
		// 判断是否存在
		if (file.exists()) {
			SimpleDateFormat hdf = new SimpleDateFormat("HHmmss");
			String hms = hdf.format(new Date());
			File file1 = new File(destPath + destPathFile);
			File file2 = new File(destPath + destPathFile + hms);
			ret = file1.renameTo(file2);
			ret = file1.delete();
			log.info("目标文件：" + file.getName() + "已存在,重命名为:" + file2.getName() + ":::" + ret);
		}

		return ret;
	}

	/**
	 * @param filePathAndName
	 *            文件名称
	 * @return 返回LIST
	 * @Description: 在txt文件中获取申请书编号 .
	 */
	public List txtFileToList(String filePathAndName) {
		List list = new ArrayList();
		InputStreamReader read = null;
		try {
			File f = new File(filePathAndName);
			if (f.isFile() && f.exists()) {
				read = new InputStreamReader(new FileInputStream(f), "gb2312");
				BufferedReader br = new BufferedReader(read);
				String strLine = "";
				String shenqingshuCode = "";
				while ((strLine = br.readLine()) != null) {
					if (strLine.length() > 20) {
						shenqingshuCode = strLine.substring(4, 20);
					} else {
						shenqingshuCode = strLine.substring(4, 16);
					}
					if (shenqingshuCode.substring(10, 12).equals("01") || shenqingshuCode.substring(10, 12).equals("99") ) {  //modified by gbd 20141107
						list.add(shenqingshuCode.trim());
					}
				}
			}

			if (read != null) {

				read.close();
			}
		} catch (FileNotFoundException e) {
			log.error("文件 " + filePathAndName + "不存在." + e.toString());
		} catch (IOException e) {
			log.error("txtFileToList失败." + e.toString());
		}

		return list;
	}

	/**
	 * @param content
	 * @param placHead
	 * @return
	 * @Description: 利用位移 来截取字符串中的字段 并返回数据
	 */
	public static String[] disposeContent(String content, int[] placHead) {
		String res[] = new String[placHead.length];

		if (content.length() > placHead[placHead.length - 1]) {
			for (int i = 0; i < placHead.length; i++) {
				if (i < placHead.length - 1) {

					res[i] = content.substring((placHead[i] - 1), (placHead[i + 1] - 1)).trim();

				} else {
					res[i] = content.substring((placHead[i] - 1)).trim();
				}
			}
		}

		return res;
	}

	/**
	 * @param keyword
	 * @param filePathAndName
	 * @return
	 * @Description: 判断文件内容是否包含指定字符串
	 */
	public boolean isContainKeyword(String keyword, String filePathAndName) {
		boolean ret = false;
		InputStreamReader read = null;
		try {
			File f = new File(filePathAndName);
			if (f.isFile() && f.exists()) {
				read = new InputStreamReader(new FileInputStream(f), "gb2312");
				BufferedReader br = new BufferedReader(read);
				String strLine = "";
				while ((strLine = br.readLine()) != null) {
					// 判断是否包含,包含则返回TRUE
					int iPos = strLine.indexOf(keyword);
					if (iPos > 0) {

						return true;
					}
				}
			}
			if (read != null) {

				read.close();
			}
		} catch (FileNotFoundException e) {
			ret = false;
			log.error("文件 " + filePathAndName + "不存在." + e.toString());
		} catch (IOException e) {
			ret = false;
			log.error("isContainKeyword失败." + e.toString());
		}

		return ret;
	}

	/**
	 * @param filePathAndName
	 * @return
	 * @Description: 获取错误进件文件中的文件名称和文件信息
	 */
	public Map getFileNameAndErrorInfo(String filePathAndName) {
		Map<String, String> mp = new HashMap();
		InputStreamReader read = null;
		try {
			File f = new File(filePathAndName);
			if (f.isFile() && f.exists()) {
				read = new InputStreamReader(new FileInputStream(f), "gb2312");
				BufferedReader br = new BufferedReader(read);
				String strLine = "";
				String fileName = "";
				String errorInfo = "";
				int iLine = 0;
				while ((strLine = br.readLine()) != null) {
					// 在第一行中取文件名称
					if (iLine == 0) {
						int iS = strLine.indexOf("[");
						int iE = strLine.indexOf("]");

						fileName = strLine.substring(iS + 1, iE);
						errorInfo = strLine.substring(iE + 1, strLine.length());
					}
					// 第二行
					if (iLine == 1) {
						errorInfo = errorInfo + strLine;
					}
					iLine++;
				}
				mp.put("FILENAME", fileName);
				mp.put("ERRORINFO", errorInfo);
			}
			if (read != null) {

				read.close();
			}
		} catch (FileNotFoundException e) {
			log.error("文件 " + filePathAndName + "不存在." + e.toString());
		} catch (IOException e) {
			log.error("getFileNameAndErrorInfo失败." + e.toString());
		}

		return mp;
	}

	/**
	 * @param folder
	 * @Description: 批量删除 指定目录下的文件
	 */
	public void deleteBatch(String folder) {

		Vector<String> files = new Vector<String>();
		FileOperateUtil.getInstance().getFileList(files, folder, true);

		for (String filepath : files) {
			File tempFile = new File(filepath);
			if (tempFile.exists()) {
				log.info("删除文件:" + filepath + ":----:: " + tempFile.delete());
			}
		}
	}

	/**
	 * 文件重命名
	 * 
	 * @param oldname
	 * @param newname
	 */
	public static void reNameFile(String oldname, String newname) {
		  long t1 = System.currentTimeMillis(); 
		log.info("文件重命名开始:"+t1 );
		try {
			nioCopy2(oldname, newname);
			//new File(oldname).renameTo(new File(newname));
			// 删除原文件
			new File(oldname).deleteOnExit();

		} catch (Exception ioex) {
			log.error("文件重命名失败:", ioex);
		}
		  long t2 = System.currentTimeMillis(); 
			log.info("文件重命名结束:"+(t2-t1) + "ms" );
	}

	public static void nioCopy(String sourcePath, String destPath) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		FileChannel sourceCh = null;
		FileChannel destCh = null;

		try {
			File source = new File(sourcePath);

			File dest = new File(destPath);

			if (!dest.exists()) {

				dest.createNewFile();

			}

			fis = new FileInputStream(source);

			fos = new FileOutputStream(dest);

			sourceCh = fis.getChannel();

			destCh = fos.getChannel();

			destCh.transferFrom(sourceCh, 0, sourceCh.size());
			//		    删除原文件
			//new File(sourcePath).deleteOnExit();
		} catch (Exception e) {
			log.error("NIO COPY EXCEPTION:", e);
		} finally {
			try {
				if (null != destCh) {

					destCh.close();

				}
				if (null != sourceCh) {
					sourceCh.close();
				}

				if (null != fos) {
					fos.close();
				}

				if (null != fis) {
					fis.close();
				}
			} catch (IOException e) {
				log.error("NIO2 COPY CLOSE EXCEPTION:", e);
			}
		}

	}

	public static void nioCopy2(String sourcePath, String destPath) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		FileChannel sourceCh = null;
		FileChannel destCh = null;

		try {
			File source = new File(sourcePath);

			File dest = new File(destPath);

			if (!dest.exists()) {

				dest.createNewFile();

			}

			fis = new FileInputStream(source);

			fos = new FileOutputStream(dest);

			sourceCh = fis.getChannel();

			destCh = fos.getChannel();

			MappedByteBuffer mbb = sourceCh.map(FileChannel.MapMode.READ_ONLY, 0, sourceCh.size());

			destCh.write(mbb);
			//		    删除原文件
			new File(sourcePath).deleteOnExit();
		} catch (Exception e) {
			log.error("NIO2 COPY EXCEPTION:", e);
		} finally {
			try {
				if (null != destCh) {

					destCh.close();

				}
				if (null != sourceCh) {
					sourceCh.close();
				}

				if (null != fos) {
					fos.close();
				}

				if (null != fis) {
					fis.close();
				}
			} catch (IOException e) {
				log.error("NIO2 COPY CLOSE EXCEPTION:", e);
			}
		}
	}

	/**
	 * 拷贝复制文件
	 * @param oldFile
	 * @param newFile
	 */
	public static void copyFile(String oldFile, String newFile) {
		try {
			FileInputStream input = new FileInputStream(oldFile);//可替换为任何路径何和文件名
			FileOutputStream output = new FileOutputStream(newFile);//可替换为任何路径何和文件名
			int in = input.read();
			while (in != -1) {
				output.write(in);
				in = input.read();
			}
		} catch (IOException e) {
			log.error("拷贝复制文件失败:", e);
		}
	}

	/**
	 * 如果没有模板文件，则从BAK目录拷贝到模板文件夹
	 *
	 */
	public static void bakToTemplete() {
		String appDoc = "appTemplete.doc";
		String moveDoc = "moveTemplete.doc";
		String pbocXls = "pbocCopyTemplete.xls";
		List appTemplete = new ArrayList();
		List moveTemplete = new ArrayList();
		List pbocCopyTemplete = new ArrayList();
		String templeteFolder = FileOperateUtil.getInstance().getFolderName(FileOperateUtil.LOCAL_ROOT_FOLDER_TEMPLETE);
		System.out.println(templeteFolder);
		//获取信号文件
		appTemplete = FileOperateUtil.getListFiles(templeteFolder, appDoc, false);
		moveTemplete = FileOperateUtil.getListFiles(templeteFolder, moveDoc, false);
		pbocCopyTemplete = FileOperateUtil.getListFiles(templeteFolder, pbocXls, false);

		String srcFile = FileOperateUtil.getInstance().getFolderName(FileOperateUtil.LOCAL_ROOT_FOLDER_TEMPLETE_BAK);
		String destPath = FileOperateUtil.getInstance().getFolderName(FileOperateUtil.LOCAL_ROOT_FOLDER_TEMPLETE);

		if (appTemplete.size() == 0) {
			log.error("模板文件丢失；开始拷贝模板文件 appTemplete");
			FileOperateUtil.copyFile(srcFile + appDoc, destPath + appDoc);
		}
		if (moveTemplete.size() == 0) {
			log.error("模板文件丢失；开始拷贝模板文件 moveTemplete");
			FileOperateUtil.copyFile(srcFile + moveDoc, destPath + moveDoc);
		}
		if (pbocCopyTemplete.size() == 0) {
			log.error("模板文件丢失；开始拷贝模板文件 pbocCopyTemplete");
			FileOperateUtil.copyFile(srcFile + pbocXls, destPath + pbocXls);
		}
	}
	
/**
 * 生成通用模板文件
 * @param filepathAndName
 * @param amList
 * @return
 */
	public static boolean bluidTxtFile(String filepathAndName,List<ThirdinfoModel> amList){
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
				ThirdinfoModel sm = amList.get(i);
				ThirdInfoWriteModel writeModel= new ThirdInfoWriteModel();
				writeModel= (ThirdInfoWriteModel) MakeTxtUtil.getInstance().getTxtWriteModel(sm,writeModel);
				String writeString = "";
				log.info("--------------创建写入字符串----------------");
				writeString =MakeTxtUtil.getInstance().bulidComplementASpace(writeModel);
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

	/**
	 *@Author: AlexHe
	 *@CrateDate:2012-8-17
	 *@Version:1.1.0
	 *@FunctionName:
	 *@Description : 获取文件大小类
	 *@Modify History: ----------------------------------
	 * 
	 */
	public static class GetFileSize {
		/**
		 * @param f
		 * @return
		 * @throws Exception
		 * @Description: 单个文件大小
		 */
		public static long getFileSizes(File f) throws Exception {// 取得文件大小
			long s = 0;
			if (f.exists()) {
				FileInputStream fis = null;
				fis = new FileInputStream(f);
				s = fis.available();
			} else {
				f.createNewFile();
				log.error("文件不存在");
			}
			return s;
		}

		// 递归
		public static long getFileSize(File f) throws Exception// 取得文件夹大小
		{
			long size = 0;
			File flist[] = f.listFiles();
			for (int i = 0; i < flist.length; i++) {
				if (flist[i].isDirectory()) {
					size = size + getFileSize(flist[i]);
				} else {
					size = size + flist[i].length();
				}
			}
			return size;
		}

		public static String FormetFileSize(long fileS) {// 转换文件大小
			DecimalFormat df = new DecimalFormat("#.00");
			String fileSizeString = "";
			if (fileS < 1024) {
				fileSizeString = df.format((double) fileS) + "B";
			} else if (fileS < 1048576) {
				fileSizeString = df.format((double) fileS / 1024) + "K";
			} else if (fileS < 1073741824) {
				fileSizeString = df.format((double) fileS / 1048576) + "M";
			} else {
				fileSizeString = df.format((double) fileS / 1073741824) + "G";
			}
			return fileSizeString;
		}

		public static long getFolderDirNum(File f) {// 递归求取目录文件个数
			long size = 0;
			File flist[] = f.listFiles();
			size = flist.length;
			for (int i = 0; i < flist.length; i++) {
				if (flist[i].isDirectory()) {
					size = size + getFolderDirNum(flist[i]);
					size--;
				}
			}
			return size;

		}

		public static void testGetFileSize() {

			GetFileSize g = new GetFileSize();
			long startTime = System.currentTimeMillis();
			try {
				long l = 0;
				String path = "D:/TEST";
				File ff = new File(path);
				if (ff.isDirectory()) { // 如果路径是文件夹的时候
					System.out.println("文件个数 " + g.getFolderDirNum(ff));
					System.out.println("目录");
					l = g.getFileSize(ff);
					System.out.println(path + "目录的大小为：" + g.FormetFileSize(l));
				} else {
					System.out.println(" 文件个数 1");
					System.out.println("文件");
					l = g.getFileSizes(ff);
					System.out.println(path + "文件的大小为：" + g.FormetFileSize(l));
				}

			} catch (Exception e) {
				log.error("testGetFileSize方法异常" + e);
			}
			long endTime = System.currentTimeMillis();
			System.out.println("总共花费时间为：" + (endTime - startTime) + "毫秒...");
		}
	}

	/**
	 * @param f
	 * @return
	 * @Description: 删除文件
	 */
	public static boolean forceDelete(File f) {
		boolean result = false;
		int tryCount = 0;
		while (!result && tryCount++ < 10) {
			// logger.debug("try to delete file "+ f.getName()
			// +" cnt:"+tryCount);
			System.gc();
			result = f.delete();
		}
		return result;
	}

	public static void main(String[] args) {
		// List list = new ArrayList();
		// list.add("D:\\TEST\\APP_IMG\\1.tif");
		// list.add("D:\\TEST\\APP_IMG\\merge.tif");
		//
		// String zipName = "D:\\TEST\\APP_IMG\\demo.zip";
		//
		// System.out.println(FileOperateUtil.getInstance().getBluidTifName(
		// "L00881057921", "D:\\TEST\\TEMP\\201208231182934.tif.new.tif"));

		// String filePath = "d:\\xx.txt";
		// try {
		// FileWriter fw = new FileWriter(filePath);
		//
		// // 转换为可写数据
		// ApplicationModel aModel = new ApplicationModel();
		// ApplicationWriteModel awModle = ApplicationUtil.getInstance()
		// .getWriteModelFromDaoModel(aModel);
		// String writeString = ApplicationUtil.getInstance()
		// .bulidComplementASpace(awModle);
		// // 写入文件
		// fw.write(writeString);
		// if (fw != null) {
		// fw.close();
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		//
		// System.out.println(sdf.format(new Date()));
		//		
		// System.out.println(FileOperateUtil.getInstance().getBluidZipName("SSSSSSS","D:\\xx.txt"));

		// //获取文件列表
		// List<String> outFileLists =
		// FileOperateUtil.getListFiles("D:\\TEST\\TIF",".jpg", true);
		//		
		// FileOperateUtil.getInstance().assginFile2Zip(outFileLists,
		// "D:\\TEST\\TIF\\zipname.zip");

		//		System.out.println(FileOperateUtil.move("d:\\11.txt", "d:\\1\\"));

		//FileOperateUtil.reNameFile("D://LOACAL//WZTIF//Z000002337.zip", "D://LOACAL//WZTIF//00000000260-00001-0409183806.0.zip");
//		 目标文件如果存在，则重命名目标文件,删除目标文件后进行move;
	//	bakToBak("D:\LOACAL\TEMP\cheng.tif", "D:\LOACAL\TEMP\bak\cheng.tif");
		// File (or directory) to be moved
		File file = new File("D:\\LOACAL\\TEMP\\cheng.tif");
		// Destination directory
		File dir = new File("D:\\LOACAL\\TEMP\\bak\\cheng.tif");
		System.out.println(dir+"   "+file.getName());
		// Move file to new directory
		boolean success = file.renameTo(dir);
		String retString = "";
		if (success) {

			retString = "成功";
		} else {
			retString = "失败";
		}
	
	}
	//2015-03-09
	private boolean checkString(String writeString) {
		boolean retValue = true;
		
		//长度不符
		byte[] ws=	writeString.getBytes();
		if(ws.length!=3473){
			log.info("bluidTxtFile.txt文件内容长度大小不符合规范byte:");
		    log.info("相应的内容为："+writeString);
		    retValue = false;
		}
		//包含特殊字符？'
		if(writeString.indexOf("'")!=-1 || writeString.indexOf("?")!=-1){
			log.info("包含特殊字符："+writeString);
			retValue = false;
		}
		return retValue;
	}
	
	
	

}
