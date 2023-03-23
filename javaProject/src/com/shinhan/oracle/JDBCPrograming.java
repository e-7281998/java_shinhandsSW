package com.shinhan.oracle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.shinhan.dbutil.OracleUtil;

public class JDBCPrograming {
	public static void main(String[] args) {
		f2();
	}

	//PreparedStatement 버전
	private static void f2() {
		System.out.print ("상사의 이름을 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		String ceo = sc.nextLine();
		Connection conn = null;
//		Statement st = null;
		PreparedStatement st = null; 	//Statement(부) <-----PreparedStatement(자식)
		ResultSet rs = null;
		String sql = """
				select employee_id, first_name,salary,hire_date
				from employees
				where manager_id = any 
								(select employee_id
								from employees
								where last_name = ?)
								""";
		conn = OracleUtil.getConnection();
		try {
//			st = conn.createStatement();
			st = conn.prepareStatement(sql);	//PreparedStatement: ?를 지원
			st.setString(1, ceo);	//첫번째 ?에 값을 setting : 첫번째 물음표에 ceo들어갈거야 
//			rs = st.executeQuery(sql); //sql을 미리 주면안됨
			rs = st.executeQuery();	//prepared된 sql문을 실행
			while(rs.next()) {
				int empid = rs.getInt(1);
				String fname = rs.getString(2);
				int sal = rs.getInt(3);
				Date hdate = rs.getDate(4);
				System.out.print(empid+"\t" + fname +"\t"+ sal);
				System.out.println("\t" + hdate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			OracleUtil.dbDisconnect(rs, st, conn);
		}
	}

	//OracleUtil 활용 버전
	private static void f1() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String userid = "hr", pass = "hr";
		String sql = """
				select first_name,department_id, department_name, city
				from employees join departments using(department_id)
				                join locations using(location_id)
				where job_id in(
				    select job_id
				    from jobs
				    where substr(job_title, -7) = initcap('manager')
				    )
				""";
		try {
			conn = OracleUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				String fname = rs.getString(1);
				int deptid = rs.getInt(2);
				String deptname = rs.getString(3);
				String city = rs.getString(4);

				System.out.printf("%s\t%d\t%10s\t%s\t\n", fname, deptid, deptname, city);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, st, conn);
		}

		// 1.Driver load
		// 2.DB 연결
		// 3. SQL문 보낼 통로 만들기
		// 4. SQL문 실행
		// 5. 결과 받아서 이용
		// 6. 자원반납

	}
}

//진짜원본
//package com.shinhan.oracle;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class JDBCPrograming {
//	public static void main(String[] args) {
//		f1();
//	}
//
//	private static void f1() {
//		Connection conn = null;
//		Statement st = null;
//		ResultSet rs = null;
//		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
//		String userid = "hr", pass = "hr";
//		String sql = """
//				select first_name,department_id, department_name, city
//				from employees join departments using(department_id)
//				                join locations using(location_id)
//				where job_id in(
//				    select job_id
//				    from jobs
//				    where substr(job_title, -7) = initcap('manager')
//				    )
//				""";
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//			conn = DriverManager.getConnection(url, userid, pass);
//			st = conn.createStatement();
//			rs = st.executeQuery(sql);
//			
//			while(rs.next()) {
//				String fname = rs.getString(1);
//				int deptid = rs.getInt(2);
//				String deptname = rs.getString(3);
//				String city = rs.getString(4);
//				
//				System.out.printf("%s\t%d\t%10s\t%s\t\n", fname, deptid, deptname, city);
//			}
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				// try 없이 .close 쓰면 안됨 : 열기도 전에 에러나면 닫을게 없기 때문
//				//Class.forName("oracle.jdbc.OracleDriver");가 먼저 실행되는데 여기서 에러나면 안되니까
//				if (null != rs)
//					rs.close();
//				if (null != st)
//					st.close();
//				if (null != conn)
//					conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//		// 1.Driver load
//		// 2.DB 연결
//		// 3. SQL문 보낼 통로 만들기
//		// 4. SQL문 실행
//		// 5. 결과 받아서 이용
//		// 6. 자원반납
//
//	}
//}
