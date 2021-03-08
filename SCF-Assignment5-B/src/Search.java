import java.util.*;
public class Search {

	/*
	 * @param array, element, index
	 * @return index - if element found else return -1
	 */
	static int linearSearch(int [] array, int element,int index){
		if(index == array.length) return -1;
		if(element == array[index]) return index;
		return linearSearch(array, element, index + 1);
		
	}
	/*
	 * @param array -assuming sorted array,element- which is to be search, firstIndex, lastIndex
	 */
	static int binarySearch(int array[], int element, int firstIndex, int lastIndex){
		if( firstIndex > lastIndex) return -1;
		int mid = (firstIndex + lastIndex) /2;
		if(element == array[mid])return mid;
		if (element > array[mid] ) return binarySearch(array, element, mid + 1, lastIndex);
		return binarySearch(array, element, firstIndex, mid -1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter 0 to exit");
		System.out.println("Enter 1 for linear search : ");
		System.out.println("Enter 2 for binary search : ");
		int operationCase = scanner.nextInt();
		while(operationCase != 0){
			if (operationCase == 1){
				System.out.println("Enter length of array : ");
				int len = scanner.nextInt();
				int array[] = new int[len];
				System.out.printf("Enter %d elements : \n", len);
				for(int i = 0 ; i < len; i++)
					array[i] = scanner.nextInt();
				System.out.println("Enter element to search");
				int element = scanner.nextInt();
				System.out.println("Element present at index: " + linearSearch(array, element, 0));
				
			}else if (operationCase == 2){
				System.out.println("Enter length of array : ");
				int len = scanner.nextInt();
				int array[] = new int[len];
				System.out.printf("Enter %d elements in sorted order : \n", len);
				for(int i = 0 ; i < len; i++)
					array[i] = scanner.nextInt();
				System.out.println("Enter element to search");
				int element = scanner.nextInt();
				System.out.println("Element present at index: " + binarySearch(array, element, 0, len));
			}else{
				System.out.println("Enter a valid operation case");
			}
			System.out.println("Enter 0, 1 or 2");
			operationCase = scanner.nextInt();
		}
	}

}
