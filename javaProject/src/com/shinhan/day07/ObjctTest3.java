package com.shinhan.day07;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Properties;
import java.util.Set;

//명령행 매개변수 > java Object3 100 200
public class ObjctTest3 {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3(args)
//		f4();
		f5();

		System.out.println("main end~");
	}

	private static void f5() {
		String os = System.getProperty("os.name");
		System.out.println(os);
		
		Properties ps = System.getProperties();
		for(Object key:ps.keySet()) {
			System.out.println("key: " + key);
			String val = System.getProperty((String) key);
			System.out.println("val: " + val);
			System.out.println("====================");
		}
		
//		Properties ps = System.getProperties();
//		Set<Object> keys = ps.keySet();
//		for(Object key:keys) {
//			System.out.println(key + " --------- " + System.getProperty((String)key));
//		}
	}

	private static void f4() {
		long startTime  = System.nanoTime();
		
		for(int i = 0; i<1000000000; i++) {
			
		}
		
		long endTime = System.nanoTime();
		System.out.println("걸린시간 : " + (endTime-startTime));
	}

	private static void f3(String[] arr) {
		if (arr.length == 0) {
			System.out.println("명령행 매개변수가 없다.");

			// 1. 함수 빠지기
			// return;

			// 2.프로그램 당장 종료
			System.exit(0);
		}
		System.out.println("매개변수: " + Arrays.toString(arr));
	}

	private static void f2() throws IOException {
		// 3. 표준입력(default 키보드)
		InputStream is = System.in; // InputStream : 1byte 씩 읽음 : 숫자는 괜찮음. 한글은 깨짐
		InputStreamReader ir = new InputStreamReader(is); // InputStreamReader : 2byte씩 읽음 : 한글 안깨짐 : 한글은 2byte
		int i;
		while ((i = ir.read()) != 13) {
			System.out.println((char) i);
		}
	}

	private static void f1() {
		// System class
		// 1. 표준 출력(모니터 출력)
		PrintStream ps1 = System.out;

		// 2. err
		PrintStream ps = System.err;

		ps.print(false);
		ps.printf("%10d", 100); // 10자리로 100을 찍어라
		ps.printf("%-10d", 100); // - : 왼쪽정렬
		ps.println("java");
		ps.println("==================");
	}

}
