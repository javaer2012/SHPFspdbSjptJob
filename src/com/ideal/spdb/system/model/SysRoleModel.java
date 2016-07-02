package com.ideal.spdb.system.model;


import com.ideal.spdb.utils.BaseModel;

/**
 * 
 * <p>Title:  浦发五星项目</p>
 * <p>Description:角色表实体</p>
 * <p>Company: 上海理想信息产业(集团)有限公司</p>
 * @author wls
 * create date: 2011-8-31
 * @version 1.0
 */
public class SysRoleModel extends BaseModel {
	private static final long serialVersionUID = 1L;
	private String roleName;// 角色名
	private String createDate;// 创建时间
	private String roleDescribe;// 角色描述
	private String foreground;//是否是前台的角色 是：1，否：0
	private String column4;// 备份字段
	private String systemUrl;//url地址（判断权限）

	public SysRoleModel() {
	}


	
	public SysRoleModel(String roleName, String createDate,
			String roleDescribe, String foreground, String column4,
			String systemUrl) {
		this.roleName = roleName;
		this.createDate = createDate;
		this.roleDescribe = roleDescribe;
		this.foreground = foreground;
		this.column4 = column4;
		this.systemUrl = systemUrl;
	}



	public String getSystemUrl() {
		return systemUrl;
	}



	public void setSystemUrl(String systemUrl) {
		this.systemUrl = systemUrl;
	}



	public String getForeground() {
		return foreground;
	}

	public void setForeground(String foreground) {
		this.foreground = foreground;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getRoleDescribe() {
		return roleDescribe;
	}

	public void setRoleDescribe(String roleDescribe) {
		this.roleDescribe = roleDescribe;
	}

	public String getColumn4() {
		return column4;
	}

	public void setColumn4(String column4) {
		this.column4 = column4;
	}

}