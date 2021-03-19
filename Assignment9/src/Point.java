/*
 * @author- Neha Patidar
 */
public class Point {
	int xCoordinate, yCoordinate;
	/*
	 * Parameterized constructor
	 * @param xCoordinate, yCoordinate
	 */
	Point(int xCoordinate, int yCoordinate){
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}
	/*
	 * @return this.xCoordinate
	 */
	int getXCoordinate(){
		return this.xCoordinate;
	}
	/*
	 * @return this.yCoordinate
	 */
	int getYCoordinate(){
		return this.yCoordinate;
	}
}
