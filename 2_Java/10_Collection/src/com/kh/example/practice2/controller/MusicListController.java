package com.kh.example.practice2.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.kh.example.practice2.model.Music;

public class MusicListController {
	private Music m = new Music();
	private List<Music> musicList = new ArrayList<>();
	private List<Music> tmp = new ArrayList<>();
	
	public Music getM() {
		return m;
	}
	public void setM(Music m) {
		this.m = m;
	}
	public List<Music> getMusicList() {
		return musicList;
	}
	
	public void addLast(Music m) {
		musicList.add(m);
		tmp.add(m);
	}
	public void addFirst(Music m) {
		musicList.add(0,m);
		tmp.add(0,m);
	}
	
	public void search(String title) {
		int count = 0;
		for(Music m : musicList) {
			if(m.getTitle().contains(title)) {
				System.out.printf("%s - %s 을 검색 했습니다.\n",m.getName(),m.getTitle());
				count++;
			}
		}
		if(count==0) {
			System.out.println("곡을 찾지 못했습니다.");
		}
	}
	
	public void update(String title, String updateTitle, String updateName) {
		int count = 0;
		for(Music m : musicList) {
			if(m.getTitle().contains(title)) {
				System.out.printf("%s - %s의 값이 변경 되었습니다.\n",m.getName(),m.getTitle());
				
				m.setTitle(updateTitle);
				m.setName(updateName);
				count++;
			}
		}
		if(count==0) {
			System.out.println("수정할 곡을 찾지 못했습니다.");
		}
	}
	
	public void remove(String title) {
		int count = 0;
		for(Music m : musicList) {
			if(m.getTitle().equals(title)) {
				System.out.printf("%s - %s 을 삭제 했습니다.\n",m.getName(),m.getTitle());
				
				musicList.remove(m);
				tmp.remove(m);
				count++;
				break;
			}
		}
		if(count==0) {
			System.out.println("삭제할 곡이 없습니다.");
		}
	}
	
	public void info() {
		System.out.println("****** 전체 곡 목록 출력 ******");
		for(Music m : musicList) {
			System.out.println(m.getName() + " - " + m.getTitle());
		}
	}
	
	public void infoNameSort() {
		System.out.println("****** 가수 명 내림차순 정렬 ******");
		for(Music m : tmp) {
			System.out.println(m.getName() + " - " + m.getTitle());
		}
	}
	
	public void infoTitleSort() {
		System.out.println("****** 곡 명 오름차순 정렬 ******");
		for(Music m : tmp) {
			System.out.println(m.getName() + " - " + m.getTitle());
		}
	}
	
	public void nameSort() {
		Collections.sort(tmp, new MusicNameComparator());
		infoNameSort();
	}
	
	public void titleSort() {
		Collections.sort(tmp, new MusicTitleComparator());
		infoTitleSort();
	}
	
	class MusicNameComparator implements Comparator<Music>{
		@Override
		public int compare(Music o1, Music o2) {
			return o2.getName().compareTo(o1.getName());
		}
	}
	
	class MusicTitleComparator implements Comparator<Music>{
		@Override
		public int compare(Music o1, Music o2) {
			return o1.getTitle().compareTo(o2.getTitle());
		}
	}
}
