package com.ideal.spdb.flowflag.to;

import com.ideal.spdb.utils.BaseModel;

public class FlowflagModelTo extends BaseModel {
	
	private String switch_id;    //流程编号
	private String switch_name;    //流程名
	private String switch_state;    //流程值
	private String switch_seq;    //流程顺序
	private String switch_remark;    //流程描述
	
	/**查询记录数**/
    private long querryRecords;
	
	public String getSwitch_id() {
		return switch_id;
	}
	public void setSwitch_id(String switch_id) {
		this.switch_id = switch_id;
	}
	public String getSwitch_name() {
		return switch_name;
	}
	public void setSwitch_name(String switch_name) {
		this.switch_name = switch_name;
	}
	public String getSwitch_state() {
		return switch_state;
	}
	public void setSwitch_state(String switch_state) {
		this.switch_state = switch_state;
	}
	public String getSwitch_seq() {
		return switch_seq;
	}
	public void setSwitch_seq(String switch_seq) {
		this.switch_seq = switch_seq;
	}
	public String getSwitch_remark() {
		return switch_remark;
	}
	public void setSwitch_remark(String switch_remark) {
		this.switch_remark = switch_remark;
	}
	public long getQuerryRecords() {
		return querryRecords;
	}
	public void setQuerryRecords(long querryRecords) {
		this.querryRecords = querryRecords;
	}

	
}
