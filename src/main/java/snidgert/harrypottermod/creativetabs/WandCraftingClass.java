package snidgert.harrypottermod.creativetabs;

import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import snidgert.harrypottermod.*;

public class WandCraftingClass extends CreativeTabs
{
    public WandCraftingClass(final int par1, final String par2Str) {
        super(par1, par2Str);
    }
    
    @Override
	public Item getTabIconItem() {
        return Item.getItemFromBlock(MainClass.WandCrafterIdle);
    }
}
