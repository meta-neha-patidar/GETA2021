import java.util.ArrayList;
import java.util.Date;
/*
 * @author -Neha Patidar
 */

public class Rectangle implements Shape{
	double length, breadth;
	String timestamp;
	Point coordinatePoints;
	int shapeNo;
	
	/*
	 * Parameterized constructor
	 * @param point, list
	 */
	Rectangle (Point point, ArrayList<Integer> list){
		this.length = list.get(0);
		this.breadth = list.get(1);
		this.coordinatePoints = point;
		this.timestamp = new Date().toString();
	}
	
	/*
	 * (non-Javadoc)
	 * @see Shape#getArea()
	 */
	public double getArea(){
		return this.length * this.breadth;
	}

	/*
	 * (non-Javadoc)
	 * @see Shape#getPerimeter()
	 */
	public double getPerimeter(){
		return 2 * (this.length + this.breadth);
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

	@Override
	public void setShapeNo(int shapeNo) {
		this.shapeNo = shapeNo;
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getShapeNo() {
		// TODO Auto-generated method stub
		return this.shapeNo;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		// TODO Auto-generated method stub
		if(point.xCoordinate > coordinatePoints.xCoordinate &&
				point.xCoordinate < coordinatePoints.xCoordinate + this.breadth &&
				point.yCoordinate > coordinatePoints.yCoordinate &&
				point.yCoordinate < coordinatePoints.yCoordinate + this.length) return true;
		return false;
	}
	
}
