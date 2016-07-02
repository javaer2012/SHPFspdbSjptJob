package com.ideal.spdb.system.model;

import com.ideal.spdb.utils.BaseModel;

/**
 * 
 * <p>
 * Title: 浦发五星项目
 * </p>
 * <p>
 * Description:用户表实体
 * </p>
 * <p>
 * Company: 上海理想信息产业(集团)有限公司
 * </p>
 * 
 * @author wls create date: 2011-8-31
 * @version 1.0
 */
public class SysPadModel extends BaseModel {
	private static final long serialVersionUID = 1L;
	private String userName;// 用户
	private String userPassword;// 密码
	private String userRoleId;// 用户对应的角色表id
	private String parallelismRole;// 对应角色ID
	private String roleName;// 角色名
	private String realName;// 真实姓名
	private String registerDate;// 注册时间
	private String column7;// 备份字段
	private String managerNo;// 管理员编号
	private String city;// 用户类型
	private String state;// 状态
	private String oldState;// 原状态
	private String orgId;// 所属机构ID
	private String oldOrgId;// 所属机构ID
	private String orgName;// 所属机构名称
	private String station;// 岗位
	private String post;// 职务
	private String address;// 联系地址
	private String tel;// 联系电话
	private String email;// EMAIL
	private String remark;// 备注
	private String logoutTime;// 上次注销时间
	private String backGround;// 后台用户为1，前台用户为0
	private String foreground;// 前台角色为1，前台角色为0
	private String isOnline;// 是否在线
	private String errorCount;// 前台登陆错误次数
	private String pwdReset;//密码重置
	 private String branchapprovalcode;//所属分行
	public SysPadModel() {
	}

	
	
	public SysPadModel(String userName, String userPassword, String userRoleId,
			String parallelismRole, String roleName, String realName,
			String registerDate, String column7, String managerNo, String city,
			String state, String oldState, String orgId, String oldOrgId,
			String orgName, String station, String post, String address,
			String tel, String email, String remark, String logoutTime,
			String backGround, String foreground, String isOnline,
			String errorCount, String pwdReset,String branchapprovalcode) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userRoleId = userRoleId;
		this.parallelismRole = parallelismRole;
		this.roleName = roleName;
		this.realName = realName;
		this.registerDate = registerDate;
		this.column7 = column7;
		this.managerNo = managerNo;
		this.city = city;
		this.state = state;
		this.oldState = oldState;
		this.orgId = orgId;
		this.oldOrgId = oldOrgId;
		this.orgName = orgName;
		this.station = station;
		this.post = post;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.remark = remark;
		this.logoutTime = logoutTime;
		this.backGround = backGround;
		this.foreground = foreground;
		this.isOnline = isOnline;
		this.errorCount = errorCount;
		this.pwdReset = pwdReset;
		this.branchapprovalcode=branchapprovalcode;
	}



	public String getPwdReset() {
		return pwdReset;
	}

	public void setPwdReset(String pwdReset) {
		this.pwdReset = pwdReset;
	}

	public String getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(String isOnline) {
		this.isOnline = isOnline;
	}

	public String getErrorCount() {
		return errorCount;
	}

	public void setErrorCount(String errorCount) {
		this.errorCount = errorCount;
	}

	public String getOldState() {
		return oldState;
	}

	public void setOldState(String oldState) {
		this.oldState = oldState;
	}

	public String getOldOrgId() {
		return oldOrgId;
	}

	public void setOldOrgId(String oldOrgId) {
		this.oldOrgId = oldOrgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getForeground() {
		return foreground;
	}

	public void setForeground(String foreground) {
		this.foreground = foreground;
	}

	public String getManagerNo() {
		return managerNo;
	}

	public void setManagerNo(String managerNo) {
		this.managerNo = managerNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(String logoutTime) {
		this.logoutTime = logoutTime;
	}

	public String getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getParallelismRole() {
		return parallelismRole;
	}

	public void setParallelismRole(String parallelismRole) {
		this.parallelismRole = parallelismRole;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getColumn7() {
		return column7;
	}

	public void setColumn7(String column7) {
		this.column7 = column7;
	}

	public String getBackGround() {
		return backGround;
	}

	public void setBackGround(String backGround) {
		this.backGround = backGround;
	}



	public String getBranchapprovalcode() {
		return branchapprovalcode;
	}



	public void setBranchapprovalcode(String branchapprovalcode) {
		this.branchapprovalcode = branchapprovalcode;
	}
}