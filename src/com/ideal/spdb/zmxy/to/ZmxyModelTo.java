package com.ideal.spdb.zmxy.to;

import com.ideal.spdb.utils.BaseModel;

public class ZmxyModelTo extends BaseModel {
	private static final long serialVersionUID = 1L;

	private String zmxy_id;// 主键id

	private String applicationId;// 申请书编号

	private String userName;// 申请人姓名

	private String identityCard;// 申请人证件号码

	private String mobile;// 手机号

	private String email;// 邮箱

	private String callType;// 查询类型

	private String errorMsg;// 错误原因

	private String familyAddress;// 家庭住址

	private String companyAddress;// 工作地址

	private String flow; // 流程处理项

	private String process_finish; // 已完成项

	private String familyAddress1;
	private String familyAddress2;
	private String familyAddress3;
	private String companyAddress1;
	private String companyAddress2;
	private String companyAddress3;
	
	private String isLocal;//是否本地查询
	
	private String score;//芝麻分
	
	private String infoCode;//info-code
	
	private String results;//查询结果
	
	private String isInstinct;//倒入结果
	
	public String getIsLocal() {
		return isLocal;
	}

	public void setIsLocal(String isLocal) {
		this.isLocal = isLocal;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getInfoCode() {
		return infoCode;
	}

	public void setInfoCode(String infoCode) {
		this.infoCode = infoCode;
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public String getIsInstinct() {
		return isInstinct;
	}

	public void setIsInstinct(String isInstinct) {
		this.isInstinct = isInstinct;
	}

	public String getFlow() {
		return flow;
	}

	public void setFlow(String flow) {
		this.flow = flow;
	}

	public String getProcess_finish() {
		return process_finish;
	}

	public void setProcess_finish(String process_finish) {
		this.process_finish = process_finish;
	}

	public String getFamilyAddress1() {
		return familyAddress1;
	}

	public void setFamilyAddress1(String familyAddress1) {
		this.familyAddress1 = familyAddress1;
	}

	public String getFamilyAddress2() {
		return familyAddress2;
	}

	public void setFamilyAddress2(String familyAddress2) {
		this.familyAddress2 = familyAddress2;
	}

	public String getFamilyAddress3() {
		return familyAddress3;
	}

	public void setFamilyAddress3(String familyAddress3) {
		this.familyAddress3 = familyAddress3;
	}

	public String getCompanyAddress1() {
		return companyAddress1;
	}

	public void setCompanyAddress1(String companyAddress1) {
		this.companyAddress1 = companyAddress1;
	}

	public String getCompanyAddress2() {
		return companyAddress2;
	}

	public void setCompanyAddress2(String companyAddress2) {
		this.companyAddress2 = companyAddress2;
	}

	public String getCompanyAddress3() {
		return companyAddress3;
	}

	public void setCompanyAddress3(String companyAddress3) {
		this.companyAddress3 = companyAddress3;
	}

	public String getFamilyAddress() {
		return familyAddress;
	}

	public void setFamilyAddress(String familyAddress) {
		this.familyAddress = familyAddress;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getCallType() {
		return callType;
	}

	public void setCallType(String callType) {
		this.callType = callType;
	}

	public String getZmxy_id() {
		return zmxy_id;
	}

	public void setZmxy_id(String zmxy_id) {
		this.zmxy_id = zmxy_id;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
