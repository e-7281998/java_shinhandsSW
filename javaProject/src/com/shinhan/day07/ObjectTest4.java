package com.shinhan.day07;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

public class ObjectTest4 {
	public static void main(String[] args) throws UnsupportedEncodingException {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		f6();
//		f7();
//		f8();
//		f9();
//		f10();
//		f11();
//		f12();
//		f13();
//		f14();
		f15();
	}

	private static void f15() {
		Date d1 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd:hh:mm:ss");
		String result = sdf.format(d1);
		System.out.println(result);
		System.out.println(d1);
	}

	private static void f14() {
//		DecimalFormat df = new DecimalFormat("000,000,000");
		DecimalFormat df = new DecimalFormat("###, ###");
		long money = 1000000000000l;
		String result = df.format(money);
		System.out.println(result);
	}

	private static void f13() {
		Date d1 = new Date();
		System.out.println(d1);
		System.out.println(d1.getTime());
		
		Calendar cal = Calendar.getInstance();	//인스턴스를 새로 만들어라
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH ) + 1);
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dt.getYear());
		System.out.println(dt.getMonthValue());
	}

	private static void f12() {
//		Math.max(10,20);
		int a = 10;
		int b = 20;
		int max = Math.max(a, b);
//		if(a>b)
//			max = a;
//		else
//			max=b;
		
		//round(반올림), ceil(올림), floor(버림)
		double c = 3.9;
		System.out.println(Math.ceil(c));
		System.out.println(Math.round(c));
		System.out.println(Math.floor(c));
	}

	private static void f11() {
		Integer a = 10;
		Integer b = 10;
		System.out.println(a==b);
		System.out.println(a.intValue()==b.intValue());	//위 코드는 자동으로 이 코드를 실행한다. 
	}

	private static void f10() {
		//다음의 문자열에서 숫자들만 추출
		String s = "이것이 자바다 12345 This is 6789 JAva 55";
//		String result = "";
		StringBuilder result = new StringBuilder();
		char arr[] = s.toCharArray();
		for(char ch: arr) {
			if(Character.isDigit(ch)) {	//isDigit은 숫자인지 물어봐줌
				result.append(ch);
//				result += ch;
			}
		}
		System.out.println(result);
		
	}

	private static void f9() {
		String s = "이것이 자바다 This is JAVA";
		System.out.println(s.substring(0,1));	//문자열 자르기 : 문자열은 배열이 아니기 때문에 s[0] 이렇게 접근 못함.
		System.out.println(s.charAt(0));
		char arr[] = s.toCharArray();	//문자열을 배열로 하나씩 넣어줌 : 문자열을 배열로 만들어줌
		for(char ch:arr) {
			if(Character.isUpperCase(ch)) {	//문자가 대문자인지 확인해줌. ch가 문자형이므로 Character로 찾아보면 됨.
				System.out.println(ch + "--- 대문자");
			}else {
				System.out.println(ch + "--- 대문자 아님.");

			}
		}
	}

	private static void f8() {
		String score = "100";
		int score2 = Integer.parseInt(score);
		System.out.println(score2 + 200);
		
		int su = 10;
		System.out.println(Integer.toBinaryString(su));
	}

	private static void f7() {
		int a = 10; // 기본형 : 값 저장, 연산, 비교
		Integer b = 20; // 객체 : 참조형 : 기본형 + 기능	//Boxing : new Integer(20)
		
		System.out.println(a+b+200);//Unboxing b.intValue()
		
		float f = b.floatValue();
		System.out.println(Integer.MAX_VALUE);//< = > : -1 0 1
		int su = Integer.compare(10, 30); // 앞이 크면 -1, 뒤가 크면 1
		System.out.println(su);

		int arr[] = { 10, 60, 20, 50, 44 };
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void f6() {
		// LocalDate는 new 했을 때 뭐가 안나옴
		// => 객체를 생성할 수 없음
		// 그럴경우 . 연산자로 (다이렉트로) 접근하면 됨.
		// LocalDate dt = new LocalDate();

		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dt.toString()); // toString은 원래 생략되므로 다음과 같이 써도 됨
		System.out.println(dt);
		String s = dt.toString();
		String arr[] = s.split("T");
		System.out.println(arr[0]);
		System.out.println(arr[1]);

		StringTokenizer st = new StringTokenizer(s, "T");

//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
		// 읽게되면 만들었던 애는 사라짐.
		// 때문에 나머지가 없는데 계속 나누게되면 오류남.
		// System.out.println(st.nextToken()); //세번토째는 없으므로 오류남

		// 그렇기 때문에 다음과 같이 토큰이 더 남았는지 물어보고 분리해야 함.
		// hasMoreTokens() : 더이상 나눌 토큰이 있는지 알아봐줌.
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}

	}

	private static void f5() {
		String number = "010-1234-5678 010-0000-0000";
		StringTokenizer st = new StringTokenizer(number, "- ");
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

	private static void f4() {
		String fruits = "사과,오렌지/키위 수박,참외";

		// 읽게되면 만들었던 애는 사라짐.
		StringTokenizer st = new StringTokenizer(fruits, ",/ ");
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

	private static void f3() {
		String fruits = "사과,오렌지/키위 수박,참외";
		String arr[] = fruits.split(",|/| |");
		for (String f : arr) {
			System.out.println(f);
		}

	}

	private static void f2() throws UnsupportedEncodingException {
		String s1 = "자바"; // 가장 일반적, String은 고정 문자열
		s1 = s1 + "프로그램"; // 메모리 낭비

		StringBuffer sf = new StringBuffer("자바");
		StringBuilder sb = new StringBuilder("자바의");
		// sb = sb + "프로그램"; //불가능
		sb.append("프로그램");
		System.out.println(sb);
		sf.append("프로그램");
		System.out.println(sf);

		String s2 = new String(sf);
		String s3 = new String(sb);
		System.out.println(s2);
		System.out.println(s3);

		String s4 = "자바프로그래밍";
		byte[] arr1 = s4.getBytes("utf-8"); // 한글 1자 => 3byte
		byte[] arr2 = s4.getBytes("euc-kr");// 한글 2자 => 2byte
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.out.println(arr1.length);
		System.out.println(arr2.length);
	}

	private static void f1() throws UnsupportedEncodingException {
		String s1 = "자바";
		String s2 = new String("자바");
		byte arr1[] = new byte[] { 65, 66, 67, 97, 98, 99 }; // 65 = "A";
		char[] arr2 = new char[] { 'A', 'B', 'C', 'a', 'b', 'c' };
		String s3 = new String(arr1);
		String s4 = new String(arr2);
		System.out.println(s1 + s2 + s3 + s4);

		String s5 = new String(arr1, "utf-8");
		System.out.println(s5);
		System.out.println(s5.length());
		System.out.println((int) '가');

	}
}
