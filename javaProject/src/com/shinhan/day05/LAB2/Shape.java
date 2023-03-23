package com.shinhan.day05.LAB2;

public abstract class Shape {
	int numSides;
	
	Shape(int numSides){
		this.numSides = numSides;
	}
	int getNumSides(){
		return numSides;
	};
	
	abstract double getArea();
	abstract double getPerimeter();

}
