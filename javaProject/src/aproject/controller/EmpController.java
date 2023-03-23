package aproject.controller;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import aproject.model.EmpService;
import aproject.view.EmpView;
import aproject.vo.EmpVO;


 
//Servlet으로 대치될예정 
public class EmpController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmpService eService = new EmpService();
		
		while(true) {
			System.out.println("1.모든직원");
			System.out.println("2.직원상세");
			System.out.println("3.부서의직원");
			System.out.println("4.부서,직책, 급여로 조회");
			System.out.println("5.부서의평균급여이하를 받는 직원조회");
			
			System.out.println("6.신규직원등록");
			System.out.println("7.직원정보수정");
			System.out.println("8.직원정보삭제");
			System.out.println("9.직원의 급여 조회(SP)");
			System.out.println("exit 종료");
			System.out.print("====작업선택>>");
			//nextLine(1줄 enter포함)  | 공백분리한 단어 - nextInt(),next()
			String job = sc.next();
			if(job.equals("exit")) break;
			switch (job) {
			case "1":
				EmpView.print(eService.selectAll());
				break;
			case "2":{
				System.out.print("조회할 직원번호>>");
				int empid = sc.nextInt();
				EmpView.print(eService.selectById(empid));
				break;
			}
				
			case "3":{
				System.out.print("조회할 부서번호>>");
				int deptid = sc.nextInt();
				EmpView.print(eService.selectByDept(deptid));
				break;
			}
			case "4":{
				System.out.print("조회할 부서번호,job,salary>>");
				int deptid = sc.nextInt();
				String jobid = sc.next();
				double salary = sc.nextDouble();
				EmpView.print(eService.selectByCondition(deptid, jobid, salary));
				break;
			}
			case "5":
				List<EmpVO> empList = eService.selectLAB();
				System.out.println("[Controller] 5번작업:" + empList.size());
				EmpView.print(empList);
				break; 
			case "6":{
				EmpVO emp = makeEmp(sc);
				EmpView.print(eService.empInsert(emp));
				break;
			}
			case "7":{
				System.out.println("수정할 직원아이디");
				int empid = sc.nextInt();
				EmpView.print(eService.selectById(empid));
				EmpVO emp = makeEmp2(sc, empid);
				EmpView.print(eService.empUpdate(emp));
				break;
			}
			case "8":{
				System.out.println("삭제할 직원아이디");
				int empid = sc.nextInt();
				EmpView.print(eService.selectById(empid));
				System.out.println("삭제를 진행할까요?");
				String yn = sc.next();
				if(yn.equals("Y"))
					EmpView.print(eService.empDelete(empid));
				break;
			}
			case "9" :{
				System.out.print("조회할 직원번호>>");
				int empid = sc.nextInt();
				EmpView.print("급여는 " + eService.getSalary(empid));
				break;
			}
				
			default:
				break;
			}
		}
		System.out.println("수고하셨습니다.....");
	}

	private static EmpVO makeEmp(Scanner sc) {
		System.out.print("1.신규직원의 first_NAME>>");
		String fName = sc.next();
		System.out.print("2.신규직원의 LAST_NAME>>");
		String lastName = sc.next();
		System.out.print("3.신규직원의 email>>");
		String email = sc.next();
		System.out.print("4.신규직원의 jobid>>");
		String jobid = sc.next();
		System.out.print("5.신규직원의 phone>>");
		String phone = sc.next();
		
		System.out.print("6.신규직원의 manager>>");
		int mid = sc.nextInt();
		System.out.print("7.신규직원의 dept>>");
		int deptid = sc.nextInt();
		System.out.print("8.신규직원의 commission>>");
		double comm = sc.nextDouble();
		System.out.print("9.신규직원의 salary>>");
		double sal = sc.nextDouble();
		
		System.out.print("10.신규직원의 입사일 yyyy/mm/dd>>");
		String sdate = sc.next();
		//String->Date
		Date hiredata = DateUtil.convertToDate(sdate);
		
		EmpVO emp = new EmpVO();
		emp.setLast_name(lastName);
		emp.setEmail(email);
		emp.setJob_id(jobid);	
		emp.setCommission_pct(comm);
		emp.setDepartment_id(deptid);
		emp.setFirst_name(fName);
		emp.setHire_date(hiredata);
		emp.setManager_id(mid);
		emp.setPhone_number(phone);
		emp.setSalary(sal);
		return emp;
	}
	
	private static EmpVO makeEmp2(Scanner sc, int empid) {

		System.out.print("1.신규직원의 email>>");
		String email = sc.next();
		System.out.print("2.신규직원의 jobid>>");
		String jobid = sc.next();

		System.out.print("3.신규직원의 dept>>");
		int deptid = sc.nextInt();

		System.out.print("4.신규직원의 salary>>");
		double sal = sc.nextDouble();
		
		System.out.print("5.신규직원의 입사일 yyyy/mm/dd>>");
		String sdate = sc.next();
		Date hiredata = DateUtil.convertToDate(sdate);
		
		System.out.print("6.신규직원의 manager>>");
		int mid = sc.nextInt();

		EmpVO emp = new EmpVO();
		emp.setEmployee_id(empid);
		emp.setEmail(email);
		emp.setJob_id(jobid);	
		emp.setDepartment_id(deptid);
		emp.setHire_date(hiredata);
		emp.setManager_id(mid);
		emp.setSalary(sal);
		return emp;
	}

}
















//package aproject.controller;
//
//import java.sql.Date;
//import java.util.List;
//import java.util.Scanner;
//
//import aproject.model.EmpService;
//import aproject.view.EmpView;
//import aproject.vo.EmpVO;
//
//public class EmpController {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		EmpService eService = new EmpService();
//		
//		while(true) {
//			System.out.println("1. 모든직원");
//			System.out.println("2. 직원 상세");
//			System.out.println("3. 부서의 직원");
//			System.out.println("4. 부서, 직책, 급여로 조회");
//			System.out.println("5. 부서의 평균 급여 이하를 받는 직원");
//			System.out.println("6. 직원 입력");
//			System.out.println("7. 부서의 직원");
//			System.out.println("exit 종료");
//			System.out.println("==== 작업 선택 >>>");
//			
//			
//			String job = sc.nextLine();
//			if(job.equals("exit")) break;
//			switch (job) {
//			case "1":
//				EmpView.print(eService.selectAll());
//				break;
//			case "2":
//				System.out.print("조회할 직원번호 >>>");
//				int empid = sc.nextInt();
//				sc.nextLine();
//				EmpView.print(eService.selectById(empid));
//				break;
//			case "3":{
//				System.out.print("조회할 부서번호 >>>");
//				int deptid = sc.nextInt();
//				sc.nextLine();
//				EmpView.print(eService.selectByDept(deptid));
//				break;
//			}
//			//같은 이름의 지역변수 선언 원하면 블럭으로 감싸기 { }
//			//case 4에서도 deptid 사용하고 싶음. 이미 3번에 사용함. 위로 올라가서 변수 선언하기는 싫음
//			//{ } 로 감싸면 지역변수로 사용 가능... 3과 동일한 지역변수 사용 가능.
//			case "4":{	
//				System.out.print("조회할 부서번호, job, salary >>>");
//				int deptid = sc.nextInt();
//				String jobid = sc.next();
//				double salary = sc.nextDouble();
//				sc.nextLine();
//				EmpView.print(eService.selectCondition(deptid, jobid, salary));
//				break;
//			}
//			case "5":
//				List<EmpVO> empList = eService.selectLAB();
//				System.out.println("[Controller] 5번 작업: "+empList.size());
//				EmpView.print(empList);
//				break;
//			case "6":
//				System.out.println("1.신규직원의 First_name >>>");
//				String firstName = sc.next();
//				System.out.println("2.신규직원의 Last_name >>>");
//				String lastName = sc.next();
//				System.out.println("3.신규직원의 email >>>");
//				String email = sc.next();
//				System.out.println("4.신규직원의 Phone >>>");
//				String phone = sc.next();
//				System.out.println("5.신규직원의 Hire_date : yyyy/mm/dd>>>");
//				String sDate = sc.next();
//				//문자를 날짜로 바꿔라
//				Date hireDate = DateUtil.convertToDate(sDate);
//				System.out.println("6.신규직원의 Job_id >>>");
//				String jobId = sc.next();
//				System.out.println("7.신규직원의 salary >>>");
//				Double salary = sc.nextDouble();
//				System.out.println("8.신규직원의 Commission_pct >>>");
//				Double commissionPct = sc.nextDouble();
//				System.out.println("9.신규직원의 Manager_id >>>");
//				int managerId = sc.nextInt();
//				System.out.println("10.신규직원의 Department_id >>>");
//				int DepartmentId = sc.nextInt();
//				
//				EmpVO emp = new EmpVO();
//				emp.setFirst_name(firstName);
//				emp.setLast_name(lastName);
//				
//				emp.setEmail(email);
//				emp.setPhone_number(phone);
//				emp.setHire_date(hireDate);
//				emp.setJob_id(jobId);
//				emp.setSalary(salary);
//				emp.setCommission_pct(commissionPct);
//				emp.setManager_id(managerId);
//				emp.setDepartment_id(DepartmentId);
//				EmpView.print(eService.empInsert(emp));
//			default:
//				break;
//			}
//		}
//		System.out.println("종료되었습니다.");
//	}
//}
