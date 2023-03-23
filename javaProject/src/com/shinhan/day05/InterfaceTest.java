package com.shinhan.day05;

import java.util.LinkedList;
import java.util.List;

public class InterfaceTest {

	public static void main(String[] args) {
//		f1();
//		f2();
		f3();
//		f5();
	}

	private static void f5() {
		String arr[] = new String[] {"자바", "SQL", "CSS", "HTML"};
		//List, Set, Map : Interface임
		//List Interface : 순서가 있음 / 중복 허용 : ArrayList, Vector, LinkedLIst
		//Set : 순서가 없음 / 중복 불가
		
		//**다음은 내가 쓴거
		//ArrayList<String> data = new ArrayList<String>();	//이렇게 사용 안함
		//ArrayList, Vector, LinkedLIst를 사용하면 나중에 ArrayList에서 Vector로 바뀔경우 모든 곳을 바꿔야 함
		//: 코드 난리남 :유지보수 불편 : 코드가 흔들림
		//때문에 이 모든것의 interface인 LinkedList를 사용하면 유지보수에 용이

		LinkedList<String> data = new LinkedList<String>();	
		data.add("자바");
		data.add("SQL");
		data.add("CSS");
		data.add("자바");		//중복 허용
		data.add("HTML");	
		print(data);
	}
	
	static void print(List<String> data) {
		for(String s:data) {
			System.out.println(s);
		}
	}

	private static void f3() {
		f4(new Television());
		f4(new Audio());
	}

	//Television이 올지 Audio가 올지 모르니까 RemoteControl로 받음
	//자동형변환 + override ===> 다형성 : 사용법은 같고, 결과는 다양하다.
	private static void f4(RemoteControl remote) {
		remote.powerOn();
		remote.powerOff();
		remote.display();	//audio, television 다 추가해야 함.

		//remote.display2();	//접근 불가. 왜? 인터페이스꺼라서
		RemoteControl.dispay2(); //static이므로 이렇게만 사용 가능
		
		if(remote instanceof Audio audio) {
			//RemoteControl의 display2와 이름만 같은 것임.
			//오디오타입임을 알 때만 호출 가능.
			audio.display2();
			audio.wifiTurnOn();
		}
		if(remote instanceof Wifi wf) {
			wf.wifiTurnOn();
		}
		
	}

	private static void f2() {
		String s1 = "A";
		String s2 = "C";
		System.out.println(s1.compareTo(s2));
	}

	private static void f1() {
		//1. 객체 생성
		OracleDB db = new OracleDB();
		SybaseDB db2 = new SybaseDB();
		
		//OracleDB 사용
		
		//SybaseDB 사용
		
		use(db2);
	}

	private static void use(JDBCInterface db) {
		db.dbConnect("데이터베이스");
	}

}
