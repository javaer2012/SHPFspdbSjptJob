package com.ideal.spdb.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static Date StringFormatToDate(String pattern, String dateStr) throws Exception {
        if(StringUtils.isEmpty(pattern)||StringUtils.isEmpty(dateStr)){
            throw new IllegalArgumentException("日期格式或日期字符串不能为空！");
        }
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        return sdf.parse(dateStr);
    }
}
