import java.util.*;
/*
 * @author - Neha Patidar
 * 
 */
public class Screen {
	int X_MIN = 0;
	int Y_MIN = 0;
	int X_MAX = 1000;
	int Y_MAX = 1000;
	static List<Shape> shapes = new ArrayList<>();
	static int shapeNo = 1;
	/*
	 * purpose add shape on screen
	 * @param scanner
	 */
	static void addShape(Scanner scanner){
		System.out.println("Enter name of shape");
		String shapeName = scanner.next();
		System.out.println("Enter coordinate points of shape : ");
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		Point point = new Point(x,y);
		ArrayList<Integer> list = new ArrayList<>();
		System.out.println("Enter the shape elements in a list and enter -1 if all elements added");
		
		int element = scanner.nextInt();
		while(element != -1){
			list.add(element);
			element = scanner.nextInt();
		}
		Shape shapeObject = ShapeFactory.creator(shapeName, point, list);
		
		System.out.println("Area of Shape = " + shapeObject.getArea());
		System.out.println("Perimeter of Shape = " + shapeObject.getPerimeter());
		System.out.println("Timestamp of shape = " + shapeObject.getTimestamp());
		shapeObject.setShapeNo(shapeNo++);
		shapes.add(shapeObject);
	}
	/*
	 * purpose remove shape object of a given shapeNo
	 * @param scanner
	 */
	static void removeShapeObject(int shapeNo){
		
		for(int index = 0;index<shapes.size();index++){
			if(shapes.get(index).getShapeNo()==shapeNo){
				shapes.remove(index);
				break;
			}
		}
	}
	
	/*
	 * purpose: display the shapes on screen
	 */
	static void display(){
		if(shapes.size() == 0){
			System.out.println("Blank screen");
			return;
		}
		for(Shape shape : shapes){
			System.out.println("shapeNo: " + shape.getShapeNo() + ",\torigin points: x="+shape.getOrigin().xCoordinate
					+", y="+shape.getOrigin().yCoordinate + " and\t timestamp: "+ shape.getTimestamp());
		}
	}
	/*
	 * 
	 */
	static void pointEnclose(Point point){
		
		System.out.println("Shapes enclosed the given point ");
		for(Shape shape: shapes){
			if(shape.isPointEnclosed(point)){
				System.out.println("shapeNo = " + shape.getShapeNo() + ",\torigin points = "+shape.getOrigin().xCoordinate
						+", "+shape.getOrigin().yCoordinate + " and\t timestamp = "+ shape.getTimestamp());
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		try{
			System.out.println("Enter 0 to perform any operation");
			System.out.println("Enter 1 to add shape ");
			System.out.println("Enter 2 to remove shape object");
			System.out.println("Enter 3 to display shapes on screen");
			System.out.println("Enter 4 to check that a given point is enclosed by which shapes");
			int operationCase = scanner.nextInt();
			while(operationCase != 0){
				if(operationCase == 1){
					//addShape()
					addShape(scanner);
				}
				else if(operationCase == 2){
					//removeShapeObject()
					System.out.println("Enter shape Id");
					int shapeNo = scanner.nextInt();
					removeShapeObject(shapeNo);
				}
				else if(operationCase == 3){
					//display()
					display();
				}
				else if (operationCase == 4){
					System.out.println("Enter x and y coordinate of point");
					int x = scanner.nextInt();
					int y = scanner.nextInt();
					Point point = new Point(x,y);
					pointEnclose(point);
				}
				System.out.println("Enter operation case");
				operationCase = scanner.nextInt();
			}
				
		}catch (Exception e){
			System.out.println(e);
		}

	}
	

}
