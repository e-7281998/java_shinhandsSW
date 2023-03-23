package com.shinhan.day05;

import java.util.Arrays;

public class ExchangeStudent extends Student {
	String language[];

	public ExchangeStudent(String stdId, String name, String language[]) {
		// 1. 명시적으로 부모 생성자를 호출 (현재 사용중)
		super(stdId, name);
		// 2. 부모에서 default 생성자를 정의
		this.setStdId(stdId);
		this.name = name;

		this.language = language;
	}

	void display() {
		// getClass(); 현재 클래스를 얻을 수 있음.
		System.out.println(getClass().getSimpleName() + "에서 추가됟 메서드");
	}

	//방법1. Inherited fields 체크 후 오버라이드
	@Override
	public String toString() {
		return "ExchangeStudent [language=" + Arrays.toString(language) + ", name=" + name + ", major=" + major
				+ ", score=" + score + ", school=" + school + "]";
	}
	//방법2. 부모 호출해서 사용
//	@Override
//	public String toString() {
//		String aa = super.toString();
//		return aa + "ExchangeStudent [language=" + Arrays.toString(language) + "]";
//	}

}
