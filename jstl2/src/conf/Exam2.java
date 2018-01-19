package conf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.iot.test.common.MybatisSessionFactory;
import com.iot.test.vo.Customer;

public class Exam2 {
	public static void main(String[] args) {
		SqlSessionFactory ssf = MybatisSessionFactory.getSqlSessionFactory();
		SqlSession ss = ssf.openSession(); // openSession() 디폴트는 false다 -> autocommit의 상태값
		Customer c = new Customer();
		c.setCustomerName("김명재");
		c.setCustomerID(1);
		System.out.println(ss.update("customer.updateCustomer", c));
		ss.commit();
		Map<String,String> map = new HashMap<String,String>();
		map.put("str", "customerid desc");
		List<Customer> ctList = ss.selectList("customer.selectCustomer", map);

		for(Customer customer : ctList) {
			System.out.println(customer);
		}
		
	}
}
