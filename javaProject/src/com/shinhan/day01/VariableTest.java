package com.shinhan.day01;

//class = 변수 + 함수

//VariableTest.java => 컴파일 VariableTest.class
//실행
//1. JVM이  VariableTest class Loader에 의해 Load
//(static이 method영역에 올라간다.)
//2. 검증
//3. main 시작


public class VariableTest {
	int score=100;
	
	public static void main(String[] args) {
		//1.변수 선언
		int a;	//지역변수(local)
		
		//System.out.println(a); 	//초기화하지 않으면 사용 불가, 사라짐
		
		//System.out.println(score);	//static이 non-static 사용 불가
		//초기화해도 사용 불가
		//왜? main은 static이라 VariableTest class와 메모리에 올라가는 시점이 다름.
		
		//2.변수 사용
		a = 10;	//값을 할당
		
		//3. 읽기
		System.out.println(a);
		
		//4.선언+사용
		int a2 = 30;
		System.out.println(a2);
	}

}
