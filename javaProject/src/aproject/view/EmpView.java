package aproject.view;

import java.util.List;

import aproject.vo.EmpVO;

//다음의 것들은 오버로딩임. (메소드명은 같고, 매개변수만 다르기 때문)
public class EmpView {
	public static void print(List<EmpVO> emplist) {
		System.out.println("===========직원들 정보===========");
		for (EmpVO emp : emplist) {
			System.out.println(emp);
		}
		System.out.println("==============================");

	}

	public static void print(EmpVO emp) {
		System.out.println("===========직원 상세보기===========");
		if(emp == null) {
			print("직원이 존재하지 않습니다.");
		}else {
			System.out.println(emp);
		}
		System.out.println("==============================");

	}
	
	public static void print(String message) {
		System.out.println("[알림]" + message);
	}
}
