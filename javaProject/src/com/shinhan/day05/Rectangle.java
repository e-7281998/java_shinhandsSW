package com.shinhan.day05;

public class Rectangle extends Shape{
	int width;
	int height;

	public Rectangle(String color, int witdh, int height) {
		super(color, "Rectangle");
		this.width = witdh;
		this.height = height;
	}

	@Override
	public double calculateArea() {
		return width * height;
	}

	@Override
	public double calculatePerimeter() {
		return 2 * (width + height);
	}
	
}
