package com.ideal.spdb.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;


/**
 * @author wls
 * @date 2012-9-4
 * @version V1.0
 */
public class IoDownload {

	public void download(HttpServletResponse response,String folder,String fileName) {
		String downloadfiledir = AppConfigFile.getInstance().getValue("IMG_PATH");
		String fullfilename = downloadfiledir + folder+"/" + fileName;

		String contentType = "application/octet-stream";
		response.setContentType(contentType);
		response.setHeader("Content-disposition", "attachment;filename=\""
				+ fileName + "\"");
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new BufferedInputStream(new FileInputStream(fullfilename));
			// 定义输出字节流
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			// 定义response的输出流
			os = new BufferedOutputStream(response.getOutputStream());
			// 定义buffer
			byte[] buffer = new byte[Integer.parseInt(AppConfigFile.getInstance().getValue("VIDEO_SIZE")) * 1024 * 1024]; // 4M
																			// Buffer
			int read = 0;
			// 从文件中读入数据并写到输出字节流中
			while ((read = is.read(buffer)) != -1) {
				baos.write(buffer, 0, read);
			}
			// 将输出字节流写到response的输出流中
			os.write(baos.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭输出字节流和response输出流
			try {
				os.close();
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
