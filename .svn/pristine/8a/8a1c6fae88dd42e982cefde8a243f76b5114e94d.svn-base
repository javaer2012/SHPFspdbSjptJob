package com.ideal.spdb.utils;

import java.lang.reflect.Field;
import java.util.Comparator;

/**
 * 
 * <p>Title: 浦发五星项目</p>
 * <p>Description: 比较器用于自定义字段导出到Excel的列顺序</p>
 * <p>Company: 上海理想信息产业(集团)有限公司</p>
 * @author dinghui
 * create date: 2012-1-16
 * @version 1.0
 */
@SuppressWarnings("rawtypes")
public class FieldComparator  implements Comparator {
	public int compare(Object arg0, Object arg1) {  
        Field fieldOne = (Field)arg0;  
        Field fieldTwo = (Field)arg1;  
        ExcelAnnotation annoOne = fieldOne.getAnnotation(ExcelAnnotation.class);  
        ExcelAnnotation annoTwo = fieldTwo.getAnnotation(ExcelAnnotation.class);  
        if(annoOne==null||annoTwo==null){  
            return 0;  
        }  
        int result = annoOne.id()-annoTwo.id();  
        if(result>0){  
            return 1;  
        }else if(result<0){  
            return -1;  
        }else {  
            return 0;  
        }  
    }  
  
}
