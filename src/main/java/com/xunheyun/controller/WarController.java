package com.xunheyun.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xunheyun.service.IWarService;
import com.xunheyun.vo.War;

@Controller
@RequestMapping(value="/war")
public class WarController {

	@Autowired
	private IWarService warService;
	
	@RequestMapping(value="/packagepage/{project_id}")
	public String packagepage(HttpServletRequest request,@PathVariable int project_id){
		
		List<War> list = warService.list(project_id);
		
		request.setAttribute("project_id", project_id);
		request.setAttribute("wars", list);
		
		return "package_list";
	}
	
	@RequestMapping("/upload/{project_id}")
	@ResponseBody
	public String upload(@RequestParam("file") MultipartFile file,@PathVariable int project_id) throws IOException{
		
		if (!file.isEmpty()) {
			
			String path = "/Users/HAITAO/Downloads/"+file.getOriginalFilename();
			
			java.io.File localfile = new java.io.File(path);
	        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(localfile));  
	        out.write(file.getBytes());
	        out.flush();
	        out.close();
	        
	        // 将结果保存到数据库中
	        
	        War war = new War();
	        war.setFile_name(file.getOriginalFilename());
	        war.setProject_id(project_id);
	        warService.saveUploadFile(war);
		}
        
        return String.valueOf(project_id);
	}
	
}
