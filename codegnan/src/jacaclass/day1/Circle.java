package jacaclass.day1;

public class Circle extends Shape{
	int radius;
	String name;
	Circle(int r,String n ){
		radius = r;
		name = n;
	}
	double area() {
		return Math.PI* radius*radius;
	}
	double peremeter() {
		return Math.PI*2*radius;
	}
	String getShapeName() {
		return name;
	}
}
