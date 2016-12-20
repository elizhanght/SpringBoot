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
	public UserForm login(String userName,String password) {
		
		UserForm user = userMapper.findUser(userName, password);
		
		return user;
	}

}

