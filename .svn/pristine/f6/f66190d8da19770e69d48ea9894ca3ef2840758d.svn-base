package com.ideal.spdb.system.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ideal.spdb.system.dao.ISysUserDao;
import com.ideal.spdb.system.model.SysUserModel;
import com.ideal.spdb.system.service.ISysUserService;
import com.ideal.spdb.utils.BaseServiceImpl;

/**
 * 
 * <p>
 * Title:  浦发五星项目
 * </p>
 * <p>
 * Description:用户管理sevice
 * </p>
 * <p>
 * Company: 上海理想信息产业(集团)有限公司
 * </p>
 * 
 * @author wls create date: 2011-8-31
 * @version 1.0
 */
@Service("sysUserService")
public class SysUserServiceImpl extends BaseServiceImpl<SysUserModel> implements
		ISysUserService {
	private static final long serialVersionUID = 1L;
	
	@Inject ISysUserDao sysUserDao;

	/**
	 * 检测用户登录
	 * 
	 * @param model实体
	 * @return 检测结果
	 */
	public boolean checkLogin(SysUserModel model) throws Exception {
		return sysUserDao.checkLogin(model) > 0 ? true : false;
	}

	/**
	 * 查询用户信息
	 * 
	 * @param model实体
	 * @return 检测结果
	 */
	public SysUserModel queryUserInfo(SysUserModel model) throws Exception {
		return sysUserDao.queryUserInfo(model);
	}

	/**
	 * 添加用户及对应的角色
	 * 
	 * @param model
	 *            model实体
	 * @throws Exception抛出所有异常
	 */
	public boolean addUser(SysUserModel model) throws Exception {
		boolean flag = true;
		try {
			sysUserDao.add("sysUser.addUser", model);
			sysUserDao.addUserRole(model);
		} catch (Exception e) {
			flag = false;
			throw e;
		}
		return flag;
	}

	/**
	 * 删除用户对应的角色
	 * 
	 * @param model
	 *            model实体
	 * @throws Exception抛出所有异常
	 */
	public boolean deleteUser(List<String> list) throws Exception {
		boolean flag = true;
		try {
			sysUserDao.batchDelete("sysUser.deleteUser", list);
			sysUserDao.deleteUserRole(list);
			//2015-1-15增，物理删除
			sysUserDao.batchDelete("sysUser.deleteUser2", list);
		} catch (Exception e) {
			flag = false;
			throw e;
		}
		return flag;
	}

	/**
	 * 修改用户对应的角色
	 * 
	 * @param model
	 *            model实体
	 * @throws Exception抛出所有异常
	 */
	public boolean updateUser(SysUserModel model) throws Exception {
		boolean flag = true;
		try {
			sysUserDao.edit("sysUser.editUser", model);
			sysUserDao.updateUserRole(model);
		} catch (Exception e) {
			flag = false;
			throw e;
		}
		return flag;
	}

	/**
	 * 修改组织负责人为空
	 * 
	 * @param model
	 *            model实体
	 * @throws Exception抛出所有异常
	 */
	public boolean updateOrgPrincipal(SysUserModel model) throws Exception {
		boolean flag = true;
		try {
			if(null == model.getManagerNo()){
				sysUserDao.edit("sysUser.updateOrgPrincipalWithId", model);
			}else{
				sysUserDao.edit("sysUser.updateOrgPrincipalWithNo", model);
			}
		} catch (Exception e) {
			flag = false;
			throw e;
		}
		return flag;
	}

}
