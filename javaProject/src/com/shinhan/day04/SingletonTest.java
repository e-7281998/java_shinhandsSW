package com.shinhan.day04;

public class SingletonTest {

	public static void main(String[] args) {
		MyServlet a = MyServlet.getInstance();
		MyServlet b = MyServlet.getInstance();
		MyServlet c = MyServlet.getInstance();
		MyServlet d = MyServlet.getInstance();
		//여러번 호출해도 한번만 실행됨.
		
		System.out.println(a==b);
		a.print();
		b.print2();
	}

}
