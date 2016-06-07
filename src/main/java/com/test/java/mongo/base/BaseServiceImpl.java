package com.test.java.mongo.base;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;

@Service
public class BaseServiceImpl<T> implements BaseService<T> {
	@Autowired
	private MongoTemplate template;

	@SuppressWarnings("unchecked")
	public List<T> findByCondtion(T obj) {
		Criteria criteria = getCriteria(obj);
		if (criteria != null) {
			return (List<T>) template.find(new Query(criteria), obj.getClass());
		}
		return (List<T>) template.findAll(obj.getClass());
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findByPk(String id, Class<T> obj) {
		if (StringUtils.isEmpty(id)) {
			throw new RuntimeException("id Can not be null!");
		}
		List<T> resultList = template.find(new Query(Criteria.where("_id").is(id)), obj);
		if (resultList != null && resultList.size() > 1) {
			throw new RuntimeException("pk can not duplicate !");
		}
		if (resultList.size() > 0) {
			return resultList.get(0);
		}
		return null;
	}

	@Override
	public void deleteByPk(String id, Class<T> obj) {
		template.remove(new Query(Criteria.where("_id").is(id)), obj);
	}

	@Override
	public int getCount(T obj) {
		return findByCondtion(obj).size();
	}

	@Override
	public void insert(T obj) {
		template.insert(obj);
	}

	@Override
	public void updateByPk(T obj) {
		Update update = new Update();
		Map<String, Object> map = objToMap(obj);
		if (StringUtils.isEmpty(map.get("id"))) {
			throw new RuntimeException("id can not be null ");
		}
		String id = map.get("id").toString();
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			Object value = map.get(key);
			if (value != null) {
				update.set(key, value);
			}
		}
		template.updateFirst(new Query(Criteria.where("_id").is(id)), update, obj.getClass());
	}

	@Override
	public List<T> findByCondtion(T obj, int start, int offsite,String sortColumns) {
		Query queryDto = null;
		Criteria criteria = getCriteria(obj);
		if (criteria != null) {
			queryDto = new Query(criteria);
		}else{
			queryDto = new Query();
		}
		queryDto.skip(start);
		queryDto.limit(offsite);
		if(!StringUtils.isEmpty(sortColumns)){
			Sort sort = new Sort(sortColumns);
			queryDto.with(sort);
		}
		return (List<T>) template.find(queryDto, obj.getClass());
	}

	private Criteria getCriteria(Object obj) {
		Map<String, Object> map = objToMap(obj);
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
		return criteria;
	}
	private Map<String,Object> objToMap(Object obj){
		return (Map<String, Object>) JSONObject.parseObject(JSONObject.toJSON(obj).toString(),
				Map.class);
	}

	@Override
	public List<T> findByCondtionByMap(Map<String, Object> param, Class<T> clazz) {
		Iterator<String> iterator = param.keySet().iterator();
		int i = 0;
		Criteria criteria = null;
		while (iterator.hasNext()) {
			String key = iterator.next();
			Object value = param.get(key);
				if (i > 0) {
					criteria.and(key).is(value);
				} else {
					criteria = Criteria.where(key).is(value);
				}
				i++;
		}
		if (criteria != null) {
			return (List<T>) template.find(new Query(criteria), clazz);
		}
		return (List<T>) template.findAll(clazz);
	}
}
