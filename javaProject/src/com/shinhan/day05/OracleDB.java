package com.shinhan.day05;

public class OracleDB implements JDBCInterface{

	@Override
	public void dbConnect(String dbName) {
		System.out.println("상수 접근: " + JDBC);
		System.out.println("상수 접근: " + JDBC2);
		
		//default메서드 호출
		select();
		//static 메서드 호출
		JDBCInterface.update();
		//private는 호출 불가
	}
	
	/*
	public void select() {
		System.out.println("select 재정의가 가능하다. ");
	}*/

	@Override
	public void dbConnect2(String dbName) {
		System.out.println(dbName + "오라클 DB dbConnection");
	}


}
