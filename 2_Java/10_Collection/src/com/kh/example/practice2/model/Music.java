package com.kh.example.practice2.model;

import java.util.Comparator;

public class Music {
	private String title;
	private String name;
	
	public Music() {
	}
	public Music(String title, String name) {
		this.title = title;
		this.name = name;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Music [title=" + title + ", name=" + name + "]";
	}
}
