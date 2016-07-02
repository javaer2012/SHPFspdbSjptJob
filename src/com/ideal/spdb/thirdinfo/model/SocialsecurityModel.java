package com.ideal.spdb.thirdinfo.model;

import com.ideal.spdb.utils.BaseModel;

public class SocialsecurityModel extends BaseModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String appid;//申请书编号
		private String idno;//证件号码
		private String appname;//申请人姓名
		private String totalpaymonths;//累计缴费月数
		private String recentnormalmonth;//最近正常缴费月份
		private String assuresalary;//投保公子
		private String currpensionamount;//改越个人养老缴费金额
		private String recentinsurecompany;//最近正常参保单位
		private String insurecompanytype;//参保单位类型

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
		public String getTotalpaymonths() {
			return totalpaymonths;
		}
		public void setTotalpaymonths(String totalpaymonths) {
			this.totalpaymonths = totalpaymonths;
		}
		public String getRecentnormalmonth() {
			return recentnormalmonth;
		}
		public void setRecentnormalmonth(String recentnormalmonth) {
			this.recentnormalmonth = recentnormalmonth;
		}
		public String getAssuresalary() {
			return assuresalary;
		}
		public void setAssuresalary(String assuresalary) {
			this.assuresalary = assuresalary;
		}
		public String getCurrpensionamount() {
			return currpensionamount;
		}
		public void setCurrpensionamount(String currpensionamount) {
			this.currpensionamount = currpensionamount;
		}
		public String getRecentinsurecompany() {
			return recentinsurecompany;
		}
		public void setRecentinsurecompany(String recentinsurecompany) {
			this.recentinsurecompany = recentinsurecompany;
		}
		public String getInsurecompanytype() {
			return insurecompanytype;
		}
		public void setInsurecompanytype(String insurecompanytype) {
			this.insurecompanytype = insurecompanytype;
		}
		public String getAppname() {
			return appname;
		}
		public void setAppname(String appname) {
			this.appname = appname;
		}

}
