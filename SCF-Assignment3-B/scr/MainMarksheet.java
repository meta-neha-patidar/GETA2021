package marksheet;

import java.util.*;

public class MainMarksheet {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the number of students : ");			
		int noOfStudent = scanner.nextInt();						//take no of students as input
		if(noOfStudent == 0){
			System.out.println("number Of Student must be greater than 0");
			return ;
		}
		int gradeArray[] = new int[noOfStudent];
		for(int i = 0; i < noOfStudent; i++){
			gradeArray[i] = scanner.nextInt();					// take grade of all students
		}
		// object initialize of MarkSheet class
		MarkSheet markSheet =new MarkSheet();
		
		//print average grade of students
		System.out.println("Average grade  : " + markSheet.averageGrade(gradeArray));
		//print maximum grade among all students
		System.out.println("Maximum grade among all students  : " + markSheet.maximumGrade(gradeArray));
		//print minimum grade among all students
		System.out.println("Minimum grade among all students : " + markSheet.minimumGrade(gradeArray));
		//print percentage of students who passed exam 
		System.out.println("Percentage of student who passes exam : " + markSheet.studentPassedPrcentage(gradeArray));

	}

}
