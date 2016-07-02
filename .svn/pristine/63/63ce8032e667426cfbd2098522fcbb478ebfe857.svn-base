package com.ideal.spdb.datadictionary.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ideal.spdb.datadictionary.dao.ISysChilddatadictionarDao;
import com.ideal.spdb.datadictionary.model.SysChilddatadictionarModel;
import com.ideal.spdb.utils.BaseDaoImpl;

/**
 * 
 * <p>Title: 浦发五星项目</p>
 * <p>Description:数据字典管理dao实现类</p>
 * <p>Company: 上海理想信息产业(集团)有限公司</p>
 * @author wls
 * create date: 2011-10-10
 * @version 1.0
 */
@Repository("sysChilddatadictionarDao")
public class SysChilddatadictionarDaoImpl extends BaseDaoImpl<SysChilddatadictionarModel>
		implements ISysChilddatadictionarDao {
	/**
	 * 生成序列值
	 * @param type子系统类型（1：接入子系统；2：队列管理子系统；3：监控管理子系统）
	 * @return 返回生成的序列值
	 */
	public 	Map<String,String> getSequenceValue(String type)throws Exception{
		Map<String,String>map=new HashMap<String, String>();
		map.put("in_subsystem_id",type);
		map.put("out_system_seq","");
		this.getSqlSession().selectOne("sysChilddatadictionar.getSequenceValue",map);
		return map;
	}

}
