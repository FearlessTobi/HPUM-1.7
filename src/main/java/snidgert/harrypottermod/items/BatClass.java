package snidgert.harrypottermod.items;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.enchantment.*;

public class BatClass extends Item
{
    public BatClass() {
        this.setTextureName("harrypottermod:Bat");
        this.setMaxStackSize(1);
    }
    
    @Override
	public void onUpdate(final ItemStack itemstack, final World par2World, final Entity par3Entity, final int par4, final boolean par5) {
        if (!itemstack.isItemEnchanted()) {
            itemstack.addEnchantment(Enchantment.knockback, 3);
        }
    }
}
