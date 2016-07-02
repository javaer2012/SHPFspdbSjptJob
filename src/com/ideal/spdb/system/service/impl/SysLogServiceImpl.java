package com.ideal.spdb.system.service.impl;



import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

import com.ideal.spdb.system.dao.ISysLogDao;
import com.ideal.spdb.system.model.PbLogSystemRunModel;
import com.ideal.spdb.system.model.SysOperateLogModel;
import com.ideal.spdb.system.service.ISysLogService;
import com.ideal.spdb.utils.BaseServiceImpl;
import com.ideal.spdb.utils.Constants;
import com.ideal.spdb.utils.Pagenation;

/**
 * 
 * <p>Title:  浦发五星项目</p>
 * <p>Description:系统操作日志管理service实现类</p>
 * <p>Company:上海理想信息产业(集团)有限公司</p>
 * @author wls
 * create date: 2011-10-9
 * @version 1.0
 */
@Service("sysLogService")
public class SysLogServiceImpl extends BaseServiceImpl<SysOperateLogModel> implements
		ISysLogService {
	@Inject ISysLogDao sysLogDao;
	/**
	 * 添加运行日志
	 * 
	 * @param logSystemRunModel
	 *            实体
	 * @return 返回操作结果
	 */
	public boolean addSystemRunLog(PbLogSystemRunModel logSystemRunModel)
			throws Exception {
		return sysLogDao.addSystemRunLog(logSystemRunModel);
	}
	
	  /**
     * 查询系统运行日志总记录数
     * @param logSystemRunModel  实体
     * @return 返回总记录数
     * @throws Exception 抛出所有异常
     */
    public int getSysRunLogCount(PbLogSystemRunModel logSystemRunModel)throws Exception{
    	return sysLogDao.getSysRunLogCount(logSystemRunModel);
    }
    /**
     * 查询系统运行日志集合
     * @param classMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
     * @param logSystemRunModel  实体
     * @return 返回系统运行日志集合
     * @throws Exception抛出所有异常
     */
    public Pagenation querySysRunLog(String classMethod,PbLogSystemRunModel logSystemRunModel)throws Exception{
    	int count=sysLogDao.getSysRunLogCount(logSystemRunModel);
		Pagenation pagenation=new Pagenation(Constants.PAGE_SIZE,logSystemRunModel.getPageNum().intValue(),count);
		logSystemRunModel.setStartRow(pagenation.getStartRow());
		pagenation.setList(sysLogDao.querySysRunLog(classMethod,logSystemRunModel));
		return pagenation;
    }
    
    /**
     * 查询系统运行日志集合
     * @param classMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
     * @param logSystemRunModel  实体
     * @return 返回系统运行日志集合
     * @throws Exception抛出所有异常
     */
   public List<PbLogSystemRunModel> querySysRunLogAll(String classMethod,PbLogSystemRunModel logSystemRunModel)throws Exception{
	   return sysLogDao.querySysRunLog(classMethod,logSystemRunModel);
   }
    
    /**
     * 查找系统运行日志详细信息
     * @param logSystemRunModel 实体
     * @return 返回查找结果
     * @throws Exception 抛出所有异常
     */
    public PbLogSystemRunModel findByRunLog(PbLogSystemRunModel logSystemRunModel)throws Exception{
    	return sysLogDao.findByRunLog(logSystemRunModel);
    }
	
}
