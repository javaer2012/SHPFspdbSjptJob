package com.ideal.spdb.tencent.model;

import com.ideal.spdb.utils.BaseModel;
import com.ideal.spdb.utils.ExcelAnnotation;

public class TencentReportModel extends BaseModel {

	private static final long serialVersionUID = -6786615463811504327L;
	private String tencentId;
	@ExcelAnnotation(id=1,name="申请件编号")
	private String appid;
	@ExcelAnnotation(id=2,name="证件号码")
	private String idno;
	@ExcelAnnotation(id=3,name="姓名")
	private String appname;
	@ExcelAnnotation(id=4,name="查询时间")
	private String createDate;
	@ExcelAnnotation(id=5,name="实名制")
	private String frealHis;
	
    private String startSearchDate;  //开始查询日期
	private String endSearchDate;  //结束查询日期
	private String startReturnDate;  //开始返回日期
	private String endReturnDate;  //结束返回日期
	
	@ExcelAnnotation(id=7,name="查询结果")
	private String isEffective;
	@ExcelAnnotation(id=8,name="导入结果")
	private String flag;
	@ExcelAnnotation(id=9,name="查询类型")
	private String callType;
	@ExcelAnnotation(id=10,name="腾讯数据类型")
	private String tencentType;
	
	private String card_type;  //证件类型
	private String freg_his;  //注册历史0:无注册 1:1年以内  2:1(含)-2年 3:2(含)-3年 4-:3年及以上
	private String freal_his;  //实名历史0:非实名 1:1年以内  2:1(含)-2年 3:2(含)-3年 4-:3年及以上
	private String fbind_credit_his;  //绑定信用卡时长0:无绑卡  1:1年以内  2:1(含)-2年  3:2(含)-3年  4:3年及以上
	private String fbind_cre_cnt;  //绑定信用卡张数0：无绑卡 1：绑卡1张 2：绑卡2张 3：绑卡3张及以上
	private String fbind_mobile_his;  //绑定用户时长0：无绑定 1：1年以内 2：1（含）-2年 3：2（含）-3年 4：3年及以上
	private String fbind_mobile_recent;  //最近绑定手机情况0：无绑定 1：1年以内 2：1（含）-2年 3：2（含）-3年 4：3年及以上
	private String fbind_mobile_chg;  //手机稳定性0：无手机号码 1：手机号码更改3次及以上 2：手机号码更改2次 3：手机号码更改1次 4：手机号码无更改
	private String faddress_chg;  //地址稳定性 0：无联系地址 1： 联系地址更改3次及以上 2：联系地址更改2次 3：联系地址更改1次 4：联系地址无更改
	private String fxf_level;  //消费层次0：无消费 1：100元以内 2：100（含）-500元 3：500（含）-1000元 4：1000元及以上
	private String fzz_level;  //转账层次0：无转账 1： 100元以内 2：100（含）-500元 3：500（含）-1000元 4：1000元及以上
	private String flc_level;  //理财申购层次0：无理财申购 1： 1000元以内 2：1000（含）-3000元 3：3000（含）-5000元 4：5000元及以上
	private String fhk_level;  //信用卡还款情况 0：无还款 1：1-3个月有还款 2：  4-6个月有还款 3：7-11个月有还款 4：12个月均有还款
	private String fjf_level;  //生活缴费情况 0：无缴费 1：1-3个月有缴费 2：  4-6个月有缴费 3：7-11个月有缴费 4：12个月均有缴费
	private String floan_balance;  //贷款余额0：无贷款 1：  500元以内 2：500（含）-2000元 3： 2000（含）-10000元 4： 10000元及以上
	private String floan_unpay_cnt;  //未结清贷款笔数 0：无贷款 1：未结清0笔 2：未结清1-2笔 3： 未结清3-5笔 4： 未结清6笔及以上
	private String floan_state;  //当前贷款状态 0-  无贷款 1-  正常（当前无逾期） 2-  逾期30天以内 3-  逾期30（含）-90天 4-  逾期90天及以上
	private String flast_dead_line;  //当前贷款状态 0-  无贷款 1-  正常（历史无逾期） 2-  距今30天以内 3-  距今30（含）-90天 4-  距今90天及以上
	private String fdead_unpay_cnt;  //逾期贷款笔数 0-  无贷款 1-  逾期0笔 2-  逾期1-2笔 3-  逾期3-5笔 4-  逾期6笔及以上
	private String finternet_age;  //网龄 0-  无qq号码 1-  新用户 1年以内 2-  中度用户 1（含）-6年   3-  资深用户 6（含）-13年  4-  超级资深用户 13年及以上
	private String factive_level;  //社交活跃度 0-  无qq号码 1-  静止用户    登录5天以内 2-  低活跃用户 登录5（含）-15天 3-  活跃用户    登录15（含）-25天 4-  高活跃用户 登录25天及以上
	private String fsocial_level;  //社交圈 0-  无qq号码 1-  好友数 20个以内 2-  好友数 20（含）-50个 3-  好友数 50（含）-200个 4-  好友数 200个及以上
	private String fjy_amt_level;  //在线交易量 0-  无交易 1-  500元以内 2-  500（含）-2000元 3-  2000（含）-5000元 4-  5000元及以上
	private String fjy_month_level;  //在线交易活跃度 0-  无交易 1-  1-3个月有交易 2-  4-6个月有交易 3-  7-11个月有交易 4-  12个月均有交易
	
	private String cdate;    //评估时间
	private String score;    //征信评分
	private String pd;    //违约率
	
	@ExcelAnnotation(id=11,name="腾讯数据类型")
	private String is_local;  //是否调用本地库数据 1是 0不是
	
	public String getTencentId() {
		return tencentId;
	}
	public void setTencentId(String tencentId) {
		this.tencentId = tencentId;
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
	public String getFrealHis() {
		return frealHis;
	}
	public void setFrealHis(String frealHis) {
		this.frealHis = frealHis;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
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
	public String getTencentType() {
		return tencentType;
	}
	public void setTencentType(String tencentType) {
		this.tencentType = tencentType;
	}
	public String getIsEffective() {
		return isEffective;
	}
	public void setIsEffective(String isEffective) {
		this.isEffective = isEffective;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	public String getCallType() {
		return callType;
	}
	public void setCallType(String callType) {
		this.callType = callType;
	}
	public String getCard_type() {
		return card_type;
	}
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}
	public String getFreg_his() {
		return freg_his;
	}
	public void setFreg_his(String freg_his) {
		this.freg_his = freg_his;
	}
	public String getFreal_his() {
		return freal_his;
	}
	public void setFreal_his(String freal_his) {
		this.freal_his = freal_his;
	}
	public String getFbind_credit_his() {
		return fbind_credit_his;
	}
	public void setFbind_credit_his(String fbind_credit_his) {
		this.fbind_credit_his = fbind_credit_his;
	}
	public String getFbind_cre_cnt() {
		return fbind_cre_cnt;
	}
	public void setFbind_cre_cnt(String fbind_cre_cnt) {
		this.fbind_cre_cnt = fbind_cre_cnt;
	}
	public String getFbind_mobile_his() {
		return fbind_mobile_his;
	}
	public void setFbind_mobile_his(String fbind_mobile_his) {
		this.fbind_mobile_his = fbind_mobile_his;
	}
	public String getFbind_mobile_recent() {
		return fbind_mobile_recent;
	}
	public void setFbind_mobile_recent(String fbind_mobile_recent) {
		this.fbind_mobile_recent = fbind_mobile_recent;
	}
	public String getFbind_mobile_chg() {
		return fbind_mobile_chg;
	}
	public void setFbind_mobile_chg(String fbind_mobile_chg) {
		this.fbind_mobile_chg = fbind_mobile_chg;
	}
	public String getFaddress_chg() {
		return faddress_chg;
	}
	public void setFaddress_chg(String faddress_chg) {
		this.faddress_chg = faddress_chg;
	}
	public String getFxf_level() {
		return fxf_level;
	}
	public void setFxf_level(String fxf_level) {
		this.fxf_level = fxf_level;
	}
	public String getFzz_level() {
		return fzz_level;
	}
	public void setFzz_level(String fzz_level) {
		this.fzz_level = fzz_level;
	}
	public String getFlc_level() {
		return flc_level;
	}
	public void setFlc_level(String flc_level) {
		this.flc_level = flc_level;
	}
	public String getFhk_level() {
		return fhk_level;
	}
	public void setFhk_level(String fhk_level) {
		this.fhk_level = fhk_level;
	}
	public String getFjf_level() {
		return fjf_level;
	}
	public void setFjf_level(String fjf_level) {
		this.fjf_level = fjf_level;
	}
	public String getFloan_balance() {
		return floan_balance;
	}
	public void setFloan_balance(String floan_balance) {
		this.floan_balance = floan_balance;
	}
	public String getFloan_unpay_cnt() {
		return floan_unpay_cnt;
	}
	public void setFloan_unpay_cnt(String floan_unpay_cnt) {
		this.floan_unpay_cnt = floan_unpay_cnt;
	}
	public String getFloan_state() {
		return floan_state;
	}
	public void setFloan_state(String floan_state) {
		this.floan_state = floan_state;
	}
	public String getFlast_dead_line() {
		return flast_dead_line;
	}
	public void setFlast_dead_line(String flast_dead_line) {
		this.flast_dead_line = flast_dead_line;
	}
	public String getFdead_unpay_cnt() {
		return fdead_unpay_cnt;
	}
	public void setFdead_unpay_cnt(String fdead_unpay_cnt) {
		this.fdead_unpay_cnt = fdead_unpay_cnt;
	}
	public String getFinternet_age() {
		return finternet_age;
	}
	public void setFinternet_age(String finternet_age) {
		this.finternet_age = finternet_age;
	}
	public String getFactive_level() {
		return factive_level;
	}
	public void setFactive_level(String factive_level) {
		this.factive_level = factive_level;
	}
	public String getFsocial_level() {
		return fsocial_level;
	}
	public void setFsocial_level(String fsocial_level) {
		this.fsocial_level = fsocial_level;
	}
	public String getFjy_amt_level() {
		return fjy_amt_level;
	}
	public void setFjy_amt_level(String fjy_amt_level) {
		this.fjy_amt_level = fjy_amt_level;
	}
	public String getFjy_month_level() {
		return fjy_month_level;
	}
	public void setFjy_month_level(String fjy_month_level) {
		this.fjy_month_level = fjy_month_level;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getPd() {
		return pd;
	}
	public void setPd(String pd) {
		this.pd = pd;
	}
	public String getIs_local() {
		return is_local;
	}
	public void setIs_local(String is_local) {
		this.is_local = is_local;
	}
	
	
}
