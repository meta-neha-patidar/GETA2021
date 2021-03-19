
/*
 * @author Neha Patidar
 * Shape interface
 */
public interface Shape {
	
	/*
	 * @param shapeNo
	 */
	void setShapeNo(int shapeNo);
	/*
	 * @return shapeNo
	 */
	int getShapeNo();
	/*
	 * @return area
	 */
	double getArea();
	
	/*
	 * return perimeter
	 */
	double getPerimeter();
	
	/*
	 * @return timestamp
	 */
	String getTimestamp();
	
	/*
	 * @return coordinatePoints
	 */
	Point getOrigin();
	/*
	 * @param point
	 * @return true if point enclosed, false otherwise
	 */
	boolean isPointEnclosed(Point point);
	
}
