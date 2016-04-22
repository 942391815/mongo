package com.test.java.mongo.base;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.test.java.utils.Tools;

@Service
public class BaseServiceImpl<T> implements BaseService<T>{
	@Autowired
	private MongoTemplate template;
	
	@SuppressWarnings("unchecked")
	public List<T> findByCondtion(T ob) {
		Map<String, Object> map = new HashMap<String, Object>();
		Class clazz = ob.getClass();
		Method[] declaredMethods = clazz.getDeclaredMethods();
		for (Method each : declaredMethods) {
			if (each.getName().startsWith("get")) {
				String fieldName = Tools.converFirstCharToLower(each.getName().substring(3));
				try {
					map.put(fieldName, each.invoke(ob, null));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		Iterator<String> iterator = map.keySet().iterator();
		int i = 0;
		Criteria criteria = null;
		while (iterator.hasNext()) {
			String key = iterator.next();
			Object value = map.get(key);
			if (value != null) {
				if (i > 0) {
					criteria.and(key).is(value);
				} else {
					criteria = Criteria.where(key).is(value);
				}
				i++;
			}
		}
		return (List<T>) template.find(new Query(criteria), ob.getClass());
	}
	@SuppressWarnings("unchecked")
	@Override
	public T findByPk(String id, Class<T> obj) {
		return (T) template.find(new Query(Criteria.where("id").is(id)), obj);
	}
}
