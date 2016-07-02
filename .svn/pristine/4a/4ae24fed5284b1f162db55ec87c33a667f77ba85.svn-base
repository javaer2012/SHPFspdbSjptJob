package com.ideal.spdb.utils;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 
 * <p>Title:  浦发五星项目</p>
 * <p>Description:编写自定义注解。实现对方法所实现的功能进行描述，以便在通知中获取描述信息</p>
 * <p>Company: 上海理想信息产业(集团)有限公司</p>
 * @author dinghui
 * create date: 2011-9-3
 * @version 1.0
 */
@Target({ElementType.METHOD}) 
@Retention (RetentionPolicy.RUNTIME)   
@Documented  
public @interface OperateLog {
	 String content() default "无描述信息";  
}
