package com.ideal.spdb.system.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ideal.spdb.system.dao.ISysLogDao;
import com.ideal.spdb.system.model.PbLogSystemRunModel;
import com.ideal.spdb.system.model.SysOperateLogModel;
import com.ideal.spdb.utils.BaseDaoImpl;

/**
 * 
 * <p>
 * Title: 浦发五星项目
 * </p>
 * <p>
 * Description:系统操作日志管理dao实现类
 * </p>
 * <p>
 * Company: 上海理想信息产业(集团)有限公司
 * </p>
 * 
 * @author wls create date: 2011-10-9
 * @version 1.0
 */
@Repository("sysLogDao")
public class SysLogDaoImpl extends BaseDaoImpl<SysOperateLogModel> implements
		ISysLogDao {
	/**
	 * 添加运行日志
	 * 
	 * @param logSystemRunModel
	 *            实体
	 * @return 返回操作结果
	 */
	public boolean addSystemRunLog(PbLogSystemRunModel logSystemRunModel)
			throws Exception {
		boolean flag = false;
	/*	try {
			flag = this.getSqlSession().insert("sysLog.addSystemRunLog",
					logSystemRunModel) > 0 ? true : false;
		} catch (Exception e) {
			flag = false;
			throw e;
		}*/
		return flag;
	}
	 /**
     * 查询系统运行日志总记录数
     * @param logSystemRunModel  实体
     * @return 返回总记录数
     * @throws Exception 抛出所有异常
     */
    public int getSysRunLogCount(PbLogSystemRunModel logSystemRunModel)throws Exception{
    	return (Integer) this.getSqlSession().selectOne("sysLog.getSysRunLogCount",logSystemRunModel);
    }
    /**
     * 查询系统运行日志集合
     * @param classMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
     * @param logSystemRunModel  实体
     * @return 返回系统运行日志集合
     * @throws Exception抛出所有异常
     */
    @SuppressWarnings("unchecked")
	public List<PbLogSystemRunModel>querySysRunLog(String classMethod,PbLogSystemRunModel logSystemRunModel)throws Exception{
    	List<PbLogSystemRunModel> list=null;
    	list=this.getSqlSession().selectList(classMethod,logSystemRunModel);
    	return list;
    }
    
    
    /**
     * 查找系统运行日志详细信息
     * @param logSystemRunModel 实体
     * @return 返回查找结果
     * @throws Exception 抛出所有异常
     */
    public PbLogSystemRunModel findByRunLog(PbLogSystemRunModel logSystemRunModel)throws Exception{
    	return (PbLogSystemRunModel) this.getSqlSession().selectOne("sysLog.findByRunLog",logSystemRunModel);
    }

}
