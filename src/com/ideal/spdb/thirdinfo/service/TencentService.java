package com.ideal.spdb.thirdinfo.service;


public interface TencentService {
	public void creditExcel() throws Exception;

	public void fraudExcel() throws Exception;
	
	public void uploadReoprt2CRM() throws Exception;
	
	public void uploadReportToApproval() throws Exception;
	
	public void uploadFraudReportToApproval() throws Exception;
}
