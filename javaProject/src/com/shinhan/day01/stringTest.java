package com.shinhan.day01;

public class stringTest {

	public static void main(String[] args) {
		f8();

	}

	private static void f8() {
		int a = 10;
		float b = 20f;
		System.out.printf("a=%5d, b=%3.1f \n",a,b);
		//음수(%-5)는 왼쪽 정력, d : decimal
		//%3.15f : 전체자리수.소수아래자리수 float
		System.out.printf("a=%-5d, b=%3.1f",a,b);
	}

	private static void f7() {
		int a = 100;
		{
			int b = 200;
			System.out.println(a+b);
		}
		//block을 벗어나면 변수 사용 불가
//		System.out.println(a+b);
	}

	private static void f6() {
		//자바기본타입(8) : data저장, 연산, 비교
		//byte, short, char, int, long, double, boolean, float
		
		//Wrapper Class : 자바기본타입 + 기능 (함수)
		//Byte, Short, Character, Integer, Long, Float, Double, Boolean
		
		String score = "100";
		int i = 100;
		
		Integer i2 = 100;
		//Wrapper Class이기 때문에 i2. ~ 가능
		System.out.println(Integer.parseInt(score)+10);	//문자 + 숫자 = 문자;
	
		String str = String.valueOf(i);
		String str2 = i + "";
	}

	private static void f5() {
		byte v1 = 10;
		byte v2 = 20;
		//사칙연산식에서 byte가 int로 자동변환된다.
		byte v3 = (byte)(v1 + v2);
		int v4 = v1 + v2;
		
		System.out.println(v3);
		System.out.println(v4);
	}

	private static void f4() {
		//강제형변환 : 작은 방 = (작은방 타입)큰 값
		//data 손실 가능성 O
		
		byte v1;
		int v3 = 128;
		v1 = (byte)v3;
		
		System.out.println(v1);
	}

	private static void f3() {
		//자동형변환 : 큰 방 = 작은 값
		//byte < short < int <long < float < double
		//		 char
		//boolean
		//byte는 char로 자동형변환 불가
		
		byte v1 = 127;
		short v2 = v1;
		int v3 = v1;
		long v4 = v1;
		float v5 = v1;
		double v6 = v1;
		
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(v4);
		System.out.println(v5);
		System.out.println(v6);
		
		v3 = 10000;
		v4 = v3;
		v5 = v3;
		v6 = v3;
	}

	private static void f2() {
		// \t : tab
		
		String str1 = "자바 \n '프로그램' \t 완성";
		//'이스케이프문자'라고 함, \랑 같이 사용, 무시해라
		String str2 = "자바 \"프로그램\" 완성";
		String str3 = "{\"name\":\"홍\", \"age\":20}";	//json : javascript형태의 문자열
		String str4 = """
				{"name" : "홍", "age" : 20}
				""";
		System.out.println(str1);
		System.out.println(str4);
	}

	private static void f1() {
		//java.base 모듈 java.lang 패키지 String class에 있음
		//기본형이 아님
		//***String : 고정문자열
		
		//리터럴 방식과 new 형식 차이점
		String s1 = "자바";	//컴파일 시점에 .class의 상수 pool에 집어넣어라 (stack영역에)
		String s2 = "자바";	//s1,과 s2의 주소가 같음
		
		String s3 = new String ("자바");	//실행할 때 만들어짐 (heap영역에 - 메모리)
		String s4 = new String ("자바");	//s3, s4 주소가 다름
		
		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));
		System.out.println(System.identityHashCode(s3));
		System.out.println(System.identityHashCode(s4));
		
		//가비지 컬랙터 : 메모리 정리해줌
		
		//문자열끼리 더하기 X : 메모리 낭비
		//왜?
		//스트링 버퍼를 통해 "프로그램"을 스트링으로 바꿈.
		//새로운 주소를 만들어 s1과 스트링으로 바꾼 "프로그램"에 append함.
		//더이상 필요없는 메모리는 가비지 컬랙터가 정리해줌.
		s1 = s1 + "프로그램";
		s2 = s2 + "프로그램";
		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));
	}

}
