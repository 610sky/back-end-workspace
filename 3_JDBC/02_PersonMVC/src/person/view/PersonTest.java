package person.view;

import java.util.Scanner;

import person.controller.PersonController;

public class PersonTest {
	PersonController pc = new PersonController();
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		PersonTest pt = new PersonTest();
		
		// 이 부분은 테스트 용도로만!
//		pt.addPerson();
//		pt.searchPerson();
//		pt.updatePerson();
//		pt.removePerson();
//		pt.searchAllPerson();
		
//		pt.updatePerson2(new Person(~~,~~,~~,~~));
	}
	
	// 각 Controller에 메서드들 연결하는 건 각 메서드들에서 구현
	
	// person 테이블에 데이터 추가 - INSERT
	public void addPerson() {
		// ~~님, 회원가입 완료!
		System.out.print("아이디 : ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		System.out.print("주소 : ");
		String addr = sc.nextLine();
		pc.addPerson(id, name, age, addr);
		
		System.out.println(name + "님, 회원가입 완료!");
	}
	// person 테이블에 데이터 수정 - UPDATE
	public void updatePerson() {
		// ~~님, 정보 수정 완료!
		System.out.print("변경하려는 아이디 : ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.print("변경하려는 이름 : ");
		String name = sc.nextLine();
		System.out.print("변경하려는 나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		System.out.print("변경하려는 주소 : ");
		String addr = sc.nextLine();
		
		System.out.println(pc.searchNamePerson(id) + "님, 정보 수정 완료!");
		
		pc.updatePerson(id, name, age, addr);
	}
	// person 테이블에 데이터 삭제 - DELETE
	public void removePerson() {
		// !!님, 회원탈퇴 완료!
		System.out.print("삭제하려는 아이디 : ");
		int id = Integer.parseInt(sc.nextLine());
		
		System.out.println(pc.searchNamePerson(id) + "님, 회원탈퇴 완료!");
		
		pc.removePerson(id);
	}
	// person 테이블에 있는 데이터 전체 보여주기 - SELECT
	public void searchAllPerson() {
		pc.searchAllPerson();
	}
	// person 테이블에서 데이터 한개만 가져오기 - SELECT
	public void searchPerson() {
		System.out.print("찾으려는 아이디 : ");
		int id = Integer.parseInt(sc.nextLine());
		
		pc.searchPerson(id);
	}
	
//	public void searchAllPerson2() {
//		ArrayList<Person> list = pc.searchAllPerson2();
//		for(Person p : list) {
//			System.out.println(p);
//		}
//	}
}
