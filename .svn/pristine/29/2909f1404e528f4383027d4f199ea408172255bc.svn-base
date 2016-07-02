package com.ideal.spdb.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.log4j.Logger;

/**
 * 
 * <p>Title:  浦发五星项目</p>
 * <p>Description:读写文件工具类</p>
 * <p>Company: 上海理想信息产业(集团)有限公司</p>
 * @author dinghui
 * create date: 2011-8-30
 * @version 1.0
 */
public class WriteAndRead {
    protected static Logger log=Logger.getLogger(WriteAndRead.class);
    private WriteAndRead(){
    	
    }
	/**
	 * 读文件
	 * 
	 * @param path
	 *            文件路径
	 * @param content
	 *            文件内容
	 */
	public static void write(String path, String content) {
		String contentStr = "";
		StringBuilder sb = new StringBuilder();
		BufferedReader input = null;
		BufferedWriter output = null;
		try {
			File f = new File(path);
			if (f.exists()) {
				log.info("文件存在");
			} else {
				log.info("文件不存在，正在创建...");
				if (f.createNewFile()) {
					log.info("文件创建成功！");
				} else {
					log.info("文件创建失败！");
				}
			}
			input = new BufferedReader(new FileReader(f));
			while ((contentStr = input.readLine()) != null) {
				sb.append(contentStr + "\n");
			}
			log.info("write的文件内容：" + sb.toString());
			output = new BufferedWriter(new FileWriter(f));
			output.write(content);
			output.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != input) {
					input.close();
				}
				if (null != output) {
					output.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 读文件
	 * 
	 * @param file
	 *            文件路径
	 */
	public static String read(String file) {
		String content = "";
		BufferedReader output = null;
		StringBuilder sb = new StringBuilder();
		File f = new File(file);
		if (f.exists()) {
			log.info("文件存在");
			try {
				output = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
				while ((content = output.readLine()) != null) {
					sb.append(content);
				}
				log.info("read的文件内容：" + sb.toString());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (null != output) {
						output.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			log.info("文件不存在!");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		WriteAndRead.write("d:\\123.csv", "hello");
		WriteAndRead.read("d:\\123.csv");
	}

}
