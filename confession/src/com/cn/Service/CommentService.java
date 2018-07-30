package com.cn.Service;

import java.util.List;

import com.cn.Entity.CommentEntity;

public interface CommentService {

	void addComment(String comment, String commentName,String stuId, int messageId);

	List<CommentEntity> selectComment(int messageId);
}
