package snidgert.harrypottermod.items;

import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.init.*;

public class PenknifeClass extends Item
{
    public PenknifeClass() {
        this.setTextureName("harrypottermod:Penknife");
    }
    
    @Override
	public boolean onItemUse(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final World par3World, final int par4, final int par5, final int par6, final int par7, final float par8, final float par9, final float par10) {
        if (par3World.getBlock(par4, par5, par6) == Blocks.iron_door) {
            final int id = par3World.getBlockMetadata(par4, par5, par6);
            int j1 = 2;
            j1 ^= 0x4;
            switch (id) {
                case 0: {
                    par3World.setBlockMetadataWithNotify(par4, par5, par6, j1 - 2, 2);
                    break;
                }
                case 1: {
                    par3World.setBlockMetadataWithNotify(par4, par5, par6, j1 - 1, 2);
                    break;
                }
                case 2: {
                    par3World.setBlockMetadataWithNotify(par4, par5, par6, j1, 2);
                    break;
                }
                case 3: {
                    par3World.setBlockMetadataWithNotify(par4, par5, par6, j1 + 1, 2);
                    break;
                }
                case 4: {
                    par3World.setBlockMetadataWithNotify(par4, par5, par6, j1 + 10, 2);
                    break;
                }
                case 5: {
                    par3World.setBlockMetadataWithNotify(par4, par5, par6, j1 + 11, 2);
                    break;
                }
                case 6: {
                    par3World.setBlockMetadataWithNotify(par4, par5, par6, j1 - 4, 2);
                    break;
                }
                case 7: {
                    par3World.setBlockMetadataWithNotify(par4, par5, par6, j1 - 3, 2);
                    break;
                }
            }
            par3World.markBlockRangeForRenderUpdate(par4, par5, par6, par4, par5, par6);
        }
        return true;
    }
}
