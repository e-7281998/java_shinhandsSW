package com.shinhan.day05;

public class Circle extends Shape {

	int radius;
	double circumference;

	public Circle(String color, int radius) {
		super(color, "Circle");
		this.radius = radius;
	}

	// 추상 클래스 오버라이드 : 필수
	@Override
	public double calculateArea() { // 면적
		return radius * radius * Math.PI;
	}

	@Override
	public double calculatePerimeter() { // 둘레
		circumference = 2 * Math.PI * radius;
		return circumference;
	}

	public double getRadius() {
		return radius;
	}
}
