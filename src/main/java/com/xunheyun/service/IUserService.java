package com.xunheyun.service;

import java.util.Map;

import org.springframework.stereotype.Service;


@Service
public interface IUserService {

	public Map<String, Object> login(String userName,String password);
}
