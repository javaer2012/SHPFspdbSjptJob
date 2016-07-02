package com.ideal.spdb.system.dao;

import java.util.List;
import java.util.Map;

import com.ideal.spdb.system.model.SysAuthorityResourceModel;
import com.ideal.spdb.system.model.SysChildnodeResourceModel;
import com.ideal.spdb.system.model.SysFathernodeResourceModel;
import com.ideal.spdb.system.model.SysOperateAuthorityModel;
import com.ideal.spdb.system.model.SysRoleModel;
import com.ideal.spdb.system.model.SysRoleResourceModel;
import com.ideal.spdb.utils.BaseDao;

/**
 * 
 * <p>Title:  浦发五星项目</p>
 * <p>Description:角色管理dao接口</p>
 * <p>Company:上海理想信息产业(集团)有限公司</p>
 * @author wls
 * create date: 2011-10-24
 * @version 1.0
 */
public interface ISysRoleDao extends BaseDao<SysRoleModel>{
    /**
     * 增加角色对应的资源
     * @param list 角色对应的资源集合
     * @return 返回操作结果
     * @throws Exception 抛出所有异常
     */
	boolean addRoleResource(List<SysRoleResourceModel> list)throws Exception;
	
	 /**
     * 增加角色对应的模块具体操作权限
     * @param list 角色对应的资源集合
     * @return 返回操作结果
     * @throws Exception 抛出所有异常
     */
	public boolean addRoleAuthority(List<SysOperateAuthorityModel> list)throws Exception;
	
	/**
	 * 查询父节点资源
	 * @param map 查询条件
	 * @return 返回父节点资源集合
	 * @throws Exception 抛出所有异常
	 */
	public List<SysFathernodeResourceModel>queryFathernodeResource(Map<String,String>map)throws Exception;
	
	/**
	 * 查询子节点节点资源
	 * @param map 查询条件
	 * @return 返回子节点资源集合
	 * @throws Exception 抛出所有异常
	 */
	public List<SysChildnodeResourceModel>queryChildnodeResource(Map<String,String>map)throws Exception;
	
	/**
	 * 子节点资源对应具体功能权限
	 * @param map 查询条件
	 * @return 返回子节点资源对应具体功能权限集合
	 * @throws Exception 抛出所有异常
	 */
	public List<SysAuthorityResourceModel>queryAuthorityResource(Map<String,String>map)throws Exception;
	/**
	 * 删除角色对应的模块资源
	 * @param roleId要删除的数据集合
	 * @return 返回操作结果
	 * @throws Exception 抛出所有异常
	 */
	public boolean remvoeRoleModule(List<String>roleId) throws Exception;
	/**
	 * 删除角色对应的模块具体操作权限
	 * @param roleId要删除的数据集合
	 * @return 返回操作结果
	 * @throws Exception 抛出所有异常
	 */
	public boolean remvoeRoleOperate(List<String> roleId) throws Exception;
	
	 /**删除角色与用户对应表的数据
     * @param list要删除的数据集合
     * @throws Exception抛出所有异常
     */
   public void deleteUserRole(List<String>list)throws Exception;
   /**删除角色对应的用户
    * @param list要删除的数据集合
    * @throws Exception抛出所有异常
    */
  public void deleteUser(List<String>list)throws Exception;
}
