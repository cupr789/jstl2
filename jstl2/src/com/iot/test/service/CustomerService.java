package com.iot.test.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iot.test.vo.Customer;

public interface CustomerService {
	public void setCustomerList(HttpServletRequest req);
	public void setCustomerOne(HttpServletRequest req);
	public int deleteCustomer(HttpServletRequest req);
	public int updateCustomer(HttpServletRequest req);
	public int insertCustomer(HttpServletRequest req);
}
