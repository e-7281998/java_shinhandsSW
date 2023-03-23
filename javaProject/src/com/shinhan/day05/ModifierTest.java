package com.shinhan.day05;

import com.shinhan.day04.Phone;

//다음일 경우에만 price 가능
//price는 protected이기 때문에 다음과 같이 상속을 받아야만 사용 가능
//public class ModifierTest extends Phone {
public class ModifierTest extends Phone {
	// 다른 패키지 연습
	public static void main(String[] args) {
		Phone p = new Phone();
		p.model = "아이폰";
		System.out.println(p);
	}

}
