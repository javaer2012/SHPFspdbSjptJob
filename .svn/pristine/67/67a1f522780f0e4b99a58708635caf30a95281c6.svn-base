package com.ideal.spdb.thirdinfo.work.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.ideal.spdb.utils.BaseModel;

public class MakeTxtUtil {
	 private static final Logger log = Logger.getLogger(MakeTxtUtil.class);
	  public static MakeTxtUtil instance = null;
	  public static synchronized MakeTxtUtil getInstance(){
		  if (instance == null) {
		      return MakeTxtUtil.instance = new MakeTxtUtil();
		  }
		  return instance;
	  }
	  
	  public BaseWriteModel getTxtWriteModel(BaseModel bm,BaseWriteModel swm){
		  if (bm == null) {
		      return null;
		  }
		  Field[] awFields = swm.getClass().getDeclaredFields();
		    try{
		      for (Field field : awFields){
		        String nowFieldName = getLowerCaseFieldName(field.getName());

		        String nowValue = getFieldValueByName(nowFieldName, bm);

		        BeanUtils.setProperty(swm, field.getName(), nowValue);
		      }
		    }
		    catch (Exception e){
		      log.error("getWriteModelFromDaoModel方法异常" + e);
		    }
		  return swm;
	  }
	  
	  public BaseWriteModel getTxtWriteModelNoCase(BaseModel bm,BaseWriteModel swm){
		  if (bm == null) {
		      return null;
		  }
		  Field[] awFields = swm.getClass().getDeclaredFields();
		    try{
		      for (Field field : awFields){
		        String nowFieldName = getFieldName(field.getName());

		        String nowValue = getFieldValueByName(nowFieldName, bm);

		        BeanUtils.setProperty(swm, field.getName(), nowValue);
		      }
		    }
		    catch (Exception e){
		      log.error("getWriteModelFromDaoModel方法异常" + e);
		    }
		  return swm;
	  }
	  
	  /**
	   * 将传入的String截取
	   * @param fieldName
	   * @return
	   */
	  private String getFieldName(String fieldName){
		  if (fieldName == null) {
		      return "";
		    }
		    String retSting = "";
		    int iPos = fieldName.lastIndexOf("M");
		    if ((iPos > 0) && (fieldName.length() - iPos < 6)) {
		      retSting = fieldName.substring(0, iPos);

		      return retSting;
		    }
		    iPos = fieldName.lastIndexOf("S");
		    if ((iPos > 0) && (fieldName.length() - iPos < 6)) {
		      retSting = fieldName.substring(0, iPos);
		      return retSting;
		    }
		    iPos = fieldName.lastIndexOf("N");
		    if ((iPos > 0) && (fieldName.length() - iPos < 6)) {
		      retSting = fieldName.substring(0, iPos);
		      return retSting;
		    }
		    return "";
	  }
	  
	  /**
	   * 将传入的String转换成小写字符
	   * @param fieldName 传入需要小写的字符串
	   * @return
	   */
	  private String getLowerCaseFieldName(String fieldName) {
		    
		    if (fieldName == null) {
		      return "";
		    }
		    String retSting = "";

		    int iPos = fieldName.lastIndexOf("M");
		    if ((iPos > 0) && (fieldName.length() - iPos < 5)) {
		      retSting = fieldName.substring(0, iPos);

		      return retSting.toLowerCase();
		    }

		    iPos = fieldName.lastIndexOf("S");
		    if ((iPos > 0) && (fieldName.length() - iPos < 6)) {
		      retSting = fieldName.substring(0, iPos);
		      return retSting.toLowerCase();
		    }

		    iPos = fieldName.lastIndexOf("N");
		    if ((iPos > 0) && (fieldName.length() - iPos < 5)) {
		      retSting = fieldName.substring(0, iPos);
		      return retSting.toLowerCase();
		    }

		    return "";
		  }
	  
	  /**
	   * 获得字段的get方法
	   * @param fieldName
	   * @param o
	   * @return
	   */
	  private String getFieldValueByName(String fieldName, Object o) {
		   
		    try {
		      String firstLetter = fieldName.substring(0, 1).toUpperCase();

		      String getter = "get" + firstLetter + fieldName.substring(1);
		      Method method = o.getClass().getMethod(getter, new Class[0]);
		      Object value = method.invoke(o, new Object[0]);
		      String retValue = String.valueOf(value);
		      if ((retValue != null) && (!retValue.equals("null"))) {
		        return retValue;
		      }
		      return "";
		    }
		    catch (Exception e){
		      log.error("getFieldValueByName方法异常" + e);
		    }return null;
		  }
	  /**
	   * 根据传入的模型，增加空格和0
	   * @param bwm 写入模型
	   * @return
	   */
	  public String bulidComplementASpace(BaseWriteModel bwm)
	  {
	   
	    if (bwm == null) {
	      return null;
	    }
	    StringBuffer sb = new StringBuffer();
	    Field[] declaredFields = bwm.getClass().getDeclaredFields();
	    try
	    {
	      for (Field field : declaredFields) {
	        String nowValue = BeanUtils.getProperty(bwm, field
	          .getName());

	        String newValue = getNewValue(field.getName(), nowValue);

	        sb.append(newValue);
	      }
	    } catch (IllegalAccessException e) {
	      log.error("bulidComplementASpace方法异常" + e);
	    } catch (InvocationTargetException e) {
	      log.error("bulidComplementASpace方法异常" + e);
	    } catch (NoSuchMethodException e) {
	      log.error("bulidComplementASpace方法异常" + e);
	    }

	    sb.append("\r\n");

	    return sb.toString();
	  }
	  
	  
	  /**
	   * 
	   * @param fieldName 字段名字
	   * @param nowValue	现存的值
	   * @return
	   */
	  private String getNewValue(String fieldName, String nowValue) {
		    
		    if (fieldName == null) {
		      return "";
		    }
		    System.out.println(fieldName);
		    String cc = "";

		    int iPos = fieldName.lastIndexOf("M");
		    if ((iPos > 0) && (fieldName.length() - iPos < 6)) {
		      cc = fieldName
		        .substring(iPos + 1, fieldName.length());

		      return createZeroString(nowValue, Integer.parseInt(cc));
		    }

		    iPos = fieldName.lastIndexOf("S");
		    if ((iPos > 0) && (fieldName.length() - iPos < 6)) {
		      cc = fieldName.substring(iPos + 1, fieldName.length());
		      return CreateSpaceString(nowValue, Integer.parseInt(cc));
		    }

		    iPos = fieldName.lastIndexOf("N");
		    if ((iPos > 0) && (fieldName.length() - iPos < 6)) {
		      cc = fieldName.substring(iPos + 1, fieldName.length());
		      return createZeroString(nowValue, Integer.parseInt(cc));
		    }

		    return "";
		  }
	  
	  /**
	   * 加空格
	   * @param nowValue 现在的值
	   * @param spaceNum 加空格的个数
	   * @return
	   */
	  private String CreateSpaceString(String nowValue, int spaceNum)
	  {
	   
	    StringBuffer newSB = new StringBuffer();

	    String anotherString = null;
	    try {
	      anotherString = new String(nowValue.getBytes("GBK"), "ISO8859_1");
	    } catch (UnsupportedEncodingException e) {
	      log.error("CreateSpaceString方法异常" + e);
	    }
	    int iNum = spaceNum - anotherString.length();

	    newSB.append(nowValue);

	    for (int i = 0; i < iNum; i++) {
	      newSB.append(" ");
	    }

	    return newSB.toString();
	  }
	  /**
	   * 加0的个数
	   * @param nowValue 现在的值
	   * @param zeroNum 加0的个数
	   * @return
	   */
	  private String createZeroString(String nowValue, int zeroNum) {
	    
	    StringBuffer newSB = new StringBuffer();

	    int iNum = zeroNum - nowValue.length();

	    for (int i = 0; i < iNum; i++) {
	      newSB.append("0");
	    }
	    newSB.append(nowValue);

	    return newSB.toString();
	  }

}
