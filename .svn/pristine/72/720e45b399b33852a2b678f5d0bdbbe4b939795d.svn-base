package com.ideal.spdb.system.service;

import java.util.List;

import com.ideal.spdb.system.model.SysOrgModel;
import com.ideal.spdb.utils.BaseService;

/**
 * 
 * <p>Title:  浦发五星项目</p>
 * <p>Description:组织机构管理service接口</p>
 * <p>Company: 上海理想信息产业(集团)有限公司</p>
 * @author wls
 * create date: 2011-8-31
 * @version 1.0
 */
public interface ISysOrgService extends BaseService<SysOrgModel>{
	/**
     * 添加组织机构及对应的角色
     * @param model model实体
     * @throws Exception抛出所有异常
     */
	boolean  addOrg(SysOrgModel model)throws Exception;
	 /**删除组织机构对应的角色
     * @param model model实体
     * @throws Exception抛出所有异常
     */
     boolean deleteOrg(List<String>list)throws Exception;
    /**
     * 修改组织机构对应的角色
     * @param model model实体
     * @throws Exception抛出所有异常
     */
    boolean  updateOrg(SysOrgModel model)throws Exception;
}
