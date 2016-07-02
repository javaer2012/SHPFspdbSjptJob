package com.ideal.spdb.callreport.model;

import com.ideal.spdb.utils.BaseModel;
import com.ideal.spdb.utils.ExcelAnnotation;

public class CallReportModel extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String applicationID;//申请书编号
	@ExcelAnnotation(id=1,name="调用接口")
	private String calltype;//接口类型：1 学历接口
	@ExcelAnnotation(id=2,name="返回结果")
	private String results;//返回结果
	@ExcelAnnotation(id=3,name="发起时间")
	private String calldate;//发起时间
	@ExcelAnnotation(id=4,name="返回时间")
	private String recorddate;//返回时间
	@ExcelAnnotation(id=5,name="姓名")
	private String parameters1;//参数1
	@ExcelAnnotation(id=6,name="身份证号")
	private String parameters2;//参数2
	

    /**查询记录数**/
    private long querryRecords;

	public String getApplicationID() {
		return applicationID;
	}

	public void setApplicationID(String applicationID) {
		this.applicationID = applicationID;
	}

	public String getCalltype() {
		return calltype;
	}

	public void setCalltype(String calltype) {
		this.calltype = calltype;
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public String getCalldate() {
		return calldate;
	}

	public void setCalldate(String calldate) {
		this.calldate = calldate;
	}

	public String getRecorddate() {
		return recorddate;
	}

	public void setRecorddate(String recorddate) {
		this.recorddate = recorddate;
	}

	public String getParameters1() {
		return parameters1;
	}

	public void setParameters1(String parameters1) {
		this.parameters1 = parameters1;
	}

	public String getParameters2() {
		return parameters2;
	}

	public void setParameters2(String parameters2) {
		this.parameters2 = parameters2;
	}

	public long getQuerryRecords() {
		return querryRecords;
	}

	public void setQuerryRecords(long querryRecords) {
		this.querryRecords = querryRecords;
	}
	
	
}
