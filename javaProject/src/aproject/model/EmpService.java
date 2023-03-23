package aproject.model;

import java.sql.Statement;
import java.util.List;

import aproject.vo.EmpVO;

//Service : 업무로직담당 
public class EmpService {

	EmpDAO empDao = new EmpDAO();
	//SP 호출
	public EmpVO getSalary(int empid) {
		return empDao.getSalary(empid);
	}
	
	public List<EmpVO> selectAll() {
		//
		return empDao.selectAll();
	}
	public EmpVO selectById(int empid) {
		//
		return empDao.selectById(empid);
	}
	public List<EmpVO> selectByDept(int deptid) {
		return empDao.selectByDept(deptid);
	}
	public List<EmpVO> selectByCondition(int deptid, String jobid, double salary) {
		return empDao.selectByCondition(deptid, jobid, salary);
	}
	//자신의 속한 부서의 평균 급여보다 더 적은 급여를 받는 직원들을 조회하시오
	public List<EmpVO> selectLAB() {
		List<EmpVO> emplist = empDao.selectLAB();
		System.out.println("[EempService] 실행건수:" + emplist.size());
		return emplist;
	}
	//신규직원등록 (insert)
	public String empInsert(EmpVO emp) {
		int result = empDao.empInsert(emp);
		return result>0?"입력성공":"입력실패";
	}
	//직원정보 수정 (update)
	public String empUpdate(EmpVO emp) {
		int result = empDao.empUpdate(emp);
		return result>0?"update성공":"update실패";
	}
	//직원정보 1개 삭제 (delete)
	public String empDelete(int emp) {
		int result = empDao.empDelete(emp);
		return result>0?"삭제 성공":"삭제 실패";
	}
	
}











//package aproject.model;
//
//import java.util.List;
//
//import aproject.vo.EmpVO;
//
////Service : 업무로직 담당
////컨트롤러로부터 요청을 받으면 DAO에게 요청 후 결과 받아서 리턴해줌
//public class EmpService {
//	EmpDAO empDao = new EmpDAO();
//
//	public List<EmpVO> selectAll() {
//		return empDao.selectAll();
//	}
//
//	// 자신이 속한 부서의 평균 급여보다 더 적은 급여를 받는 직원 조회
//	public List<EmpVO> selectLAB() {
//		List<EmpVO> emplist = empDao.selectLAB();
//		System.out.println("[EmpService] 실행건수: " + emplist.size());
//		return emplist;
//	}
//
//	public EmpVO selectById(int empid) {
//		return empDao.selectById(empid);
//	}
//
//	public List<EmpVO> selectByDept(int deptid) {
//		return empDao.selectByDept(deptid);
//	}
//
//	public List<EmpVO> selectCondition(int deptid, String jobid, double salary) {
//		return empDao.selectCondition(deptid, jobid, salary);
//	}
//	
//	//신규 직원 등록 insert
//	public String empInsert(EmpVO emp) {
//		int result = empDao.empInsert(emp);
//		return result > 0 ? "[입력성공]" : "[입력실패]";
//	}
//}
