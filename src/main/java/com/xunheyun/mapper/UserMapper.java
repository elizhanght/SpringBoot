/**
 */
package com.xunheyun.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.xunheyun.vo.UserForm;

/**
 * @author ELI.ZHANG
 */
@Mapper
public interface UserMapper {


	@Select("SELECT * FROM xhy_user WHERE user_name=#{user_name} and pass_word=#{pass_word}")
	UserForm findUser(UserForm user);
	
	@Insert("insert into xhy_user (user_name,pass_word,email) values (#{user_name},#{pass_word},#{email})")
	@Options(useGeneratedKeys = true, keyProperty = "user_id", keyColumn = "user_id")
	int register(UserForm user);
}

