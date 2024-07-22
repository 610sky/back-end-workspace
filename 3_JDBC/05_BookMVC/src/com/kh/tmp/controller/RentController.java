package com.kh.tmp.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.tmp.model.dao.RentDAO;
import com.kh.tmp.model.vo.Rent;

public class RentController {
	private RentDAO rent = new RentDAO();
	
	// 1. 책대여
	public boolean rentBook(int memberNo, int bookNo) {
		try {
			if(!rent.checkRentBook(bookNo)) {
				rent.rentBook(memberNo, bookNo);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 2. 대여한 책 조회
	public ArrayList<Rent> printRentBook(int memberNo) {
		try {
			return rent.printRentBook(memberNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	// 3. 대여 취소
	public boolean deleteRent(int no) {
		try {
			if(rent.deleteRent(no)==1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
