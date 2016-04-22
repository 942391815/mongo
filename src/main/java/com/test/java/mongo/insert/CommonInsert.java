package com.test.java.mongo.insert;


import org.springframework.data.mongodb.core.MongoTemplate;


public class CommonInsert {
	private MongoTemplate template;
	
	public void insertObj(Object object,String tableName){
		template.insert(object,tableName);
	}
	public void insertObj(Object object){
		template.insert(object);
	}
}
