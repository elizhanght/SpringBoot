package com.xunheyun.service;

import org.springframework.stereotype.Service;

import com.sun.javafx.collections.MappingChange.Map;

@Service
public interface IUserService {

	public Map<String, Object> login(String userName,String password);
}
