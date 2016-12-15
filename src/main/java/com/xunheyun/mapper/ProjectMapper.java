package com.xunheyun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.xunheyun.vo.Project;

@Mapper
public interface ProjectMapper {

	@Insert("insert into xhy_project(project_name,project_desc,user_id) values (#{project_name},#{project_desc},#{user_id})")
	public int insertProject(Project project);
	
	@Select("select * from xhy_project where user_id=#{user_id}")
	public List<Project> list(@Param("user_id") int user_id);
}
