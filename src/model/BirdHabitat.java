package model;

public class BirdHabitat extends Habitat{

	//Relation
	private CageType cageType;
	//Atributes
	private double height;
	private int maxBirds;

	public int getmaxBirds (){
		return maxBirds;
	}

	public double getHeight (){
		return height;
	}
	/**
   * Description: This is the constructor of the class BirdHabitat <br>
   * <b> pos:</b> The atributes will be initialized with a value<br>
   * @param habitatIdentificator String
   * @param length double
   * @param width double
   * @param usage Usage
   * @param height double
   * @param maxBirds int
   * @param cageTyoe CageTyoe
   */

	public BirdHabitat (String habitatIdentificator,double length,double width,Usage usage,double height,int maxBirds,CageType cageType){
		super(habitatIdentificator,length,width,usage);
		this.height=height;
		this.maxBirds=maxBirds;
		this.cageType=cageType;
	}


	
}