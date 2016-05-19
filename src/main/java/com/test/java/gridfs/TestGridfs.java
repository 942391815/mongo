package com.test.java.gridfs;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mongodb.gridfs.GridFSDBFile;

public class TestGridfs {
	public static void main(String[] args) throws Exception{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		GridFsService gridFsService = (GridFsService)context.getBean("gridFsService");
		File file = new File("D:\\PageOffice_3.0.0.6_JAVA .rar");
		Map<String,String> metaData = new HashMap<String,String>();
		metaData.put("user", "micheal");
		long timeBegin = System.currentTimeMillis();
//		gridFsService.uploadFile(file, metaData);
		long end = System.currentTimeMillis();
		System.out.println(end-timeBegin);
		List<GridFSDBFile> findFileList = gridFsService.findFile(null);
//		InputStream down = gridFsService.down(new Query(Criteria.where("md5").is("fc936ee62985ee1130bc5096af394276")));
//		FileOutputStream fos = new FileOutputStream(new File("d:\\1"));
//		byte [] size = new byte[1024];
//		int off = 0;
//		long timeBegin = System.currentTimeMillis();
//		while((off = down.read(size))!=-1){
//			fos.write(size, 0, off);
//		}
//		down.close();
//		fos.close();
//		long end = System.currentTimeMillis();
//		System.out.println(end-timeBegin);
	}
}
