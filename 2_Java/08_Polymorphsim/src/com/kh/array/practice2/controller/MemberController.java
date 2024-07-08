package com.kh.array.practice2.controller;

import java.util.Arrays;

import com.kh.array.practice2.model.Member;

public class MemberController {
	/*완전 자유롭게*/
	private Member[] mArr = new Member[3];
	public int count = 0;
	
	// 멤버 추가
	public void insertMember(Member m) {
		mArr[count++] = new Member(m.getId(),m.getName(),m.getPwd(),m.getEmail(),m.getGender(),m.getAge());
		System.out.println(Arrays.toString(mArr));
	}
	
	// 멤버 아이디 검색 -> 멤버 index를 아이디로 조회
	public int checkId(String id) {
		for(int i = 0; i < mArr.length; i++) {
			if(mArr[i]!=null && mArr[i].getId().equals(id)) {
				// 기존 멤버 배열에 아이디가 있는 경우!
				return i;
			}
		}
		// 아이디 없는 경우
		return -1;
	}
	public void updateMember(String id, String name, String email, String pwd) {
		// 멤버의 index 찾기!
		int index = checkId(id);
		mArr[index].setName(name);
		mArr[index].setEmail(email);
		mArr[index].setPwd(pwd);
	}
	
	// 멤버 조회
	public Member[] printAll() {
		return mArr;
	}
	
//	public void add(String id, String name, String pwd, String email,
//			char gender, int age) {
////		for(int i = 0; i < member.length; i++) {
////			if(member[i] == null) {
////				member[i].setId(id);
////				member[i].setName(name);
////				member[i].setPwd(pwd);
////				member[i].setEmail(email);
////				member[i].setGender(gender);
////				member[i].setAge(age);
////				break;
////			}
////		}
//		
//		member[0].setId(id);
//		member[0].setName(name);
//		member[0].setPwd(pwd);
//		member[0].setEmail(email);
//		member[0].setGender(gender);
//		member[0].setAge(age);
//		
//	}
//	
//	public String getIdFromMember(int index) {
//		return member[index].getId();
//	}
//	
//	public boolean checkId(String id) {
//		boolean checkId2 = false;
//	
//		for(Member value : member) {
//			
//			if(value == null)
//				checkId2=false;
//			else {
//				if(value.getId().equals(id))
//					checkId2 = true;
//			}
//		}
//		
//		return checkId2;
//	}
//	
//	public boolean checkFull() {
//		boolean check = true;
//		for(int i = 0; i < member.length; i++) {
//			if(member[i] == null)
//				check = false;
//			else
//				check = true;
//		}
//		return check;
//	}
//	
//	public void modify(int index, String id, String name, String email, String pwd) {
//		member[index].setId(id);
//		member[index].setName(name);
//		member[index].setEmail(email);
//		member[index].setPwd(pwd);
//	}
//	
//	public void info() {
//		for(Member value : member) {
//			System.out.println(value);
//		}
//	}
}
