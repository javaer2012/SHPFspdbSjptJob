package com.ideal.spdb.thirdinfo.model;

import com.ideal.spdb.utils.BaseModel;

public class CapsBlackListModel extends BaseModel{
	private String cardNo;
	private String cardtype;
	private String username;
	private String channel;
	private String fromtype;
	private String recordreason;
	private String importdate;
	public String getImportdate() {
		return importdate;
	}
	public void setImportdate(String importdate) {
		this.importdate = importdate;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getFromtype() {
		return fromtype;
	}
	public void setFromtype(String fromtype) {
		this.fromtype = fromtype;
	}
	public String getRecordreason() {
		return recordreason;
	}
	public void setRecordreason(String recordreason) {
		this.recordreason = recordreason;
	}

}
