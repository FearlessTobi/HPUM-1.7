package snidgert.harrypottermod.woodwands;

import snidgert.harrypottermod.wands.WoodWandClass;

public class OakFwooperClass extends WoodWandClass {


	public boolean LightGood;
	public boolean DADA;

	public OakFwooperClass() {
		this.LightGood = true;
		this.DADA = true;
		this.setTextureName("harrypottermod:OakWand");
		this.setMaxStackSize(1);
		this.setMaxDamage(41);
	}

}
