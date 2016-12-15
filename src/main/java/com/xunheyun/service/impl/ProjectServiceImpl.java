package com.xunheyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xunheyun.mapper.ProjectMapper;
import com.xunheyun.service.IProjectService;
import com.xunheyun.vo.Project;

@Service
public class ProjectServiceImpl implements IProjectService {

	@Autowired
	private ProjectMapper projectMapper;
	
	@Override
	public String addProject(Project project) {
		
		projectMapper.insertProject(project);
		
		return null;
	}

	@Override
	public List<Project> list(int user_id) {
		
		List<Project> list = projectMapper.list(user_id);
		
		return list;
	}

}
