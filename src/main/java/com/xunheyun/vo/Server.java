package com.xunheyun.vo;

public class Server {

	private int server_id;
	private String server_name;
	private String server_ip;
	private String server_user;
	private String server_pwd;
	private String server_desc;
	private int project_id;
	private String tomcat_dir;
	
	
	public int getServer_id() {
		return server_id;
	}
	public void setServer_id(int server_id) {
		this.server_id = server_id;
	}
	public String getServer_name() {
		return server_name;
	}
	public void setServer_name(String server_name) {
		this.server_name = server_name;
	}
	public String getServer_ip() {
		return server_ip;
	}
	public void setServer_ip(String server_ip) {
		this.server_ip = server_ip;
	}
	public String getServer_user() {
		return server_user;
	}
	public void setServer_user(String server_user) {
		this.server_user = server_user;
	}
	public String getServer_pwd() {
		return server_pwd;
	}
	public void setServer_pwd(String server_pwd) {
		this.server_pwd = server_pwd;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getServer_desc() {
		return server_desc;
	}
	public void setServer_desc(String server_desc) {
		this.server_desc = server_desc;
	}
	public String getTomcat_dir() {
		return tomcat_dir;
	}
	public void setTomcat_dir(String tomcat_dir) {
		this.tomcat_dir = tomcat_dir;
	}
	
	

}
