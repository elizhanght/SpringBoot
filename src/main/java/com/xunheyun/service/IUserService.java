package com.xunheyun.service;


import org.springframework.stereotype.Service;

import com.xunheyun.vo.UserForm;


@Service
public interface IUserService {

	public UserForm login(UserForm user);
	
	public int register(UserForm user);
}

