package com.kh.example.practice2;

import java.util.Scanner;

import com.kh.example.practice2.controller.SnackController;

public class Application {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SnackController snack = new SnackController();
		
		// ------------ 화면 ------------
		System.out.println("스낵류를 입력하세요.");
		System.out.print("종류 : ");
		String kind = sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("맛 : ");
		String flavor = sc.nextLine();
		System.out.print("개수 : ");
		int numOf = Integer.parseInt(sc.nextLine());
		System.out.print("가격 : ");
		int price = Integer.parseInt(sc.nextLine());
		// --------------------------------
		// --> 즉, 여기가지는 controller나 model에 직접 접근 X
		
		// 데이터들을 서버한테 요청! 서버한테 전달할 때는 controller로!
		System.out.println(snack.saveData(kind, name, flavor, numOf, price));
		System.out.println(snack.confirmData());
		
		sc.close();
	}

}
