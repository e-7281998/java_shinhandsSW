package com.shinhan.day05.LAB2;

public class RectTriangle extends Shape{
	int width;
	int height;
	
	RectTriangle(int width, int height) {
		super(3);
		this.width = width;
		this.height = height;
	}

	@Override
	double getArea() {	//삼각형 넓이
		return width * height / 2;
	}

	@Override
	double getPerimeter() {	//삼각형 둘레
		//width * width + height * height : 빗변
		return width + height + Math.sqrt(width * width + height * height);
	}

}
