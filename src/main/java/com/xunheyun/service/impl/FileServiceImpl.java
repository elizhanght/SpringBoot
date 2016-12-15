package com.xunheyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xunheyun.mapper.FileMapper;
import com.xunheyun.service.IFileService;
import com.xunheyun.vo.File;

@Service
public class FileServiceImpl implements IFileService {

	@Autowired
	private FileMapper fileMapper;
	
	@Override
	public List<File> list(int project_id) {
		
		List<File> list = fileMapper.list(project_id);
		
		return list;
	}

	@Override
	public int insertFile(File file) {
		
		fileMapper.insertFile(file);
		return 0;
	}

}
