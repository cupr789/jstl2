package com.iot.test.service;

import javax.servlet.http.HttpServletRequest;

public interface MenuService {
	public void setMenuList(HttpServletRequest req);
	public void updateMenuList(HttpServletRequest req);
	public void deleteMenu(HttpServletRequest req);
	public void getMenuSearch(HttpServletRequest req);
	public void insertMenu(HttpServletRequest req);
	
}
