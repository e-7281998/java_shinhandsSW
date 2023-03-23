package com.shinhan.day02;

import java.util.Arrays;

public class ReferenceTest {

	public static void main(String[] args) {
		f4();
	}

	private static void f4() {
		String subject = "자바,DB#HTML,CSS,javscript,React,Spring";
		String[] arr = subject.split(",|#| ");
		System.out.println(subject);
		System.out.println(Arrays.toString(arr));
		System.out.println(arr[4]);
		
		for(String s:arr) {
			System.out.println(s);
		}
	}

	private static void f3() {
		String subject = "이것이 자바다~";
		
		for(int i=0; i < subject.length(); i++) {
			System.out.println(subject.charAt(i));
			System.out.println(subject.substring(i, i+1));
		}
		
		System.out.println(subject.replace("자", "바밤"));
		
		System.out.println(subject.indexOf("자바"));
		
	}

	private static void f2() {
		String name = null;	//힙에 생성된 객체는 없다.
		System.out.println(name);
		System.out.println(name.length());
	}

	private static void f1() {
		int a = 10;
		String s1 = "자바";	//컴파일시에 클래스의 상수pool에 들어감, load시 method영역의 상수pool
		String s2 = "자바";
		String s3 = new String("자바1");
		String s4 = new String("자바1");
		
		System.out.println(s1==s2); //주소 같다
		System.out.println(s3==s4); //주소 다르다
		
		System.out.println(s1.equals(s3));
	}

}
