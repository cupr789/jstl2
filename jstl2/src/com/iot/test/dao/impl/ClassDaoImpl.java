package com.iot.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.iot.test.common.DBCon;
import com.iot.test.dao.ClassDao;
import com.iot.test.utils.DBUtil;
import com.iot.test.vo.ClassInfo;

public class ClassDaoImpl implements ClassDao{

	@Override
	public ArrayList<ClassInfo> selectClassList(HttpServletRequest req) {
		String conditionWord = req.getParameter("inputText");
		System.out.println(conditionWord+"            ??");
		PreparedStatement ps= null;
		ResultSet rs = null;
		Connection con = null;
		ArrayList<ClassInfo> classList = new ArrayList<ClassInfo>();
		String sql = "select * from class_info";

		try {
			
			con = DBCon.getCon();
			ps = con.prepareStatement(sql);
			if(conditionWord!=null) {
				sql+=" where ciname like ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, "%"+conditionWord+"%");
			}
			rs = ps.executeQuery();
			while(rs.next()) {
				ClassInfo ci = new ClassInfo();
				ci.setCiNo(rs.getInt("cino"));
				ci.setCiName(rs.getString("ciname"));
				ci.setCiDesc(rs.getString("cidesc"));				
				classList.add(ci);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, con, ps);
		}
		
		return classList;
	}
	
}
