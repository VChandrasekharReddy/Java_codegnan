package jacaclass.day1;

public class Rectangle extends Shape{
	int length;
	int width;
	String name;
	Rectangle(int l , int w , String n){
		length = l;
		width = w;
		name = n;
	}
	double area() {
		return length*width;
	}
	double peremeter() {
		return 2*(length+width);
	}
	String getShapeName() {
		return name;
	}

}
