package com.iot.test.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.iot.test.dao.MenuDao;
import com.iot.test.dao.impl.MenuDaoImpl;
import com.iot.test.service.MenuService;

public class MenuServiceImpl implements MenuService {

	private MenuDao mdao = new MenuDaoImpl();
	
	@Override
	public void setMenuList(HttpServletRequest req) {
		req.setAttribute("menuList", mdao.selectMenuList());
	}

}
