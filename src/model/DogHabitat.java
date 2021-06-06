package model;

public class DogHabitat extends Habitat {

	//Atributes
	private int toyNumber;
	// get
	public int gettoyNumber (){
		return toyNumber;
		
	}
	/**
   * Description: This is the constructor of the class DogHabitat <br>
   * <b> pos:</b> The atributes will be initialized with a value<br>
   * @param habitatIdentificator String
   * @param length double
   * @param width double
   * @param usage Usage
   * @param toyNumber int
   */

	public DogHabitat (String habitatIdentificator,double length,double width,Usage usage,int toyNumber){
		super(habitatIdentificator,length,width,usage);
		this.toyNumber=toyNumber;
	}





	
}