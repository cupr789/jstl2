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
		req.setAttribute("customerList", cd.selectCustomerList(req.getParameter("order"),req.getParameter("flag")));
		req.setAttribute("flag", req.getParameter("flag"));
	}
	

}
