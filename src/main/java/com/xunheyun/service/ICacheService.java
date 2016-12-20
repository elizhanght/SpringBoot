package com.xunheyun.service;

import java.util.List;
import java.util.Map;

import com.xunheyun.vo.Property;

public interface ICacheService {

	/**
	 * 将项目和文件名称和属性存储到缓存中
	 * @param project			-- 项目名称
	 * @param filename			-- 文件名称
	 * @param properties		-- 文件内的属性
	 */
	public void saveProject(String project,String filename,List<Property> properties);
	
	/**
	 * 根据项目名称和文件名称获取文件内的属性
	 * @param project			-- 项目名称
	 * @param filename			-- 文件名称
	 * @return Map<String, Object>
	 */
	public Map<String, Object> getFileMap(String project,String filename);
}
