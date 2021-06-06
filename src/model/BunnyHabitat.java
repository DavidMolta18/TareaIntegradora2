package model;

public class BunnyHabitat extends Habitat {

	//Atribute
	private String plantType;
	private int plantNumber;
	// get 
	public String getplantType(){
		return plantType;
		
	}
	public int plantNumber (){
		return plantNumber;
	}
	/**
   * Description: This is the constructor of the class BunnyHabitat <br>
   * <b> pos:</b> The atributes will be initialized with a value<br>
   * @param habitatIdentificator String
   * @param length double
   * @param width double
   * @param usage Usage
   * @param plantType String
   * @param plantNumber int
   */

	public BunnyHabitat (String habitatIdentificator,double length,double width,Usage usage,String plantType,int plantNumber){
		super(habitatIdentificator,length,width,usage);
		this.plantType=plantType;
		this.plantNumber=plantNumber;
	}



	
}