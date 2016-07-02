package com.ideal.spdb.socialInsurance.service;

import com.ideal.spdb.socialInsurance.model.SocialInsuranceModel;
import com.ideal.spdb.utils.BaseService;
/**
 * 社保业务处理
 * @author uatyangxh
 */
public interface SocialInsuranceService extends BaseService<SocialInsuranceModel> {
	/**
	 * 根据查询社保信息
	 * @param SocialInsuranceModel
	 * @return
	 */
	public SocialInsuranceModel quertSocialInsuranceByAPPID(SocialInsuranceModel socialInsuranceModel);
}
