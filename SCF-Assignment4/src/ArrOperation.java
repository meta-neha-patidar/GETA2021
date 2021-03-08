import java.util.*;
/*
 * @author - neha patidar
 * 
 */
public class ArrOperation {
	/*
	 * @param array - input array 
	 * @return max - maximum mirror length
	 */
	int maxMirror(int array[])throws AssertionError{
		if(array == null || array.length == 0){
			throw new AssertionError("Inappropriate input");
		}
		int max = 1;
		int longestSeq[][] = new int[array.length+1][array.length+1];
		for(int i = 0; i < array.length; i++){
			for(int j = array.length - 1; j >= 0; j--){
				if(array[i] == array[j]){
					longestSeq[i+1][j] = longestSeq[i][j+1]+1;
					if(longestSeq[i+1][j] > max){
						max = longestSeq[i+1][j];
					}
				}
			}
		}
		return max;
	}
	/*
	 * @param array - input array
	 * @return totalClumps - no of clumps present in given array
	 */
	int countClumps(int array[])throws AssertionError{
		if(array == null || array.length == 0){
			throw new AssertionError("Inappropriate input");
		}
		int totalClumps = 0;
		int tempCount = 1, i = 0;
		while(i < array.length){
			while (i + 1 < array.length && array[i] == array[i+1]){
				i++;
				tempCount++;
			}
			if (tempCount > 1){
				totalClumps++;
			}
			tempCount = 1;
			i++;
		}
		return totalClumps;
	}
	/*
	 * @param array - input array
	 * @return 
	 */
	int [] fixXY(int array[], int x, int y)throws AssertionError{
		if(array==null){
			throw new AssertionError("Null Array Provided ");
		}
		if(array.length==0){
			throw new AssertionError("Length of Array is 0 ");
		}
		if(array[array.length-1]==x){
			throw new AssertionError("X at the last index");
		}
		
		List<Integer> yIndexes = new ArrayList<Integer>();
		for(int i=0;i<array.length;i++){
			if(array[i]==y && (i==0 || array[i-1]!=x)){
				yIndexes.add(i);
			}
		}
		
		int yCount=yIndexes.size();
		int pos=0;
		for(int i=0;i<array.length;i++){
			if(array[i]==x && array[i+1]==x){
				throw new AssertionError("two x together");
			}
			if(array[i]==x && array[i+1]!=y){
				if (pos>=yCount){
					throw new AssertionError("insuffecient no. of y");
				}
				array[yIndexes.get(pos)]=array[i+1];
				array[i+1]=y;
				pos++;
			}
		}
		return array;
	}
	
//	int [] fixXY(int array[], int x, int y){
//		List<Integer> yIndexes = YIndex(array,y,x);
//		int yCount = yIndexes.size();
//		int pos = 0;
//		for(int i = 0;i < array.length; i++){
//			if(array[i]== x && array[i+1]!= y){
//				array[yIndexes.get(pos)] = array[i+1];
//				array[i+1] = y;
//				pos++;
//			}
//		}
//		return array;
//	}
//	public static List<Integer> YIndex(int arr[],int y,int x){
//		List<Integer> yIndexes = new ArrayList<Integer>();
//		for(int i=0;i<arr.length;i++){
//			if(arr[i]==y && (i==0 || arr[i-1]!=x)){
//				yIndexes.add(i);
//			}
//		}
//		return yIndexes;
//	}
	/*
	 * @param array - input array
	 * @return index from where array is split otherwise @return -1
	 */
	int splitArray(int [] array)throws AssertionError{
		if(array == null || array.length == 0){
			throw new AssertionError("Inappropriate input");
		}
		int prefixSum[] = new int[array.length];
		int total = array[0];
		prefixSum[0] = total;
		for(int i = 1; i < array.length; i++){
			total += array[i];
			prefixSum[i] = total;
		}
		for(int index = 0; index < array.length; index++){
			
			if(prefixSum[index] == (total - prefixSum[index])){
				return index + 1;
			}
		}
		return -1;
	}
	/*
	 * main() method
	 */
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		ArrOperation object = new ArrOperation();
		
		System.out.println("Enter 0 to stop performing operation");
		System.out.println("Enter 1 to perform maximum mirror operation on array");
		System.out.println("Enter 2 to perform count clumps operation on array");
		System.out.println("Enter 3 to perform fixXY opearation on array");
		System.out.println("Enter 4 to perform split array opearation on array");
		int operationCase = scanner.nextInt();
		while(operationCase != 0){
			if(operationCase == 1){
				//maxMirror()
				System.out.println("Enter length of array : ");
				int lenArray = scanner.nextInt();
				int array[] = new int[lenArray];
				for(int i = 0; i < lenArray; i++){
					array[i] = scanner.nextInt();
				}
				System.out.println("Maximum mirror in given array = " + object.maxMirror(array));
			}else if (operationCase == 2){
				//countClumps()
				System.out.println("Enter length of array : ");
				int lenArray = scanner.nextInt();
				int array[] = new int[lenArray];
				for(int i = 0; i < lenArray; i++){
					array[i] = scanner.nextInt();
				}
				System.out.println("number of clumps in given array = " + object.countClumps(array));
			}else if (operationCase == 3){
				// fixXY()
				System.out.println("Enter length of array : ");
				int lenArray = scanner.nextInt();
				int array[] = new int[lenArray];
				for(int i = 0; i < lenArray; i++){
					array[i] = scanner.nextInt();
				}
				System.out.println("Enter x and y value");
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				array = object.fixXY(array, x, y);
				System.out.println("output");
				for(int i = 0; i < lenArray; i++){
					System.out.println(array[i] + " ");
				}
				System.out.println();
			}else if(operationCase == 4){
				//splitArray()
				System.out.println("Enter length of array : ");
				int lenArray = scanner.nextInt();
				int array[] = new int[lenArray];
				for(int i = 0; i < lenArray; i++){
					array[i] = scanner.nextInt();
				}
				System.out.println("Index from where array split into two with equal sum = " + object.splitArray(array));
			}else{
				System.out.println("Enter a valid case");
			}
			System.out.println("Enter case from 0 to 4");
			operationCase = scanner.nextInt();
		}
	}
	
}
