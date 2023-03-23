package com.shinhan.day02;

public class Review {

	public static void main(String[] args) {
		System.out.println("main 시작");
		f1();
		f2();
		System.out.println("main 끝");
	}

	private static void f2() {
		// TODO Auto-generated method stub

	}

	private static void f1() {
		System.out.println("f1 function");
		//기본형 dataType
		//byte, short, char, int, long, float, double, boolean
		//값 저장, 연산, 비교 를 위한 것 (기능 없음)
		//Wrapper class : 기본형 datatype + 기능 추가된 것.
		boolean b = true;	//boolean 기본 값은 false임
		
		byte v1 = 100;
		int v2;
		//1. 자동형변환
		v2 = v1;
		//2. 강제형변환 : casting 한다고 함.
		v1 = (byte)v2;
		//3. String은 기본형이 아님, java.lang.String class에 있음
		String s = "100";
//		int v3 = (int)s;	//불가, 왜? int는 기본형이라 기능이 없음. 다음과 같이 Wrapper class 사용해야 함.
		int v3 = Integer.parseInt(s);
		System.out.println(v3+200);
	}

}
