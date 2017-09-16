package snidgert.harrypottermod.items;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;

public class TimeTurnerClass extends ItemFood
{
    public TimeTurnerClass(final int i, final float f, final boolean b) {
        super(i, b);
        this.setTextureName("harrypottermod:timerturner2");
        this.setMaxStackSize(1);
    }
    
    @Override
	public ItemStack onEaten(final ItemStack par1ItemStack, final World world, final EntityPlayer par3EntityPlayer) {
        super.onEaten(par1ItemStack, world, par3EntityPlayer);
        if (world.getWorldTime() <= 13000L) {
            world.setWorldTime(13000L);
        }
        else if (world.getWorldTime() >= 1000L) {
            world.setWorldTime(1000L);
        }
        return new ItemStack(this, 1);
    }
    
    @Override
	public int getMaxItemUseDuration(final ItemStack par1ItemStack) {
        return 12;
    }
    
    @Override
	public EnumAction getItemUseAction(final ItemStack par1ItemStack) {
        return EnumAction.drink;
    }
    
    @Override
	public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        par2World.playSoundEffect(((Entity)par3EntityPlayer).posX + 0.5, ((Entity)par3EntityPlayer).posY + 0.5, ((Entity)par3EntityPlayer).posZ + 0.5, "harrypottermod:TimeTurner", 1.0f, Item.itemRand.nextFloat() * 0.4f + 0.8f);
        return par1ItemStack;
    }
}
