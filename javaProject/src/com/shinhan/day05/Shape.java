package com.shinhan.day05;

//추상클래스 : 추상 메서드가 1개 이상 있다.
//직접 객체 생성 불가 : new Shape() 불가
//추상 클래스를 상속받은 자식 클래스를 이용해서 객체생성 가능.
public abstract class Shape {

	private String color;
	private String type;
	
//	public Shape() {}
	
	public Shape(String color, String type)
	{
		this.color = color;
		this.type = type;
	}
	
	public String getColor()
	{
		return color;
	}
	public String getType()
	{
		return type;
	}
	
	//추상메서드: 정의는 있고 수현은 상속받은 클래스에서 반드시 한다. (override)
	public abstract double calculateArea();
	
	public abstract double calculatePerimeter();
	
	public String toString()
	{
		return color + " " + type;
	}
	
}
