package com.iot.test.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iot.test.dao.MenuDao;
import com.iot.test.dao.impl.MenuDaoImpl;
import com.iot.test.service.ClassService;
import com.iot.test.service.CustomerService;
import com.iot.test.service.MenuService;
import com.iot.test.service.UserService;
import com.iot.test.service.impl.ClassServiceImpl;
import com.iot.test.service.impl.CustomerServiceImpl;
import com.iot.test.service.impl.MenuServiceImpl;
import com.iot.test.service.impl.UserServiceImpl;
import com.iot.test.vo.Customer;
import com.iot.test.vo.MenuInfo;
import com.iot.test.vo.UserInfo;

//@WebServlet("/view/*")
public class JspServlet extends HttpServlet{
	private MenuService ms = new MenuServiceImpl();
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}
	
	private void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=utf-8");
		String uri = req.getRequestURI();
		System.out.println(uri);
		String root = req.getContextPath();
		System.out.println(root);
		uri = uri.replace(root, "");
		System.out.println(uri);
		ms.setMenuList(req);
		
		if(uri.indexOf("user/list")!=-1) {
			UserService us = new UserServiceImpl();
			us.getUserList(req);	
		}
		if(uri.indexOf("class/list")!=-1) {
			ClassService cs = new ClassServiceImpl();
			System.out.println(cs.getClassList(req));
			req.setAttribute("classList", cs.getClassList(req));
		}
		if(uri.indexOf("customer/list")!=-1) {
			CustomerService cuService = new CustomerServiceImpl();
			cuService.setCustomerList(req);
		}
		if(uri.indexOf("customer/update")!=-1) {
			int partIdx = uri.indexOf(".");
			uri = uri.replace(uri.substring(uri.indexOf("update"),partIdx), "list");
			System.out.println(req.getParameter("customerId")+"                    ??");
		}
		
		uri = "/WEB-INF"+uri;
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, res);
	}
}
