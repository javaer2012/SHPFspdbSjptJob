package com.ideal.spdb.system.to;

import com.ideal.spdb.utils.BaseModel;

/**
 * 
 * <p>Title:  浦发五星项目</p>
 * <p>Description:模块具体操作权限TO(Transfer Object)数据传输对象</p>
 * <p>Company: 上海理想信息产业(集团)有限公司</p>
 * @author wls
 * create date: 2011-11-3
 * @version 1.0
 */
public class SysAuthorityResourceTO extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String authorityCode;//功能编码
	private String authorityName;//功能名称
	private String childnodeId;//子节点ID
    private String buttonInfo;//按钮信息
	
	public SysAuthorityResourceTO(String authorityCode,
			String authorityName, String childnodeId, String  buttonInfo) {
		this.authorityCode = authorityCode;
		this.authorityName = authorityName;
		this.childnodeId = childnodeId;
		this.buttonInfo = buttonInfo;
	}
	
	public SysAuthorityResourceTO() {
	}


	public String getAuthorityCode() {
		return authorityCode;
	}
	public void setAuthorityCode(String authorityCode) {
		this.authorityCode = super.filter(authorityCode);
	}
	public String getAuthorityName() {
		return authorityName;
	}
	public void setAuthorityName(String authorityName) {
		this.authorityName = super.filter(authorityName);
	}
	public String getChildnodeId() {
		return childnodeId;
	}
	public void setChildnodeId(String childnodeId) {
		this.childnodeId = super.filter(childnodeId);
	}

	public String getButtonInfo() {
		return buttonInfo;
	}

	public void setButtonInfo(String buttonInfo) {
		this.buttonInfo = super.filter(buttonInfo);
	}
	
}
