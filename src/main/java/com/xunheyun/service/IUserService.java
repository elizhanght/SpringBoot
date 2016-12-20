package com.xunheyun.service;


import org.springframework.stereotype.Service;

import com.xunheyun.vo.UserForm;


@Service
public interface IUserService {

	public UserForm login(String userName,String password);
}

