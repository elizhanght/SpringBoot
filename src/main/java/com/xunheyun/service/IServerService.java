package com.xunheyun.service;

import java.util.List;

import com.xunheyun.vo.Result;
import com.xunheyun.vo.Server;

public interface IServerService {

	public List<Server> list(int project_id);
	
	public int insertServer(Server server);
	
	public int updateServer(Server server);
	
	public int deleteServer(int server_id);
	
	public Result startServer(int server_id);
	
	public Result stopServer(int server_id);
	
	public Result deployWar(int server_id,int war_id);
	
	public void logServer(int server_id);
	
}
