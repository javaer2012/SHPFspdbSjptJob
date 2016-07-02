package com.ideal.spdb.pboc.service.impl;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ideal.spdb.pboc.dao.PbocDao;
import com.ideal.spdb.pboc.model.PbocModel;
import com.ideal.spdb.pboc.service.PbocService;
import com.ideal.spdb.utils.BaseServiceImpl;

@Service("pbocService")
public class PbocServiceImpl extends BaseServiceImpl<PbocModel> implements PbocService{
	
	private static final Logger log = Logger.getLogger(PbocServiceImpl.class);
	
	@Inject
	private PbocDao pbocDao;
	
	@Override
	public int getUserCount(String username) throws Exception{
		return pbocDao.getUserCount(username);
	}

	/**
	 * pboc查询
	 * @param pbocModel
	 * @return
	 * @throws Exception
	 */
	@Override
	public String queryPboc(PbocModel pbocModel) throws Exception {
		//判断是否存在于applicaiton表中,如果不存在，则插入一条数据
		if(null == pbocDao.get("pboc.selectAppliction", pbocModel)){
			log.info(pbocModel.getShenqingshucode()+"不存在，开始插入");
			if(true == pbocDao.add("pboc.addApplicationInfoById", pbocModel)){
				log.info(pbocModel.getShenqingshucode()+"插入成功");
			}else {
				log.info(pbocModel.getShenqingshucode()+"插入失败");
				throw new Exception();
			}
		}else {
			log.info(pbocModel.getShenqingshucode()+"存在，开始更新信息");
			if(pbocDao.edit("pboc.editApplicationInfoById", pbocModel)){
				log.info(pbocModel.getShenqingshucode()+"更新成功");
			}else{
				log.info(pbocModel.getShenqingshucode()+"更新失败");
				throw new Exception();
			}
		}
		//插入调用流程表pf_process
		pbocDao.add("pboc.addPbocProcee", pbocModel);
		return "success";
	}

}
