package snidgert.harrypottermod.blocks;

import java.util.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.block.material.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.world.*;
import snidgert.harrypottermod.*;
import snidgert.harrypottermod.tileentities.TileEntityWandCrafter;
import net.minecraft.entity.player.*;
import cpw.mods.fml.common.network.internal.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.tileentity.*;
import net.minecraft.entity.*;

public class WandCrafterClass extends BlockContainer
{
    private Random rand;
    private final boolean isActive;
    private static boolean keepInventory;
    @SideOnly(Side.CLIENT)
    private IIcon iconfront;
    
    public WandCrafterClass(final boolean blockState) {
        super(Material.wood);
        this.rand = new Random();
        this.isActive = blockState;
    }
    
    @Override
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister iconregister) {
        this.blockIcon = iconregister.registerIcon("harrypottermod:Table");
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
	public void onBlockAdded(final World world, final int x, final int y, final int z) {
        super.onBlockAdded(world, x, y, z);
        this.setDeafultDirectrion(world, x, y, z);
    }
    
    @Override
	public boolean onBlockActivated(final World world, final int x, final int y, final int z, final EntityPlayer player, final int side, final float hitX, final float hitY, final float hitZ) {
        if (world.isRemote) {
            return true;
        }
        if (!player.isSneaking()) {
            final TileEntityWandCrafter entity = (TileEntityWandCrafter)world.getTileEntity(x, y, z);
            if (entity != null) {
                FMLNetworkHandler.openGui(player, MainClass.instance, 4, world, x, y, z);
            }
            return true;
        }
        return false;
    }
    
    private void setDeafultDirectrion(final World world, final int x, final int y, final int z) {
        if (!world.isRemote) {
            final Block block1 = world.getBlock(x, y, z - 1);
            final Block block2 = world.getBlock(x, y, z + 1);
            final Block block3 = world.getBlock(x - 1, y, z);
            final Block block4 = world.getBlock(x + 1, y, z);
            byte b0 = 3;
            if (block1.func_149730_j() && !block2.func_149730_j()) {
                b0 = 3;
            }
            if (block2.func_149730_j() && !block1.func_149730_j()) {
                b0 = 2;
            }
            if (block3.func_149730_j() && !block4.func_149730_j()) {
                b0 = 5;
            }
            if (block4.func_149730_j() && !block3.func_149730_j()) {
                b0 = 4;
            }
            world.setBlockMetadataWithNotify(x, y, z, b0, 2);
        }
    }
    
    @Override
	public void onBlockPlacedBy(final World world, final int x, final int y, final int z, final EntityLivingBase entity, final ItemStack itemstack) {
        final int i = MathHelper.floor_double(((Entity)entity).rotationYaw * 4.0 / 360.0 + 0.5) & 0x3;
        if (i == 0) {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }
        if (i == 1) {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }
        if (i == 2) {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }
        if (i == 3) {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }
        if (itemstack.hasDisplayName()) {}
    }
    
    @Override
	public TileEntity createNewTileEntity(final World var1, final int var2) {
        return new TileEntityWandCrafter();
    }
    
    public static void updateBlockState(final boolean craftingWand, final World world, final int xCoord, final int yCoord, final int zCoord) {
        final int i = world.getBlockMetadata(xCoord, yCoord, zCoord);
        final TileEntity entity = world.getTileEntity(xCoord, yCoord, zCoord);
        WandCrafterClass.keepInventory = true;
        if (craftingWand) {
            world.setBlock(xCoord, yCoord, zCoord, MainClass.WandCrafterActive);
        }
        else {
            world.setBlock(xCoord, yCoord, zCoord, MainClass.WandCrafterIdle);
        }
        WandCrafterClass.keepInventory = false;
        world.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);
        if (entity != null) {
            entity.validate();
            world.setTileEntity(xCoord, yCoord, zCoord, entity);
        }
    }
    
    static {
        WandCrafterClass.keepInventory = false;
    }
}
