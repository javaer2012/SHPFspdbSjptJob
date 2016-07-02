package com.ideal.spdb.system.dao;

import java.util.List;

import com.ideal.spdb.system.model.SysPadModel;
import com.ideal.spdb.utils.BaseDao;

/**
 * 
 * <p>Title:  浦发五星项目</p>
 * <p>Description:用户管理dao接口</p>
 * <p>Company: 上海理想信息产业(集团)有限公司</p>
 * @author wls
 * create date: 2011-8-31
 * @version 1.0
 */
public interface ISysPadDao extends BaseDao<SysPadModel> {
	/**
	 * 检测用户登录
	 * @param model实体
	 * @return 检测结果
	 */
	int  checkLogin(SysPadModel model)throws Exception;
	/**
	 * 查询用户信息
	 * @param model实体
	 * @return 检测结果
	 */
	SysPadModel  queryUserInfo(SysPadModel model)throws Exception;
	
    /**
     * 添加用户对应的角色
     * @param model model实体
     * @throws Exception抛出所有异常
     */
    void addUserRole(SysPadModel model)throws Exception;
    /**删除用户对应的角色
     * @param model model实体
     * @throws Exception抛出所有异常
     */
    void deleteUserRole(List<String>list)throws Exception;
    /**
     * 修改用户对应的角色
     * @param model model实体
     * @throws Exception抛出所有异常
     */
    void updateUserRole(SysPadModel model)throws Exception;
}
