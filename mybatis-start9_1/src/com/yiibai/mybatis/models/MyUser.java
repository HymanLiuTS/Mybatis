package com.yiibai.mybatis.models;

import java.io.Serializable;

public class MyUser implements Serializable{
	private int id;
	private String username;
	private int mobile;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String name) {
		this.username = name;
	}
	
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int phone) {
		this.mobile = phone;
	}
	

}
