package com.ideal.spdb.tencent.model;

public class TencentFraudReportModel {
	private String tencent_id;    //id
	private String appid;    //申请书编号
	private String idno;    //证件号
	private String appname;    //姓名
	private String ret_code;    //0 请求成功，非0 请求失败
	private String ret_msg;    //请求失败返回的错误信息或则不匹配详细信息
	private String type;    //id qq mobile
	private String anticheatrank;    //总反欺诈评级
	private String devicerank;    //设备反欺诈评级
	private String identityrank;    //用户身份反欺诈评级
	private String relachainrank;    //用户关系链返欺诈评级
	private String relationrank;    //账户关联返欺诈评级
	private String isactuser;    //是否活跃用户
	private String iscommipc;    //是否常用ip段
	private String isnewdevice;    //是否新设备
	private String isnewuser;    //是否新用户
	private String issensiplace;    //是否敏感地区
	private String provnum;    //最近登录不同省份个数
	private String qq_id;    //'0'	匹配 1：不匹配，默认值为0
	private String qq_name;    //'0'	匹配 1：不匹配，默认值为0
	private String qq_mobile;    //'0'	匹配 1：不匹配，默认值为0
	private String id_name;    //'0'	匹配 1：不匹配，默认值为0
	private String id_mobile;    //'0'	匹配 1：不匹配，默认值为0
	private String qq;    //qq号
	private String mobile;    //手机号
	private String create_date;    //生成记录时间
	private String calltype;    //外部请求类别,0：线下导入，1：批量，2：手动查询，3：线上预筛
	private String is_effective;    //查询是否有效:0查询成功，1未查到数据，2查询失败，3未查询
	private String flag;    //是否上传 ：1上传，0未上传
	private String version;    //用来表示同一次查询
	private String isinstinct;    //是否上传instinct：1上传，0未上传
	private String is_local;    //是否本地库 (1本地 0接口)
	private String approvalflag;    //是否上传按特殊格式上传审批系统
	private String remark;
	
	public String getTencent_id() {
		return tencent_id;
	}
	public void setTencent_id(String tencent_id) {
		this.tencent_id = tencent_id;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getIdno() {
		return idno;
	}
	public void setIdno(String idno) {
		this.idno = idno;
	}
	public String getAppname() {
		return appname;
	}
	public void setAppname(String appname) {
		this.appname = appname;
	}
	public String getRet_code() {
		return ret_code;
	}
	public void setRet_code(String ret_code) {
		this.ret_code = ret_code;
	}
	public String getRet_msg() {
		return ret_msg;
	}
	public void setRet_msg(String ret_msg) {
		this.ret_msg = ret_msg;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAnticheatrank() {
		return anticheatrank;
	}
	public void setAnticheatrank(String anticheatrank) {
		this.anticheatrank = anticheatrank;
	}
	public String getDevicerank() {
		return devicerank;
	}
	public void setDevicerank(String devicerank) {
		this.devicerank = devicerank;
	}
	public String getIdentityrank() {
		return identityrank;
	}
	public void setIdentityrank(String identityrank) {
		this.identityrank = identityrank;
	}
	public String getRelachainrank() {
		return relachainrank;
	}
	public void setRelachainrank(String relachainrank) {
		this.relachainrank = relachainrank;
	}
	public String getRelationrank() {
		return relationrank;
	}
	public void setRelationrank(String relationrank) {
		this.relationrank = relationrank;
	}
	public String getIsactuser() {
		return isactuser;
	}
	public void setIsactuser(String isactuser) {
		this.isactuser = isactuser;
	}
	public String getIscommipc() {
		return iscommipc;
	}
	public void setIscommipc(String iscommipc) {
		this.iscommipc = iscommipc;
	}
	public String getIsnewdevice() {
		return isnewdevice;
	}
	public void setIsnewdevice(String isnewdevice) {
		this.isnewdevice = isnewdevice;
	}
	public String getIsnewuser() {
		return isnewuser;
	}
	public void setIsnewuser(String isnewuser) {
		this.isnewuser = isnewuser;
	}
	public String getIssensiplace() {
		return issensiplace;
	}
	public void setIssensiplace(String issensiplace) {
		this.issensiplace = issensiplace;
	}
	public String getProvnum() {
		return provnum;
	}
	public void setProvnum(String provnum) {
		this.provnum = provnum;
	}
	public String getQq_id() {
		return qq_id;
	}
	public void setQq_id(String qq_id) {
		this.qq_id = qq_id;
	}
	public String getQq_name() {
		return qq_name;
	}
	public void setQq_name(String qq_name) {
		this.qq_name = qq_name;
	}
	public String getQq_mobile() {
		return qq_mobile;
	}
	public void setQq_mobile(String qq_mobile) {
		this.qq_mobile = qq_mobile;
	}
	public String getId_name() {
		return id_name;
	}
	public void setId_name(String id_name) {
		this.id_name = id_name;
	}
	public String getId_mobile() {
		return id_mobile;
	}
	public void setId_mobile(String id_mobile) {
		this.id_mobile = id_mobile;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getCalltype() {
		return calltype;
	}
	public void setCalltype(String calltype) {
		this.calltype = calltype;
	}
	public String getIs_effective() {
		return is_effective;
	}
	public void setIs_effective(String is_effective) {
		this.is_effective = is_effective;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getIsinstinct() {
		return isinstinct;
	}
	public void setIsinstinct(String isinstinct) {
		this.isinstinct = isinstinct;
	}
	public String getIs_local() {
		return is_local;
	}
	public void setIs_local(String is_local) {
		this.is_local = is_local;
	}
	public String getApprovalflag() {
		return approvalflag;
	}
	public void setApprovalflag(String approvalflag) {
		this.approvalflag = approvalflag;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
