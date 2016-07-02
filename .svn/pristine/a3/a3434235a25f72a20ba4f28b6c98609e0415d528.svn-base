package com.ideal.spdb.utils;

import java.util.List;
/**
 * 
 * <p>Title:  浦发五星项目技术平台</p>
 * <p>Description:Service基类接口封装CRUD方法</p>
 * <p>Company:上海理想信息产业(集团)有限公司</p>
 * @author dinghui
 * create date: 2011-6-17
 * @version 1.0
 */
public interface BaseService<T> {
    /**
     * 增加
     * @param classMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
     * @param entity 封装数据的实体
     * @return 返回操作结果
     * @throws Exception 抛出所有异常
     */
    public boolean add(String classMethod,T entity) throws Exception;
    
    /**
     * 修改
     * @param classMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
     * @param entity 封装数据的实体
     * @return 返回操作结果
     * @throws Exception 抛出所有异常
     */
    public boolean edit(String classMethod,T entity) throws Exception;

    /**
     * 删除
     * @param classMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
     * @param entity 封装数据的实体
     * @return 返回操作结果
     * @throws Exception 抛出所有异常
     */
    public boolean remvoe(String classMethod,T entity) throws Exception;
    
    /**
     * 批量删除
     * @param classMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
     * @param list 要删除的数据集合
     * @return 返回操作结果
     * @throws Exception
     */
    public boolean batchDelete(String classMethod,List<String>list) throws Exception;
    
    /**
     * 批量增加
     * @param classMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
     * @param list 要增加的数据集合
     * @return 返回操作结果
     * @throws Exception
     */
    public boolean batchAdd(String classMethod,List<T>list) throws Exception;

    /**
     * 以id为条件查找对象
     * @param classMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
     * @param entity 封装数据的实体
     * @return 返回查询结果
     * @throws Exception 抛出所有异常
     */
    public T get(String classMethod,T entity) throws Exception;
    /**
     * 查询
     * @param classMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
     * @param entity 封装数据的实体
     * @return 返回查询结果
     * @throws Exception 抛出所有异常
     */
    public List<T> getAllList(String classMethod,T entity) throws Exception;
    /**
     * 查询数量
     * @param queryClassMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
     * @param countClassMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
     * @param entity 封装数据的实体
     * @return 返回查询结果
     * @throws Exception 抛出所有异常
     */
    public int getCount(String classMethod,T entity) throws Exception;
    
     /** 分页查询
     * @param queryClassMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
     * @param countClassMethod mybatis配置文件里面对应的命名空间+要执行的sql语句id
     * @param entity 封装数据的实体
     * @return 返回查询结果
     * @throws Exception 抛出所有异常
     */
    public Pagenation queryPage(String queryClassMethod,String countClassMethod,T entity) throws Exception;
    
    /**
     * 动态分页查询
     * @param queryClassMethod
     * @param countClassMethod
     * @param entity
     * @return
     * @throws Exception
     */
    public Pagenation queryDynamicPage(String queryClassMethod,String countClassMethod,T entity) throws Exception;
}
