package com.shinhan.day06;

public class Button {
	//field
	private ClickListener listner;
	//method
	void setListener(ClickListener listner) {
		this.listner = listner;
	}
	
	public void buttonClick() {
		listner.onClick();
	}
	
	//내부 interface.. 규격서
	//버튼 전용으로 사용하고 싶어서 class 내부에 작성함.
	static interface ClickListener{
		void onClick();
	}
}
