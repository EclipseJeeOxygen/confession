package com.cn.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.Entity.MessageEntity;

public interface MessageDao {

	void add(@Param("name") String name, @Param("userNameOne") String userNameOne,@Param("leaveMessage") String leaveMessage, @Param("userId") int userId);

	List<MessageEntity> select();

	List<MessageEntity> checkHot();

	void updateCommentNum(@Param("id") int id);
	void deleteMessage(@Param("id") int id);
}
