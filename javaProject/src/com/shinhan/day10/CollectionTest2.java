package com.shinhan.day10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

import com.shinhan.day04.Employee;
import com.shinhan.day05.Account;

public class CollectionTest2 {
	public static void main(String[] args) {
//		f14();
		
		String[] arr = {"A", "B","C"};
		Integer[] arr2 = {100, 30, 40};
		List<String> data = Arrays.asList(arr);
		List<Integer> data2 = Arrays.asList(arr2);
	}
	
	private static void f14() {
		Set<Fruit> data = new HashSet<>();
		data.add(new Fruit("귤1", 3000));
		data.add(new Fruit("귤2", 3000));
		data.add(new Fruit("귤3", 3000));
		data.add(new Fruit("귤4", 3000));
		data.add(new Fruit("귤5", 3000));
		data.add(new Fruit("귤6", 3000));
		Set<Fruit> data2 = Set.copyOf(data);
		//수정 불가
		//data2.add(new Fruit("빵", 300));
		for(Fruit f : data2) {
			System.out.println(f);
		}
	}

	private static void f13() {
		//중복 불가 : 런타임 에러
//		Map<String, Integer> data = Map.of("탬", 300, "탬",400, "밤",900);
		Map<String, Integer> data = Map.of("탬", 300, "밍",400, "밤",900);
		//값 수정 불가 : data.put("a", 300);
		for(String key:data.keySet()) {
			System.out.println(key + " : " + data.get(key));
		}
	}

	private static void f12() {
		//Set과 List의 차이 : 중복이 되는가?
		//중복 불가 : 90이 중복됨
//		Set<Integer> listData = Set.of(100, 50, 90, 90, 60, 40);
		Set<Integer> listData = Set.of(100, 50, 90, 60, 40);
//		listData.add(50);	//수정 불가 : 런타임에러
		for(Integer a:listData) {
			System.out.println(a);
		}
	}
	
	//수정불가한 클래스
	private static void f11() {
//		int arr[] = new int[] {100, 50, 90, 60, 40};
		List<Integer> listData = List.of(100, 50, 90, 60, 40);
//		List<int []> listData2 = Arrays.asList(arr);
//		listData.add(50);	//수정 불가 : 런타임에러
		for(Integer a:listData) {
			System.out.println(a);
		}
		
//		for(int[] a:listData2) {
//			System.out.println(Arrays.toString(a));
//		}
	}

	private static void f10() {
		//Queue는 인터페이스
		Queue<Fruit> data = new LinkedList<>();
		data.add(new Fruit("자두1", 3000));
		data.add(new Fruit("자두2", 6000));
		data.add(new Fruit("자두3", 1000));
		data.add(new Fruit("자두4", 4000));
		data.add(new Fruit("자두6", 3000));
		data.add(new Fruit("자두5", 7000));
		
		while(!data.isEmpty()) {
			Fruit f = data.poll();
			System.out.println(f);
		}
	}
	
	private static void f9() {
		//Stack는 클래스
		Stack<Fruit> data = new Stack<>();
		data.push(new Fruit("자두1", 3000));
		data.push(new Fruit("자두2", 6000));
		data.push(new Fruit("자두3", 1000));
		data.push(new Fruit("자두4", 4000));
		data.push(new Fruit("자두6", 3000));
		data.push(new Fruit("자두5", 7000));
		
		while(!data.isEmpty()) {
			Fruit f = data.pop();
			System.out.println(f);
		}
	}

	private static void f8() {
		//Map : HashMap, TreeMap
		TreeMap<String, Fruit> data = new TreeMap<>(new Comparator<String>() {
			//익명으로 디센딩해서 넣기
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);	//뒤에것을 기준으로 비교했기에 디센딩
			}
			
		});
		//기본은 어센딩
//		TreeMap<String, Fruit> data = new TreeMap<>();
		data.put("S", new Fruit("뀰", 900));
		data.put("A", new Fruit("키위", 900));
		data.put("C", new Fruit("애플망고", 50000));
		data.put("D", new Fruit("뀰", 900));
		data.put("D", new Fruit("사과", 1000));
		data.put("C", new Fruit("딸기", 1900));
		data.put("A", new Fruit("망고", 1700));
		data.put("B",new Fruit("키위", 1000));

		for (Entry<String, Fruit>  entry: data.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			System.out.println(entry.getValue());
			System.out.println("================================");
		}
		System.out.println("***********뒤집어***********");

		//data를 디센딩해서 출력
		NavigableMap<String, Fruit> data2 = data.descendingMap();
		for (Entry<String, Fruit>  entry: data2.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			System.out.println(entry.getValue());
			System.out.println("================================");
		}
	}

	private static void f7() {
		Set<Fruit> data = new TreeSet<>();
		data.add(new Fruit("뀰", 900));
		data.add(new Fruit("키위", 900));
		data.add(new Fruit("애플망고", 50000));
		data.add(new Fruit("뀰", 900));
		data.add(new Fruit("사과", 1000));
		data.add(new Fruit("딸기", 1900));
		data.add(new Fruit("망고", 1700));
		data.add(new Fruit("키위", 1000));

		for (Fruit s : data) {
			System.out.println(s);
		}
	}

	private static void f6() {
//		Set<Board> data = new HashSet<>();
		Set<Board> data = new TreeSet<>();
		data.add(new Board(1, "링딩동", "링디기딩디기딩딩딩", "SHINee"));
		data.add(new Board(2, "루시퍼", "거부할 수 없는 너의 마력은", "SHINee"));
		data.add(new Board(3, "누너예", "나의 MVP", "SHINee"));
		data.add(new Board(4, "링딩동", "링디기딩디기딩딩딩", "SHINee"));
		data.add(new Board(5, "돈콜미", "내게 전화하지마", "SHINee"));

		for (Board s : data) {
			System.out.println(s);
		}
	}

	private static void f5() {
		// default : key로 sort한다.
		TreeMap<String, Integer> data = new TreeMap<>();
		data.put("홍길동5", 88);
		data.put("홍길동3", 10);
		data.put("홍길동1", 44);
		data.put("홍길동4", 50);
		data.put("홍길동4", 90);
		data.put("홍길동1", 80); // 같은 key가 있으면 값을 replace

		for (String key : data.keySet()) {
			System.out.println(key + " ==> " + data.get(key));
		}
		System.out.println("firstKey : " + data.firstKey());
		System.out.println("firstKey의  값 :" + data.get(data.firstKey()));
		System.out.println("lastEntry의  값 :" + data.lastEntry());
		// lowerEntry : key값보다 낮은 값 (바로 앞)
		System.out.println("lowerEntry의  값 :" + data.lowerEntry("홍길동5"));

		// 디샌딩
		NavigableMap<String, Integer> data2 = data.descendingMap();
		for (String key : data2.keySet()) {
			System.out.println(key + " ==> " + data.get(key));
		}
	}

	private static void f4() {
		// Set : 중복X - compareto 정의 필요
		// Tree : sort : 검색속도 향상 위해 - hashcode, equals 정의 필요
		TreeSet<Integer> scoreSet = new TreeSet<>();
		scoreSet.add(100);
		scoreSet.add(20);
		scoreSet.add(50);
		scoreSet.add(80);
		scoreSet.add(80);
		scoreSet.add(10);

		for (Integer score : scoreSet) {
			System.out.println(score);
		}
		System.out.println("====================");

		System.out.println("first : " + scoreSet.first());
		System.out.println("last : " + scoreSet.last());
		System.out.println("50 < : " + scoreSet.higher(50));
		System.out.println("50 > : " + scoreSet.lower(50));
		System.out.println("50 <= 중 가장 첫 번째 : " + scoreSet.ceiling(50));
		System.out.println("50 >= 중 가장 첫 번째 : " + scoreSet.floor(50));
		System.out.println("====================");

		// tailSet은 크거나 같은것들 모음
		SortedSet<Integer> data = scoreSet.tailSet(50);
		for (Integer i : data) {
			System.out.println(i);
		}

		System.out.println("====================");

		// headSet : 작은 것 모음
//		SortedSet<Integer> data2 = scoreSet.headSet(50);
		// 작거나 같은 것 모음
		SortedSet<Integer> data2 = scoreSet.headSet(50, true);
		for (Integer i : data2) {
			System.out.println(i);
		}

		System.out.println("====================");
		// 작거나 같은 것 모음
		NavigableSet<Integer> data3 = scoreSet.headSet(50, true);
		for (Integer i : data2) {
			System.out.println(i);
		}

	}

	// List : 순서있음, 중복가능 : ArrayList, LinkedList, Vector(MuitiThread 환경에서서 동기화 지원)
	// Set : 순서 없음, 중복불가
	// Map : 키와 값의 쌍
	// HashSet : hashcode(), equals()로 동등비교, 동등하면 add 불가
	// TreeSet compareTo()로 크기 비교
	private static void f3() {
		Set<Employee> data = new TreeSet<>();
		data.add(new Employee("김", "사원", 1000));
		data.add(new Employee("이", "과장", 1700));
		data.add(new Employee("강", "부장", 1800));
		data.add(new Employee("한", "사장", 3000));
		data.add(new Employee("한", "사원", 1000));
		data.add(new Employee("최", "사원", 1300));
		for (Employee s : data) {
			System.out.println(s);
		}
	}

	private static void f2() {
		// TreeSet : 중복 불가, 순서 O : 객체이므로 재정의 필요
		Set<Account> data = new TreeSet<>();
		data.add(new Account("8787", "탬4", 7000));
		data.add(new Account("8787", "탬4", 5000));
		data.add(new Account("6666", "탬1", 2000));
		data.add(new Account("4545", "탬2", 3000));
		data.add(new Account("1212", "탬3", 7000));

		// 데이터 비교 불가 : 런타임 오류 :
		for (Account s : data) {
			System.out.println(s);
		}
	}

	private static void f1() {
		// TreeSet : 중복 불가, 순서 O
		Set<String> data = new TreeSet<>();
		data.add("월7");
		data.add("월2");
		data.add("월4");
		data.add("월4"); // 중복 불가 : add 실패
		data.add("월3");

		for (String s : data) {
			System.out.println(s);
		}
	}
}
