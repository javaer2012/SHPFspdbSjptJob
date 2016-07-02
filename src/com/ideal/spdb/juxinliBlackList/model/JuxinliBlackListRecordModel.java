package com.ideal.spdb.juxinliBlackList.model;

import com.ideal.spdb.utils.BaseModel;
import com.ideal.spdb.utils.ExcelAnnotation;

public class JuxinliBlackListRecordModel extends BaseModel {
	
	private String recordId;    //申请书编号
	@ExcelAnnotation(id=1,name="申请件编号")
	private String applicationId;    //申请书编号
	@ExcelAnnotation(id=3,name="证件号码")
	private String identityCard;    //身份证号码
	@ExcelAnnotation(id=2,name="姓名")
	private String userName;    //姓名
	
	private String juxinliCreate_time;    //聚信力创建时间
	private String juxinliUpdate_time;    //聚信力更新时间
	@ExcelAnnotation(id=6,name="来源")
	private String categories;    //黑名单来源
	@ExcelAnnotation(id=7,name="其他信息")
	private String others;    //其他信息
	
	private String mobiles;    //电话

	private String createDime;    //创建时间
	@ExcelAnnotation(id=16,name="触发查询时间")
	private String callDate;    //调用时间
	@ExcelAnnotation(id=17,name="返回查询时间")
	private String recordDate;    //返回时间
	
	private String startSearchDate;  //开始查询日期
	private String endSearchDate;  //结束查询日期
	private String startReturnDate;  //开始返回日期
	private String endReturnDate;  //结束返回日期
	
	@ExcelAnnotation(id=15,name="查询类型")
	private String callType;  //查询类型
	
	@ExcelAnnotation(id=14,name="导入结果")
	private String flag;  //是否上传 ：1上传，0未上传
	@ExcelAnnotation(id=13,name="查询结果")
	private String isEffective; // 查询是否有效:0查询成功，1未查到数据，2查询失败，3未查询
	private String remark;  //备注信息 
	
	private String projetNo;    //项目编号
	private String projetName;    //项目名称

	@ExcelAnnotation(id=4,name="申请人手机")
	public String user_mobiles;  //申请人手机
	public String blacklistmobiles;  //黑名单电话
	public String blacklistaddress;  //黑名单地址
	public String jierubenjin;  //累计借入本金
	public String yuqitianshu;  //最大逾期天数
	@ExcelAnnotation(id=5,name="是否中黑名单")
	public String isinblacklist;  //是否中黑名单
	@ExcelAnnotation(id=8,name="黑名单更新时间")
	public String blacklistupdatetime;  //黑名单更新时间
	@ExcelAnnotation(id=9,name="黑名单创建时间")
	public String blacklistcreatetime;  //黑名单创建时间
	
	/**查询记录数**/
    private long querryRecords;
    
    @ExcelAnnotation(id=18,name="是否调库")
    private String is_local;  //是否调用本地库数据 1是 0不是
    
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	public String getIdentityCard() {
		return identityCard;
	}
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getJuxinliCreate_time() {
		return juxinliCreate_time;
	}
	public void setJuxinliCreate_time(String juxinliCreate_time) {
		this.juxinliCreate_time = juxinliCreate_time;
	}
	public String getJuxinliUpdate_time() {
		return juxinliUpdate_time;
	}
	public void setJuxinliUpdate_time(String juxinliUpdate_time) {
		this.juxinliUpdate_time = juxinliUpdate_time;
	}
	public String getCategories() {
		return categories;
	}
	public void setCategories(String categories) {
		this.categories = categories;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	public String getMobiles() {
		return mobiles;
	}
	public void setMobiles(String mobiles) {
		this.mobiles = mobiles;
	}
	public String getCreateDime() {
		return createDime;
	}
	public void setCreateDime(String createDime) {
		this.createDime = createDime;
	}
	public String getCallDate() {
		return callDate;
	}
	public void setCallDate(String callDate) {
		this.callDate = callDate;
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public String getStartSearchDate() {
		return startSearchDate;
	}
	public void setStartSearchDate(String startSearchDate) {
		this.startSearchDate = startSearchDate;
	}
	public String getEndSearchDate() {
		return endSearchDate;
	}
	public void setEndSearchDate(String endSearchDate) {
		this.endSearchDate = endSearchDate;
	}
	public String getStartReturnDate() {
		return startReturnDate;
	}
	public void setStartReturnDate(String startReturnDate) {
		this.startReturnDate = startReturnDate;
	}
	public String getEndReturnDate() {
		return endReturnDate;
	}
	public void setEndReturnDate(String endReturnDate) {
		this.endReturnDate = endReturnDate;
	}
	public String getCallType() {
		return callType;
	}
	public void setCallType(String callType) {
		this.callType = callType;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getIsEffective() {
		return isEffective;
	}
	public void setIsEffective(String isEffective) {
		this.isEffective = isEffective;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getProjetNo() {
		return projetNo;
	}
	public void setProjetNo(String projetNo) {
		this.projetNo = projetNo;
	}
	public String getProjetName() {
		return projetName;
	}
	public void setProjetName(String projetName) {
		this.projetName = projetName;
	}
	public String getUser_mobiles() {
		return user_mobiles;
	}
	public void setUser_mobiles(String user_mobiles) {
		this.user_mobiles = user_mobiles;
	}
	public String getBlacklistmobiles() {
		return blacklistmobiles;
	}
	public void setBlacklistmobiles(String blacklistmobiles) {
		this.blacklistmobiles = blacklistmobiles;
	}
	public String getBlacklistaddress() {
		return blacklistaddress;
	}
	public void setBlacklistaddress(String blacklistaddress) {
		this.blacklistaddress = blacklistaddress;
	}
	public String getJierubenjin() {
		return jierubenjin;
	}
	public void setJierubenjin(String jierubenjin) {
		this.jierubenjin = jierubenjin;
	}
	public String getYuqitianshu() {
		return yuqitianshu;
	}
	public void setYuqitianshu(String yuqitianshu) {
		this.yuqitianshu = yuqitianshu;
	}
	public String getIsinblacklist() {
		return isinblacklist;
	}
	public void setIsinblacklist(String isinblacklist) {
		this.isinblacklist = isinblacklist;
	}
	public String getBlacklistupdatetime() {
		return blacklistupdatetime;
	}
	public void setBlacklistupdatetime(String blacklistupdatetime) {
		this.blacklistupdatetime = blacklistupdatetime;
	}
	public String getBlacklistcreatetime() {
		return blacklistcreatetime;
	}
	public void setBlacklistcreatetime(String blacklistcreatetime) {
		this.blacklistcreatetime = blacklistcreatetime;
	}
	public long getQuerryRecords() {
		return querryRecords;
	}
	public void setQuerryRecords(long querryRecords) {
		this.querryRecords = querryRecords;
	}
	public String getIs_local() {
		return is_local;
	}
	public void setIs_local(String is_local) {
		this.is_local = is_local;
	}
	
}
