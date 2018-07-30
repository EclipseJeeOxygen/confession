package com.cn.Dao;

import org.apache.ibatis.annotations.Param;

import com.cn.Entity.UserEntity;

public interface UserDao {

	// 增加用户
	void adduser(@Param("userName") String userName, @Param("andName") String andName,
			@Param("password") String password, @Param("gustId") Integer gustId);

	// 查询用户
	UserEntity selectName(@Param("userName") String userName);

	// 修改昵称
	void updateName(@Param("id") int id, @Param("andName") String andName);

	// 修改密码
	void updatePassword(@Param("id") int id, @Param("password") String password);
}