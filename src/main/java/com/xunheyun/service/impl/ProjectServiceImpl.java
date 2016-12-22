package com.xunheyun.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xunheyun.mapper.ProjectMapper;
import com.xunheyun.service.IProjectService;
import com.xunheyun.vo.File;
import com.xunheyun.vo.Project;

@Service
public class ProjectServiceImpl implements IProjectService {

	@Autowired
	private ProjectMapper projectMapper;
	
	@Override
	public String addProject(Project project) {
		
		Project oldProject = projectMapper.getProjectByName(project.getProject_name());
		
		if (oldProject != null) {
			return "The project already exists!";
		}else{
			project.setTimestamp(new Timestamp(System.currentTimeMillis()));
			projectMapper.insertProject(project);
		}
		
		return "success";
	}

	@Override
	public List<Project> list(int user_id) {
		
		List<Project> list = projectMapper.list(user_id);
		
		return list;
	}

	@Override
	public int deleteProject(int project_id) {
		
		// 删除项目时验证项目下是否有配置文件
		List<File> fileList = projectMapper.getFileByProjectId(project_id);
		
		if (fileList == null || fileList.isEmpty()) {
			projectMapper.deleteProject(project_id);
		}
		
		return 0;
	}

	@Override
	public Project getProject(int project_id) {
		
		Project project = projectMapper.getProject(project_id);
		
		return project;
	}

	@Override
	public int updateProject(Project project) {
		projectMapper.updateProject(project);
		return 0;
	}

}

