package com.kh.variable;

public class C_Printf {

	public static void main(String[] args) {
		// System.out.print(출력하고자하는값); -- 출력만 함 (줄바꿈 발생 X)
		// System.out.println(출력하고자하는값); -- 출력 후 줄바꿈 발생 O
		System.out.print("hello\n");
		System.out.println("hello");
		
		System.out.println("----------------------");
		
		// System.out.printf("출력하고자하는형식(포맷)", 출력하고자하는값, 값, ...);
		// 출력하고자하는 값들이 제시한 형시겡 맞춰서 출력만 진행
		int iNum1 = 10;
		int iNum2 = 20;
		
		// 10% 20%
		System.out.println(iNum1 + "%" + " " + iNum2 + "%");
	}

}
