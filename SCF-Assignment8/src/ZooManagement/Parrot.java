package ZooManagement;

public class Parrot extends Bird{
	Parrot(){
		super();
		this.animalName = "Parrot";
	}
	/*
	 * (non-Javadoc)
	 * @see ZooManagement.Animal#setId(int)
	 */
	void setId(int animalId){
		this.id = animalId;
	}
	/*
	 * (non-Javadoc)
	 * @see ZooManagement.Animal#setName(java.lang.String)
	 */
	void setName(String name){
		this.name = name; 
	}
	/*
	 * (non-Javadoc)
	 * @see ZooManagement.Animal#setAge(int)
	 */
	void setAge(int age){
		this.age = age;
	}
	/*
	 * (non-Javadoc)
	 * @see ZooManagement.Animal#setWeight(int)
	 */
	void setWeight(int weight){
		this.weight = weight;
	}
	/*
	 * (non-Javadoc)
	 * @see ZooManagement.Animal#getId()
	 */
	int getId(){
		return this.id;
	}
	/*
	 * (non-Javadoc)
	 * @see ZooManagement.Animal#getName()
	 */
	String getName(){
		return this.name;
	}
	/*
	 * (non-Javadoc)
	 * @see ZooManagement.Animal#getType()
	 */
	String getType(){
		return this.type;
	}
	/*
	 * (non-Javadoc)
	 * @see ZooManagement.Animal#getAnimalName()
	 */
	String getAnimalName(){
		return this.animalName;
	}
	String getSound(){
		return "Squawk";
	}
	
}
