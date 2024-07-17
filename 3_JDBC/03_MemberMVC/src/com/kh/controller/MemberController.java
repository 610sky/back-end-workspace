package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.model.Member;

public class MemberController {
	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/member";
	public static final String USER = "root";
	public static final String PASSWORD = "qwer1234";
	
	public Connection getConnect() {
		try {
			Class.forName(DRIVER_NAME);
			return DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps,conn);
	}
	
	public boolean signUp(String id, String password, String name) {
		// 회원가입 기능 구현! 
		// -> 아이디가 기존에 있는지 체크 여부!
		// -> member 테이블에 데이터 추가! 
		
		try {
			Connection conn = getConnect();
			String query="INSERT INTO member VALUES (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			
			if(search(id)) {
				ps.setString(1, id);
				ps.setString(2, password);
				ps.setString(3, name);
				
				int result = ps.executeUpdate();
				if(result == 1) {
					closeAll(ps,conn);
					// 중복아님
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 중복발생
		return false;
	}
	
	// 아이디 중복 검색
	public boolean search(String id) {
		try {
			Connection conn = getConnect();
			String query="SELECT * FROM member WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				closeAll(rs,ps,conn);
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	// 아이디, 비밀번호 검색
	public boolean search(String id, String password) {
		try {
			Connection conn = getConnect();
			String query="SELECT * FROM member WHERE id = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				closeAll(rs,ps,conn);
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public String login(String id, String password) {
		// 로그인 기능 구현! 
		// -> member 테이블에서 id와 password로 멤버 정보 하나 가져오기!
		String name = null;
		
		try {
			Connection conn = getConnect();
			String query="SELECT name FROM member WHERE id = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				name = rs.getString("name");
				
				closeAll(rs,ps,conn);
				return name;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}
	
	public boolean changePassword(String id, String password, String newPassword, String name) {
		// 비밀번호 바꾸기 기능 구현!
		// -> login 메서드 활용 후 사용자 이름이 null이 아니면 member 테이블에서 id로 새로운 패스워드로 변경

		try {
			Connection conn = getConnect();
			String query="UPDATE member SET password = ? WHERE id = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			if(name != null) {
				ps.setString(1, newPassword);
				ps.setString(2, id);
				ps.setString(3, password);
				
				int result = ps.executeUpdate();
				if(result == 1) {
					closeAll(ps,conn);
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public String changeName(String id, String password, String name) {
		// 이름 바꾸기 기능 구현!
		// -> member 테이블에서 id로 새로운 이름으로 변경 
		try {
			Connection conn = getConnect();
			String query="UPDATE member SET name = ? WHERE id = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			if(name != null && name != "") {
				ps.setString(1, name);
				ps.setString(2, id);
				ps.setString(3, password);
				
				int result = ps.executeUpdate();
				if(result == 1) {
					closeAll(ps,conn);
					return name;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}









