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
		int project_id = Integer.valueOf(request.getParameter("project_id"));
		
		request.setAttribute("file_id", file_id);
		request.setAttribute("project_id", project_id);
		
		return "/property_add";
	}
	
	@RequestMapping(value="/add")
	public String addProperty(HttpServletRequest request,@ModelAttribute("form") Property property){
		
		propertyService.addProperty(property);
		
		int project_id = Integer.valueOf(request.getParameter("project_id"));
		
		return "redirect:/property/list?file_id="+property.getFile_id()+"&project_id="+project_id;
	}
	
	@RequestMapping(value="/editpage")
	public String editpage(HttpServletRequest request){
		
		int keyvalue_id = Integer.valueOf(request.getParameter("keyvalue_id"));
		int project_id = Integer.valueOf(request.getParameter("project_id"));
		
		Property property = propertyService.getPropertyById(keyvalue_id);
		
		request.setAttribute("project_id", project_id);
		request.setAttribute("property", property);
		
		return "property_edit";
	}
	
	@RequestMapping(value="/edit")
	public String edit(HttpServletRequest request,@ModelAttribute("form") Property property){
		
		int project_id = Integer.valueOf(request.getParameter("project_id"));
		propertyService.updateProperty(property);
		
		return "redirect:/property/list?file_id="+property.getFile_id()+"&project_id="+project_id;
	}
	
	@RequestMapping(value="/delete")
	public String delete(HttpServletRequest request){
		
		int keyvalue_id = Integer.valueOf(request.getParameter("keyvalue_id"));
		int project_id = Integer.valueOf(request.getParameter("project_id"));
		int file_id = Integer.valueOf(request.getParameter("file_id"));
		
		propertyService.delete(keyvalue_id);
		
		return "redirect:/property/list?file_id="+file_id+"&project_id="+project_id;
	}
}
