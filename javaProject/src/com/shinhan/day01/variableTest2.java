package com.shinhan.day01;

public class variableTest2 {

	public static void main(String[] args) {
		System.out.println("main 시작");
		f3();	//함수호출
		System.out.println("main 끝~");
	}

	private static void f3() {
		short v1 = 32767;	//short 가장 큰 값
		
		char v2 = 'A';	//값X면 오류, 공백이라도 사용, ""double은 string이므로 char에 사용 불가
		
		int v3 = Integer.MAX_VALUE;	//최댓값 구하기
		System.out.println(v3);
		long v4 = 2147483648L;	//마지막에 L,l을 추가함으로써 long타입임을 알려줘야함.
		
		float v5 = 3.14f;	//마지막에 f붙여줌
		double v6 = 3.14;	//실수의 기본값은 double이라고 생각하기
		
		char v7 = 65;	//A
		char v8 = 0x0041;	//A
		System.out.println(v8);
		
		boolean result;
		result = 10 > 20;
		System.out.println(result);
	}

	private static void f2() {
		//자바의 dataType
		//1. 정수(byte 1, short 2, char 2, int 4, long 8)
		//2. 실수(float 4, double 8)
		//3.boolean 1 : true, false
		//00000000
		//01111111 정수 가장 큰 값 : 127	//맨 앞은 부호, 뒤집어서 계산, 0이 양수
		//10000000 정수 가장 작은 값: -128
		
		byte v1=127;
		byte v2=-128;
		System.out.println(Integer.toBinaryString(v1));	//binary로 찍기
		System.out.println(Integer.toBinaryString(v2));	//binary로 찍기
		
		v1++;
		//최상위 값이 오버플로우되면 가장 작은수로 넘어감
		System.out.println(v1);
	}

	private static void f1() {
		int a;
		System.out.println(a=10);
		System.out.println(a==10);
	}
	

}
