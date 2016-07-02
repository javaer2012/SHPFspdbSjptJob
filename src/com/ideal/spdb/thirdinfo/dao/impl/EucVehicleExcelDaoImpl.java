package com.ideal.spdb.thirdinfo.dao.impl;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.ideal.spdb.thirdinfo.dao.IEucVehicleExcelDao;
import com.ideal.spdb.thirdinfo.model.EucVehicleModel;
import com.ideal.spdb.utils.BaseDaoImpl;

/**
 * 处理euc excel文件 dao 实现类
 * @author uatmy06136
 *
 */
@Repository
public class EucVehicleExcelDaoImpl extends BaseDaoImpl<EucVehicleModel>implements IEucVehicleExcelDao{
    
	
	 /**
	  * 查询ip
	  */
	@Override
	public String getConfigIP(String costValue) throws Exception {
		
		return (String) this.getSqlSession().selectOne("vehicle.getConfigIP",costValue);
	}

	@Override
	public void uporinset(String string, List<EucVehicleModel> comlist) throws Exception {
		if(comlist!=null && comlist.size()>0){
			for(EucVehicleModel EucVehicleModel:comlist){
					this.getSqlSession().update("eucvehicleexcel.insertOrUpdateApp",EucVehicleModel);
			}
		}
		
	}
}
