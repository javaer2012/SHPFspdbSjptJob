package com.ideal.spdb.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.stereotype.Service;

import com.ideal.spdb.datadictionary.service.ISysDatadictionarService;
import com.ideal.spdb.system.dao.ISysRoleDao;
import com.ideal.spdb.system.model.SysAuthorityResourceModel;
import com.ideal.spdb.system.model.SysChildnodeResourceModel;
import com.ideal.spdb.system.model.SysFathernodeResourceModel;
import com.ideal.spdb.system.model.SysOperateAuthorityModel;
import com.ideal.spdb.system.model.SysRoleModel;
import com.ideal.spdb.system.model.SysRoleResourceModel;
import com.ideal.spdb.system.service.ISysRoleService;
import com.ideal.spdb.utils.BaseServiceImpl;
import com.ideal.spdb.utils.Constants;
import com.ideal.spdb.utils.StringUtils;

/**
 * 
 * <p>
 * Title:  浦发五星项目
 * </p>
 * <p>
 * Description:角色管理service实现类
 * </p>
 * <p>
 * Company: 上海理想信息产业(集团)有限公司
 * </p>
 * 
 * @author wls create date: 2011-10-24
 * @version 1.0
 */
@Service("sysRoleService")
@RemoteProxy(name = "sysRoleService")
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleModel> implements
		ISysRoleService {

	@Inject
	ISysRoleDao sysRoleDao;
	@Inject ISysDatadictionarService sysDatadictionarService;

	/**
	 * 增加角色并给角色分配权限
	 * 
	 * @param model角色实体
	 * @param resourceIds
	 *            模块资源ID集合
	 * @param operateIds
	 *            模块具体操作权限集合
	 * @return 返回操作结果
	 * @throws Exception
	 *             抛出所有异常
	 */
	public boolean addRole(SysRoleModel model, String[] resourceIds,
			String[] operateIds) throws Exception {
		boolean flag = true;

		try {
			model.setSoleId(sysDatadictionarService.getSequenceValue(Constants.SEQ_CREATE_TYPE));
			sysRoleDao.add("sysRole.addRole", model);
			this.addAuthority(model, resourceIds, operateIds);

		} catch (Exception e) {
			flag = false;
			throw e;
		}
		return flag;
	}

	/**
	 * 给 角色分配权限
	 * 
	 * @param model角色实体
	 * @param resourceIds
	 *            模块资源ID集合
	 * @param operateIds
	 *            模块具体操作权限集合
	 * @return 返回操作结果
	 * @throws Exception
	 *             抛出所有异常
	 */
	public void addAuthority(SysRoleModel model, String[] resourceIds,
			String[] operateIds) throws Exception {
		String operateIdStr = "";
		List<SysRoleResourceModel> resourceModels = new ArrayList<SysRoleResourceModel>();
		List<SysOperateAuthorityModel> authorityModels = new ArrayList<SysOperateAuthorityModel>();
		SysRoleResourceModel roleResourceModel = null;
		SysOperateAuthorityModel operateAuthorityModel = null;
		if (null != resourceIds) {
			for (int i = 0; i < resourceIds.length; i++) {
				// 得到角色所拥有的模块相关信息
				String resourceId = StringUtils.getInstance().filter(resourceIds[i]);
				roleResourceModel = new SysRoleResourceModel();
				roleResourceModel.setSoleId(sysDatadictionarService.getSequenceValue(Constants.SEQ_CREATE_TYPE));
				roleResourceModel.setResourceId(resourceId);
				roleResourceModel.setRoleId(model.getSoleId());
				resourceModels.add(roleResourceModel);
				// 匹配角色对应的模块具体操作权限，为了考虑扩展这里
				// 分为两种情况 一种是角色模块模块具体操作权限ID编号为4位。其中最小的编号为：101+操作权限编码
				// 一种是角色模块具体操作权限ID编号为5位的。其中最大的编号为9999+操作权限编码
				// 具体操作权限编号=父模块ID+子模块ID+具体操作（C 增加 R查询 U修改 D删除 I导入
				// E导出），101C-表示拥有模块编号为101的增加权限
				if (null != operateIds) {
					for (int j = 0; j < operateIds.length; j++) {
						String operateId = StringUtils.getInstance().filter(operateIds[j]);
						if (null != operateId) {
							if (Constants.OPERATE_ID_LENGTH_FOUR == operateId
									.length()) {
								operateIdStr = operateId.substring(0,Constants.OPERATE_ID_LENGTH_FOUR - 1);
								if (operateIdStr.equals(resourceId)) {
									operateAuthorityModel = new SysOperateAuthorityModel();
									operateAuthorityModel.setSoleId(sysDatadictionarService.getSequenceValue(Constants.SEQ_CREATE_TYPE));
									operateAuthorityModel.setAuthority(operateId);
									operateAuthorityModel.setChildnodeId(resourceId);
									operateAuthorityModel.setRoleId(model.getSoleId());
									authorityModels.add(operateAuthorityModel);
								}
							} else if (Constants.OPERATE_ID_LENGTH_FIVE == operateId.length()) {
								operateIdStr = operateId.substring(0,Constants.OPERATE_ID_LENGTH_FIVE - 1);
								if (operateIdStr.equals(resourceId)) {
									operateAuthorityModel = new SysOperateAuthorityModel();
									operateAuthorityModel.setSoleId(sysDatadictionarService.getSequenceValue(Constants.SEQ_CREATE_TYPE));
									operateAuthorityModel.setAuthority(operateId);
									operateAuthorityModel.setChildnodeId(resourceId);
									operateAuthorityModel.setRoleId(model.getSoleId());
									authorityModels.add(operateAuthorityModel);
								}
							}
						}
					}
				}
			}
		}
		sysRoleDao.addRoleResource(resourceModels);
		sysRoleDao.addRoleAuthority(authorityModels);
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
	@RemoteMethod
	public List<SysFathernodeResourceModel> queryFathernodeResource(
			Map<String, String> map) throws Exception {
		return sysRoleDao.queryFathernodeResource(map);
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
	@RemoteMethod
	public List<SysChildnodeResourceModel> queryChildnodeResource(
			Map<String, String> map) throws Exception {
		return sysRoleDao.queryChildnodeResource(map);
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
	@RemoteMethod
	public List<SysAuthorityResourceModel> queryAuthorityResource(
			Map<String, String> map) throws Exception {
		return sysRoleDao.queryAuthorityResource(map);
	}

	/**
	 * 修改角色及对应权限
	 * 
	 * @param model角色实体
	 * @param resourceIds
	 *            模块资源ID集合
	 * @param operateIds
	 *            模块具体操作权限集合
	 * @return 返回操作结果
	 * @throws Exception
	 *             抛出所有异常
	 */
	public boolean updateRole(SysRoleModel model, String[] resourceIds,
			String[] operateIds) throws Exception {
		boolean flag = true;
		try {
			sysRoleDao.edit("sysRole.updateRole", model);
			List<String> list = new ArrayList<String>();
			list.add(model.getSoleId());
			sysRoleDao.remvoeRoleModule(list);
			sysRoleDao.remvoeRoleOperate(list);
			this.addAuthority(model, resourceIds, operateIds);
		} catch (Exception e) {
			flag = false;
			throw e;
		}
		return flag;
	}

	/**
	 * 删除角色对应的模块资源，模块具体操作权限，角色对应的用户，角色本身
	 * 
	 * @param list
	 *            要删除的集合
	 * @return 返回操作结果
	 * @throws Exception
	 *             抛出所有异常
	 */
	public boolean deleteRole(List<String> list) throws Exception {
		boolean flag = true;
		try {
			// 删除角色对应的模块资源
			sysRoleDao.remvoeRoleModule(list);
			// 删除角色对应的模块具体操作权限
			sysRoleDao.remvoeRoleOperate(list);
			// 删除角色
			sysRoleDao.batchDelete("sysRole.remvoeRole", list);
			// 删除角色上的用户
			sysRoleDao.deleteUser(list);
			// 删除用户与角色对应表的数据
			sysRoleDao.deleteUserRole(list);
		} catch (Exception e) {
			flag = false;
			throw e;
		}
		return flag;
	}

}
