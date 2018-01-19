package com.iot.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iot.test.dao.CustomerDao;
import com.iot.test.dao.impl.CustomerDaoImpl;
import com.iot.test.service.CustomerService;
import com.iot.test.vo.Customer;

public class CustomerServiceImpl implements CustomerService{
	CustomerDao cd = new CustomerDaoImpl();

	@Override
	public void setCustomerList(HttpServletRequest req) {
		req.setAttribute("customerList", cd.selectCustomerList(req));
		req.setAttribute("flag", req.getParameter("flag"));
	}

	@Override
	public int deleteCustomer(HttpServletRequest req) {
		int result = cd.deleteCustomer(req);
		return result;
	}

	@Override
	public int updateCustomer(HttpServletRequest req) {
		int result = cd.updateCustomer(req);
		return result;
	}

	@Override
	public int insertCustomer(HttpServletRequest req) {
		int result = cd.insertCustomer(req);
		return result;
	}

	@Override
	public void setCustomerOne(HttpServletRequest req) {
		System.out.println(cd.selectCustomerOne(req));
		req.setAttribute("customerOne", cd.selectCustomerOne(req));
		
	}
	

}
