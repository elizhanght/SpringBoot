package com.xunheyun.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xunheyun.mapper.FileMapper;
import com.xunheyun.mapper.ProjectMapper;
import com.xunheyun.mapper.PropertyMapper;
import com.xunheyun.service.IPropertyApiService;
import com.xunheyun.vo.File;
import com.xunheyun.vo.Project;
import com.xunheyun.vo.Property;

@Service
public class PropertyApiServiceImpl implements IPropertyApiService {

	@Autowired
	private ProjectMapper projectMapper;
	
	@Autowired
	private FileMapper fileMapper;
	
	@Autowired
	private PropertyMapper propertyMapper;
	
	@Override
	public List<Property> getPropertyByProjectAndFile(String project_name,String file_name) {
		
		// 根据项目名称获取项目ID
		Project project = projectMapper.getProjectByName(project_name);
		
		// 根据项目ID和文件名称获取文件ID
		File file = fileMapper.getFileByProjectIdAndFileName(project.getProject_id(), file_name);
		
		// 根据文件ID获取文件内的属性
		List<Property> list = propertyMapper.list(file.getFile_id());
		
		return list;
	}

	@Override
	public List<Property> getPropertyByProject(String project_name) {
		
		// 根据项目名称获取项目ID
		Project project = projectMapper.getProjectByName(project_name);
				
		List<File> fileList = fileMapper.list(project.getProject_id());
		
		List<Property> propertyList = new ArrayList<>();
		
		for (File file : fileList) {
			
			List<Property> list = propertyMapper.list(file.getFile_id());
			
			propertyList.addAll(list);
		}
		
		return propertyList;
	}

}
