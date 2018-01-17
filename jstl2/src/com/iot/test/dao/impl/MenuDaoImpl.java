package com.iot.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iot.test.common.DBCon;
import com.iot.test.dao.MenuDao;
import com.iot.test.test.DBConTest;
import com.iot.test.utils.DBUtil;
import com.iot.test.vo.MenuInfo;

public class MenuDaoImpl implements MenuDao{

	@Override
	public List<MenuInfo> selectMenuList() {
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<MenuInfo> menuList = new ArrayList<MenuInfo>();
		String sql = "select * from menu order by mNum";
		
		try {
			con = DBConTest.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				MenuInfo mi = new MenuInfo();
				mi.setmNum(rs.getInt("mNum"));
				mi.setmName(rs.getString("mName"));
				mi.setmDesc(rs.getString("mDesc"));
				mi.setmUrl(rs.getString("mUrl"));
				menuList.add(mi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, con, ps);
		}
		return menuList;
	}

}
