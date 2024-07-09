package com.kh.polymorphism.practice1;

import java.util.Scanner;

import com.kh.polymorphism.practice1.controller.BookController;
import com.kh.polymorphism.practice1.model.Book;

public class Application {
	Scanner sc = new Scanner(System.in);
	BookController bc = new BookController();
	
	public static void main(String[] args) {
		Application app = new Application();
		app.mainMenu();
	}
	public void mainMenu() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		bc.add(name,age);
		
		boolean check = true;
		while(check) {
			System.out.println("====메뉴====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 대여하기");
			System.out.println("3. 프로그램 종료하기");
			System.out.print("메뉴 번호 : ");
			int select = Integer.parseInt(sc.nextLine());
			
			switch(select) {
			case 1:
				bc.memberInfo();
				break;
			case 2:
				if(bc.getCount() > 1) {
					System.out.println("더 이상 대여할 수 없습니다.");
				}
				else	
					borBook();
				break;
			case 3:
				check=false;
				break;
			}
		}
	}
	public void borBook() {
		bc.bookInfo();
		System.out.print("대여할 도서 번호 선택 : ");
		int select = Integer.parseInt(sc.nextLine());
		
		if(bc.checkAge(select)) {
			System.out.println("나이 제한으로 대여 불가능입니다.");
		}
		else if(bc.checkBook(select)) {
			System.out.println("이미 대여한 책입니다.");
		}
		else {
			bc.setBookList(select);
			System.out.println("성공적으로 대여되었습니다.");
		}
	}
}
