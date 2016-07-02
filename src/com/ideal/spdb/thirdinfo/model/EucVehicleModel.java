package com.ideal.spdb.thirdinfo.model;

/**
 * euc Model类
 * @author uatmy06136
 *
 */
public class EucVehicleModel {
    
	private String shenqingshucode;//申请书编号
	private String shenqingrenzhongwenminchen;//姓名
	private String shengqingrencardnumber;//申请人证件号码
	private String carno;//车牌号码
	private String cartype;//车辆类型
	private String flag;//调用接口标记
	private String approvalcode;
	public String getApprovalcode() {
		return approvalcode;
	}
	public void setApprovalcode(String approvalcode) {
		this.approvalcode = approvalcode;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
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
	public String getShengqingrencardnumber() {
		return shengqingrencardnumber;
	}
	public void setShengqingrencardnumber(String shengqingrencardnumber) {
		this.shengqingrencardnumber = shengqingrencardnumber;
	}
	public String getCarno() {
		return carno;
	}
	public void setCarno(String carno) {
		this.carno = carno;
	}
	public String getCartype() {
		return cartype;
	}
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	
}
