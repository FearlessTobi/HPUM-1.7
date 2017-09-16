package snidgert.harrypottermod.woodwands;

import snidgert.harrypottermod.wands.WoodWandClass;

public class BirchDemiguiseClass extends WoodWandClass {


	public boolean LightGood;
	public boolean DADA;

	public BirchDemiguiseClass() {
		this.LightGood = true;
		this.DADA = true;
		this.setTextureName("harrypottermod:BirchWand");
		this.setMaxStackSize(1);
		this.setMaxDamage(41);
	}

}
