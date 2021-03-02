import java.util.*;
public class Area {
	double areaOfTriangle(double height, double base){
		// area of triangle = (height * base) / 2
		return Math.round ( height * base / 2.0 * 100.0) / 100.0;
	}
	
	double areaOfRectangle(double length, double width){
		// area of rectangle = length * width
		return length * width ;
	}
	
	double areaOfSquare(double side){
		//area of square = side * side
		return side * side;
	}
	
	double areaOfCircle(double radius){
		// area of circle = radius * radius * 22 / 7
		return Math.round( (radius *radius * 22 / 7) * 100.0) / 100.0;
	}
}
