package com.shinhan.day08.ch12LAB8;

import java.util.Objects;

class MySum {
	int first;
	int second;

	MySum(int first, int second) {
		this.first = first;
		this.second = second;
	}

	// 조건 1 : Object의 toString은 주소를 문자로 return;
	@Override
	public String toString() {
//		return first+second+"";	//잔머리
		return String.valueOf(first + second);
	}

	// 조건 2 : Object의 equals는 주소를 비교
	/*
	 * @Override
	 * 
	 * public boolean equals(Object obj) { //방법1 if(!(obj instanceof MySum)) return
	 * false; MySum my = (MySum) obj; // return (first+second) == (my.first +
	 * my.second);
	 * 
	 * //방법2 return toString().equals(my.toString()); }
	 * //방법2 return this.toString().equals(my.toString()); } 과 위의 코드는 같은 것임
	 */

	@Override
	public int hashCode() {
		return Objects.hash(first, second);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MySum other = (MySum) obj;
		return first + second == other.first + other.second;
	}

}

public class OverridingTest {
	public static void main(String args[]) {
		int i = 10;
		int j = 20;

		MySum ms1 = new MySum(i, j);
		MySum ms2 = new MySum(i, j);
		String s = "30";

		System.out.println(ms1);
		//System.out.println(ms2.toString());
		// 다음의 문장은 .toString이 숨어있는 것임
		//출력할때만 생략됨(?)
		System.out.println(ms2);

		if (ms1.equals(ms2))
			System.out.println("ms1과 ms2의 합계는 동일합니다.");
		if (ms1.equals(s))
			System.out.println("ms1과 s1의 합계는 동일합니다.");
		else
			System.out.println("ms1과 s1의 합계는 동일하지 않습니다.");

	}
}
