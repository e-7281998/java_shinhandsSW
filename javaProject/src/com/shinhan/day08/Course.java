package com.shinhan.day08;

public class Course {

	//<?> 타입이 누구든 상관X
	public static void registerCourse1(Applicant<?> applicant) {
		System.out.println(applicant.kind.getClass().getSimpleName() + "가 등록했다.(모두)");
	}
	
	//Student, HighStudent, MiddleStudent 만 가능 : 하위만 가능
	public static void registerCourse2(Applicant<? extends Student> applicant) {
		System.out.println(applicant.kind.getClass().getSimpleName() + "가 등록했다. (Student, HighStudent, MiddleStudent");
	}
	
	//Worker의 상위만 가능 : Worker, Person만 가능
	public static void registerCourse3(Applicant<? super Worker> applicant) {
		System.out.println(applicant.kind.getClass().getSimpleName() + "가 등록했다. (Worker, Person)");
	}
}
