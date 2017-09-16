package snidgert.harrypottermod.items;

import net.minecraft.item.*;
import net.minecraft.world.*;
import snidgert.harrypottermod.mobs.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;

public class WerewolfFormClass extends Item
{
    public WerewolfFormClass() {
        this.setTextureName("harrypottermod:WerewolfMedallion");
    }
    
    @Override
	public ItemStack onItemRightClick(final ItemStack itemstack, final World world, final EntityPlayer entityplayer) {
        if (!world.isRemote) {
            entityplayer.setInvisible(true);
            ((Entity)entityplayer).noClip = true;
            final EntityWerewolf entitylevitate = new EntityWerewolf(world);
            entitylevitate.setPosition(((Entity)entityplayer).posX, ((Entity)entityplayer).posY, ((Entity)entityplayer).posZ);
            world.spawnEntityInWorld(entitylevitate);
            entityplayer.mountEntity(entitylevitate);
        }
        return itemstack;
    }
}
