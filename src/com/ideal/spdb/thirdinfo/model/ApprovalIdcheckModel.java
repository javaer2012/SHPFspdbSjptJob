package com.ideal.spdb.thirdinfo.model;

import com.ideal.spdb.utils.BaseModel;

public class ApprovalIdcheckModel extends BaseModel{
	private String appname;    //姓名
	private String idno;    //身份证号
	private String signoffice;    //签发机关
	private String checkresult;    //核对结果
	private String modelid;
	public String getAppname() {
		return appname;
	}
	public void setAppname(String appname) {
		this.appname = appname;
	}
	public String getIdno() {
		return idno;
	}
	public void setIdno(String idno) {
		this.idno = idno;
	}
	public String getSignoffice() {
		return signoffice;
	}
	public void setSignoffice(String signoffice) {
		this.signoffice = signoffice;
	}
	public String getCheckresult() {
		return checkresult;
	}
	public void setCheckresult(String checkresult) {
		this.checkresult = checkresult;
	}
	public String getModelid() {
		return modelid;
	}
	public void setModelid(String modelid) {
		this.modelid = modelid;
	}
	
}
