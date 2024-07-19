package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.vo.Book;
import com.kh.model.vo.Publisher;

/*
 * DAO(Data Access Object)
 * - DB에 접근하는 역할을 하는 객체 (CRUD)
 * */

public class BookDAO {
	
	public BookDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Connection connect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","qwer1234");
	}
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}
	public void closeAll(ResultSet rs,PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps,conn);
	}
	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll() throws SQLException {
		Connection conn = connect();
		String query="SELECT * FROM book LEFT JOIN publisher ON (pub_no = bk_pub_no);";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		ArrayList<Book> list = new ArrayList<>();
		
		while(rs.next()) {
			Book book = new Book();
			book.setBkNo(rs.getInt("bk_no"));
			book.setBkTitle(rs.getString("bk_title"));
			book.setBkAuthor(rs.getString("bk_author"));
			
			Publisher publisher = new Publisher();
			publisher.setPubName(rs.getString("pub_name"));
			book.setPublihser(publisher);
			
			list.add(book);
		}
		closeAll(rs,ps,conn);
		return list;
	}
}
