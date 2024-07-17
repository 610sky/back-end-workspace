package person.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import person.model.Person;

public class PersonController {
	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/sample";
	public static final String USER = "root";
	public static final String PASSWORD = "qwer1234";
	// 리턴 타입이나 매개변수(파라미터) 자유롭게 변경 가능!
	// 메서드 추가 가능! <-- 추천!!
	/*
	 * 1. 드라이버 로딩
	 * 2. DB 연결
	 * 3. PreparedStatement - 쿼리
	 * 4. 쿼리 실행
	 * */
	
	public Connection connect() {
		try {
			// 1. 드라이버 로딩
			Class.forName(DRIVER_NAME);
			
			// 2. 데이터베이스 연결
			Connection conn = DriverManager.getConnection(
					URL, USER, PASSWORD);
			return conn;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// 변동적인 반복 -- 비즈니스 로직 DAO(Database Access Object)
	
	// person 테이블에 데이터 추가 - INSERT
	public void addPerson(int id, String name, int age, String addr) {
		try {
			String query = "INSERT INTO person(id, name, age, addr) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = connect().prepareStatement(query);
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);
			ps.setString(4, addr);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// person 테이블에 데이터 수정 - UPDATE
	public void updatePerson(int id, String name, int age, String addr) {
		try {
			String query = "UPDATE person SET name = ?, age = ?, addr = ? WHERE id = ?";
			PreparedStatement ps = connect().prepareStatement(query);
			
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, addr);
			ps.setInt(4, id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// person 테이블에 데이터 삭제 - DELETE
	public void removePerson(int id) {
		try {
			String query = "DELETE FROM person WHERE id = ?";
			PreparedStatement ps = connect().prepareStatement(query);
			
			ps.setInt(1,id);
			
			ps.executeUpdate();
			
			/*
			 * int result = ps.executeUpdate();
			 * 
			 * closeAll(ps,conn);
			 * return result;
			 * */
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// person 테이블에 있는 데이터 전체 보여주기 - SELECT
	public void searchAllPerson() {
		try {
			String query = "SELECT * FROM person";
			PreparedStatement ps = connect().prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String addr = rs.getString("addr");
				
				System.out.println(id + " / " + name + " / " + 
				age + " / " + addr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// person 테이블에서 데이터 한개만 가져오기 - SELECT
	public void searchPerson(int id) {
		try {
			String query = "SELECT * FROM person WHERE id = ?";
			PreparedStatement ps = connect().prepareStatement(query);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String addr = rs.getString("addr");
				
				System.out.println(id + " / " + name + " / " + 
				age + " / " + addr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String searchNamePerson(int id) {
		try {
			String query = "SELECT name FROM person WHERE id = ?";
			PreparedStatement ps = connect().prepareStatement(query);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("name");
				return name;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
//	public ArrayList<Person> searchAllPerson2() {
//		try {
//			String query = "SELECT * FROM person";
//			PreparedStatement ps = connect().prepareStatement(query);
//			
//			ResultSet rs = ps.executeQuery();
//			
//			ArrayList<Person> list = new ArrayList<>();
//			
//			while(rs.next()) {
//				Person person = new Person();
//				person.setId(rs.getInt("id"));
//				person.setName(rs.getString("name"));
//				person.setAge(rs.getInt("age"));
//				person.setAddr(rs.getString("addr"));
//				list.add(person);
//			}
//			
//			closeAll(rs,ps,conn);
//			
//			return list;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//	public String updatePerson2(Person person) throws SQLException {
//		Connection conn = getConnect();
//		
//		String query = "~~";
//		PreparedStatement ps = conn.prepareStatement(query);
//		
//		ps.setString(1, person.getName());
//		ps.setString(1, person.getName());
//		ps.setString(1, person.getName());
//		
//		ps.executeUpdate();
//		
//		if(ps.executeUpdate() == 1) {
//			return person.getName();
//		}
//		return null;
//	}
//	
//	// 고정적인 반복 -- DB 연결, 자원 반납 -> 공통적인 메서드 정의.. 메서드마다 호출해서 사용!
//	public Connection getConnect() {
//		try {
//			// 1. 드라이버 로딩
//			Class.forName(DRIVER_NAME);
//			// 2. 데이터베이스 연결
//			return DriverManager.getConnection(
//					URL, USER, PASSWORD);
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//	public Person searchPerson2(int id) {
//		try {
//			String query = "SELECT * FROM person WHERE id = ?";
//			PreparedStatement ps = connect().prepareStatement(query);
//			
//			ps.setInt(1, id);
//			
//			ResultSet rs = ps.executeQuery();
//			
//			Person person = null;
//			
//			if(rs.next()) {
//				person = new Person(rs.getInt("id"),
//									rs.getString("name"),
//									rs.getInt("age"),
//									rs.getString("addr"));
//			}
//			
//			closeAll(rs,ps,conn);
//			
//			return person;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
//		rs.close();
//		closeAll(ps,conn);
//	}
	
//	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
//		ps.close();
//		conn.close();
//	}
}
