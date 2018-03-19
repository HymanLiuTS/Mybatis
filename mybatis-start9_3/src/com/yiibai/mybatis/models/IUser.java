package com.yiibai.mybatis.models;

import org.apache.ibatis.annotations.Param;

public interface IUser {

	public MyUser getUserByID(@Param("id") int id);
	public MyUser getUserByIDName(MyUser user);
	public MyUser getUserByChose(MyUser user);
	public MyUser getUserByTrim(MyUser user);
	
	public void updateUser(MyUser user);
	public void updateUser2(MyUser user);
}
