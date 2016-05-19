package com.test.java.gridfs;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;
import com.test.java.utils.MD5Utils;

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
		String md5 = DigestUtils.md5Hex(IOUtils.toByteArray(inputStream));
		List<GridFSDBFile> result = gridFsTemplate.find(new Query(Criteria.where("md5").is(md5)));
//		if(result!=null){
//		}else{
			DBObject obj = new BasicDBObject();
			obj.putAll(metaData);
			return gridFsTemplate.store(inputStream,metaData);
//		}
	}
	public List<GridFSDBFile> findFile(Query query){
		return gridFsTemplate.find(query);
	}
	public InputStream down(Query query){
		GridFSDBFile file = gridFsTemplate.findOne(query);
		return file.getInputStream();
	} 
}
