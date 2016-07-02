package com.ideal.spdb.system.to;

import com.ideal.spdb.utils.BaseModel;

/**
 * 
 * <p>Title:  浦发五星项目</p>
 * <p>Description:父节点资源TO(Transfer Object)数据传输对象</p>
 * <p>Company: 上海理想信息产业(集团)有限公司</p>
 * @author wls
 * create date: 2011-8-31
 * @version 1.0
 */
public class SysFathernodeResourceTO extends BaseModel {
	private static final long serialVersionUID = 1L;
	private String fathernodeName;// 父节点名称
	
	public SysFathernodeResourceTO(String fathernodeName,
			String column3) {
		this.fathernodeName = fathernodeName;
		this.column3 = column3;
	}

	public SysFathernodeResourceTO() {
	}

	private String column3;// 备份字段


	public String getFathernodeName() {
		return fathernodeName;
	}

	public void setFathernodeName(String fathernodeName) {
		this.fathernodeName =  super.filter(fathernodeName);
	}

	public String getColumn3() {
		return column3;
	}

	public void setColumn3(String column3) {
		this.column3 =  super.filter(column3);
	}

}