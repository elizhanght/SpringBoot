package com.xunheyun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xunheyun.vo.Property;

@Mapper
public interface PropertyMapper {

	@Insert("insert into xhy_keyvalue(pro_key,pro_value,file_id) values (#{pro_key},#{pro_value},#{file_id})")
	public int insertProperty(Property property);
	
	@Select("select * from xhy_keyvalue where file_id=#{file_id}")
	public List<Property> list(@Param("file_id") int file_id);
	
	@Update("update xhy_keyvalue set pro_key=#{pro_key},pro_value=#{pro_value} where keyvalue_id=#{keyvalue_id}")
	public int updateProperty(Property property);
	
	@Select("select * from xhy_keyvalue where keyvalue_id=#{keyvalue_id}")
	public Property getPropertyById(@Param("keyvalue_id") int keyvalue_id);
	
	@Delete("delete from xhy_keyvalue where keyvalue_id=#{keyvalue_id}")
	public int delete(@Param("keyvalue_id") int keyvalue_id);
	
	@Delete("delete from xhy_keyvalue where file_id=#{file_id}")
	public int deleteByFileId(@Param("file_id") int file_id);
}

