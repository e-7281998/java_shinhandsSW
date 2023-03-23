package com.shinhan.day07;

import java.util.HashSet;
import java.util.Set;

public class ObjectTest2 {

	public static void main(String[] args) {
//		f2();
		f3();
	}

	private static void f3() {
//		Computer c0 = new Computer();
		Computer c1 = new Computer("model");
		Computer c2 = new Computer("A", 100, "LG");
		Computer c3 = new Computer("A", 100, "LG");
		System.out.println(c2.getModel());
		c2.setMaker("엘지");
		System.out.println(c1.equals(c3));
		System.out.println(c2);
		System.out.println(c3);		
	}

	private static void f2() {
		Person p1 = new Person("홍길동", 20);
		System.out.println(p1);
		System.out.println(p1.name());
		System.out.println(p1.age());
	}

	private static void f1() {
		ProdectVO p1 = new ProdectVO("컴퓨터", 100, "삼성");
		ProdectVO p2 = new ProdectVO("컴퓨터", 100, "삼성");

		System.out.println(p1);
		System.out.println(p2);

		System.out.println(p1 == p2); // 주소비교, 자바는 연산자 재정의 불가능
		System.out.println(p1.equals(p2)); // 재정의 안하면 주소 비교
		System.out.println(p1.equals(null)); // 재정의 안하면 주소 비교
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());

		System.out.println("----------------");
		
		// 우측은 생략 가능
		Set<ProdectVO> data = new HashSet<>();
		data.add(p1);
		data.add(p2);

		for (ProdectVO p : data) {
			System.out.println(p);
		}
	}

}
