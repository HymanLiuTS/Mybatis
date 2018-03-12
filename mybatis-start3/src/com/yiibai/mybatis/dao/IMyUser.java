package com.yiibai.mybatis.dao;

import java.util.List;

import com.yiibai.mybatis.models.MyUser;

public interface IMyUser {
	
	public List<MyUser> getUserList();
	
	public void insertUser(MyUser user);
	
	public void updateUser(MyUser user);
	
	public void deleteUser(int userID);
	
	public MyUser getUser(int id);

}
