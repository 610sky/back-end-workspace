package com.kh.example.practice2;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.example.practice2.controller.MusicListController;
import com.kh.example.practice2.model.Music;

public class Application {
	Scanner sc = new Scanner(System.in);
	MusicListController mlc = new MusicListController();
	
	public static void main(String[] args) {
		Application app = new Application();
		app.mainMenu();
	}
	public void mainMenu() {
		boolean check = true;
		
		while(check) {
			System.out.println("====메인 메뉴====");
			System.out.println("1. 마지막 위치에 곡 추가");
			System.out.println("2. 첫 위치에 곡 추가");
			System.out.println("3. 전체 곡 목록 출력");
			System.out.println("4. 특정 곡 검색");
			System.out.println("5. 특정 곡 삭제");
			System.out.println("6. 특정 곡 수정");
			System.out.println("7. 가수 명 내림차순 정렬");
			System.out.println("8. 곡 명 오름차순 정렬");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 입력 : ");
			
			try {
				int select = Integer.parseInt(sc.nextLine());
				
				switch(select) {
				case 1:
					addMusicLast();
					System.out.println("추가 성공");
					break;
				case 2:
					addMusicFirst();
					System.out.println("추가 성공");
					break;
				case 3:
					mlc.info();
					break;
				case 4:
					searchTitle();
					break;
				case 5:
					removeMusic();
					break;
				case 6:
					updateMusic();
					break;
				case 7:
					break;
				case 8:
					check = false;
					break;
				case 9:
					check = false;
					System.out.println("종료");
					break;
				}
			} catch(Exception e) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	public void addMusicLast() {
		Music m = new Music();
		System.out.println("****** 마지막 위치에 곡 추가 ******");
		System.out.print("곡 명 : ");
		m.setTitle(sc.nextLine());
		System.out.print("가수 명 : ");
		m.setName(sc.nextLine());
		
		mlc.addLast(m);
	}
	public void addMusicFirst() {
		Music m = new Music();
		System.out.println("****** 첫 위치에 곡 추가 ******");
		System.out.print("곡 명 : ");
		m.setTitle(sc.nextLine());
		System.out.print("가수 명 : ");
		m.setName(sc.nextLine());
		
		mlc.addFirst(m);
	}
	public void searchTitle() {
		System.out.println("****** 특정 곡 검색 ******");
		System.out.print("검색할 곡 명 : ");
		String title = sc.nextLine();
		
		mlc.search(title);
	}
	public void updateMusic() {
		System.out.println("****** 특정 곡 수정 ******");
		System.out.print("검색할 곡 명 : ");
		String title = sc.nextLine();
		System.out.print("수정할 곡 명 : ");
		String updateTitle = sc.nextLine();
		System.out.print("수정할 가수 명 : ");
		String updateName = sc.nextLine();
		
		mlc.update(title,updateTitle,updateName);
	}
	public void removeMusic() {
		System.out.println("****** 특정 곡 삭제 ******");
		System.out.print("삭제할 곡 명 : ");
		String title = sc.nextLine();
		
		mlc.remove(title);
	}
}
