package snidgert.harrypottermod.items;

import net.minecraft.item.*;
import net.minecraft.world.*;
import snidgert.harrypottermod.mobs.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class QuaffleClass extends Item
{
    public QuaffleClass() {
        this.setTextureName("harrypottermod:QuaffleItem");
        this.setMaxStackSize(1);
    }
    
    @Override
	public ItemStack onItemRightClick(final ItemStack itemstack, final World world, final EntityPlayer entityplayer) {
        final Vec3 look = entityplayer.getLookVec();
        final EntityQuaffle fireball2 = new EntityQuaffle(world, entityplayer);
        fireball2.setPosition(((Entity)entityplayer).posX + look.xCoord * 2.0, ((Entity)entityplayer).posY + look.yCoord * 2.0, ((Entity)entityplayer).posZ + look.zCoord * 2.0);
        fireball2.addVelocity(look.xCoord * 1.4, look.yCoord * 1.4, look.zCoord * 1.4);
        world.spawnEntityInWorld(fireball2);
        if (!entityplayer.capabilities.isCreativeMode) {
            --itemstack.stackSize;
        }
        return itemstack;
    }
}
