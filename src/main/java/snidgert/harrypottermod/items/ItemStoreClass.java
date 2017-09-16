package snidgert.harrypottermod.items;

import net.minecraft.item.*;
import net.minecraft.world.*;
import snidgert.harrypottermod.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.entity.*;

public class ItemStoreClass extends Item
{
    public ItemStoreClass() {
        this.setMaxStackSize(1);
        this.setTextureName("harrypottermod:Bag");
    }
    
    @Override
	public int getMaxItemUseDuration(final ItemStack stack) {
        return 1;
    }
    
    @Override
	public ItemStack onItemRightClick(final ItemStack stack, final World world, final EntityPlayer player) {
        if (!world.isRemote) {
            if (!player.isSneaking()) {
                player.openGui(MainClass.instance, MainClass.GUI_ITEM_INV, ((Entity)player).worldObj, (int)((Entity)player).posX, (int)((Entity)player).posY, (int)((Entity)player).posZ);
            }
            else {
                new InventoryItem(player.getHeldItem()).setInventorySlotContents(0, new ItemStack(Items.diamond, 4));
            }
        }
        return stack;
    }
}
