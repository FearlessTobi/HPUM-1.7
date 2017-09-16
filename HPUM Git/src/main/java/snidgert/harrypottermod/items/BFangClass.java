package snidgert.harrypottermod.items;

import net.minecraft.item.*;
import snidgert.harrypottermod.mobs.entity.*;
import net.minecraft.entity.*;

public class BFangClass extends Item
{
    public BFangClass() {
        this.setTextureName("harrypottermod:BasiliskFang");
        this.setMaxStackSize(1);
    }
    
    @Override
	public boolean hitEntity(final ItemStack par1ItemStack, final EntityLivingBase par2EntityLivingBase, final EntityLivingBase par3EntityLivingBase) {
        if (par2EntityLivingBase instanceof EntityNagini) {
            par2EntityLivingBase.setDead();
        }
        return true;
    }
}
