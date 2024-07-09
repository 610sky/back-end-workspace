package com.kh.example.practice1;

import com.kh.example.practice1.model.Lotto;

public class Application {
// 1~45까지 랜덤숫자로 6개 지정
	public static void main(String[] args) {
		Lotto l = new Lotto();
		l.initLotto();
		while(true) {
			l.initMyLotto();
			l.compareNum();
			if(l.getCount() == 6) {
				System.out.println("횟수 : " + l.getTotalCount());
				break;
			}
			else if(l.getCount()==5 && l.compareBonus()) {
				System.out.println("2등 당첨! 보너스 번호 : " + l.getBonusNum()
				+ ", 횟수 : " + l.getTotalCount());
				break;
			}
			else {
				l.setCount(0);
				l.clearMy();
			}
		}
	}
}
