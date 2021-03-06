package com.xunheyun.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.xunheyun.service.IProjectService;
import com.xunheyun.vo.Project;
import com.xunheyun.vo.UserForm;

@RequestMapping(value="/project")
@Controller
public class ProjectController {

	@Autowired
	private IProjectService projectService;
	
	@RequestMapping(value="/list")
	public String projectList(HttpServletRequest request,HttpServletResponse response){
		
		UserForm user = (UserForm) request.getSession().getAttribute("user");
		List<Project> list = projectService.list(user.getUser_id());
		
		request.setAttribute("projects", list);
		
		Map<String,?> map = RequestContextUtils.getInputFlashMap(request);
		if (map != null) {
			request.setAttribute("fail", map.get("fail"));
		}else{
			request.setAttribute("fail", "");
		}
		
		return "project_list";
	}
	
	@RequestMapping(value="/deploy_list")
	public String deployprojectList(HttpServletRequest request,HttpServletResponse response){
		
		UserForm user = (UserForm) request.getSession().getAttribute("user");
		List<Project> list = projectService.list(user.getUser_id());
		
		request.setAttribute("projects", list);
		
		Map<String,?> map = RequestContextUtils.getInputFlashMap(request);
		if (map != null) {
			request.setAttribute("fail", map.get("fail"));
		}else{
			request.setAttribute("fail", "");
		}
		
		return "deploy_project_list";
	}
	
	@RequestMapping(value="/addpage")
	public String projectAddPage(HttpServletRequest request){
		
		request.setAttribute("fail", "");
		return "project_add";
	}
	
	@RequestMapping(value="/add")
	public String projectAdd(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("form") Project project){
		
		UserForm user = (UserForm) request.getSession().getAttribute("user");
		project.setUser_id(user.getUser_id());
		
		String result = projectService.addProject(project);
		
		if (result.equals("success")) {
			return "redirect:/project/list";
		}else{
			
			request.setAttribute("fail", result);
			return "project_add";
		}
	}
	
	@RequestMapping(value="/delete")
	public String projectDelete(HttpServletRequest request,RedirectAttributes redirectAttributes){
		
		int project_id = Integer.valueOf(request.getParameter("project_id"));
		
		String result = projectService.deleteProject(project_id);
		
		redirectAttributes.addFlashAttribute("fail", result);
		
		return "redirect:/project/list";
	}
	
	@RequestMapping(value="/editpage")
	public String projectEditPage(HttpServletRequest request){
		
		int project_id = Integer.valueOf(request.getParameter("project_id"));
		
		Project project = projectService.getProject(project_id);
		
		request.setAttribute("project", project);
		
		return "project_edit";
	}
	
	@RequestMapping(value="/edit")
	public String projectEdit(HttpServletRequest request,@ModelAttribute("form") Project project){
		
		projectService.updateProject(project);
		
		List<Project> list = projectService.list(0);
		request.setAttribute("projects", list);
		
		return "redirect:/project/list";
	}
	
}

