package snidgert.harrypottermod.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;

public class BlackMarbleClass extends Block
{
    public BlackMarbleClass(final Material p_i45394_1_) {
        super(p_i45394_1_);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(3.0f);
        this.setResistance(4.0f);
        this.setBlockTextureName("harrypottermod:blackmarble");
    }
}
