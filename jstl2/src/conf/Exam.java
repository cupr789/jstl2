package conf;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class Exam {

		public void init() throws ClassNotFoundException, SQLException {
			InputStream in = this.getClass().getResourceAsStream("/conf/dbconf.properties");
			Properties prop = new Properties();
			try {
				prop.load(in);
				Iterator<Object> it = prop.keySet().iterator();
				Class.forName(prop.getProperty("driver"));
				String url = prop.getProperty("url");
				String id = prop.getProperty("id");
				String pwd = prop.getProperty("pwd");
				Connection con = DriverManager.getConnection(url,id,pwd);
				String sql = "select * from customer";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					System.out.println(rs.getString("customerName"));
				}
				System.out.println("���Ἲ��");
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			System.out.println("�� ���� �����̴�!! ���α׷��� ����������!!");
			Exam e =new Exam();
			e.init();
		}
}
