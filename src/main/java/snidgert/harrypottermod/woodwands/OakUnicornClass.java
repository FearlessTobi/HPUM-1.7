package snidgert.harrypottermod.woodwands;

import snidgert.harrypottermod.wands.WoodWandClass;

public class OakUnicornClass extends WoodWandClass {


	public boolean LightGood;
	public boolean DADA;

	public OakUnicornClass() {
		this.LightGood = true;
		this.DADA = true;
		this.setTextureName("harrypottermod:OakWand");
		this.setMaxStackSize(1);
		this.setMaxDamage(41);
	}

}
