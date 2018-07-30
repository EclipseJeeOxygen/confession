package com.cn.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.Dao.CommentDao;
import com.cn.Entity.CommentEntity;
import com.cn.Service.CommentService;
import com.cn.Service.MessageService;

@Service("commentServiceImpl")
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;
	@Autowired
	private MessageService messageServiceImpl;

	@Override
	// 增加评论
	public void addComment(String comment, String commentName, String stuId, int messageId) {
		// TODO Auto-generated method stub
		commentDao.addComment(comment, commentName, stuId,messageId);
		messageServiceImpl.updateCommentNum(messageId);
	}

	@Override
	// 查询评论
	public List<CommentEntity> selectComment(int messageId) {
		// TODO Auto-generated method stub
		return commentDao.selectComment(messageId);
	}

}
