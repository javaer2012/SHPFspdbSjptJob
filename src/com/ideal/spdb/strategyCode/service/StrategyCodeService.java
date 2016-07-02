package com.ideal.spdb.strategyCode.service;

import com.ideal.spdb.strategyCode.model.StrategyCodeModel;
import com.ideal.spdb.utils.BaseService;

public interface StrategyCodeService extends BaseService<StrategyCodeModel> {
	/**
	 * 导出文件方法
	 * @throws Exception 
	 */
	public void ExportStrategyCodeFile() throws Exception;
}
