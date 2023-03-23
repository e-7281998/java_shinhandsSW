package com.shinhan.day06;

public class Book implements Colorable{
	String title;
	String forgroundColor;
	String backgroundColor;

	@Override
	public void setForeground(String color) {
		forgroundColor = color;
		System.out.println("Book의  폭라운드 변경한다."+ color);
		System.out.println("=============================");
	}

	@Override
	public void setBackground(String color) {
		backgroundColor = color;
		System.out.println("Book의  백그라운드 변경한다."+ color);
		System.out.println("=============================");		
	}

}
