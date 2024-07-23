package com.kh.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.vo.Member;

public class MemberDAO {
	public MemberDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Connection connect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/member","root","qwer1234");
	}
	public void close(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}
	public void close(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		close(ps,conn);
		rs.close();
	}
	// 회원가입 - member 스키마의 member 테이블
	public void registerMember(String id, String pwd, String name) throws SQLException {
		// 중복 여부 판단 -> boolean 값으로 리턴
		// Servlet?에서 체크! 결과 페이지에 값에 따라서 바꾸고 싶음
		// 결과 페이지에서 boolean 결과 페이지에서도 받을 수 있고
		// Servlet에서 해결할 수도 있고! -> 결과 페이지 따로 만들어서
		Connection conn = connect();
		String query="INSERT INTO member VALUES(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, pwd);
		ps.setString(3, name);
		
		ps.executeUpdate();
		
		close(ps,conn);
	}
	
	public ArrayList<Member> printMember() throws SQLException {
		Connection conn = connect();
		String query="SELECT * FROM member";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Member> member = new ArrayList<>();
		
		while(rs.next()) {
			member.add(new Member(rs.getString("id"),
								  rs.getString("password"),
								  rs.getString("name")));
		}
		
		close(rs,ps,conn);
		return member;
	}
	
	public Member searchMember(String id) throws SQLException {
		Connection conn = connect();
		String query="SELECT * FROM member WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		Member member = null;
		
		if(rs.next()) {
			member = new Member(id,
								rs.getString("password"),
								rs.getString("name"));
		}
		
		close(rs,ps,conn);
		return member;
	}
}
