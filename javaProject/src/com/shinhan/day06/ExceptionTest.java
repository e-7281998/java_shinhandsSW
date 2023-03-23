package com.shinhan.day06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//Exception(예외) : 프로그래머의 노력으로 프로그램이 중단되지 않고, 계속 진행하도록 할 수 있다.
public class ExceptionTest {
	private static FileInputStream rf;
	private static char i;

	public static void main(String[] args) throws IOException{
		System.out.println("main start");
//		f1();
//		f2();
//		f3();
//		f5();
		try {
			f6();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("main end");
	}

	private static void f6() throws ClassNotFoundException {
		Class cls = Class.forName("com.shinhan.day06.Book");
		System.out.println(cls.getSimpleName());
	}

	private static void f5() throws IOException {
		// 컴파일시점에 반드시 해결해야 한다.
		// 2. 이 함수를 호출한 곳에 떠넘긴다.
		FileReader fr = new FileReader("./src/com/shinhan/day06/Book.java");
		int i;

		while ((i = fr.read()) != -1) {
			System.out.print((char) i);
		}
	}

	private static void f4() {
		// 1. 내가한다. 2//떠넌긴다.

		FileReader fr = null;
		int i;
		// try 종료후 자원이 자동 반납한다.
		try (FileReader fr1 = new FileReader("./src/com/shinhan/day06/Book.java")) {
			while ((i = fr1.read()) != -1) {
				System.out.println((char) i);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException ex) {

			}
		}

	}

	private static void f3() {
		// 일반 exception : 컴파이리점에 만드시 해결해야 한다.
		// 1. 내가한다. 2//떠넌긴다.

		FileReader fr = null;
		int i;
		try {
			fr = new FileReader("./src/com.shinhan/doy06.Book.jva");
			while ((i = fr.read()) != -1) {
				System.out.println((char) i);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException ex) {

			}
		}

//		FileReader fr = null ;	//지역변수는 꼭 초기화 해주어야 한다.
//		try {
//			 fr = new FileReader("src/com/shinhan/day06/Book.java");
//			System.out.println("파일 존재한다. 파일 열림");
//			
//			while((int i = fr.read()) != -1) {
//				System.out.println((char)i);
//			}
//			
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				fr.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}chatc(NullPointerException ex){
//		E
//			}
//			
//		}
	}

	private static void f2() {
		// if로 조건체크해서 오류가 없는 코드를 수행하지 않고 try-catch로 처리한 이요
		// : 업무로직, 오류처리로직 분리위해

		/*
		 * // 1. ArithmeticException try { int a = 10; int b = 0; System.out.println(a /
		 * b); System.out.println("여기는 안옴"); } catch (ArithmeticException ex) { //
		 * ex.printStackTrace(); // 오류과정 출력 System.out.println(ex.getMessage()); //오류
		 * 메시지만 출력 }
		 */

		/*
		 * 2. ArrayIndexOutOfBoundsException... try {
		 * 
		 * int[] arr = new int[5]; System.out.println(arr[0]);
		 * System.out.println(arr[5]); }catch(ArithmeticException ex) {
		 * ex.printStackTrace(); // 오류과정 출력
		 * 
		 * }catch(ArrayIndexOutOfBoundsException ex) { ex.printStackTrace(); // 오류과정 출력
		 * }
		 * 
		 */

		/*
		 * 3. ClassCastException try { // Object obj = new String("자바"); Object obj =
		 * new Object(); System.out.println(obj.toString()); String s = (String) obj;
		 * System.out.println(s.length());
		 * 
		 * } catch (ArithmeticException ex) { ex.printStackTrace(); // 오류과정 출력
		 * 
		 * } catch (ArrayIndexOutOfBoundsException ex) { ex.printStackTrace(); // 오류과정
		 * 출력 } catch (ClassCastException ex) { ex.printStackTrace(); // 오류과정 출력
		 * 
		 * }
		 */

		// 4.NumberFormatException
		try {
//			String su = "100점";
//			int total = Integer.parseInt(su) + 200;
//			System.out.println(total);

		} catch (ArithmeticException ex) {
			ex.printStackTrace(); // 오류과정 출력

		} catch (ArrayIndexOutOfBoundsException ex) {
			ex.printStackTrace(); // 오류과정 출력
		} catch (ClassCastException | NumberFormatException ex) { // 오류 여럭 한번에 작성 가능 | 이용
			ex.printStackTrace(); // 오류과정 출력

		} catch (Exception ex) { // catch는 하위먼저 상위 나중에 작성.
			ex.printStackTrace();
			System.out.println("나머지 오류 : " + ex);
		} finally { // err 여부에 상관없이 이곳을 반드시 처리한다.
			System.out.println("이 부분은 반드시 처리한다... 자원 반납코드를 쓴다. dbdisconnect, fileClose");
		}

	}

	private static void f1() {
		// 실행예외 : 컴파일시에 오류 없음, 실행시 오류. (비정상 종료)
		// 런타임 에러
		// 1. ArithmeticException
		// 0으로 나눔
		int a = 10;
		int b = 0;
//		System.out.println(a/b);

		// 2. ArrayIndexOutOfBoundsException...
		// 배열 범위 잘못 됨
		int[] arr = new int[5];
		System.out.println(arr[0]);
//		System.out.println(arr[5]);

		// 3. ClassCastException
		// Object는 String으로 캐스팅하려 했음
		Object obj = new String("자바");
//		Object obj = new Object();
		System.out.println(obj.toString());
		String s = (String) obj;
		System.out.println(s.length());

		// 4.NumberFormatException
		// 글자를 숫자형으로 바꾸려했음
		String su = "100";
//		String su = "100점";
		int total = Integer.parseInt(su) + 200;
		System.out.println(total);

		// 기타예외 : 컴파일시에 반드시 처리해야 한다.
	}
}
