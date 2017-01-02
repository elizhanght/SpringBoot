package com.xunheyun.service;

import java.util.List;

import com.xunheyun.vo.War;

public interface IWarService {

	public void saveUploadFile(War war);
	
	public int deleteFileUploadFile(int fileId);
	
	public List<War> list(int project_id);
	
}
