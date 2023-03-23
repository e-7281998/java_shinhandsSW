package com.shinhan.day06;

import com.shinhan.day06.Button.ClickListener;

public class CancelListener implements Button.ClickListener{

	@Override
	public void onClick() {
		System.out.println("cancel 버튼 클릭.");
		System.out.println("cancel 버튼 클릭 시 수행되는 로직입니다.");
	}
}
