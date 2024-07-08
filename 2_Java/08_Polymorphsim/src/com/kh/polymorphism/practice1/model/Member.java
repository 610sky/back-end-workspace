package com.kh.polymorphism.practice1.model;

import java.util.Arrays;

public class Member{
	private String name;
	private int age;
	private int coupon = 0;
	private Book[] bookList = new Book[2];
	
	public Member() {
	}
	public Member(String name, int age, int coupon) {
		this.name = name;
		this.age = age;
		this.coupon = coupon;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getCoupon() {
		return coupon;
	}
	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}
	public Book[] getBookList() {
		return bookList;
	}
	public void setBookList(Book book, int index) {
		bookList[index] = book;
	}
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", coupon=" + coupon + ", bookList="
				+ Arrays.toString(bookList) + "]";
	}
}
