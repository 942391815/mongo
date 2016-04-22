package com.test.java.mongo.base;


import java.util.List;

public interface BaseService<T> {
	
	public List<T> findByCondtion(T ob);
	
	public T findByPk(String id,Class<T> obj);
	
	
}
