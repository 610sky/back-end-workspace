package com.kh.tmp.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.tmp.model.vo.Member;
import com.kh.tmp.model.dao.MemberDAO;

public class MemberController {
	private MemberDAO member = new MemberDAO();
	
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
}
