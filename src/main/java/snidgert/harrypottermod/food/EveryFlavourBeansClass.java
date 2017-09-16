package snidgert.harrypottermod.food;

import net.minecraft.block.material.*;
import net.minecraft.world.*;
import snidgert.harrypottermod.*;
import net.minecraft.tileentity.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;

public class EveryFlavourBeansClass extends BlockContainer
{
    public EveryFlavourBeansClass(final Material arg0) {
        super(arg0);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }
    
    @Override
	public int getRenderType() {
        return -1;
    }
    
    @Override
	public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
	public boolean renderAsNormalBlock() {
        return false;
    }
    
    @Override
	public TileEntity createNewTileEntity(final World arg0, final int arg1) {
        return new TileEntityEveryFlavourBeans();
    }
    
    @Override
	public void registerBlockIcons(final IIconRegister iconregister) {
        this.blockIcon = iconregister.registerIcon("harrypottermod:EveryFlavourBeans");
    }
    
    @Override
	public void onBlockAdded(final World world, final int x, final int y, final int z) {
        super.onBlockAdded(world, x, y, z);
        this.setDeafultDirectrion(world, x, y, z);
    }
    
    private void setDeafultDirectrion(final World world, final int x, final int y, final int z) {
        if (!world.isRemote) {
            final Block b1 = world.getBlock(x, y, z - 1);
            final Block b2 = world.getBlock(x, y, z + 1);
            final Block b3 = world.getBlock(x - 1, y, z);
            final Block b4 = world.getBlock(x + 1, y, z);
            byte b5 = 3;
            if (b1.func_149730_j() && !b2.func_149730_j()) {
                b5 = 3;
            }
            if (b2.func_149730_j() && !b1.func_149730_j()) {
                b5 = 2;
            }
            if (b3.func_149730_j() && !b4.func_149730_j()) {
                b5 = 5;
            }
            if (b4.func_149730_j() && !b3.func_149730_j()) {
                b5 = 4;
            }
            world.setBlockMetadataWithNotify(x, y, z, b5, 2);
        }
    }
    
    @Override
	public void onBlockPlacedBy(final World world, final int x, final int y, final int z, final EntityLivingBase entityplayer, final ItemStack itemstack) {
        final int l = MathHelper.floor_double(((Entity)entityplayer).rotationYaw * 4.0f / 360.0f + 0.5) & 0x3;
        if (l == 0) {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }
        if (l == 1) {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }
        if (l == 2) {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }
        if (l == 3) {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }
    }
    
    @Override
	public int quantityDropped(final Random p_149745_1_) {
        return 10 + p_149745_1_.nextInt(3);
    }
    
    @Override
	public Item getItemDropped(final int p_149650_1_, final Random p_149650_2_, final int p_149650_3_) {
        final int w = p_149650_2_.nextInt(9);
        if (w == 0) {
            return MainClass.Bean1;
        }
        if (w == 1) {
            return MainClass.Bean2;
        }
        if (w == 2) {
            return MainClass.Bean3;
        }
        if (w == 3) {
            return MainClass.Bean4;
        }
        if (w == 4) {
            return MainClass.Bean5;
        }
        if (w == 5) {
            return MainClass.Bean7;
        }
        if (w == 6) {
            return MainClass.Bean8;
        }
        if (w == 7) {
            return MainClass.Bean9;
        }
        if (w == 8) {
            return MainClass.Bean10;
        }
        return MainClass.Bean6;
    }
}
