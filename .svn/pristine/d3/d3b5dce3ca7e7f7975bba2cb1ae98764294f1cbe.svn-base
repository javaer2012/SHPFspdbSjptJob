package com.ideal.spdb.system.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ideal.spdb.system.dao.ISysPadDao;
import com.ideal.spdb.system.model.SysPadModel;
import com.ideal.spdb.system.service.ISysPadService;
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
@Service("sysPadService")
public class SysPadServiceImpl extends BaseServiceImpl<SysPadModel> implements
		ISysPadService {
	private static final long serialVersionUID = 1L;
	
	@Inject ISysPadDao sysPadDao;

	/**
	 * 检测用户登录
	 * 
	 * @param model实体
	 * @return 检测结果
	 */
	public boolean checkLogin(SysPadModel model) throws Exception {
		return sysPadDao.checkLogin(model) > 0 ? true : false;
	}

	/**
	 * 查询用户信息
	 * 
	 * @param model实体
	 * @return 检测结果
	 */
	public SysPadModel queryUserInfo(SysPadModel model) throws Exception {
		return sysPadDao.queryUserInfo(model);
	}

	/**
	 * 添加用户及对应的角色
	 * 
	 * @param model
	 *            model实体
	 * @throws Exception抛出所有异常
	 */
	public boolean addUser(SysPadModel model) throws Exception {
		boolean flag = true;
		try {
			sysPadDao.add("sysPad.addUser", model);
			sysPadDao.addUserRole(model);
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
			sysPadDao.batchDelete("sysPad.deleteUser", list);
			sysPadDao.deleteUserRole(list);
			//2015-1-15增，物理删除
			sysPadDao.batchDelete("sysPad.deleteUser2", list);
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
	public boolean updateUser(SysPadModel model) throws Exception {
		boolean flag = true;
		try {
			sysPadDao.edit("sysPad.editUser", model);
			sysPadDao.updateUserRole(model);
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
	public boolean updateOrgPrincipal(SysPadModel model) throws Exception {
		boolean flag = true;
		try {
			if(null == model.getManagerNo()){
				sysPadDao.edit("sysPad.updateOrgPrincipalWithId", model);
			}else{
				sysPadDao.edit("sysPad.updateOrgPrincipalWithNo", model);
			}
		} catch (Exception e) {
			flag = false;
			throw e;
		}
		return flag;
	}
}
