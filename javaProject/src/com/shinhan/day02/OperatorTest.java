package com.shinhan.day02;

public class OperatorTest {

	public static void main(String[] args) {
		method5();
	}

	private static void method5() {
		int a = 10;
		a++;
		++a;
		
	}

	private static void method4() {
		int a = 10;
		int b = 20;
		System.out.println(a == b);
		System.out.println(a != b);
		System.out.println(!(a == b));
	}

	private static void method3() {
		int a = 10;
		int b = 20;
		boolean result = a > 10 && ++b == 20;
		boolean result2 = a > 10 & ++b == 20;
		System.out.println(result);
		System.out.println(result2);
		System.out.println(b);
	}

	private static void method2() {
		int a = 10;
		int b = 0;
		double d = 0.0;
		//정수는 0으로 나눌 수 없다.(실수는 가능)	ArithmeticException 에러 발생
		//RuntimeException 발생 : 실행 시 오류남
//		System.out.println(a/b);
		
		System.out.println(a%d);
		if(Double.isNaN(a%d)) {
			System.out.println("계산불가");
		}else {
			System.out.println(a%d);
		}
		
		System.out.println(Double.isInfinite(a/d));
		if(Double.isInfinite(a/d)) {
			System.out.println("계산불가");
		}else {
			System.out.println(a/d);
		}
	}

	private static void method1() {
		int a = 10;
		int b = 5;
		
		System.out.println("더하기: " + (a+b));
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b);
		System.out.println(a%b);	//나머지
	}

}
