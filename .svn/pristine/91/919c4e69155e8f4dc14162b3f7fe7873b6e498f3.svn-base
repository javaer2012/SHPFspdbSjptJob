package com.ideal.spdb.system.service;

import java.util.List;

import com.ideal.spdb.system.model.SysUserModel;
import com.ideal.spdb.utils.BaseService;

/**
 * 
 * <p>Title:  浦发五星项目</p>
 * <p>Description:用户管理service接口</p>
 * <p>Company: 上海理想信息产业(集团)有限公司</p>
 * @author wls
 * create date: 2011-8-31
 * @version 1.0
 */
public interface ISysUserService extends BaseService<SysUserModel>{
	/**
	 * 检测用户登录
	 * @param model实体
	 * @return 检测结果
	 */
	boolean checkLogin(SysUserModel model)throws Exception;
	/**
	 * 查询用户信息
	 * @param model实体
	 * @return 检测结果
	 */
	SysUserModel queryUserInfo(SysUserModel model)throws Exception;
	/**
     * 添加用户及对应的角色
     * @param model model实体
     * @throws Exception抛出所有异常
     */
	boolean  addUser(SysUserModel model)throws Exception;
	 /**删除用户对应的角色
     * @param model model实体
     * @throws Exception抛出所有异常
     */
     boolean deleteUser(List<String>list)throws Exception;
    /**
     * 修改用户对应的角色
     * @param model model实体
     * @throws Exception抛出所有异常
     */
    boolean  updateUser(SysUserModel model)throws Exception;
    

    /**
     * 修改组织负责人为空
     * @param model model实体
     * @throws Exception抛出所有异常
     */
    boolean updateOrgPrincipal(SysUserModel model)throws Exception;
}
