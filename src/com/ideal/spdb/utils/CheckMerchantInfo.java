package com.ideal.spdb.utils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
public class CheckMerchantInfo {
	public static boolean isBoolean(String param){
		if (param.contains(".")) {
			String[] ss=param.split("\\.");
			if (ss.length==2&&StringUtils.isNumeric(ss[0])&&StringUtils.isNumeric(ss[1])) {
				return true;
			}else {
			return false;	
			}
		}else {
			if (StringUtils.isNumeric(param)) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	public static boolean isPersoin(String param){
		if (param.contains("%")) {
			param=param.substring(0,param.length()-1);
			if (StringUtils.isNumeric(param)&&Integer.parseInt(param)/100>=0&&Integer.parseInt(param)/100<1) {
				return true;
			}
			if (param.contains(".")) {
				String[] ss=param.split("\\.");
				if (StringUtils.isNumeric(ss[0])&&StringUtils.isNumeric(ss[1])&&Integer.parseInt(ss[0])/100>=0&&Integer.parseInt(ss[0])/100<1) {
						return true;	
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	public static boolean isnum(String param){
		if (StringUtils.isNumeric(param)) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean isNotnull(String param){
		if (param==""||param==null||param.equals("")) {
			return false;
		}else {
			return true;
		}
	}
	public static boolean isAteshu(String param){
		return param.matches("^[\u4e00-\u9fa5A-Za-z]+$");
	}
	public static int pageNum(double pageNum){
		int page=(int) pageNum;
		return page;
	}
	public static void main(String[] args) {
		System.out.println(!isNotnull(""));
	}
//	private static final Pattern special = Pattern.compile("[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？\\[\\]_ \\n]");
//	/**
//	 * 判断input字符是否是特殊字符
//	 */
//	public static boolean checkeSpecial(CharSequence input){
//		return special.matcher(input).matches();
//	}
}
