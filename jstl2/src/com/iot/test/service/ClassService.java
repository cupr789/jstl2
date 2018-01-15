package com.iot.test.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iot.test.vo.ClassInfo;

public interface ClassService {
	public List<ClassInfo> getClassList(HttpServletRequest req);
	
}
