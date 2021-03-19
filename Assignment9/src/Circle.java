import java.util.*;
/*
 * @author -Neha Patidar
 */
public class Circle implements Shape{
	int shapeNo ;
	double PI = 3.14;
	double radius;
	String timestamp;
	Point coordinatePoints;
	
	/*
	 * Parameterized constructor
	 * @param point, list
	 */
	Circle(Point point, ArrayList<Integer> list){
		this.radius = list.get(0);
		this.coordinatePoints = point;
		this.timestamp = new Date().toString();
	}
	
	/*
	 * (non-Javadoc)
	 * @see Shape#getArea()
	 */
	public double getArea(){
		return PI * this.radius * this.radius;
	}
	
	/*
	 * (non-Javadoc)
	 * @see Shape#getPerimeter()
	 */
	public double getPerimeter(){
		return 2 * PI * this.radius;
	}
	
	/*
	 * (non-Javadoc)
	 * @see Shape#getTimestamp()
	 */
	public String getTimestamp(){
		return this.timestamp;
	}
	
	/*
	 * (non-Javadoc)
	 * @see Shape#getOrigin()
	 */
	public Point getOrigin(){
		return this.coordinatePoints;
	}

	/*
	 * (non-Javadoc)
	 * @see Shape#setShapeNo(int)
	 */
	public void setShapeNo(int shapeNo) {
		this.shapeNo = shapeNo;
		// TODO Auto-generated method stub
		
	}

	/*
	 * (non-Javadoc)
	 * @see Shape#getShapeNo()
	 */
	public int getShapeNo() {
		// TODO Auto-generated method stub
		return this.shapeNo;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		// TODO Auto-generated method stub
		if(point.xCoordinate < coordinatePoints.xCoordinate + radius &&
				point.yCoordinate < coordinatePoints.yCoordinate + radius &&
				point.xCoordinate > coordinatePoints.xCoordinate - radius &&
				point.yCoordinate > coordinatePoints.yCoordinate - radius
				) return true;
				
		
		
		return false;
	}
	
}
