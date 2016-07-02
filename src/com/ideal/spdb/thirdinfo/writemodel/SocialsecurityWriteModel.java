package com.ideal.spdb.thirdinfo.writemodel;

import com.ideal.spdb.thirdinfo.work.util.BaseWriteModel;


public class SocialsecurityWriteModel extends BaseWriteModel{
	/**
	 * 
	 */
	private String appidS16;//申请书编号S16
	//20150128将证件号码从19修改成50
	private String idnoS50;//证件号码S19
	//20150128将申请人姓名从30修改成50
	private String appnameS50;//申请人姓名S30
	private String totalpaymonthsM4;//累计缴费月数M4
	private String recentnormalmonthN6;//最近正常缴费月数M6
	private String assuresalaryM10;//投保工资M10
	private String currpensionamountM10;//该月个人养老缴费金额M10
	private String recentinsurecompanyS50;//最近正常参保单位S50
	private String insurecompanytypeS30;//参保单位类型S30
	public String getAppidS16() {
		return appidS16;
	}
	public void setAppidS16(String appidS16) {
		this.appidS16 = appidS16;
	}
	public String getTotalpaymonthsM4() {
		return totalpaymonthsM4;
	}
	public void setTotalpaymonthsM4(String totalpaymonthsM4) {
		this.totalpaymonthsM4 = totalpaymonthsM4;
	}

	public String getAssuresalaryM10() {
		return assuresalaryM10;
	}
	public void setAssuresalaryM10(String assuresalaryM10) {
		this.assuresalaryM10 = assuresalaryM10;
	}
	public String getCurrpensionamountM10() {
		return currpensionamountM10;
	}
	public void setCurrpensionamountM10(String currpensionamountM10) {
		this.currpensionamountM10 = currpensionamountM10;
	}
	public String getRecentinsurecompanyS50() {
		return recentinsurecompanyS50;
	}
	public void setRecentinsurecompanyS50(String recentinsurecompanyS50) {
		this.recentinsurecompanyS50 = recentinsurecompanyS50;
	}
	public String getInsurecompanytypeS30() {
		return insurecompanytypeS30;
	}
	public void setInsurecompanytypeS30(String insurecompanytypeS30) {
		this.insurecompanytypeS30 = insurecompanytypeS30;
	}
	public String getRecentnormalmonthN6() {
		return recentnormalmonthN6;
	}
	public void setRecentnormalmonthN6(String recentnormalmonthN6) {
		this.recentnormalmonthN6 = recentnormalmonthN6;
	}
	public String getIdnoS50() {
		return idnoS50;
	}
	public void setIdnoS50(String idnoS50) {
		this.idnoS50 = idnoS50;
	}
	public String getAppnameS50() {
		return appnameS50;
	}
	public void setAppnameS50(String appnameS50) {
		this.appnameS50 = appnameS50;
	}
}
