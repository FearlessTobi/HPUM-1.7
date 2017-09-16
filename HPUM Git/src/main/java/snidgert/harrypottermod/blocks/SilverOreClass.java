package snidgert.harrypottermod.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import snidgert.harrypottermod.MainClass;

public class SilverOreClass extends Block
{
	public SilverOreClass(final Material p_i45394_1_) {
		super(p_i45394_1_);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(5.0f);
		this.setResistance(4.0f);
		this.setBlockTextureName("harrypottermod:SilverOre");
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return MainClass.SilverIngot;
	}

}
