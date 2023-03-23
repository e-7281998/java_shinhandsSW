package aproject.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.dbutil.OracleUtil;

import aproject.vo.EmpVO;

//DAO(Data Access Object):DB업무 ..CRUD..Insert,Select,Update,Delete 
public class EmpDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst;// ?지원
	CallableStatement cst; //sp지원
	ResultSet rs;
	int resultCount;// insert, update, delete건수
	
	public int[] insertAll(List<EmpVO> emplist) {
		int[] arr = new int[emplist.size()];
		String sql="""
				insert into employees 
				values(seq_employee.nextval,?,?,?,?,?,?,?,?,?,?)
				"""; 
		try {
			conn = OracleUtil.getConnection();
			pst = conn.prepareStatement(sql);
			
			
			for(EmpVO emp:emplist) {
				pst.setString(1, emp.getFirst_name() );
				pst.setString(2, emp.getLast_name() );
				pst.setString(3, emp.getEmail() );
				pst.setString(4, emp.getPhone_number() );
				pst.setDate(5, emp.getHire_date() );
				pst.setString(6, emp.getJob_id() );
				pst.setDouble(7, emp.getSalary());
				pst.setDouble(8, emp.getCommission_pct() );
				pst.setInt(9, emp.getManager_id() );
				pst.setInt(10, emp.getDepartment_id() );
				
				//반복문 돌면서 모아두었다가
				pst.addBatch();
			}
			//한번에 insert해줌
			pst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return arr;
		
	}
	
	
	//SP 호출 (프로시저 호출하기) : Stored Procedure : 저장 프로시저
	//sqldevelper(0317 line 10~22 프로시저를 42처럼) 실행하기 : oracle에서 우측 작업하듯.. execute sp_salary(101, :sal);
	public EmpVO getSalary(int empid) {
		String sql = "{call sp_salary(?, ?, ?)}";
		conn = OracleUtil.getConnection();
		EmpVO emp = new EmpVO();
		try {
			cst = conn.prepareCall(sql);
			cst.setInt(1, empid);
			cst.registerOutParameter(2, Types.DOUBLE);	//output 얻기
			cst.registerOutParameter(3, Types.VARCHAR);	//output 얻기
			//executeQuery(), executeUpdate();
			//cst.execute();	//resultset이 있으면 true이고(select일 때), 없으면 false(지금은 프로시저라 select없음)
			cst.executeQuery();	//위의 것도 되고, 이것도 됨... 
			//double salary = cst.getDouble(2);	//값 가져오기 (물음표 두번째 값 가져오기)
			emp .setSalary(cst.getDouble(2));
			emp.setFirst_name(cst.getString(3));
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return emp;
	}

	public List<EmpVO> selectAll() {
		String sql = """
				select  EMPLOYEE_ID,
						 FIRST_NAME,
						 LAST_NAME,
						 EMAIL,
						 PHONE_NUMBER,
						 HIRE_DATE,
						 JOB_ID,
						 f_tax(SALARY) SALARY,
						 COMMISSION_PCT,
						 MANAGER_ID,
						 DEPARTMENT_ID
				 from employees order by 1
				""";
		List<EmpVO> emplist = new ArrayList<>();
		conn = OracleUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			//칼럼이름 가져오기 위한 ..
			ResultSetMetaData meta = rs.getMetaData();
			int count = meta.getColumnCount();
			for(int i=1; i<=count; i++) {
			System.out.println("칼럼이름:" + meta.getColumnName(i));
			}
			
			while (rs.next()) {
				EmpVO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, st, conn);
		}
		return emplist;
	}
	//자신의 속한 부서의 평균 급여보다 더 적은 급여를 받는 직원들을 조회하시오
	public List<EmpVO> selectLAB() {
		String sql = """
				select employee_id, first_name, salary, employees.department_id
				from employees, 
                                 (select department_id, avg(salary) sal
                                from employees
                                group by  department_id )  inlineview_emp
				where employees.department_id = inlineview_emp.department_id
				and employees.salary < inlineview_emp.sal
				""";
		List<EmpVO> emplist = new ArrayList<>();
		conn = OracleUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				EmpVO emp = makeEmp2(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, st, conn);
		}
		return emplist;
	}
	
	
	// 특정직원 조회
	public EmpVO selectById(int empid) {
		EmpVO emp = null;
		String sql = "select * from employees where employee_id = " + empid;
		conn = OracleUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				emp = makeEmp(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			OracleUtil.dbDisconnect(rs, st, conn);
		}
		return emp;
	}

	// 특정부서의 직원조회
	public List<EmpVO> selectByDept(int deptid) {
		String sql = "select * from employees where department_id = " + deptid;
		List<EmpVO> emplist = new ArrayList<>();
		conn = OracleUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				EmpVO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			OracleUtil.dbDisconnect(rs, st, conn);
		}
		return emplist;
	}

	// 특정부서, jobid, salary이상 직원조회
	public List<EmpVO> selectByCondition(int deptid, String jobid, double salary) {
		String sql = "select * "
				+ " from employees "
				+ " where department_id = ? "
				+ " and job_id = ? "
				+ " and salary >= ? ";
		List<EmpVO> emplist = new ArrayList<>();
		conn = OracleUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, deptid);
			pst.setString(2, jobid);
			pst.setDouble(3, salary);
			rs = pst.executeQuery();
			while (rs.next()) {
				EmpVO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			OracleUtil.dbDisconnect(rs, pst, conn);
		}
		return emplist;
	}

	//신규직원등록 (insert)
	public int empInsert(EmpVO emp) {
		String sql="""
				insert into employees 
				values(seq_employee.nextval,?,?,?,?,?,?,?,?,?,?)
				""";
		conn = OracleUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, emp.getFirst_name() );
			pst.setString(2, emp.getLast_name() );
			pst.setString(3, emp.getEmail() );
			pst.setString(4, emp.getPhone_number() );
			pst.setDate(5, emp.getHire_date() );
			pst.setString(6, emp.getJob_id() );
			pst.setDouble(7, emp.getSalary());
			pst.setDouble(8, emp.getCommission_pct() );
			pst.setInt(9, emp.getManager_id() );
			pst.setInt(10, emp.getDepartment_id() );

			resultCount = pst.executeUpdate();//DML문장실행한다.영향받은건수가 return 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			 OracleUtil.dbDisconnect(null, pst, conn);
		}
		return resultCount;
	}
	
	//직원정보 수정하기 (insert)
		public int empUpdate(EmpVO emp) {
			String sql="""
					update employees
						set email = ?, department_id =?, job_id=?, salary=?,
						hire_date = ?, manager_id = ?
						where employee_id =?
					""";
			conn = OracleUtil.getConnection();
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1, emp.getEmail() );
				pst.setString(3, emp.getJob_id() );
				pst.setDouble(4, emp.getSalary());
				pst.setInt(2, emp.getDepartment_id() );
				pst.setDate(5, emp.getHire_date() );
				pst.setInt(6, emp.getManager_id() );

				
				pst.setInt(7, emp.getEmployee_id());

				resultCount = pst.executeUpdate();//DML문장실행한다.영향받은건수가 return 
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				 OracleUtil.dbDisconnect(null, pst, conn);
			}
			return resultCount;
		}
	
		//한건의 직원을 삭제하기
		public int empDelete(int emp) {
			String sql="""
					delete from employees
						where employee_id =?
					""";
			conn = OracleUtil.getConnection();
			try {
				pst = conn.prepareStatement(sql);				
				pst.setInt(1, emp);

				resultCount = pst.executeUpdate();//DML문장실행한다.영향받은건수가 return 
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				 OracleUtil.dbDisconnect(null, pst, conn);
			}
			System.out.println("delete결과: " + resultCount);
			return resultCount;
		}
	
	
	
	private EmpVO makeEmp(ResultSet rs) throws SQLException {
		EmpVO emp = new EmpVO();
		emp.setCommission_pct(rs.getDouble("Commission_pct"));
		emp.setDepartment_id(rs.getInt("Department_id"));
		emp.setEmail(rs.getString("Email"));
		emp.setEmployee_id(rs.getInt("Employee_id"));
		emp.setFirst_name(rs.getString("First_name"));
		emp.setHire_date(rs.getDate("Hire_date"));
		emp.setJob_id(rs.getString("Job_id"));
		emp.setLast_name(rs.getString("Last_name"));
		emp.setManager_id(rs.getInt("Manager_id"));
		emp.setPhone_number(rs.getString("Phone_number"));
		emp.setSalary(rs.getDouble("Salary"));

		return emp;
	}
	
	private EmpVO makeEmp2(ResultSet rs) throws SQLException {
		EmpVO emp = new EmpVO();
		emp.setEmployee_id(rs.getInt("Employee_id"));
		emp.setDepartment_id(rs.getInt("Department_id"));
		emp.setEmployee_id(rs.getInt("Employee_id"));
		emp.setFirst_name(rs.getString("First_name"));
		emp.setSalary(rs.getDouble("Salary"));
		emp.setHire_date(rs.getDate("Hire_date"));
		emp.setManager_id(rs.getInt("Manager_id"));


		return emp;
	}
	
	
}













//package aproject.model;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.shinhan.dbutil.OracleUtil;
//
//import aproject.vo.EmpVO;
//
////DAO : Data Access Object : DB 업무 : CRUD 업무 (: insert, select, update, delete)
//public class EmpDAO {
//	//필드는 자동으로 new 할 때 자동으로 초기화 됨.
//	//Connection conn = null; 하지 않아도 됨.
//	
//	Connection conn;
//	Statement st;
//	PreparedStatement pst;	//?지원
//	ResultSet rs;	//결과 값 받는 곳
//	int resultCount;	//insert, update, delete 건수
//	
//	//List<EmpVO> 직원이 여러건 있어
//	public List<EmpVO> selectAll () {
//		String sql = "select * from employees order by 1";
//		List<EmpVO> emplist = new ArrayList<>();
//		conn = OracleUtil.getConnection();	//DB 연결 //사전에 만들어 놓음..
//		try {
//			st = conn.createStatement();	//통로 만들기
//			rs = st.executeQuery(sql);	//결과가 넘어옴	 (실행은 sql에서 하고)
//			
//			while(rs.next()) {
//				EmpVO emp = makeEmp(rs);	//결과 너무 많으니까 다른 애 시키자
//				emplist.add(emp);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			OracleUtil.dbDisconnect(rs, st, conn);
//		}
//		
//		
//		return emplist;
//	}
//	//자신이 속한 부서의 평균 급여보다 더 적은 급여를 받는 직원 조회
//	public List<EmpVO> selectLAB () {
//		String sql = """
//				select employee_id, first_name, salary, employees.department_id
//				from employees, (
//                				select department_id, avg(salary) sal
//                				from employees
//                				group by department_id
//                				) view_emp
//				where employees.department_id = view_emp.department_id
//				and employees.salary < view_emp.sal
//				""";
//		List<EmpVO> emplist = new ArrayList<>();
//		conn = OracleUtil.getConnection();	//DB 연결 //사전에 만들어 놓음..
//		try {
//			st = conn.createStatement();	//통로 만들기
//			rs = st.executeQuery(sql);	//결과가 넘어옴	 (실행은 sql에서 하고)
//			
//			while(rs.next()) {
//				EmpVO emp = makeEmp2(rs);	//결과 너무 많으니까 다른 애 시키자
//				emplist.add(emp);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			OracleUtil.dbDisconnect(rs, st, conn);
//		}
//		
//		
//		return emplist;
//	}
//	
//	
//	//특정 직원 조회 : 1명만 조회 > List 필요 없음.. 그러므로 EmpVO 리턴
//	public EmpVO selectById (int empid) {
//		EmpVO emp = null;
//		String sql = "select * from employees where employee_id = " + empid;
//		conn = OracleUtil.getConnection();	//DB 연결 //사전에 만들어 놓음..
//		try {
//			st = conn.createStatement();	//통로 만들기
//			rs = st.executeQuery(sql);	//결과가 넘어옴	 (실행은 sql에서 하고)			
//			while(rs.next()) {
//				emp = makeEmp(rs);
//			}			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			OracleUtil.dbDisconnect(rs, st, conn);
//		}		
//		return emp;
//	}
//
//	//특정부서의 직원 조회 :여러건 조회 그러므로 List로 리턴
//	public List<EmpVO> selectByDept (int deptid) {
//		String sql = "select * from employees where department_id =" + deptid;
//		List<EmpVO> emplist = new ArrayList<>();
//		conn = OracleUtil.getConnection();
//		try {
//			st = conn.createStatement();
//			rs = st.executeQuery(sql);
//			
//			while(rs.next()) {
//				EmpVO emp = makeEmp(rs);
//				emplist.add(emp);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			OracleUtil.dbDisconnect(rs, st, conn);
//		}	
//		
//		
//		return emplist;
//	}
//	
//	//특정부서, jobid, salary 이상 직원 조회	//조건 조회이므로 이름을... Condition
//	public List<EmpVO> selectCondition (int deptid, String jobid, double salary) {
//		String sql = "select * "
//				+ "from employees "
//				+ "where department_id =? "
//				+ "and job_id = ? "
//				+ "and salary >= ? ";
//		List<EmpVO> emplist = new ArrayList<>();
//		conn = OracleUtil.getConnection();
//		try {
//			pst = conn.prepareStatement(sql);
//			pst.setInt(1, deptid);
//			pst.setString(2, jobid);
//			pst.setDouble(3, salary);
//			rs = pst.executeQuery();
//			
//			while(rs.next()) {
//				EmpVO emp = makeEmp(rs);
//				emplist.add(emp);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			OracleUtil.dbDisconnect(rs, pst, conn);
//		}	
//		
//		
//		return emplist;
//	}
//	
//	//신규 직원 등록 insert
//	public int empInsert(EmpVO emp) { //칼럼 11개 들고다니기 귀찮음 그래서 VO 사용 : VO : 데이터를 담는 가방
////		String sql = """
////				insert into employees
////				(EMPLOYEE_ID, LAST_NAME, EMAIL , HIRE_DATE, JOB_ID )
////				values(seq_employee.nextval , ? , ? , sysdate, ?)
////				""";
//		String sql = """
//				insert into employees
//				values(seq_employee.nextval ,? ,? ,? ,? ,? ,? ,?, ?, ?, ?)
//				""";
//		conn = OracleUtil.getConnection();
//		try {
//			pst = conn.prepareStatement(sql); //sql문장 준비
////			pst.setString(1, emp.getLast_name());
////			pst.setString(2, emp.getEmail());
////			pst.setString(3, emp.getJob_id());
//			pst.setString(1, emp.getFirst_name());
//			pst.setString(2, emp.getLast_name());
//			pst.setString(3, emp.getEmail());
//			pst.setString(4, emp.getPhone_number());
//			pst.setDate(5, emp.getHire_date());
//			pst.setString(6, emp.getJob_id());
//			pst.setDouble(7, emp.getSalary());
//			pst.setDouble(8, emp.getCommission_pct());
//			pst.setInt(9, emp.getManager_id());
//			pst.setInt(10, emp.getDepartment_id());
//			//오류메시지: column not allowed here : sql문장 주다가 오류난 것... sql문장 확인하기
//			resultCount = pst.executeUpdate();	//DML 문장 실행, 영향 받은 건수가 return //select가 아니면 다 update, 얘는 insert할 것이니 update.
//		} catch (SQLException e) {
// 			e.printStackTrace();
//		}finally {
//			OracleUtil.dbDisconnect(null, pst, conn);
//		}
//				
//		return resultCount;
//	}
//	
//	
//	private EmpVO makeEmp(ResultSet rs) throws SQLException {
//		EmpVO emp = new EmpVO();
//		emp.setCommission_pct(rs.getDouble("commission_pct"));
//		emp.setDepartment_id(rs.getInt("department_id"));
//		emp.setEmail(rs.getString("email"));
//		emp.setFirst_name(rs.getString("first_name"));
//		emp.setHire_date(rs.getDate("hire_date"));
//		emp.setJob_id(rs.getString("job_id"));
//		emp.setLast_name(rs.getString("last_name"));
//		emp.setManager_id(rs.getInt("manager_id"));
//		emp.setPhone_number(rs.getString("phone_number"));
//		emp.setSalary(rs.getDouble("salary"));
//		
//		return emp;
//	}
//	
//	private EmpVO makeEmp2(ResultSet rs) throws SQLException {
//		EmpVO emp = new EmpVO();
//		emp.setDepartment_id(rs.getInt("department_id"));
//		emp.setEmployee_id(rs.getInt("employee_id"));
//		emp.setFirst_name(rs.getString("first_name"));
//		emp.setSalary(rs.getDouble("salary"));
//		
//		return emp;
//	}
//
//}
