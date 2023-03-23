package com.shinhan.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Oracle {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//드라이버를 올려라
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("1. driver load 성공");
		String sql = "select * from EMPLOYEES";
		//2. Connection로 연결한 후
		//1521 : 포트번호, xe : 실행환경?
		//어떤 드라이버 쓸거야? jdbc:oracle:thin
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String userid="hr", pass="hr";
		Connection conn = DriverManager.getConnection(url, userid, pass);
		System.out.println("2. Connection 성공");
		//3. Statement를 통해서 SQL전송	 : Statement 2개 있음, jdbc에 있는 것 import 하면 됨
		//statement란 java가 왔다갔다할 통로
		Statement st = conn.createStatement();	//통로 만들기 완성
		ResultSet rs = st.executeQuery(sql);	//sql이 간다. //executeQuery를 통해 결과를 가져옴 
		//ResultSet : 데이터가 여러건 받을 수 있도록? 표같이 생김? 무조건 resultSet 형태로 옴.
		while(rs.next()) {	//다음게 있니? boolean
			System.out.println(rs.getInt(1));	//첫번째 컬럼 읽어라 (직원 아이디 : int 타입 이므로)
			System.out.println(rs.getString(2));	//두번째 컬럼 읽어라
			System.out.println(rs.getString(3));	//세번째 컬럼 읽어라
			System.out.println(rs.getInt("salary"));	//컬럼의 이름으로 읽음
			System.out.println("======================");
		}
		
		//자원 반남
		rs.close(); st.close(); conn.close();
	}
	
}

