package ZooManagement;
import java.util.*;
public class Zone {
	private final int MaxCages = 5;
	private ArrayList<Cage> cageList = new ArrayList<>();
	boolean hasPark;
	String category;
	
	/**
	 * 
	 * @param category
	 */
	void setCategory(String category){
		this.category = category;
	}
	/**
	 * 
	 * @return
	 */
	String getCategory(){
		return this.category;
	}
	/**
	 * 
	 * @param newAnimal
	 */
	boolean addAnimal(Animal newAnimal){
		if(cageList.size() == MaxCages){
			System.out.println("No cages are available to add animal");
			return false;
		}
		boolean isAnimalAdded = false;
		for (Cage cage: cageList){
			if(cage.getCurrentCapacity() < cage.getCapacity() && cage.getType() == newAnimal.getAnimalName()){
				cage.addAnimal(newAnimal);
				isAnimalAdded = true;
				break;
			}
		}
		if(! isAnimalAdded){
			Cage cage = new Cage();
			cage.addAnimal(newAnimal);
			cageList.add(cage);
		}
		
		return true;
			
	}
	/*
	 * purpose: display cages
	 */
	void displayCages(){
		for(int index = 0; index< this.cageList.size() ; index++){
			System.out.println(this.cageList.get(index).getType());
			this.cageList.get(index).showAnimals();
		}
	}
	/**
	 * 
	 * @return this.cageList
	 */
	ArrayList<Cage> getCages(){
		return this.cageList;
	}
	
}
