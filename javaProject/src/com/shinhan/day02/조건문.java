package com.shinhan.day02;

import java.util.Scanner;

public class 조건문 {

	public static void main(String[] args) {
		method3();
	}

	private static void method3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("월 >>> ");
		int month = sc.nextInt();
		String message = "";
	
		//8버전은 ,사용 불가
		switch(month) {
		case 12,1,2:
			message = "겨울 입니다.";
			break;
		case 3,4,5:
			message = "봄 입니다.";
			break;
		case 6,7,8:
			message = "여름 입니다.";
			break;
		case 9,10,11:
			message = "가을 입니다.";
			break;
		default:
			message = "월 입력이 잘못 되었습니다.";
		}
		
		System.out.println(message);
	}

	private static void method2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하세요: ");
		int score = sc.nextInt();
		String grade = "";
		
		//90-100  A
		//80-89 B 
		//70-79 C 
		//60-69 D
		//F
		
		switch (score/10) {	//score을 10나는 것. 몫만으로 등급 나눔
		case 10:
		case 9:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
			
		default:
			grade = "F";
			break;
		}
		
		System.out.println("결과는" + score + " ==> " + grade); 
	}

	private static void method1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하세요: ");
		int score = sc.nextInt();
		String grade = "";
		
		if(score > 90) {
			grade = "A";
		}
		
		System.out.println("결과는" + score + " ==> " + grade); 
	}

}
