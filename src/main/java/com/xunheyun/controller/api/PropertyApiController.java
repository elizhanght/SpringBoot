/**
 */
package com.xunheyun.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.xunheyun.service.IPropertyApiService;
import com.xunheyun.service.IUserService;
import com.xunheyun.vo.Property;
import com.xunheyun.vo.UserForm;

/**
 * @author eli.zhang
 */
@Controller
@RequestMapping(value="/api/property")
public class PropertyApiController {
	
	Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private IPropertyApiService propertyApiService;
	
	@Autowired
	private IUserService userService;
	
	/**
	 * 根据项目和文件名称获取配置属性
	 * 
	 * @param project		-- 项目名称
	 * @param filename		-- 文件名称
	 * 
	 * @return Map<String, Object>
	 */
	@RequestMapping(value="/{project}/{filename}")
	@ResponseBody
	public Map<String, Object> getProperty(@PathVariable("project") String project,@PathVariable("filename") String filename,@RequestBody String json){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(validateUser(json) == false)return map;
		
		List<Property> propertyList = propertyApiService.getPropertyByProjectAndFile(project, filename);
		
		for (Property property : propertyList) {
			
			map.put(property.getPro_key(), property.getPro_value());
		}
		
		logger.info("根据项目和文件获取属性 - " + JSON.toJSONString(map));
		
		return map;
	}
	/**
	 * 获取项目下面的所有文件的属性,如果files对象中有值则会取到files中文件的属性，如果files为空则获取当前项目中的所有文件属性
	 * @param project		-- 项目名称
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/{project}")
	@ResponseBody
	public Map<String, Object> getProperty(@PathVariable("project") String project,@RequestBody String json){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(validateUser(json) == false)return map;
		
		Map<String, Object> jsonMap = JSON.parseObject(json, Map.class);
		List<String> files = (List<String>) jsonMap.get("files");
		
		List<Property> propertyList = propertyApiService.getPropertyByProject(project,files);
		
		for (Property property : propertyList) {
			
			map.put(property.getPro_key(), property.getPro_value());
		}
		
		logger.info("根据项目属性 - " + JSON.toJSONString(map));
		
		return map;
	}
	
	private boolean validateUser(String json){
		
		UserForm user = JSON.parseObject(json, UserForm.class);
		
		UserForm login = userService.login(user);
		
		if (login == null) {
			logger.info("用户名或者密码错误 - " + json);
			return false;
		}
		return true;
	}
	
}
