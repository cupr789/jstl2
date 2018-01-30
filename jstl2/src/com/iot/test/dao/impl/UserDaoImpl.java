package com.iot.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.log4j.Log4jImpl;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import com.iot.test.common.DBCon;
import com.iot.test.common.MybatisSessionFactory;
import com.iot.test.dao.UserDao;
import com.iot.test.utils.DBUtil;
import com.iot.test.vo.UserInfo;

public class UserDaoImpl implements UserDao{
	
	private static Logger log = Logger.getLogger(UserDaoImpl.class);
	
	@Override
	public List<UserInfo> selectUserList(UserInfo ui) {
		List<UserInfo> userList = new ArrayList<UserInfo>();
		SqlSessionFactory ssf = MybatisSessionFactory.getSqlSessionFactory();
		SqlSession ss = ssf.openSession();
		Map<String,String> map = new HashMap<String,String>();
		map.put("str", "uino");
		log.info("DAO시작");
		userList = ss.selectList("user.selectUserList",map);
		log.info("DAO종료");
		
/*		String sql = "select * from user_info where 1=1";
		if(ui!=null) {
			sql+= " and ";
			sql+= ui.getSearchType();
			sql+= " like ?";
		}
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		try {
			log.info("DAO 시작");
			con=DBCon.getCon();
			ps= con.prepareStatement(sql);
			if(ui!=null && !ui.getUiName().equals("")) {
				String searchStr = ui.getUiName();
				if(ui.getSearchType().equals("uiAge")) {
					searchStr = ""+ui.getUiAge();
				}else if(ui.getSearchType().equals("address")) {
					searchStr = ui.getAddress();
				}
				
				ps.setString(1, "%"+searchStr+"%");
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
			
		}log.info("DAO 종료");*/
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
