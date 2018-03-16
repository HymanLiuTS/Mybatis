package com.yiibai.maper;

import java.util.List;

import com.yiibai.pojo.Order;
import com.yiibai.pojo.User;

public interface UserMaper {
	
	public List<Order> getUserOrders(int id);
	
	public List<Order> getUserOrdersPageList(int id,int limit,int offset);

	public User getUserById(int id);

}
