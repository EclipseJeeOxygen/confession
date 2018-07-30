package com.cn.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.Entity.CommentEntity;

public interface CommentDao {

	void addComment(@Param("comment") String comment, @Param("commentName") String commentName,@Param("stuId") String stuId,
			@Param("messageId") int messageId);

	List<CommentEntity> selectComment(@Param("messageId") int messageId);
}
