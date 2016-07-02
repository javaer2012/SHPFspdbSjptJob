package com.ideal.spdb.system.to;

import com.ideal.spdb.utils.BaseModel;

/**
 * 
 * <p>Title:  浦发五星项目</p>
 * <p>Description:子节点资源TO(Transfer Object)数据传输对象</p>
 * <p>Company: 上海理想信息产业(集团)有限公司</p>
 * @author wls
 * create date: 2011-8-31
 * @version 1.0
 */
public class SysChildnodeResourceT0 extends BaseModel {
	private static final long serialVersionUID = 1L;
	private String moduleName;//模块名称
	private String systemUrl;// 路径
	private String fathernodeId;// 父节点id
	private String column4;// 备份字段



	public SysChildnodeResourceT0(String moduleName, String systemUrl,
			String fathernodeId, String column4) {
		this.moduleName = moduleName;
		this.systemUrl = systemUrl;
		this.fathernodeId = fathernodeId;
		this.column4 = column4;
	}

	public SysChildnodeResourceT0() {
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = super.filter(moduleName);
	}

	public String getSystemUrl() {
		return systemUrl;
	}

	public void setSystemUrl(String systemUrl) {
		this.systemUrl =  super.filter(systemUrl);
	}

	public String getFathernodeId() {
		return fathernodeId;
	}

	public void setFathernodeId(String fathernodeId) {
		this.fathernodeId =  super.filter(fathernodeId);
	}

	public String getColumn4() {
		return column4;
	}

	public void setColumn4(String column4) {
		this.column4 =  super.filter(column4);
	}

}