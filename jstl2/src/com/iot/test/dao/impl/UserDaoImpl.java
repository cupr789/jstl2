package com.iot.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iot.test.common.DBCon;
import com.iot.test.dao.UserDao;
import com.iot.test.utils.DBUtil;
import com.iot.test.vo.UserInfo;

public class UserDaoImpl implements UserDao{

	@Override
	public List<UserInfo> selectUserList(UserInfo ui) {
		List<UserInfo> userList = new ArrayList<UserInfo>();
		String sql = "select * from user_info where 1=1";
		if(ui!=null) {
			sql+="and uiname like ?";
		}
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		try {
			con=DBCon.getCon();
			ps= con.prepareStatement(sql);
			if(ui!=null) {
				ps.setString(1, "%"+ui.getUiName()+"%");
			}
			rs=ps.executeQuery();
			while(rs.next()) {
				UserInfo userInfo=new UserInfo();
				userInfo.setUiNo(rs.getInt("uino"));
				userInfo.setUiName(rs.getString("uiname"));
				userInfo.setUiAge(rs.getInt("uiage"));
				userInfo.setUiId(rs.getString("uiid"));
				userInfo.setUiPwd(rs.getString("uipwd"));
				userInfo.setAddress(rs.getString("address"));
				userInfo.setUiRegDate(rs.getString("uiregdate"));
				userInfo.setCiNo(rs.getInt("cino"));
				userList.add(userInfo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(rs, con, ps);
			
		}
		return userList;
	}

	@Override
	public UserInfo selectUser(UserInfo ui) {
		return null;
	}

	@Override
	public int insertUser(UserInfo ui) {
		return 0;
	}

	@Override
	public int updateUser(UserInfo ui) {
		return 0;
	}

	@Override
	public int deleteUser(UserInfo ui) {
		return 0;
	}

}
