import java.util.*;
/*
 * @author Neha Patidar
 */
public class ShapeFactory {
	public static Shape creator(String shapeName, Point point, ArrayList<Integer> list){
		Shape shape = null;
		if(shapeName.equalsIgnoreCase("Triangle")){
			shape = new Triangle(point, list);
		}
		else if(shapeName.equalsIgnoreCase("Square")){
			shape = new Square(point, list);
		}
		else if(shapeName.equalsIgnoreCase("Rectangle")){
			shape = new Rectangle(point, list);
		}
		else if(shapeName.equalsIgnoreCase("Circle")){
			shape = new Circle(point, list);
		}
		return shape;
	}
}
