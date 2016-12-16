package com.xunheyun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.xunheyun.vo.Property;

@Mapper
public interface PropertyMapper {

	@Insert("insert into xhy_keyvalue(pro_key,pro_value,file_id) values (#{pro_key},#{pro_value},#{file_id})")
	public int insertProperty(Property property);
	
	@Select("select * from xhy_keyvalue where file_id=#{file_id}")
	public List<Property> list(@Param("file_id") int file_id);
	
}
