package com.iot.test.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.iot.test.dao.UserDao;
import com.iot.test.dao.impl.UserDaoImpl;
import com.iot.test.service.UserService;
import com.iot.test.vo.UserInfo;

public class UserServiceImpl implements UserService{
	UserDao ud = new UserDaoImpl();
	@Override
	public void getUserList(HttpServletRequest req) {
		UserInfo ui = null;
		Gson gs = new Gson();
		String json = req.getParameter("param");
		if(json!=null) {
			ui=gs.fromJson(json, UserInfo.class);
		}
		req.setAttribute("userList", ud.selectUserList(ui));
	}

	@Override
	public void getUser(HttpServletRequest req) {
		
	}

	@Override
	public void insertUser(HttpServletRequest req) {
		
	}

	@Override
	public void updateUser(HttpServletRequest req) {
		
	}

	@Override
	public void deleteUser(HttpServletRequest req) {
		
	}

}
