/**
 */
package com.xunheyun.vo;

import java.sql.Timestamp;

/**
 * @author eli.zhang
 */
public class File {

	private int file_id;
	private String file_name;
	private int project_id;
	private String file_desc;
	private Timestamp timestamp;
	private String project_name;
	
	
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public int getFile_id() {
		return file_id;
	}
	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}
	public String getFile_desc() {
		return file_desc;
	}
	public void setFile_desc(String file_desc) {
		this.file_desc = file_desc;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	
	
}

