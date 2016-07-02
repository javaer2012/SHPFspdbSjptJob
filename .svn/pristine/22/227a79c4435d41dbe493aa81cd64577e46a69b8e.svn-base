package com.ideal.spdb.thirdinfo.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;



import com.ideal.spdb.thirdinfo.dao.IEducationTxtDao;
import com.ideal.spdb.thirdinfo.dao.IVehicleDao;
import com.ideal.spdb.thirdinfo.model.Vehicle;
import com.ideal.spdb.utils.BaseDaoImpl;
@Repository
public class VehicleDaoImpl extends BaseDaoImpl<Vehicle> implements IVehicleDao{
	@Inject
	IEducationTxtDao EducationTxtdao;
	/**
	 * 查询符合要求的车辆信息，flag=0 同时PF_application表中有该件
	 */
	public String getConfigIP(String costVale) {
		String ipString = (String) this.getSqlSession().selectOne(
				"Vehicle.getConfigIP", costVale);
		log.info(costVale+"sql======="+ipString);
		return ipString;
	}
	/**
	 * 更新flag上传信息状态为1
	 */

	@SuppressWarnings("unchecked")
	public List<Vehicle> getNeedExportCarInfo() {
		List<Vehicle> list = null;
		list = this.getSqlSession().selectList("Vehicle.getNeedCarInfoList");
		return list;
	}


	@Override
	public boolean updateFlag(Vehicle tci) {
		boolean res = false;
		this.getSqlSession().update("vehicle.updataFlag",tci);
		res = true;
		return res;

	}
	/**
	 * 用于获取批次号
	 */
	public Map<String,String> getXuHao(int type){
		Map<String,String>map=new HashMap<String, String>();
		//待存储过程移植过来
//		String type1 = type + "";
//		map.put("in_type", type1);
		String xuHao = EducationTxtdao.getXuHao(type).get("out_system_seq");
		map.put("out_system_seq",xuHao);
//		this.getSqlSession().selectOne("educationTxt.getSequenceValue",map);
		return map;
	}

}
