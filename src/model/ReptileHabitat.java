package model;

public class ReptileHabitat extends Habitat {

	//Atributes
	private String material;
	//Relation
	private ReptileType reptileType;

	// get
	public String getmaterial (){
		return material;
	}

		/**
   * Description: This is the constructor of the class ReptileHabitat <br>
   * <b> pos:</b> The atributes will be initialized with a value<br>
   * @param habitatIdentificator String
   * @param length double
   * @param width double
   * @param usage Usage
   * @param material String
   * @param reptileType ReptileType
   */

	public ReptileHabitat (String habitatIdentificator,double length,double width,Usage usage,String material,ReptileType reptileType){
		super(habitatIdentificator,length,width,usage);
		this.material=material;
		this.reptileType=reptileType;

	}

	
}