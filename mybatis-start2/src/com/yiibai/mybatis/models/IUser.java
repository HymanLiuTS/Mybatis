package com.yiibai.mybatis.models;

import org.apache.ibatis.annotations.Select;

public interface IUser {
	@Select("select * from user where id= #{id}")
	public MyUser getUserByID(int id);
}
