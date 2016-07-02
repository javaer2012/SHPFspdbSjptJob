package com.ideal.spdb.bjwt.to;

import java.util.Date;

import com.ideal.spdb.utils.BaseModel;

/**
 * 北京网通单位记录表
 * 
 * @author yxh
 */
public class BjwtUnitRecordModelTo extends BaseModel {
	private String bjwt_unit_record_id; // 唯一标志 北京网通单位id
	private String applicationId;    //申请书ID
	private String o_unit_name; // 原单位名称
	private String o_unit_address; // 原地址
	private String o_unit_phone; // 原电话
	private String unit_name; // 单位名称
	private String unit_address; // 单位地址
	private String mark_matching; // 匹配标志
	private String personal_call_sign; // 个人电话标志
	private String phs_sign; // 小灵通标志
	private Date record_date; // 记录时间

	public String getBjwt_unit_record_id() {
		return bjwt_unit_record_id;
	}

	public void setBjwt_unit_record_id(String bjwt_unit_record_id) {
		this.bjwt_unit_record_id = bjwt_unit_record_id;
	}
	
	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getO_unit_name() {
		return o_unit_name;
	}

	public void setO_unit_name(String o_unit_name) {
		this.o_unit_name = o_unit_name;
	}

	public String getO_unit_address() {
		return o_unit_address;
	}

	public void setO_unit_address(String o_unit_address) {
		this.o_unit_address = o_unit_address;
	}

	public String getO_unit_phone() {
		return o_unit_phone;
	}

	public void setO_unit_phone(String o_unit_phone) {
		this.o_unit_phone = o_unit_phone;
	}

	public String getUnit_name() {
		return unit_name;
	}

	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}

	public String getUnit_address() {
		return unit_address;
	}

	public void setUnit_address(String unit_address) {
		this.unit_address = unit_address;
	}

	public String getMark_matching() {
		return mark_matching;
	}

	public void setMark_matching(String mark_matching) {
		this.mark_matching = mark_matching;
	}

	public String getPersonal_call_sign() {
		return personal_call_sign;
	}

	public void setPersonal_call_sign(String personal_call_sign) {
		this.personal_call_sign = personal_call_sign;
	}

	public String getPhs_sign() {
		return phs_sign;
	}

	public void setPhs_sign(String phs_sign) {
		this.phs_sign = phs_sign;
	}

	public Date getRecord_date() {
		return record_date;
	}

	public void setRecord_date(Date record_date) {
		this.record_date = record_date;
	}

}
