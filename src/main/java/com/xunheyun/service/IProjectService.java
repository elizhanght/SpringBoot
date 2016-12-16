/**
 * 
 */
package com.xunheyun.service;

import java.util.List;

import com.xunheyun.vo.Project;

/**
 * @author eli.zhang
 */
public interface IProjectService {

	public List<Project> list(int user_id);
	public String addProject(Project project);
	public int deleteProject(int project_id);
	public Project getProject(int project_id);
	public int updateProject(Project project);
}
