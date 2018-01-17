package com.iot.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iot.test.common.DBCon;
import com.iot.test.dao.CustomerDao;
import com.iot.test.utils.DBUtil;
import com.iot.test.vo.Customer;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public List<Customer> selectCustomerList(String orderStr,String flag) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		try {
			con = DBCon.getCon();
			String sql = "select * from customer";
			if(orderStr!=null) {
				if(flag.equals("1")) {					
					sql+=" order by "+orderStr;
				}
				if(flag.equals("2")){
					sql+=" order by "+orderStr+" desc";
				}
			}
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Customer cs = new Customer();
				cs.setCity(rs.getString("city"));
				cs.setCountry(rs.getString("country"));
				cs.setCustomerName(rs.getString("customername"));
				cs.setCustomerID(rs.getInt("customerID"));
				cs.setFlag(flag);
				customerList.add(cs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, con, ps);
		}

		return customerList;

	}

}
