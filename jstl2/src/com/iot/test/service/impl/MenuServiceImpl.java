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

	@Override
	public void updateMenuList(HttpServletRequest req) {
		req.setAttribute("updateResult", mdao.updateMenuList(req));
		
	}

	@Override
	public void deleteMenu(HttpServletRequest req) {
		req.setAttribute("deleteResult", mdao.deleteMenu(req));
		
	}

	@Override
	public void getMenuSearch(HttpServletRequest req) {
		req.setAttribute("menuList", mdao.selectMenuSearch(req));
		
	}

	@Override
	public void insertMenu(HttpServletRequest req) {
		req.setAttribute("insertResult", mdao.insertMenu(req));
		
	}

}
