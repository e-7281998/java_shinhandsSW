package com.shinhan.day10.project;

import java.util.List;

//View : display 담당
public class DeptView {
	//오버로딩 : 이름은 같고, 매개변수 사양만 다름
	public static void print(String message) {
		System.out.println("알림: " + message);
	}
	
	public static void print(DeptVO dept) {
		System.out.println("Dept 정보 : " + dept);
	}
	
	public static void print(List<DeptVO> deptlist) {
		System.out.println("========dept list=========");
		for(DeptVO dept: deptlist) {
			System.out.println(dept);
		}
	}
}
