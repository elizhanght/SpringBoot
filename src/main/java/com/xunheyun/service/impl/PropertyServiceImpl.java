/**
 * 
 */
package com.xunheyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xunheyun.mapper.PropertyMapper;
import com.xunheyun.service.IPropertyService;
import com.xunheyun.vo.Property;

/**
 * @author eli.zhang
 */
@Service
public class PropertyServiceImpl implements IPropertyService {

	@Autowired
	private PropertyMapper propertyMapper;
	
	/* (non-Javadoc)
	 * @see com.xunheyun.service.IPropertyService#list(int)
	 */
	@Override
	public List<Property> list(int file_id) {
		
		List<Property> list = propertyMapper.list(file_id);
		
		return list;
	}

	/* (non-Javadoc)
	 * @see com.xunheyun.service.IPropertyService#addProperty(com.xunheyun.vo.Property)
	 */
	@Override
	public int addProperty(Property property) {
		
		int insertProperty = propertyMapper.insertProperty(property);
		
		return insertProperty;
	}

	@Override
	public int updateProperty(Property property) {
		// TODO Auto-generated method stub
		
		propertyMapper.updateProperty(property);
		
		return 0;
	}

	@Override
	public Property getPropertyById(int keyvalue_id) {
		// TODO Auto-generated method stub
		
		Property property = propertyMapper.getPropertyById(keyvalue_id);
		
		return property;
	}

	@Override
	public int delete(int keyvalue_id) {
		// TODO Auto-generated method stub
		propertyMapper.delete(keyvalue_id);
		return 0;
	}

}
