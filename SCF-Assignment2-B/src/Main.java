import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the no of processes : ");
		//take no of processes as input
		int noOfProcesses = scanner.nextInt();
		if(noOfProcesses == 0){
			//if no of processes = 0  then no operation will be perform
			System.out.println("Number of processes must be greater than 0");
			return ;
		}
		int process[][] = new int[noOfProcesses][2];
		for(int i = 0;i < noOfProcesses; i++){
			
			System.out.println("Enter arrival time and brust time of process " + i);
			process[i][0] = scanner.nextInt();				//taking arrival time as an input
			process[i][1] = scanner.nextInt();				//taking brust time as an input
		}
		
		// object initialization of JobScheduler class
		JobScheduler object = new JobScheduler(noOfProcesses);
		System.out.println("==========compeletion time of processes=======");
		//calling completionTimeMethod() method
		object.completionTimeMethod(process);
		
		System.out.println("==========Turn around time of processes=======");
		// calling turnAroundTimeMethod() method
		object.turnAroundTimeMethod(process);
		
		System.out.println("==========Waiting time of processes=======");
		// calling waitingTimeMethod() method
		object.waitingTimeMethod(process);
		
		System.out.println("Average waiting time : " + object.averageWaitingTime()); //calling averageWaitingTime() method
		
		System.out.println("MAximum waiting time : " + object.maximumWaitingTime()); //calling maximumWaitingTime() method
		
	}

}
