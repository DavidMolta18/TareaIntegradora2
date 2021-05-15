package model;

public class Veterinary {

/**
* Description: this var stores the name of the veterinary
*/
	private String name;
/**
* Description: this var stores the last name of the veterinary
*/
	private String lastName;
/**
* Description: this var stores the id  of the veterinary
*/
	private String  idNumber;
/**
* Description: this var stores the unique vet number of the veterinary
*/
	private String  uniqueVet;
/**
* Description: Relation with the class VetStatus that allows the vet to have a status
*/
	private VetStatus vetstatus;
/**
* Description: this var stores the number of patients of the veterinary
*/
	private int numberofpatients;
	


// Setters 
	public void setNumberOfPatients (int numberofpatients){

		this.numberofpatients=numberofpatients;
	}

	public void setvetstatus (VetStatus vetstatus){
		this.vetstatus=vetstatus;
	}

// Getters
	public int getNumberOfPatients(){

		return numberofpatients;
	}
	public VetStatus getvetstatus (){
		return vetstatus;
	}

	public String getName (){

		return name;

	}

	public String getlastName () {

		return lastName;
	}

	public String getidNumber () {

		return idNumber;

	}


// Constructor


	/**
   * Description: This is the constructor of the class veterinary <br>
    * <b> pos:</b> The atributes will be initialized with a value<br>
   * @param name String
   * @param lastName String
   * @param idNumber String
   * @param uniqueVet String
   * @param vetstatus VetStatus
   */

	public Veterinary (String name, String lastName, String  idNumber,String  uniqueVet, VetStatus vetstatus) {

		this.name= name;
		this.lastName= lastName;
		this.idNumber=idNumber;
		this.uniqueVet=uniqueVet;
		this.vetstatus=vetstatus;
		

	}


}