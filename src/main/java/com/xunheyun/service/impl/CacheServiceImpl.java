/**
 * 
 */
package com.xunheyun.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;

import com.xunheyun.service.ICacheService;
import com.xunheyun.vo.Property;

/**
 * @author eli.zhang
 */
public class CacheServiceImpl implements ICacheService {

	private final static String DIS_KEY="xhydis:dis:";
	
	@Resource(name="redisTemplate") 
	private HashOperations<String, String, Object> hashOps;
	
	@Override
	public void saveProject(String project, String filename, List<Property> properties) {

		String key = DIS_KEY+project+":"+filename;
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		for (Property property : properties) {
			map.put(property.getPro_key(), property.getPro_value());
		}
		
		hashOps.putAll(key, map);
	}

	@Override
	public Map<String, Object> getFileMap(String project, String filename) {
		
		String key = DIS_KEY+project+":"+filename;

		Map<String, Object> entries = hashOps.entries(key);
		
		return entries;
	}

}
