package com.yiibai.mybatis.model;

import java.util.List;

public class MyUser {
	private int id;
	private String username;
	private String mobile;
	private List<MyGroup> groups;

	public List<MyGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<MyGroup> groups) {
		this.groups = groups;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
