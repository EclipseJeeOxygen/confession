package com.cn.Service;

import com.cn.Entity.UserEntity;

public interface UserService {
	void adduser(String file);

	UserEntity selectName(String userName);

	void updateName(int id, String andName);

	void updatePassword(int id, String password);
}
