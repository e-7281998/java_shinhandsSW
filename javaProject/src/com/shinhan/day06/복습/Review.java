package com.shinhan.day06.복습;

/*
1. 변수 : 데이터를 저장하기 위한 기억장소 이름 : 값 수정 가능
2. 상수 : 데이터를 저장하기 위한 기어장소 이름 : 값 수정 가능
3. enum (열거) : 관련있는 상수들의 묶음
4. method : 문장들을 묶음 
5. class : Obejct를 만들기 위한 틀 : 변수 + 상수 + 메소드
6. Object : class로 new한 실체 (heap영역)
7. interface : 규격서(로직은 없음) : 상수 + 추상 메소드 + default method  + static method
*/

abstract class ParentClass{
//	void mehtod1() {};
	abstract void method1();	//추상 클래스 : 구현이 없음 : { } 없음 : 자식이 구현할 의무 있음
}

//규격서
interface MyInterface{
	//public abstract 생략 되어 있음
	void method2();
}

interface MyInterface2{
	void method2_1();
}

interface MyInterface3 extends MyInterface, MyInterface2{
	void method3_1();
}

class MyClass1 extends ParentClass implements MyInterface3{
//	void mehtod1() {}	//여기 말고 부모에 만들어 왜? MyClass2에서도 쓸 거니까
	 void method1() {}//추상클래스이므로 반드시 구현할 의무가 있다.

	 //MyInterface3은 MyInterface1, MyInterface2를 상속 받은 인터페이스이다.
	 //때문에 MyInterface1, MyInterface1, MyInterface3의 메소드 : 3개를 모두 구현할 의무가 있다.
	@Override
	public void method2() {}

	@Override
	public void method2_1() {}

	@Override
	public void method3_1() {};		 
}
class MyClass2 extends ParentClass implements MyInterface{
//	void mehtod1() {}
	 void method1() {};	//추상클래스이므로 반드시 구현할 의무가 있다.
	 
		@Override
		public void method2() {};	
}

public class Review {

	public static void main(String[] args) {
		MyClass1 v1 = new MyClass1();
//		v1.method1();
//		v1.method2();
//		v1.method2_1();
//		v1.method3_1();
		
		//Myclass1,2 중 어느것으로 받을지 모르지만, 코드가 흔들리길 원치 않음
		//:부모 클래스로 받기 : 자동 형변환
//		ParentClass v1 = new MyClass2();
		
		work(v1);
	}
	
	static void work(ParentClass aa ) {
		aa.method1();
		
		System.out.println(aa instanceof MyClass1);
		System.out.println(aa instanceof ParentClass);
		System.out.println(aa instanceof MyInterface);
		System.out.println(aa instanceof MyInterface2);
		System.out.println(aa instanceof MyInterface3);
		
		if(aa instanceof MyInterface3 my) {
//			MyInterface3 my = (MyInterface3)aa;	//1 2이전
			my.method2();
			my.method2_1();
			my.method3_1();
		}

//		aa.method2();
//		aa.method2_1();
//		aa.method3_1();
	}

}
