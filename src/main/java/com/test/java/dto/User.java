package com.test.java.dto;

public class User{
	private String id;
	private String fileId;
	private String fileName;
	private String md5;
	private String usernId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getMd5() {
		return md5;
	}
	public void setMd5(String md5) {
		this.md5 = md5;
	}
	public String getUsernId() {
		return usernId;
	}
	public void setUsernId(String usernId) {
		this.usernId = usernId;
	}
}
