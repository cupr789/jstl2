package com.iot.test.test;

import java.util.List;

import com.iot.test.dao.MenuDao;
import com.iot.test.dao.UserDao;
import com.iot.test.dao.impl.MenuDaoImpl;
import com.iot.test.vo.MenuInfo;

public class MenuTest {
	public static void main(String[] args) {
		MenuDao mdao = new MenuDaoImpl();
		
		List<MenuInfo> menuList = mdao.selectMenuList();
		for(MenuInfo m : menuList) {
			System.out.println(m);
		}
	}
}
