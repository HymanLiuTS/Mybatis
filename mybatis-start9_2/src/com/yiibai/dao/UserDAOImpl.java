package com.yiibai.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.yiibai.pojo.Order;

@Repository
public class UserDAOImpl extends SqlSessionDaoSupport implements UserDAO {
	public List<Order> getUserOrders(int id){
		List<Order> orders = this.getSqlSession().selectList("com.yiibai.dao.UserDAO.getUserOrders",id);
		orders.clear();
		Order order=new Order();
		order.setOrderId(1);
		order.setOrderNo("123456");
		order.setMoney((float)(123.45));
		order.setUserId(1);
		orders.add(order);
		return orders;
	}
}
