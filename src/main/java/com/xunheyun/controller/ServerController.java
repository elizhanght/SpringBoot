package com.xunheyun.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.xunheyun.service.IServerService;
import com.xunheyun.utils.LogUtils;
import com.xunheyun.vo.Result;
import com.xunheyun.vo.Server;

/**
 * @author ELI.ZHANG
 * 项目下面的服务器列表
 */
@Controller
@RequestMapping(value="/server")
public class ServerController {

	@Autowired
	private IServerService serverService;
	
	@RequestMapping(value="/list")
	public String list(HttpServletRequest request){
	
		int projectId = 0;
		
		Map<String,?> map = RequestContextUtils.getInputFlashMap(request);
		if (map != null) {
			projectId = Integer.valueOf(map.get("project_id").toString());
		}else{
			projectId = Integer.valueOf(request.getParameter("project_id"));
		}
		
		List<Server> list = serverService.list(projectId);
		
		request.setAttribute("project_id", projectId);
		request.setAttribute("servers", list);
		return "server_list";
	}
	
	@RequestMapping(value="/addpage")
	public String addserverpage(HttpServletRequest request){
		
		request.setAttribute("project_id", request.getParameter("project_id"));
		return "server_add";
	}
	@RequestMapping(value="add")
	public String addServer(HttpServletRequest request,RedirectAttributes redirectAttributes,@ModelAttribute("form") Server server){
		
		serverService.insertServer(server);
		
		redirectAttributes.addFlashAttribute("project_id", server.getProject_id());
		
		return "redirect:/server/list";
	}
	
	@RequestMapping(value="deploy/{server_id}/{war_id}")
	@ResponseBody
	public Result deployWar(@PathVariable int server_id,@PathVariable int war_id){
		
		Result result = serverService.deployWar(server_id, war_id);
		
		return result;
	}
	// 停止服务
	@RequestMapping(value="stop/{server_id}")
	@ResponseBody
	public Result stopServer(@PathVariable int server_id){
		
		Result result = serverService.stopServer(server_id);
		
		return result;
	}
	// 停止服务
	@RequestMapping(value="start/{server_id}")
	@ResponseBody
	public Result startServer(@PathVariable int server_id){
		
		Result result = serverService.startServer(server_id);
		
		return result;
	}
	// 服务日志服务
	@RequestMapping(value="log/{server_id}")
	@ResponseBody
	public Result logServer(@PathVariable int server_id){
		
		Result result = new Result();
		result.setResult(0);
		
		serverService.logServer(server_id);
		
		return result;
	}
	
	// 日志页面
	@RequestMapping(value="logpage/{server_id}")
	public String logpage(HttpServletRequest request, @PathVariable int server_id){
		
		request.setAttribute("server_id", server_id);
		return "log";
	}
	
	@RequestMapping(value="/getlog")
	@ResponseBody
	public Result getLog(){
		
		Result result = new Result();
		result.setResult(0);
		
		String log = LogUtils.getInstance()._sb.toString();
		if (!log.equals("")) {
			result.setData(log);
			return result;
		}
		return result;
	}

}
