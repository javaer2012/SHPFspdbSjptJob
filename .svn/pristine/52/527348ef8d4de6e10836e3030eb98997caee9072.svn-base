package com.ideal.spdb.system.service;


import java.util.List;
import java.util.Map;

import com.ideal.spdb.system.model.SysAuthorityResourceModel;
import com.ideal.spdb.system.model.SysChildnodeResourceModel;
import com.ideal.spdb.system.model.SysFathernodeResourceModel;
import com.ideal.spdb.system.model.SysRoleModel;
import com.ideal.spdb.utils.BaseService;

/**
 * 
 * <p>Title:  浦发五星项目</p>
 * <p>Description:角色管理service接口</p>
 * <p>Company: 上海理想信息产业(集团)有限公司</p>
 * @author wls
 * create date: 2011-10-24
 * @version 1.0
 */
public interface ISysRoleService extends BaseService<SysRoleModel>{
	 /**
     * 增加角色并给角色分配权限
     * @param model角色实体
     * @param resourceIds 模块资源ID集合
     * @param operateIds 模块具体操作权限集合
     * @return 返回操作结果
     * @throws Exception 抛出所有异常
     */
	boolean addRole(SysRoleModel model,String[] resourceIds,String[]operateIds)throws Exception;
	/**
	 * 查询父节点资源
	 * @param map 查询条件
	 * @return 返回父节点资源集合
	 * @throws Exception 抛出所有异常
	 */
	List<SysFathernodeResourceModel>queryFathernodeResource(Map<String,String>map)throws Exception;
	
	/**
	 * 查询子节点节点资源
	 * @param map 查询条件
	 * @return 返回子节点资源集合
	 * @throws Exception 抛出所有异常
	 */
	List<SysChildnodeResourceModel>queryChildnodeResource(Map<String,String>map)throws Exception;
	
	/**
	 * 子节点资源对应具体功能权限
	 * @param map 查询条件
	 * @return 返回子节点资源对应具体功能权限集合
	 * @throws Exception 抛出所有异常
	 */
	List<SysAuthorityResourceModel>queryAuthorityResource(Map<String,String>map)throws Exception;
	
	/**
	 * 修改角色
	 * @param model角色实体
     * @param resourceIds 模块资源ID集合
     * @param operateIds 模块具体操作权限集合
     * @return 返回操作结果
     * @throws Exception 抛出所有异常
     */
	boolean updateRole(SysRoleModel model, String[] resourceIds,
			String[] operateIds) throws Exception;
	/**
	 * 删除角色对应的模块资源，模块具体操作权限，角色对应的用户，角色本身
	 * @param list 要删除的集合
	 * @return 返回操作结果
	 * @throws Exception 抛出所有异常
	 */
    boolean deleteRole(List<String>list)throws Exception;
}
