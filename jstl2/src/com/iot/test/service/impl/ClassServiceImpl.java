package com.iot.test.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iot.test.dao.ClassDao;
import com.iot.test.dao.impl.ClassDaoImpl;
import com.iot.test.service.ClassService;
import com.iot.test.vo.ClassInfo;

public class ClassServiceImpl implements ClassService{
	ClassDao cd = new ClassDaoImpl();
	@Override
	public List<ClassInfo> getClassList(HttpServletRequest req) {
		
		return cd.selectClassList(req);
	}

}
