package com.kh.polymorphism.practice1.controller;

import com.kh.polymorphism.practice1.model.Book;
import com.kh.polymorphism.practice1.model.Member;

public class BookController {
	private Member m = new Member();
	private Book[] book = {
			new Book("밥을 지어요",true,0),
			new Book("오늘은 아무래도 덮밥",false,0),
			new Book("원피스 108",false,15),
			new Book("귀멸의 칼날 23",false,19)
	};
	private int count=0;
	
	public void add(String name, int age) {
		m.setName(name);
		m.setAge(age);
	}
	public void setBookList(int number) {
			m.getBookList()[count] = book[number-1];
			count++;
			if(book[number-1].isCoupon()) {
				m.setCoupon(m.getCoupon()+1);
			}
	}
	public boolean checkAge(int number) {
		if(m.getAge() < book[number-1].getAccessAge()) {
			return true;
		}
		return false;
	}
	public boolean checkBook(int number) {
			for(int i=0; i<m.getBookList().length; i++) {
				if(m.getBookList()[i] != null)
					if(book[number].getTitle().equals(m.getBookList()[i].getTitle()))
						return true;
		}
		return false;
	}
	
	public void memberInfo() {
		System.out.println(m);
	}
	public void bookInfo() {
		for(int i = 0; i < book.length; i++) {
			System.out.println(i+1 + "번 도서 : " + book[i]);
		}
	}
	public int getCount() {
		return this.count;
	}
}
