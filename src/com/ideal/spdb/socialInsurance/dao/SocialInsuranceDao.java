package com.ideal.spdb.socialInsurance.dao;

import com.ideal.spdb.socialInsurance.model.SocialInsuranceModel;
import com.ideal.spdb.utils.BaseDao;
import com.ideal.spdb.utils.BaseModel;
/**
 * 社保数据库访问
 * @author uatyangxh
 */
public interface SocialInsuranceDao extends BaseDao<SocialInsuranceModel> {
	/**
	 * 根据查询社保信息
	 * @param SocialInsuranceModel
	 * @return
	 */
	public SocialInsuranceModel quertSocialInsuranceByAPPID(SocialInsuranceModel socialInsuranceModel);
}
