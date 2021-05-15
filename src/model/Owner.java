package model;

public class Owner {
/**
* Description: this var stores the name of the owner
*/
	private String ownerName;
/**
* Description: this var stores the phone of the owner
*/
	private String ownerPhone;
/**
* Description: this var stores the adress of the owner
*/
	private String ownerAdress;
/**
* Description: this var stores the id of the owner
*/
	private double owneridNumber;
	


	// get

	public String getownerName () {

		return ownerName;
	}


	public double getowneridNumber () {

		return owneridNumber;
	}

		/**
   * Description: This is the constructor of the class Owner <br>
   * <b> pos:</b> The atributes will be initialized with a value<br>
   * @param ownerName String
   * @param ownerPhone String
   * @param ownerAdress String
   * @param owneridNumber double
   */

	public Owner (String ownerName, String ownerPhone, String ownerAdress, double owneridNumber) {

		this.ownerName=ownerName;
		this.ownerPhone=ownerPhone;
		this.ownerAdress=ownerAdress;
		this.owneridNumber=owneridNumber;


	}







}