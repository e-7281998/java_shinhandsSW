package com.shinhan.day04;

//Servlet : java(주인공) + html 서버에서 수행하는 자바프로그램
//JSP : HTML(주인공) + JAVA : 실행하면 서버가 jsp => servlet으로 변경해서 실행
//Servlet은 싱글톤으로 동작한다. : new를 1회만 한다.
//내가 씀 * Servlet에서 자바를 짜고 jsp에서 html을 짜서 합친다.

public class MyServlet {
	
	private static MyServlet my;
	
	private MyServlet(){
		System.out.println("MyServlet이 생성됨");
	}
	
	//static이 붙어야 객체생성 없이 접근 할 수 있음
	public static MyServlet getInstance() {
		if(my == null) {
			my = new MyServlet();
		}
		return my;
	}
	
	public void print() {
		System.out.println("싱글톤 연습1");
	}
	
	public void print2() {
		System.out.println("싱글톤 연습2");
	}
}

//해당 클래스는 외부에서 접근 가능하지만 new를 통한 객체 생성은 불가.
//외부에서 getInstance 호출하면 my가 null이므로 하나 생성함.
//이후에는 my가 null이 아니므로 생성된 my리턴해줌