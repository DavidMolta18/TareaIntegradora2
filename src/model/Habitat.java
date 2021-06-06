package model;

public abstract class Habitat {
	//Atributes
	private String habitatIdentificator;
	private double length;
	private double width;
	//Relation
	private Usage usage;
	private Pet nurseryPet;

	//get

	public Usage getUsage (){
		return usage;
	}

	public String getIdentificator (){
		return habitatIdentificator;
	}
	public Pet getPet(){
		return nurseryPet;
	}
	public double getLength (){
		return length;
	}
	public double getWidth (){
		return width;
	}

	// Set
	public void setNurseryPet (Pet nurseryPet){
		this.nurseryPet=nurseryPet;
	}

	public void setUsage (Usage usage){
		this.usage=usage;
	}



	//Constructor

	public Habitat (String habitatIdentificator,double length,double width,Usage usage){
		this.habitatIdentificator=habitatIdentificator;
		this.length=length;
		this.width=width;
		this.usage=usage;
	}


	
}