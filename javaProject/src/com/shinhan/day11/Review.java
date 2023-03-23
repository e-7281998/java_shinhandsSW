package com.shinhan.day11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Review {
	public static void main(String[] args) {
		f2();
	}

	private static void f2() {
		// <T> : 기본형 안됨, obj만 가능
		// Integer, String : 기본으로 equals, hashCode, toString이 재정의 되어 있음
		List<Integer> data1 = new ArrayList<>();
		Set<Integer> data2 = new HashSet<>();
		Map<String, Integer> data3 = new HashMap<>();

		data1.add(100);
		data2.add(200);
		data3.put("aa", 300);

		System.out.println(data1.get(0));

		for (Integer data : data2) {
			System.out.println(data);
		}
		// 내부 반복자를 생성
		Iterator<Integer> it = data2.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		// Map은 key가 있으면 value를 읽을 수 있다.
		int value = data3.get("aa");
		// key를 다 가져와라
		Set<String> keys = data3.keySet();
		for (String key : keys) {
			int val = data3.get(key);
			System.out.println(key + " : " + val);
		}
		//entry를 다 가져와라 : 타입이 entry임 : Entry<String, Integer>
		Set<Entry<String, Integer>> entrys = data3.entrySet();
		for(Entry<String, Integer> entry:entrys) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		Iterator<Entry<String, Integer>> it2 = entrys.iterator();
		while(it2.hasNext()) {
			Entry<String, Integer> en = it2.next();
			System.out.println(en.getKey() + " : " + en.getValue());
		}

	}

	private static void f1() {
		// Collection : interface임 : List, Set
		// Map : interface임
		// List 구현 클래스 : ArrayList, Vector, LinkedList
		// 순서 O, 중복 O : 연속공간 : 데이터가 끝에 들어갈때는 빠름
		// Set 구현 클래스 : HashSet, TreeSet
		// 순서 X, 중복 X : equals, hashCode로 중복체크
		// data 추가시 순서정해짐 (크기비교 compareTo() 필요)
		// Map 구현 클래스 : HashMap, TreeMap, Properties
		// key(:Set임) ,value (엔트리)구성

	}
}
