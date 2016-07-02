/**  
 *@Copyright:Copyright (c) 2011 - 2100  
 *@Company:FBI
 */
package com.ideal.spdb.utils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 * @Author: AlexHe
 * @CrateDate:2012-8-13
 * @Version:1.1.0
 * @FunctionName:
 * @Description :
 * @Modify History: ----------------------------------
 * 
 */
public class ApplicationUtil {
	private static final Logger log = Logger.getLogger(ApplicationUtil.class);
	public static ApplicationUtil instance = null;

	private ApplicationUtil() {
		
	}

	public synchronized static ApplicationUtil getInstance() {
		if (instance == null) {
			return instance = new ApplicationUtil();
		}
		return instance;
	}

	/**
	 * @param fieldName属性名称
	 *            .(根据属性名称获取当前值应有的位数)
	 * @param nowValue现在的值
	 * @return
	 * @throws Exception 
	 * @Description: 对于不满足位数的值，补全空格
	 */
	public static String getLowerCaseFieldName(String fieldName, String value,Object obj,Object chineseData) throws Exception {
		// 获取值
	    
		Field declaredFields[] = fieldName.getClass().getDeclaredFields();
		if (StringUtils.isEmpty(fieldName)||(fieldName.lastIndexOf("_")==-1)||fieldName.lastIndexOf("Desc")!=-1) {
			return "";
		}
		
	    // 获取字段名
		String name = fieldName.substring(0, fieldName.lastIndexOf("_"));
		name=name.replace("_","");
        //获取该字段的中文形式
        String chinese="";
		//对特殊字符做校验
        if(!StringUtils.isEmpty(value)){
            chinese=getModelFieldValueByName(chineseData,name+"Desc");
            String regEx = "[`~!#$%^*()+={}':;',\\[\\]<>/?~！#￥%……*（）——+{}【】‘；：”“’。，、？]";
            Pattern p = Pattern.compile(regEx);
            Matcher matcher = p.matcher(value);
            if(matcher.find()){
                return "字段"+chinese + "存在特殊字符!"; 
            }        
        }
		
		String retSting = "";
		String rexp = "";

		// 截取属性名称中的字符串 位数 数字
		// 1.截取 "_"
		int index = fieldName.lastIndexOf("_");
		String newValue = fieldName.substring(index + 1);
		
		  //对不为空的项做数字校验
	      if(!StringUtils.isEmpty(value)){
	            chinese=getModelFieldValueByName(chineseData,name+"Desc");
	             //校验数字
	            int n = newValue.indexOf("N");
	            if (n != -1) {
	                boolean b = value.matches("^\\d*$"); //^[0-9]*$
	                if (!b) {
	                    return "字段"+chinese + "只能填写数字!";
	                }
	            }
	            

	            //校验长度
	            int numberIndex = fieldName.lastIndexOf("_");
	            if (numberIndex != -1) {
	                String numberValue = fieldName.substring(numberIndex + 3);
	                int number = Integer.valueOf(numberValue); //定义的最大长度值
	                int b=0;
	                try {
	                  if(!StringUtils.isEmpty(value)){
	                    b = new String(value.getBytes("GBK"),"ISO8859_1").length();
	                  } 
	                } catch (UnsupportedEncodingException e) {
	                    e.printStackTrace();
	                } 
	                if (b>number) {
	                    return "字段"+chinese + "长度过长!";
	                }
	            }
	      }
	      
	      
	    /***  
		// 2.截取A字符
		int a = newValue.lastIndexOf("A");
		if (a != -1) {
			return "字段"+name + "请填写正确的字符!";
		}

		// 3.截取O非必须填的项 可以 不作判断
		int o = fieldName.lastIndexOf("O");
		if (o != -1) {
			return "字段"+name + "";
		}
		**/
	      
	      
	      
		// 5.截取M 必填项
		int m = newValue.indexOf("M");
		if (m != -1) {
		    chinese=getModelFieldValueByName(chineseData,name+"Desc");
			if (StringUtils.isEmpty(value)) {
				return "字段"+chinese + "不能为空,请填写值!";
			}else{
				// 4.截取N 数字
				int n = newValue.indexOf("N");
				if (n != -1) {
					boolean b = value.matches("^\\d*$"); //^[0-9]*$
					if (!b) {
						return "字段"+chinese + "只能填写数字!";
					}
				}
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

	public static String getWriteModelFromDaoModel(Object aModel,Object chineseData) {
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
				msg = getLowerCaseFieldName(field.getName(), nowValue,aModel,chineseData);
				if (!StringUtils.isEmpty(msg)) {
					return msg;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("getWriteModelFromDaoModel方法异常" + e);
		}
		return msg;
	}
	
    public static String getModelFieldValueByName(Object obj, String filedName) throws Exception {
        int length = filedName.length();
        String firstName = filedName.substring(0, 1).toUpperCase();
        String secondName = filedName.substring(1, length);
        String getter = "get" + firstName + secondName;
        Method method = obj.getClass().getMethod(getter);
        Object value = method.invoke(obj);
        String retValue = String.valueOf(value);
        return retValue;
    }
	
	//清除实体类相关字段的的空格
	public static void cleanBlankSpace(Object aModel) throws Exception{
	    if(null==aModel){
	        throw new IllegalArgumentException("操作的实体不能为空！");
	    }
	    Field awFields[] = aModel.getClass().getDeclaredFields();
        for (Field field : awFields) {
            String value = getModelFieldValueByName(aModel,field.getName());
            if(!StringUtils.isEmpty(value)){
                value.trim();
            }
        }
	}
	
	// public static void main(String[] args) {
	// String sendString = "wang_aaa";
	// String aa = sendString.substring(0, sendString.lastIndexOf("_"));
	//
	// System.out.print(aa);
	// }
}
