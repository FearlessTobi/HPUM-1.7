package snidgert.harrypottermod.blocks;

import net.minecraft.block.material.*;
import net.minecraft.world.*;
import snidgert.harrypottermod.*;
import snidgert.harrypottermod.items.*;
import snidgert.harrypottermod.mobs.entity.*;
import snidgert.harrypottermod.tileentities.TileEntityLocket;
import snidgert.harrypottermod.wands.WoodWandClass;
import net.minecraft.tileentity.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.item.*;

public class LocketClass extends BlockContainer
{
    public LocketClass(final Material arg0) {
        super(arg0);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.75f, 1.0f);
        this.setBlockUnbreakable();
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
        return new TileEntityLocket();
    }
    
    @Override
	public void registerBlockIcons(final IIconRegister iconregister) {
        this.blockIcon = iconregister.registerIcon("harrypottermod:LocketItem");
    }
    
    @Override
	public void onBlockAdded(final World world, final int x, final int y, final int z) {
        super.onBlockAdded(world, x, y, z);
        this.setDeafultDirectrion(world, x, y, z);
    }
    
    @Override
	public boolean onBlockActivated(final World par1World, final int par2, final int par3, final int par4, final EntityPlayer par5EntityPlayer, final int par6, final float par7, final float par8, final float par9) {
        if (par5EntityPlayer.getHeldItem() != null && par5EntityPlayer.getHeldItem().getItem() == MainClass.SwordofGryffindor) {
            par1World.setBlockToAir(par2, par3, par4);
        }
        else if (par5EntityPlayer.getHeldItem() != null && par5EntityPlayer.getHeldItem().getItem() == MainClass.BFang) {
            par1World.setBlockToAir(par2, par3, par4);
        }
        else if (par5EntityPlayer.getHeldItem() != null && par5EntityPlayer.getHeldItem().getItem() instanceof WoodWandClass) {
            par1World.setBlockToAir(par2, par3, par4);
            if (par1World.isAirBlock(par2, par3, par4)) {
                par1World.setBlock(par2, par3, par4, Blocks.lava);
            }
            if (par1World.isAirBlock(par2 + 1, par3, par4)) {
                par1World.setBlock(par2 + 1, par3, par4, Blocks.fire);
            }
            if (par1World.isAirBlock(par2 - 1, par3, par4)) {
                par1World.setBlock(par2 - 1, par3, par4, Blocks.fire);
            }
            if (par1World.isAirBlock(par2, par3, par4 + 1)) {
                par1World.setBlock(par2, par3, par4 + 1, Blocks.fire);
            }
            if (par1World.isAirBlock(par2, par3, par4 - 1)) {
                par1World.setBlock(par2, par3, par4 - 1, Blocks.fire);
            }
            final EntityFiendfyreDragon entityboat = new EntityFiendfyreDragon(par1World, par2 + 0.5f, par3 + 5.0f, par4 + 0.5f);
            if (!par1World.isRemote) {
                par1World.spawnEntityInWorld(entityboat);
            }
        }
        return true;
    }
    
    public static int determineOrientation(final World world, final int p_150071_1_, final int p_150071_2_, final int p_150071_3_, final EntityLivingBase p_150071_4_) {
        if (MathHelper.abs((float)((Entity)p_150071_4_).posX - p_150071_1_) < 2.0f && MathHelper.abs((float)((Entity)p_150071_4_).posZ - p_150071_3_) < 2.0f) {
            final double d0 = ((Entity)p_150071_4_).posY + 1.82 - ((Entity)p_150071_4_).yOffset;
            if (d0 - p_150071_2_ > 2.0) {
                return 1;
            }
            if (p_150071_2_ - d0 > 0.0) {
                return 0;
            }
        }
        final int l = MathHelper.floor_double(((Entity)p_150071_4_).rotationYaw * 4.0f / 360.0f + 0.5) & 0x3;
        return (l == 0) ? 2 : ((l == 1) ? 5 : ((l == 2) ? 3 : ((l == 3) ? 4 : 0)));
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
}
