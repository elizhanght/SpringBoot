package com.xunheyun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xunheyun.vo.File;

@Mapper
public interface FileMapper {

	@Select("select * from xhy_file where project_id=#{project_id}")
	public List<File> list(@Param("project_id") int project_id);
	
	@Insert("insert into xhy_file (file_name,project_id,file_desc,timestamp) values (#{file_name},#{project_id},#{file_desc},#{timestamp})")
	public int insertFile(File file);
	
	@Delete("delete from xhy_file where file_id=#{file_id}")
	public int deleteFile(@Param("file_id") int file_id);
	
	@Select("select * from xhy_file where file_id=#{file_id}")
	public File getFileById(@Param("file_id") int file_id);
	
	@Update("update xhy_file set file_name=#{file_name},file_desc=#{file_desc} where file_id=#{file_id}")
	public int updateFile(File file);
	
	@Select("select * from xhy_file where project_id=#{project_id} and file_name=#{file_name}")
	public File getFileByProjectIdAndFileName(@Param("project_id") int project_id,@Param("file_name") String file_name);
}

