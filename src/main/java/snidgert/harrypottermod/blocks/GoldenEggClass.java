package snidgert.harrypottermod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import snidgert.harrypottermod.MainClass;
import snidgert.harrypottermod.tileentities.TileEntityGoldenEgg;

public class GoldenEggClass extends BlockContainer
{
	public GoldenEggClass(final Material arg0) {
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
		return new TileEntityGoldenEgg();
	}

	@Override
	public void registerBlockIcons(final IIconRegister iconregister) {
		this.blockIcon = iconregister.registerIcon("harrypottermod:GoldenEggItem");
	}

	@Override
	public void onBlockAdded(final World world, final int x, final int y, final int z) {
		super.onBlockAdded(world, x, y, z);
		this.setDeafultDirectrion(world, x, y, z);
	}

	@Override
	public boolean onBlockActivated(final World par1World, final int par2, final int par3, final int par4, final EntityPlayer par5EntityPlayer, final int par6, final float par7, final float par8, final float par9) {
		if (par1World.getBlock(par2, par3 + 1, par4) == Blocks.water) {
			par1World.playSoundEffect(par2 + 0.5, par3 + 0.5, par4 + 0.5, "harrypottermod:Song", 1.0f, 1.2f);
		}
		else {
			par1World.playSoundEffect(par2 + 0.5, par3 + 0.5, par4 + 0.5, "harrypottermod:EggScream", 1.0f, 1.2f);
		}
		par1World.setBlockToAir(par2, par3, par4);
		par1World.setBlock(par2, par3, par4, MainClass.GoldenEggOpen);
		return true;
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
}
