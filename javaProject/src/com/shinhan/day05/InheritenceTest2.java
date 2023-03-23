package com.shinhan.day05;

//new Child() : Object 생성 Parents2 생성 Child2 생성
//**내가 씀 : 호출의 역순으로 생성됨

//final class : 상속 불가 : final class Parent2 { ... }일 경우 상속 불가
//final field : 값 수정 불가
//final method : 재정의 불가

class Parent2{	//extends Object 기본으로 상속받고 있는 중
	int a = 10;
	Parent2(){
		super();
		System.out.println("부모 생성자");
	}
	
	void method1() {
		System.out.println("부모의 method");
	}
}

//child객체에서 호출했는데 없다 ? 부모로 올라가서 찾음.
class Child2 extends Parent2{
//	String a = "자바";	//a 덮어쓰기됨, 없을경우에만 부모의 a 호출 됨.	//override
	int b = 2;
	
	Child2(){
//		super();
		System.out.println("자식 생성자");
	}
	
	void method1() {	//덮어쓰기 : override
		System.out.println("자식 메소드");
	}
//
//	
//	void method1(String b) {	//추가 : overloading
//		System.out.println("자식 메소드");
//	}
	
	void metohd2() {
		System.out.println("자식 메소드2");
	}
	
}

public class InheritenceTest2 {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
		f4();
	}
	
	private static void f4() {
		Parent2 ch = new Child2();
//		System.out.println(ch.a +","+ ch.b);
		System.out.println(ch.a);
		ch.method1();
//		ch.metohd2();
	}
	
	private static void f3() {
		//부모를 통해서 자식을 본다... 
		Parent2 ch = new Child2();
//		System.out.println(ch.a +","+ ch.b);
		System.out.println(ch.a);
		ch.method1();
//		ch.metohd2();
	}

	private static void f2() {
		Child2 ch = new Child2();
		System.out.println(ch.a +","+ ch.b);
		ch.method1();
		ch.metohd2();
	}



	private static void f1() {
		Student st1 =  new Student("123","홍길동");
		Student st2 =  new Student("456","감길동", "컴공");
		Student st3 =  new Student("123","한길동", "정보통신", 77);
		//배열을 초기화하여 넣어도 되고 다음 코드처럼 넣어도 됨.
		ExchangeStudent st4 = new ExchangeStudent("789","소길동",new String[] {"영어", "프랑스"});
		
		System.out.println(st1);	//원래는 주소찍힘	//기본적으로 toString이 찍히는데 배열의 주소값을 돌려줌.
		System.out.println(st2);	//해당 객체의 모든 것을 보고싶어 Student에서 toString을 오버라이드 함.
		System.out.println(st3);
		System.out.println(st4);
		System.out.println(Student.count);
		}

}
