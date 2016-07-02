package com.ideal.spdb.yellowpage.to;

import java.util.Date;

import com.ideal.spdb.utils.BaseModel;

/**
 * 黄页单位记录表
 * 
 * @author yxh
 */
public class YellowPageUnitRecordModelTo extends BaseModel {
	private String yellowpage_unit_record_id; // 唯一标志 黄页单位id
	private String applicationId; // 申请书ID
	private String unit_name; // 户名
	private String unit_address; // 地址
	private String unit_phone; // 电话
	private String operate_state; // 处理方式
	private String sidekey; // 副关键字
	private String return_name; // 返回户名
	private String return_address; // 返回地址
	private String return_phone; // 返回电话
	private String operator_logo; // 总机标志
	private String operator_address; // 总机地址
	private String telephone_switchboard; // 总机电话
	private String classify; // 分类
	private String ys_username; // 引示电话户名
	private String ys_address; // 引示电话地址
	private String ys_phone; // 引示电话号码
	private String phone_name; // 电话查询户名
	private String phone_address; // 电话查询地址
	private String phone_num; // 电话查询号码
	private String area_code; // 区号
	private Date record_date; // 记录时间

	public String getYellowpage_unit_record_id() {
		return yellowpage_unit_record_id;
	}

	public void setYellowpage_unit_record_id(String yellowpage_unit_record_id) {
		this.yellowpage_unit_record_id = yellowpage_unit_record_id;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
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

	public String getUnit_phone() {
		return unit_phone;
	}

	public void setUnit_phone(String unit_phone) {
		this.unit_phone = unit_phone;
	}

	public String getOperate_state() {
		return operate_state;
	}

	public void setOperate_state(String operate_state) {
		this.operate_state = operate_state;
	}

	public String getSidekey() {
		return sidekey;
	}

	public void setSidekey(String sidekey) {
		this.sidekey = sidekey;
	}

	public String getReturn_name() {
		return return_name;
	}

	public void setReturn_name(String return_name) {
		this.return_name = return_name;
	}

	public String getReturn_address() {
		return return_address;
	}

	public void setReturn_address(String return_address) {
		this.return_address = return_address;
	}

	public String getReturn_phone() {
		return return_phone;
	}

	public void setReturn_phone(String return_phone) {
		this.return_phone = return_phone;
	}

	public String getOperator_logo() {
		return operator_logo;
	}

	public void setOperator_logo(String operator_logo) {
		this.operator_logo = operator_logo;
	}

	public String getOperator_address() {
		return operator_address;
	}

	public void setOperator_address(String operator_address) {
		this.operator_address = operator_address;
	}

	public String getTelephone_switchboard() {
		return telephone_switchboard;
	}

	public void setTelephone_switchboard(String telephone_switchboard) {
		this.telephone_switchboard = telephone_switchboard;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public String getYs_username() {
		return ys_username;
	}

	public void setYs_username(String ys_username) {
		this.ys_username = ys_username;
	}

	public String getYs_address() {
		return ys_address;
	}

	public void setYs_address(String ys_address) {
		this.ys_address = ys_address;
	}

	public String getYs_phone() {
		return ys_phone;
	}

	public void setYs_phone(String ys_phone) {
		this.ys_phone = ys_phone;
	}

	public String getPhone_name() {
		return phone_name;
	}

	public void setPhone_name(String phone_name) {
		this.phone_name = phone_name;
	}

	public String getPhone_address() {
		return phone_address;
	}

	public void setPhone_address(String phone_address) {
		this.phone_address = phone_address;
	}

	public String getPhone_num() {
		return phone_num;
	}

	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}

	public String getArea_code() {
		return area_code;
	}

	public void setArea_code(String area_code) {
		this.area_code = area_code;
	}

	public Date getRecord_date() {
		return record_date;
	}

	public void setRecord_date(Date record_date) {
		this.record_date = record_date;
	}

}
