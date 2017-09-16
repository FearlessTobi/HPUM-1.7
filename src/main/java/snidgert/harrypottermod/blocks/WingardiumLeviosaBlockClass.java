package snidgert.harrypottermod.blocks;

import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import snidgert.harrypottermod.mobs.entity.*;
import snidgert.harrypottermod.wands.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;

public class WingardiumLeviosaBlockClass extends Block
{
    private IIcon iconTop;
    
    public WingardiumLeviosaBlockClass(final Material p_i45394_1_) {
        super(p_i45394_1_);
    }
    
    @Override
	public boolean onBlockActivated(final World par1World, final int par2, final int par3, final int par4, final EntityPlayer par5EntityPlayer, final int par6, final float par7, final float par8, final float par9) {
        if (par5EntityPlayer.getHeldItem() != null && par5EntityPlayer.getHeldItem().getItem() instanceof DPSWandClass) {
            final EntityLevitate entitylevitate = new EntityLevitate(par1World);
            entitylevitate.setPosition(par2, par3, par4);
            par1World.spawnEntityInWorld(entitylevitate);
            par1World.setBlockToAir(par2, par3, par4);
            par1World.playSoundEffect(((Entity)par5EntityPlayer).posX + 0.5, ((Entity)par5EntityPlayer).posY + 0.5, ((Entity)par5EntityPlayer).posZ + 0.5, "harrypottermod:WandFlick", 1.0f, 1.2f);
            par5EntityPlayer.addExperience(200);
        }
        if (par5EntityPlayer.getHeldItem() != null && par5EntityPlayer.getHeldItem().getItem() instanceof TankWandClass) {
            final EntityLevitate entitylevitate = new EntityLevitate(par1World);
            entitylevitate.setPosition(par2, par3, par4);
            par1World.spawnEntityInWorld(entitylevitate);
            par1World.setBlockToAir(par2, par3, par4);
            par1World.playSoundEffect(((Entity)par5EntityPlayer).posX + 0.5, ((Entity)par5EntityPlayer).posY + 0.5, ((Entity)par5EntityPlayer).posZ + 0.5, "harrypottermod:WandFlick", 1.0f, 1.2f);
            par5EntityPlayer.addExperience(200);
        }
        if (par5EntityPlayer.getHeldItem() != null && par5EntityPlayer.getHeldItem().getItem() instanceof SupportWandClass) {
            final EntityLevitate entitylevitate = new EntityLevitate(par1World);
            entitylevitate.setPosition(par2, par3, par4);
            par1World.spawnEntityInWorld(entitylevitate);
            par1World.setBlockToAir(par2, par3, par4);
            par1World.playSoundEffect(((Entity)par5EntityPlayer).posX + 0.5, ((Entity)par5EntityPlayer).posY + 0.5, ((Entity)par5EntityPlayer).posZ + 0.5, "harrypottermod:WandFlick", 1.0f, 1.2f);
            par5EntityPlayer.addExperience(200);
        }
        return true;
    }
    
    @Override
	public void registerBlockIcons(final IIconRegister reg) {
        super.blockIcon = reg.registerIcon("harrypottermod:levitate2");
        this.iconTop = reg.registerIcon("harrypottermod:levitate1");
    }
    
    @Override
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(final int p_149691_1_, final int p_149691_2_) {
        return (p_149691_1_ == 1) ? this.iconTop : ((p_149691_1_ == 0) ? this.iconTop : ((p_149691_1_ != p_149691_2_) ? super.blockIcon : super.blockIcon));
    }
}
