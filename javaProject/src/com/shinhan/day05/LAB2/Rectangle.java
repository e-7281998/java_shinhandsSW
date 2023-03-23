package com.shinhan.day05.LAB2;

import com.shinhan.day05.Resizable;

public class Rectangle extends Shape implements Resizable{
	double width;
	double height;
	
	Rectangle(double width, double height) {
		super(4);
		this.width = width;
		this.height = height;
	}

	@Override
	double getArea() {	//사각형 넓이
		return width * height;
	}

	@Override
	double getPerimeter() {	//사각형 둘레
		return 2 * (width + height);
	}

	@Override
	public void resize(double s) {
		width = width * s;
		height = height * s;
	}
}
