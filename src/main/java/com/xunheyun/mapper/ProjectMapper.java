package com.xunheyun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xunheyun.vo.Project;

@Mapper
public interface ProjectMapper {

	@Insert("insert into xhy_project(project_name,project_desc,user_id) values (#{project_name},#{project_desc},#{user_id})")
	public int insertProject(Project project);
	
	@Select("select * from xhy_project where user_id=#{user_id}")
	public List<Project> list(@Param("user_id") int user_id);
	
	@Delete("DELETE FROM xhy_project WHERE project_id = #{project_id}")
	public int deleteProject(@Param("project_id") int project_id);
	
	@Update("UPDATE xhy_project SET project_name = #{project_name},project_desc=#{project_desc} WHERE project_id = #{project_id}")
	public int updateProject(Project project);
	
	@Select("select * from xhy_project where project_id=#{project_id}")
	public Project getProject(int project_id);
}
