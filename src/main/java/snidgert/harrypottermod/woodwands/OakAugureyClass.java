package snidgert.harrypottermod.woodwands;

import snidgert.harrypottermod.wands.WoodWandClass;

public class OakAugureyClass extends WoodWandClass {


	public boolean Trans;
	public boolean DADA;

	public OakAugureyClass() {
		this.Trans = true;
		this.DADA = true;
		this.setTextureName("harrypottermod:OakWand");
		this.setMaxStackSize(1);
		this.setMaxDamage(41);
	}

}
