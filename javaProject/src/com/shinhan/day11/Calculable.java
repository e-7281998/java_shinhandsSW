package com.shinhan.day11;

//람다식 가능한지 확인하는 어노테이션
//interface에 1개의 메서드만 존재해야 한다.
//: 메소드 2개 이상일 경우 람다식 표현 불가
@FunctionalInterface	
public interface Calculable {
	//추상 메서드 정의
	void calculate(int x, int y);
//	void calculate1(int x, int y);	//사용하면 람다식 불가
}
