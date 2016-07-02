package com.ideal.spdb.utils;

import java.util.List;


import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * Dao基类实现类封装CRUD方法
 * <p>Title:  浦发五星项目</p>
 * <p>Description:</p>
 * <p>Company: 上海理想信息产业(集团)有限公司</p>
 * @author dinghui
 * create date : 2011-6-17
 * @version 1.0
 */
@Repository("baseDao")
public  class BaseDaoImpl<T extends Object> extends SqlSessionDaoSupport implements BaseDao<T> {
	protected  Logger log=Logger.getLogger(BaseDaoImpl.class);
	
	/**
	 * 增加
	 * @param classMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
	 * @param entity 封装数据的实体
	 * @return 返回操作结果
	 * @throws Exception 抛出所有异常
	 */
	public boolean add(String classMethod, T entity) throws Exception {
		log.info("dao add!");
		
		boolean flag = false;
		try {
			flag =this.getSqlSession().insert(classMethod, entity) > 0 ? true : false;
		} catch (Exception e) {
			flag = false;
			log.error("dao add:",e);
			throw e;
		}
		return flag;
	}

	/**
	 * 修改
	 * @param classMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
	 * @param entity 封装数据的实体
	 * @return 返回操作结果
	 * @throws Exception 抛出所有异常
	 */
	public boolean edit(String classMethod, T entity) throws Exception {
		log.info("dao edit!");
		boolean flag = false;
		try {
			flag = this.getSqlSession().update(classMethod, entity) > 0 ? true
					: false;
		} catch (Exception e) {
			flag = false;
			log.error("dao edit:",e);
			throw e;
		}
		return flag;
	}
	
	/**
	 * 以id为条件查找对象
	 * @param classMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
	 * @param entity 封装数据的实体
	 * @return 返回查询结果
	 * @throws Exception 抛出所有异常
	 */
	@SuppressWarnings("unchecked")
	public T get(String classMethod, T entity) throws Exception {
		log.info("dao get!");
		T result = null;
		try {
			result = (T) this.getSqlSession().selectOne(classMethod, entity);
		} catch (Exception e) {
			log.error("dao get:",e);
			throw e;
			
		}
		return result;
	}

	/**
	 * 删除
	 * @param classMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
	 * @param entity 封装数据的实体
	 * @return 返回操作结果
	 * @throws Exception 抛出所有异常
	 */
	public boolean remvoe(String classMethod, T entity) throws Exception {
		log.info("dao remvoe!");
		boolean flag = false;
		try {
			flag = this.getSqlSession().delete(classMethod, entity) > 0 ? true
					: false;
		} catch (Exception e) {
			flag = false;
			log.error("dao remvoe:",e);
			throw e;
		}
		return flag;
	}
	
	/**
	 * 批量删除
	 * @param classMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
	 * @param list 要删除的数据集合
	 * @return 返回操作结果
	 * @throws Exception 抛出所有异常
	 */
	public boolean batchDelete(String classMethod,List<String>list) throws Exception{
		log.info("dao batchDelete!");
		boolean flag = false;
		try {
			flag = this.getSqlSession().delete(classMethod,list) > 0 ? true
					: false;
		} catch (Exception e) {
			flag = false;
			log.error("dao batchDelete:",e);
			throw e;
		}
		return flag;
	}
	
	
	/**
	 * 批量增加
	 * @param classMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
	 * @param list 要增加的数据集合
	 * @return 返回操作结果
	 * @throws Exception  抛出所有异常
	 */
	public boolean batchAdd(String classMethod,List<T>list) throws Exception{
		log.info("dao batchAdd!");
		boolean flag = false;
		try {
			for (T t : list) {
				flag = this.getSqlSession().insert(classMethod,t) > 0 ? true
						: false;
			}
			
		} catch (Exception e) {
			flag = false;
			log.error("dao batchAdd:",e);
			throw e;
		}
		return flag;
	}

	/**
	 * 查询
	 * @param classMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
	 * @param entity 封装数据的实体
	 * @return 返回查询结果
	 * @throws Exception 抛出所有异常
	 */
	@SuppressWarnings("unchecked")
	public List<T> getAllList(String classMethod, T entity) throws Exception {
		log.info("dao getAllList!");
		List<T> result=null;
		try {
			result = this.getSqlSession().selectList(classMethod,entity);
		} catch (Exception e) {
			log.error("dao getAllList:",e);
			throw e;
		}
		return result;
	}
	
	/**
	 * 查询数量
	 * @param classMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
	 * @param entity 封装数据的实体
	 * @return 返回查询结果
	 * @throws Exception 抛出所有异常
	 */
	public int getCount(String classMethod, T entity) throws Exception {
		log.info("dao getCount!");
		int result = 0;
		try {
			result =(Integer) this.getSqlSession().selectOne(classMethod,entity);
		} catch (Exception e) {
			log.error("dao getCount:",e);
			throw e;
		}
		return result;
	}

}
