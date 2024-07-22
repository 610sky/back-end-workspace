package com.kh.tmp.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.tmp.model.vo.Member;
import com.kh.tmp.model.vo.Rent;
import com.kh.tmp.model.dao.MemberDAO;
import com.kh.tmp.model.dao.RentDAO;

public class MemberController {
	private MemberDAO member = new MemberDAO();
	private RentDAO rent = new RentDAO();
	
	// 4. 회원가입
	public boolean registerMember(String id, String password, String name) {
		try {
			member.registerMember(id, password, name);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	// 5. 로그인
	public Member login(String id, String password) {
		try {
			Member m = member.login(id, password);
			if(m.getStatus()=='N') {
				return m;
			}
		} catch (SQLException e) {
			return null;
		}
		return null;
	}
	
	// 4. 회원탈퇴
	public boolean deleteMember(int memberNo) {
		// 회원탈퇴할 때 대여중인 책 있으면 탈퇴 못하게
		try {
//			ArrayList<Rent> bookList = rent.printRentBook(memberNo);
//			if(bookList.size() > 0)
//				return false;
			
			// 회원탈퇴시 대여중인 책들 모두 기록 삭제 -> DELETE 조건 CASCADE!
			if(member.deleteMember(memberNo)==1) {				
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
