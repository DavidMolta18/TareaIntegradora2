package ui;

import java.util.Scanner;
import model.Center;
import model.Owner;
import model.Specie;
import model.Priority;
import model.Status;
import model.VetStatus;

public class Main{

/**
* Description: Var to control the race of the animal
*/

private String race;



/**
* Description: Scanner to read options in the program
*/

private Scanner reader;

/**
* Description: Relation with the class Center that allows to use its methods
*/

private Center petCenter; 

	/**
   * Description: Creates an object of Scanner <br>
   * <b> pre:</b> Scanner must be declarated<br>
   * <b> pos:</b> object reader is created<br>

   */
public Main () {
	petCenter=new Center();
	reader= new Scanner (System.in);
}

	/**
   * Description: Creates an object of class main <br>
   * <b> pre:</b> Start the program<br>
   * <b> pos:</b> object op is created<br>
   * @param args String array

   */

public static void main (String[]args){

	Main op=new Main();
	op.showMenu();
}


/**
   * Description: This method helps the user to register a pet center <br>
   * <b> pre:</b> Start the program<br>
   * <b> pos:</b> The method registerPetCenter and showMenu2 are now active<br>

   */

public void showMenu (){

	int option=0;
	

	System.out.println("Select an option please: \n1:Enter the veterinary center menu \n0: Exit");
		
	option= reader.nextInt();
	reader.nextLine();

	switch (option){

	case 1:
	showInitialMenu();
	break;
	case 0:
	System.out.println("Have a good day");
	break;


		}
}

/**
   * Description: This method shows the entire functional options of the program <br>
   * <b> pre:</b> showMenu has to be started first and option!=0<br>
   * <b> pos:</b> A method is called depending on the option the user selects<br>
   */

public void showMenu2 (){

	int option=0;

	do {

		System.out.println("===Welcome to the veterinary center==="+ "\n"+ "Select an option please, \n1: Register a veterinary  \n2: Delete a veterinary \n=====================\n3: Register a pet \n4: Remove a pet \n===================== \n5: Start a consult \n6: End a consult \n7: See how many pets are waiting \n8: Statistics \n0:Go back");

		option= reader.nextInt();
		reader.nextLine();


		switch (option){

			case 1:
			registerVeterinary();
			break;
			case 2:
			String verr= idVeterinarydel();
			petCenter.deleteVeterinary(verr);
			break;
			case 3:
			registerPet();
			break;
			case 4:
			idPetDel();
			break;
			case 5:
			startConsult();
			break;
			case 6:
			endConsult();
			break;
			case 7:
			System.out.println("There are: "+ petCenter.getNoAttended() + " pets waiting to be attended");
			break;
			case 8:
			if (petCenter.closeCenter()==true){
				System.out.println("The center has some pets registered that are WAITING or are IN CONSULT right now");
			}
			break;
			case 0:
			showInitialMenu();
			break;


		} 


	} while (option!=0);
}

/**
   * Description: This method allows the user to register a new veterinary <br>
   * <b> pre:</b> showMenu2 has to be initialized and option=1<br>
   * <b> pos:</b> Recolects all data and calls the addVeterinary in the class Center to create a veterinary<br>
   */

public void registerVeterinary () {


	System.out.println("Enter the name of the veterinary, please:");

	String name= reader.nextLine();

	System.out.println("Enter the last name of the veterinary, please:");

	String lastName= reader.nextLine();

	System.out.println("Enter the id number of the veterinary, please:");

	String  idNumber= reader.nextLine();
	

	System.out.println("Enter the unique identification of the veterinary, please:");

	String  uniqueVet= reader.nextLine();
	


	petCenter.addVeterinary(name,lastName,idNumber,uniqueVet,VetStatus.FREE);

	
}


/**
   * Description: Method to ask the id of the veterinary that the user wants to delete<br>
   * <b> pre:</b> showMenu2 has to be initialized and option=2<br>
   * <b> pos:</b> Recolects all data and returns the id of the veterinary<br>
   * @return idNumber String Contains the id of the veterinary that the user wants to delete
   */


public String  idVeterinarydel () {

	System.out.println("Please enter the id number of the veterinary you want to delete");
		String  idNumber = reader.nextLine();
		

		return idNumber;
}




/**
   * Description: Method to ask the name of the pet center<br>
   * <b> pre:</b> showMenu2 has to be initialized and option=3<br>
   * <b> pos:</b> Recolects all the information of the pet and his owner, then calls the method in the class Center with all the params<br>

   */


public void registerPet(){
	

	System.out.println("Hi!");


	System.out.println("Enter the name of the pet");
	String fullname= reader.nextLine();

	System.out.println("Enter the age of the pet");
	int age= reader.nextInt();
	reader.nextLine();

	System.out.println("Enter the specie of the pet \n"
		+"1. Cat \n"
		+"2. Dog \n" +
		"3. Reptile \n"+
		"4. Bunny \n"+
		"5. Bird");
	int type= reader.nextInt();
	reader.nextLine();

	if (type==1 || type==2) {
		System.out.println("Enter the race of the pet");
		race= reader.nextLine();
	}

	
	System.out.println("Enter the symptoms of the pet");
	String symptoms= reader.nextLine();

	System.out.println("Enter the priority of your consult \n"
		+"1. Priority 1 \n"
		+"2. Priority 2 \n" +
		"3. Priority 3 \n"+
		"4. Priority 4 \n"+
		"5. Priority 5");

	int priority = reader.nextInt();
	reader.nextLine();




	System.out.println("Enter the full name of the owner :");
	String ownerName= reader.nextLine();



	System.out.println("Enter the phone of the owner :");
	String ownerPhone= reader.nextLine();

	System.out.println("Enter the adress of the owner :");
	String ownerAdress= reader.nextLine();

	System.out.println("Enter the id number of the owner ");
	double owneridNumber= reader.nextDouble();
	reader.nextLine();

	Owner owner = new Owner(ownerName,ownerPhone,ownerAdress,owneridNumber);

	
	
	switch (type) {

		case 1:
		switch (priority){
			case 1:
			petCenter.addPet(fullname,age,race,Specie.CAT,symptoms,owner,Status.WAITING,Priority.PRIORITY1);
			break;
			case 2:
			petCenter.addPet(fullname,age,race,Specie.CAT,symptoms,owner,Status.WAITING,Priority.PRIORITY2);
			break;
			case 3:
			petCenter.addPet(fullname,age,race,Specie.CAT,symptoms,owner,Status.WAITING,Priority.PRIORITY3);
			break;
			case 4:
			petCenter.addPet(fullname,age,race,Specie.CAT,symptoms,owner,Status.WAITING,Priority.PRIORITY4);
			break;
			case 5:
			petCenter.addPet(fullname,age,race,Specie.CAT,symptoms,owner,Status.WAITING,Priority.PRIORITY5);
			break;
			default:
			System.out.println("Enter valid information");
			break;
		}

		break;
		case 2:
		switch (priority){
			case 1:
			petCenter.addPet(fullname,age,race,Specie.DOG,symptoms,owner,Status.WAITING,Priority.PRIORITY1);
			break;
			case 2:
			petCenter.addPet(fullname,age,race,Specie.DOG,symptoms,owner,Status.WAITING,Priority.PRIORITY2);
			break;
			case 3:
			petCenter.addPet(fullname,age,race,Specie.DOG,symptoms,owner,Status.WAITING,Priority.PRIORITY3);
			break;
			case 4:
			petCenter.addPet(fullname,age,race,Specie.DOG,symptoms,owner,Status.WAITING,Priority.PRIORITY4);
			break;
			case 5:
			petCenter.addPet(fullname,age,race,Specie.DOG,symptoms,owner,Status.WAITING,Priority.PRIORITY5);
			break;
			default:
			System.out.println("Enter valid information");
			break;
		}
		break;
		case 3:
		switch (priority){
			case 1:
			petCenter.addPet(fullname,age,Specie.REPTILE,symptoms,owner,Status.WAITING,Priority.PRIORITY1);
			break;
			case 2:
			petCenter.addPet(fullname,age,Specie.REPTILE,symptoms,owner,Status.WAITING,Priority.PRIORITY2);
			break;
			case 3:
			petCenter.addPet(fullname,age,Specie.REPTILE,symptoms,owner,Status.WAITING,Priority.PRIORITY3);
			break;
			case 4:
			petCenter.addPet(fullname,age,Specie.REPTILE,symptoms,owner,Status.WAITING,Priority.PRIORITY4);
			break;
			case 5:
			petCenter.addPet(fullname,age,Specie.REPTILE,symptoms,owner,Status.WAITING,Priority.PRIORITY5);
			break;
			default:
			System.out.println("Enter valid information");
			break;
		}

		break;
		case 4:
		switch (priority){
			case 1:
			petCenter.addPet(fullname,age,Specie.BUNNY,symptoms,owner,Status.WAITING,Priority.PRIORITY1);
			break;
			case 2:
			petCenter.addPet(fullname,age,Specie.BUNNY,symptoms,owner,Status.WAITING,Priority.PRIORITY2);
			break;
			case 3:
			petCenter.addPet(fullname,age,Specie.BUNNY,symptoms,owner,Status.WAITING,Priority.PRIORITY3);
			break;
			case 4:
			petCenter.addPet(fullname,age,Specie.BUNNY,symptoms,owner,Status.WAITING,Priority.PRIORITY4);
			break;
			case 5:
			petCenter.addPet(fullname,age,Specie.BUNNY,symptoms,owner,Status.WAITING,Priority.PRIORITY5);
			break;
			default:
			System.out.println("Enter valid information");
			break;
		}
		break;
		case 5:
		switch (priority){
			case 1:
			petCenter.addPet(fullname,age,Specie.BIRD,symptoms,owner,Status.WAITING,Priority.PRIORITY1);
			break;
			case 2:
			petCenter.addPet(fullname,age,Specie.BIRD,symptoms,owner,Status.WAITING,Priority.PRIORITY2);
			break;
			case 3:
			petCenter.addPet(fullname,age,Specie.BIRD,symptoms,owner,Status.WAITING,Priority.PRIORITY3);
			break;
			case 4:
			petCenter.addPet(fullname,age,Specie.BIRD,symptoms,owner,Status.WAITING,Priority.PRIORITY4);
			break;
			case 5:
			petCenter.addPet(fullname,age,Specie.BIRD,symptoms,owner,Status.WAITING,Priority.PRIORITY5);
			break;
			default:
			System.out.println("Enter valid information");
			break;
		}
		break;
		default:
			System.out.println("Enter valid information");
			break;

	}
}

/**
   * Description: Method to ask the id of the owner and the name of the pet that the user wants to delete<br>
   * <b> pre:</b> showMenu2 has to be initialized and option=4<br>
   * <b> pos:</b> Recolects all data and calls the method deletePet in the class Center with the params<br>
   */


public void idPetDel(){

	System.out.print("Enter the name of the pet you want to delete please: ");
	String petName= reader.nextLine();
	System.out.print("Enter the id number of the owner please: ");
	double ownerid= reader.nextDouble();

	petCenter.deletePet(petName,ownerid);
}

/**
   * Description: Method to ask the id of the veterinarian that that will treat the patient<br>
   * <b> pre:</b> showMenu2 has to be initialized and option=5<br>
   * <b> pos:</b> Recolects all data and calls the method startConsult in the class Center with the params<br>
   */

public void startConsult () {
	System.out.println("Enter the ID of the veterinarian who will treat the patient");
	String id= reader.nextLine();
	petCenter.startConsult(id);
}

/**
   * Description: Method to ask the id of the vet , the name of the pet and the new status in order to finish the consult<br>
   * <b> pre:</b> showMenu2 has to be initialized and option=6<br>
   * <b> pos:</b> Recolects all data and calls the method endConsultt in the class Center with the params<br>
   */

public void endConsult (){
	int selection=0;
	System.out.println("Enter the ID of the veterinarian to finish the consult");
	String id= reader.nextLine();
	System.out.println("Enter the name of the pet that you want to end the consult");
	String petName= reader.nextLine();
	System.out.println("Select the new pet status please: " + "\n"+
			"1. Authorizhed departure" + "\n"+
			"2. Hospitalization" );
	int option=reader.nextInt();

	switch (option){
		case 1:
		petCenter.endConsult(id,petName,option);
		break;
		case 2:
		if(!(petCenter.endConsult(id,petName,option))){
			sendHospitalization();
		}
		
		break;
	}


	

}
/**
   * Description: Method to show the initial menu, the user will select to go to nursery or emergencies<br>
   * <b> pre:</b> showMenu has to be initialized and option=1<br>
   * <b> pos:</b> Recolects all data and calls the method that was selected<br>
   */

public void showInitialMenu(){
	int op = 0;
	System.out.println("===Welcome to the veterinary center===" + "\n" + 
		"Select an option, please: " + "\n" +
		"1. Veterinary emergencies"+ "\n"+
		"2. Animal nursery"+ "\n"+
		"0. Close the center");
	op= reader.nextInt();

	switch (op){

		case 1:
		showMenu2();
		break;
		case 2:
		nurseryMenu();
		break;
		case 0:
		System.out.println("Bye!");
		break;
		default:
		System.out.println("Incorrect option");
		break;
	}
}
/**
   * Description: Method to show the options for the pets nursery<br>
   * <b> pre:</b> showInitialMenu has to be initialized and option==2<br>
   * <b> pos:Calls the method according to the option that the user selected</b> <br>
   */
public void nurseryMenu (){


	int option=0;

	do {
		System.out.println("Welcome to the nursery" + "\n" +
		"Select an option: " + "\n" +
		"1. Register a pet" + "\n" +
		"2. Information of your pet" + "\n" +
		"3. Show the nursery map" + "\n" +
		"4. Information of an habitat" + "\n" +
		"5. Statistics"+ "\n"+
		"0. Go back");
		option=reader.nextInt();
		reader.nextLine();
		switch (option){

		case 1:
		registerNurseryPet();
		break;
		case 2:
		informationNurseryPet();
		break;
		case 3:
		showNurseryMap();
		break;
		case 4:
		habitatInformation();
		break;
		case 5:
		nurseryStatistics();
		break;
		case 0:
		showInitialMenu();
		break;
		default:
		System.out.println("Wrong option");
		break;


		}

	}while (option!=0);


}
/**
   * Description: Method to add a pet to the nursery<br>
   * <b> pre:</b> nurseryMenu must me initialized and option==1<br>
   * <b> pos: All data recolected in order to add a pet, then call a method in the class Center to create it</b> <br>
   */

public void registerNurseryPet() {
	String out ="";

	System.out.println("Enter the name of your pet:");
	String pName = reader.nextLine();
	System.out.println("Enter the age of your pet:");
	int pAge= reader.nextInt();
	reader.nextLine();
	
	System.out.println("Select your pet specie, please: "+ "\n" +
		"1. DOG"+ "\n" +
		"2. CAT"+ "\n" +
		"3. BUNNY"+ "\n" +
		"4. REPTILE"+ "\n" +
		"5. BIRD");
	int pType= reader.nextInt();
	reader.nextLine();
	System.out.println("Now, enter the information of the owner ");
	System.out.println("Enter the name of the owner:");
	String oName= reader.nextLine();
	System.out.println("Enter the phone of the owner:");
	String oPhone= reader.nextLine();
	
	System.out.println("Enter the adress of the owner:");
	String oAdress= reader.nextLine();
	
	System.out.println("Enter the owner id:");
	double oId= reader.nextDouble();
	reader.nextLine();
	
	System.out.println("Enter the number of days your pet will stay on nursery:");
	int day= reader.nextInt();
	reader.nextLine();

	Owner ow = new Owner (oName,oPhone,oAdress,oId);
	switch (pType){
		case 1:
		out= petCenter.addNurseryPet(pName,pAge,Specie.DOG,ow,day,1);
		System.out.println(out);
		break;
		case 2:
		out= petCenter.addNurseryPet(pName,pAge,Specie.CAT,ow,day,1);
		System.out.println(out);
		break;
		case 3:
		out= petCenter.addNurseryPet(pName,pAge,Specie.BUNNY,ow,day,1);
		System.out.println(out);
		break;
		case 4:
		out= petCenter.addNurseryPet(pName,pAge,Specie.REPTILE,ow,day,1);
		System.out.println(out);
		break;
		case 5:
		out= petCenter.addNurseryPet(pName,pAge,Specie.BIRD,ow,day,1);
		System.out.println(out);
		break;


	}
}
/**
   * Description: Method that ask the name of the pet that will be searched on the habitats, then print the information<br>
   * <b> pre:</b> nurseryMenu must me initialized and option==2<br>
   * <b> pos: All data recolected in order to search for a pet, then call the method on the class Center to do the logic</b> <br>
   */

public void informationNurseryPet() {

	System.out.println("Please enter the name of the pet to search: ");
	String petName = reader.nextLine();
	System.out.println(petCenter.informationNurseryPet(petName));
}
/**
   * Description: Method to show the map of the nursery<br>
   * <b> pre:</b> nurseryMenu must me initialized and option==3<br>
   * <b> pos: The method showNurseryMap on class center is called</b> <br>
   */


public void showNurseryMap() {

	System.out.println(petCenter.showNurseryMap());
}
/**
   * Description: Method to print the information of an habitat <br>
   * <b> pre:</b> nurseryMenu must me initialized and option==4<br>
   * <b> pos: method habitatInformation on the class Center is called with the information that the user recolected about the habitat that is going to be printed</b> <br>
   */


public void habitatInformation() {
	System.out.println("Enter the habitat indentificator: ");
	String iden = reader.nextLine();

	System.out.println(petCenter.habitatInformation(iden));
}
/**
   * Description: Method that prints all the statistics of the nursery center<br>
   * <b> pre:</b> nurseryMenu must me initialized and option==5<br>
   * <b> pos:The method nurseryStatistics is called on the class Center to do all the logic</b> <br>
   */

public void nurseryStatistics() {

	System.out.println(petCenter.nurseryStatistics());
}
/**
   * Description: Method that ask the name of the pet, and the owner id number in order to search for a pet, if the pet is found and is Status hospilatization then the pet will be hospitalizated<br>
   * <b> pre:</b> showMenu2 must me initialized and option==9<br>
   * <b> pos: All data recolected in order to search for a pet, then call the method on the class Center to do the logic</b> <br>
   */

public void sendHospitalization(){

	System.out.println("Enter the days you want to hospitalizate the pet: ");
	int days = reader.nextInt();
	System.out.println(petCenter.hospitalizate(days));

}


}














