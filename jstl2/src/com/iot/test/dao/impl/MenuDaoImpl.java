package com.iot.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iot.test.common.DBCon;
import com.iot.test.dao.MenuDao;
import com.iot.test.test.DBConTest;
import com.iot.test.utils.DBUtil;
import com.iot.test.vo.MenuInfo;

public class MenuDaoImpl implements MenuDao {

	@Override
	public List<MenuInfo> selectMenuList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<MenuInfo> menuList = new ArrayList<MenuInfo>();
		String sql = "select * from menu order by mNum";

		try {
			con = DBConTest.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				MenuInfo mi = new MenuInfo();
				mi.setmNum(rs.getInt("mNum"));
				mi.setmName(rs.getString("mName"));
				mi.setmDesc(rs.getString("mDesc"));
				mi.setmUrl(rs.getString("mUrl"));
				menuList.add(mi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, con, ps);
		}
		return menuList;
	}

	@Override
	public int updateMenuList(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "update menu set mName=?,mUrl=?,mDesc=? where mNum=?";
		try {
			con = DBCon.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, req.getParameter("updateName"));
			ps.setString(2, req.getParameter("updateUrl"));
			ps.setString(3, req.getParameter("updateDesc"));
			ps.setInt(4, Integer.parseInt(req.getParameter("updateId")));

			result = ps.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con);
			DBUtil.close(ps);
		}

		return result;
	}

	@Override
	public int deleteMenu(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "delete from menu where mNum=?";
		try {
			con = DBCon.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(req.getParameter("deleteId")));
			result = ps.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con);
			DBUtil.close(ps);
		}
		return result;
	}

	@Override
	public List<MenuInfo> selectMenuSearch(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<MenuInfo> menuList = new ArrayList<MenuInfo>();
		String searchType = req.getParameter("searchType");
		String searchStr = req.getParameter("searchStr");

		String sql = "select * from menu ";
		try {
			
			con = DBCon.getCon();
			if (searchStr != null && searchStr != "") {
				sql += "where " + searchType + "=?";
				ps = con.prepareStatement(sql);
				ps.setString(1, searchStr);
			}else {				
				ps = con.prepareStatement(sql);
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				MenuInfo mi = new MenuInfo();
				mi.setmNum(rs.getInt("mNum"));
				mi.setmName(rs.getString("mName"));
				mi.setmDesc(rs.getString("mDesc"));
				mi.setmUrl(rs.getString("mUrl"));
				menuList.add(mi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, con, ps);
		}
		return menuList;
	}

	@Override
	public int insertMenu(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "insert into menu(mName,mUrl,mDesc) values(?,?,?)";
		try {
			con = DBCon.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, req.getParameter("mName"));
			ps.setString(2, req.getParameter("mUrl"));
			ps.setString(3, req.getParameter("mDesc"));
			result = ps.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con);
			DBUtil.close(ps);
		}
		return result;
	}

}
