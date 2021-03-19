package part1;
import java.util.*;

/*
 * @author: Neha Patidar
 */
public class Main {
	static void printSet(ArrayList<Integer> set){
		for(int element : set){
			System.out.print(element + " ");
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			Scanner scanner = new Scanner(System.in);
			System.out.println("Ener the length of input array");
			int length = scanner.nextInt();
			int setArray[] = new int[length];
			System.out.printf("Enter %d set elements\n",length);
			for(int index = 0;index < length; index++){
				setArray[index] = scanner.nextInt();
			}
			IntSet set1 = new IntSet(setArray);
			
			System.out.println("Enter 0 to end operations");
			System.out.println("Enter 1 to check if the element is a member of given set");
			System.out.println("Enter 2 to print the size of set");
			System.out.println("Enter 3 to check if the given set is subsetof set or not");
			System.out.println("Enter 4 to get the compliment of the set");
			System.out.println("Enter 5 to union two sets");
			
			int operationCase = scanner.nextInt();
			while(operationCase != 0){
				
				if(operationCase == 1){
					//isMemeber()
					System.out.println("Enter an integer value to check is member of set ");
					int element = scanner.nextInt();
					System.out.println(element + " is a member of set = " + set1.isMember(element));
					
				}else if(operationCase == 2){
					//size()
					System.out.println("Size of set = " + set1.size());
					
				}else if(operationCase == 3){
					//isSubSet()
					System.out.println("Ener the length of input sub array");
					int subLength = scanner.nextInt();
					int subArray[] = new int[subLength];
					System.out.printf("Enter %d set elements\n",subLength);
					for(int index = 0;index < subLength; index++){
						subArray[index] = scanner.nextInt();
					}
					IntSet subSet = new IntSet(subArray);
					System.out.println("given set is subset of set1 = " + set1.isSubSet(subSet));
					
				}else if(operationCase == 4){
					//getComplement()
					ArrayList<Integer> complementSet = set1.getComplement();
					System.out.println("\nComplement set");
					printSet(complementSet);
					
				}else if(operationCase == 5){
					//unionSet()
					System.out.println("Ener the length of input sub array");
					int length2 = scanner.nextInt();
					int array2[] = new int[length2];
					System.out.printf("Enter %d set elements\n",length2);
					for(int index = 0;index < length2; index++){
						array2[index] = scanner.nextInt();
					}
					IntSet set2 = new IntSet(array2);
					ArrayList<Integer> unionSet = IntSet.unionSet(set1, set2);
					System.out.println("\nUnion set");
					printSet(unionSet);
				}else{
					System.out.println("Invalid choice");
				}
				
				System.out.println("Enter operation case from 0 to 5");
				operationCase = scanner.nextInt();
			}
			System.out.println("Done");
			
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
