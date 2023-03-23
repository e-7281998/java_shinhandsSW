package com.shinhan.day02;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

//javs.lang 패키지에 있는 클래스는 import 없이 사용 가능

public class ScannerTest {

	public static void main(String[] args) throws IOException {
		f2();
	}

	private static void f2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력해 : ");
		int score = sc.nextInt();
		System.out.print("이름 입력해 : ");
		String name = sc.next();
		sc.nextLine();	//라인 한 줄을 다 읽는다.
		String memo = sc.nextLine();	//이름 입력시 엔터를 먹어버림. 때문에 위 코드에서 엔터 먹고, 메모는 다시 받기.
		
		System.out.println(name + " ==> " + score);
		System.out.println(memo);
	}

	private static void f1() throws IOException {
		//사용자 입력 받기
		System.out.println("f1 function");	//System.out이 표준 출력
		System.out.print("정수를 입력하세요 >>> ");
		
		InputStream is = System.in;
		
//		int i1 = is.read();	//1byte만 읽음
//		System.out.println((char)i1);
		//만약 i1에 100을 입력해한 경우
		//강제형변환하지 않으면 아스키코드값인 49가 나옴
		
		int i;
		while((i = is.read()) != 13) {	//13은 아스키코드로 엔터임: 엔터 만날때까지 돌아
			System.out.print((char)i);
		}
	}

}
