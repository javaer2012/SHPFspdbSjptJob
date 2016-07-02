package com.ideal.spdb.thirdinfo.dao;

import java.util.List;

import com.ideal.spdb.tencent.model.TencentFraudReportModel;
import com.ideal.spdb.tencent.model.TencentReportModel;
import com.ideal.spdb.thirdinfo.model.TencentModel;
import com.ideal.spdb.utils.BaseDao;

public interface TencentDao extends BaseDao<TencentModel>{
    
    public void uporinset(List<TencentModel> list)throws Exception;
    
    public void batchApprovalUpdate(List<TencentReportModel> list)throws Exception;
    
    public List<TencentFraudReportModel> getNeedUploadFraudReportList()throws Exception;
    
    public void batchFraudApprovalUpdate(List<TencentFraudReportModel> list)throws Exception;

}
