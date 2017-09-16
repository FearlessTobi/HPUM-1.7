package snidgert.harrypottermod.food;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;

public class ButterBeerClass extends ItemFood
{
    public ButterBeerClass(final int p_i45339_1_, final float p_i45339_2_, final boolean p_i45339_3_) {
        super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
        this.setTextureName("harrypottermod:butterbeer");
        this.setMaxStackSize(1);
    }
    
    @Override
	public EnumAction getItemUseAction(final ItemStack par1ItemStack) {
        return EnumAction.drink;
    }
    
    @Override
	public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        return par1ItemStack;
    }
}
