package com.ideal.spdb.socialInsurance.model;

import com.ideal.spdb.utils.BaseModel;
import com.ideal.spdb.utils.ExcelAnnotation;

/**
 * 社保实体(包括武汉、深圳)
 * @author uatyangxh
 */
public class SocialInsuranceModel extends BaseModel {
	/**查询记录数**/
    private long querryRecords;
    
    private String cityCode;
    
    @ExcelAnnotation(id=1,name="申请件编号")
    private String appid;  //申请件编号
    @ExcelAnnotation(id=2,name="证件号码")
    private String idno;  //证件号码
    private String appname;  //申请人姓名
    private String totalPayMonths;  //累计缴费月数
    @ExcelAnnotation(id=3,name="最近正常参保月份")
    private String recentNormalMonth;  //最近正常缴费月份，格式yymm
    @ExcelAnnotation(id=4,name="投保工资")
    private String assureSalary;  //担保工资，单位元
    @ExcelAnnotation(id=5,name="该月个人养老缴费金额")
    private String currPensionAmount;  //该月个人养老缴费金额，单位元
    @ExcelAnnotation(id=6,name="最近正常参保单位")
    private String recentInsureCompany;  //最近正常参保单位
    @ExcelAnnotation(id=7,name="参保单位类型")
    private String insureCompanyType;  //参保单位类型
    private String importdate;  //导入日期
    @ExcelAnnotation(id=8,name="查询结果")
    private String isEffective;  //0:成功 1：未查到数据 2：查询失败  3：未查询
    private String address;  //参保城市:0广州，1深圳
    @ExcelAnnotation(id=9,name="导入结果")
    private String flag;  //是否上传
    @ExcelAnnotation(id=10,name="查询类型")
    private String outtype;  //外部请求类别

    @ExcelAnnotation(id=11,name="触发查询时间")
	private String callDate; // 调用时间
    @ExcelAnnotation(id=12,name="返回查询时间")
	private String recordDate; // 返回时间
    
    private String startSearchDate;  //开始查询日期
	private String endSearchDate;  //结束查询日期
	private String startReturnDate;  //开始返回日期
	private String endReturnDate;  //结束返回日期
	
	@ExcelAnnotation(id=13,name="是否调库")
	private String is_local;  //是否调用本地库数据 1是 0不是
	
	public long getQuerryRecords() {
		return querryRecords;
	}

	public void setQuerryRecords(long querryRecords) {
		this.querryRecords = querryRecords;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
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

	public String getTotalPayMonths() {
		return totalPayMonths;
	}

	public void setTotalPayMonths(String totalPayMonths) {
		this.totalPayMonths = totalPayMonths;
	}

	public String getRecentNormalMonth() {
		return recentNormalMonth;
	}

	public void setRecentNormalMonth(String recentNormalMonth) {
		this.recentNormalMonth = recentNormalMonth;
	}

	public String getAssureSalary() {
		return assureSalary;
	}

	public void setAssureSalary(String assureSalary) {
		this.assureSalary = assureSalary;
	}

	public String getCurrPensionAmount() {
		return currPensionAmount;
	}

	public void setCurrPensionAmount(String currPensionAmount) {
		this.currPensionAmount = currPensionAmount;
	}

	public String getRecentInsureCompany() {
		return recentInsureCompany;
	}

	public void setRecentInsureCompany(String recentInsureCompany) {
		this.recentInsureCompany = recentInsureCompany;
	}

	public String getInsureCompanyType() {
		return insureCompanyType;
	}

	public void setInsureCompanyType(String insureCompanyType) {
		this.insureCompanyType = insureCompanyType;
	}

	public String getImportdate() {
		return importdate;
	}

	public void setImportdate(String importdate) {
		this.importdate = importdate;
	}

	public String getIsEffective() {
		return isEffective;
	}

	public void setIsEffective(String isEffective) {
		this.isEffective = isEffective;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getOuttype() {
		return outtype;
	}

	public void setOuttype(String outtype) {
		this.outtype = outtype;
	}

	public String getCallDate() {
		return callDate;
	}

	public void setCallDate(String callDate) {
		this.callDate = callDate;
	}

	public String getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}

	public String getIs_local() {
		return is_local;
	}

	public void setIs_local(String is_local) {
		this.is_local = is_local;
	}
}
