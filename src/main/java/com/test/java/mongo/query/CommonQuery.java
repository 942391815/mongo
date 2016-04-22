package com.test.java.mongo.query;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.test.java.dto.TemplateApproval;
import com.test.java.utils.Tools;

public class CommonQuery {
	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		MongoTemplate template = (MongoTemplate)context.getBean("mongoTemplate");
//		Query query = new Query(Criteria.where("CUSTOM_NAME").regex("招标"));
//		List<Map> resultList = template.find(query, Map.class, "template_approval");
//		for(Map each:resultList){
//			System.out.println(each);
//		}
		TemplateApproval dto = new TemplateApproval();
		dto.setCustomName("1929");
		findByCondtion(dto);
	}
	public static void findByCondtion(Object ob){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MongoTemplate template = (MongoTemplate)context.getBean("mongoTemplate");

		Map<String,Object> map = new HashMap<String,Object>();
		Class clazz = ob.getClass();
		Method[] declaredMethods = clazz.getDeclaredMethods();
		for(Method each:declaredMethods){
			if(each.getName().startsWith("get")){
				String fieldName = Tools.converFirstCharToLower(each.getName().substring(3));
				try {
					map.put(fieldName, each.invoke(ob, null));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		Iterator<String> iterator = map.keySet().iterator();
		int i=0;
		Criteria criteria = null;
		while(iterator.hasNext()){
			String key = iterator.next();
			Object value = map.get(key);
			if(value!=null){
				if(i>0){
					criteria.and(key).is(value);
				}else{
						criteria = Criteria.where(key).is(value);
				}
				i++;
			}
		}
		List<? extends Object> find = template.find(new Query(criteria), ob.getClass());
		for(Object each:find){
			System.out.println(each);
		}
	}
}
