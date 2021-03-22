package ZooManagement;

public  class Turtle extends Reptile{

	Turtle(){
		super();
		this.animalName = "Turtle";
	}
	@Override
	void setId(int animalId) {
		// TODO Auto-generated method stub
		this.id = animalId;
	}

	@Override
	void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	@Override
	void setAge(int age) {
		// TODO Auto-generated method stub
		this.age = age;
	}

	@Override
	void setWeight(int weight) {
		// TODO Auto-generated method stub
		this.weight = weight;
	}

	@Override
	int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	String getType() {
		// TODO Auto-generated method stub
		return this.type;
	}

	@Override
	String getAnimalName() {
		// TODO Auto-generated method stub
		return this.animalName;
	}

	@Override
	String getSound() {
		// TODO Auto-generated method stub
		return "Cluck";
	}

}
