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
}
