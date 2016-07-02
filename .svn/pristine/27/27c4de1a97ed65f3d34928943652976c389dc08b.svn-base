package com.ideal.spdb.policydeploy.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ideal.spdb.policydeploy.dao.PolicyDeployDao;
import com.ideal.spdb.policydeploy.dao.PolicyVersionDao;
import com.ideal.spdb.policydeploy.model.PolicyDeployModel;
import com.ideal.spdb.policydeploy.model.PolicyVersionModel;
import com.ideal.spdb.policydeploy.service.PolicyVersionService;
import com.ideal.spdb.utils.BaseServiceImpl;

@Service
public class PolicyVersionServiceImpl extends BaseServiceImpl<PolicyVersionModel> implements PolicyVersionService {
	private static final Logger log = Logger.getLogger(PolicyVersionServiceImpl.class);
	@Inject
	public PolicyVersionDao dao;
	@Inject
	public PolicyDeployDao deployDao;
	
	/**
	 * 添加策略版本
	 */
	@Override
	public boolean addPolicyVersion(PolicyVersionModel policyVersionModel,
			List<PolicyDeployModel> deploys) {
		try {
			if(dao.add("policy.insertPolicyVersion", policyVersionModel)){
				boolean flag = false;
				int i = 1;
				for (PolicyDeployModel policyDeployModel : deploys) {
					flag = false;
					policyDeployModel.setPolicy_number(i+"");
					i++;
					policyDeployModel.setPolicyversion_code(policyVersionModel.getPolicyversion_code());
					policyDeployModel.setPolicy_state(policyDeployModel.getPolicy_state().equals("Y")?"1":"0");
					flag = deployDao.add("policy.insertPolicyDeployTemp", policyDeployModel);
				}
				return flag;
			}else{
				throw new RuntimeException("更新策略版本错误！版本号："+policyVersionModel.getPolicyversion_code());
			}
		} catch (Exception e) {
			log.error("添加策略版本错误！版本号："+policyVersionModel.getPolicyversion_code(), e);
			throw new RuntimeException("添加策略版本错误！版本号："+policyVersionModel.getPolicyversion_code());
		}
	}

	@Override
	public boolean updatePolicyVersion(PolicyVersionModel policyVersionModel,
			List<PolicyDeployModel> deploys) {
		try {
			if(dao.edit("policy.updatePolicyVersion", policyVersionModel)){
				PolicyDeployModel p = new PolicyDeployModel();
				p.setPolicyversion_code(policyVersionModel.getPolicyversion_code());
				//删除老数据
				deployDao.remvoe("policy.deletePolicyDeployBAK", p);
				boolean flag = false;
				int i = 1;
				for (PolicyDeployModel policyDeployModel : deploys) {
					flag = false;
					policyDeployModel.setPolicy_number(i+"");
					i++;
					policyDeployModel.setPolicyversion_code(policyVersionModel.getPolicyversion_code());
					policyDeployModel.setPolicy_state(policyDeployModel.getPolicy_state().equals("Y")?"1":"0");
					flag = deployDao.add("policy.insertPolicyDeployTemp", policyDeployModel);
				}
				return flag;
			}else{
				throw new RuntimeException("更新策略版本错误！版本号："+policyVersionModel.getPolicyversion_code());
			}
		} catch (Exception e) {
			log.error("更新策略版本错误！版本号："+policyVersionModel.getPolicyversion_code(), e);
			throw new RuntimeException("更新策略版本错误！版本号："+policyVersionModel.getPolicyversion_code());
		}
	}

	@Override
	public boolean changePolicyVersion(PolicyVersionModel policyVersionModel) {
		try {
			//获取当前版本信息
			PolicyVersionModel p = dao.get("policy.queryPolicyVersionByCode", policyVersionModel);
			
			if(policyVersionModel.getPolicyversion_state() == 2){
				//判断当前是否有正在使用的
				PolicyVersionModel used = dao.get("policy.queryUsedPolicyVersion",null);
				if(null != used && used.getPolicyversion_state() == 1){
					//将当前正在使用的版本的数据复制到备份表
					dao.add("policy.insertPolicyDeployBAKFromUse", used);
					//将当前正在使用的版本改为会审成功
					used.setPolicyversion_state(2);
					dao.edit("policy.updatePolicyVersion", used);
					//删除当前业务表中的正在使用的规则
					dao.remvoe("policy.deletePolicyDeploy", used); 
				}
				//将此次会审通过的数据改为正在使用
				policyVersionModel.setPolicyversion_state(1);
				dao.edit("policy.updatePolicyVersion", policyVersionModel);
				if(p.getPolicyversion_state() == 0){ //新建策略进行会审
					//将此次会审通过的数据移动到业务表中
					dao.add("policy.insertPolicyDeployFromTemp", policyVersionModel);
					//从原来表中删除数据
					dao.remvoe("policy.deletePolicyDeployTemp", policyVersionModel); 
					return true;
				}else if(p.getPolicyversion_state() == 3 || p.getPolicyversion_state() == 2){  //会审失败策略再次进行会审
					//将此次会审通过的数据移动到业务表中
					dao.add("policy.insertPolicyDeployFromBAK", policyVersionModel);
					//从原来表中删除数据
					dao.remvoe("policy.deletePolicyDeployBAK", policyVersionModel); 
					return true;
				}
			}else if(policyVersionModel.getPolicyversion_state() == 3){
				if(p.getPolicyversion_state() == 0){
					//将会审失败的数据放到bak表
					dao.add("policy.insertPolicyDeployBAKFromTemp", policyVersionModel);
					//更新状态为会审失败
					policyVersionModel.setPolicyversion_state(3);
					dao.edit("policy.updatePolicyVersion", policyVersionModel);
					//移除temp表中的数据
					dao.remvoe("policy.deletePolicyDeployTemp", policyVersionModel);
					return true;
				}
			}
		} catch (Exception e) {
			log.error("修改策略版本错误！版本号："+policyVersionModel.getPolicyversion_code(), e);
			throw new RuntimeException("修改策略版本错误！版本号："+policyVersionModel.getPolicyversion_code());
		}
		return false;
	}

	
	
}
