package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import config.ServerInfo;

public class DBConnectionTest4 {
	
	public static void main(String[] args) {
		
		try {
			Properties p = new Properties();
			p.load(new FileInputStream("src/config/jdbc.properties"));
			
			// 1. 드라이버 로딩
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("1. 드라이버 로딩...!");
			
			// 2. 데이터베이스 연결
			Connection conn = DriverManager.getConnection(
					ServerInfo.URL,ServerInfo.USER,ServerInfo.PASSWORD);
			System.out.println("2. 데이터베이스와 연결...!");
			
			// 3. PreparedStatement - DELETE (emp_id로 삭제)
			String query = p.getProperty("delete");
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, 900);
			
			// 4. 쿼리문 실행
			System.out.println(ps.executeUpdate() + "명 삭제");
						
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}
}
