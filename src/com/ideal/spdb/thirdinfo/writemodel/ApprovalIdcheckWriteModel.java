package com.ideal.spdb.thirdinfo.writemodel;

import com.ideal.spdb.thirdinfo.work.util.BaseWriteModel;
import com.ideal.spdb.utils.BaseModel;

public class ApprovalIdcheckWriteModel extends BaseWriteModel{
	private String appnameS30;    //姓名
	private String idnoS18;    //身份证号
	private String signofficeS50;    //签发机关
	private String checkresultS2;    //核对结果
	public String getAppnameS30() {
		return appnameS30;
	}
	public void setAppnameS30(String appnameS30) {
		this.appnameS30 = appnameS30;
	}
	public String getIdnoS18() {
		return idnoS18;
	}
	public void setIdnoS18(String idnoS18) {
		this.idnoS18 = idnoS18;
	}
	public String getSignofficeS50() {
		return signofficeS50;
	}
	public void setSignofficeS50(String signofficeS50) {
		this.signofficeS50 = signofficeS50;
	}
	public String getCheckresultS2() {
		return checkresultS2;
	}
	public void setCheckresultS2(String checkresultS2) {
		this.checkresultS2 = checkresultS2;
	}
	
}
