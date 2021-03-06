package com.xunheyun.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xunheyun.mapper.FileMapper;
import com.xunheyun.mapper.PropertyMapper;
import com.xunheyun.service.IFileService;
import com.xunheyun.vo.File;

@Service
public class FileServiceImpl implements IFileService {

	@Autowired
	private FileMapper fileMapper;
	
	@Autowired
	private PropertyMapper propertyMapper;
	
	@Override
	public List<File> list(int project_id) {
		
		List<File> list = fileMapper.list(project_id);
		
		return list;
	}

	@Override
	public int insertFile(File file) {
		
		file.setTimestamp(new Timestamp(System.currentTimeMillis()));
		fileMapper.insertFile(file);
		
		return 0;
	}

	@Override
	@Transactional
	public int deleteFile(int file_id) {
		
		// 先删除文件下面的属性值
		propertyMapper.deleteByFileId(file_id);
		
		// 再删除文件
		fileMapper.deleteFile(file_id);
		
		return 0;
	}

	@Override
	public File getFileById(int file_id) {
		
		File file = fileMapper.getFileById(file_id);
		
		return file;
	}

	@Override
	public int updateFile(File file) {
		
		fileMapper.updateFile(file);
		
		return 0;
	}

}

