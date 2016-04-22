package com.test.java.mongo.base;


import java.util.List;

public interface BaseService<T> {
	
	public List<T> findByCondtion(T obj);
	
	public T findByPk(String id,Class<T> obj);
	
	public void deleteByPk(String id,Class<T> obj);
	
	public int getCount(T obj);
	
	public void insert(T obj);
	
	public void updateByPk(T obj);
}
