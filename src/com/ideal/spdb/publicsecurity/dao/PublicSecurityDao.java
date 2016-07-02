package com.ideal.spdb.publicsecurity.dao;

import java.util.List;

import com.ideal.spdb.publicsecurity.model.PublicSecurityModel;
import com.ideal.spdb.utils.BaseDao;

public interface PublicSecurityDao extends BaseDao<PublicSecurityModel> {
	
	/**
	 * 根据查询公安网信息
	 * @param publicSecurityModel
	 * @return
	 */
	public PublicSecurityModel quertPublicSecurityByAPPID(PublicSecurityModel publicSecurityModel);
	
	/**
	 * 查询公安网需上传信息
	 * @param publicSecurityModel
	 * @return
	 */
	public List<PublicSecurityModel> queryPublicSecurityInfo();
	
	/**
	 * 更新
	 * @param publicSecurityModel
	 * @return
	 */
	public void updatePublicSecurityInfoStatus(PublicSecurityModel publicSecurityModel);
}
