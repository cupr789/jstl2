package com.iot.test.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iot.test.vo.Customer;

public interface CustomerDao {
	public List<Customer> selectCustomerList(HttpServletRequest req);
	public int deleteCustomer(HttpServletRequest req);
	public int updateCustomer(HttpServletRequest req);
	public int insertCustomer(HttpServletRequest req);
}
