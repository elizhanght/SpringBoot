package com.xunheyun.vo;

import java.sql.Timestamp;

public class War {

	private int war_id;
	private String file_name;
	private Timestamp timestamp;
	private int project_id;
	
	public int getWar_id() {
		return war_id;
	}
	public void setWar_id(int war_id) {
		this.war_id = war_id;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	
	
	
}
