package com.kh.practice;

import java.util.Scanner;

public class OperatorPractice {
    
	public static void main(String[] args) {
		OperatorPractice op = new OperatorPractice();
//		op.method1();
//		op.method2();
//		op.method3();
//		op.method4();
//		op.method5();
//		op.method6();
		op.method7();
	}

	Scanner sc = new Scanner(System.in);
	
	//모든 사람이 연필을 골고루 나눠가지려고 한다. 인원 수와 연필 개수를 입력 받고 
	//1인당 동일하게 나눠가진 연필 개수와 나눠주고 남은 연필의 개수를 출력하세요.
	public void method1() {
		System.out.print("인원 수 >");
		int people = sc.nextInt();
		System.out.print("연필 개수 >");
		int pencil = sc.nextInt();
		
		System.out.println("나눠가진 연필 개수 : " + pencil / people);
		System.out.println("남은 연필 개수 : " + pencil % people);
	}
	
	//입력 받은 숫자를 산술 연산자만 사용해서 십의 자리 이하는 버리는 코드를 작성하세요.
	//만약 432이라면 400, 111이라면 100이 출력됩니다.
	public void method2() {
		System.out.print("숫자 >");
		int number = sc.nextInt();
		
		int result = number - number % 100;
		
		System.out.println(result);
	}

	//3개의 수를 입력 받아 입력 받은 수가 모두 같으면 true, 아니면 false를 출력하세요.
	public void method3() {
		System.out.print("첫번째 숫자 >");
		int num1 = sc.nextInt();
		System.out.print("두번째 숫자 >");
		int num2 = sc.nextInt();
		System.out.print("세번째 숫자 >");
		int num3 = sc.nextInt();
		
		boolean result = num1 == num2 && num2 == num3;
		System.out.println(result);
	}

	//입력 받은 하나의 정수가 짝수이면 "짝수다", 짝수가 아니면 "짝수가 아니다"를 출력하세요.
	public void method4() {
		System.out.print("정수 >");
		int number = sc.nextInt();
		
		String result = number % 2 == 0 ? "짝수다" : "짝수가 아니다";
		System.out.println(result);
	}

	//주민번호(-포함)를 입력받아 남자인지 여자인지 구분하여 출력하세요
	public void method5() {
		System.out.print("주민번호(-포함) >");
		String id_num = sc.nextLine();
		
		String result = id_num.charAt(7) == '1' ? "남자" : "여자";
		System.out.println(result);
	}

	//나이를 입력 받아 어린이(13세 이하)인지, 청소년(13세 초과 ~ 19세 이하)인지, 성인(19세 초과)인지 출력하세요.
	public void method6() {
		System.out.print("나이 >");
		int age = sc.nextInt();
		
		String result = age <= 13 ? "13세 이하" :
			age > 13 && age <= 19 ? "13세 초과 ~ 19세 이하" : "19세 초과";
			
		System.out.println(result);
	}

	//사과의 개수와 바구니의 크기(바구니 1개의 들어가는 사과의 개수)를 입력받아
	//필요한 바구니의 수를 출력하세요
	public void method7() {
		System.out.print("사과의 개수 >");
		int apple = sc.nextInt();
		System.out.print("바구니의 크기 >");
		int box_size = sc.nextInt();
		
		int result = (apple / box_size) + 1;
		
		System.out.println("필요한 바구니의 수 : " + result);
	}
	
}