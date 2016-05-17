package com.test.java.gridfs;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;

@Service
public class GridFsService {
	@Autowired
	private GridFsTemplate gridFsTemplate;
	public GridFSFile uploadFile(File file,Map metaData) throws Exception{
		FileInputStream fos = new FileInputStream(file);
		DBObject obj = new BasicDBObject();
		obj.putAll(metaData);
		return gridFsTemplate.store(fos,metaData);
	}
	public GridFSFile uploadFile(InputStream inputStream,Map metaData) throws Exception{
		DBObject obj = new BasicDBObject();
		obj.putAll(metaData);
		return gridFsTemplate.store(inputStream,metaData);
	}
	public List<GridFSDBFile> findFile(Query query){
		return gridFsTemplate.find(query);
	}
}
