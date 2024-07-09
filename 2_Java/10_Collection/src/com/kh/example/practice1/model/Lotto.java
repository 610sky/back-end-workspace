package com.kh.example.practice1.model;
import java.lang.Math;
import java.util.ArrayList;

public class Lotto {
	private ArrayList lotto = new ArrayList();
	private ArrayList myLotto = new ArrayList();
	private int count = 0;
	private int totalCount = 0;
	private int bonusNum;
	
	public void initLotto() {
		for(int i = 0; i<6; i++) {
			int randNum = (int) (Math.random() * 44 + 1);
			if(lotto.isEmpty())
				lotto.add(randNum);
			else {
				while(lotto.contains(randNum)) {
					randNum = (int) (Math.random() * 44 + 1);
				}
				lotto.add(randNum);
			}
		}
		bonusNum = (int) (Math.random() * 44 + 1);
	}
	public void initMyLotto() {
		for(int i = 0; i<6; i++) {
			int randNum = (int) (Math.random() * 44 + 1);
			if(myLotto.isEmpty())
				myLotto.add(randNum);
			else {
				while(myLotto.contains(randNum)) {
					randNum = (int) (Math.random() * 44 + 1);
				}
				myLotto.add(randNum);
			}
		}
		System.out.println("로또 번호 : " + lotto);
		System.out.println("내 번호 : " + myLotto);
	}
	public void compareNum() {
		for(int i=0; i<6; i++) {
			if(lotto.contains(myLotto.get(i)))
				count++;
//				System.out.println(myLotto.get(i));
		}
		totalCount++;
	}
	public boolean compareBonus() {
		for(int i=0; i<6; i++) {
			if(myLotto.contains(bonusNum))
				return true;
		}
		return false;
	}
	public void clearMy() {
		myLotto.clear();
	}
	public int getCount() {
		return this.count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotalCount() {
		return this.totalCount;
	}
	public int getBonusNum() {
		return this.bonusNum;
	}
}
