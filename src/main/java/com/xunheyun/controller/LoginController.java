/**
 * 用户登录操作
 */
package com.xunheyun.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xunheyun.service.IFileService;
import com.xunheyun.service.IProjectService;
import com.xunheyun.service.IUserService;
import com.xunheyun.vo.File;
import com.xunheyun.vo.Project;
import com.xunheyun.vo.UserForm;

/**
 * @author HAITAO
 */
@Controller
@RequestMapping(value="/login")
public class LoginController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IProjectService projectService;
	
	@Autowired
	private IFileService fileService;
	
	@RequestMapping(value="/page")
	public String page(){
		return "login";
	}
	
	@RequestMapping(value="/index")
	public String index(HttpServletRequest request){
		
		UserForm user = (UserForm) request.getSession().getAttribute("user");
		List<Project> list = projectService.list(user.getUser_id());
		
		List<File> fileList = new ArrayList<>();
		for (Project project : list) {
			List<File> list2 = fileService.list(project.getProject_id());
			fileList.addAll(list2);
		}
		request.setAttribute("files", fileList);
		request.setAttribute("projects", list);
		
		return "home";
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request){
		
		request.getSession().setAttribute("user",null);
		
		return "login";
	}
	
	@RequestMapping(value="/home")
	public String login(HttpServletRequest request, @ModelAttribute("form") UserForm user){
		
		if (user == null || user.getUser_name().equals("") || user.getPass_word().equals("")) {
			return "redirect:/login/page";
		}
		
		UserForm userForm = userService.login(user);
		
		if (userForm == null) {
			return "redirect:/login/page";
		}
		request.getSession().setAttribute("user", userForm);
		
		request.setAttribute("user", userForm);
		
		// 项目列表
		List<Project> list = projectService.list(userForm.getUser_id());
		request.setAttribute("projects", list);
		
		// 文件列表
		List<File> fileList = new ArrayList<>();
		for (Project project : list) {
			List<File> list2 = fileService.list(project.getProject_id());
			fileList.addAll(list2);
		}
		request.setAttribute("files", fileList);
		
		return "home";
	}
	@RequestMapping(value="/registerpage")
	public String registerpage(@ModelAttribute("form") UserForm user){
		
		return "register";
	}
	
	@RequestMapping(value="/register")
	public String register(@ModelAttribute("form") UserForm user){
		
		userService.register(user);
		
		if (user.getUser_id() != 0) {
			return "redirect:/login/page";
		}
		return "redirect:/login/registerpage";
	}
}

