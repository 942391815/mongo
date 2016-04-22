package com.test.java.mongo.base;


import java.util.List;

import org.springframework.stereotype.Service;


@Service
public interface BaseService<T> {
	public List<T> findByCondtion(T ob);
}
