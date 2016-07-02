package com.ideal.spdb.thirdinfo.dao;

import java.util.List;

import com.ideal.spdb.thirdinfo.model.AllCountModel;
import com.ideal.spdb.thirdinfo.model.SheBaoInfoExcelModel;
import com.ideal.spdb.thirdinfo.model.ThirdinfoModel;

public interface IThirdinfoDao {
	public List<ThirdinfoModel> getNeedExportInfo();
	public void updateFlag(ThirdinfoModel ssm);
	/**
	 * 获取社保返回信息数据列表
	 * @return
	 */
	List<SheBaoInfoExcelModel> getSheBaoReturnList();
	/**
	 * 更新上传标识为1
	 * @param model
	 */
	void updateFlagTo1(SheBaoInfoExcelModel model);
	
	/**
	 * 查询数据
	 */
	List<AllCountModel> getCount(AllCountModel model);
}
