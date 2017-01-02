package com.xunheyun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.xunheyun.vo.War;

@Mapper
public interface WarMapper {

	@Insert("insert into xhy_war (file_name,project_id) values (#{file_name},#{project_id})")
	public void insertWar(War war);
	
	@Delete("delete from xhy_war where war_id =#{war_id}")
	public int deleteWar(@Param("war_id") int war_id);
	
	@Select("select * from xhy_war where project_id=#{project_id}")
	public List<War> list(@Param("project_id") int project_id);
	
	@Select("select * from xhy_war where war_id=#{war_id}")
	public War getWarById(@Param("war_id") int war_id);
	
}
