package com.ideal.spdb.thirdinfo.dao.impl;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ideal.spdb.tencent.model.TencentFraudReportModel;
import com.ideal.spdb.tencent.model.TencentReportModel;
import com.ideal.spdb.thirdinfo.dao.TencentDao;
import com.ideal.spdb.thirdinfo.model.TencentModel;
import com.ideal.spdb.utils.BaseDaoImpl;

@Repository
public class TencentDaoImpl extends BaseDaoImpl<TencentModel>implements TencentDao{

	@Override
	public void uporinset(List<TencentModel> list) throws Exception {
		log.info("插入主表mergeApplication");
		for (TencentModel tencentModel : list) {
			this.getSqlSession().update("tencent.mergeApplication", tencentModel);
		}
		
		/*
		for (TencentModel tencentModel : list) {
			//moger
			TencentModel model = super.get("tencent.queryApp", tencentModel);//查询是否存在该对象
			if(model==null){
				log.info("没有查到相关申请书编号" + tencentModel.getShenqingshucode());
				add("tencent.insertApp", tencentModel);
			}else{
				log.info("主表有相关申请书编号信息：" + tencentModel.getShenqingshucode() + "不再进行插入");
			}
		}
		*/
	}

	@Override
	public void batchApprovalUpdate(List<TencentReportModel> list)
			throws Exception {
		this.getSqlSession().update("tencentReport.batchApprovalUpdate", list);
	}

	@Override
	public List<TencentFraudReportModel> getNeedUploadFraudReportList()
			throws Exception {
		return this.getSqlSession().selectList("tencentReport.queryAllNeedUploadFraudReportToApproval");
	}

	@Override
	public void batchFraudApprovalUpdate(List<TencentFraudReportModel> list)
			throws Exception {
		// TODO Auto-generated method stub
		this.getSqlSession().update("tencentReport.batchFraudApprovalUpdate", list);
	}
	

}
