
import java.util.ArrayList;
import java.util.Date;

/*
 * @author -Neha Patidar
 */
public class Triangle implements Shape{
	int height, base, x1, x2, x3, y1, y2, y3;
	String timestamp;
	Point coordinatePoints;
	int shapeNo;
	/*
	 * Parameterized constructor
	 * @param point, list
	 */
	Triangle(Point point, ArrayList<Integer> list){
		this.height = list.get(0);
		this.base = list.get(1);
		this.coordinatePoints = point;
		x1 = coordinatePoints.xCoordinate;
		y1 = coordinatePoints.yCoordinate;
		x2 = x1 + this.base;
		y2 = y1 + this.base;
		x3 = x1 + this.height;
		y3 = y1 + this.base;
		this.timestamp = new Date().toString();
		
	}
	/*
	 * (non-Javadoc)
	 * @see Shape#getArea()
	 */
	public double getArea(){
		return area (x1, y1, x2, y2, x3, y3);
	}
	private double area(int x1, int y1, int x2, int y2, int x3, int y3) {
		return Math.abs((x1*(y2-y3) + x2*(y3-y1)+ x3*(y1-y2))*0.5); 
	}
	/*
	 * (non-Javadoc)
	 * @see Shape#getPerimeter()
	 */
	public double getPerimeter(){
		double hypo = Math.sqrt((this.base * this.base) + (this.height * this.height));
		return hypo + this.base + this.height;
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
		// TODO Auto-generated method stub
		int x = point.xCoordinate;
		int y = point.yCoordinate;
		
		double tempVar1 =  area(x,y,x2,y2,x3,y3);
		double tempVar2 = area(x1,y1,x,y,x3,y3);
		double tempVar3 = area(x1,y1,x2,y2,x,y);
		return (this.getArea() == tempVar1 + tempVar2 + tempVar3);
	}
	
}
