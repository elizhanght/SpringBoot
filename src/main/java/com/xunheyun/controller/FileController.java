/**
 */
package com.xunheyun.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xunheyun.service.IFileService;
import com.xunheyun.vo.File;

/**
 * @author eli.zhang
 */
@RequestMapping(value="/file")
@Controller
public class FileController {

	@Autowired
	private IFileService fileService;
	
	@RequestMapping(value="/list")
	public String list(HttpServletRequest request){
		
		int projectId = Integer.valueOf(request.getParameter("project_id"));
		
		List<File> list = fileService.list(projectId);
		
		request.setAttribute("files", list);
		request.setAttribute("project_id", projectId);
		
		return "file_list";
	}
	
	@RequestMapping(value="/addpage")
	public String addPage(HttpServletRequest request){
		
		int projectId = Integer.valueOf(request.getParameter("project_id"));
		
		request.setAttribute("project_id", projectId);
		
		return "file_add";
	}
	
	@RequestMapping(value="/add")
	public String add(HttpServletRequest request,@ModelAttribute("form") File file){
		
		fileService.insertFile(file);
		
		request.setAttribute("project_id", file.getProject_id());
		
		return "redirect:/file/list?project_id="+file.getProject_id();
	}
	
	@RequestMapping(value="/delete")
	public String deleteFile(HttpServletRequest request){
		
		int fileId = Integer.valueOf(request.getParameter("file_id"));
		int projectId = Integer.valueOf(request.getParameter("project_id"));
		
		fileService.deleteFile(fileId);
		
		return "redirect:/file/list?project_id="+projectId;
	}
	
	@RequestMapping(value="/editpage")
	public String editPage(HttpServletRequest request){
		
		int fileId = Integer.valueOf(request.getParameter("file_id"));
		int projectId = Integer.valueOf(request.getParameter("project_id"));
		
		File file = fileService.getFileById(fileId);
		
		request.setAttribute("file", file);
		request.setAttribute("project_id", projectId);
		
		return "file_edit";
	}
	@RequestMapping(value="/edit")
	public String edit(HttpServletRequest request,@ModelAttribute("form") File file){
		
		int projectId = Integer.valueOf(request.getParameter("project_id"));
		
		fileService.updateFile(file);
		
		return "redirect:/file/list?project_id="+projectId;
	}
	
}

