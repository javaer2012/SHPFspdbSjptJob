package com.ideal.spdb.gzMobile.to;

import com.ideal.spdb.utils.BaseModel;

public class GZMobileRecordTo extends BaseModel {

	
	private String gz_mobile_id;    //id
	private String applicationId;    //申请书编号
	private String identityCard;    //证件号
	private String userName;    //姓名
	private String callDate;    //记录生成时间
	private String callType;    //外部请求类别,0：线下导入，1：批量，2：手动查询，3：线上预筛
	private String isEffective;    //查询是否有效:0查询成功，1未查到数据
	private String flag;    //是否上传 ：1上传，0未上传
	private String mobile_no;    //手机号码
	private String authentication;    //身份验证信息
	private String access_conditions;    //是否符合准入条件
	private String net_age;    //在网年限
	private String last_three_months;    //最近三个月均话费
	private String brand;    //号码品牌
	private String recordDate;    //结果反馈日期
	
	private String startSearchDate;  //开始查询日期
	private String endSearchDate;  //结束查询日期
	private String startReturnDate;  //开始返回日期
	private String endReturnDate;  //结束返回日期
	
	/**查询记录数**/
    private long querryRecords;

	public String getGz_mobile_id() {
		return gz_mobile_id;
	}

	public void setGz_mobile_id(String gz_mobile_id) {
		this.gz_mobile_id = gz_mobile_id;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCallDate() {
		return callDate;
	}

	public void setCallDate(String callDate) {
		this.callDate = callDate;
	}

	public String getCallType() {
		return callType;
	}

	public void setCallType(String callType) {
		this.callType = callType;
	}

	public String getIsEffective() {
		return isEffective;
	}

	public void setIsEffective(String isEffective) {
		this.isEffective = isEffective;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getAuthentication() {
		return authentication;
	}

	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}

	public String getAccess_conditions() {
		return access_conditions;
	}

	public void setAccess_conditions(String access_conditions) {
		this.access_conditions = access_conditions;
	}

	public String getNet_age() {
		return net_age;
	}

	public void setNet_age(String net_age) {
		this.net_age = net_age;
	}

	public String getLast_three_months() {
		return last_three_months;
	}

	public void setLast_three_months(String last_three_months) {
		this.last_three_months = last_three_months;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}

	public long getQuerryRecords() {
		return querryRecords;
	}

	public void setQuerryRecords(long querryRecords) {
		this.querryRecords = querryRecords;
	}

	public String getStartSearchDate() {
		return startSearchDate;
	}

	public void setStartSearchDate(String startSearchDate) {
		this.startSearchDate = startSearchDate;
	}

	public String getEndSearchDate() {
		return endSearchDate;
	}

	public void setEndSearchDate(String endSearchDate) {
		this.endSearchDate = endSearchDate;
	}

	public String getStartReturnDate() {
		return startReturnDate;
	}

	public void setStartReturnDate(String startReturnDate) {
		this.startReturnDate = startReturnDate;
	}

	public String getEndReturnDate() {
		return endReturnDate;
	}

	public void setEndReturnDate(String endReturnDate) {
		this.endReturnDate = endReturnDate;
	}
	
}
