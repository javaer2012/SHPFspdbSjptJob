package com.ideal.spdb.system.model;



import com.ideal.spdb.utils.BaseModel;

/**
 * 
 * <p>Title:  浦发五星项目</p>
 * <p>Description:模块具体操作权限表实体</p>
 * <p>Company: 上海理想信息产业(集团)有限公司</p>
 * @author wls
 * create date: 2011-11-3
 * @version 1.0
 */
public class SysOperateAuthorityModel extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String childnodeId;//子节点ID
	private String authority;//具体操作权限
	private String roleId;//角色ID
	private String column4;//备份字段
	
	public SysOperateAuthorityModel(String childnodeId, String authority,
			String roleId, String column4) {
		this.childnodeId = childnodeId;
		this.authority = authority;
		this.roleId = roleId;
		this.column4 = column4;
	}
	
	public SysOperateAuthorityModel() {
	}

	public String getChildnodeId() {
		return childnodeId;
	}
	public void setChildnodeId(String childnodeId) {
		this.childnodeId = childnodeId;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getColumn4() {
		return column4;
	}
	public void setColumn4(String column4) {
		this.column4 = column4;
	}
}
