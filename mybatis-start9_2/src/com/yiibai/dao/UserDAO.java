package com.yiibai.dao;

import java.util.List;

import com.yiibai.pojo.Order;

public interface UserDAO {
	public List<Order> getUserOrders(int id);

}
