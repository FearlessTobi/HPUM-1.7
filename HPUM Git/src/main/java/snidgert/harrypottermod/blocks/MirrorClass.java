package snidgert.harrypottermod.blocks;

import net.minecraft.block.material.*;
import net.minecraft.world.*;
import snidgert.harrypottermod.*;
import snidgert.harrypottermod.tileentities.TileEntityMirror;
import net.minecraft.tileentity.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;

public class MirrorClass extends BlockContainer
{
    public MirrorClass(final Material arg0) {
        super(arg0);
        this.setBlockBounds(-0.3125f, 0.0f, 0.625f, 1.3125f, 3.0625f, 0.375f);
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
        return new TileEntityMirror();
    }
    
    @Override
	public void registerBlockIcons(final IIconRegister iconregister) {
        this.blockIcon = iconregister.registerIcon("harrypottermod:MirrorItem");
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
        byte b0 = 0;
        final int l = MathHelper.floor_double(((Entity)entityplayer).rotationYaw * 4.0f / 360.0f + 0.5) & 0x3;
        if (l == 0) {
            b0 = 2;
        }
        if (l == 1) {
            b0 = 5;
        }
        if (l == 2) {
            b0 = 3;
        }
        if (l == 3) {
            b0 = 4;
        }
        world.setBlockMetadataWithNotify(x, y, z, b0, 2);
    }
    
    @Override
	public boolean onBlockActivated(final World par1World, final int par2, final int par3, final int par4, final EntityPlayer par5EntityPlayer, final int par6, final float par7, final float par8, final float par9) {
        par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(MainClass.PStone, 1));
        return true;
    }
}
