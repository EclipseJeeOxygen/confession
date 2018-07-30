package com.cn.Entity;

public class UserEntity {

	private Integer id;
	private String userName;
	private String andName;
	private String password;
	private Integer gustId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAndName() {
		return andName;
	}

	public void setAndName(String andName) {
		this.andName = andName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getGustId() {
		return gustId;
	}

	public void setGustId(Integer gustId) {
		this.gustId = gustId;
	}

}
