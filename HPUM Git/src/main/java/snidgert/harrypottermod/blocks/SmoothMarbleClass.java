package snidgert.harrypottermod.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;

public class SmoothMarbleClass extends Block
{
    public SmoothMarbleClass(final Material p_i45394_1_) {
        super(p_i45394_1_);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(3.0f);
        this.setResistance(4.0f);
        this.setBlockTextureName("harrypottermod:marble_smooth");
    }
}
