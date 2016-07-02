package com.ideal.spdb.vehicle.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ideal.spdb.utils.BaseDaoImpl;
import com.ideal.spdb.vehicle.dao.VehicleDao;
import com.ideal.spdb.vehicle.model.VehicleModel;

@Repository("VehicleDao")
public class VehicleDaoImpl extends BaseDaoImpl<VehicleModel> implements VehicleDao {

	private static final Logger log = Logger.getLogger(VehicleDaoImpl.class);
	
	@Override
	public List<VehicleModel> queryVehicleInfo(VehicleModel vehicle) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("vehicle.queryVehicleInfo", vehicle);
	}
	
}
