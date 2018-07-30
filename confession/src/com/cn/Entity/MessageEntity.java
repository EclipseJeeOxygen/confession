package com.cn.Entity;

public class MessageEntity {
	private Integer id;
	private String name;
	private String leaveMessage;
	private String time;
	private int commentNum;
	private String userNameOne;

	public String getUserNameOne() {
		return userNameOne;
	}

	public void setUserNameOne(String userNameOne) {
		this.userNameOne = userNameOne;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLeaveMessage() {
		return leaveMessage;
	}

	public void setLeaveMessage(String leaveMessage) {
		this.leaveMessage = leaveMessage;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

}
