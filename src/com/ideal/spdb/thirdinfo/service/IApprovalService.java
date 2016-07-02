package com.ideal.spdb.thirdinfo.service;

import java.util.List;

import com.ideal.spdb.thirdinfo.model.ApprovalZmxyIvsModel;
import com.ideal.spdb.thirdinfo.model.ThirdinfoModel;

public interface IApprovalService {
	public boolean upload(List<ThirdinfoModel> list);
	public boolean uploadZmxyIvs(List<ApprovalZmxyIvsModel> list);
}
