package snidgert.harrypottermod.woodwands;

import snidgert.harrypottermod.wands.WoodWandClass;

public class BirchVeelaClass extends WoodWandClass {


	public boolean LightGood;
	public boolean DADA;

	public BirchVeelaClass() {
		this.LightGood = true;
		this.DADA = true;
		this.setTextureName("harrypottermod:BirchWand");
		this.setMaxStackSize(1);
		this.setMaxDamage(41);
	}

}
