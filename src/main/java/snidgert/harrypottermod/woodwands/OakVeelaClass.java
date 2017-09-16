package snidgert.harrypottermod.woodwands;

import snidgert.harrypottermod.wands.WoodWandClass;

public class OakVeelaClass extends WoodWandClass {


	public boolean LightGood;
	public boolean DADA;

	public OakVeelaClass() {
		this.LightGood = true;
		this.DADA = true;
		this.setTextureName("harrypottermod:OakWand");
		this.setMaxStackSize(1);
		this.setMaxDamage(41);
	}

}
