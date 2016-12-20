/**
 * 用户登录操作
 */
package com.xunheyun.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xunheyun.service.IUserService;
import com.xunheyun.vo.UserForm;

/**
 * @author HAITAO
 */
@Controller
@RequestMapping(value="/login")
public class LoginController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/page")
	public String page(){
		return "login";
	}
	
	@RequestMapping(value="/index")
	public String index(){
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
		
		UserForm userForm = userService.login(user.getUser_name(),user.getPass_word());
		
		if (userForm == null) {
			return "redirect:/login/page";
		}
		request.getSession().setAttribute("user", userForm);
		
		request.setAttribute("user", userForm);
		
		return "home";
	}
}

