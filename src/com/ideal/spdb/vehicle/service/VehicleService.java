package com.ideal.spdb.vehicle.service;

import java.util.List;

import com.ideal.spdb.utils.BaseService;
import com.ideal.spdb.vehicle.model.VehicleModel;

public interface VehicleService extends BaseService<VehicleModel> {
	
	/**
	 * 查询汽车信息
	 * @param vehicle
	 * @return
	 */
	List<VehicleModel> queryVehicleInfo(VehicleModel vehicle);
}
