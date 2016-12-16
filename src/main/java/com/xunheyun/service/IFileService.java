package com.xunheyun.service;

import java.util.List;

import com.xunheyun.vo.File;

public interface IFileService {

	public List<File> list(int project_id);
	
	public int insertFile(File file);
}
