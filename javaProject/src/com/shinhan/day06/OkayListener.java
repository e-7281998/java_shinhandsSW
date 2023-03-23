package com.shinhan.day06;

import com.shinhan.day06.Button.ClickListener;

public class OkayListener implements Button.ClickListener{

	@Override
	public void onClick() {
		System.out.println("ok 버튼 클릭.");
		System.out.println("ok 버튼 클릭 시 수행되는 로직입니다.");
	}
}
