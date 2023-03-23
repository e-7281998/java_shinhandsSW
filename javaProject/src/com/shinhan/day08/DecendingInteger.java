package com.shinhan.day08;

import java.util.Comparator;

//나는 Integer형으로 비교할래
public class DecendingInteger implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {

		return  o2 - o1;
	}

}
