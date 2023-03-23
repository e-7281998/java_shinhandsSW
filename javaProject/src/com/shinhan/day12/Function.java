package com.shinhan.day12;

import lombok.Getter;

//interface : 규격서
//반드시 규칙을 지켜라
//추상 메서드가 정의되 있음. 구현 클래스가 반드시 구현해야 한다.

//T는 제네릭 타입... 사용 시 결정
//람다표현식으로 가능한 interface이고자 한다. => 추상 메서드가 한개만 존재해야 함.
//람다표현식이 아니라면 구현클래스를 만들거나, 익명 구현 클래스를 만든다. => 추상 메서드 여러개 가능
@FunctionalInterface	//람다표현식이 가능한지 확인해주는 어노테이션
public interface Function<T>{
	public double apply(T t);
}
