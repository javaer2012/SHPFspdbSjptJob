package com.ideal.spdb.thirdinfo.model;

import com.ideal.spdb.utils.BaseModel;

public class EduImportModel extends BaseModel{
	private String shenqingshucode;//
	private String appname;
	private String appno;
	private String approvalcode;
	public String getApprovalcode() {
		return approvalcode;
	}
	public void setApprovalcode(String approvalcode) {
		this.approvalcode = approvalcode;
	}
	public String getShenqingshucode() {
		return shenqingshucode;
	}
	public void setShenqingshucode(String shenqingshucode) {
		this.shenqingshucode = shenqingshucode;
	}
	public String getAppname() {
		return appname;
	}
	public void setAppname(String appname) {
		this.appname = appname;
	}
	public String getAppno() {
		return appno;
	}
	public void setAppno(String appno) {
		this.appno = appno;
	}
	
	
}
