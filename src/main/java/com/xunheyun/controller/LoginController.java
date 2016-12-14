/**
 * 用户登录操作
 */
package com.xunheyun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xunheyun.UserForm;

/**
 * @author HAITAO
 */
@Controller
@RequestMapping(value="/login")
public class LoginController {


	@RequestMapping(value="/page")
	public String page(){
		return "login";
	}
	
	@RequestMapping(value="/home")
	public String login(@ModelAttribute("form") UserForm user){
		return "home";
	}
}
