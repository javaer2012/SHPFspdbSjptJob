package com.ideal.spdb.system.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ideal.spdb.system.dao.ISysRoleDao;
import com.ideal.spdb.system.model.SysAuthorityResourceModel;
import com.ideal.spdb.system.model.SysChildnodeResourceModel;
import com.ideal.spdb.system.model.SysFathernodeResourceModel;
import com.ideal.spdb.system.model.SysOperateAuthorityModel;
import com.ideal.spdb.system.model.SysRoleModel;
import com.ideal.spdb.system.model.SysRoleResourceModel;
import com.ideal.spdb.utils.BaseDaoImpl;

/**
 * 
 * <p>
 * Title:  浦发五星项目
 * </p>
 * <p>
 * Description:角色管理dao实现类
 * </p>
 * <p>
 * Company: 上海理想信息产业(集团)有限公司
 * </p>
 * 
 * @author wls create date: 2011-10-24
 * @version 1.0
 */
@Repository("sysRoleDao")
public class SysRoleDaoImpl extends BaseDaoImpl<SysRoleModel> implements
		ISysRoleDao {

	/**
	 * 增加角色对应的资源
	 * 
	 * @param list
	 *            角色对应的资源集合
	 * @return 返回操作结果
	 * @throws Exception
	 *             抛出所有异常
	 */
	public boolean addRoleResource(List<SysRoleResourceModel> list)
			throws Exception {
		boolean flag = false;
		try {
			for (SysRoleResourceModel sysRoleResourceModel : list) {
				flag = this.getSqlSession().insert("sysRole.addRoleRes",
						sysRoleResourceModel) > 0 ? true : false;
			}

		} catch (Exception e) {
			flag = false;
			throw e;
		}
		return flag;
	}

	/**
	 * 增加角色对应的模块具体操作权限
	 * 
	 * @param list
	 *            角色对应的资源集合
	 * @return 返回操作结果
	 * @throws Exception
	 *             抛出所有异常
	 */
	public boolean addRoleAuthority(List<SysOperateAuthorityModel> list)
			throws Exception {
		boolean flag = false;
		try {
			for (SysOperateAuthorityModel sysOperateAuthorityModel : list) {
				flag = this.getSqlSession().insert("sysRole.addRoleAut",
						sysOperateAuthorityModel) > 0 ? true : false;
			}

		} catch (Exception e) {
			flag = false;
			throw e;
		}
		return flag;
	}

	/**
	 * 查询父节点资源
	 * 
	 * @param map
	 *            查询条件
	 * @return 返回父节点资源集合
	 * @throws Exception
	 *             抛出所有异常
	 */
	@SuppressWarnings("unchecked")
	public List<SysFathernodeResourceModel> queryFathernodeResource(
			Map<String, String> map) throws Exception {
		List<SysFathernodeResourceModel> result = null;
		try {
			result = this.getSqlSession().selectList(
					"sysRole.queryFathernodeResource", map);
		} catch (Exception e) {
			throw e;
		}
		return result;
	}

	/**
	 * 查询子节点节点资源
	 * 
	 * @param map
	 *            查询条件
	 * @return 返回子节点资源集合
	 * @throws Exception
	 *             抛出所有异常
	 */
	@SuppressWarnings("unchecked")
	public List<SysChildnodeResourceModel> queryChildnodeResource(
			Map<String, String> map) throws Exception {
		List<SysChildnodeResourceModel> result = null;
		try {
			result = this.getSqlSession().selectList(
					"sysRole.queryChildnodeResource", map);
		} catch (Exception e) {
			throw e;
		}
		return result;
	}

	/**
	 * 子节点资源对应具体功能权限
	 * 
	 * @param map
	 *            查询条件
	 * @return 返回子节点资源对应具体功能权限集合
	 * @throws Exception
	 *             抛出所有异常
	 */
	@SuppressWarnings("unchecked")
	public List<SysAuthorityResourceModel> queryAuthorityResource(
			Map<String, String> map) throws Exception {
		List<SysAuthorityResourceModel> result = null;
		try {
			result = this.getSqlSession().selectList(
					"sysRole.queryAuthorityResource", map);
		} catch (Exception e) {
			throw e;
		}
		return result;
	}

	/**
	 * 删除角色对应的模块资源
	 * 
	 * @param roleId要删除的数据集合
	 * @return 返回操作结果
	 * @throws Exception
	 *             抛出所有异常
	 */
	public boolean remvoeRoleModule(List<String> roleId) throws Exception {
		boolean flag = false;
		try {

			flag = this.getSqlSession().delete("sysRole.remvoeRoleMod", roleId) > 0 ? true
					: false;

		} catch (Exception e) {
			flag = false;
			throw e;
		}
		return flag;
	}

	/**
	 * 删除角色对应的模块具体操作权限
	 * 
	 * @param roleId要删除的数据集合
	 * @return 返回操作结果
	 * @throws Exception
	 *             抛出所有异常
	 */
	public boolean remvoeRoleOperate(List<String> roleId) throws Exception {
		boolean flag = false;
		try {

			flag = this.getSqlSession().delete("sysRole.remvoeRoleOpe", roleId) > 0 ? true
					: false;

		} catch (Exception e) {
			flag = false;
			throw e;
		}
		return flag;
	}
	
	 /**删除角色与用户对应表的数据
     * @param model model实体
     * @throws Exception抛出所有异常
     */
    public void deleteUserRole(List<String>list)throws Exception{
    	this.getSqlSession().delete("sysRole.deleteUserRole",list);
    }
    
    /**删除角色对应的用户
     * @param list要删除的数据集合
     * @throws Exception抛出所有异常
     */
   public void deleteUser(List<String>list)throws Exception{
	   this.getSqlSession().delete("sysRole.deleteUser",list);
   }
}
