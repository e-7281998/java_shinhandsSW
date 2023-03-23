package com.shinhan.day05.LAB2;

import com.shinhan.day05.Resizable;

public class ShapeTest {

	public static void main(String[] args) {

		Shape arr[] = new Shape[2];
		
		arr[0] =  new Rectangle(5, 6);
		arr[1] = new RectTriangle(6, 2);
		
		for(Shape a:arr) {
			System.out.println("area: " + a.getArea());
			System.out.println("perimeter: " +a.getPerimeter());
			if(a instanceof Resizable re) {
				re.resize(0.5);
				System.out.println("new area: " + a.getArea());
				System.out.println("new perimeter: " +a.getPerimeter());
			}
			
			
		}
		
	}

}
