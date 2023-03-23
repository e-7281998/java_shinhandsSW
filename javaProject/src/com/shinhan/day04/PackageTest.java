package com.shinhan.day04;

import java.util.Date;

public class PackageTest {

	public static void main(String[] args) {
		Date d1 = new Date();
		System.out.println(d1);
		
		//위의 Date()는 utill에 있는 것이고
		//아래의 Date()는 sql에 있는 것이다. 
		//때문에 같은 이름의 클래스를 사용할 때는 어느 패키지에 있는 것인지 다음과 같이 함께 선언해줘야 한다.
		java.sql.Date d2 = new java.sql.Date(2023 - 1900, 2, 24);	//초기버전에 있었음, 권장 안함, 디프리케이트되었다고 함
		java.sql.Date d3 = new java.sql.Date(d1.getTime());
		System.out.println(d2);
		System.out.println(d3);
		
		BookVO b1 = new BookVO("자바다",1000);
		com.shinhan.day05.BookVO b2 = new com.shinhan.day05.BookVO("자바2다", 122);
		
	}

}
