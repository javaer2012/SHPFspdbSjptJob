package com.ideal.spdb.utils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

public class FSCardUtil {
	
	private static final Logger log = Logger.getLogger(ApplicationUtil.class);
	public static FSCardUtil instance = null;

	private FSCardUtil() {
		
	}

	public synchronized static FSCardUtil getInstance() {
		if (instance == null) {
			return instance = new FSCardUtil();
		}
		return instance;
	}

	/**
	 * @param fieldName属性名称
	 *            .(根据属性名称获取当前值应有的位数)
	 * @param nowValue现在的值
	 * @return
	 * @Description: 对于不满足位数的值，补全空格
	 */
	public static String getLowerCaseFieldName(String fieldName, String value) {
		// 获取值
		Field declaredFields[] = fieldName.getClass().getDeclaredFields();

		// 获取字段名
		String name = fieldName.substring(0, fieldName.lastIndexOf("_"));
		
		if(name.equals("shengqingrencardnumber")){
			System.out.println("");
			
		}
		if (fieldName == null) {
			return "";
		}
		
//		if (value == null || "".equals(value)) {
//			return "字段"+name + "的值为空!";
//		}
		
		String retSting = "";
		String rexp = "";

		// 截取属性名称中的字符串 位数 数字
		// 1.截取 "_"
		int index = fieldName.lastIndexOf("_");
		String newValue = fieldName.substring(index + 1);

		// 2.截取A字符
//		int a = newValue.lastIndexOf("A");
//		if (a != -1) {
//			return "字段"+name + "请填写正确的字符!";
//		}

		// 3.截取O非必须填的项 可以 不作判断
//		int o = fieldName.lastIndexOf("O");
//		if (o != -1) {
//			return "字段"+name + "";
//		}
		
		// 5.截取M 必填项
		int m = newValue.indexOf("M");
		if (m != -1) {
			if (value==null || "".equals(value)) {
				return "字段"+name + "不能为空,请填写值!";
			}else{
				// 4.截取N 数字
				int n = newValue.indexOf("N");
				if (n != -1) {
					boolean b = value.matches("^\\d*$"); //^[0-9]*$
					if (!b) {
						return "附属卡:字段"+name + "只能填写数字!";
					}
				}
			}
		}

		// 6.截取位数
		int numberIndex = fieldName.lastIndexOf("_");

		if (numberIndex != -1) {
			String numberValue = fieldName.substring(numberIndex + 3);
			int number = Integer.valueOf(numberValue); //定义的最大长度值
			int b=0;
			try {
			  if(null!=value&&!"".equals(value)&&!"null".equals(value)){
				b = new String(value.getBytes("GBK"),"ISO8859_1").length();
			  }	
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //送过来的长度值
			if (b>number) {
				System.out.println("b.size()====>"+b);
				return "附属卡:字段"+name + "长度过长!";
			}
		}
		return "";
	}

	/**
	 * 使用反射根据属性名称获取属性值
	 * 
	 * @param fieldName
	 *            属性名称
	 * @param o
	 *            操作对象
	 * @return Object 属性值
	 */
	private static String getFieldValueByName(Object obj,String filedName) {
		try {
			String firstLetter = filedName.substring(0, 1).toUpperCase();
			String getter = "get" + firstLetter +filedName.substring(1);
			Method method = obj.getClass().getMethod(getter);
			Object value = method.invoke(obj);
			String retValue = String.valueOf(value);
			if (retValue != null && !"".equals(retValue)) {
				return retValue;
			} else {
				return "";
			}
		} catch (Exception e) {
			log.error("getFieldValueByName方法异常" + e);
			e.printStackTrace();
			return null;
		}
	}

	public static String getWriteModelFromDaoModel(Object aModel) {
		// 信息
		String msg = "";
		if (aModel == null) {
			return null;
		}
		Field awFields[] = aModel.getClass().getDeclaredFields();
		System.out.println("总字段数："+awFields.length);
		try {
			// 遍历属性值
			for (Field field : awFields) {
				// 获取现有值
				String nowValue = getFieldValueByName(aModel,field.getName());
				// 判断是否是 字符 数字 长度
				msg = getLowerCaseFieldName(field.getName(), nowValue);
				if (msg != "") {
					return msg;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("getWriteModelFromDaoModel方法异常" + e);
		}
		return msg;
	}

}
