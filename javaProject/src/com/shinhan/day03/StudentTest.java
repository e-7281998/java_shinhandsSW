package com.shinhan.day03;

public class StudentTest {

	public static void main(String[] args) {
		f1();
	}

	private static void f1() {
		//default 생성자
		Student student1 = new Student(); // 클래스와 변수 같은 이름으로 맞추는 것이 보기 좋음
		//정보은닉 위해
		Student student2 = new Student("김기범", "0923","eng",100);
		student1.name = "최민호";
		student1.stdId = "1209";
		student1.subject = "java";
//		student1.score = 100;

		display(student1);
	}

	private static void display(Student std) {
		System.out.println("==========================");
		System.out.println(std.name);
		System.out.println(std.stdId);
		System.out.println(std.subject);
		System.out.println(std.score);

		std.study();
	}

}
