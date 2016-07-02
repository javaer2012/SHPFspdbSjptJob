package com.ideal.spdb.utils;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

/**
 * 
 * <p>Title:  浦发五星项目</p>
 * <p>Description:Service基类实现类封装CRUD方法</p>
 * <p>Company: 上海理想信息产业(集团)有限公司</p>
 * @author dinghui
 * create date: 2011-6-17
 * @version 1.0
 */
@Service("baseService")
public  class BaseServiceImpl<T extends BaseModel>implements BaseService<T>{
	
	@Inject BaseDao<T> baseDao;

	/**
	 * 增加
	 * @param classMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
	 * @param entity 封装数据的实体
	 * @return 返回操作结果
	 * @throws Exception 抛出所有异常
	 */
	public boolean add(String classMethod, T entity) throws Exception {
		
		return baseDao.add(classMethod, entity);
	}
    
	/**
	 * 修改
	 * @param classMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
	 * @param entity 封装数据的实体
	 * @return 返回操作结果
	 * @throws Exception 抛出所有异常
	 */
	public boolean edit(String classMethod, T entity) throws Exception {
		return baseDao.edit(classMethod, entity);
	}

	/**
	 * 删除
	 * @param classMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
	 * @param entity 封装数据的实体
	 * @return 返回操作结果
	 * @throws Exception 抛出所有异常
	 */
	public boolean remvoe(String classMethod, T entity) throws Exception {
		return baseDao.remvoe(classMethod, entity);
	}
	
	/**
	 * 批量删除
	 * @param classMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
	 * @param list 要删除的数据集合
	 * @return 返回操作结果
	 * @throws Exception 抛出所有异常
	 */
	public boolean batchDelete(String classMethod,List<String>list) throws Exception{
		return baseDao.batchDelete(classMethod, list);
	}
	
	/**
	 * 批量增加
	 * @param classMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
	 * @param list 要增加的数据集合
	 * @return 返回操作结果
	 * @throws Exception 抛出所有异常
	 */
	public boolean batchAdd(String classMethod,List<T>list) throws Exception{
		return baseDao.batchAdd(classMethod, list);
	}

	/**
	 * 以id为条件查找对象
	 * @param classMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
	 * @param entity 封装数据的实体
	 * @return 返回查询结果
	 * @throws Exception 抛出所有异常
	 */
	public T get(String classMethod, T entity) throws Exception {
		return baseDao.get(classMethod, entity);
	}

	/**
	 * 查询
	 * @param classMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
	 * @param entity 封装数据的实体
	 * @return 返回查询结果
	 * @throws Exception 抛出所有异常
	 */
	public List<T> getAllList(String classMethod, T entity) throws Exception {
		return baseDao.getAllList(classMethod, entity);
	}

	/**
	 * 查询数量
	 * @param classMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
	 * @param entity 封装数据的实体
	 * @return 返回查询结果
	 * @throws Exception 抛出所有异常
	 */
	public int getCount(String classMethod, T entity) throws Exception {
		return baseDao.getCount(classMethod, entity);
	}	
	
	
	 /** 分页查询
	 * @param queryClassMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
	 * @param countClassMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
	 * @param entity 封装数据的实体
	 * @return 返回查询结果
	 * @throws Exception 抛出所有异常
	 */
	public Pagenation queryPage(String queryClassMethod,String countClassMethod,T entity) throws Exception{
		int count=baseDao.getCount(countClassMethod, entity);
		Pagenation pagenation=new Pagenation(Constants.PAGE_SIZE,entity.getPageNum().intValue(),count);
		entity.setStartRow(pagenation.getStartRow());
		pagenation.setList(baseDao.getAllList(queryClassMethod, entity));
		return pagenation;
	}
	
    /** 动态分页查询(主要针对检件处理的时候使用快捷键来翻页,由于处理过程中通过、退回销售等操作会改变分页的原始数据,因此为了解决这个问题,特重写了此方法)
     * @param queryClassMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
     * @param countClassMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
     * @param entity 封装数据的实体
     * @return 返回查询结果
     * @throws Exception 抛出所有异常
     */
    public Pagenation queryDynamicPage(String queryClassMethod,String countClassMethod,T entity) throws Exception{
        int count=baseDao.getCount(countClassMethod, entity);
        long rowCount=entity.getRowCount();
        if(rowCount!=-1&&rowCount!=count&&entity.getPageNum()!=0){
            //当记录数发生改变时,说明原始分页数据已经改变
            entity.setPageNum(entity.getPageNum().intValue()-1);
        }
        Pagenation pagenation=new Pagenation(entity.getPageSize(),entity.getPageNum().intValue(),count);
        entity.setStartRow(pagenation.getStartRow());
        pagenation.setList(baseDao.getAllList(queryClassMethod, entity));
        return pagenation;
    }
}
