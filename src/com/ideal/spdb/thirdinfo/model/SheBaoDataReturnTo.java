package com.ideal.spdb.thirdinfo.model;

import com.ideal.spdb.utils.BaseModel;

/**
 * 查询数据To
 * @author uatguansl
 *
 */
public class SheBaoDataReturnTo extends BaseModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String beginTime;
	private String endTime;
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
