package com.xunheyun.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xunheyun.mapper.UserMapper;
import com.xunheyun.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public Map<String, Object> login(String userName,String password) {
		
		java.util.Map<String, Object> user = userMapper.findUser(userName, password);
		
		return user;
	}

}
