package com.cn.Service;

import java.util.List;

import com.cn.Entity.MessageEntity;

public interface MessageService {
	void add(String name,String userNameOne, String leaveMessage, int userId);

	List<MessageEntity> select();

	List<MessageEntity> checkHot();

	void updateCommentNum(int id);
	void deleteMessage(int id);
}
