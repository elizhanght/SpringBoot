/**
 */
package com.xunheyun.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xunheyun.service.IPropertyService;
import com.xunheyun.vo.Property;

/**
 * @author eli.zhang
 */
@RequestMapping(value="/property")
@Controller
public class PropertyController {

	@Autowired
	private IPropertyService propertyService;
	
	@RequestMapping(value="/list")
	public String list(HttpServletRequest request){
		
		int fileId = Integer.valueOf(request.getParameter("file_id"));
		int projectId = Integer.valueOf(request.getParameter("project_id"));
		
		List<Property> list = propertyService.list(fileId);
		
		request.setAttribute("properties", list);
		request.setAttribute("file_id", fileId);
		request.setAttribute("project_id", projectId);
		
		return "/property_list";
	}
	
	@RequestMapping(value="/addpage")
	public String addPage(HttpServletRequest request){
		
		int file_id = Integer.valueOf(request.getParameter("file_id"));
		
		request.setAttribute("file_id", file_id);
		
		return "/property_add";
	}
	
	@RequestMapping(value="/add")
	public String addProperty(HttpServletRequest request,@ModelAttribute("form") Property property){
		
		propertyService.addProperty(property);
		
		List<Property> list = propertyService.list(property.getFile_id());
		
		request.setAttribute("properties", list);
		request.setAttribute("file_id", property.getFile_id());
		
		return "/property/list";
	}
}
