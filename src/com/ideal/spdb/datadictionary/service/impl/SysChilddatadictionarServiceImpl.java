package com.ideal.spdb.datadictionary.service.impl;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ideal.spdb.datadictionary.dao.ISysChilddatadictionarDao;
import com.ideal.spdb.datadictionary.model.SysChilddatadictionarModel;
import com.ideal.spdb.datadictionary.service.ISysChilddatadictionarService;
import com.ideal.spdb.utils.BaseServiceImpl;

/**
 * 
 * <p>Title: 浦发五星项目</p>
 * <p>Description:数据字典管理service实现类</p>
 * <p>Company: 上海理想信息产业(集团)有限公司</p>
 * @author wls
 * create date: 2011-10-10
 * @version 1.0
 */
@Service("sysChilddatadictionarService")
public class SysChilddatadictionarServiceImpl extends
		BaseServiceImpl<SysChilddatadictionarModel> implements
		ISysChilddatadictionarService {
	@Inject ISysChilddatadictionarDao sysChilddatadictionarDao;
	/**
	 * 生成序列值
	 * @param type子系统类型（1：接入子系统；2：队列管理子系统；3：监控管理子系统）
	 * @return 返回生成的序列值
	 */
	public String getSequenceValue(String type)throws Exception{
		Map<String,String>map=sysChilddatadictionarDao.getSequenceValue(type);
		String out_system_seq=map.get("out_system_seq");
		return  out_system_seq;
	}
}
