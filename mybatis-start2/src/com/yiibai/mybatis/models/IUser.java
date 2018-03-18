package com.yiibai.mybatis.models;

import org.apache.ibatis.annotations.Select;

public interface IUser {
	public MyUser getUserByID(int id);
}
