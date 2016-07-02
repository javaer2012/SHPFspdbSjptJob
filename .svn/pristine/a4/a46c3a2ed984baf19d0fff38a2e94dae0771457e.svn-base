package com.ideal.spdb.policydeploy.service;

import java.util.List;

import com.ideal.spdb.policydeploy.model.PolicyDeployModel;
import com.ideal.spdb.policydeploy.model.PolicyVersionModel;
import com.ideal.spdb.system.model.SysUserModel;
import com.ideal.spdb.utils.BaseService;

public interface PolicyVersionService extends BaseService<PolicyVersionModel> {
	/**
	 * 添加策略版本
	 * @param deploys 
	 * @param policyVersionModel 
	 * @return
	 */
	public boolean addPolicyVersion(PolicyVersionModel policyVersionModel, List<PolicyDeployModel> deploys);
	
	/**
	 * 更新策略版本
	 * @param deploys 
	 * @param policyVersionModel 
	 * @return
	 */
	public boolean updatePolicyVersion(PolicyVersionModel policyVersionModel, List<PolicyDeployModel> deploys);
	
	/**
	 * 会审
	 * @param policyVersionModel
	 * @param user 
	 * @return
	 */
	public boolean changePolicyVersion(PolicyVersionModel policyVersionModel);
}
