package com.ideal.spdb.thirdinforeport.model;

import com.ideal.spdb.utils.BaseModel;
import com.ideal.spdb.utils.ExcelAnnotation;

public class ThirdInfoReportModel extends BaseModel {
	
	@ExcelAnnotation(id=1,name="导入日期")
	private String importDate;  //导入日期
	private String appid;  //申请书编号
	private String identityCard;  //证件号码
	private String callType;  //类型（包含银联黑名单、黄页、网通数据）
	@ExcelAnnotation(id=1,name="详情")
	private String thirdinfo;  //第三方信息
	
	private String startSearchDate;  //开始查询日期
	private String endSearchDate;  //结束查询日期
	
	/**查询记录数**/
    private long querryRecords;
	
	public String getImportDate() {
		return importDate;
	}
	public void setImportDate(String importDate) {
		this.importDate = importDate;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getIdentityCard() {
		return identityCard;
	}
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	public String getCallType() {
		return callType;
	}
	public void setCallType(String callType) {
		this.callType = callType;
	}
	public String getThirdinfo() {
		return thirdinfo;
	}
	public void setThirdinfo(String thirdinfo) {
		this.thirdinfo = thirdinfo;
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
	public long getQuerryRecords() {
		return querryRecords;
	}
	public void setQuerryRecords(long querryRecords) {
		this.querryRecords = querryRecords;
	}
	
}
