package snidgert.harrypottermod.items;

import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;

public class PhoenixFeatherClass extends Item
{
    public PhoenixFeatherClass() {
        this.setCreativeTab(CreativeTabs.tabCombat);
        this.setTextureName("harrypottermod:PhoenixFeather");
        this.setMaxStackSize(64);
    }
    
    @Override
	public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        return par1ItemStack;
    }
}
