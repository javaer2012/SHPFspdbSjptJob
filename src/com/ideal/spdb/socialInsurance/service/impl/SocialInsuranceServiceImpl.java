package com.ideal.spdb.socialInsurance.service.impl;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ideal.spdb.socialInsurance.dao.SocialInsuranceDao;
import com.ideal.spdb.socialInsurance.model.SocialInsuranceModel;
import com.ideal.spdb.socialInsurance.service.SocialInsuranceService;
import com.ideal.spdb.utils.BaseModel;
import com.ideal.spdb.utils.BaseServiceImpl;
/**
 * 社保业务处理实现
 * @author uatyangxh
 */
@Service
public class SocialInsuranceServiceImpl extends BaseServiceImpl<SocialInsuranceModel> implements SocialInsuranceService {

	private static final Logger log = Logger.getLogger(SocialInsuranceServiceImpl.class);
	
	@Inject
	private SocialInsuranceDao dao;
	
	@Override
	public SocialInsuranceModel quertSocialInsuranceByAPPID(
			SocialInsuranceModel socialInsuranceModel) {
		// TODO Auto-generated method stub
		return dao.quertSocialInsuranceByAPPID(socialInsuranceModel);
	}

}
