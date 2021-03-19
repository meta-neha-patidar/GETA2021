import java.util.ArrayList;
import java.util.Date;
/*
 * @author - Neha Patidar
 */

public class Square implements Shape{
	double side;
	String timestamp;
	Point coordinatePoints;
	int shapeNo;
	/*
	 * Parameterized constructor
	 * @param point, list
	 */
	Square(Point point, ArrayList<Integer> list){
		this.side = list.get(0);
		this.coordinatePoints = point;
		this.timestamp = new Date().toString();
	}
	
	/*
	 * (non-Javadoc)
	 * @see Shape#getArea()
	 */
	public double getArea(){
		return this.side * this.side;
	}
	
	/*
	 * (non-Javadoc)
	 * @see Shape#getPerimeter()
	 */
	public double getPerimeter(){
		return 4 * this.side;
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
		// TODO Auto-generated method stub
		this.shapeNo = shapeNo;
	}

	@Override
	public int getShapeNo() {
		// TODO Auto-generated method stub
		return this.shapeNo;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		if(point.xCoordinate > coordinatePoints.xCoordinate &&
				point.xCoordinate < (coordinatePoints.xCoordinate +this.side) &&
				point.yCoordinate > coordinatePoints.yCoordinate &&
				point.yCoordinate < (coordinatePoints.yCoordinate +this.side) ) return true;
		// TODO Auto-generated method stub
		return false;
	}
	
}
