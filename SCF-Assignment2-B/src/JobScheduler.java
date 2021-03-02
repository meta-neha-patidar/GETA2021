/*
Calculate completion time for each process. 
Calculate waiting time for each process.
Calculate turn around time for each process.
Average waiting time of processes.
Maximum waiting time period for a process in queue.


Here we have simple formulae for calculating various times for given processes:

Completion Time: Time taken for the execution to complete, starting from arrival time of first process.
Turn Around Time: Time taken to complete after arrival. In simple words, it is the difference between the Completion time and the Arrival time.
Waiting Time: Total time the process has to wait before it's execution begins. It is the difference between the Turn Around time and the Burst time of the process.
Burst Time : Time required to execute a process.


 */
public class JobScheduler {
	static int noOfProcesses;
	static int [] completionTime;
	static int [] waitingTime;
	static int [] turnAroundTime;
	JobScheduler (int noOfProcesses){
		this.noOfProcesses = noOfProcesses;
		completionTime = new int[noOfProcesses];
		turnAroundTime  = new int[noOfProcesses];;
		waitingTime = new int[noOfProcesses];
	}
	void completionTimeMethod(int [][] process){
		System.out.println("process\t  completion time");

		for(int i = 0; i < noOfProcesses; i++){
			if(i == 0 ||completionTime[i-1] < process[i][0]){
				completionTime[i] =  process[i][0] + process[i][1];
				System.out.println("process[" + i + " ]\t\t\t"+ completionTime[i]);		//completionTime calculating
			}else{
				completionTime[i] = completionTime[i-1] + process[i][1];		//completionTime calculating
				System.out.println("process[" + i + " ]\t\t\t"+ completionTime[i]);
			}
		}
	}
	
	void turnAroundTimeMethod(int [][]process){
		System.out.println("process\t turn around time");
		turnAroundTime[0] = process[0][1];
		System.out.println("process[0]\t\t\t" + turnAroundTime[0]);
		for(int i = 1; i < noOfProcesses; i++){
			turnAroundTime[i] = completionTime[i] - process[i][0];					//turn around time calculation
			System.out.println("process[" + i + " ]\t\t\t"+ turnAroundTime[i]);
		}
	}
	void waitingTimeMethod(int [][]process){
		System.out.println("process\t waiting time");
		for(int i = 0; i < noOfProcesses; i++){
			waitingTime[i] = turnAroundTime[i] - process[i][1];						//waiting time calculation
			System.out.println("process[" + i + " ]\t\t\t"+ waitingTime[i]);
		}
	}
	
	float averageWaitingTime(){
		int total = 0;
		for(int i = 0; i < noOfProcesses; i++){
			total += waitingTime[i];						//total waiting time calculation
		}
		return (float) (total / noOfProcesses);			//returning average waiting time
	}
	
	int maximumWaitingTime(){
		int maxWait = waitingTime[0];
		for(int i = 1; i < noOfProcesses; i++){
			maxWait = Math.max(maxWait, waitingTime[i]);
		}
		return maxWait;						//returning maximum waiting time
	}

}
