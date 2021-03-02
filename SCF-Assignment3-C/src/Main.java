import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 0 to stop calculating :");
		System.out.println("Enter 1 for calculating area of triangle :");
		System.out.println("Enter 2 for calculating area of rectangle :");
		System.out.println("Enter 3 for calculating area of square :");
		System.out.println("Enter 4 for calculating area of circle :");
		//take input to select shape
		int operation = scanner.nextInt();
		Area areaObject=new Area();
		
		while(operation != 0){
			if(operation == 1){
				//area of triangle
				System.out.println("Enter height and base of triangle must be greater than 0: ");
				double height = scanner.nextDouble();								// height of triangle to calculate area of triangle
				double base = scanner.nextDouble();								//base of triangle to calculate area of triangle
				if(height == 0 || base == 0){
					System.out.println("Invalid input");
				}else
					System.out.println("Area of triangle is : " + areaObject.areaOfTriangle(height, base));				//area of triangle as an output
			}
			else if(operation == 2){
				//area of rectangle
				System.out.println("Enter length and width of rectangle must be greater than 0: ");
				double length = scanner.nextDouble();							//length of rectangle
				double width = scanner.nextDouble();							//width of rectangle
				if(length == 0 || width == 0){
					System.out.println("Invalid input");
				}else
					System.out.println("Area of rectangle is : " + areaObject.areaOfRectangle(length, width));		//area of rectangle as an output
			}
			else if(operation == 3){
				//area of square
				System.out.println("Enter the side of square must be greater than 0: ");
				double side = scanner.nextDouble();							//side of square to calculate ares
				if(side == 0){
					System.out.println("Invalid input");
				}else
					System.out.println("Area of square : " + areaObject.areaOfSquare(side));		//area of square as an output
			}
			else if(operation == 4){
				//area of circle
				System.out.println("Enter radius of circle greater than 0: ");
				double radius = scanner.nextDouble();						//radius of circle to calculate area
				if(radius == 0){
					System.out.println("Invalid input");
				}else
					System.out.println("Area of circle : " + areaObject.areaOfCircle(radius));			//area of circle as an output
			}
			else{
				System.out.println("Select a valid input : ");			//number is not in between 0-4
			}
			System.out.println("Select number from 0 to 4 : ");
			operation = scanner.nextInt();
		}
		System.out.println("opearations done");
	}

}
