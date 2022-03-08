package com.sapient.entity;


@FunctionalInterface
public interface Shape {
	public double getArea();
	public default double getPerimeter() { return 1.0; }
	public default void printInfo() {}
}
