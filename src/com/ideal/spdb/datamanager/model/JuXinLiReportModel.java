package com.ideal.spdb.datamanager.model;

import java.util.Date;

import com.ideal.spdb.utils.BaseModel;

public class JuXinLiReportModel extends BaseModel {
	private String jxlId;
	private String appid; 
	private String idno;
	private String appname;
	private String calltype;
	private String isEffective;
	private String flag;
	private Date createDate;
	private String mobile;
	private String result;
	public String getJxlId() {
		return jxlId;
	}
	public void setJxlId(String jxlId) {
		this.jxlId = jxlId;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getIdno() {
		return idno;
	}
	public void setIdno(String idno) {
		this.idno = idno;
	}
	public String getAppname() {
		return appname;
	}
	public void setAppname(String appname) {
		this.appname = appname;
	}
	public String getCalltype() {
		return calltype;
	}
	public void setCalltype(String calltype) {
		this.calltype = calltype;
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	

}
