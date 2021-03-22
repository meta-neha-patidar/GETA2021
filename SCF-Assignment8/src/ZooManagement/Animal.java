package ZooManagement;

public abstract class Animal {
	int id;
	String name;
	String type;
	String animalName;
	int weight;
	int age;
	/**
	 * 
	 * @param animalId
	 */
	abstract void setId(int animalId);
	/**
	 * 
	 * @param name
	 */
	abstract void setName(String name);
	/**
	 * 
	 * @param age
	 */
	abstract void setAge(int age);
	/**
	 * 
	 * @param weight
	 */
	abstract void setWeight(int weight);
	/**
	 * 
	 * @return
	 */
	abstract int getId();
	/**
	 * 
	 * @return
	 */
	abstract String getName();
	/**
	 * 
	 * @return
	 */
	abstract String getType();
	/**
	 * 
	 * @return
	 */
	abstract String getAnimalName();
	/**
	 * 
	 * @return
	 */
	abstract String getSound();

}
