package com.test.java.gridfs;

import java.io.File;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import com.mongodb.gridfs.GridFSDBFile;

public class TestGridfs {
	public static void main(String[] args) throws Exception{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		GridFsService gridFsService = (GridFsService)context.getBean("gridFsService");
		gridFsService.uploadFile(new File("D:\\张海月修改.rar"), "zhangsan");
		List<GridFSDBFile> findFileList = gridFsService.findFile(new Query(Criteria.where("metadata.user").is("alex")));
		for(int i=0;i<findFileList.size();i++){
			GridFSDBFile each = findFileList.get(i);
			System.out.println(each.get("metadata"));
		}
	}
}
