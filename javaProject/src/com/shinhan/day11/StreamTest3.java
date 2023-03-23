package com.shinhan.day11;

import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.shinhan.day05.Account;

public class StreamTest3 {
	public static void main(String[] args) throws IOException, URISyntaxException {
//		f7();
//		f10();
		f13();
	}
	
	private static void f13() {
		List<Student2> data = new ArrayList<>();
		data.add(new Student2("강길동", 60, "남"));
		data.add(new Student2("박남길", 40, "남"));
		data.add(new Student2("강경아", 50, "여"));
		data.add(new Student2("고길동", 20, "남"));
		data.add(new Student2("한선아", 60, "여"));
		data.add(new Student2("이유아", 100, "여"));
		data.add(new Student2("최유진", 90, "여"));
		data.add(new Student2("박유빈", 70, "남"));
		
		//group으로 집계를 하고, 다시 group이 collection으로 만든다.
		//key : gender , value = score
		Map<String, Double> map = data.stream().collect(
				//groupingBy : 무엇을 기준으로 그룹을 짓나 ? 성별로 그룹
				Collectors.groupingBy(st -> st.getGender(),
						//그룹별 점수 평균
						Collectors.averagingDouble(st -> st.getScore())
						)
				);
		System.out.println(map);
	}

	private static void f12() {
		int arr[] = {1,2,3,4,5,6,7,8};
		//매칭...
		
		//intPredicate : int가 들어가면 맞는지 아닌지 알려줌 : boolean
		//전부 매치하는지... 전부 짝수가 맞는지
		boolean result = Arrays.stream(arr).allMatch(su -> su%2==0);
		System.out.println(result);
		
		//일부가 매치하는지... 짝수가 1개라도 있는지..
		result = Arrays.stream(arr).anyMatch(su -> su%2==0);
		System.out.println(result);
		
		//모든 요소가 만족하지 않는가?... 모두 짝수가 아닌지...
		result = Arrays.stream(arr).noneMatch(su -> su%2==0);
		System.out.println(result);
		
		//average는 optional로 나옴.
		double d = Arrays.stream(arr)
						.filter(su -> su%2==0)
						.average()
						.orElse(0);	//값은 d에 들어감...값이 없을 경우에는 0이 들어가도록함 (값이 없을 때 초기값 주는 것임)
		System.out.println(d);
	}

	private static void f11() {
		List<Student> data = new ArrayList<>();
		data.add(new Student("이5", 500));
		data.add(new Student("최1", 300));
		data.add(new Student("최1", 300));
		data.add(new Student("강6", 500));
		data.add(new Student("강4", 500));
		data.add(new Student("한2", 200));
		data.add(new Student("김3", 100));
		data.add(new Student("김2", 200));		
		
		data.stream().sorted().forEach(st -> System.out.println(st));
		System.out.println("---------------------");
		//stream활용한 정렬
		data.stream().sorted((a,b) -> 
			a.getName().compareTo(b.getName())).forEach(st -> System.out.println(st));
	}

	private static void f10() {
		Integer[] arr = {100,20,50,90,10};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		Arrays.sort(arr, (a,b) -> b-a);
		System.out.println(Arrays.toString(arr));
		
		Student[] arr2 = {
				new Student("강", 80),new Student("이", 50),new Student("이", 40),new Student("이", 30),
				new Student("김", 80),new Student("이", 90),new Student("이", 60),new Student("이", 100)
		};
		
		Arrays.sort(arr2);
		System.out.println(Arrays.toString(arr2));
		
		Arrays.sort(arr2, (a,b) -> {
			return a.getName().compareTo(b.getName());
		});
	}

	private static void f9() {
		List<String> data = new ArrayList<>();
		data.add("This is Java");
		data.add("I am a best developer");
		//stream으로 문장 쪼개기
		data.stream()
			.flatMap(row -> Arrays.stream(row.split(" ")))
			.forEach(word -> System.out.println(word));
		
		System.out.println("----------------------");
		
		//다음과같이 이중 for문으로도 가능...
		for(String row:data) {
			String[] arr = row.split(" ");
			for(String s:arr) {
				System.out.println(s);
			}
		}
	}

	private static void f8() {
		int arr[] = {10, 20, 70, 90};
		//정수 -> 더블
		Arrays.stream(arr).asDoubleStream().forEach(d -> System.out.println(d));
		
		//boxed로 변형
		Arrays.stream(arr).boxed().forEach(d -> System.out.println(d.floatValue()));
	}

	private static void f7() {
		List<Student> data = new ArrayList<>();
		data.add(new Student("이5", 500));
		data.add(new Student("최1", 300));
		data.add(new Student("최1", 300));
		data.add(new Student("강6", 500));
		data.add(new Student("강4", 500));
		data.add(new Student("한2", 200));
		data.add(new Student("김3", 100));
		data.add(new Student("김2", 200));
		
		//점수가 200초과인 사람 남김
		//filter : true만 return :조건에 맞는애만 남김
		/*
		 data.stream()
			.distinct()
			.filter(s -> s.getScore() > 200)
			.forEach(s -> System.out.println(s));
		*/
		Stream<Student> st = data.stream()
						.distinct()
						.filter(s -> s.getScore() > 200);
		st.forEach(s -> System.out.println(s));
		//스트림은 한번만 사용할 수 있음 : 스트림은 흐름이므로... 한 번 쓰면 흐름이 끝나버리는 것임
		//위에서 이미 소진....
//		st.forEach(s -> System.out.println(s));	

		
		System.out.println("========================");
		
		//이름이 '김'인 학생만 추출
		data.stream()
			.filter(s -> s.getName().startsWith("김"))
			.forEach(s -> System.out.println(s));
		
		//이름이 '김'인 학생들의 평균 추출
				data.stream()
					.filter(s -> s.getName().startsWith("김"))
					.mapToInt(s -> s.getScore())	//map이 들어가면 특정 값을 추출 (중간처리) 
					.average()	//평균 구하기 (최종 처리)
					.ifPresent(d -> System.out.println("평균 : " + d));	//값이 있는경우에만 실행한다.
		
	}

	private static void f6() {
		List<String> data = new ArrayList<>();
		data.add("홍길동3");
		data.add("홍길동2");
		data.add("홍길동4");
		data.add("홍길동1");
		data.add("홍길동14");
		data.add("홍길동5");
		data.add("홍길동5");
		data.add("홍길동7");
		data.add("홍길동6");
		data.add("홍길동6");
		
		//.stream 스트림으로 얻어라~~
		//data.stream().forEach(s -> System.out.println(s));	//중복O
		//distinct : 중복 제거
		//data.stream().distinct().forEach(s -> System.out.println(s));
		//s.endsWith("4") 문자열 기능 중... '4'로 끝나는 문자열을 찾아라 
		data.stream().distinct().filter(s -> s.endsWith("4")).forEach(s -> System.out.println(s));
		
		
	}

	private static void f5() throws URISyntaxException, IOException {
		//파일 읽기
		
		//파일 패스를 얻어라!
		Path path = Paths.get(StreamTest3.class.getResource("data.txt").toURI());
		System.out.println(path);
		System.out.println(path.getFileName());
		
		//Files.lines 파일을 한줄 씩 읽어라... 스트림으로!
		Stream<String> streamData = Files.lines(path, Charset.defaultCharset());	//한글 한자가 3바이트로 처리된다 ?
		streamData.forEach(line -> {System.out.println(line);});
	}

	private static void f4() throws IOException {
		//FileInputStream은 1바이트씩 읽음 : 숫자로 나옴
//		FileInputStream f1 = new FileInputStream("src/com/shinhan/day11/data.txt");
		//위의 방식으로하면 char로 바꿔도 한글은 깨짐...
		//다음과 같이 FIleReader로 읽으면 2byte씩 읽어서 한글 안깨지고 읽을 수 있음
		FileReader f1 = new FileReader("src/com/shinhan/day11/data.txt");
		int i;
		while((i=f1.read()) != -1) {
			System.out.println((char)i);
		}
	}

	private static void f3() {
		//range 마지막 미포함
		//rangeClosed 마지막 포함
		IntStream.range(1, 10).forEach(n -> System.out.println(n));	//1부터 9까지
		for(int i=1; i<10; i++) {
			System.out.println(i);
		}
	}

	private static void f2() {
		List<Account> data = new LinkedList<>();
		data.add(new Account("123","dk5",500));
		data.add(new Account("505","dk3",100));
		data.add(new Account("555","dk7",300));
		data.add(new Account("999","dk2",200));
		
		//모든 계좌의 잔고의 합을 구하기...외부 반복자 이용
		int total = 0;
		for(Account acc:data) {
			System.out.println(data);
		}
		System.out.println("통장의 잔고는 " + total );
		//Stream을 이용하면, 내부반복자를 사요
		 long total2 = data.stream().mapToLong(acc -> acc.getBalance()).sum();
		 System.out.println("balance합계 " + total2);
		 

		 total2 = data.stream().mapToLong(acc -> acc.getBalance()).count();
		 System.out.println("건수는 " + total2);
		 //forEach : 순서를 보장 안함
		 //forEachOrdered : 순서를 보장함
		 data.stream().map(acc -> acc.getOwner()).forEach(owner -> System.out.println(owner + " 예금주"));
		 System.out.println("=======");
		 data.stream().map(acc -> acc.getOwner()).forEachOrdered(owner -> System.out.println(owner + " 예금주"));
	}

	private static void f1() {
		//데이터 여러건 저장하기 : 배열, Collection(List, Set, Map)
		List<Student> data = new ArrayList<>();
		data.add(new Student("이5", 500));
		data.add(new Student("이1", 300));
		data.add(new Student("이4", 500));
		data.add(new Student("이2", 200));
		data.add(new Student("이3", 100));
		//data를 stream으로 만들어서 중간처리, 최종처리
		data.stream().forEach((st) -> {
			//System.out.println(st.toString());이 다음과 같음, 
			System.out.println(st);
			System.out.println(st.getName() + st.getScore());
		});
		
		System.out.println("========중간처리========");
		data.stream()
		.mapToInt(st -> st.getScore() )
		.forEach(score ->{
			System.out.println(score);
			System.out.println("------------");
		});
		
		System.out.println("========최종처리========");
		double d = data.stream()
		.mapToInt(st -> st.getScore() )
		.average()
		.getAsDouble();
		System.out.println("average - " +d);
		
		System.out.println("========Optional test1========");
		OptionalDouble option = data.stream()
		.mapToInt(st -> st.getScore() )
		.average();
		option.ifPresent(result -> System.out.println(result));
		
		System.out.println("========Optional test2========");
		data.stream()
		.mapToInt(st -> st.getScore() )
		.average()
		.ifPresent(result -> System.out.println(result));
		
		System.out.println("========Optional test3========");
		data.stream()
		.mapToInt(st -> st.getScore() )
		.average()
		.ifPresentOrElse((s) -> {System.out.println(s);}, () -> System.out.println("평균계산실패"));
	}

}
