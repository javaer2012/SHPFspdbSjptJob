package com.ideal.spdb.utils;

import java.io.File;
import java.io.Serializable;

/**
 *Model基类
 * <p>Title: 浦发五星项目</p>
 * <p>Description:</p>
 * <p>Company: 上海理想信息产业(集团)有限公司</p>
 * @author dinghui
 * create date: 2011-6-17
 * @version 1.0
 */
public abstract  class BaseModel implements Serializable{
	/**
	 * 
	 */
	protected  static final long serialVersionUID = 1L;
	protected Integer startRow;//当前页面开始行
	protected Integer pageSize=15;//每页显示多少条
	protected Integer pageNum=1;//当前页
	protected long rowCount=-1;//总记录数
	protected String  orderFieldName;//要排序的字段名
	protected String  orderByRule;//排序规则
	protected String letterIndex;//字母索引
	protected String soleId;//唯一标识（用于所有自动增长序列）
	protected Integer id;//唯一标识（用于所有自动增长序列）
	protected String beginTime;//开始时间
	protected String endTime;//结束时间
	protected String createTime;//创建时间
	protected String beginTime2;//开始时间
	protected String endTime2;//结束时间
	protected String tableName;//表名
	protected int beginRecord=0;//导出excel开始记录
	protected int endRecord=30000;//导出excel结束记录（二者最大差为2000）
	protected java.util.List<File> uploads;
	protected java.util.List<String> uploadsFileName;
	protected java.util.List<String> uploadsContentType;

	public String getBeginTime2() {
		return beginTime2;
	}
	public void setBeginTime2(String beginTime2) {
		this.beginTime2 = beginTime2;
	}
	public String getEndTime2() {
		return endTime2;
	}
	public void setEndTime2(String endTime2) {
		this.endTime2 = endTime2;
	}
	public java.util.List<File> getUploads() {
		return uploads;
	}
	public void setUploads(java.util.List<File> uploads) {
		this.uploads = uploads;
	}
	public java.util.List<String> getUploadsFileName() {
		return uploadsFileName;
	}
	public void setUploadsFileName(java.util.List<String> uploadsFileName) {
		this.uploadsFileName = uploadsFileName;
	}
	public java.util.List<String> getUploadsContentType() {
		return uploadsContentType;
	}
	public void setUploadsContentType(java.util.List<String> uploadsContentType) {
		this.uploadsContentType = uploadsContentType;
	}
	public int getBeginRecord() {
		return beginRecord;
	}
	public void setBeginRecord(int beginRecord) {
		this.beginRecord = beginRecord;
	}
	public int getEndRecord() {
		return endRecord;
	}
	public void setEndRecord(int endRecord) {
		this.endRecord = endRecord;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLetterIndex() {
		return letterIndex;
	}
	public void setLetterIndex(String letterIndex) {
		this.letterIndex = letterIndex;
	}
	public String getOrderByRule() {
		return orderByRule;
	}
	public void setOrderByRule(String orderByRule) {
		this.orderByRule = orderByRule;
	}

	public String getOrderFieldName() {
		return orderFieldName;
	}
	public void setOrderFieldName(String orderFieldName) {
		this.orderFieldName = orderFieldName;
	}
	public String getSoleId() {
		return soleId;
	}
	public void setSoleId(String soleId) {
		this.soleId = soleId;
	}
	public Integer getStartRow() {
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	
    public long getRowCount() {
        return rowCount;
    }
    public void setRowCount(long rowCount) {
        this.rowCount = rowCount;
    }
    /**
	 * 过滤空格
	 * @param o 要过滤的对象
	 * @return 返回过滤后的结果
	 */
	public String filter(Object o) {
		if (o == null)
			return "";
		if ("null".equals(o))
			return "";
		return o.toString().trim();
	}
}
