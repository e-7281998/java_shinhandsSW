package com.shinhan.day04;

public class BookExample {

	public static void main(String[] args) {
		BookVO[] b = new BookVO[5];
		b[0] = new BookVO("Java Program", 30000);
		b[1] = new BookVO("JSP Program", 25000);
		b[2] = new BookVO("SQL Fundamentals", 20000);
		b[3] = new BookVO("JDBC Program", 32000);
		b[4] = new BookVO("EJB Program", 25000);
		
		System.out.println("책 생성 후 : " + BookVO.count);
		
//		b[0].isbn = "1111";	//staic 이므로 수정 불가
		System.out.println(BookVO.PUBLISHER);
	}

}
