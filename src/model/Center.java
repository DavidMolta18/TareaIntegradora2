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

/**
* Description: Matrix to save the animals
*/
	private Habitat [][]habitatMatrix;

/**
* Description: Constant to control the limits of the habitatMatrix
*/

	private final int MAXCOLCAT = 2;
/**
* Description: Constant to control the limits of the habitatMatrix
*/
	private final int MINCOLCAT= 0;
/**
* Description: Constant to control the limits of the habitatMatrix
*/
	private final int MAXROWCAT = 2;
/**
* Description: Constant to control the limits of the habitatMatrix
*/
	private final int MINROWCAT= 0;

/**
* Description: Constant to control the limits of the habitatMatrix
*/
	private final int MAXCOLDOG = 2;
/**
* Description: Constant to control the limits of the habitatMatrix
*/
	private final int MINCOLDOG= 0;
/**
* Description: Constant to control the limits of the habitatMatrix
*/
	private final int MAXROWDOG = 5;
/**
* Description: Constant to control the limits of the habitatMatrix
*/
	private final int MINROWDOG= 3;
/**
* Description: Constant to control the limits of the habitatMatrix
*/
	private final int MAXCOLREPTILE = 4;
/**
* Description: Constant to control the limits of the habitatMatrix
*/
	private final int MINCOLREPTILE= 3;
/**
* Description: Constant to control the limits of the habitatMatrix
*/
	private final int MAXROWREPTILE =1;
/**
* Description: Constant to control the limits of the habitatMatrix
*/
	private final int MINROWREPTILE= 0;
/**
* Description: Constant to control the limits of the habitatMatrix
*/
	private final int MAXCOLBUNNY = 4;
/**
* Description: Constant to control the limits of the habitatMatrix
*/
	private final int MINCOLBUNNY= 3;
/**
* Description: Constant to control the limits of the habitatMatrix
*/
	private final int MAXROWBUNNY =3;
/**
* Description: Constant to control the limits of the habitatMatrix
*/
	private final int MINROWBUNNY= 2;
/**
* Description: Constant to control the limits of the habitatMatrix
*/
	private final int MAXCOLBIRD = 4;
/**
* Description: Constant to control the limits of the habitatMatrix
*/
	private final int MINCOLBIRD= 3;
/**
* Description: Constant to control the limits of the habitatMatrix
*/
	private final int MAXROWBIRD =5;
/**
* Description: Constant to control the limits of the habitatMatrix
*/
	private final int MINROWBIRD= 4;
/**
* Description: Constant to control the limits of the habitatMatrix
*/
	private final double MAXHABITATS = 30;
/**
* Description: var to count the amount of habitats that are occupied by a dog
*/
	private double dogCount=0;
/**
* Description: var to count the amount of habitats that are occupied by a bunny
*/
	private double bunnyCount=0;
/**
* Description:var to count the amount of habitats that are occupied by a bird
*/
	private double birdCount=0;
/**
* Description: var to count the amount of habitats that are occupied by a reptile
*/
	private double reptileCount=0;
/**
* Description: var to count the amount of habitats that are occupied by a cat
*/
	private double catCount=0;
/**
* Description: Var to store the amount of the total pets that are healthy
*/
	private double healthyPet=0;
/**
* Description: Var to store the amount of the total pets that are sick
*/
	private double sickPet=0;

/**
* Description: var to store the position of the pet that will be hospitalized
*/
	private int hospiPos=0;




	// get



	// Constructor

	/**
   * Description: This is the constructor of the class center <br>
   * <b> pre:</b> User must enter a name in the menu to start the center<br>
   * <b> pos:</b> Initialize veterinaryarray,petarray,noattended,petNumber,veterinaryNumber,habitatMatrix and call all the methods to initialize the animal habitats  <br>

   */


	public Center () {
		veterinaryNumber=0;
		petNumber=0;

		veterinaryarray= new Veterinary [MAX_VETS];
		petarray= new Pet [MAX_PETS];
		noattended=0;
		// Initialization of the matrix habitat
		habitatMatrix= new Habitat [6][5];

		// Initialization of the habitats
		initializateDog();
		initializateBird();
		initializateReptile();
		initializateCat();
		initializateBunny();
	
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
			
					System.out.println("The pet exit the center without attention!");
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
	<b> pos: </b> The consult is now finished, vet status changed from IN CONSULT to FREE and pet status changed from IN CONSULTATION to HOSPITALIZATION or AUTHORIZED DEPARTURE // hospiPos gets a value
	* @param id String
	* @param petName String
	* @param option int 
	* @return inconsult boolean, this will help the program to know if the vet is in consult in order to continue with the normal logic 
	
	*/


	public boolean endConsult (String id, String petName,int option) {

		boolean exit=false;
		boolean inconsult=true;
		int position=0;
		String aId= id;
		String apetName=petName;
		int aOption=option;
		int hospitalizationday=0;
		

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
					hospiPos=a;

					System.out.println("Pets waiting for attendance: " + noattended);
					exit=true;

				}else {
					System.out.println("Select a correct option");
					exit=true;
					inconsult=true;
				}


			}else if (a==119){
				System.out.println("There's no pet /Or/ Incorrect name /Or/ The pet is not in consult /Or/ The vet is not attending this pet");
				inconsult=true; // CHECKE
			}


		}

		return inconsult;
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
		int novet=0;

		for (int i=0;i<MAX_VETS;i++){
			if(veterinaryarray[i]==null){
				novet++;
			}
		}


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


		if(!exit){
			System.out.println("Total pets attended per priority: " + "\n" +
			"PRIORITY1: " + totalPriority1 + "\n" + 
			"PRIORITY2: "+ totalPriority2 + "\n" +
			"PRIORITY3: "+ totalPriority3 + "\n" +
			"PRIORITY4: "+ totalPriority4 + "\n" +
			"PRIORITY5: "+ totalPriority5 + "\n");

			double percentage = (leftnoattended/totalPets)*100;
			System.out.println("Percentage of pets that left the center without being attended: "+ percentage + "%");

			if(totalPets!=0 && novet!=7){
				System.out.println("The veterinary with the greatest amount of patients attended was: " + veterinaryarray[positionmaxvet].getName() + " "+ veterinaryarray[positionmaxvet].getlastName() + " with a total of " + veterinaryarray[positionmaxvet].getNumberOfPatients()+ ", CONGRATULATIONS!");
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



	/**
    * Description: This call the method addNurseryPet to the habitatMatrix<br>
    * <b> pre:</b> endConsult needs to be called first<br>
    * <b> pos:</b>hospiPos will now contain the position of the pet that will store the animal for hospitalization<br>
    * @param days int, days that the pet will stay on the habitat
    * @return out , String that contains a message of the addNurseryPet indicating if the pet was succesfully added or not
    */

	public String hospitalizate(int days){
		String out="";
		out=addNurseryPet(petarray[hospiPos].getPetName(),petarray[hospiPos].getPetAge(),petarray[hospiPos].getSpecie(),petarray[hospiPos].getOwner(),days,2);
		return out;
	}


	// Initialization of the habitats

	/**
    * Description: This method will initialize the habitat were the dogs are going to be sent<br>
    * <b> pre:</b> Constructor class must be activated first<br>
    * <b> pos:</b> Dog habitat is now available to receive animals<br>
    */

	private void initializateDog (){
		int id=1;
		
		for(int row=MINROWDOG; row<=MAXROWDOG; row++){
			for(int col=MINCOLDOG; col<=MAXCOLDOG;col++){

				habitatMatrix[row][col]= new DogHabitat ("D"+id,5.0,3.0,Usage.EMPTY,3);
				id++;
			}
		}

	}

	/**
    * Description: This method will initialize the habitat were the birds are going to be sent<br>
    * <b> pre:</b> Constructor class must be activated first<br>
    * <b> pos:</b> Bird habitat is now available to receive animals<br>
    */

	private void initializateBird (){
		int id=1;
		
		for(int row=MINROWBIRD; row<=MAXROWBIRD; row++){
			for(int col=MINCOLBIRD; col<=MAXCOLBIRD;col++){

				habitatMatrix[row][col]= new BirdHabitat ("B"+id,6.5,5.3,Usage.EMPTY,5,8,CageType.LAND);
				id++;
			}
		}
		
	}

	/**
    * Description: This method will initialize the habitat were the reptiles are going to be sent<br>
    * <b> pre:</b> Constructor class must be activated first<br>
    * <b> pos:</b> Reptile habitat is now available to receive animals<br>
    */

	private void initializateReptile (){
		int id=1;
		
		for(int row=MINROWREPTILE; row<=MAXROWREPTILE; row++){
			for(int col=MINCOLREPTILE; col<=MAXCOLREPTILE;col++){

				habitatMatrix[row][col]= new ReptileHabitat ("R"+id,9,5,Usage.EMPTY,"METAL",ReptileType.AMPHIBIAN);
				id++;
			}
		}
		
	}

	/**
    * Description: This method will initialize the habitat were the cats are going to be sent<br>
    * <b> pre:</b> Constructor class must be activated first<br>
    * <b> pos:</b> Cat habitat is now available to receive animals<br>
    */

	private void initializateCat (){
		int id=1;
		
		for(int row=MINROWCAT; row<=MAXROWCAT; row++){
			for(int col=MINCOLCAT; col<=MAXCOLCAT;col++){

				habitatMatrix[row][col]= new CatHabitat("C"+id,5,3,Usage.EMPTY,8,90);
				id++;
			}
		}
		
	}

	/**
    * Description: This method will initialize the habitat were the bunnies are going to be sent<br>
    * <b> pre:</b> Constructor class must be activated first<br>
    * <b> pos:</b> Bunny habitat is now available to receive animals<br>
    */

	private void initializateBunny (){
		int id=1;
		
		for(int row=MINROWBUNNY; row<=MAXROWBUNNY; row++){
			for(int col=MINCOLBUNNY; col<=MAXCOLBUNNY;col++){
				habitatMatrix[row][col]= new BunnyHabitat ("BN"+id,5,8,Usage.EMPTY,"ORCHID",3);
				id++;
			}
		}
		
	}


	/**
    * Description: This method will add a pet to the habitatMatrix<br>
    * <b> pos:</b> depending of the Specie of the pet that is added, the counter of each type of pet will add ++ <br>
    * @param petName String
   	* @param petAge int
   	* @param petSpecie Specie
  	* @param owner Owner
   	* @param day int, days that the pet will be on the habitat
  	* @param tryy int, var to control if the pet is healthy or sick
  	* @return out, String that contains a message with an error or a succesfull message
    */
	public String addNurseryPet (String petName, int petAge, Specie petSpecie,Owner owner,int day,int tryy) {
		String out= "";
		int option=-1;
		boolean cat=false;
		boolean dog=false;
		boolean reptile=false;
		boolean bunny=false;
		boolean bird=false;
		int number=tryy;
		if (petSpecie==Specie.DOG){
			option=0;
			}else if (petSpecie==Specie.CAT){
			option=1;
			}else if(petSpecie==Specie.BUNNY){
			option=2;
			}else if(petSpecie==Specie.REPTILE){
			option=3;
			}else if(petSpecie==Specie.BIRD){
			option=4;
		}

		switch(option){

			case 1:

				for(int row=MINROWCAT;!cat && row<=MAXROWCAT; row++){
					for(int col=MINCOLCAT;!cat && col<=MAXCOLCAT;col++){

						if(habitatMatrix[row][col].getUsage()==Usage.EMPTY){
							Pet p= new Pet(petName,petAge,petSpecie,owner,day);
							habitatMatrix[row][col].setNurseryPet(p);
							if(number==1){
								habitatMatrix[row][col].setUsage(Usage.OCCUPIED_HEALTHY);
								healthyPet++;
							}else {habitatMatrix[row][col].setUsage(Usage.OCCUPIED_SICK);
							sickPet++;}
							
							out= "Your cat was added successfully" + ", the pet will be on the habitat with the identificator: " + habitatMatrix[row][col].getIdentificator();
							cat=true;
							catCount++;


						}else {out="There's no space to save your cat, sorry";}
					}
				}

			break;
			case 0:

				for(int row=MINROWDOG; !dog && row<=MAXROWDOG; row++){
					for(int col=MINCOLDOG;!dog && col<=MAXCOLDOG;col++){

						if(habitatMatrix[row][col].getUsage()==Usage.EMPTY){
							Pet p= new Pet(petName,petAge,petSpecie,owner,day);
							habitatMatrix[row][col].setNurseryPet(p);
							if(number==1){
								habitatMatrix[row][col].setUsage(Usage.OCCUPIED_HEALTHY);
								healthyPet++;
							}else {habitatMatrix[row][col].setUsage(Usage.OCCUPIED_SICK);
							sickPet++;}
							out="Your dog was added successfully" + ", the pet will be on the habitat with the identificator: " + habitatMatrix[row][col].getIdentificator();
							dog=true;
							dogCount++;
							
						}else{ out="There's no space to save your dog, sorry";}
						
					}
				}
			break;
			case 3:
				for(int row=MINROWREPTILE; !reptile && row<=MAXROWREPTILE; row++){
					for(int col=MINCOLREPTILE;!reptile && col<=MAXCOLREPTILE;col++){

						if(habitatMatrix[row][col].getUsage()==Usage.EMPTY){
							Pet p= new Pet(petName,petAge,petSpecie,owner,day);
							habitatMatrix[row][col].setNurseryPet(p);
							if(number==1){
								habitatMatrix[row][col].setUsage(Usage.OCCUPIED_HEALTHY);
								healthyPet++;
							}else {habitatMatrix[row][col].setUsage(Usage.OCCUPIED_SICK);
							sickPet++;}
							out="Your reptile was added successfully" + ", the pet will be on the habitat with the identificator: " + habitatMatrix[row][col].getIdentificator();
							reptile=true;
							reptileCount++;
							
						}else{ out="There's no space to save your reptile, sorry";}
						
					}
				}
			break;
			case 2:
				for(int row=MINROWBUNNY; !bunny && row<=MAXROWBUNNY; row++){
					for(int col=MINCOLBUNNY;!bunny && col<=MAXCOLBUNNY;col++){

						if(habitatMatrix[row][col].getUsage()==Usage.EMPTY){
							Pet p= new Pet(petName,petAge,petSpecie,owner,day);
							habitatMatrix[row][col].setNurseryPet(p);
							if(number==1){
								habitatMatrix[row][col].setUsage(Usage.OCCUPIED_HEALTHY);
								healthyPet++;
							}else {habitatMatrix[row][col].setUsage(Usage.OCCUPIED_SICK);
							sickPet++;}
							out="Your bunny was added successfully" + ", the pet will be on the habitat with the identificator: " + habitatMatrix[row][col].getIdentificator();
							bunny=true;
							bunnyCount++;
							
						}else {out="There's no space to save your bunny, sorry";}
						
					}
				}
			break;
			case 4:
				for(int row=MINROWBIRD; !bird && row<=MAXROWBIRD; row++){
					for(int col=MINCOLBIRD;!bird && col<=MAXCOLBIRD;col++){

						if(habitatMatrix[row][col].getUsage()==Usage.EMPTY){
							Pet p= new Pet(petName,petAge,petSpecie,owner,day);
							habitatMatrix[row][col].setNurseryPet(p);
							if(number==1){
								habitatMatrix[row][col].setUsage(Usage.OCCUPIED_HEALTHY);
								healthyPet++;
							}else {habitatMatrix[row][col].setUsage(Usage.OCCUPIED_SICK);
							sickPet++;}
							out="Your bird was added successfully" + ", the pet will be on the habitat with the identificator: " + habitatMatrix[row][col].getIdentificator();;
							bird=true;
							birdCount++;
							
						}else{ out="There's no space to save your bird, sorry";}
						
					}
				}
			break;

		}

		return out;
	}

	/**
    * Description: This method will give a message depending on the name of the pet that is received<br>
    * @param petName String
    * @return out, String that contains a message with the information of the pet
   */
	public String informationNurseryPet(String petName) {

		String out="";
		String habitat="";
		String usage="";
		for(int f=0;f<habitatMatrix.length;f++){
			for(int c=0;c<habitatMatrix[0].length;c++){
	
				if(habitatMatrix[f][c].getPet()!=null && habitatMatrix[f][c].getPet().getPetName().equals(petName)){

					if(habitatMatrix[f][c].getPet().getSpecie()==Specie.BUNNY){
						habitat= "Bunny zone";
					}else if (habitatMatrix[f][c].getPet().getSpecie()==Specie.CAT){
						habitat="Cat zone";
					}else if(habitatMatrix[f][c].getPet().getSpecie()==Specie.REPTILE){
						habitat="Reptile zone";
					}else if(habitatMatrix[f][c].getPet().getSpecie()==Specie.DOG){
						habitat="Dog zone";

					}else habitat="Bird zone";

					if(habitatMatrix[f][c].getUsage()==Usage.OCCUPIED_SICK){
						usage= "Sick";
					}else if(habitatMatrix[f][c].getUsage()==Usage.OCCUPIED_HEALTHY){
						usage= "Healthy";
						
					}


					out += "The pet is on the nursery. " + "\n"+ "Habitat: " + habitat + "\n" + "Habitat identificator: " + habitatMatrix[f][c].getIdentificator() +
					"\n" + "Status: " + usage;
					out += "\n" + "\n";

				}


			}
		}

		if(out.equals("")){
			out="There's no pet with that info";
		}

		return out;
	}
	/**
    * Description: This method will save on a String var the map of the nursery<br>
	* @return out, String that contains the map of the nursery
    */
	public String showNurseryMap() {
		String out="C is for Cat, D is for Dog, BN is for Bunny, B is for Bird and R is for Reptile" + "\n"+
		"E= EMPTY, S=Sick, H= Healthy ///" + "IDENTIFICATOR + STATE";


		for(int i=0;i<habitatMatrix.length;i++){
			out+="\n";
			for(int a=0;a<habitatMatrix[0].length;a++){
				if(habitatMatrix[i][a].getUsage()==Usage.EMPTY){
					out+= habitatMatrix[i][a].getIdentificator()+ "E";
					out+=" - ";
				}
				if(habitatMatrix[i][a].getUsage()==Usage.OCCUPIED_HEALTHY){
					out+= habitatMatrix[i][a].getIdentificator()+ "H";
					out+=" - ";
				}
				if(habitatMatrix[i][a].getUsage()==Usage.OCCUPIED_SICK){
					out+= habitatMatrix[i][a].getIdentificator()+ "S";
					out+=" - ";
				}


			}

		}




		return out;
	}
	/**
    * Description: This method will give the information of an habitat depending on its identificator<br>
    * @param identificator String, identificator of the habitat
    * @return information, String that contains all the information of the habitat specificated
    */
	public String habitatInformation(String identificator) {
		String information=null;
		String specie="";



			for(int row=MINROWBUNNY; row<=MAXROWBUNNY; row++){
				for(int col=MINCOLBUNNY; col<=MAXCOLBUNNY;col++){
					if(habitatMatrix[row][col].getIdentificator().equalsIgnoreCase(identificator) && habitatMatrix[row][col].getPet()==null){
							information="===BUNNY ZONE===" +"\n"+ "The habitat is EMPTY." + "\n"+ 
							"Identificator: " + habitatMatrix[row][col].getIdentificator() + "\n" +
							"Length: " + "5" + "\n" +
					 		"Width: "+"8" + "\n"+
					 		"Plant type: "+ "ORCHID" + "\n"+
					 		"Total plants: "+ "3";
					}
				}
			}

			for(int row=MINROWCAT; row<=MAXROWCAT; row++){
				for(int col=MINCOLCAT; col<=MAXCOLCAT;col++){
					if(habitatMatrix[row][col].getIdentificator().equalsIgnoreCase(identificator) && habitatMatrix[row][col].getPet()==null){
						information= "===CAT ZONE===" +"\n"+"The habitat is EMPTY." + "\n"+ 
						"Identificator: " + habitatMatrix[row][col].getIdentificator() + "\n" +
						"Length: " + "5 meters" + "\n" +
					 	"Width: "+"3 meters" + "\n"+
						 "Height: "+ "8 meters" + "\n" +
						 "Max weight: "+ "90 kg";
					}

				}
			}

			for(int row=MINROWBIRD; row<=MAXROWBIRD; row++){
				for(int col=MINCOLBIRD; col<=MAXCOLBIRD;col++){
					if(habitatMatrix[row][col].getIdentificator().equalsIgnoreCase(identificator) && habitatMatrix[row][col].getPet()==null){
						information= "===BIRD ZONE===" +"\n"+"The habitat is EMPTY." + "\n"+ 
							"Identificator: " + habitatMatrix[row][col].getIdentificator() + "\n" +
							"Length: " + "6.5 meters" + "\n" +
					 		"Width: "+"5.3 meters" + "\n"+
						 	"Height" + "5 meters" + "\n"+
						 	"Max birds: " + "8" + "\n" + 
						 	"Cage type: " + "LAND";
					}

				}
			}	
			for(int row=MINROWREPTILE; row<=MAXROWREPTILE; row++){
				for(int col=MINCOLREPTILE; col<=MAXCOLREPTILE;col++){
					if(habitatMatrix[row][col].getIdentificator().equalsIgnoreCase(identificator) && habitatMatrix[row][col].getPet()==null){
						information="===REPTILE ZONE===" + "\n"+"The habitat is EMPTY." + "\n"+ 
							"Identificator: " + habitatMatrix[row][col].getIdentificator() + "\n" +
							"Length: " + "9 meters" + "\n" +
					 		"Width: "+"5 meters" + "\n"+
						 	"Material" +"METAL" + "\n" +
						 	"Aquarium type: " + "AMPHIBIAN";
					}

				}
			}

			for(int row=MINROWDOG; row<=MAXROWDOG; row++){
				for(int col=MINCOLDOG; col<=MAXCOLDOG;col++){
					if(habitatMatrix[row][col].getIdentificator().equalsIgnoreCase(identificator) && habitatMatrix[row][col].getPet()==null){
						information= "===DOG ZONE===" + "\n" + "The habitat is EMPTY." + "\n"+ 
							"Identificator: " + habitatMatrix[row][col].getIdentificator() + "\n" +
							"Length: " + "5 meters" + "\n" +
					 		"Width: "+"3 meters" + "\n"+
					 		"Amount of toys: "+ "3";
					}

				}
			}


		

		for(int row=0; row<habitatMatrix.length; row++){
			for(int col=0; col<habitatMatrix[0].length;col++){

				if(habitatMatrix[row][col].getIdentificator().equalsIgnoreCase(identificator)){


					if (habitatMatrix[row][col].getUsage()==Usage.OCCUPIED_HEALTHY){
						if(habitatMatrix[row][col].getPet().getSpecie()==Specie.BUNNY){

							specie="BUNNY";
							information= "The habitat is occupied with a HEALTHY pet." + "\n"+ 
							"Identificator: " + habitatMatrix[row][col].getIdentificator() + "\n" +
							"Length: " + "5" + "\n" +
					 		"Width: "+"8" + "\n"+
					 		"Plant type: "+ "ORCHID" + "\n"+
					 		"Total plants: "+ "3";
					 		information+="\n"+"===Pet information===" + "\n" + 
					 		"Pet specie: " + specie + "\n" +
					 		"Pet name: " + habitatMatrix[row][col].getPet().getPetName() + "\n" +
					 		"Pet Age: "	+ habitatMatrix[row][col].getPet().getPetName() + "\n" +
					 		"Pet Specie: "	+ habitatMatrix[row][col].getPet().getPetName() + "\n" +
					 		"Days to be on the nursery: " + habitatMatrix[row][col].getPet().getDay() + "\n"+"Pet owner name: "+ habitatMatrix[row][col].getPet().getOwner().getownerName();

						}else if (habitatMatrix[row][col].getPet().getSpecie()==Specie.DOG){
							specie="DOG";
							information= "The habitat is occupied with a HEALTHY pet." + "\n"+ 
							"Identificator: " + habitatMatrix[row][col].getIdentificator() + "\n" +
							"Length: " + "5 meters" + "\n" +
					 		"Width: "+"3 meters" + "\n"+
					 		"Amount of toys: "+ "3";

					 		information+="\n"+"===Pet information===" + "\n" + 
					 		"Pet specie: " + specie + "\n" +
					 		"Pet name: " + habitatMatrix[row][col].getPet().getPetName() + "\n" +
					 		"Pet Age: "	+ habitatMatrix[row][col].getPet().getPetName() + "\n" +
					 		"Pet Specie: "	+ habitatMatrix[row][col].getPet().getPetName() + "\n" +
					 		"Days to be on the nursery: " + habitatMatrix[row][col].getPet().getDay() + "\n"+ "Pet owner name: "+ habitatMatrix[row][col].getPet().getOwner().getownerName();
					 		

						}else if(habitatMatrix[row][col].getPet().getSpecie()==Specie.CAT){
							specie="CAT";
							information= "The habitat is occupied with a HEALTHY pet." + "\n"+ 
							"Identificator: " + habitatMatrix[row][col].getIdentificator() + "\n" +
							"Length: " + "5 meters" + "\n" +
					 		"Width: "+"3 meters" + "\n"+
						 	"Height: "+ "8 meters" + "\n" +
						 	"Max weight: "+ "90 kg";
						 	information+="\n"+"===Pet information===" + "\n" + 
						 	"Pet specie: " + specie + "\n" +
						 	"Pet name: " + habitatMatrix[row][col].getPet().getPetName() + "\n" +
						 	"Pet Age: "	+ habitatMatrix[row][col].getPet().getPetName() + "\n" +
						 	"Pet Specie: "	+ habitatMatrix[row][col].getPet().getPetName() + "\n" +
						 	"Days to be on the nursery: " + habitatMatrix[row][col].getPet().getDay() + "\n"+"Pet owner name: "+ habitatMatrix[row][col].getPet().getOwner().getownerName();

						}else if(habitatMatrix[row][col].getPet().getSpecie()==Specie.REPTILE){
							specie="REPTILE";
							information= "The habitat is occupied with a HEALTHY pet." + "\n"+ 
							"Identificator: " + habitatMatrix[row][col].getIdentificator() + "\n" +
							"Length: " + "9 meters" + "\n" +
					 		"Width: "+"5 meters" + "\n"+
						 	"Material" +"METAL" + "\n" +
						 	"Aquarium type: " + "AMPHIBIAN";
						 	information+="\n"+"===Pet information===" + "\n" + 
						 	"Pet specie: " + specie + "\n" +
						 	"Pet name: " + habitatMatrix[row][col].getPet().getPetName() + "\n" +
						 	"Pet Age: "	+ habitatMatrix[row][col].getPet().getPetName() + "\n" +
						 	"Pet Specie: "	+ habitatMatrix[row][col].getPet().getPetName() + "\n" +
						 	"Days to be on the nursery: " + habitatMatrix[row][col].getPet().getDay() + "\n"+"Pet owner name: "+ habitatMatrix[row][col].getPet().getOwner().getownerName();


						}else if (habitatMatrix[row][col].getPet().getSpecie()==Specie.BIRD) {

							specie="BIRD";
							information= "The habitat is occupied with a HEALTHY pet." + "\n"+ 
							"Identificator: " + habitatMatrix[row][col].getIdentificator() + "\n" +
							"Length: " + "6.5 meters" + "\n" +
					 		"Width: "+"5.3 meters" + "\n"+
						 	"Height" + "5 meters" + "\n"+
						 	"Max birds: " + "8" + "\n" + 
						 	"Cage type: " + "LAND";
						 	information+= "\n"+ "===Pet information===" + "\n" + 
						 	"Pet specie: " + specie + "\n" +
						 	"Pet name: " + habitatMatrix[row][col].getPet().getPetName() + "\n" +
						 	"Pet Age: "	+ habitatMatrix[row][col].getPet().getPetName() + "\n" +
						 	"Pet Specie: "	+ habitatMatrix[row][col].getPet().getPetName() + "\n" +
						 	"Days to be on the nursery: " + habitatMatrix[row][col].getPet().getDay() + "\n"+"Pet owner name: "+ habitatMatrix[row][col].getPet().getOwner().getownerName();
						}
							

					}
					if (habitatMatrix[row][col].getUsage()==Usage.OCCUPIED_SICK){
						if(habitatMatrix[row][col].getPet().getSpecie()==Specie.BUNNY){
							specie="BUNNY";
							information= "The habitat is occupied with a SICK pet." + "\n"+ 
							"Identificator: " + habitatMatrix[row][col].getIdentificator() + "\n" +
							"Length: " + "5" + "\n" +
					 		"Width: "+"8" + "\n"+
					 		"Plant type: "+ "ORCHID" + "\n"+
					 		"Total plants: "+ "3";
					 		information+="\n"+"===Pet information===" + "\n" + 
					 		"Pet specie: " + specie + "\n" +
					 		"Pet name: " + habitatMatrix[row][col].getPet().getPetName() + "\n" +
					 		"Pet Age: "	+ habitatMatrix[row][col].getPet().getPetName() + "\n" +
					 		"Pet Specie: "	+ habitatMatrix[row][col].getPet().getPetName() + "\n" +
					 		"Days to be on the nursery: " + habitatMatrix[row][col].getPet().getDay() + "\n"+"Pet owner name: "+ habitatMatrix[row][col].getPet().getOwner().getownerName();
						}else if (habitatMatrix[row][col].getPet().getSpecie()==Specie.DOG){
							specie="DOG";
							information= "The habitat is occupied with a SICK pet." + "\n"+ 
							"Identificator: " + habitatMatrix[row][col].getIdentificator() + "\n" +
							"Length: " + "5 meters" + "\n" +
					 		"Width: "+"3 meters" + "\n"+
					 		"Amount of toys: "+ "3";

					 		information+="\n"+"===Pet information===" + "\n" + 
					 		"Pet specie: " + specie + "\n" +
					 		"Pet name: " + habitatMatrix[row][col].getPet().getPetName() + "\n" +
					 		"Pet Age: "	+ habitatMatrix[row][col].getPet().getPetName() + "\n" +
					 		"Pet Specie: "	+ habitatMatrix[row][col].getPet().getPetName() + "\n" +
					 		"Days to be on the nursery: " + habitatMatrix[row][col].getPet().getDay() + "\n"+ "Pet owner name: "+ habitatMatrix[row][col].getPet().getOwner().getownerName();
						}else if(habitatMatrix[row][col].getPet().getSpecie()==Specie.CAT){
							specie="CAT";
							information= "The habitat is occupied with a SICK pet." + "\n"+ 
							"Identificator: " + habitatMatrix[row][col].getIdentificator() + "\n" +
							"Length: " + "5 meters" + "\n" +
					 		"Width: "+"3 meters" + "\n"+
						 	"Height: "+ "8 meters" + "\n" +
						 	"Max weight: "+ "90 kg";
						 	information+="\n"+"===Pet information===" + "\n" + 
						 	"Pet specie: " + specie + "\n" +
						 	"Pet name: " + habitatMatrix[row][col].getPet().getPetName() + "\n" +
						 	"Pet Age: "	+ habitatMatrix[row][col].getPet().getPetName() + "\n" +
						 	"Pet Specie: "	+ habitatMatrix[row][col].getPet().getPetName() + "\n" +
						 	"Days to be on the nursery: " + habitatMatrix[row][col].getPet().getDay() + "\n"+"Pet owner name: "+ habitatMatrix[row][col].getPet().getOwner().getownerName();
						}else if(habitatMatrix[row][col].getPet().getSpecie()==Specie.REPTILE){
							specie="REPTILE";
							
							information= "The habitat is occupied with a SICK pet." + "\n"+ 
							"Identificator: " + habitatMatrix[row][col].getIdentificator() + "\n" +
							"Length: " + "9 meters" + "\n" +
					 		"Width: "+"5 meters" + "\n"+
						 	"Material" +"METAL" + "\n" +
						 	"Aquarium type: " + "AMPHIBIAN";
						 	information+="\n"+"===Pet information===" + "\n" + 
						 	"Pet specie: " + specie + "\n" +
						 	"Pet name: " + habitatMatrix[row][col].getPet().getPetName() + "\n" +
						 	"Pet Age: "	+ habitatMatrix[row][col].getPet().getPetName() + "\n" +
						 	"Pet Specie: "	+ habitatMatrix[row][col].getPet().getPetName() + "\n" +
						 	"Days to be on the nursery: " + habitatMatrix[row][col].getPet().getDay() + "\n"+"Pet owner name: "+ habitatMatrix[row][col].getPet().getOwner().getownerName();
						}else if(habitatMatrix[row][col].getPet().getSpecie()==Specie.BIRD){
							specie="BIRD";
							information= "The habitat is occupied with a SICK pet." + "\n"+ 
							"Identificator: " + habitatMatrix[row][col].getIdentificator() + "\n" +
							"Length: " + "6.5 meters" + "\n" +
					 		"Width: "+"5.3 meters" + "\n"+
						 	"Height" + "5 meters" + "\n"+
						 	"Max birds: " + "8" + "\n" + 
						 	"Cage type: " + "LAND";
						 	information+= "\n"+ "===Pet information===" + "\n" + 
						 	"Pet specie: " + specie + "\n" +
						 	"Pet name: " + habitatMatrix[row][col].getPet().getPetName() + "\n" +
						 	"Pet Age: "	+ habitatMatrix[row][col].getPet().getPetName() + "\n" +
						 	"Pet Specie: "	+ habitatMatrix[row][col].getPet().getPetName() + "\n" +
						 	"Days to be on the nursery: " + habitatMatrix[row][col].getPet().getDay() + "\n"+"Pet owner name: "+ habitatMatrix[row][col].getPet().getOwner().getownerName();
						 }

					}


				}



			}
		}
		if(information==null){
		information="There's no habitat with that identificator";
		}
		return information;
		
	}
	/**
    * Description: This method will give the statistics of the nursery<br>
    * @return statistics, Var that store all the statistsics of the nursery
    */
	public String nurseryStatistics() {
		String statistics="";
		double totalCount= birdCount+reptileCount+bunnyCount+dogCount+catCount;

		double percentage;

		statistics+= "===CAT==="+ "\n" +
		"Cat occupancy percentage: " + (catCount/9)*100 + " %" + "\n";

		statistics+="===DOG===" + "\n" +
		"Dog occupancy percentage: " + (dogCount/9)*100 + " %" + "\n";

		statistics+="===BUNNY===" + "\n" +
		"Bunny occupancy percentage: " + (bunnyCount/4)*100 + " %" + "\n";

		statistics+="===REPTILE===" + "\n" +
		"Reptile occupancy percentage: " + (reptileCount/4)*100 + " %" + "\n";

		statistics+="===BIRD===" + "\n" +
		"Bird occupancy percentage: " + (birdCount/4)*100 + " %"+ "\n" + "\n";

		// General ocupation
		statistics+="===GENERAL OCUPATIONS===" + "\n" +
		"General occupancy percentage: " + (totalCount/MAXHABITATS)*100 + " %" + "\n";

		// Healthy && Sick

		statistics+="===HEALTHY===" + "\n" +
		"Healthy occupancy percentage: " + (healthyPet/totalCount)*100 + " %" + "\n";
		statistics+="===SICK===" + "\n" +
		"Sick occupancy percentage: " + (sickPet/totalCount)*100 + " %" + "\n";



		return statistics;
	}








}





		
	



		

	
	
	
	
	








