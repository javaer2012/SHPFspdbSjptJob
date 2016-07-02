package com.ideal.spdb.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Vector;

import org.apache.log4j.Logger;

/**
 * @author huangxq
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class FileUtils {
	private static Logger log = Logger.getLogger(FileUtils.class.getName());

	public FileUtils() {
	}
	public static void closeInputStream(InputStream is) {
		// 退出前,一定要将文件处理读写器关闭
		try {
			if (is != null)
				is.close();
			is = null;
		} catch (Exception exx) {
			log.error(exx);
		}
	} 
	public static void closeOutputStream(OutputStream os) {
		// 退出前,一定要将文件处理读写器关闭
		try {
			if (os != null)
				os.close();
			os = null;
		} catch (Exception exx) {
			log.error(exx);
		}
	}	
	public static void closeFileReader(FileReader fr) {
		// 退出前,一定要将文件处理读写器关闭
		try {
			if (fr != null)
				fr.close();
			fr = null;
		} catch (Exception exx) {
			log.error(exx);
		}
	}

	public static void closeBufferedReader(BufferedReader br) {
		// 退出前,一定要将文件处理读写器关闭
		try {
			if (br != null)
				br.close();
			br = null;
		} catch (Exception exx) {
			log.error(exx);
		}
	}

	public static void closeReader(FileReader fr, BufferedReader br) {
		// 退出前,一定要将文件处理读写器关闭
		try {
			if (fr != null)
				fr.close();
			fr = null;
		} catch (Exception exx) {
			log.error(exx);
		}
		try {
			if (br != null)
				br.close();
			br = null;
		} catch (Exception exx) {
			log.error(exx);
		}		
	}

	public static void closeFileWriter(FileWriter fw) {
		// 退出前,一定要将文件处理读写器关闭
		try {
			if (fw != null)
				fw.close();
			fw = null;
		} catch (Exception exx) {
			log.error(exx);
		}
	}

	public static void closeBufferedWriter(BufferedWriter bw) {
		// 退出前,一定要将文件处理读写器关闭
		try {
			if (bw != null)
				bw.close();
			bw = null;
		} catch (Exception exx) {
			log.error(exx);
		}
	}

	public static void closePrintWriter(PrintWriter pw) {
		// 退出前,一定要将文件处理读写器关闭
		try {
			if (pw != null)
				pw.close();
			pw = null;
		} catch (Exception exx) {
			log.error(exx);
		}
	}

	public static void closeWriter(FileWriter fw, BufferedWriter bw) {
		// 退出前,一定要将文件处理读写器关闭
		try {
			if (fw != null)
				fw.close();
			fw = null;
		} catch (Exception exx) {
			log.error(exx);
		}
		try {
			if (bw != null)
				bw.close();
			bw = null;
		} catch (Exception exx) {
			log.error(exx);
		}		
	}

	public static void closeFile(File inFile) {
		// 退出前,将文件置为空
		try {
			if (inFile != null)
  			inFile = null;
		} catch (Exception exx) {
			log.error(exx);
		}
	}

	/**
	 * 方法残缺不可用
	 * @param inPath
	 * @param fileName
	 * @param absolutePath
	 * @return
	 */
	public static boolean moveFile(String inPath, String fileName,
			String absolutePath) {
		boolean isSuccess = true;
		File newFile = null;
		try {
			if (inPath != null && !inPath.equals("") && fileName != null
					&& !fileName.equals("")) {
				File newPath = new File(inPath);
				String newfilename = null;
				if (!(newPath.exists()))
					newPath.mkdir();
				if (newPath != null) {
					newfilename = newPath.getAbsolutePath() + File.separator
							+ fileName;
					log.info("newfilename == " + newfilename);
					newFile = new File(newfilename);
					if (newFile.exists()) { // 文件已经存在,则先将文件重命名,后缀为当时的系统时间
						try {
							newFile.renameTo(new File(newfilename + "."));
						} catch (Exception ex) {
							log.error(ex);
						}
						log.info("文件已经存在 =2= " + isSuccess);
					}
					log.info("absolutePath == " + absolutePath);
					isSuccess = (new File(absolutePath)).renameTo(newFile);
					if (newFile != null)
						newFile = null;
				}
			}
		} catch (Exception ex) {
			log.error(ex);
			isSuccess = false;
			if (newFile != null)
				newFile = null;
		}
		log.info("文件往成功或失败文件夹下移动结果: " + isSuccess);
		return isSuccess;
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
	 * 删除单个文件
	 * @param sPath 被删除文件的文件名
	 * @return 单个文件删除成功返回true，否则返回false
	 */
	public static boolean deleteFile(String sPath) {
		boolean flag = false;
		File file = new File(sPath);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.delete();
			flag = true;
		}
		return flag;
	}
	
	
	/**
	 * 获取随机数
	 * @return
	 */
	public String getRandomNumber() {
		Random random = new Random();
		int n = Math.abs(random.nextInt()) % 10;
		return String.valueOf(n);
	}
	
	/**
	 * 在文档后附加内容
	 * 
	 * @param textName
	 * @param data
	 * @return
	 */
	public boolean appendText(String textPath, String textName, String data) {
		boolean flag = false;
		File filePath = new File(textPath);
		if (!filePath.exists()) {
			filePath.mkdirs();
		}

		try {
			FileWriter fw = new FileWriter(textPath + File.separator + textName, true);
			fw.append(data);
			flag = true;
			if (fw != null)
				fw.close();
		} catch (IOException e) {
			log.error(this.getClass().getName() + e.toString());
		}
		return flag;
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
		if (srcFile.lastIndexOf(File.separatorChar) > -1) {
			destPathFile = srcFile.substring(srcFile.lastIndexOf(File.separatorChar) + 1, srcFile.length());
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
	 * @param folder
	 * @Description: 批量删除 指定目录下的文件
	 */
	public void deleteBatch(String folder) {

		File[] files = (new File(folder)).listFiles();

		for (File filepath : files) {
			if (filepath.exists()) {
				log.info("删除文件:" + filepath + ":----:: " + filepath.delete());
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
}
