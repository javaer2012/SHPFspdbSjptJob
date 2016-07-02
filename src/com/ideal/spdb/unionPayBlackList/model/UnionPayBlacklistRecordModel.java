package com.ideal.spdb.unionPayBlackList.model;

import java.util.Date;

import com.ideal.spdb.utils.BaseModel;

/**
 * 银联黑名单记录表
 * 
 * @author yxh
 */
public class UnionPayBlacklistRecordModel extends BaseModel {
	private String unionpayblacklist_record_id; // 唯一标志 银联黑名单记录id
	private String applicationId; // 申请书ID
	private String record_type_code; // 记录类型代码
	private String username; // 姓名
	private String paper_type; // 证件类型
	private String paper_num; // 证件号码
	private String retuen_result; // 反馈结果
	private String hit_message_type; // 命中信息类型
	private Date record_date; // 记录时间

	public String getUnionpayblacklist_record_id() {
		return unionpayblacklist_record_id;
	}

	public void setUnionpayblacklist_record_id(String unionpayblacklist_record_id) {
		this.unionpayblacklist_record_id = unionpayblacklist_record_id;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getRecord_type_code() {
		return record_type_code;
	}

	public void setRecord_type_code(String record_type_code) {
		this.record_type_code = record_type_code;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPaper_type() {
		return paper_type;
	}

	public void setPaper_type(String paper_type) {
		this.paper_type = paper_type;
	}

	public String getPaper_num() {
		return paper_num;
	}

	public void setPaper_num(String paper_num) {
		this.paper_num = paper_num;
	}

	public String getRetuen_result() {
		return retuen_result;
	}

	public void setRetuen_result(String retuen_result) {
		this.retuen_result = retuen_result;
	}

	public String getHit_message_type() {
		return hit_message_type;
	}

	public void setHit_message_type(String hit_message_type) {
		this.hit_message_type = hit_message_type;
	}

	public Date getRecord_date() {
		return record_date;
	}

	public void setRecord_date(Date record_date) {
		this.record_date = record_date;
	}

}
