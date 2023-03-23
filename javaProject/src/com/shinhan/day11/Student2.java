package com.shinhan.day11;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
public class Student2 implements Comparable<Student2>{
	private String name;
	private int score;
	private String gender;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student2 [name=").append(name).append(", score=").append(score).append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(Student2 o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
