package snidgert.harrypottermod.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import java.util.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.world.*;
import snidgert.harrypottermod.wands.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.entity.*;

public class BrokenGlassClass extends Block
{
    public BrokenGlassClass(final Material p_i45394_1_) {
        super(p_i45394_1_);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(0.0f);
        this.setResistance(0.0f);
        this.setBlockTextureName("harrypottermod:BrokenGlass");
    }
    
    @Override
	public int quantityDropped(final Random par1Random) {
        return 0;
    }
    
    @Override
	@SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 0;
    }
    
    @Override
	public boolean onBlockActivated(final World par1World, final int par2, final int par3, final int par4, final EntityPlayer par5EntityPlayer, final int par6, final float par7, final float par8, final float par9) {
        if (par5EntityPlayer.getHeldItem() != null && par5EntityPlayer.getHeldItem().getItem() instanceof DPSWandClass) {
            par1World.setBlock(par2, par3, par4, Blocks.glass);
            par1World.playSoundEffect(((Entity)par5EntityPlayer).posX + 0.5, ((Entity)par5EntityPlayer).posY + 0.5, ((Entity)par5EntityPlayer).posZ + 0.5, "harrypottermod:Reparo", 1.0f, 1.2f);
            par5EntityPlayer.addExperience(200);
        }
        if (par5EntityPlayer.getHeldItem() != null && par5EntityPlayer.getHeldItem().getItem() instanceof TankWandClass) {
            par1World.setBlock(par2, par3, par4, Blocks.glass);
            par1World.playSoundEffect(((Entity)par5EntityPlayer).posX + 0.5, ((Entity)par5EntityPlayer).posY + 0.5, ((Entity)par5EntityPlayer).posZ + 0.5, "harrypottermod:Reparo", 1.0f, 1.2f);
            par5EntityPlayer.addExperience(200);
        }
        if (par5EntityPlayer.getHeldItem() != null && par5EntityPlayer.getHeldItem().getItem() instanceof SupportWandClass) {
            par1World.setBlock(par2, par3, par4, Blocks.glass);
            par1World.playSoundEffect(((Entity)par5EntityPlayer).posX + 0.5, ((Entity)par5EntityPlayer).posY + 0.5, ((Entity)par5EntityPlayer).posZ + 0.5, "harrypottermod:Reparo", 1.0f, 1.2f);
            par5EntityPlayer.addExperience(200);
        }
        return true;
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
	protected boolean canSilkHarvest() {
        return false;
    }
}
