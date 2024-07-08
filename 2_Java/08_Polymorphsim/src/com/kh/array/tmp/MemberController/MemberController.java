package com.kh.array.tmp.MemberController;

import java.util.Arrays;

import com.kh.array.tmp.model.Member;

public class MemberController {
	private Member[] member = new Member[3];
	
	public void add(String id, String name, String pwd, String email,
			char gender, int age) {
		for(int i = 0; i < member.length; i++) {
			if(member[i] == null) {
//				Member m = new Member();
//				m.setId(id);
//				m.setName(name);
//				m.setPwd(pwd);
//				m.setEmail(email);
//				m.setGender(gender);
//				m.setAge(age);
//				member[i] = m;
//				member[0].setId(id);
//				member[i].setName(name);
//				member[i].setPwd(pwd);
//				member[i].setEmail(email);
//				member[i].setGender(gender);
//				member[i].setAge(age);
				member[i] = new Member(id,name,pwd,email,gender,age);
				break;
			}
		}
//		member[0] = new Member(id,name,pwd,email,gender,age);
//		member[0].setId(id);
//		member[0].setName(name);
//		member[0].setPwd(pwd);
//		member[0].setEmail(email);
//		member[0].setGender(gender);
//		member[0].setAge(age);
		
	}
	
	public String getIdFromMember(int index) {
		return member[index].getId();
	}
	
	public boolean checkId(String id) {
		boolean checkId2 = false;
	
		for(Member value : member) {
			if(value == null)
				checkId2=false;
			else {
				if(value.getId().equals(id))
					checkId2 = true;
			}
		}
		
		return checkId2;
	}
	
	public boolean checkFull() {
		boolean check = true;
		for(int i = 0; i < member.length; i++) {
			if(member[i] == null)
				check = false;
			else
				check = true;
		}
		return check;
	}
	
	public void modify(int index, String id, String name, String email, String pwd) {
		member[index].setId(id);
		member[index].setName(name);
		member[index].setEmail(email);
		member[index].setPwd(pwd);
	}
	
	public void info() {
		for(Member value : member) {
			System.out.println(value);
		}
	}
}
