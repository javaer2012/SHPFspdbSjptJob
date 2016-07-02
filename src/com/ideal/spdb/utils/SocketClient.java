package com.ideal.spdb.utils;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

import org.apache.log4j.Logger;

public class SocketClient {

	private static Logger log = Logger.getLogger(SocketClient.class);

	private Socket s;
	private OutputStream serverOutput = null;
	private InputStream serverInput = null;
	private String host;
	private int port;
	private int timeout;

	public SocketClient() { 
		this(Constants.pro.getProperty("QUEUE_MANAGE_IP"),
				Integer.parseInt(Constants.pro.getProperty("QUEUE_MANAGE_PORT")),
				5000);
	}
	
	/**
	 * 构造方法完成初始化
	 * 
	 * @param host,port,timeout
	 */
	public SocketClient(String host, int port, int timeOut) {

		this.host = host;
		this.port = port;
		this.timeout = timeOut;
		openConnection();
	}

	/**
	 * 打开连接的输入输出流
	 * 
	 * @return boolean
	 */
	public boolean openConnection() {
		try {
			s = new Socket(host, port);
			s.setSoTimeout(timeout);
			 
			log.info("SocketClient:---------->" + host + ":" + port + " Socket连接成功");
			serverOutput = s.getOutputStream();
			serverInput = s.getInputStream();
		} catch (Exception e) {
			log.error("SocketClient:Exception when openConnection()-", e);
			this.closeConnection();
			return false;
		}
		return true;
	}

	/**
	 * 关闭连接的输入输出流
	 * 
	 * @author mick.ge
	 */
	public void closeConnection() {
		try {
			// 关闭输出
			if (serverOutput != null) {
				serverOutput.close();
			}
		} catch (Exception e) {
			log.error("SocketClient:Exception when closeConnection()-", e);
		}
		try {
			// 关闭输入
			if (serverInput != null) {
				serverInput.close();
			}
		} catch (Exception e) {
			log.error("SocketClient:Exception when closeConnection()-", e);
		}

		try {
			if (s != null) {
				s.close();// 关闭socket
			}
		} catch (Exception e) {
			log.error("SocketClient:Exception when closeConnection()-", e);
		}

		log.info("SocketClient:---------->" + host + ":" + port
				+ " Socket连接关闭");
	}

	/**
	 * 发送数据
	 * 
	 * @param sndStr
	 * @return boolean
	 */
	public boolean sndData(String sndStr) {
		try {
			int len = sndStr.getBytes("ISO-8859-1").length + 6;
			String mlen = StringTools.addSymbolAtLeft(String.valueOf(len), 6, '0');
			sndStr = mlen + sndStr;
			log.info("SocketClient:sndData() sent msg is "+sndStr);
			byte[] sndByte = sndStr.getBytes(); 
			serverOutput.write(sndByte);
			serverOutput.flush(); 
			return true;
		} catch (SocketTimeoutException ste) {
			log.error("SocketClient:SocketTimeout when sndData()-" + ste);
			closeConnection();
			return false;
		} catch (Exception e) {
			log.error("SocketClient:Exception when sndData()-" + e);
			closeConnection();
			return false;
		}
	}

	/**
	 * 接收数据
	 * 
	 * @param lenSize
	 * @return 数据字符串
	 * 
	 */
	public String rcvData(int lenSize) {

		byte[] line = null;
		byte[] lenBuffer = new byte[lenSize];
		String readLine = null;

		try {

			// 读取规定字节数的字符
			for (int i = 0; i < lenSize; i++) {
				lenBuffer[i] = (byte) serverInput.read();
			}

			// 取得消息总长度

			int messageLength = Integer.valueOf((new String(lenBuffer)).trim())
					.intValue();
			line = new byte[messageLength];

			// 将已读取的n个字节传给line
			for (int i = 0; i < lenSize; i++) {
				line[i] = lenBuffer[i];
			}

			// 将剩余的n个字节传给line
			for (int i = lenSize; i < messageLength; i++) {
				line[i] = (byte) serverInput.read();
			} 
			// 生成字符串对象,写入日志
			readLine = new String(line); // ,InitServer.CHARSET 
			// log.info("SocketClient:rcvData() received msg is "+readLine);
		} catch (SocketTimeoutException ste) {
			readLine = null;
			log.error("SocketClient:SocketTimeout when rcvData()-" + ste);
		} catch (Exception ex) {
			readLine = null;
			log.error("SocketClient:Exception when rcvData()-" + ex);
		}

		finally {
			this.closeConnection();
		}
		log.info("rcvData Line=" + readLine);
		return readLine;
	}
}
