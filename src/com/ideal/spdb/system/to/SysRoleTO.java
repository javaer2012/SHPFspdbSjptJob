package com.ideal.spdb.system.to;


import com.ideal.spdb.utils.BaseModel;

/**
 * 
 * <p>Title: 浦发五星项目</p>
 * <p>Description:角色TO(Transfer Object)数据传输对象</p>
 * <p>Company: 上海理想信息产业(集团)有限公司</p>
 * @author wls
 * create date: 2011-8-31
 * @version 1.0
 */
public class SysRoleTO extends BaseModel {
	private static final long serialVersionUID = 1L;
	private String roleName;// 角色名
	private String createDate;// 创建时间
	private String roleDescribe;// 角色描述
	private String column4;// 备份字段

	public SysRoleTO() {
	}

	public SysRoleTO(String roleName, String createDate,
			String roleDescribe, String column4) {
		this.roleName = roleName;
		this.createDate = createDate;
		this.roleDescribe = roleDescribe;
		this.column4 = column4;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName =  super.filter(roleName);
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate =  super.filter(createDate);
	}

	public String getRoleDescribe() {
		return roleDescribe;
	}

	public void setRoleDescribe(String roleDescribe) {
		this.roleDescribe =  super.filter(roleDescribe);
	}

	public String getColumn4() {
		return column4;
	}

	public void setColumn4(String column4) {
		this.column4 =  super.filter(column4);
	}

}