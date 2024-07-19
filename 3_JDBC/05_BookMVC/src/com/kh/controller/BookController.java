package com.kh.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.dao.BookDAO;
import com.kh.model.vo.Book;

public class BookController {
	private BookDAO dao = new BookDAO();
	
	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll() {
		try {
			return dao.printBookAll();
		} catch (SQLException e) {
			return null;
		}
	}
}
