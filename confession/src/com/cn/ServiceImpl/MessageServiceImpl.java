package com.cn.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.Dao.MessageDao;
import com.cn.Entity.MessageEntity;
import com.cn.Service.MessageService;

/**
 * @author Tiny 2018年3月11日
 */
@Service("messageServiceImpl")
public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageDao messageDao;

	@Override
	public void add(String name,String userNameOne, String leaveMessage, int userId) {
		// TODO Auto-generated method stub
		messageDao.add(name, userNameOne ,leaveMessage, userId);

	}

	@Override
	public List<MessageEntity> select() {

		return messageDao.select();
	}

	@Override
	public List<MessageEntity> checkHot() {
		// TODO Auto-generated method stub
		return messageDao.checkHot();
	}

	@Override
	public void updateCommentNum(int id) {
		// TODO Auto-generated method stub
		messageDao.updateCommentNum(id);
	}

	@Override
	public void deleteMessage(int id) {
		// TODO Auto-generated method stub
		messageDao.deleteMessage(id);
	}
}
