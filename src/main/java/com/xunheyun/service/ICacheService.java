package com.xunheyun.service;

import java.util.List;
import java.util.Map;

import com.xunheyun.vo.Property;

public interface ICacheService {

	public void saveProject(String project,String filename,List<Property> properties);
	
	public Map<String, Object> getFileMap(String project,String filename);
}
