package com.ideal.spdb.vehicle.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ideal.spdb.utils.BaseServiceImpl;
import com.ideal.spdb.vehicle.dao.VehicleDao;
import com.ideal.spdb.vehicle.model.VehicleModel;
import com.ideal.spdb.vehicle.service.VehicleService;

@Service("VehicleService")
public class VehicleServiceImpl extends BaseServiceImpl<VehicleModel> implements VehicleService {
	
	private static final Logger log = Logger.getLogger(VehicleServiceImpl.class);
	
	@Inject
	private VehicleDao dao;

	@Override
	public List<VehicleModel> queryVehicleInfo(VehicleModel vehicle) {
		// TODO Auto-generated method stub
		return dao.queryVehicleInfo(vehicle);
	}

}
