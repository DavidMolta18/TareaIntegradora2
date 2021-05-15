package model;
import model.Veterinary;
import model.Owner;



public class Center {


/**
* Description: Relation with the class Veterinary that allows to store 7 vets
*/
	private Veterinary [] veterinaryarray;

/**
* Description: Relation with the class Pet that allows to store 120 pets
*/
	private Pet [] petarray;
/**
* Description: Var to have a count of how many vets are in the center
*/
	private int veterinaryNumber;
/**
* Description: var to have a count of how many pets are in the center
*/
	private int petNumber;
/**
* Description: A constant with the maximum number of vets
*/
	private final int MAX_VETS = 7;
/**
* Description: A constant with the maximum number of pets
*/
	private final int MAX_PETS=120;
/**
* Description: A var to save the name of the pet center
*/
	private String petCenterName;
/**
* Description: Position to save the pet that is next
*/
	private int pos; 
/**
* Description: Var to save how many pets haven't been attended
*/
	private double noattended; 
/**
* Description: Var to save how many pets left without been attented
	
*/
	private double leftnoattended; 

/**
* Description: Var to save all the pets
*/
	private double totalPets;  
/**
* Description: Var to save the total pets attended of priority1
*/
	private int totalPriority1; 
/**
* Description: Var to save the total pets attended of priority2
*/
	private int totalPriority2; 
/**
* Description: Var to save the total pets attended of priority3
*/
	private int totalPriority3;
/**
* Description: Var to save the total pets attended of priority4
*/
	private int totalPriority4;  
/**
* Description: Var to save the total pets attended of priority5
*/
	private int totalPriority5;



	// get

	public String getCenterName () {

		return petCenterName;
	}

	// Constructor

	/**
   * Description: This is the constructor of the class center <br>
   * <b> pre:</b> User must enter a name in the menu to start the center<br>
   * <b> pos:</b> Initialize veterinaryarray,petarray,noattended,petNumber,veterinaryNumber // the pet center has now a name  <br>
   * @param name String
   */


	public Center (String name) {
	
		veterinaryNumber=0;
		petNumber=0;


		petCenterName= name;

		veterinaryarray= new Veterinary [MAX_VETS];
		petarray= new Pet [MAX_PETS];
		noattended=0;
	
	}

	
	/**
   * Description: This method creates an object of the class Veterinary <br>
   * <b> pre:</b> veterinaryarray must have at least one empty space to save a new vet<br>
   * <b> pos:</b> the veterinaryarray is filled with one vet// Object was created // veterinaryNumber++ <br>
   * @param name String
   * @param lastName String
   * @param idNumber String
   * @param uniqueVet String
   * @param vetstatus VetStatus
   */

	public void addVeterinary (String name, String lastName, String  idNumber, String  uniqueVet,VetStatus vetstatus) {

		boolean exit=false; // Var to control if the space on the array is available
		boolean diff= false; //boolean to control that there are not 2 vets with same information
		
		for (int i=0; i<MAX_VETS;i++){
			if(veterinaryarray[i]!=null && veterinaryarray[i].getidNumber().equalsIgnoreCase(idNumber)){
				diff=true;
				System.out.println("There's a vet with the same information");
				System.out.println("Saving a veterinary was not possible");

			}

		}

	
		if (!diff && veterinaryNumber==7){

			System.out.println("There is no space to create another Veterinary! , please try to delete an existing one");
			

			}else {

			for (int i =0 ;!diff && !exit && i<MAX_VETS; i++) {    // For to verify if there is a space to save a Vet

				if (veterinaryarray[i]==null){
				veterinaryarray[i] = new Veterinary(name,lastName,idNumber,uniqueVet,vetstatus);
				exit= true;
				veterinaryNumber++;
				System.out.println("Veterinary succesfully added");
				System.out.println("There are currently: "+ veterinaryNumber + " vets");
		
				}

			}
		} 
	}


	/**
   * Description: This deletes a veterinary of the array veterinaryarray <br>
   * <b> pre:</b> The petsarray must be empty to delete a vet<br>
   * <b> pos:</b> The veterinary with the id that was entered is deleted // veterinaryNumber--<br>
   * @param idNumber String
   */


	public void deleteVeterinary (String  idNumber) {

		String verify= idNumber;
		int check = 1; // Var to verify that the veterinary was succesfully deleted
		boolean exit=false;
		if (petNumber!=0){
			System.out.println("There's 1 or more pet registered, we can't delete a vet");
			exit=true;
		}


		for(int del=0; !exit && del<MAX_VETS ; del++) {

			if (veterinaryarray[del]!=null && veterinaryarray[del].getidNumber().equalsIgnoreCase(verify)){
			veterinaryarray[del]=null;
			check=-1;
			System.out.println("The veterinarian has been successfully deleted!");
			veterinaryNumber--;
			}

		}

		if (!exit && check==1){
		System.out.println("Oops! our system didn't find a veterinarian with that id number, please verify you entered the correct number or that you have created a vet first");
		} 
	}


	/**
   * Description: This method creates an object of the class Pet <br>
   * <b> pre:</b> petarray must have at least one empty space to save a new vet // PET MUST BE A CAT OR A DOG TO HAVE RACE<br>
   * <b> pos:</b> the petarray is filled with one pet// Object was created// seePriority is called, this helps to see which pet is next on the list to be attended according to its priority // totalPets++//noattended++<br>
   * @param petName String
   * @param petAge int
   * @param petRace String
   * @param petSpecie Specie
   * @param petSymptoms String
   * @param owner Owner
   * @param status Status
   * @param priority Priority

   */

	public void addPet (String petName, int petAge, String petRace, Specie petSpecie, String petSymptoms, Owner owner,Status status, Priority priority){


		boolean cent=false;

		boolean exit= false;
		boolean combination=false;

		for (int i=0;i<MAX_PETS ; i++){

		if(petarray[i]!=null && petarray[i].getPetName().equalsIgnoreCase(petName) && petarray[i].getOwner().getownerName().equalsIgnoreCase(owner.getownerName())){
                    System.out.println("The pet " + petName + " , "+ "with the owner: " + owner.getownerName() + " already exists\n");
                    combination=true;
                }




		}



		for (int i =0 ;!combination && !exit && i<MAX_PETS; i++) {    // For to verify if there is a space to save a pet

			if (!combination && petarray[i]==null){
			petarray[i] = new Pet(petName,petAge,petRace,petSpecie,petSymptoms,owner, status, priority);
			exit= true;
			petNumber++;
			System.out.println("The pet was successfully saved.");
			System.out.println("There are currently "+ petNumber + " pets");
			
			noattended++;
			seePriority();

			totalPets++;
			}

		}

		
		

		if ( !combination && petNumber==120){
			System.out.println("There's no vacant to register a pet, please delete one.");
		}
	}


	/**
   * Description: This method creates an object of the class Pet <br>
   * <b> pre:</b> petarray must have at least one empty space to save a new vet // PET CAN'T BE A DOG OR A CAT<br>
   * <b> pos:</b> the petarray is filled with one pet// Object was created // seePriority is called, this helps to see which pet is next on the list to be attended according to its priority// totalPets++ // noattended++<br>
   * @param petName String
   * @param petAge int
   * @param petSpecie Specie
   * @param petSymptoms String
   * @param owner Owner
   * @param status Status
   * @param priority Priority

   */


	public void addPet (String petName, int petAge, Specie petSpecie, String petSymptoms, Owner owner,Status status, Priority priority){

		boolean exit= false;
		boolean combination=false;
		boolean cent=false;

		for (int i=0;i<MAX_PETS ; i++){

		if(petarray[i]!=null && petarray[i].getPetName().equalsIgnoreCase(petName) && petarray[i].getOwner().getownerName().equalsIgnoreCase(owner.getownerName())){
                    System.out.println("The pet " + petName + " , "+ "with the owner: " + owner.getownerName() + " already exists\n");
                    combination=true;
                }

		}

		for (int i =0 ;!exit && i<MAX_VETS; i++) {    // For to verify if there is a space to save a pet

			if (!combination && petarray[i]==null){
			petarray[i] = new Pet(petName,petAge,petSpecie,petSymptoms,owner,status,priority);
			exit= true;
			petNumber++;
			System.out.println("The pet was successfully saved.");
			System.out.println("There are currently "+ petNumber + " pets");
			
			noattended++;
			seePriority();
			totalPets++;
			}


		}

		
		



		

		if ( !combination && petNumber==120){
			System.out.println("There's no vacant to register a pet, please delete one.");
		}
	}



	/**
	* Description: This method deletes a pet of the array petarray
	<b> pre: </b> the pet can't be in other status than WAITING // petarray must have at least one pet registered // pet cannot be in consult
	<b> pos: </b> the pet with the information associated (petName and ownerid) is now with a different status (EXIT WITHOUT ATTENTION)// leftnoattended++ // petNumber-- 
	* @param petName String
	* @param ownerid double

	*/

	public void deletePet (String petName, double ownerid){
		
		boolean exit= false;
		

		for(int i=0; !exit && i<MAX_PETS ; i++) {

			if (!exit && petarray[i]!=null && petarray[i].getOwner().getowneridNumber()==ownerid){

				if(!exit && petarray[i].getPetName().equalsIgnoreCase(petName) && petarray[i].getStatus()==Status.WAITING){


					petarray[i].setStatus(Status.EXIT_WITHOUT_ATTENTION);
			
					System.out.println("The pet left the center!");
					petNumber--;
					System.out.println("There are currently "+ petNumber + " pets");
					exit=true;
					seePriority();
					leftnoattended++;

				}else {
					System.out.println("INCORRECT PET NAME --//OR//-- THE PET IS NOT WAITING TO BE ATTENDED");
					exit=true;}

			
			}else if(i==6){
				System.out.println("There is no pet associated with that owner id, PLEASE check that you have registered a pet or that you digit the correct number");
			}

		}

	}


	/**
	* Description: This method starts a consult 
	<b> pre: </b> A vet must exist, vet must be free, a pet must exist, pet must be on WAITING // seePriority must be initializated
	<b> pos: </b> the pet with the information associated in seePriority is now being attended by the vet with the id given// Pet status change from WAITING to IN CONSULTATION // the vet is now associated with the pet that is attending//noattended--
	* @param id String
	*/


	public void startConsult (String id){
		
		boolean exit= false;
		boolean nopet=false;
		int condition=0;
		boolean novet=false;
		
		

			if(petarray[pos]==null){
				System.out.println("There's no pet waiting to be attended");
				nopet=true;
			}

			
			if (!nopet && veterinaryNumber==0) {

				System.out.println("Please register a vet first");
				novet=true;
			}


			for (int i=0;!novet && !nopet && !exit && i<MAX_VETS; i++){

				if(veterinaryarray[i]!=null && veterinaryarray[i].getvetstatus()==VetStatus.FREE && veterinaryarray[i].getidNumber().equalsIgnoreCase(id)){

					veterinaryarray[i].setvetstatus(VetStatus.IN_CONSULT);
					countPerconsult(petarray[pos].getPriority());
					petarray[pos].setaVet(veterinaryarray[i]);
					petarray[pos].setStatus(Status.IN_CONSULTATION);
					System.out.println("The pet: "+ petarray[pos].getPetName()+ " is being attended by: "+ veterinaryarray[i].getName() + " " + veterinaryarray[i].getlastName());
					int numberofpatients = veterinaryarray[i].getNumberOfPatients();
					numberofpatients++;
					veterinaryarray[i].setNumberOfPatients(numberofpatients);
					condition =1;
					noattended--;
					
					seePriority();
					
							


				}

			

			}

			if (!novet && !nopet && condition==0){
				System.out.println("Please check that the vet you selected is FREE or that the id number is correct!");

			}

	}

	/**
	* Description: This method ends a consult
	<b> pre: </b> The pet must be in consult, the vet must be in consult, the id of the vet must be associated with the name of the pet
	<b> pos: </b> The consult is now finished, vet status changed from IN CONSULT to FREE and pet status changed from IN CONSULTATION to HOSPITALIZATION or AUTHORIZED DEPARTURE
	* @param id String
	* @param petName String
	* @param option int 
	
	*/


	public void endConsult (String id, String petName,int option) {

		boolean exit=false;
		boolean inconsult=true;
		int position=0;
		String aId= id;
		String apetName=petName;
		int aOption=option;
		

		for (int i=0;!exit && i<MAX_VETS; i++) {

			if(veterinaryarray[i]!=null && veterinaryarray[i].getidNumber().equalsIgnoreCase(id) && veterinaryarray[i].getvetstatus()==VetStatus.IN_CONSULT){
				inconsult=false;
				exit=true;
				position=i;
				

			}


		}

		if (inconsult==true){

			System.out.println("We didn't find a vet with that id or the vet is not in consult PLEASE CHECK YOUR INFORMATION");


		}else exit=false;

		for (int a=0;!inconsult && !exit &&  a<MAX_PETS; a++) {


			if(petarray[a]!=null && petarray[a].getPetName().equalsIgnoreCase(apetName) && petarray[a].getStatus()==Status.IN_CONSULTATION && petarray[a].getaVet().getidNumber().equals(aId)){
			
				if(aOption==1){

					petarray[a].setStatus(Status.AUTORIZHED_DEPARTURE);
					veterinaryarray[position].setvetstatus(VetStatus.FREE);
					System.out.println("The consult was successfully finished, now the vet "+ veterinaryarray[position].getName()+ " "+ veterinaryarray[position].getlastName()+" is ready to attend other pet");
					System.out.println("The pet "+ petarray[a].getPetName() + " changed its status to AUTORIZHED DEPARTURE.");
					System.out.println("Pets waiting for attendance: " + noattended);
					exit=true;


				}else if (aOption==2) {

					petarray[a].setStatus(Status.HOSPITALIZATION);
					veterinaryarray[position].setvetstatus(VetStatus.FREE);
					System.out.println("The consult was successfully finished, now the vet: "+ veterinaryarray[position].getName()+" "+ veterinaryarray[position].getlastName()+" is ready to attend other pet");
					System.out.println("The pet: "+ petarray[a].getPetName() + " is now hospitalized, we're sorry to hear that.");
					System.out.println("Pets waiting for attendance: " + noattended);
					exit=true;

				}else {
					System.out.println("Select a correct option");
					exit=true;
				}


			}else if (a==119){
				System.out.println("There's no pet /Or/ Incorrect name /Or/ The pet is not in consult /Or/ The vet is not attending this pet"); // CHECKE
			}


		}


	}

	/**
    * Description: This method helps the user to know which pet is next on the list based on its priority<br>
    * <b> pre:</b> petarray must have at least one pet<br>
    * <b> pos:</b> the var pos is actualizated with the position of the pet that is next to be attended according to its priority<br>
    */

	public void seePriority(){

		boolean cent=false;
		

		


		for(int i=0;!cent && i<MAX_PETS;i++){

			if(petarray[i]!=null && petarray[i].getStatus()==Status.WAITING && petarray[i].getPriority()==Priority.PRIORITY1){
			pos=i;
			cent=true;
			System.out.println("The next pet to be attended is " + petarray[pos].getPetName()+ " with the owner identified with the id number: "+ petarray[pos].getOwner().getowneridNumber()+ " " + " named "+ petarray[pos].getOwner().getownerName());
			System.out.println("Pets waiting for attendance: " + noattended);
			

			}

		}
		for(int i=0;!cent &&i<MAX_PETS;i++){

			if(petarray[i]!=null && petarray[i].getStatus()==Status.WAITING && petarray[i].getPriority()==Priority.PRIORITY2){
			pos=i;
			cent=true;
			System.out.println("The next pet to be attended is: " + petarray[pos].getPetName()+ " with the owner identified with the id number: "+ petarray[pos].getOwner().getowneridNumber()+ " " + " named "+ petarray[pos].getOwner().getownerName());
			System.out.println("Pets waiting for attendance: " + noattended);
			
			}

		}
		for(int i=0;!cent &&i<MAX_PETS;i++){

			if(petarray[i]!=null && petarray[i].getStatus()==Status.WAITING && petarray[i].getPriority()==Priority.PRIORITY3){
			pos=i;
			cent=true;
			System.out.println("The next pet to be attended is: " + petarray[pos].getPetName()+ " with the owner identified with the id number: "+ petarray[pos].getOwner().getowneridNumber()+ " " + " named "+ petarray[pos].getOwner().getownerName());
			System.out.println("Pets waiting for attendance: " + noattended);
			
			}

		}
		for(int i=0;!cent &&i<MAX_PETS;i++){

			if(petarray[i]!=null && petarray[i].getStatus()==Status.WAITING && petarray[i].getPriority()==Priority.PRIORITY4){
			pos=i;
			cent=true;
			System.out.println("The next pet to be attended is: " + petarray[pos].getPetName()+ " with the owner identified with the id number: "+ petarray[pos].getOwner().getowneridNumber()+ " " + " named "+ petarray[pos].getOwner().getownerName());
			System.out.println("Pets waiting for attendance: " + noattended);
			
			}

		}
		for(int i=0;!cent &&i<MAX_PETS;i++){

			if(petarray[i]!=null && petarray[i].getStatus()==Status.WAITING && petarray[i].getPriority()==Priority.PRIORITY5){
			pos=i;
			cent=true;
			System.out.println("The next pet to be attended is: " + petarray[pos].getPetName()+ " with the owner identified with the id number: "+ petarray[pos].getOwner().getowneridNumber()+ " " + " named "+ petarray[pos].getOwner().getownerName());
			System.out.println("Pets waiting for attendance: " + noattended);
			
			}

		} 

	}


	/**
    * Description: This method helps the user to close the pet center<br>
    * <b> pre:</b> petarray can't have pets waiting to be attended or in consultation<br>
    * <b> pos:</b> all the pets in petarray are deleted<br>
    * @return exit boolean the var helps the program to know if the pet center can close, if exit==true the pet center can't close
    */

	public boolean closeCenter () {

		boolean exit=false;
		int maxtotalconsult=0;
		int positionmaxvet=0;


		for(int i=0 ; !false && i<MAX_PETS;i++){

			if(petarray[i]!=null && (petarray[i].getStatus()==Status.WAITING||petarray[i].getStatus()==Status.IN_CONSULTATION) ){

			exit=true;
			}




		}

		for (int i=0; i<MAX_VETS;i++){


			if(veterinaryarray[i]!=null && veterinaryarray[i].getNumberOfPatients()>maxtotalconsult){

				maxtotalconsult=veterinaryarray[i].getNumberOfPatients();
				positionmaxvet=i;
			}

		}


		if(!exit && totalPets!=0){
			System.out.println("Total pets attended per priority: " + "\n" +
			"PRIORITY1: " + totalPriority1 + "\n" + 
			"PRIORITY2: "+ totalPriority2 + "\n" +
			"PRIORITY3: "+ totalPriority3 + "\n" +
			"PRIORITY4: "+ totalPriority4 + "\n" +
			"PRIORITY5: "+ totalPriority5 + "\n");

			double percentage = (leftnoattended/totalPets)*100;
			System.out.println("Percentage of pets that left the center without being attended: "+ percentage + "%");

			System.out.println("The veterinary with the greatest amount of patients attended was: " + veterinaryarray[positionmaxvet].getName() + " "+ veterinaryarray[positionmaxvet].getlastName() + " with a total of " + veterinaryarray[positionmaxvet].getNumberOfPatients()+ ", CONGRATULATIONS!");

			for(int i=0; i<MAX_PETS;i++){ // DELETE ALL PETS
				if(petarray[i]!=null && petarray[i].getStatus()!=Status.WAITING){
					petarray[i]=null;
				}

			}

		}
					

		return exit;

	}

	/**
    * Description: This method helps the user to count how much consults are done by priority<br>
    * <b> pre:</b> petarray must have a pet in consult to start this method<br>
    * <b> pos:</b> totalpriority1++ or totalpriority2++ or totalpriority3++ or totalpriority4++ or totalpriority5++ <br>
    * @param aPos Priority
    */

	
	public void countPerconsult(Priority aPos){


		if (aPos==Priority.PRIORITY1){

			totalPriority1++;
		}
		if (aPos==Priority.PRIORITY2){

			totalPriority2++;
		}
		if (aPos==Priority.PRIORITY3){

			totalPriority3++;
		}
		if (aPos==Priority.PRIORITY4){

			totalPriority4++;
		}
		if (aPos==Priority.PRIORITY5){

			totalPriority5++;
		}

	}

	public double getNoAttended () {

		return noattended;
	}


	



}




