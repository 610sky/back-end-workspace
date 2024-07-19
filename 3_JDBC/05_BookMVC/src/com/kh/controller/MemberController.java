package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.model.Member;

public class MemberController {
	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/sample";
	public static final String USER = "root";
	public static final String PASSWORD = "qwer1234";
	
	public boolean registerMember(String id, String password, String name) {
		try {
			Connection conn = getConnect();
			String query="INSERT INTO member(member_id, member_pwd, member_name) VALUES (?, ?, ?)";
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
			String query="SELECT * FROM member WHERE member_id = ?";
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
	public boolean search(String id, String password) {
		try {
			Connection conn = getConnect();
			String query="SELECT * FROM member WHERE member_id = ? AND member_pwd = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				closeAll(rs,ps,conn);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean searchBook(String title, String author) {
		try {
			Connection conn = getConnect();
			String query="SELECT * FROM book WHERE bk_title = ? OR bk_author = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, title);
			ps.setString(2, author);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				closeAll(rs,ps,conn);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean searchBook(int bk_no) {
		try {
			Connection conn = getConnect();
			String query="SELECT * FROM book WHERE bk_no = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, bk_no);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				closeAll(rs,ps,conn);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public String login(String id, String password) {
		String name = null;
		try {
			Connection conn = getConnect();
			String query="SELECT member_name FROM member WHERE member_id=? AND member_pwd=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				name = rs.getString("member_name");
			
			if(search(id,password)) {
				closeAll(rs,ps,conn);
				return name;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}
	
	public void printBookAll() {
		try {
			Connection conn = getConnect();
			String query="SELECT bk_no, bk_title, bk_author FROM book";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt("bk_no") + ". " + rs.getString("bk_title") + " / " + rs.getString("bk_author"));
			}
			closeAll(rs,ps,conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean registerBook(String title, String author) {
		try {
			Connection conn = getConnect();
			String query="INSERT INTO book(bk_title, bk_author) VALUES(?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, title);
			ps.setString(2, author);
			
			if(!searchBook(title,author)) {
				ps.executeUpdate();
				
				closeAll(ps,conn);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("책을 등록하는데 실패했습니다.");
		return false;
	}
	
	public boolean sellBook(int select) {
		try {
			Connection conn = getConnect();
			String query="DELETE FROM book WHERE bk_no = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, select);
			
			if(searchBook(select)) {
				ps.executeUpdate();
				closeAll(ps,conn);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean rentBook(Member member, int select) {
		/*
		 * 번호를 입력받고 책 대여 시작
		 * 파라미터로 받은 member의 name으로 member_no를 찾고
		 * member_no로 조인해서 rent테이블에서 값들을 뽑고
		 * rent_book_no랑 select랑 대조해서 이미 있으면 대여 불가
		 * 없으면 대여 가능
		 * */
		try {
			Connection conn = getConnect();
			String query="SELECT rent_book_no, member_name FROM rent JOIN book ON (bk_no = rent_book_no) JOIN member ON(rent_mem_no = member_no) WHERE member_name = ? AND rent_book_no = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, member.getName());
			ps.setInt(2, select);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				closeAll(rs,ps,conn);
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String query2="INSERT INTO rent(rent_mem_no,rent_book_no,rent_date) VALUES(?,?,?)";
		return true;
	}
	
	
	
	
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
}
