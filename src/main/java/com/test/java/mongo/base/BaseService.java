package com.test.java.mongo.base;


import java.util.List;

public interface BaseService<T> {
	
	public List<T> findByCondtion(T obj);
	
	public List<T> findByCondtion(T obj,int start,int offsite,String sortColumns);
	
	public T findByPk(String id,Class<T> obj);
	
	public void deleteByPk(String id,Class<T> obj);
	
	public int getCount(T obj);
	
	public void insert(T obj);
	
	public void updateByPk(T obj);
}
