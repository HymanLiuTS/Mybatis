package com.yiibai.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yiibai.dao.UserDAOImpl;
import com.yiibai.pojo.Order;

// http://localhost:8080/mybatis-start8/user/orders
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserDAOImpl udao;

	@RequestMapping("/orders")
	public ModelAndView listall(HttpServletRequest request, HttpServletResponse response) {
		List<Order> orders = this.udao.getUserOrders(1);
		System.out.println("orders");
		ModelAndView mav = new ModelAndView("user_orders");
		mav.addObject("orders", orders);
		return mav;
	}
}
