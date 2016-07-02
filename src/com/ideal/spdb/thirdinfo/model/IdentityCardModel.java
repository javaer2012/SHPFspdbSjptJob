package com.ideal.spdb.thirdinfo.model;

import com.ideal.spdb.utils.BaseModel;

public class IdentityCardModel extends BaseModel {
	private static final long serialVersionUID = -2158784673053132183L;
	private String code;
	private String address;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
