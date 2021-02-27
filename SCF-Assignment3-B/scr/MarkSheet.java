package marksheet;

public class MarkSheet {
	float averageGrade(int grade[]){
		float result = 0;
		for(int i = 0; i < grade.length; i++){
			result +=grade[i];
		}
		if (result <= 0) return 0;				//if sum of grade is 0 then return 0
		result = result / grade.length;
		return Math.round(result);
	}
	int maximumGrade(int grade[]){
		if(grade.length ==0 ) return 0;			// if no of student is 0 then return 0
		int maximum = grade[0];
		for(int i = 1; i < grade.length; i++){
			maximum = Math.max(maximum, grade[i]);
		}
		return maximum;							// returning maximum grade among all
	}
	int minimumGrade(int grade[]){
		if(grade.length ==0)return 0;			// if no of student is 0 then return 0
		int minimum = grade[0];
		for(int i = 1;i < grade.length; i++){
			minimum =Math.min(minimum, grade[i]);
		}
		return minimum;							// returning minimum grade among all 
	}
	
	float studentPassedPrcentage(int grade[]){
		if(grade.length == 0) return 0;			// if no of student is 0 then return 0
		
		int noOfStudentPassed = 0;
		for(int i = 0; i < grade.length; i++){
			if(grade[i] >= 40) noOfStudentPassed++;			
		}
		if(noOfStudentPassed == 0)return 0;				//if no one passes exam
		return Math.round(((float)noOfStudentPassed / (float)grade.length) * 100.0);		//returning required result 
	}

}
