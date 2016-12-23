/**
 */
package com.xunheyun.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xunheyun.service.IPropertyApiService;
import com.xunheyun.vo.Property;

/**
 * @author eli.zhang
 */
@Controller
@RequestMapping(value="/api/property")
public class PropertyApiController {
	
	@Autowired
	private IPropertyApiService propertyApiService;
	
	/**
	 * 根据项目和文件名称获取配置属性
	 * @param project		-- 项目名称
	 * @param filename		-- 文件名称
	 * @return
	 */
	@RequestMapping(value="/{project}/{filename}")
	@ResponseBody
	public Map<String, Object> getProperty(@PathVariable("project") String project,@PathVariable("filename") String filename){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Property> propertyList = propertyApiService.getPropertyByProjectAndFile(project, filename);
		
		for (Property property : propertyList) {
			
			map.put(property.getPro_key(), property.getPro_value());
		}
		
		return map;
	}
	/**
	 * 获取项目下面的所有文件的属性
	 * @param project		-- 项目名称
	 * @return
	 */
	@RequestMapping(value="/{project}")
	@ResponseBody
	public Map<String, Object> getProperty(@PathVariable("project") String project){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Property> propertyList = propertyApiService.getPropertyByProject(project);
		
		for (Property property : propertyList) {
			
			map.put(property.getPro_key(), property.getPro_value());
		}
		
		return map;
	}
	
}
