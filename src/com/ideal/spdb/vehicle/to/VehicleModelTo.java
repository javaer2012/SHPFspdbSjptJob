package com.ideal.spdb.vehicle.to;

import com.ideal.spdb.utils.BaseModel;

/**
 * 车辆信息实体类
 * @author uatyangxh
 */
public class VehicleModelTo extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String appid; // 申请件编号
	private String idno; // 证件号码
	private String appname; // 申请人姓名
	private String carUsefor; // 车辆使用性质
	private String carNo; // 车牌号码
	private String carType; // 车辆类型
	private String carBelong; // 机动车所有人
	private String carStatus; // 机动车状态
	private String brandType; // 厂牌型号
	private String isEffective; // 查询是否有效:0查询成功，1未查到数据，2查询失败，3未查询
	private String flag; // 是否上传 ：1上传，0未上传
	private String msgGetDate; // 获取信息时间
	private String checkValidDeadline; // 检验有效期
	private String firstRegDate; // 初始登记日期
	private String importdate; // 创建时间

	private String callDate; // 调用时间
	private String recordDate; // 返回时间
	
	private String startSearchDate;  //开始查询日期
	private String endSearchDate;  //结束查询日期
	private String startReturnDate;  //开始返回日期
	private String endReturnDate;  //结束返回日期
	
	private String callType;  //查询类型
	
	private String is_local;  //是否调用本地库数据 1是 0不是
	
	/**查询记录数**/
    private long querryRecords;

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

	public String getCarUsefor() {
		return carUsefor;
	}

	public void setCarUsefor(String carUsefor) {
		this.carUsefor = carUsefor;
	}

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarBelong() {
		return carBelong;
	}

	public void setCarBelong(String carBelong) {
		this.carBelong = carBelong;
	}

	public String getCarStatus() {
		return carStatus;
	}

	public void setCarStatus(String carStatus) {
		this.carStatus = carStatus;
	}

	public String getBrandType() {
		return brandType;
	}

	public void setBrandType(String brandType) {
		this.brandType = brandType;
	}

	public String getIsEffective() {
		return isEffective;
	}

	public void setIsEffective(String isEffective) {
		this.isEffective = isEffective;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getMsgGetDate() {
		return msgGetDate;
	}

	public void setMsgGetDate(String msgGetDate) {
		this.msgGetDate = msgGetDate;
	}

	public String getCheckValidDeadline() {
		return checkValidDeadline;
	}

	public void setCheckValidDeadline(String checkValidDeadline) {
		this.checkValidDeadline = checkValidDeadline;
	}

	public String getFirstRegDate() {
		return firstRegDate;
	}

	public void setFirstRegDate(String firstRegDate) {
		this.firstRegDate = firstRegDate;
	}

	public String getImportdate() {
		return importdate;
	}

	public void setImportdate(String importdate) {
		this.importdate = importdate;
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

	public String getCallType() {
		return callType;
	}

	public void setCallType(String callType) {
		this.callType = callType;
	}

	public long getQuerryRecords() {
		return querryRecords;
	}

	public void setQuerryRecords(long querryRecords) {
		this.querryRecords = querryRecords;
	}

	public String getIs_local() {
		return is_local;
	}

	public void setIs_local(String is_local) {
		this.is_local = is_local;
	}

}
