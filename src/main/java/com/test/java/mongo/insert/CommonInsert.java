package com.test.java.mongo.insert;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import com.test.java.dto.Person;

public class CommonInsert {
//	private MongoTemplate template;
	public static void main(String args[]){
//		insertPerson();
		insertPerson1();
	}
	/**
	 * 如果id相同不插入数据
	 */
	public static void insertPerson(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MongoTemplate template = (MongoTemplate)context.getBean("mongoTemplate");
		Person person = new Person();
		person.setId("testswetsetset");
		person.setAge("1sdfsdf7");
		person.setName("zhaolisdfsdfu");
		String hobby[] = {"test1sdf","test2","test3"};
		person.setHobby(hobby);
		template.insert(person);
	}
	public static void insertPerson1(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcTemplate jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
		List<Map<String, Object>> templateList = jdbcTemplate.queryForList("select * from template_approval_record");
		
		MongoTemplate template = (MongoTemplate)context.getBean("mongoTemplate");
		for(Map each:templateList){
			template.insert(each, "template_approval_record");
		}
	}
}
