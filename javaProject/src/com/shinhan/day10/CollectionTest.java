package com.shinhan.day10;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;

import com.shinhan.day04.Employee;
import com.shinhan.day05.Account;

public class CollectionTest {
	public static void main(String[] args) throws IOException {
		f9();
	}
	
	private static void f9() throws IOException {
		//Stream : 데이터의 흐름
		Properties pro = new Properties();
		//inputStream : 1byte씩 읽음 ? //Reader  2byte씩 읽음 ?
		//방법 1
		//getResourceAsStream : 그 경로이 있는~
		//pro.load(CollectionTest.class.getResourceAsStream("oracleInfo.properties"));	//stream은 1byte씩 읽음
		//방법 2 : 안좋음 : src는 배포하지 않으므로
		InputStream fis = new FileInputStream("src/com/shinhan/day10/oracleInfo.properties");
		pro.load(fis);
		
		//방법2
		String myname = pro.getProperty("myname");
		System.out.println(myname);
		
		for(Object key :pro.keySet()) {
			String value = pro.getProperty((String)key);
			System.out.println(key + " --- " + value);
		}
	}

	private static void f8() {
		//key는 Set이다.
		//Set은 add시에 동등 객체인지 확이한다. 동동하면 add 불가(add 실패)
		//Map은 put()시 key를 찾는다. 동등한 것을 찾으면 값을 replace한다. 없으면 무조건 추가
		//다음의 hashmap과 hashtable은 똑같이 동작함.
		//다만 스레드의 환경이 아니라면 hashtable사용할 것 ~
		//Map<Employee, Account> data = new HashMap<>();
		Map<Employee, Account> data = new Hashtable<>();
		
		data.put(new Employee("태민", "대리", 1000) , new Account("1234", "태민", 2000));
		//내가씀 : 다음의 코드 "태민"은 key는 값을 덮을 수 없음, value만 바뀜
		//왜 ? 현재 Employee에서는 이름과 직급만 비교하도록 재정의 해놓음.
		data.put(new Employee("태민", "대리", 6000) , new Account("0505", "태민", 5000)); 
		data.put(new Employee("민호", "사원", 5000) , new Account("1234", "민호", 2000));
		data.put(new Employee("진기", "부장", 6000) , new Account("1234", "진기", 6500));
		data.put(new Employee("기범", "과장", 10000) , new Account("1234", "기범", 8000));
		
		for(Employee emp :data.keySet()) {
			//toString 재정의 필요 : key 타입이 객체이므로 주소 찍힘
			//hashCode, equals 재정의 필요 : 동등비교 위해 (안하면 결과 5개 나옴)
			System.out.println("key : " + emp);
			System.out.println("value : " + data.get(emp));
			System.out.println("-------------------------------");
		}
		
		System.out.println("key 찾기");
		//내가씀 : 둘다 true 왜 ? Employee에서 이름과 직급만 비교하도록 재정의 되어 있음
		//내가씀 : 다르다고 하고 싶으면 baseSalary도 비교하도록 재정의 해야 함.
		System.out.println(data.containsKey(new Employee("태민", "대리", 1000) ));
		System.out.println(data.containsKey(new Employee("태민", "대리", 6000) ));
	
	}

	private static void f7() {
		//Map : key와 value의 쌍. (Entry), key는 Set이므로 중복 불가
		//구현 클래스 : HashMap, HashTable
		HashMap<String, Integer> data = new HashMap<>();
		data.put("탬", 70);
		data.put("밤", 50);
		data.put("둡", 50);
		data.put("쫑", 100);
		data.put("탬", 100);
		
		int sum = 0;
		
		System.out.println("key가 중복되면 마지막 값이 유효 : " + data.get("탬"));
		//1. 일반 for	 -- 불가 : n 번째 지정 불가능
		//2. 향상 for
		//entry는 1건을 의미, entrySet은 여러건을 의미
		for(Entry<String, Integer> entry :data.entrySet()) {	//.entrySet() 엔트리랄 다 가져와
			System.out.println(entry.getKey() + " ===> " + entry.getValue());
			sum += entry.getValue();
		}
		System.out.println("총점 : " + sum);
		System.out.println("===========================");
		
		sum = 0;
		//keyset() : 키들을 의미
		for(String key :data.keySet()) {	//.keySet() key만 다 가져와
			System.out.println(key+ " ===> " + data.get(key));
			sum += data.get(key);
		}
		System.out.println("총점 : " + sum);
		System.out.println("===========================");

		
		Iterator<String> it = data.keySet().iterator();	//key들을 iterator로 넘겨라?
		while(it.hasNext()) {	//다음 데이터가 있는지 확인.
			String key = it.next();	//다음 데이터 읽기
			System.out.println(key);
			System.out.println(data.get(key));
		}
		System.out.println("===========================");

		
		//.containsKey 키가 존재하는지 확인
		System.out.println("키 찾기" + data.containsKey("밤"));
		//.containsValue 값이 존재하는지 확인
		System.out.println("값 찾기" + data.containsValue(50));

	}

	private static void f6() {
		//Set interface => 구현 클래스 : HashSet, TreeSet
		//HashSet : 순서 없고, 중복 불가
		Set<Account> data = new HashSet<>();
		data.add(new Account("1234", "밍", 1000));
		data.add(new Account("1234", "밍", 1000));
		data.add(new Account("1234", "밍1", 3000));
		data.add(new Account("1234", "밍2", 2000));
		data.add(new Account("1234", "밍3", 4000));
		
		//1.일반 for	//불가 : Set은 순서 없음 : index 사용 불가 > 순서지정 불가 
		//2.향상 for
		for(Account acc:data) {
			System.out.println(acc);
		}
		System.out.println("================================================");
		
		//3.iterator : 내분 반복자
		//자료 구조를 하나 더 만든 것임
		Iterator<Account> it = data.iterator();
		while(it.hasNext()) {	//다음에 가져올 것이 있을 동안만
			System.out.println(it.next());
		}
		
		//원하는 객체 찾기 :contains()
		//동등비교함 : 해쉬코드, equals가 같은지 : 그러므로 재정의 되어있어야 함
		Account searchData = new Account("1234", "밍1", 3000);
		boolean result = data.contains(searchData);
		System.out.println(result ? "찾음" : "못찾음");
	}
	
	private static void f5() {
		//Set interface => 구현 클래스 : HashSet, TreeSet
		//HashSet : 순서 없고, 중복 불가 		//TreeSet : 순서 있음, 중복 불가
		Set<String> data = new HashSet<>();
		data.add("월요일");
		data.add("화요일");
		data.add("토요일");
		data.add("토요일");
		data.add("일요일");
		
		//1.일반 for	//불가 : Set은 순서 없음 : index 사용 불가 > 순서지정 불가 
		//2.향상 for
		for(String week:data) {
			System.out.println(week);
		}
		
		System.out.println("========================");
		
		//3.iterator : 내분 반복자
		//자료 구조를 하나 더 만든 것임
		Iterator<String> it = data.iterator();
		while(it.hasNext()) {	//다음에 가져올 것이 있을 동안만
			System.out.println(it.next());
		}
	}

	private static void f4() {
		//ArrayList는 중간의 data를 삽입하고나 삭제 시 앞으로 당기는 것때문에 느리다.
//		List<Account> data = new ArrayList<>();

		List<Account> data = new Vector<>();
		long start = System.nanoTime();		
		
		for(int i=1; i<=1000; i++) {
			data.add(new Account(i+"", "탬"+i, 100));
		}
		
		for(int i=100; i<200; i++) {
			data.remove(0);
		}
		
		for(int i=100; i<200; i++) {
			data.add(i, new Account(i+"", "밍"+i, 100));
		}
		
		long end = System.nanoTime();
		DecimalFormat df = new DecimalFormat("###,###");		
		System.out.println("걸린시간 : " + df.format(end-start) + " nano");
	}

	//Vector는 멀티 스레드에 안정적이다...동기화된다.
	private static void f3() {
		//ArrayList : 스레드에 안정적이지 않다. //결과 : 2000건 저장 안됨
//		List<Account> data = new ArrayList<>();
		
		//LinkedList : 스레드에 안정적이지 않다. //결과 : 2000건 저장 안됨
//		List<Account> data = new LinkedList<>();

		//Vector : 스레드에 안정적
		List<Account> data = new Vector<>();

		long start = System.nanoTime();
		
		//2000건을 add하고자 함.
		//2개의 흐름을 만들어서 각자 1000건씩 넣고자 한다.
		Thread t1 = new Thread() {
			public void run() {
				for(int i=1; i<=1000; i++) {
					data.add(new Account(i+"", "탬"+i, 100));	//계좌, 주, 잔고
				}
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				for(int i=1001; i<=2000; i++) {
					data.add(new Account(i+"", "밤"+i, 100));	//계좌, 주, 잔고
				}
			}
		};
		
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(data.size() + "건이 저장되었습니다.");
		
		for(int i=0; i<100; i++) {
			data.remove(0);
		}
		
		long end = System.nanoTime();
		DecimalFormat df = new DecimalFormat("###,###");		
		System.out.println("걸린시간 : " + df.format(end-start) + " nano");
	}

	private static void f2() {
		//List interface임 : 구현 클래스 => ArrayList, LinkedList, Vector
		List <String> data = new ArrayList<String>();
		data.add("자바1");
		data.add("자바2");
		data.add("자바3");
		data.add("자바4");
		data.add("자바5");
		
		System.out.println(data.size()+"개");
		
		//1. 일반 for
		for(int i=0; i<data.size(); i++) {
			System.out.println(i + "번째 " + data.get(i));
		}
		
		//2. 향상 for
		for(String s:data) {
			System.out.println(s);
		}
		
		//iterator : 내가 하나씩 받아와라
		System.out.println("================");
		Iterator<String> it = data.iterator();
		while(it.hasNext()) {	//다음 값이 존재하는 가?
			String s = it.next();	//다음 값 존재함
			System.out.println(s);
		}
	}

	private static void f1() {
		//List interface임 : 구현 클래스 => ArrayList, LinkedList, Vector
//		List data = new ArrayList();
//		LinkedList data = new LinkedList();
		Vector data = new Vector();
		data.add(100);
		data.add("자바");
		data.add(new Account("12345", "tm", 10000));
		int a = (Integer)data.get(0);
		String s = (String)data.get(1);
//		Account acc = (String)data.get(2);	//컴파일 시 오류는 안남, 런타임 오류. ArrayList가 오브젝트이고, String은 Object의 자식이므로 
		Account acc = (Account)data.get(2);
	}
}
