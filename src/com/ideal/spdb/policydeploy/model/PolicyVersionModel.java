package com.ideal.spdb.policydeploy.model;

import java.util.Date;

import com.ideal.spdb.utils.BaseModel;

public class PolicyVersionModel extends BaseModel {
	String policyversion_code;    //策略版本编码
	String founder;    //创建人
	Date createdate;    //创建时间
	String mixed_people;    //会审人
	Date updatedate;    //会审时间
	int policyversion_state;    //策略版本状态(0：新建  1：使用中  2：已关闭)
	String policyversion_remark;    //版本备注
	
	/**查询记录数**/
    private long querryRecords;
	
	public String getPolicyversion_code() {
		return policyversion_code;
	}
	public void setPolicyversion_code(String policyversion_code) {
		this.policyversion_code = policyversion_code;
	}
	public String getFounder() {
		return founder;
	}
	public void setFounder(String founder) {
		this.founder = founder;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public String getMixed_people() {
		return mixed_people;
	}
	public void setMixed_people(String mixed_people) {
		this.mixed_people = mixed_people;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	public int getPolicyversion_state() {
		return policyversion_state;
	}
	public void setPolicyversion_state(int policyversion_state) {
		this.policyversion_state = policyversion_state;
	}
	public String getPolicyversion_remark() {
		return policyversion_remark;
	}
	public void setPolicyversion_remark(String policyversion_remark) {
		this.policyversion_remark = policyversion_remark;
	}
	public long getQuerryRecords() {
		return querryRecords;
	}
	public void setQuerryRecords(long querryRecords) {
		this.querryRecords = querryRecords;
	}

}
