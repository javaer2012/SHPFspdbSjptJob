package com.ideal.spdb.thirdinfo.model;

import com.ideal.spdb.utils.ExcelAnnotation;

public class JuxinliBlackListExportModel {
	@ExcelAnnotation(id=1,name="类型编号")
	private String typeNo;  //类型编号
	@ExcelAnnotation(id=2,name="设置值")
	private String identityCard;    //身份证号码
	@ExcelAnnotation(id=3,name="操作时间")
	private String operateDate;  //操作时间
	@ExcelAnnotation(id=4,name="设置值明细")
	private String Detail;  //设置值明细
	public String getTypeNo() {
		return typeNo;
	}
	public void setTypeNo(String typeNo) {
		this.typeNo = typeNo;
	}
	public String getIdentityCard() {
		return identityCard;
	}
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	public String getOperateDate() {
		return operateDate;
	}
	public void setOperateDate(String operateDate) {
		this.operateDate = operateDate;
	}
	public String getDetail() {
		return Detail;
	}
	public void setDetail(String detail) {
		Detail = detail;
	}
}
