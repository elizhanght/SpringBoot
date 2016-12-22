/**
 */
package com.xunheyun.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author eli.zhang
 */
@Controller
@RequestMapping(value="/api/property")
public class PropertyApiController {
	
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
		map.put("spring.datasource", "1");
		map.put("jdbc.driverClass", "com.mysql.jdbc.Driver");
		map.put("jdbc.url", "jdbc:mysql://119.254.209.185:3306/xunheyun_device?useUnicode=true&amp;characterEncoding=utf8&amp;autoReconnect=true");
		map.put("jdbc.username", "root");
//		map.put("jdbc.password", "Xhynb123.net");
		
		return map;
	}
}
