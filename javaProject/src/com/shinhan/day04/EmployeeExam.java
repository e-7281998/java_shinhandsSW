package com.shinhan.day04;

public class EmployeeExam {

	public static void main(String[] args) {

		Employee emps[] = new Employee[4];
		emps[0] = new Employee("이부장", "부장", 1500000);
		emps[1] = new Employee("김과장", "과장", 1495000);
		emps[2] = new Employee("최대리", "대리", 1260000);
		emps[3] = new Employee("박사원", "사원", 1050000);
		
		for(Employee emp:emps) {
			emp.print();
		}
	}
	

}
