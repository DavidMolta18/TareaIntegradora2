package model;

public class CatHabitat extends Habitat{

	//Atributes
	private double height;
	private double maxWeight;

	//get
	public double getHeight (){
		return height;
	}
	public double getWeight (){
		return maxWeight;
	}
	//Constructor

		/**
   * Description: This is the constructor of the class CatHabitat <br>
   * <b> pos:</b> The atributes will be initialized with a value<br>
   * @param habitatIdentificator String
   * @param length double
   * @param width double
   * @param usage Usage
   * @param height double
   * @param maxWeight double
   */

	public CatHabitat (String habitatIdentificator,double length,double width,Usage usage,double height,double maxWeight){

		super(habitatIdentificator,length,width,usage);
		this.height=height;
		this.maxWeight=maxWeight;


	}



	
}