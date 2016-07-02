package com.ideal.spdb.utils;

import javax.inject.Inject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ideal.spdb.datadictionary.service.ISysDatadictionarService;
import com.ideal.spdb.system.model.PbLogSystemRunModel;
import com.ideal.spdb.system.model.SysOperateLogModel;
import com.ideal.spdb.system.model.SysUserModel;
import com.ideal.spdb.system.service.ISysLogService;
import com.opensymphony.xwork2.ActionContext;

/**
 * 
 * <p>Title:  浦发五星项目</p>
 * <p>Description:添加系统日志</p>
 * <p>Company: 上海理想信息产业(集团)有限公司</p>
 * @author dinghui
 * create date: 2012-1-10
 * @version 1.0
 */
@Service("systemLog")
public class SystemLog implements ISystemLog{
	private  Logger logger = Logger.getLogger(SystemLog.class);
	@Inject  ISysLogService sysLogService;
	@Inject ISysDatadictionarService sysDatadictionarService;
	
	
	
	/**
	 * 添加系统操作日志
	 * @param operateContent操作内容
	 */
	public  void addOperateLog(String operateContent)throws Exception{
		SysOperateLogModel logModel=null; 
		SysUserModel sysUserModel = (SysUserModel) ActionContext.getContext().getSession().get(Constants.USERINFO_SESSION_ATTRIBUTE);
//		String ip=NetworkTools.getIpAddrByRequest(ServletActionContext.getRequest());
//		if(Constants.LOCALHOST_IP.equals(ip)){
//			ip=NetworkTools.getRealIp();
//		}
//		String mac=NetworkTools.getMACAddress(ip);
		if (null != sysUserModel) {
			logModel = new SysOperateLogModel();
			//操作人编号
			logModel.setOperateUser(sysUserModel.getManagerNo());
			//操作内容
			logModel.setOperateContent(operateContent);
			sysLogService.add("sysLog.addOperateLog", logModel);
		}
	}
	
	/**
	 * 增加系统异常日志
	 * @param exceptionOutline 异常概要
	 * @param exceptionContent 异常详细信息
	 */
	public void addExceptionLog(String exceptionOutline,String exceptionContent){
		SysOperateLogModel exceptionLogModel = new SysOperateLogModel();
		try {
			exceptionLogModel.setSoleId(sysDatadictionarService.getSequenceValue(Constants.SEQ_CREATE_TYPE_FIVE));
			exceptionLogModel.setExceptionOutline(exceptionOutline);
			exceptionLogModel.setExceptionContent(exceptionContent);
			sysLogService.add("sysLog.addExceptionLog",exceptionLogModel);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("增加系统操作异常日志时发生异常:", e);
		}
	}
	
    /**
     * 增加系统运行日志
     * @param systemRunModel实体
     */
	public void addSystemRunLog(PbLogSystemRunModel logSystemRunModel)throws Exception{
		logSystemRunModel.setLogSystemRunId(sysDatadictionarService.getSequenceValue(logSystemRunModel.getInSystemId()));
		sysLogService.addSystemRunLog(logSystemRunModel);
	}
	
	

    /**
     * 增加系统运行日志
     * @param systemRunModel实体
     */
	public void addSystemRunLog(String functionName,String opertionDesc,String result)throws Exception{
		
		PbLogSystemRunModel logSystemRunModel = new PbLogSystemRunModel();
		logSystemRunModel.setOpertionDesc(opertionDesc);
		logSystemRunModel.setResult(result);
		logSystemRunModel.setFunctionName(functionName);
		
		logSystemRunModel.setLogSystemRunId(sysDatadictionarService.getSequenceValue(logSystemRunModel.getInSystemId()));
		sysLogService.addSystemRunLog(logSystemRunModel);
	}

	public void addApplicationRunLog(int step,String functionName, String opertionDesc,
			boolean result)  {
		
		logger.info(functionName+opertionDesc+result);
		
		// TODO Auto-generated method stub  
		PbLogSystemRunModel logSystemRunModel = new PbLogSystemRunModel();
		
		logSystemRunModel.setStepSeq(String.valueOf(step));
		logSystemRunModel.setOpertionDesc(opertionDesc);
		if(result){

			logSystemRunModel.setResult("成功");
		}else{
			logSystemRunModel.setResult("失败");
		}
		
		logSystemRunModel.setFunctionName(functionName);
		
		
		logSystemRunModel.setType("1");
		try {
			logSystemRunModel.setLogSystemRunId(sysDatadictionarService.getSequenceValue(logSystemRunModel.getInSystemId()));

			sysLogService.addSystemRunLog(logSystemRunModel);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block  
			e.printStackTrace();
		}
	}
}
