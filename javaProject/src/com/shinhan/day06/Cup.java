package com.shinhan.day06;

public class Cup implements Colorable{
	int size;
	String forgroundColor;
	String backgroundColor;

	@Override
	public void setForeground(String color) {
		forgroundColor = color;
		System.out.println("Cup의  폭라운드 변경한다."+ color);
		System.out.println("=============================");
	}

	@Override
	public void setBackground(String color) {
		backgroundColor = color;
		System.out.println("Cup의  백그라운드 변경한다."+ color);
		System.out.println("=============================");		
	}

}
