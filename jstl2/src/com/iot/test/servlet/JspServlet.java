package com.iot.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iot.test.service.ClassService;
import com.iot.test.service.CustomerService;
import com.iot.test.service.MenuService;
import com.iot.test.service.UserService;
import com.iot.test.service.impl.ClassServiceImpl;
import com.iot.test.service.impl.CustomerServiceImpl;
import com.iot.test.service.impl.MenuServiceImpl;
import com.iot.test.service.impl.UserServiceImpl;

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
			uri = "/WEB-INF"+uri;
		}
		if(uri.indexOf("class/list")!=-1) {
			ClassService cs = new ClassServiceImpl();
			System.out.println(cs.getClassList(req));
			req.setAttribute("classList", cs.getClassList(req));
			uri = "/WEB-INF"+uri;
		}
		if(uri.indexOf("customer/list")!=-1) {
			CustomerService cuService = new CustomerServiceImpl();
			cuService.setCustomerList(req);
			if(req.getParameter("searchType")!=null) {				
				cuService.setCustomerOne(req);
			}
			uri = "/WEB-INF"+uri;
		}
		if(uri.indexOf("customer/insert")!=-1) {
			int partIdx = uri.indexOf(".");
			uri = uri.replace(uri.substring(uri.indexOf("insert"),partIdx), "list");
			System.out.println("인서트할꺼다");
			CustomerService cuService = new CustomerServiceImpl();
			int result = cuService.insertCustomer(req);
			if(result>=1) {
				System.out.println("입력성공");
			}else {
				System.out.println("입력실패");
			}
		}
		
		if(uri.indexOf("customer/update")!=-1) {
			int partIdx = uri.indexOf(".");
			uri = uri.replace(uri.substring(uri.indexOf("update"),partIdx), "list");
			String updateKey = req.getParameter("customerId");
			String deleteKey = req.getParameter("deleteName");
			if(deleteKey!=null) {
				System.out.println("삭제할게");
				CustomerService cs = new CustomerServiceImpl();
				int result = cs.deleteCustomer(req);
				if(result>=1) {
					System.out.println("삭제성공");
				}
				else {
					System.out.println("삭제실패");
				}
				
			}
			if(updateKey!=null) {
				
				System.out.println("업데이트할게");
				CustomerService cs = new CustomerServiceImpl();
				int result = cs.updateCustomer(req);
				if(result>=1) {
					System.out.println("수정성공");
				}
				else {
					System.out.println("수정실패");
				}
			}
			
		}
		
		if(uri.indexOf("menu/list")!=-1) {
			uri = "/WEB-INF"+uri;
		}
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, res);
	}
}
	
