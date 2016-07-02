package com.ideal.spdb.system.dao;

import java.util.List;

import com.ideal.spdb.system.model.PbLogSystemRunModel;
import com.ideal.spdb.system.model.SysOperateLogModel;
import com.ideal.spdb.utils.BaseDao;

/**
 * 
 * <p>Title:  浦发五星项目</p>
 * <p>Description:系统操作日志管理dao接口</p>
 * <p>Company: 上海理想信息产业(集团)有限公司</p>
 * @author wls
 * create date: 2011-10-9
 * @version 1.0
 */
public interface ISysLogDao extends BaseDao<SysOperateLogModel>{
	/**
	 * 添加运行日志
	 * @param logSystemRunModel 实体
	 * @return 返回操作结果
	 */
    boolean addSystemRunLog(PbLogSystemRunModel logSystemRunModel)throws Exception;
    /**
     * 查询系统运行日志总记录数
     * @param logSystemRunModel  实体
     * @return 返回总记录数
     * @throws Exception 抛出所有异常
     */
    int getSysRunLogCount(PbLogSystemRunModel logSystemRunModel)throws Exception;
    /**
     * 查询系统运行日志集合
     *  @param classMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
     *  @param logSystemRunModel  实体
     * @return 返回系统运行日志集合
     * @throws Exception抛出所有异常
     */
    List<PbLogSystemRunModel>querySysRunLog(String classMethod,PbLogSystemRunModel logSystemRunModel)throws Exception;
    
    /**
     * 查找系统运行日志详细信息
     * @param logSystemRunModel 实体
     * @return 返回查找结果
     * @throws Exception 抛出所有异常
     */
    PbLogSystemRunModel findByRunLog(PbLogSystemRunModel logSystemRunModel)throws Exception;

}
