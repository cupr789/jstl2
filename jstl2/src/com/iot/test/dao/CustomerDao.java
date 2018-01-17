package com.iot.test.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iot.test.vo.Customer;

public interface CustomerDao {
	public List<Customer> selectCustomerList(String order,String flag);
}
