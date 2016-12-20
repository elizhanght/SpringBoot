/**
 */
package com.xunheyun.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.xunheyun.vo.UserForm;

/**
 * @author ELI.ZHANG
 */
@Mapper
public interface UserMapper {


	@Select("SELECT * FROM xhy_user WHERE user_name=#{userName} and pass_word=#{passWord}")
	UserForm findUser(@Param("userName") String userName,@Param("passWord") String passWord);
}

