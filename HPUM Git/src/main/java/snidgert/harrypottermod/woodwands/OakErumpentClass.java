package snidgert.harrypottermod.woodwands;

import snidgert.harrypottermod.wands.WoodWandClass;

public class OakErumpentClass extends WoodWandClass {


	public boolean Trans;
	public boolean DADA;

	public OakErumpentClass() {
		this.Trans = true;
		this.DADA = true;
		this.setTextureName("harrypottermod:OakWand");
		this.setMaxStackSize(1);
		this.setMaxDamage(41);
	}

}
