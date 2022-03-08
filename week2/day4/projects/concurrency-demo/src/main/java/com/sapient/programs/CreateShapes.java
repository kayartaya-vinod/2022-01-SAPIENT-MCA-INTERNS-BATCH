package com.sapient.programs;

import com.sapient.entity.Shape;

public class CreateShapes {

	static void procesShape(Shape shape) {
		System.out.println("Area of the given shape is: " + shape.getArea());
		System.out.println("Perimeter of the given shape is: " + shape.getPerimeter());
	}

	public static void main(String[] args) {

		procesShape(() -> 12.34);

	}

}
