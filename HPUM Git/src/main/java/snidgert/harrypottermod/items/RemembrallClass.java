package snidgert.harrypottermod.items;

import net.minecraft.item.*;
import net.minecraft.world.*;
import snidgert.harrypottermod.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;

public class RemembrallClass extends Item
{
    public RemembrallClass() {
        this.setMaxStackSize(1);
        this.setTextureName("harrypottermod:Remembrall");
    }
    
    @Override
	public int getMaxItemUseDuration(final ItemStack stack) {
        return 1;
    }
    
    @Override
	public ItemStack onItemRightClick(final ItemStack stack, final World world, final EntityPlayer player) {
        if (!world.isRemote && !player.isSneaking()) {
            player.openGui(MainClass.instance, 3, ((Entity)player).worldObj, (int)((Entity)player).posX, (int)((Entity)player).posY, (int)((Entity)player).posZ);
        }
        return stack;
    }
}
