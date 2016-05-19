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
import com.test.java.dto.User;
import com.test.java.mongo.base.BaseService;
@Service
public class GridFsService {
	@Autowired
	private GridFsTemplate gridFsTemplate;
	@Autowired
	private BaseService baseServiceImpl;
	
	public GridFSFile uploadFile(File file,String user) throws Exception{
		FileInputStream fis = new FileInputStream(file);
		return uploadFile(fis,user,file.getName());
	}
	public GridFSFile uploadFile(InputStream inputStream,String user,String fileName) throws Exception{
		GridFSFile uploadFile = null;
		/**
		 * 上传文件计算文件的md5值，如果文件值存在则
		 */
		String md5 = DigestUtils.md5Hex(IOUtils.toByteArray(inputStream));
		List<GridFSDBFile> fileList = findFile(new Query(Criteria.where("md5").is(md5)));
		if(fileList!=null&&fileList.size()>0){
			uploadFile=fileList.get(0);
		}else{
			uploadFile = gridFsTemplate.store(inputStream, fileName);
		}
		baseServiceImpl.insert(getMetaDataUser(uploadFile,user));
		return uploadFile;
	}
	public List<GridFSDBFile> findFile(Query query){
		return gridFsTemplate.find(query);
	}
	public InputStream down(Query query){
		GridFSDBFile file = gridFsTemplate.findOne(query);
		return file.getInputStream();
	}
	private User getMetaDataUser(GridFSFile file,String user){
		User fileUser = new User();
		fileUser.setMd5(file.get("md5").toString());
		fileUser.setFileId(file.get("_id").toString());
		fileUser.setUsernId(user);
		baseServiceImpl.insert(fileUser);
		return fileUser;
	}
}
