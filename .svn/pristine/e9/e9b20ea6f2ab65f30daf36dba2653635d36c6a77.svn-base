package com.ideal.spdb.system.to;

import com.ideal.spdb.utils.BaseModel;

/**
 * 
 * <p>Title:  浦发五星项目</p>
 * <p>Description:模块具体操作权限TO(Transfer Object)数据传输对象</p>
 * <p>Company: 上海理想信息产业(集团)有限公司</p>
 * @author wls
 * create date: 2011-11-3
 * @version 1.0
 */
public class SysOperateAuthorityTO extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String childnodeId;//子节点ID
	private String authority;//具体操作权限
	private String roleId;//角色ID
	private String column4;//备份字段
	
	public SysOperateAuthorityTO(String childnodeId, String authority,
			String roleId, String column4) {
		this.childnodeId = childnodeId;
		this.authority = authority;
		this.roleId = roleId;
		this.column4 = column4;
	}
	
	public SysOperateAuthorityTO() {
	}

	public String getChildnodeId() {
		return childnodeId;
	}
	public void setChildnodeId(String childnodeId) {
		this.childnodeId = super.filter(childnodeId);
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = super.filter(authority);
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = super.filter(roleId);
	}
	public String getColumn4() {
		return column4;
	}
	public void setColumn4(String column4) {
		this.column4 = super.filter(column4);
	}
}
