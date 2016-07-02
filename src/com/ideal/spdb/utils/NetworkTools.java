package com.ideal.spdb.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * <p>Title:  浦发五星项目</p>
 * <p>Description:网络操作工具类</p>
 * <p>Company: 上海理想信息产业(集团)有限公司</p>
 * @author dinghui	
 * create date: 2012-2-11
 * @version 1.0
 */
public class NetworkTools {
	
	/**
	 * 获取操作系统类型
	 * 
	 * @return 返回操作系统类型
	 */
	public static String getOsName() {
		return System.getProperty("os.name");
	}

	/**
	 * 通过运行命令获取本机mac地址(支持window和linux平台)
	 * 
	 * @return 返回mac地址
	 */
	public static String getMACAddress() {
		String address = "";
		BufferedReader br = null;
		String os = getOsName();
		if (null != os) {
			if (os.startsWith("Windows")) {
				try {
					String command = "cmd.exe /c ipconfig /all";
					Process p = Runtime.getRuntime().exec(command);
					br = new BufferedReader(new InputStreamReader(p.getInputStream()));
					String line;
					while ((line = br.readLine()) != null) {
						if (line.indexOf("Physical Address") > 0) {
							int index = line.indexOf(":");
							index += 2;
							address = line.substring(index);
							break;
						}
					}
					return address.trim();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (null != br) {
						try {
							br.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}

				}
			} else if (os.startsWith("Linux")) {
				String command = "/bin/sh -c ifconfig -a";
				try {
					Process p= Runtime.getRuntime().exec(command);
					br = new BufferedReader(new InputStreamReader(p.getInputStream()));
					String line;
					while ((line = br.readLine()) != null) {
						if (line.indexOf("HWaddr") > 0) {
							int index = line.indexOf("HWaddr")+"HWaddr".length();
							address = line.substring(index);
							break;
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (null != br) {
						try {
							br.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		address = address.trim();
		return address;
	}

	/**
	 * 根据ip地址获取mac地址
	 * 
	 * @param ipAddress
	 *            ip地址
	 * @return 返回mac地址
	 */
	public static String getMACAddress(String ipAddress) {
		String str = "";
		String mac = "";
		try {
			Process pp = Runtime.getRuntime().exec("nbtstat -a " + ipAddress);
			InputStreamReader ir = new InputStreamReader(pp.getInputStream());
			LineNumberReader input = new LineNumberReader(ir);
			for (int i = 1; i < 100; i++) {
				str =input.readLine();
				if (str != null) {
					if(str.indexOf("=")>1){
						mac=str.substring(str.indexOf("=")+1);
						break;
					}
				}
			}
		} catch (IOException ex) {
			return "Can't Get MAC Address!";
		}
		if (mac.length() < 17) {
			return "";
		}
		return mac;
	}

	/**
	 * 获取请求ip地址
	 * 
	 * @param request
	 *            请求对象
	 * @return 返回发送请求的ip地址
	 */
	public static String getIpAddrByRequest(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 获取本机真实ip地址
	 * 
	 * @return 返回本机真实IP
	 */
	public static String getRealIp() {
		String localip = null;// 本地IP，如果没有配置外网IP则返回它
		String netip = null;// 外网IP
		try {
			Enumeration<NetworkInterface> netInterfaces = NetworkInterface
					.getNetworkInterfaces();
			InetAddress ip = null;
			boolean finded = false;// 是否找到外网IP
			while (netInterfaces.hasMoreElements() && !finded) {
				NetworkInterface ni = netInterfaces.nextElement();
				Enumeration<InetAddress> address = ni.getInetAddresses();
				while (address.hasMoreElements()) {
					ip = address.nextElement();
					if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress()
							&& ip.getHostAddress().indexOf(":") == -1) {// 外网IP
						netip = ip.getHostAddress();
						finded = true;
						break;
					} else if (ip.isSiteLocalAddress()
							&& !ip.isLoopbackAddress()
							&& ip.getHostAddress().indexOf(":") == -1) {// 内网IP
						localip = ip.getHostAddress();
					}
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}
		if (netip != null && !"".equals(netip)) {
			return netip;
		} else {
			return localip;
		}

	}

	public static void main(String[] args) {
		System.out.println("Operation System=" + getOsName());
		System.out.println("Mac Address=" + getMACAddress());
		System.out.println("通过ip获取mac=" + getMACAddress("10.4.250.123"));
		System.out.println("获取本机ip=" + getRealIp());
	}
}
