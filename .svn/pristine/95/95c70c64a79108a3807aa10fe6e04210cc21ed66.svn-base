package com.webservice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * @Title: TestDom4j.java
 * @Package
 * @Description: 解析xml字符串
 * @author 无处不在
 * @date 2012-11-20 下午05:14:05
 * @version V1.0
 */
public class XMLHandler {

	/**
	 * @description 将xml字符串转换成map
	 * @param xml
	 * @return Map
	 */
	public static Map readStringXmlOut(String xml) {
		Map map = new HashMap();
		Document doc = null;
		try {
			// 将字符串转为XML
			doc = DocumentHelper.parseText(xml);
			// 获取根节点
			Element rootElt = doc.getRootElement();
			// 拿到根节点的名称
			System.out.println("根节点：" + rootElt.getName());

			// 获取根节点下的子节点head
			Iterator iter = rootElt.elementIterator("head");
			// 遍历head节点
			while (iter.hasNext()) {

				Element recordEle = (Element) iter.next();
				// 拿到head节点下的子节点title值
				String title = recordEle.elementTextTrim("title");
				System.out.println("title:" + title);
				map.put("title", title);
				// 获取子节点head下的子节点script
				Iterator iters = recordEle.elementIterator("script");
				// 遍历Header节点下的Response节点
				while (iters.hasNext()) {
					Element itemEle = (Element) iters.next();
					// 拿到head下的子节点script下的字节点username的值
					String username = itemEle.elementTextTrim("username");
					String password = itemEle.elementTextTrim("password");

					System.out.println("username:" + username);
					System.out.println("password:" + password);
					map.put("username", username);
					map.put("password", password);
				}
			}

			// 获取根节点下的子节点body
			Iterator iterss = rootElt.elementIterator("body");
			// 遍历body节点
			while (iterss.hasNext()) {
				Element recordEless = (Element) iterss.next();
				// 拿到body节点下的子节点result值
				String result = recordEless.elementTextTrim("result");
				System.out.println("result:" + result);
				// 获取子节点body下的子节点form
				Iterator itersElIterator = recordEless.elementIterator("form");
				// 遍历Header节点下的Response节点
				while (itersElIterator.hasNext()) {
					Element itemEle = (Element) itersElIterator.next();
					// 拿到body下的子节点form下的字节点banlce的值
					String banlce = itemEle.elementTextTrim("banlce");
					String subID = itemEle.elementTextTrim("subID");

					System.out.println("banlce:" + banlce);
					System.out.println("subID:" + subID);
					map.put("result", result);
					map.put("banlce", banlce);
					map.put("subID", subID);
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("rawtypes")
	public static void readStringXml(String xml) {
		Document doc = null;
		try {
			// 读取并解析XML文档
			doc = DocumentHelper.parseText(xml); // 将字符串转为XML
			Element rootElt = doc.getRootElement(); // 获取根节点
			Iterator dataIter = rootElt.elementIterator();
			while (dataIter.hasNext()) {
				Element dataElement = (Element) dataIter.next();
				Iterator messageIters = dataElement.elementIterator("message");
				while (messageIters.hasNext()) {
					Element itemEle = (Element) messageIters.next();
					String status = itemEle.elementTextTrim("status"); // 拿到head下的子节点script下的字节点username的值
					String value = itemEle.getText();

					System.out.println("status:" + status);
					System.out.println("value:" + value);
				}
			}
			System.out.println("根节点：" + rootElt.getName()); // 拿到根节点的名称
			Iterator iter = rootElt.elementIterator("data"); // 获取根节点下的子节点head
			// 遍历data节点
			while (iter.hasNext()) {
				Element recordEle = (Element) iter.next();
				Iterator messageIters = recordEle.elementIterator("message"); // 获取子节点head下的子节点script

				// 遍历Header节点下的Response节点
				while (messageIters.hasNext()) {
					Element itemEle = (Element) messageIters.next();
					String status = itemEle.elementTextTrim("status"); // 拿到head下的子节点script下的字节点username的值
					String value = itemEle.elementTextTrim("value");

					System.out.println("status:" + status);
					System.out.println("value:" + value);
				}

				Iterator iterss = rootElt.elementIterator("eduInfos"); // /获取根节点下的子节点eduInfos
				// 遍历eduInfos节点
				while (iterss.hasNext()) {
					Element recordEless = (Element) iterss.next();
					String userName = recordEless.elementTextTrim("userName"); // 拿到body节点下的子节点result值
					String identityCard = recordEless
							.elementTextTrim("identityCard"); // 拿到body节点下的子节点result值
					String graduate = recordEless.elementTextTrim("graduate"); // 拿到body节点下的子节点result值
					System.out.println("result:" + graduate);

					Iterator itersElIterator = recordEless
							.elementIterator("message"); // 获取子节点body下的子节点form
					// 遍历Header节点下的Response节点
					while (itersElIterator.hasNext()) {
						Element itemEle = (Element) itersElIterator.next();
						String status = itemEle.elementTextTrim("status"); // 拿到head下的子节点script下的字节点username的值
						String value = itemEle.elementTextTrim("value");
						System.out.println("status:" + status);
						System.out.println("value:" + value);
					}
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	@SuppressWarnings("rawtypes")
	public static void strToXml(String xmlStr){
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(xmlStr);
			Element rootElt = doc.getRootElement();
			Iterator iterMes = rootElt.elementIterator("message");
			while (iterMes.hasNext()) {
				Element element = (Element) iterMes.next();
				String status = element.elementTextTrim("status");
				String value = element.elementTextTrim("value");
				System.out.println(status); 
				System.out.println(value);
			}
			
			Iterator iterEduInfos = rootElt.elementIterator("eduInfos");
			while (iterEduInfos.hasNext()) {
				Element eduInfos = (Element) iterEduInfos.next();
				Iterator iterEduInfo = eduInfos.elementIterator("eduInfo");
				while (iterEduInfo.hasNext()) {
					Element eduInfo = (Element) iterEduInfo.next();
					Iterator iterMessage = eduInfo.elementIterator("message");
					while (iterMessage.hasNext()) {
						Element message = (Element) iterMessage.next();
						String status = message.elementTextTrim("status");
						String value = message.elementTextTrim("value");
						System.out.println(status); 
						System.out.println(value);
					}
					String userName = eduInfo.elementTextTrim("userName");
					String identityCard = eduInfo.elementTextTrim("identityCard");
					String graduate = eduInfo.elementTextTrim("graduate");
					String educationDegree = eduInfo.elementTextTrim("educationDegree");
					String enrolDate = eduInfo.elementTextTrim("enrolDate");
					String specialityName = eduInfo.elementTextTrim("specialityName");
					String graduateTime = eduInfo.elementTextTrim("graduateTime");
					String studyResult = eduInfo.elementTextTrim("studyResult");
					String studyStyle = eduInfo.elementTextTrim("studyStyle");
					String photo = eduInfo.elementTextTrim("photo");
					System.out.println(userName); 
					System.out.println(identityCard);
					System.out.println(graduate);
					System.out.println(educationDegree);
					System.out.println(enrolDate);
					System.out.println(specialityName);
					System.out.println(graduateTime);
					System.out.println(studyResult);
					System.out.println(studyStyle);
					System.out.println(photo);
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
				+ "<data>"
				+ " <message>"
				+ "    <status>0</status>"
				+ "    <value>处理成功</value>"
				+ "  </message>"
				+ "  <eduInfos>"
				+ "    <eduInfo name=\"魏明丽\" id=\"340621198409064827\">"
				+ "      <message>"
				+ "        <status>0</status>"
				+ "        <value>查询成功</value>"
				+ "      </message>"
				+ "      <userName desc=\"姓名\">魏明丽</userName>"
				+ "      <identityCard desc=\"身份证号\">340621198409064827</identityCard>"
				+ "      <graduate desc=\"毕业院校\">兰州理工大学</graduate>"
				+ "      <educationDegree desc=\"学历\">硕士研究生</educationDegree>"
				+ "      <enrolDate desc=\"入学年份\">20050910</enrolDate>"
				+ "      <specialityName desc=\"专业\">通信与信息系统</specialityName>"
				+ "      <graduateTime desc=\"毕业时间\">2008</graduateTime>"
				+ "      <studyResult desc=\"毕业结论\">毕业</studyResult>"
				+ "      <studyStyle desc=\"学历类型\">研究生</studyStyle>"
				+ "      <photo desc=\"照片\">/9j/4AAQSkZJRgABAQEBLAEsAAD/2wBDAAIB==...</photo>"
				+ "    </eduInfo>" 
				+ "  </eduInfos>" 
				+ "</data>";
		strToXml(xmlStr);

		// 下面是需要解析的xml字符串例子
		String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+ "<html>" + "<head>" + "<title>dom4j解析一个例子</title>"
				+ "<script>" + "<username name='dd'>yangrong</username>"
				+ "<password>123456</password>" + "</script>" + "</head>"
				+ "<body>" + "<result>0</result>" + "<form>"
				+ "<banlce>1000</banlce>" + "<subID>36242519880716</subID>"
				+ "</form>" + "</body>" + "</html>";

//		 readStringXml(xmlStr);
//		 readStringXmlOut(xmlString);
		/*
		 * Map map = readStringXmlOut(xmlString); Iterator iters =
		 * map.keySet().iterator(); while (iters.hasNext()) { String key =
		 * iters.next().toString(); // 拿到键 String val = map.get(key).toString();
		 * // 拿到值 System.out.println(key + "=" + val); }
		 */
	}

}