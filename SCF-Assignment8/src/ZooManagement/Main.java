package ZooManagement;
import java.util.*;
/**
 * 
 * @author neha.patidar
 *
 */
public class Main {
	
	static List<Zone> zones = new ArrayList<>();
	static int id = 1;
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter 0 to stop performing operations");
			System.out.println("Enter 1 to add Parrot");
			System.out.println("Enter 2 to add peacock ");
			System.out.println("Enter 3 to add pigeon");
			System.out.println("Enter 4 to add cow");
			System.out.println("Enter 5 to add lion");
			System.out.println("Enter 6 to add monkey");
			System.out.println("Enter 7 to add lizard");
			System.out.println("Enter 8 to add snake");
			System.out.println("Enter 9 to add turtle");
			System.out.println("Enter 10 to remove any dead animal");
			System.out.println("Enter 11 to display animals");
			
			int operationCase = scanner.nextInt();
			while(operationCase != 0){
				if(operationCase == 1){
					// add parrot
					Animal  parrot = new Parrot();
					System.out.println("Enter name, age and weight of parrot");
					String name = scanner.next();
					int age = scanner.nextInt();
					int weight = scanner.nextInt();
					addAnimal(parrot,name, age, weight);
				}else if(operationCase == 2){
					//add peacock
					Animal peacock = new Peacock();
					System.out.println("Enter name, age and weight of peacock");
					String name = scanner.next();
					int age = scanner.nextInt();
					int weight = scanner.nextInt();
					addAnimal(peacock,name, age, weight);
				}else if(operationCase == 3){
					//add pigeon
					Animal pigeon = new Pigeon();
					System.out.println("Enter name, age and weight of pigeon");
					String name = scanner.next();
					int age = scanner.nextInt();
					int weight = scanner.nextInt();
					addAnimal(pigeon,name, age, weight);
				}
				else if(operationCase == 4){
					//add cow
					Animal cow = new Cow();
					System.out.println("Enter name, age and weight of cow");
					String name = scanner.next();
					int age = scanner.nextInt();
					int weight = scanner.nextInt();
					addAnimal(cow,name, age, weight);
				}
				else if (operationCase == 5){
					//add lion
					Animal lion = new Lion();
					System.out.println("Enter name, age and weight of lion");
					String name = scanner.next();
					int age = scanner.nextInt();
					int weight = scanner.nextInt();
					addAnimal(lion, name, age, weight);
				}
				else if (operationCase == 6){
					//add monkey
					Animal monkey = new Monkey();
					System.out.println("Enter name, age and weight of monkey");
					String name = scanner.next();
					int age = scanner.nextInt();
					int weight = scanner.nextInt();
					addAnimal(monkey,name, age, weight);
				}
				else if(operationCase == 7){
					//add lizard
					Animal lizard = new Lizard();
					System.out.println("Enter name, age and weight of lizard");
					String name = scanner.next();
					int age = scanner.nextInt();
					int weight = scanner.nextInt();
					addAnimal(lizard,name, age, weight);
				}
				else if (operationCase == 8){
					//add snake
					Animal snake = new Snake();
					System.out.println("Enter name, age and weight of snake");
					String name = scanner.next();
					int age = scanner.nextInt();
					int weight = scanner.nextInt();
					addAnimal(snake,name, age, weight);
				}
				else if (operationCase == 9){
					//add turtle
					Animal turtle = new Turtle();
					System.out.println("Enter name, age and weight of turtle");
					String name = scanner.next();
					int age = scanner.nextInt();
					int weight = scanner.nextInt();
					addAnimal(turtle,name, age, weight);
				}
				else if(operationCase == 10){
					//remove dead animal
					System.out.println("Enter id of dead animal");
					int deadAnimalId = scanner.nextInt();
					removeDeadAnimal(deadAnimalId);
				}
				else if (operationCase == 11){
					//display animals
					display();
				}else{
					System.out.println("Enter a valid operation case");
				}
				System.out.println("Enter operation case from 0 to 11");
				operationCase = scanner.nextInt();
			}
			
		}catch (Exception e){
			System.out.println(e);
		}

	}
	/**
	 * 
	 * @param animalObject
	 * @param name
	 * @param age
	 * @param weight
	 */
	static void addAnimal(Animal animalObject, String name, int age, int weight){
		animalObject.setId(id++);
		animalObject.setName(name);
		animalObject.setAge(age);
		animalObject.setWeight(weight);
		
		boolean isAnimalAdded = false;
		for(Zone zone :zones){
			if(zone.getCategory() == animalObject.getType()){
				isAnimalAdded = zone.addAnimal(animalObject);
			}
		}
		if(! isAnimalAdded){
			Zone newZone = new Zone();
			newZone.setCategory(animalObject.getType());
			newZone.addAnimal(animalObject);
			zones.add(newZone);
		}
		
		
	}
	/**
	 * 
	 * @param deadAnimalId
	 */
	static void removeDeadAnimal(int deadAnimalId){
		boolean removedDeadAnimal = false;
		for(Zone zone: zones){
			ArrayList<Cage> cageList = zone.getCages();
			for(Cage cage: cageList){
				ArrayList<Animal> animals = cage.getAnimals();
				for(Animal animal: animals){
					if(animal.getId() == deadAnimalId){
						removedDeadAnimal = animals.remove(animal);
						break;
					}
				}
				if( removedDeadAnimal){
					if(cage.getCurrentCapacity() == 0){
						cageList.remove(cage);
						
					}
					break;
				}
			}
			if(removedDeadAnimal){
				if(zone.getCages().size() == 0){
					zones.remove(zone);
				}
				break;
			}
		}
		if (removedDeadAnimal){
			System.out.printf("Dead animal having %d id removed successfuly",deadAnimalId);
		}
		else if(!removedDeadAnimal){
			System.out.printf("No animal have %d id\n",deadAnimalId);
		}
	}
	
	/**
	 * purpose display the animals in zoo
	 */
	static void display(){
		if(zones.size() == 0){
			System.out.println("=== Zoo is empty ===");
			return;
		}
		for(Zone zone : zones){
			System.out.println("=== Zone: "+zone.getCategory()+"===");
			zone.displayCages();
		}
	}

}
