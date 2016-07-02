package com.ideal.spdb.manuallyManager.to;

import com.ideal.spdb.utils.BaseModel;

public class ManuallyModelTo extends BaseModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String shenqingshucode;  //申请书编号
	
	private String shenqingrenzhongwenminchen;  //姓名
	
	private String shenqingrencardtype;  //证件类型
	
	private String shengqingrencardnumber;  //证件号码
	
	private String formcode;  //来源代码
	
	private String carnumber;  //车牌号
	
	private String searchType;  //查询类型
	
	private String shebaoCity;  //社保缴纳城市
	
	private boolean result;  //处理结果
	
	private String message;  //返回信息
	
	private String qq;
	private String shenqingrenmobilenumber;
	
	private String email;//邮箱
	
	private String familyAddress;//家庭地址
	
	private String companyAddress;//公司地址
	
	private String ip;//ip
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getShenqingshucode() {
		return shenqingshucode;
	}

	public void setShenqingshucode(String shenqingshucode) {
		this.shenqingshucode = shenqingshucode;
	}

	public String getShenqingrenzhongwenminchen() {
		return shenqingrenzhongwenminchen;
	}

	public void setShenqingrenzhongwenminchen(String shenqingrenzhongwenminchen) {
		this.shenqingrenzhongwenminchen = shenqingrenzhongwenminchen;
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

	public String getFormcode() {
		return formcode;
	}

	public void setFormcode(String formcode) {
		this.formcode = formcode;
	}

	public String getCarnumber() {
		return carnumber;
	}

	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getShebaoCity() {
		return shebaoCity;
	}

	public void setShebaoCity(String shebaoCity) {
		this.shebaoCity = shebaoCity;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getShenqingrenmobilenumber() {
		return shenqingrenmobilenumber;
	}

	public void setShenqingrenmobilenumber(String shenqingrenmobilenumber) {
		this.shenqingrenmobilenumber = shenqingrenmobilenumber;
	}
	
	
}
