package com.yiibai.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yiibai.maper.UserMaper;
import com.yiibai.pojo.Order;

// http://localhost:8080/mybatis-start8/user/orders
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserMaper userMaper;

//	@RequestMapping("/orders")
//	public ModelAndView listall(HttpServletRequest request, HttpServletResponse response) {
//		List<Order> orders = userMaper.getUserOrders(1);
//		System.out.println("orders");
//		ModelAndView mav = new ModelAndView("user_orders");
//		mav.addObject("orders", orders);
//		return mav;
//	}

	@RequestMapping("/orders")
	public ModelAndView listpage(HttpServletRequest request, HttpServletResponse response) {

		int limit = 3;
		String page = request.getParameter("page");
		int currentPage = page == null ? 1 : Integer.parseInt(page);
		if (currentPage <= 0) {
			currentPage = 1;
		}
		int offset = (currentPage - 1) * limit;
		List<Order> orders = userMaper.getUserOrdersPageList(1,limit,offset);
		System.out.println("orders");
		ModelAndView mav = new ModelAndView("user_orders");
		mav.addObject("orders", orders);
		return mav;
	}
}
