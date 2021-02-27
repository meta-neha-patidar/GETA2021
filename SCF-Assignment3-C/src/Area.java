import java.util.*;
public class Area {
	float areaOfTriangle(float height, float base){
		// area of triangle = (height * base) / 2
		return (float) ((height * base) / 2.0);
	}
	
	float areaOfRectangle(float length, float width){
		// area of rectangle = length * width
		return length * width ;
	}
	
	float areaOfSquare(float side){
		//area of square = side * side
		return side * side;
	}
	
	float areaOfCircle(float radius){
		// area of circle = radius * radius * 22 / 7
		return (float) (radius *radius * 22 / 7);
	}
}
