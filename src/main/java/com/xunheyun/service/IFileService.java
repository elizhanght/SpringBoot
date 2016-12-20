package com.xunheyun.service;

import java.util.List;

import com.xunheyun.vo.File;

public interface IFileService {

	public List<File> list(int project_id);
	
	public int insertFile(File file);
	
	public int deleteFile(int file_id);
	
	public File getFileById(int file_id);
	
	public int updateFile(File file);
	
}
