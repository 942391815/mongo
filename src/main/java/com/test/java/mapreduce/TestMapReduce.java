package com.test.java.mapreduce;

import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.BasicDBObject;
import com.mongodb.CommandResult;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MapReduceCommand;
import com.mongodb.MapReduceOutput;
public class TestMapReduce {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MongoTemplate mongoTemplate = (MongoTemplate)context.getBean("mongoTemplate");
//		mongoTemplate.
		String mapFunction = "function(){"+
		"emit(this.name,1);"+
		"}";
		String reduceFunction="function(key,values){"+
		"var cnt=0;"+   
		"values.forEach(function(val){"+ 
		    "cnt = cnt+val;"+
		"});"+
		"return cnt;"+
	"}";
//		MapReduceOutput mapReduce = mongoTemplate.getCollection("user").mapReduce(mapFunction, reduceFunction, "result", null);
//		mapReduce.getCommand();
		
//		var cc = {
//			    "mapreduce": "templateApproval",
//			    "map": " function(){emit(this.tenantId,1);}",
//			    "reduce": "function(key,values){var cnt=0;values.forEach(function(val){cnt = cnt+val;});return cnt;}",
//			    "out":"result"
//			}
		
		DBCollection coll = mongoTemplate.getCollection("user");
		MapReduceCommand mapcmd = new MapReduceCommand(coll, mapFunction, reduceFunction,
				"result", MapReduceCommand.OutputType.REPLACE, null);
		MapReduceOutput cars = coll.mapReduce(mapcmd);
		for (DBObject o : cars.results()) {
			System.out.println(o.toString());
		}
	}
}
