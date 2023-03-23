package com.shinhan.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//연결은 여기서만 하고싶음
//계속 안만들고 가져다쓰고 싶음.

public class OracleUtil {
	// 1. DB연결
	public static Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String userid = "hr", password = "hr";

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, userid, password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	// 2. 자원반납
	public static void dbDisconnect(ResultSet rs, Statement st, Connection conn) {

		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}

//원본
//public class OracleUtil {
//	public static Connection getConnection() {
//		Connection conn = null;
//		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
//		String userid = "hr", pass = "hr";
//
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//			conn = DriverManager.getConnection(url, userid, pass);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return conn;
//		
//	}
//	
//	public static void dbDisconnect(ResultSet rs, Statement st, Connection conn) {
//		try {
//			if( rs!= null) rs.close();
//			if( st!= null) st.close();
//			if( conn!= null) conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//}
