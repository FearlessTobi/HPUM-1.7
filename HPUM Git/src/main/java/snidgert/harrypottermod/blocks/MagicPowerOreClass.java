package snidgert.harrypottermod.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.item.*;
import snidgert.harrypottermod.*;

public class MagicPowerOreClass extends Block
{
    public MagicPowerOreClass(final Material p_i45394_1_) {
        super(p_i45394_1_);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(7.0f);
        this.setResistance(5.0f);
        this.setBlockTextureName("harrypottermod:MagicPowerOre");
    }
    
    @Override
	public Item getItemDropped(final int par1, final Random par2Random, final int par3) {
        return MainClass.MagicPower;
    }
}
