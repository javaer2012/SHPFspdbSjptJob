package com.ideal.spdb.pboc.model;

import com.ideal.spdb.utils.ExcelAnnotation;

public class PbocQueryModel extends PbocModel{
private static final long serialVersionUID = 1L;
	
	private String applicationId;
	
	@ExcelAnnotation(id = 1, name = "申请书编号")
	private String shenqingshucode;//申请书编号
	@ExcelAnnotation(id = 2, name = "姓名")
	private String shenqingrenzhongwenminchen;//申请人姓名
	@ExcelAnnotation(id = 3, name = "证件号码")
	private String shengqingrencardnumber;//申请人证件号码
	@ExcelAnnotation(id = 4, name = "证件类型")
	private String shenqingrencardtype;//申请人证件类型
	@ExcelAnnotation(id = 5, name = "查询类型")
	private String queryType;//查询类型
	@ExcelAnnotation(id = 6, name = "操作员")
	private String operName;//操作人
	@ExcelAnnotation(id = 7, name = "操作时间")
	private String createTime;
	@ExcelAnnotation(id = 8, name = "是否调库")
	private String is_local;//是否调用本地
	
	@ExcelAnnotation(id = 9, name = "操作人IP")
	private String session_ip;//ip

	private String errMsg;//错误原因
	@ExcelAnnotation(id = 10, name = "授权员")
	private String username;//授权人账号
	
	private String userPassword;//授权人密码
	
	public String getSession_ip() {
		return session_ip;
	}
	
	public String getIs_local() {
		return is_local;
	}

	public void setIs_local(String is_local) {
		this.is_local = is_local;
	}

	public void setSession_ip(String session_ip) {
		this.session_ip = session_ip;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	
	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getShenqingrenzhongwenminchen() {
		return shenqingrenzhongwenminchen;
	}

	public void setShenqingrenzhongwenminchen(String shenqingrenzhongwenminchen) {
		this.shenqingrenzhongwenminchen = shenqingrenzhongwenminchen;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getShenqingshucode() {
		return shenqingshucode;
	}

	public void setShenqingshucode(String shenqingshucode) {
		this.shenqingshucode = shenqingshucode;
	}

	public String getShenqingrencardtype() {
		return shenqingrencardtype;
	}

	public void setShenqingrencardtype(String shenqingrencardtype) {
		this.shenqingrencardtype = shenqingrencardtype;
	}

	public String getShengqingrencardnumber() {
		return shengqingrencardnumber;
	}

	public void setShengqingrencardnumber(String shengqingrencardnumber) {
		this.shengqingrencardnumber = shengqingrencardnumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}
}
