package com.ideal.spdb.thirdinfo.dao;

import com.ideal.spdb.thirdinfo.model.SZOverdueModel;

public interface ISZOverdueDao {
	public String insertIntoData(SZOverdueModel model);
	public boolean insertApp(SZOverdueModel model);
	public void initprocess(SZOverdueModel model);
}
