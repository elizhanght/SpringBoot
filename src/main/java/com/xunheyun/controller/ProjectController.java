package com.xunheyun.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xunheyun.service.IProjectService;
import com.xunheyun.vo.Project;
import com.xunheyun.vo.UserForm;

@RequestMapping(value="/project")
@Controller
public class ProjectController {

	@Autowired
	private IProjectService projectService;
	
	@RequestMapping(value="/list")
	public String projectList(HttpServletRequest request){
		
//		int userId = Integer.valueOf(request.getParameter("userId"));
		
		List<Project> list = projectService.list(0);
		
		request.setAttribute("projects", list);
		
		return "project_list";
	}
	
	@RequestMapping(value="/addpage")
	public String projectAddPage(HttpServletRequest request){
		return "form-common";
	}
	
	@RequestMapping(value="/add")
	public String projectAdd(HttpServletRequest request,@ModelAttribute("form") Project project){
		
		projectService.addProject(project);
		
		return "/login/home";
	}
	
	@RequestMapping(value="/delete")
	public String projectDelete(HttpServletRequest request){
		
		return "tables";
	}
	
	@RequestMapping(value="/edit")
	public String projectEdit(HttpServletRequest request){
		
		return "tables";
	}
}
