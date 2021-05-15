package model;

public class Pet {
/**
* Description: this var stores the name of the pet
*/
private String petName; 
/**
* Description: this var stores the age of the pet
*/
private int petAge; 
/**
* Description: this var stores the race of the pet
*/
private String petRace;
/**
* Description: Relation with the class Specie
*/
private Specie petSpecie; 
/**
* Description: this var stores the symptoms of the pet
*/
private String petSymptoms;

/**
* Description: Relation with the class Status that allows the pet to have a status 
*/
private Status status;
/**
* Description: Relation with the class Owner that allows the pet to have a personal owner and use its methods
*/
private Owner owner;
/**
* Description: Relation with the class Priority that allows the pet to have a priority
*/
private Priority priorityLevel;
/**
* Description: Relation with the class Specie that allows the pet to have a Specie
*/
private Specie specie;
/**
* Description: Relation with the class Veterinary that allows the pet to be relationated with a personal vet and use its methods
*/
private Veterinary aVet;


// set
public void setStatus (Status status){
	this.status=status;
}
public void setaVet(Veterinary aVet) {

	this.aVet = aVet;
}

// get
public Owner getOwner () {
	
	return owner;
}

public String getPetName () {

	return petName;

}

public Priority getPriority () {

	return priorityLevel;
} 

public Status getStatus (){

	return status;
}

public Veterinary getaVet () {

	return aVet;
}




	/**
   * Description: This method creates an object of the class Pet <br>
   * <b> pos:</b> The atributes will be initialized with a value<br>
   * @param petName String
   * @param petAge int
   * @param petRace String
   * @param specie Specie
   * @param petSymptoms String
   * @param owner Owner
   * @param status Status
   * @param priorityLevel Priority

   */

public Pet (String petName, int petAge, String petRace, Specie specie, String petSymptoms,Owner owner ,Status status, Priority priorityLevel) {


	this.petName=petName;
	this.petAge=petAge;
	this.petRace=petRace;
	this.specie=specie;
	this.petSymptoms=petSymptoms;
	this.priorityLevel=priorityLevel;
	this.status=status;
	this.owner=owner;


}


	/**
   * Description: This method creates an object of the class Pet <br>
   * <b> pos:</b>The atributes will be initialized with a value <br>
   * @param petName String
   * @param petAge int
   * @param specie Specie
   * @param petSymptoms String
   * @param owner Owner
   * @param status Status
   * @param priorityLevel Priority

   */

public Pet (String petName, int petAge,Specie specie, String petSymptoms, Owner owner ,Status status, Priority priorityLevel) {


	this.petName=petName;
	this.petAge=petAge;
	this.petRace=petRace;
	this.specie=specie;
	this.petSymptoms=petSymptoms;
	this.priorityLevel=priorityLevel;
	this.status=status;
	this.owner=owner;


}
















}