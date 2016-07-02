package com.ideal.spdb.thirdinfo.writemodel;

import com.ideal.spdb.thirdinfo.work.util.BaseWriteModel;


public class VehicleWriteModel extends BaseWriteModel{
	/**
	 * 
	 */


	private String appidS16;// 申请书编号S16
	//20150128证件号码长度 从 19修改成50
	private String idnoS50;//证件号码S50
	
	private String appnameS30;//申请人姓名S30
	//20150128车辆使用性质长度 从 10修改成80
	private String caruserforS80;//车辆使用性质S80
	//20150128车辆车牌号码长度 从 15修改成20
	private String carnoS20;//车牌号码S20
	//20150128车辆类型长度 从4修改成10
	private String cartypeS10;//车辆类型S10
	//20150128车辆类型长度 从50修改成500
	private String carbelongS500;//机动车所有人S500
	//20150128机动车状态长度 从10修改成80
	private String carstatusS80;//机动车状态S80
	//20150128厂牌型号长度 从30修改成50
	private String brandtypeS50;//厂牌型号S50
	//20150128检查有效期止 从8修改成20
	private String checkvaliddeadlineS20;//检验有效期止N20
	//20150128车辆初始登记日期从8修改成20
	private String firstregdateS20;//车辆初始登记日期N20

	private String msggetdateS8;//车辆信息获取日期N8

	public String getAppidS16() {
		return appidS16;
	}

	public void setAppidS16(String appidS16) {
		this.appidS16 = appidS16;
	}

	public String getAppnameS30() {
		return appnameS30;
	}

	public void setAppnameS30(String appnameS30) {
		this.appnameS30 = appnameS30;
	}
	
	public String getMsggetdateS8() {
		return msggetdateS8;
	}

	public void setMsggetdateS8(String msggetdateS8) {
		this.msggetdateS8 = msggetdateS8;
	}

	public String getCaruserforS80() {
		return caruserforS80;
	}

	public void setCaruserforS80(String caruserforS80) {
		this.caruserforS80 = caruserforS80;
	}

	public String getCarnoS20() {
		return carnoS20;
	}

	public void setCarnoS20(String carnoS20) {
		this.carnoS20 = carnoS20;
	}

	public String getCartypeS10() {
		return cartypeS10;
	}

	public void setCartypeS10(String cartypeS10) {
		this.cartypeS10 = cartypeS10;
	}

	public String getCarbelongS500() {
		return carbelongS500;
	}

	public void setCarbelongS500(String carbelongS500) {
		this.carbelongS500 = carbelongS500;
	}

	public String getCarstatusS80() {
		return carstatusS80;
	}

	public void setCarstatusS80(String carstatusS80) {
		this.carstatusS80 = carstatusS80;
	}

	public String getBrandtypeS50() {
		return brandtypeS50;
	}

	public void setBrandtypeS50(String brandtypeS50) {
		this.brandtypeS50 = brandtypeS50;
	}

	public String getIdnoS50() {
		return idnoS50;
	}

	public void setIdnoS50(String idnoS50) {
		this.idnoS50 = idnoS50;
	}

	public String getCheckvaliddeadlineS20() {
		return checkvaliddeadlineS20;
	}

	public void setCheckvaliddeadlineS20(String checkvaliddeadlineS20) {
		this.checkvaliddeadlineS20 = checkvaliddeadlineS20;
	}

	public String getFirstregdateS20() {
		return firstregdateS20;
	}

	public void setFirstregdateS20(String firstregdateS20) {
		this.firstregdateS20 = firstregdateS20;
	}
	
	
}
