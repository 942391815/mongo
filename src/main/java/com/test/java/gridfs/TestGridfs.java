package com.test.java.gridfs;

import java.io.File;
import java.io.FileInputStream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.gridfs.GridFS;

public class TestGridfs {
	public static void main(String[] args) throws Exception{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		GridFsTemplate gridFsTemplate = (GridFsTemplate)context.getBean("gridFsTemplate");
		FileInputStream fos = new FileInputStream(new File("d:\\12.pdf"));
		DBObject metaData = new BasicDBObject();
		metaData.put("user", "alex");
		gridFsTemplate.store(fos,metaData);
	}
}
