package part1;

import java.util.*;

/*
 * @author Neha Patidar
 */
public class IntSet {
	private ArrayList<Integer> set = new ArrayList<>();
	/*
	 * Parameterized constructor
	 * @param array
	 */
	IntSet(int array[]){
		for(int index = 0;index <array.length; index++){
			if(!set.contains(array[index])){
				set.add(array[index]);
			}
		}
	}
	
	/*
	 * getter method for set
	 * @return this.set
	 */
	ArrayList<Integer> getSet(){
		return this.set;
	}
	
	/*
	 * @return set.size()
	 */
	int size(){
		return set.size();
	}
	
	/*
	 * purpose check if the value is a member of set or not
	 * @param valueToSearch
	 * @return true if value is member of set, false otherwise
	 */
	boolean isMember(int valueToSearch){
		//traverse using for each loop
		for(int element : set){
			if(element == valueToSearch)return true;
		}
		return false;
	}
	
	/*
	 * purpose to check if given set is subset of actual set or not
	 * @param subsetToCheck
	 * @return true if given set is subset of actual set, false otherwise
	 */
	boolean isSubSet(IntSet subsetToCheck){
		for(int element: subsetToCheck.getSet()){
			if(!this.isMember(element)){
				return false;
			}
		}
		return true;
	}
	
	/*
	 * purpose get the complement of set
	 * @return complement
	 */
	ArrayList<Integer> getComplement(){
		ArrayList<Integer> complement = new ArrayList<>();
		
		for(int element = 0; element <= 1000; element++){
			if(!set.contains(element)){
				complement.add(element);
			}
		}
		
		return complement;
	}
	
	/*
	 * purpose union of 2 sets
	 * @param set1, set2
	 * @return unionSet
	 */
	static ArrayList<Integer> unionSet(IntSet set1, IntSet set2){
		ArrayList<Integer> unionSet = new ArrayList<>();
		for(int element : set1.getSet()){
			unionSet.add(element);
		}
		for(int element : set2.getSet()){
			if(!unionSet.contains(element)){
				unionSet.add(element);
			}
		}
		return unionSet;
	}
	
	
}
