package com.ideal.spdb.utils;

import java.io.UnsupportedEncodingException;


/**
 * 
 * <p>Title:  浦发五星项目</p>
 * <p>Description:字符串处理工具类</p>
 * <p>Company: 上海理想信息产业(集团)有限公司</p>
 * @author dinghui
 * create date: 2012-2-15
 * @version 1.0
 */
public class StringUtils {
	private static final StringUtils stringUtils = new StringUtils();

	private StringUtils() {
	}

	/**
	 * 对中文进行转码
	 * 
	 * @param str
	 *            要转码的字符串
	 * @param agoCoding
	 *            转码前的编码
	 * @param afterCoding
	 *            转码后的编码
	 * @return 返回转码后的字符串
	 */
	public String transCoding(String str, String agoCoding, String afterCoding) {
		String codingStr = null;
		try {
			codingStr = new String(str.getBytes(agoCoding), afterCoding);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return codingStr;
	}
	
	
	/**
	 * 过滤空格
	 * @param o 要过滤的对象
	 * @return 返回过滤后的结果
	 */
	public String filter(Object o) {
		if (o == null)
			return "";
		if ("null".equals(o))
			return "";
		return o.toString().trim();
	}

	/**
	 * 检查字符串是否为空
	 * 
	 * @param str
	 *            要检查的字符串
	 * @return boolean
	 */
	public  boolean isNull(String str) {
		if (str == null || str.length() == 0 || "".equals(str)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	 /**
     * 检查字符串是否为空
     * 
     * @param str
     *            要检查的字符串
     * @return boolean
     */
    public static  boolean isEmpty(String str) {
        if (str == null || str.length() == 0 || "".equals(str)
                ||"null".equals(str)) {
            return true;
        } else {
            return false;
        }
    }

	/**
	 * 唯一实例(单例模式)
	 * 
	 * @return
	 */
	public synchronized static StringUtils getInstance() {
		return stringUtils;
	}
    /**
     * 截取数字，直到不为零得停止
     * @param str
     * @return
     */
	public static String idLing(String str){
		String result="";
		for (int i = 0; i <6; i++) {
			String sb=str.substring(str.length()-i-1, str.length()-i);
			
			if(!"0".equals(sb)){
				result= str.substring(0, str.length()-i);
				if(result.length()==3){
					result=result+"0";
					break;
				}
				break;
			}
		}
		return result;
	}
}
