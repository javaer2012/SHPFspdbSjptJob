package com.ideal.spdb.utils;



/**
 * 
 * <p>Title:  浦发五星项目</p>
 * <p>Description:添加系统操作日志接口</p>
 * <p>Company: 上海理想信息产业(集团)有限公司</p>
 * @author dinghui
 * create date: 2012-1-10
 * @version 1.0
 */
public interface ISystemLog {
	/**
	 * 添加系统操作日志
	 * @param operateContent操作内容
	 */
	public  void addOperateLog(String operateContent)throws Exception;
	/**
	 * 增加系统异常日志
	 * @param exceptionOutline 异常概要
	 * @param exceptionContent 异常详细信息
	 */
	public void addExceptionLog(String exceptionOutline,String exceptionContent);
	 /**
     * 增加系统运行日志
     * @param systemRunModel实体
     */
	public void addSystemRunLog(String functionName,String opertionDesc,String result)throws Exception;
	 /**
     * 增加系统运行日志
     * @param systemRunModel实体
     */
	public void addApplicationRunLog(int step,String functionName,String opertionDesc,boolean result);
}
