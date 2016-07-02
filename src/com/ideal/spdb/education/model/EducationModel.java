package com.ideal.spdb.education.model;

import java.sql.Clob;
import java.util.Date;

import com.ideal.spdb.utils.BaseModel;
import com.ideal.spdb.utils.ExcelAnnotation;

public class EducationModel extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String educationId; // 主键ID
	
	@ExcelAnnotation(id=1,name="申请书编号")
	private String applicationId; // 申请书编号
	
	@ExcelAnnotation(id=2,name="证件号码")
	private String identityCard; // 身份证号码
	
	@ExcelAnnotation(id=3,name="姓名")
	private String userName; // 姓名
	
	@ExcelAnnotation(id=4,name="毕业院校名称")
	private String graduate; // 毕业学院
	
	@ExcelAnnotation(id=5,name="毕业时间")
	private String graduateTime; // 毕业年份，格式yyyy
	
	@ExcelAnnotation(id=6,name="学历类型")
	private String studyStyle; // 学历类型
	
	@ExcelAnnotation(id=7,name="学历层次")
	private String educationDegree; // 学历
	
	@ExcelAnnotation(id=8,name="专业")
	private String specialityName; // 专业
	
	@ExcelAnnotation(id=9,name="毕业结论")
	private String studyResult; // 毕业结论
	
	@ExcelAnnotation(id=10,name="备注")
	private String results; // 备注，调用学历验证接口返回值
	
	@ExcelAnnotation(id=11,name="触发查询时间")
    private String callDate;
	
	@ExcelAnnotation(id=12,name="返回查询时间")
    private String recordDate;
	
	/**查询记录数**/
    private long querryRecords;
	
	private String enrol_date; // 入学日期，格式yyyyMMdd
	private Clob photo; // 照片
	private Date create_time; // 创建日期
	
	private String callType; // 处理类型
	
	@ExcelAnnotation(id=12,name="是否调库")
	private String is_local;  //是否调用本地库数据 1是 0不是
	
	public String getEducationId() {
		return educationId;
	}
	public void setEducationId(String educationId) {
		this.educationId = educationId;
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
	public String getGraduate() {
		return graduate;
	}
	public void setGraduate(String graduate) {
		this.graduate = graduate;
	}
	public String getEducationDegree() {
		return educationDegree;
	}
	public void setEducationDegree(String educationDegree) {
		this.educationDegree = educationDegree;
	}
	public String getEnrol_date() {
		return enrol_date;
	}
	public void setEnrol_date(String enrol_date) {
		this.enrol_date = enrol_date;
	}
	public String getSpecialityName() {
		return specialityName;
	}
	public void setSpecialityName(String specialityName) {
		this.specialityName = specialityName;
	}
	public String getGraduateTime() {
		return graduateTime;
	}
	public void setGraduateTime(String graduateTime) {
		this.graduateTime = graduateTime;
	}
	public String getStudyResult() {
		return studyResult;
	}
	public void setStudyResult(String studyResult) {
		this.studyResult = studyResult;
	}
	public String getStudyStyle() {
		return studyStyle;
	}
	public void setStudyStyle(String studyStyle) {
		this.studyStyle = studyStyle;
	}
	public String getResults() {
		return results;
	}
	public void setResults(String results) {
		this.results = results;
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
	public Clob getPhoto() {
		return photo;
	}
	public void setPhoto(Clob photo) {
		this.photo = photo;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
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
	public String getCallType() {
		return callType;
	}
	public void setCallType(String callType) {
		this.callType = callType;
	}
	
}
