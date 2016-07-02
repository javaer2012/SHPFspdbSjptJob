package com.ideal.spdb.system.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ideal.spdb.system.dao.ISysOrgDao;
import com.ideal.spdb.system.model.SysOrgModel;
import com.ideal.spdb.system.service.ISysOrgService;
import com.ideal.spdb.utils.BaseServiceImpl;

/**
 * 
 * <p>
 * Title:  浦发五星项目
 * </p>
 * <p>
 * Description:组织机构管理sevice
 * </p>
 * <p>
 * Company: 上海理想信息产业(集团)有限公司
 * </p>
 * 
 * @author wls create date: 2011-8-31
 * @version 1.0
 */
@Service("sysOrgService")
public class SysOrgServiceImpl extends BaseServiceImpl<SysOrgModel> implements
		ISysOrgService {
	private static final long serialVersionUID = 1L;
	
	@Inject ISysOrgDao sysOrgDao;


	/**
	 * 添加组织机构及对应的角色
	 * 
	 * @param model
	 *            model实体
	 * @throws Exception抛出所有异常
	 */
	public boolean addOrg(SysOrgModel model) throws Exception {
		boolean flag = true;
		try {
			sysOrgDao.add("sysOrg.addOrg", model);
		} catch (Exception e) {
			flag = false;
			throw e;
		}
		return flag;
	}

	/**
	 * 删除组织机构对应的角色
	 * 
	 * @param model
	 *            model实体
	 * @throws Exception抛出所有异常
	 */
	public boolean deleteOrg(List<String> list) throws Exception {
		boolean flag = true;
		try {
			sysOrgDao.batchDelete("sysOrg.deleteOrg", list);
		} catch (Exception e) {
			flag = false;
			throw e;
		}
		return flag;
	}

	/**
	 * 修改组织机构对应的角色
	 * 
	 * @param model
	 *            model实体
	 * @throws Exception抛出所有异常
	 */
	public boolean updateOrg(SysOrgModel model) throws Exception {
		boolean flag = true;
		try {
			sysOrgDao.edit("sysOrg.editOrg", model);
		} catch (Exception e) {
			flag = false;
			throw e;
		}
		return flag;
	}

}
