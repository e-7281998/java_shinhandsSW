package com.shinhan.day04;

public class ModifierTestDay04 {
	//같은 패키지 연습
	public static void main(String[] args) {
		Phone p = new Phone();
		p.model = "갤럭시";
		p.price = 1000;
		p.f1();
		p.f2();
		p.f3();
//		p.f4();	//f4()는 private이기 때문에 호출 불가
		System.out.println(p);
	}

}
