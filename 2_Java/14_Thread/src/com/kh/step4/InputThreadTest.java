package com.kh.step4;

import javax.swing.JOptionPane;

// 프로세스 - 두 쓰레드 간의 Communication은 프로세스의 자원으로 해야 한다.
public class InputThreadTest {
	
	boolean check = false;
	
	public static void main(String[] args) {
		
		InputThreadTest process = new InputThreadTest();
		
		// 1. 데이터 입력 작업
		InputThread it = new InputThread(process);
		it.start();
		
		CountThread count = new CountThread(process);
		count.start();
	}
}
