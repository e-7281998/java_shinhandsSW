package com.shinhan.day05;


class Parent{
	int a = 10;
	
	Parent() {
		System.out.println("부모 생성");
	}
	
	void f1() {
		System.out.println("부모의 f1 메서드");
	}
}

class Child extends Parent{
	String a = "java";	//부모에게 a가 있지만 내가 a를 선언하면 덮어씌워짐(내가 중요)
	int b = 20;
	
	Child(){
		//super();
		System.out.println("Child 생성");
	}
	
	void f1() {	//override
		//**내가 추가 ) 부모의 f1() 수행 후 추가한 것 추가
		//**내가 추가 ) 이때 super는 어느 위치에 있든 상관 없다. 그냥 함수처럼 생각하고, 호출하면 된다.
		super.f1();
		System.out.println("자식의 f1 메서드");
	}
	
	void f2() {
		System.out.println("자식의 f2 메서드");
	}
}


public class InheritenceTest {

	public static void main(String[] args) {
		Child ch = new Child();
		System.out.println(ch.a);
		System.out.println(ch.b);
		ch.f1();
		ch.f2();
	}

}
