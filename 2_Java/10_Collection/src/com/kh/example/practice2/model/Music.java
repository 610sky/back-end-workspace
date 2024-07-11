package com.kh.example.practice2.model;

import java.util.Comparator;

public class Music implements Comparable<Music> {
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
	
	class MusicNameComparator implements Comparator<Music>{

		@Override
		public int compare(Music o1, Music o2) {
			return 0;
		}
		
	}

	@Override
	public int compareTo(Music o) {
		return 0;
	}
}
