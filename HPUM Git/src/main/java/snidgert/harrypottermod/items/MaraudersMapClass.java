package snidgert.harrypottermod.items;

import net.minecraft.item.*;
import net.minecraft.creativetab.*;

public class MaraudersMapClass extends ItemMap
{
    public MaraudersMapClass() {
        this.setCreativeTab(CreativeTabs.tabCombat);
        this.setTextureName("harrypottermod:MM");
        this.setMaxStackSize(1);
    }
}
