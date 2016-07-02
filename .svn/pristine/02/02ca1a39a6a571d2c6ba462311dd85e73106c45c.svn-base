package com.ideal.spdb.thirdinfo.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ideal.spdb.thirdinfo.dao.IRucangDao;
import com.ideal.spdb.thirdinfo.model.RucangModel;
import com.ideal.spdb.thirdinfo.model.SZOverdueModel;
import com.ideal.spdb.thirdinfo.model.SocialsecurityModel;
import com.ideal.spdb.utils.BaseDaoImpl;
@Repository
public class RucangDaoImpl extends BaseDaoImpl<RucangModel> implements IRucangDao{

	@Override
	public List<RucangModel> getNeedExportInfo(String string) {
		List<RucangModel> list = null;
		list = this.getSqlSession().selectList(string);
		return list;
	}

	@Override
	public void updateInstinctFlag(RucangModel rucangmodel, String string) {
		int a = this.getSqlSession().update(string, rucangmodel);
		System.out.println(a);
	}

}
