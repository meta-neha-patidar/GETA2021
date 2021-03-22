package ZooManagement;
import java.util.*;
public class Cage {
	private final int MaxCap = 5;
	String type;
	private ArrayList<Animal> animals = new ArrayList<>();
	/**
	 * 
	 * @param animalType
	 */
	void setType(String animalType){
		this.type = animalType;
	}
	/**
	 * 
	 * @return this.type
	 */
	String getType(){
		return this.type;	
	}
	/**
	 * 
	 * @return this.MaxCap
	 */
	int getCapacity(){
		return this.MaxCap;
	}
	/**
	 * 
	 * @return animals.size()
	 */
	int getCurrentCapacity(){
		return animals.size();
	}
	/**
	 * 
	 * @return animals
	 */
	ArrayList<Animal> getAnimals(){
		return animals;
	}
	/**
	 * 
	 * @param animal
	 */
	public void addAnimal(Animal animal) {
		setType(animal.getAnimalName());
		animals.add(animal);
		
	}
	/**
	 * @param 
	 */
	public void showAnimals() {
		for(Animal animal:animals){
			System.out.println("Id: " + animal.getId()+", Name: "+animal.getName()+" and sound: "+animal.getSound());
		}
		
	}
		
	
}
