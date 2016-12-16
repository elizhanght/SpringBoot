package com.xunheyun.service;

import java.util.List;

import com.xunheyun.vo.Property;

public interface IPropertyService {

	public List<Property> list(int file_id);
	
	public int addProperty(Property property);
}
