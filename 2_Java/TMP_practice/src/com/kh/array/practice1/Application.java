package com.kh.array.practice1;

import java.util.Scanner;

import com.kh.array.practice1.model.Book;
import com.kh.array.practice1.model.Member;

public class Application {
	Scanner sc = new Scanner(System.in);
	Member member = new Member();
	Book[] books = {new Book(), new Book(), new Book(), new Book()}; 
	public static void main(String[] args) {
		Application app = new Application();
		app.menu();
	}
	public void menu() {
		boolean check = true;
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		member.setName(name);
		System.out.print("나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		member.setAge(age);
		
		while(check) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 대여하기");
			System.out.println("3. 프로그램 종료하기");
			System.out.print("메뉴 번호 : ");
			int number = Integer.parseInt(sc.nextLine());
			
			switch(number) {
			case 1:
				System.out.println(member);
				break;
			case 2:
				break;
			case 3:
				check = false;
				System.out.println("종료");
				break;
			}
		}
	}
}
