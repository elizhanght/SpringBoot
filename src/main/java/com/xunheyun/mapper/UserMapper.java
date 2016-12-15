/**
 * 
 */
package com.xunheyun.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

/**
 * @author ELI.ZHANG
 */
@Mapper
public interface UserMapper {

	@Results(id = "userResult", value = {
			  @Result(property = "user_name", column = "user_name"),
			  @Result(property = "pass_word", column = "pass_word")
			})
	@Select("SELECT * FROM xhy_user WHERE user_name=#{userName} and pass_word=#{passWord}")
	Map<String, Object> findUser(@Param("userName") String userName,@Param("passWord") String passWord);
}
