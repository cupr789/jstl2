package com.iot.test.service.impl;

import java.util.ArrayList;
import java.util.List;

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
		String searchType = req.getParameter("searchType");
		String searchStr = req.getParameter("searchStr");
		if(searchType!=null && !searchStr.equals("")) {
			ui=new UserInfo();
			ui.setSearchType(searchType);
			if(searchType.equals("uiName")) {
				ui.setUiName(searchStr);
			}else if(searchType.equals("uiAge")) {
				ui.setUiAge(Integer.parseInt(searchStr));
			}else if(searchType.equals("address")) {
				ui.setAddress(searchStr);
			}
		}
		req.setAttribute("userList", ud.selectUserList(ui));
		req.setAttribute("searchType", searchType);
		req.setAttribute("searchStr", searchStr);
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
