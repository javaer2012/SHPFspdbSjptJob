package com.ideal.spdb.system.model;

import org.directwebremoting.annotations.DataTransferObject;

import com.ideal.spdb.utils.BaseModel;

/**
 * 
 * <p>Title: 浦发五星项目</p>
 * <p>Description:父节点资源表实体</p>
 * <p>Company: 上海理想信息产业(集团)有限公司</p>
 * @author wls
 * create date: 2011-8-31
 * @version 1.0
 */
@DataTransferObject 
public class SysFathernodeResourceModel extends BaseModel {
	private static final long serialVersionUID = 1L;
	private String fathernodeName;// 父节点名称
	private String column3;// 备份字段
	
	public SysFathernodeResourceModel(String fathernodeName,
			String column3) {
		this.fathernodeName = fathernodeName;
		this.column3 = column3;
	}

	public SysFathernodeResourceModel() {
	}


	public String getFathernodeName() {
		return fathernodeName;
	}

	public void setFathernodeName(String fathernodeName) {
		this.fathernodeName = fathernodeName;
	}

	public String getColumn3() {
		return column3;
	}

	public void setColumn3(String column3) {
		this.column3 = column3;
	}

}