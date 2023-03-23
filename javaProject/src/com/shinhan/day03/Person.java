package com.shinhan.day03;

public class Person {
	// 멤버변수는 instance변수, static변수(instance변수 공유변수) 있음.
	private static int numberOfPersons;
	private int age;
	private String name;

	// 생성자 메서드
	//*class와 동일해야함.
	Person() {
		// 최상위에만 사용 가능
		this("Anonymous", 12); // 코드중복방지 => 유지보수 용이
	}

	//오버로딩된 생성자
	Person(String name, int age) {
		this.name = name;
		this.age = age;
		numberOfPersons++;
	}

	//일반 메서드
	//return 반드시 필요
	public void selfIntroduce() {
		System.out.printf("내 이름은 %s이며, 나이는 %d살 입니다.\n", name, age);
	}

	//static이 사용되어있으므로 인스턴스로 접근하지 않아도 된다.
	//클래스로 접근할 수 있다.
	static public int getPopulation() {
		return numberOfPersons;
	}
}
