package com.ideal.spdb.utils;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.ideal.spdb.datadictionary.service.ISysDatadictionarService;
import com.ideal.spdb.system.model.SysOperateLogModel;
import com.ideal.spdb.system.model.SysUserModel;
import com.ideal.spdb.system.service.ISysLogService;
import com.opensymphony.xwork2.ActionContext;

/**
 * 
 * <p>
 * Title:  浦发五星项目
 * </p>
 * <p>
 * Description:系统操作日志处理切面类
 * </p>
 * <p>
 * Company: 上海理想信息产业(集团)有限公司
 * </p>
 * 
 * @author dinghui create date: 2011-9-3
 * @version 1.0
 */
@Aspect
@Component
public class LogAspect {
	private  Logger logger = Logger.getLogger(LogAspect.class);
	
	@Inject ISysLogService sysLogService;
	@Inject ISysDatadictionarService sysDatadictionarService;

	/**
	 * 后置通知 （注解，是指定该方法体为后置通知，其有一个表达式参数， 用来检索符合条件的切点。该表达式指定com/medbri/integration
	 * 目录下及其所有子目录下的所有带有@OperateLog注解的方法体为切点。）
	 * 
	 * @param jp是切点对象
	 *            ，通过该对象可以获取切点所切入方法所在的类，方法名、参数等信息
	 * @param ol则是我们的自定义注解的对象
	 *            ，通过该对象我们可以获取注解中参数值，从而获取方法的描述信息取得所操作的系统内容
	 */
	@AfterReturning(Constants.AOP_WITHIN+"&& @annotation(ol)")
	public void addOperateLog(JoinPoint jp, OperateLog ol){
		logger.info("调用后置通知!");
		try {
			SysOperateLogModel logModel = new SysOperateLogModel();
			SysUserModel sysUserModel = (SysUserModel) ActionContext
					.getContext().getSession().get(Constants.USERINFO_SESSION_ATTRIBUTE);
//			String ip=NetworkTools.getIpAddrByRequest(ServletActionContext.getRequest());
//			if(Constants.LOCALHOST_IP.equals(ip)){
//				ip=NetworkTools.getRealIp();
//			}
//			String mac=NetworkTools.getMACAddress(ip);
			if (null != sysUserModel) {
				logModel.setSoleId(sysDatadictionarService.getSequenceValue(Constants.SEQ_CREATE_TYPE_FIVE));
				logModel.setOperateUser(sysUserModel.getManagerNo());
				logModel.setOperateContent(ol.content());
				sysLogService.add("sysLog.addOperateLog", logModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("增加系统操作日志时发生异常:", e);
		}
	}

	/**
	 * 异常通知 （注解，是指定该方法体为后置通知，其有一个表达式参数， 用来检索符合条件的切点。该表达式指定com/medbri/medbri
	 * 目录下及其所有子目录下的所有带有@OperateLog注解的方法体在执行时抛出Exception异常时该通知便会执行。）
	 * 
	 * @param jp是切点对象
	 *            ，通过该对象可以获取切点所切入方法所在的类，方法名、参数等信息
	 * @param ol则是我们的自定义注解的对象
	 *            ，通过该对象我们可以获取注解中参数值，从而获取方法的描述信息取得所操作的系统内容
	 * @param ex异常
	 */
	@AfterThrowing(pointcut = Constants.AOP_WITHIN, throwing = "ex")
	public void addExceptionLog(JoinPoint jp,Exception ex){
		logger.info("调用异常通知!");
		try {
			String className = jp.getTarget().getClass().getName();// 获取目标类名
			String signature = jp.getSignature().toString();// 获取目标方法签名
			StringBuilder sb = new StringBuilder();
			sb.append("运行");
			sb.append(className);
			sb.append("类的");
			if (null != signature) {
				String methodName = signature.substring(
						signature.lastIndexOf(".") + 1, signature.indexOf("("));// 截取得到发生异常的方法名
				sb.append(methodName);
			}
			sb.append("方法运行时发生异常:");
			sb.append(ex.getMessage());
			logger.info(sb.toString());
//			SysOperateLogModel exceptionLogModel = new SysOperateLogModel();
//			exceptionLogModel.setSoleId(sysDatadictionarService.getSequenceValue(Constants.SEQ_CREATE_TYPE_FIVE));
//			exceptionLogModel.setExceptionOutline(ex.toString());
//			exceptionLogModel.setExceptionContent(sb.toString());
//			sysLogService.add("sysLog.addExceptionLog",exceptionLogModel);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("增加系统操作异常日志时发生异常:", e);
		}
	}
}
