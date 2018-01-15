package com.iot.test.dao;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.iot.test.vo.ClassInfo;

public interface ClassDao {
	public ArrayList<ClassInfo> selectClassList(HttpServletRequest req);
}
