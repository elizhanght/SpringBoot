package com.xunheyun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.xunheyun.vo.Server;

@Mapper
public interface ServerMapper {

	
	@Select("select * from xhy_server where project_id=#{project_id}")
	public List<Server> list(@Param("project_id") int project_id);
	
	@Insert("insert into xhy_server (server_name,server_ip,server_user,server_pwd,server_desc,project_id,tomcat_dir) values "
			+ "(#{server_name},#{server_ip},#{server_user},#{server_pwd},#{server_desc},#{project_id},#{tomcat_dir})")
	public void insertServer(Server server);
	
	@Select("select * from xhy_server where server_id=#{server_id}")
	public Server getServerById(@Param("server_id") int server_id);
}
