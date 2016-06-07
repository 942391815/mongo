package com.test.java.mongo.base;


import java.util.List;
import java.util.Map;

public interface BaseService<T> {
	
	public List<T> findByCondtion(T obj);
	/**
	 * 对于某一个null值查询的补充
	 * 如endType:null
	 * @param param
	 * @param clazz
	 * @return
	 */
	public List<T> findByCondtionByMap(Map<String,Object> param,Class<T> clazz);
	
	public List<T> findByCondtion(T obj,int start,int offsite,String sortColumns);
	
	public T findByPk(String id,Class<T> obj);
	
	public void deleteByPk(String id,Class<T> obj);
	
	public int getCount(T obj);
	
	public void insert(T obj);
	
	public void updateByPk(T obj);
}
