package com.ideal.spdb.thirdinfo.work.util;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;

import sun.net.TelnetInputStream;
import sun.net.TelnetOutputStream;
import sun.net.ftp.FtpClient;

/**
 * @Author: AlexHe
 * @CrateDate:2012-8-12
 * @Version:1.1.0
 * @FunctionName:
 * @Description :FTP上传工具类
 * @Modify History: ----------------------------------
 * 
 */
public class FtpUtil {

	private static final Logger log = Logger.getLogger(FtpUtil.class);

	private String path = "";
	private FtpClient ftpClient = null;
	private OutputStream os = null;
	private FileInputStream is = null;

	public void initFtpUtil() {

		// 1.读取ftp配置文件
		String ip = AppConfigFile.getInstance().getValue("FTP_IP");
		String port = AppConfigFile.getInstance().getValue("FTP_PORT");
		String user = AppConfigFile.getInstance().getValue("FTP_USER");
		String pass = AppConfigFile.getInstance().getValue("FTP_PASS");
		log.info("ip:" + ip + ",port:" + port + ",user:" + user + ",pass:" + pass);
		connectServer(ip, Integer.valueOf(port), user, pass);

	}

	public void initFtpUtil(int i) {
		log.info("initFtpUtil ==> i = " + i);
		// 1.读取ftp配置文件
		String ip = AppConfigFile.getInstance().getValue("FTP_IP" + "_" + i);
		String port = AppConfigFile.getInstance().getValue("FTP_PORT" + "_" + i);
		String user = AppConfigFile.getInstance().getValue("FTP_USER" + "_" + i);
		String pass = AppConfigFile.getInstance().getValue("FTP_PASS" + "_" + i);
		log.info("ip:" + ip + ",port:" + port + ",user:" + user + ",pass:" + pass);

		connectServer(ip, Integer.valueOf(port), user, pass);

	}

	/**
	 * 连接ftp服务器
	 * 
	 * @throws IOException
	 */
	public boolean connectServer(String ip, int port, String username, String password) {

		log.info("连接地址:" + ip);

		ftpClient = new FtpClient();
		try {
			if (port != -1) {
				ftpClient.openServer(ip, port);
			} else {
				ftpClient.openServer(ip);
			}
			ftpClient.login(username, password);
			if (this.path.length() != 0) {
				ftpClient.cd(this.path);// path是ftp服务下主目录的子目录
			}
			ftpClient.binary();// 用2进制上传、下载

			log.info("已登录到\"" + ftpClient.pwd() + "\"目录");

			return true;
		} catch (IOException e) {
			log.error("连接ftp服务器异常 connectServer(): ip:" + ip + "-------" + e.getMessage() + "------" + e.toString() + "------" + e.getStackTrace().toString());
			return false;
		}
	}

	/**
	 * 断开与ftp服务器连接
	 * 
	 * @throws IOException
	 */
	public boolean closeServer() {
		try {
			if (is != null) {
				is.close();
			}
			if (os != null) {
				os.close();
			}
			if (ftpClient != null) {
				ftpClient.closeServer();
			}
			log.info("已从服务器断开");
			return true;
		} catch (IOException e) {
			log.error("关闭ftp服务器异常 closeServer(): " + e.toString());
			return false;
		}
	}

	/**
	 * 检查文件夹在当前目录下是否存在
	 * 
	 * @param dir
	 * @return
	 */
	public boolean isDirExist(String dir) {
		String pwd = "";
		try {
			pwd = ftpClient.pwd();
			ftpClient.cd(dir);
			ftpClient.cd(pwd);
		} catch (Exception e) {
			log.error("isDirExist方法异常" + e);
			return false;
		}
		return true;
	}

	/**
	 * 在当前目录下创建文件夹
	 * 
	 * @param dir
	 * @return
	 * @throws Exception
	 */
	public boolean createDir(String dir) {
		try {
			ftpClient.ascii();
			StringTokenizer s = new StringTokenizer(dir, "/"); // sign
			s.countTokens();
			String pathName = ftpClient.pwd();
			while (s.hasMoreElements()) {
				pathName = pathName + "/" + (String) s.nextElement();
				try {
					ftpClient.sendServer("MKD " + pathName + "\r\n");
				} catch (Exception e) {
					e = null;
					return false;
				}
				ftpClient.readServerResponse();
			}
			ftpClient.binary();
			return true;
		} catch (IOException e) {
			log.error("createDir方法异常" + e);
			return false;
		}
	}

	/**
	 * ftp上传 如果服务器段已存在名为filename的文件夹，该文件夹中与要上传的文件夹中同名的文件将被替换
	 * 
	 * @param filename
	 *            要上传的文件（或文件夹）名
	 * @return
	 * @throws Exception
	 */
	public boolean upload(String filename) {
		String newname = "";
		if (filename.indexOf("/") > -1) {
			newname = filename.substring(filename.lastIndexOf("/") + 1);
		} else {
			newname = filename;
		}
		return upload(filename, newname);
	}

	/**
	 * ftp上传 如果服务器段已存在名为newName的文件夹，该文件夹中与要上传的文件夹中同名的文件将被替换
	 * 
	 * @param fileName
	 *            要上传的文件（或文件夹）名
	 * @param newName
	 *            服务器段要生成的文件（或文件夹）名
	 * @return
	 */
	public boolean upload(String fileName, String newName) {
		try {
			String savefilename = new String(fileName.getBytes("ISO-8859-1"), "GBK");
			File file_in = new File(savefilename);// 打开本地待长传的文件
			if (!file_in.exists()) {
				throw new Exception("此文件或文件夹[" + file_in.getName() + "]有误或不存在!");
			}
			if (file_in.isDirectory()) {
				upload(file_in.getPath(), newName, ftpClient.pwd());
			} else {
				uploadFile(file_in.getPath(), newName);
			}

			if (is != null) {
				is.close();
			}
			if (os != null) {
				os.close();
			}
			return true;
		} catch (Exception e) {
			log.error("Exception e in Ftp upload(): " + e.toString());
			return false;
		} finally {
			try {
				if (is != null) {
					is.close();
				}
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				log.error("upload方法异常" + e);
			}
		}
	}

	/**
	 * 真正用于上传的方法
	 * 
	 * @param fileName
	 * @param newName
	 * @param path
	 * @throws Exception
	 */
	private void upload(String fileName, String newName, String path) throws Exception {
		String savefilename = new String(fileName.getBytes("ISO-8859-1"), "GBK");
		File file_in = new File(savefilename);// 打开本地待长传的文件
		if (!file_in.exists()) {
			throw new Exception("此文件或文件夹[" + file_in.getName() + "]有误或不存在!");
		}
		if (file_in.isDirectory()) {
			if (!isDirExist(newName)) {
				createDir(newName);
			}
			ftpClient.cd(newName);
			File sourceFile[] = file_in.listFiles();
			for (int i = 0; i < sourceFile.length; i++) {
				if (!sourceFile[i].exists()) {
					continue;
				}
				if (sourceFile[i].isDirectory()) {
					this.upload(sourceFile[i].getPath(), sourceFile[i].getName(), path + "/" + newName);
				} else {
					this.uploadFile(sourceFile[i].getPath(), sourceFile[i].getName());
				}
			}
		} else {
			uploadFile(file_in.getPath(), newName);
		}
		ftpClient.cd(path);
	}

	/**
	 * upload 上传文件
	 * 
	 * @param filename
	 *            要上传的文件名
	 * @param newname
	 *            上传后的新文件名
	 * @return -1 文件不存在 >=0 成功上传，返回文件的大小
	 * @throws Exception
	 */
	public long uploadFile(String filename, String newname) throws Exception {
		long result = 0;
		TelnetOutputStream os = null;
		FileInputStream is = null;
		try {
			java.io.File file_in = new java.io.File(filename);
			if (!file_in.exists())
				return -1;
			os = ftpClient.put(newname);
			result = file_in.length();
			is = new FileInputStream(file_in);
			byte[] bytes = new byte[1024];
			int c;
			while ((c = is.read(bytes)) != -1) {
				os.write(bytes, 0, c);
			}
		} finally {
			if (is != null) {
				is.close();
			}
			if (os != null) {
				os.close();
			}
		}
		return result;
	}

	/**
	 * 从ftp下载文件到本地
	 * 
	 * @param filename
	 *            服务器上的文件名
	 * @param newfilename
	 *            本地生成的文件名
	 * @return
	 * @throws Exception
	 */
	public long downloadFile(String filename, String newfilename) {
		long result = 0;
		TelnetInputStream is = null;
		FileOutputStream os = null;
		try {
			is = ftpClient.get(filename);
			java.io.File outfile = new java.io.File(newfilename);
			os = new FileOutputStream(outfile);
			byte[] bytes = new byte[1024];
			int c;
			while ((c = is.read(bytes)) != -1) {
				os.write(bytes, 0, c);
				result = result + c;
			}
		} catch (IOException e) {
			log.error("Exception e in Ftp downloadFile(): filename:" + filename + e.toString());
		} finally {
			try {
				if (is != null) {
					is.close();
				}
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				log.error("Exception e in Ftp downloadFile(): " + e.toString());
			}
		}
		return result;
	}

	/**
	 * @param srcFile
	 *            源文件
	 * @param destFile
	 *            目标文件
	 * @return
	 * @Description: 移动FTP上的文件到指定目录
	 */
	public boolean moveFtpServerFile(String srcFile, String destFile) {
		boolean ret = false;

		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		String dateName = sdf.format(new Date());

		try {
			ftpClient.rename(srcFile, destFile + dateName);
			ret = true;
		} catch (IOException e) {
			ret = false;
			log.error("Exception e in Ftp moveFtpServerFile(): srcFile:" + srcFile + "移动到：" + destFile + dateName + e.toString());
		}
		if (ret) {

			log.info("moveFtpServerFile!!  移动文件：" + srcFile + "到:" + destFile + "  成功.");
		} else {
			log.info("moveFtpServerFile!!  移动文件：" + srcFile + "到:" + destFile + "  失败.");
		}

		return ret;
	}

	/**
	 * @param path
	 * @return
	 * @Description: 取得相对于当前连接目录的某个目录下所有文件列表
	 */
	public List getFileList(String path) {
		List list = new ArrayList();
		DataInputStream dis;
		try {
			dis = new DataInputStream(ftpClient.nameList(this.path + path));
			String filename = "";
			while ((filename = dis.readLine()) != null) {
				list.add(filename);
			}
		} catch (IOException e) {
			log.error("Exception e in Ftp getFileList(): path:" + path + e.toString());
		}
		return list;
	}

	/**
	 * @param path
	 *            目录路径
	 * @param suffix
	 *            后缀 数组
	 * @return
	 * @Description: 获取FTP服务器 指定目录下的指定后缀文件
	 */
	public List getFileList(String path, String suffix[]) {
		List list = new ArrayList();

		if (suffix == null) {
			return list;
		}

		DataInputStream dis;
		try {
			dis = new DataInputStream(ftpClient.nameList(this.path + path));
			String fileName = "";
			String suffixName = "";
			while ((fileName = dis.readLine()) != null) {
				for (int i = 0; i < suffix.length; i++) {
					suffixName = suffix[i];
					if (fileName.length() > suffixName.length()) {
						// 获取ftp上文件的后缀
						String x = fileName.substring(fileName.length() - suffixName.length(), fileName.length());
						// 判断后缀是否吻合
						if (x != null && x.equals(suffixName)) {
							list.add(fileName);
						}
					}
				}
			}
		} catch (IOException e) {
			log.error("Exception e in Ftp getFileList(): " + e.toString());
		}
		return list;
	}

	public void deleteFile(String fileName) {
		if (ftpClient != null) {
			String del = "DELE " + fileName + " \r\n";
			log.info(del); // 输出执行的命令
			ftpClient.sendServer(del);

			try {
				int iRet = ftpClient.readServerResponse();
			} catch (IOException e) {
				log.error("deleteFile发生异常" + e);
			}
		}
	}

	public List<String> queryOkFile(String ftpFolder, String localFolder) {
		List<String> list = new ArrayList<String>();
		String ftpFileName = "";

		String ftpFullFileName = "";
		String ftpFullFileNameBak = "";
		String ftpFullFileName_ok = "";
		String ftpFullFileNameBak_ok = "";

		String localFullFileName = "";
		String localFullFileName_ok = "";

		// 获取文件名列表
		FtpUtil ftpUtil = new FtpUtil();
		ftpUtil.initFtpUtil();
		List ftpFileNameList = ftpUtil.getFileList(ftpFolder, new String[] { ".ok" });
		for (int i = 0; i < ftpFileNameList.size(); i++) {
			ftpFullFileName_ok = (String) ftpFileNameList.get(i); // 带相对地址

			ftpFileName = ftpFullFileName_ok.substring(ftpFullFileName_ok.lastIndexOf(File.separator) + 1, ftpFullFileName_ok.lastIndexOf(".")); // 取到真正的文件名
			ftpFullFileName = ftpFolder + ftpFileName;
			ftpFullFileNameBak = ftpFolder + "bak\\" + ftpFileName;
			ftpFullFileNameBak_ok = ftpFullFileNameBak + ".ok";

			localFullFileName = localFolder + ftpFileName;
			localFullFileName_ok = localFullFileName + ".ok";
			log.info("ftp文件名ftpFullFileName：" + ftpFullFileName);
			log.info("本地文件名localFullFileName：" + localFullFileName);
			// 从ftp上下载文件到本地
			long context = ftpUtil.downloadFile(ftpFullFileName, localFullFileName);
			ftpUtil.downloadFile(ftpFullFileName + ".ok", localFullFileName_ok); // 获取ok文件

			boolean flag2 = context >= 0 ? true : false;
			if (flag2) {
				// 备份文件到ftp上文件的bak目录
				ftpUtil.moveFtpServerFile(ftpFullFileName, ftpFullFileNameBak);
				ftpUtil.moveFtpServerFile(ftpFullFileName + ".ok", ftpFullFileNameBak_ok); // 移除ok文件
				list.add(ftpFileName);
			}
		}
		return list;
	}

	public void uploadApache(String fileName, String newName, int i) {
		log.info("initFtpUtil ==> i = " + i);
		// 1.读取ftp配置文件
		String ip = AppConfigFile.getInstance().getValue("FTP_IP" + "_" + i);
		String port = AppConfigFile.getInstance().getValue("FTP_PORT" + "_" + i);
		String user = AppConfigFile.getInstance().getValue("FTP_USER" + "_" + i);
		String pass = AppConfigFile.getInstance().getValue("FTP_PASS" + "_" + i);
		log.info("ip:" + ip + ",port:" + port + ",user:" + user + ",pass:" + pass);
		FTPClient ftpclient = new FTPClient();
		try {
			ftpclient.connect(ip, Integer.parseInt(port));
			int reply = ftpclient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftpclient.disconnect();
			}
			// 登录
			ftpclient.login(user, pass);
			ftpclient.setBufferSize(256);
			ftpclient.setFileType(FTP.BINARY_FILE_TYPE);
			ftpclient.setControlEncoding("UTF-8");
			ftpclient.enterLocalPassiveMode();
			log.info("FTP登录成功！");
		} catch (Exception e) {
			log.error(e);
			return;
		}

		File f = new File(fileName);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
			if (ftpclient.storeFile(newName, fis)) {
				log.info("文件上传成功");
			}
		} catch (IOException e) {
			log.error("文件上传失败!", e);
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					log.error("文件上传成功,关闭流失败", e);
				}
			}
			try {
				ftpclient.logout();
				log.info("退出登录");
				ftpclient.disconnect();
				log.info("关闭连接");
			} catch (IOException e) {
				log.error("", e);
			}
		}
	}

	public static void main(String[] args) {

		/**
		 * FTP远程命令列表 USER PORT RETR ALLO DELE SITE XMKD CDUP FEAT PASS PASV STOR
		 * REST CWD STAT RMD XCUP OPTS ACCT TYPE APPE RNFR XCWD HELP XRMD STOU
		 * AUTH REIN STRU SMNT RNTO LIST NOOP PWD SIZE PBSZ QUIT MODE SYST ABOR
		 * NLST MKD XPWD MDTM PROT
		 * 在服务器上执行命令,如果用sendServer来执行远程命令(不能执行本地FTP命令)的话，所有FTP命令都要加上\r\n
		 * ftpclient.sendServer("XMKD /test/bb\r\n"); //执行服务器上的FTP命令
		 * ftpclient.readServerResponse一定要在sendServer后调用
		 * nameList("/test")获取指目录下的文件列表 XMKD建立目录，当目录存在的情况下再次创建目录时报错 XRMD删除目录
		 * DELE删除文件
		 */
		// FtpUtil.getFtpUtil().initFtpUtil();
		//
		//
		// List list = FtpUtil.getFtpUtil().getFileList("\\APDS");
		//
		// for(int i=0;i<list.size();i++){
		// System.out.println(list.get(i));
		// String loacalSavePath =
		// FileOperateUtil.getInstance().getFolderName()+"\\DOWN_FILE\\";
		// String ftpServerFile = "\\APDS\\"+(String) list.get(i);
		//
		// FtpUtil.getFtpUtil().downloadFile(ftpServerFile,
		// loacalSavePath+ftpServerFile);
		//
		// FtpUtil.getFtpUtil().moveFtpServerFile(ftpServerFile,"\\APDS_BAK\\"+(String)
		// list.get(i));
		// }
		//
		//
		// FtpUtil.getFtpUtil().closeServer();

		// 1.读取ftp配置文件
		// String ip = AppConfigFile.getInstance().getValue("FTP_IP_1");
		// String port = AppConfigFile.getInstance()
		// .getValue("FTP_PORT" + "_" + 1);
		// String user = AppConfigFile.getInstance()
		// .getValue("FTP_USER" + "_" + 1);
		// String pass = AppConfigFile.getInstance()
		// .getValue("FTP_PASS" + "_" + 1);
		//
		// log.info("ip:" + ip + "port:" + port + "user:" + user + "pass:" +
		// pass);
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		String dateName = sdf.format(new Date());

		System.out.println(dateName);

	}
}