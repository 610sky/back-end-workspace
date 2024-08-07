package com.kh.step4;

import javax.swing.JOptionPane;

public class InputThread extends Thread {
	InputThreadTest process;
	
	public InputThread(InputThreadTest process) {
		this.process = process;
	}
	
	@Override
	public void run() {
		String input = JOptionPane.showInputDialog("최종 로또 번호를 입력하세요..");
		System.out.println("입력하신 숫자는 " + input + " 입니다.");
		
		process.check = true;
	}
}
