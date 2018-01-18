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
	public List<Customer> selectCustomerList(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String orderStr = req.getParameter("order");
		System.out.println(orderStr);
		String flag = req.getParameter("flag");
		System.out.println(flag);
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		try {
			con = DBCon.getCon();
			String sql = "select * from customer ";
			
			  if(orderStr!=null) { if(flag.equals("1")) { 
				  sql+=" order by "+orderStr; 
				  }
			  if(flag.equals("2")){ 
				  sql+=" order by "+orderStr+" desc"; 
				  } 
			  }
			 

/*			if (flag != null) {
				sql += "order by ";
				int fidx = flag.indexOf(",");
				String partFlag = flag.substring(0, fidx);
				flag.replace(partFlag, "");
				if (partFlag.indexOf("asc") != -1) {
					partFlag = partFlag.substring(0, partFlag.indexOf("asc") - 1) + " desc,";
				}
				else {
					partFlag = partFlag.substring(0, partFlag.indexOf("desc") - 1) + " asc,";
				}
				sql += partFlag + flag;
				System.out.println("sql = " +sql);
			}*/
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
		} finally {
			DBUtil.closeAll(rs, con, ps);
		}

		return customerList;

	}

}
