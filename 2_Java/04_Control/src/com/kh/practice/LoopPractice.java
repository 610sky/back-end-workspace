package com.kh.practice;

import java.util.Arrays;
import java.util.Scanner;

class LoopPractice {
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		LoopPractice l = new LoopPractice();
//		l.method1();
//		l.method2();
//		l.method3();
//		l.method4();
//		l.method5();
		l.method6();
	}
 
    /*
        사용자로부터 숫자(1~100) 1개가 입력되었을 때 카운트다운 출력하시오.
        사용자 입력 : 5
        5
        4
        3
        2
        1
     */
    public void method1() {
    	System.out.print("사용자 입력 : ");
    	int number = sc.nextInt();
    	for(int i=number;i>0;i--) {
    		System.out.println(i);
    	}
    }

    // 1+(-2)+3+(-4)+...과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이 100 이상 되는지 출력하시오.
    public void method2() {
    	double sum=0;
    	double i=1;
    	double j=-2;
    	while(sum < 100) {
    		sum = i + j;
    		i +=2;
    		j *=2;
    		System.out.println("sum = " + i + " " + j);
    	}
    }

    /*
        사용자로부터 문자열을 입력 받고 문자열에서 검색될 문자를 입력 받아 해당 문자열에 그 문자가 몇 개 있는지 개수를 출력하세요. 

        문자열 : banana
        문자 : a
        banana 안에 포함된 a 개수 : 3

    */
    public void method3() {
    	System.out.print("문자열 : ");
    	String str = sc.nextLine();
    	System.out.print("문자 : ");
    	char ch = sc.nextLine().charAt(0);
    	int count = 0;
    	for(int i=0;i<str.length();i++) {
    		if(ch == str.charAt(i)) {
    			count++;
    		}
    	}
    	System.out.printf("%s 안에 포함된 %c 개수 : %d", str, ch, count);
    }

    /*
        0이 나올 때까지 숫자를 출력하시오. (random 사용! 0 ~ 10)
        7
        3
        4
        2
        3
        4
        0
     */
    public void method4() {
    	while(true) {
    		int random = (int)(Math.random()*11);
    		System.out.println(random);
    		if(random == 0)
    			break;
    	}
    }

    /*
        주사위를 10번 굴렸을 때 각 눈의 수가 몇 번 나왔는지 출력하세요. (random 사용!)

        1 : 3
        2 : 2
        3 : 1
        4 : 0
        5 : 4
        6 : 0

     */
    public void method5() {
    	int count_1=0;
    	int count_2=0;
    	int count_3=0;
    	int count_4=0;
    	int count_5=0;
    	int count_6=0;
    	
    	for(int i=0;i<10;i++) {
    		int random = (int)(Math.random()*6+1);
    		switch(random) {
    		case 1:
    			count_1++;
    			break;
    		case 2:
    			count_2++;
    			break;
    		case 3:
    			count_3++;
    			break;
    		case 4:
    			count_4++;
    			break;
    		case 5:
    			count_5++;
    			break;
    		case 6:
    			count_6++;
    			break;
    		}
    	}
    	System.out.printf("1 : %d\n", count_1);
    	System.out.printf("2 : %d\n", count_2);
    	System.out.printf("3 : %d\n", count_3);
    	System.out.printf("4 : %d\n", count_4);
    	System.out.printf("5 : %d\n", count_5);
    	System.out.printf("6 : %d\n", count_6);
    }

    /*
        사용자의 이름을 입력하고 컴퓨터와 가위바위보를 하세요. 
        컴퓨터가 가위인지 보인지 주먹인지는 랜덤한 수를 통해서 결정하도록 하고, 사용자에게는 직접 가위바위보를 받으세요.
        사용자가 이겼을 때 반복을 멈추고 몇 번 이기고 몇 번 비기고 몇 번 졌는지 출력하세요.

        당신의 이름을 입력해주세요 : 김미경
        가위바위보 : 가위
        컴퓨터 : 가위
        김미경 : 가위
        비겼습니다.

        가위바위보 : 가위 
        컴퓨터 : 바위
        김미경 : 가위
        졌습니다 ㅠㅠ

        가위바위보 : 보
        컴퓨터 : 바위
        김미경 : 보
        이겼습니다 !
	    비긴 횟수 : 1, 진 횟수 : 1, 이긴 횟수 : 1
    */
    public void method6() {
    	int win=0;
    	int lose=0;
    	int draw=0;
    	
    	System.out.print("당신의 이름을 입력해주세요 : ");
    	String name = sc.nextLine();
    	
//    	0 : 가위, 1 : 바위, 2 : 보
    	while(true) {
    		System.out.print("가위바위보 : ");
    		String select = sc.nextLine();
    		int random = (int)(Math.random()*3);
    		if(select.equals("가위")) {
    			if(random == 0) {
    				System.out.println("컴퓨터 : 가위");
    				System.out.printf("%s : %s\n", name, select);
    				System.out.println("비겼습니다.");
    				System.out.println();
    				draw++;
    				continue;
    			}
    			else if(random == 1) {
    				System.out.println("컴퓨터 : 바위");
    				System.out.printf("%s : %s\n", name, select);
    				System.out.println("졌습니다 ㅠㅠ");
    				System.out.println();
    				lose++;
    				continue;
    			}
    			else if(random == 2) {
    				System.out.println("컴퓨터 : 보");
    				System.out.printf("%s : %s\n", name, select);
    				System.out.println("이겼습니다 !");
    				win++;
    				System.out.printf("비긴 횟수 : %d, 진 횟수 : %d, 이긴 횟수 : %d", draw, lose, win);
    				break;
    			}
    		}
    		else if(select.equals("바위")) {
    			if(random == 0) {
    				System.out.println("컴퓨터 : 가위");
    				System.out.printf("%s : %s\n", name, select);
    				System.out.println("이겼습니다 !");
    				win++;
    				System.out.printf("비긴 횟수 : %d, 진 횟수 : %d, 이긴 횟수 : %d", draw, lose, win);
    				break;
    			}
    			else if(random == 1) {
    				System.out.println("컴퓨터 : 바위");
    				System.out.printf("%s : %s\n", name, select);
    				System.out.println("비겼습니다.");
    				System.out.println();
    				draw++;
    				continue;
    			}
    			else if(random == 2) {
    				System.out.println("컴퓨터 : 보");
    				System.out.printf("%s : %s\n", name, select);
    				System.out.println("졌습니다 ㅠㅠ");
    				System.out.println();
    				lose++;
    				continue;
    			}
    		}
    		else if(select.equals("보")) {
    			if(random == 0) {
    				System.out.println("컴퓨터 : 가위");
    				System.out.printf("%s : %s\n", name, select);
    				System.out.println("졌습니다 ㅠㅠ");
    				System.out.println();
    				lose++;
    				continue;
    			}
    			else if(random == 1) {
    				System.out.println("컴퓨터 : 바위");
    				System.out.printf("%s : %s\n", name, select);
    				System.out.println("이겼습니다 !");
    				win++;
    				System.out.printf("비긴 횟수 : %d, 진 횟수 : %d, 이긴 횟수 : %d", draw, lose, win);
    				break;
    			}
    			else if(random == 2) {
    				System.out.println("컴퓨터 : 보");
    				System.out.printf("%s : %s\n", name, select);
    				System.out.println("비겼습니다.");
    				System.out.println();
    				draw++;
    				continue;
    			}
    		}
    	}
    }
}