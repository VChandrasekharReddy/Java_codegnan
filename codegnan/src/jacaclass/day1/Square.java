package jacaclass.day1;

public class Square extends Shape {
	int side ;
	String name;
	Square(int s,String n ){
		side = s;
		name = n;
	}
	double area() {
		return side * side;
	}
	double peremeter() {
		return 4*side;
	}
	String getShapeName() {
		return name;
	}
}
