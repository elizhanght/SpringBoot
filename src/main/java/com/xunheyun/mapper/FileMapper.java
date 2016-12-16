package com.xunheyun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.xunheyun.vo.File;

@Mapper
public interface FileMapper {

	@Select("select * from xhy_file where project_id=#{project_id}")
	public List<File> list(@Param("project_id") int project_id);
	
	@Insert("insert into xhy_file (file_name,project_id,file_desc) values (#{file_name},#{project_id},#{file_desc})")
	public int insertFile(File file);
}
