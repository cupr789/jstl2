package com.iot.test.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iot.test.vo.MenuInfo;

public interface MenuDao {
	public List<MenuInfo> selectMenuList();
	public int updateMenuList(HttpServletRequest req);
	public int deleteMenu(HttpServletRequest req);
	public List<MenuInfo> selectMenuSearch(HttpServletRequest req);
	public int insertMenu(HttpServletRequest req);
}
