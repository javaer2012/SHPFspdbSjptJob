package com.ideal.spdb.publicsecurity.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ideal.spdb.publicsecurity.dao.PublicSecurityDao;
import com.ideal.spdb.publicsecurity.model.PublicSecurityModel;
import com.ideal.spdb.publicsecurity.model.PublicSecurityTZRModel;
import com.ideal.spdb.utils.BaseDaoImpl;

@Repository
public class PublicSecurityDaoImpl extends BaseDaoImpl<PublicSecurityModel> implements PublicSecurityDao {

	@Override
	public PublicSecurityModel quertPublicSecurityByAPPID(
			PublicSecurityModel publicSecurityModel) {
		// TODO Auto-generated method stub
		PublicSecurityModel p = (PublicSecurityModel) super.getSqlSession().selectOne("publicSecurity.quertPublicSecurityByAPPID", publicSecurityModel);
		if(p != null){
			List<PublicSecurityTZRModel> list = (List<PublicSecurityTZRModel>) super.getSqlSession().selectList("publicSecurity.quertPublicSecurityTZRByAPPID", p);
			p.setTzrs(list);
		}
		return p;
	}

	@Override
	public List<PublicSecurityModel> queryPublicSecurityInfo() {
		// TODO Auto-generated method stub
		List<PublicSecurityModel> list = super.getSqlSession().selectList("publicSecurity.queryPublicSecurityInfo");
		return list;
	}

	@Override
	public void updatePublicSecurityInfoStatus(
			PublicSecurityModel publicSecurityModel) {
		// TODO Auto-generated method stub
		super.getSqlSession().update("publicSecurity.updatePublicSecurityInfoStatus", publicSecurityModel);
	}

}
