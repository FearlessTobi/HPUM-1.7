package snidgert.harrypottermod.mobs.entity;

import net.minecraft.entity.passive.*;
import net.minecraft.world.*;
import net.minecraft.item.*;

public class EntityRamora extends EntitySquid
{
    public EntityRamora(final World p_i1693_1_) {
        super(p_i1693_1_);
    }
    
    @Override
	protected void dropFewItems(final boolean par1, final int par2) {
        this.dropItem((Item)null, 1);
    }
}
