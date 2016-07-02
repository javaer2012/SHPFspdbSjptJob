package com.ideal.spdb.socialInsurance.dao.impl;

import org.springframework.stereotype.Repository;

import com.ideal.spdb.socialInsurance.dao.SocialInsuranceDao;
import com.ideal.spdb.socialInsurance.model.SocialInsuranceModel;
import com.ideal.spdb.utils.BaseDaoImpl;
import com.ideal.spdb.utils.BaseModel;

/**
 * 社保数据库访问实现
 * @author uatyangxh
 */
@Repository
public class SocialInsuranceDaoImpl extends BaseDaoImpl<SocialInsuranceModel> implements SocialInsuranceDao {

	@Override
	public SocialInsuranceModel quertSocialInsuranceByAPPID(
			SocialInsuranceModel socialInsuranceModel) {
		// TODO Auto-generated method stub
		return (SocialInsuranceModel) super.getSqlSession().selectOne("socialInsurance.quertSocialInsuranceByAPPID", socialInsuranceModel);
	}
	
}
