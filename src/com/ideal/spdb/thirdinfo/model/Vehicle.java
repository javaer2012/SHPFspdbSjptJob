package com.ideal.spdb.thirdinfo.model;

import com.ideal.spdb.utils.BaseModel;
import com.ideal.spdb.utils.ExcelAnnotation;

public class Vehicle extends BaseModel{

	private static final long serialVersionUID = 1L;
	@ExcelAnnotation(id=1,name="申请书编号")
	private String appid;// 申请书编号
	@ExcelAnnotation(id=2,name="证件号码")
	private String idno;//证件号码
	
	private String appname;//申请人姓名
	@ExcelAnnotation(id=3,name="车辆使用性质")
	private String caruserfor;//车辆使用性质
	
	
	private String cartype;//车辆类型


	

	@ExcelAnnotation(id=4,name="厂牌型号")
	private String brandtype;//厂牌型号


	@ExcelAnnotation(id=5,name="车辆初始登记日期")
	private String firstregdate;//车辆初始登记日期
	@ExcelAnnotation(id=6,name="车辆信息获取日期")
	private String msggetdate;//车辆信息获取日期
	@ExcelAnnotation(id=7,name="车牌号码")
	private String carno;//车牌号码
	@ExcelAnnotation(id=8,name="机动车所有人")
	private String carbelong;//机动车所有人
	@ExcelAnnotation(id=9,name="机动车状态")
	private String carstatus;//机动车状态
	@ExcelAnnotation(id=10,name="检验有效期止")
	private String checkvaliddeadline;//检验有效期止
	  /**查询记录数**/
    private long querryRecords;
    @ExcelAnnotation(id=11,name="查询结果")
    private String iseffective;
    @ExcelAnnotation(id=12,name="审批导入结果")
    private String flag;
    
    private String carusefor;
    

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


	public String getCaruserfor() {
		return caruserfor;
	}


	public void setCaruserfor(String caruserfor) {
		this.caruserfor = caruserfor;
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


	public String getCarbelong() {
		return carbelong;
	}


	public void setCarbelong(String carbelong) {
		this.carbelong = carbelong;
	}


	public String getCarstatus() {
		return carstatus;
	}


	public void setCarstatus(String carstatus) {
		this.carstatus = carstatus;
	}


	public String getBrandtype() {
		return brandtype;
	}


	public void setBrandtype(String brandtype) {
		this.brandtype = brandtype;
	}


	public String getCheckvaliddeadline() {
		return checkvaliddeadline;
	}


	public void setCheckvaliddeadline(String checkvaliddeadline) {
		this.checkvaliddeadline = checkvaliddeadline;
	}


	public String getFirstregdate() {
		return firstregdate;
	}


	public void setFirstregdate(String firstregdate) {
		this.firstregdate = firstregdate;
	}


	public String getMsggetdate() {
		return msggetdate;
	}


	public void setMsggetdate(String msggetdate) {
		this.msggetdate = msggetdate;
	}


	public long getQuerryRecords() {
		return querryRecords;
	}


	public void setQuerryRecords(long querryRecords) {
		this.querryRecords = querryRecords;
	}


	public String getIseffective() {
		return iseffective;
	}


	public void setIseffective(String iseffective) {
		this.iseffective = iseffective;
	}


	public String getFlag() {
		return flag;
	}


	public void setFlag(String flag) {
		this.flag = flag;
	}


	public String getCarusefor() {
		return carusefor;
	}


	public void setCarusefor(String carusefor) {
		this.carusefor = carusefor;
	}




}
