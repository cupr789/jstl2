package com.iot.test.dao;

import java.util.ArrayList;
import java.util.List;

import com.iot.test.vo.MenuInfo;

public interface MenuDao {
	public List<MenuInfo> selectMenuList();
}
