package com.shinhan.day08;

public class Service {
	@PrintAnnotation
	public void method1() {	
		System.out.println("실행 내용1");
	}

	@PrintAnnotation("*")	//속성안주면 value로 들어감. 안주면 default로 설정한 - 임
	public void method2() {
		System.out.println("실행 내용2");
	}

	@PrintAnnotation(value = "#", number = 20, ej = "은정" )
	public void method3() {
		System.out.println("실행 내용3");
	}
}
