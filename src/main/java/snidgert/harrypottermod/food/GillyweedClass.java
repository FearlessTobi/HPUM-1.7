package snidgert.harrypottermod.food;

import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;

public class GillyweedClass extends ItemFood
{
    public GillyweedClass(final int p_i45339_1_, final float p_i45339_2_, final boolean p_i45339_3_) {
        super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
        this.setCreativeTab(CreativeTabs.tabFood);
        this.setTextureName("harrypottermod:Gillyweed");
    }
    
    @Override
	public EnumAction getItemUseAction(final ItemStack par1ItemStack) {
        return EnumAction.eat;
    }
    
    @Override
	public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        return par1ItemStack;
    }
}
