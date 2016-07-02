package com.ideal.spdb.thirdinfo.service;

import java.util.List;

import com.ideal.spdb.thirdinfo.model.MobileNumberModel;
import com.ideal.spdb.utils.BaseService;

public interface MobileNumberService extends BaseService<MobileNumberModel>{

	void batchUpdate(List<MobileNumberModel> list);

}
