/**
 * 用户登录操作
 */
package com.xunheyun.controller;

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
	
	@RequestMapping(value="/home")
	public String login(@ModelAttribute("form") UserForm user){
		
		userService.login(user.getUser_name(),user.getPass_word());
		
		return "home";
	}
}
