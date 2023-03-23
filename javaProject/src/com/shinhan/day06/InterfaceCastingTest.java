package com.shinhan.day06;

interface A{ void method1 (); }
class B implements A{
	@Override
	public void method1() {System.out.println("B에서 메서드 재정의");}
}
class C implements A{
	@Override
	public void method1() {System.out.println("C에서 메서드 재정의");}
}
class D extends B{
	@Override
	public void method1() {System.out.println("D에서의 메서드 재정의");}
	
	public void method2() {System.out.println("D에서의 메서드 c추가");}
}
class E extends C{
	@Override
	public void method1() {System.out.println("E에서의 메서드 재정의");}
}


public class InterfaceCastingTest {

	public static void main(String[] args) {
		A v1 = new D();
		B v2 = new D();
		D v3 = new D();		
		
		v1.method1();
		v2.method1();
		v3.method1();
		
		((D)v1).method2();
		((D)v2).method2();
		((D)v3).method2();
		
//		E e = (E)v1;	//컴파일시 에러 안남, 실행시 오류
//		e.method1();
	}

}
