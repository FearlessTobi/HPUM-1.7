package snidgert.harrypottermod.blocks;

import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.world.*;
import cpw.mods.fml.relauncher.*;

public class MarblePillarClass extends Block
{
    private IIcon iconTop;
    
    public MarblePillarClass(final Material p_i45394_1_) {
        super(p_i45394_1_);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(3.0f);
        this.setResistance(4.0f);
    }
    
    @Override
	public void registerBlockIcons(final IIconRegister reg) {
        super.blockIcon = reg.registerIcon("harrypottermod:marble_smooth_pillar");
        this.iconTop = reg.registerIcon("harrypottermod:marble_smooth_pillar_top");
    }
    
    @Override
	public int getRenderType() {
        return 31;
    }
    
    @Override
	public int onBlockPlaced(final World p_149660_1_, final int p_149660_2_, final int p_149660_3_, final int p_149660_4_, final int p_149660_5_, final float p_149660_6_, final float p_149660_7_, final float p_149660_8_, final int p_149660_9_) {
        final int j1 = p_149660_9_ & 0x3;
        byte b0 = 0;
        switch (p_149660_5_) {
            case 0:
            case 1: {
                b0 = 0;
                break;
            }
            case 2:
            case 3: {
                b0 = 8;
                break;
            }
            case 4:
            case 5: {
                b0 = 4;
                break;
            }
        }
        return j1 | b0;
    }
    
    @Override
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(final int p_149691_1_, final int p_149691_2_) {
        final int k = p_149691_2_ & 0xC;
        final int l = p_149691_2_ & 0x3;
        return (k == 0 && (p_149691_1_ == 1 || p_149691_1_ == 0)) ? this.iconTop : ((k == 4 && (p_149691_1_ == 5 || p_149691_1_ == 4)) ? this.iconTop : ((k == 8 && (p_149691_1_ == 2 || p_149691_1_ == 3)) ? this.iconTop : super.blockIcon));
    }
}
