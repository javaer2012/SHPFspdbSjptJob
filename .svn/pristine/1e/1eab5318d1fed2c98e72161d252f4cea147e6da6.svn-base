package com.ideal.spdb.system.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ideal.spdb.system.dao.ISysUserDao;
import com.ideal.spdb.system.model.SysUserModel;
import com.ideal.spdb.utils.BaseDaoImpl;

/**
 * 
 * <p>Title:  浦发五星项目</p>
 * <p>Description:用户管理dao实现</p>
 * <p>Company: 上海理想信息产业(集团)有限公司</p>
 * @author wls
 * create date: 2011-8-31
 * @version 1.0
 */
@Repository("sysUserDao")
public class SysUserDaoImpl extends BaseDaoImpl<SysUserModel> implements ISysUserDao{
	/**
	 * 检测用户登录
	 * @param model实体
	 * @return 检测结果
	 */
	public int checkLogin(SysUserModel model) throws Exception{
		return (Integer) this.getSqlSession().selectOne("sysUser.sysUserLogin",model);
	}
	
	/**
	 * 查询用户信息
	 * @param model实体
	 * @return 检测结果
	 */
	public SysUserModel  queryUserInfo(SysUserModel model)throws Exception{
		return (SysUserModel) this.getSqlSession().selectOne("sysUser.getUserInfo",model);
	}
	
	/**
     * 添加用户对应的角色
     * @param model model实体
     * @throws Exception抛出所有异常
     */
    public void addUserRole(SysUserModel model)throws Exception{
    	this.getSqlSession().insert("sysUser.addUserRole",model);
    }
    
    /**删除用户对应的角色
     * @param model model实体
     * @throws Exception抛出所有异常
     */
    public void deleteUserRole(List<String>list)throws Exception{
    	this.getSqlSession().delete("sysUser.deleteUserRole",list);
    }
    /**
     * 修改用户对应的角色
     * @param model model实体
     * @throws Exception抛出所有异常
     */
    public void updateUserRole(SysUserModel model)throws Exception{
    	this.getSqlSession().update("sysUser.updateUserRole",model);
    }
    public SysUserModel queryUserInfoByManagerId(SysUserModel model)throws Exception{
    	return (SysUserModel) this.getSqlSession().selectOne("sysUser.getUserInfoByManagerNo",model);
    }
}
