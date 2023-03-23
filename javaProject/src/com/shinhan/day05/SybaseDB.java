package com.shinhan.day05;

public class SybaseDB extends Object implements JDBCInterface{

	@Override
	public void dbConnect(String dbName) {
		System.out.println("Sybase... 상수 접근: " + JDBC);
		System.out.println("Sybase... 상수 접근: " + JDBC2);
		
		//default메서드 호출
		select();
		//static 메서드 호출
		JDBCInterface.update();
		//private는 호출 불가
	}
	
	
	public void select() {
		System.out.println("select 재정의가 가능하다. ");
	}

	//추상메소드 : 반드시 구현할 의무가 있다.
	@Override
	public void dbConnect2(String dbName) {
		System.out.println(dbName + "사이베이스 DB dbConnection");
	}


}
