package com.xunheyun.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xunheyun.mapper.ServerMapper;
import com.xunheyun.mapper.WarMapper;
import com.xunheyun.service.IServerService;
import com.xunheyun.utils.LogUtils;
import com.xunheyun.vo.Result;
import com.xunheyun.vo.Server;
import com.xunheyun.vo.War;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

@Service
public class ServerServiceImpl implements IServerService {


	@Autowired
	private ServerMapper serverMapper;
	
	@Autowired
	private WarMapper warMapper;

	@Override
	public List<Server> list(int project_id) {
		return serverMapper.list(project_id);
	}

	@Override
	public int insertServer(Server server) {
		
		serverMapper.insertServer(server);
		return 0;
	}

	@Override
	public int updateServer(Server server) {
		return 0;
	}

	@Override
	public int deleteServer(int server_id) {
		return 0;
	}

	@Override
	public Result startServer(int server_id) {
		
		Server server = serverMapper.getServerById(server_id);
		
		Connection connection = new Connection(server.getServer_ip());
		Result result = new Result();
		
		try {
			connection.connect();
			boolean b = connection.authenticateWithPassword(server.getServer_user(), server.getServer_pwd());
			
			if (b) {
				
				Session openSession = connection.openSession();
				openSession.execCommand(server.getTomcat_dir()+"/"+"bin/startup.sh");
				
				openSession.execCommand("ps -ef|grep "+server.getTomcat_dir());
				printStdout(openSession);
				
				result.setData(printStdout(openSession));
		        result.setResult(0);
		            
				openSession.close();
				connection.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Result stopServer(int server_id) {
		
		Server server = serverMapper.getServerById(server_id);
		
		Connection connection = new Connection(server.getServer_ip());
		Result result = new Result();
		
		try {
			connection.connect();
			boolean b = connection.authenticateWithPassword(server.getServer_user(), server.getServer_pwd());
			
			if (b) {
				
				Session openSession = connection.openSession();
				openSession.execCommand(server.getTomcat_dir()+"/"+"bin/shutdown.sh");
				
				openSession.execCommand("ps -ef|grep "+server.getTomcat_dir());
				printStdout(openSession);
				
				result.setData(printStdout(openSession));
		        result.setResult(0);
		        
				openSession.close();
				connection.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Result deployWar(int server_id, int war_id) {
		
		Server server = serverMapper.getServerById(server_id);
		War war = warMapper.getWarById(war_id);
		
		Connection connection = new Connection(server.getServer_ip());
		Result result = new Result();
		try {
			connection.connect();
			boolean b = connection.authenticateWithPassword(server.getServer_user(), server.getServer_pwd());
			
			if (b) {
				//打开一个会话session，执行linux命令  
	            Session sess = connection.openSession();
	            // 删除旧文件
	            String filename = war.getFile_name().replaceAll(".war", "*");
	            sess.execCommand("rm -rf " + server.getTomcat_dir() + "/webapps/" + filename);
	            
	            // 拷贝文件
				SCPClient scpClient = new SCPClient(connection);
				scpClient.put("/Users/HAITAO/Downloads/"+war.getFile_name(), server.getTomcat_dir()+"/webapps");
				  
				// 查看拷贝情况
	            sess.execCommand("ls -l "+server.getTomcat_dir()+"/webapps");  
	            
	            result.setData(printStdout(sess));
	            result.setResult(0);
			}
			
			connection.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public void logServer(int server_id) {
		
		Server server = serverMapper.getServerById(server_id);
		
		Connection connection = new Connection(server.getServer_ip());
		
		try {
			connection.connect();
			boolean b = connection.authenticateWithPassword(server.getServer_user(), server.getServer_pwd());
			
			if (b) {
				
				Session openSession = connection.openSession();
				openSession.execCommand("tail -f /var/log/xhy-wifi-server/catalina_info.log");
				
				printStdout(openSession);
				
				openSession.close();
				connection.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@SuppressWarnings("resource")
	private String printStdout(Session session) throws IOException{
		
		BufferedReader br = null;
        //接收目标服务器上的控制台返回结果,输出结果。  
        InputStream stdout = new StreamGobbler(session.getStdout());  
        br = new BufferedReader(new InputStreamReader(stdout));
        StringBuffer sb = new StringBuffer();
        
        while (true)  
        {  
            String line = br.readLine();  
            if (line == null)  
                break;  
            sb.append(line).append("\n");
            LogUtils.getInstance()._sb.append(line).append("\n");
            System.out.println(line);
        } 
        System.out.println(session.getExitStatus());
        
        return sb.toString();
	}


}
