package com.xunheyun.service;

import java.util.List;

import com.xunheyun.vo.Property;

public interface IPropertyApiService {

	public List<Property> getPropertyByProjectAndFile(String project,String filename);
	
	public List<Property> getPropertyByProject(String project,List<String> files);
}
