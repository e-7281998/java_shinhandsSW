package com.shinhan.day10;

import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Fruit implements Comparable<Fruit>{
	String name;
	int price;
	@Override
	public int compareTo(Fruit o) {
		int result = name.compareTo(o.name);
//		if(result == 0) return price - o.price;
		return result;
	}
}
