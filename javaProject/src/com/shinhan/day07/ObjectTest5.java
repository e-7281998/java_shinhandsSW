package com.shinhan.day07;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ObjectTest5 {

	public static void main(String[] args) throws IOException{
//		f1();
//		f2();
//		f6();
		f9();
		
	}
	private static void f9() throws IOException {
		InputStream is = ObjectTest5.class.getResourceAsStream("CellPhone.java");
		InputStreamReader ir = new InputStreamReader(is);
		int i;
		while((i = ir.read())!= -1) {
			System.out.print((char)i);
		}
		is.close();
	}
	
	private static void f8() throws IOException {
		//ObjectTest5.class은 /bin에 있는 경로임
		URL url = ObjectTest5.class.getResource("_126241775_getty_cats.png");	//현재경로에서 파일 찾을 때 getResource 사용
		System.out.println(url.getPath());
	}
	
	private static void f7() throws IOException {
		FileReader fr= new FileReader("src/com/shinhan/day07/CellPhone");
		int i;
		while((i= fr.read())!=-1) {
			System.out.println((char)i);
		}
	}
	private static void f6() throws ClassNotFoundException{
		//클래스 정보 얻는 방법1
		Class cls = CellPhone.class;	//class타입에 넣을 수 있음
		
		
		Method[] ms = cls.getDeclaredMethods();
		for(Method m:ms) {
			System.out.println(m.getName());
			System.out.println(m.getParameterCount() );
		}
		
		//클래스 정보 얻는 방법2
		Class cls2 = Class.forName("com.shinan.day07.CellPhone");	//이름 줌
		
		//클래스 정보 얻는 방법3
		CellPhone phone = new CellPhone("AA");
		Class cls3 = phone.getClass();
		
		Field[] fs = cls.getDeclaredFields();
		System.out.println(fs.length);
		for(Field f:fs) {
			System.out.println(f.getName());
		}
		
//		Constructor[] constructors = cls.getDeclaredConstructors();	//생성자 정보들 얻어냄
//		for(Constructor con: constructors) {
//			System.out.println(con.getModifiers());
//		}
		
	}
	private static void f5() {
		String p1 = "010-([0-9]{3,4})-\\d{4}";
		String data = "010-1234-5678 이곳으로 연락 바람 혹은 010-2222-1115";
		Pattern pattern = Pattern.compile(p1);	//찾고자하는 패턴을 빼옴
		Matcher matcher = pattern.matcher(data);	//매칭되는 것을 찾아줌
		while(matcher.find()) {	//있는지 물어봄
			System.out.println(matcher.group(1));
		}
	}
	
	
	private static void f4() {
		String p1 = "([A-Za-z0-9]+)@(\\w+)\\.\\w+";
		String data = "연락처1: wed0406@daum.net 연락처2: aaa@naver.com 연락처3: bbb@kakao.com";
		Pattern pattern = Pattern.compile(p1);	//찾고자하는 패턴을 빼옴
		Matcher matcher = pattern.matcher(data);	//매칭되는 것을 찾아줌
		while(matcher.find()) {	//있는지 물어봄
//			System.out.println(matcher.group());	
			System.out.println(matcher.group(1));	//( ) 괄호를 기준으로 그룹으로 나뉨
			System.out.println(matcher.group(2));
			System.out.println("====================");
		}

	}
	
	private static void f3() {
		String p1 = "010-[0-9]{3,4}-\\d{4}";
		String data = "010-1234-5678 이곳으로 연락 바람 혹은 010-2222-1115";
		Pattern pattern = Pattern.compile(p1);	//찾고자하는 패턴을 빼옴
		Matcher matcher = pattern.matcher(data);	//매칭되는 것을 찾아줌
		while(matcher.find()) {	//있는지 물어봄
			System.out.println(matcher.group());
		}
	}
	
	private static void f2() {
		String p1 = "[A-Za-z0-9]+@\\w+\\.\\w+";
		String data = "*wed0406@daum.net";
		boolean result = Pattern.matches(p1, data);
		System.out.println(result ? "OK" : "NO");
	}

	private static void f1() {
		//{3,4} 3자리이거나 4자리
		// \(역슬래시)는 제어문자임, \사용하려면 \\
		//d : 데시만
		//[0-9]와 \\d는 같은의미
		String p1 = "010-[0-9]{3,4}-\\d{4}";
		String data = "010-1234-5678";
		boolean result = Pattern.matches(p1, data);
		System.out.println(result? "OK" : "NO");
	}

}
