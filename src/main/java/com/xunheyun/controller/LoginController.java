/**
 * 
 */
package com.xunheyun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping(value="/login")
	public String login(){
		return "login";
	}
}
