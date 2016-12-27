package com.xunheyun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xunheyun.mapper.UserMapper;
import com.xunheyun.service.IUserService;
import com.xunheyun.vo.UserForm;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserForm login(UserForm userForm) {
		
		UserForm user = userMapper.findUser(userForm);
		
		return user;
	}

	@Override
	public int register(UserForm user) {
		
		return userMapper.register(user);
	}

}

