package snidgert.harrypottermod.mobs.entity;

import net.minecraft.entity.passive.*;
import net.minecraft.world.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.*;

public class EntityFlobberworm extends EntityAnimal
{
    private static final String __OBFID = "CL_00001647";
    
    public EntityFlobberworm(final World p_i1689_1_) {
        super(p_i1689_1_);
        this.setSize(0.5f, 0.5f);
        this.tasks.addTask(6, new EntityAIWander(this, 0.01));
    }
    
    @Override
	public boolean isAIEnabled() {
        return true;
    }
    
    @Override
	protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(2.5E-4);
    }
    
    @Override
	protected void updateAITasks() {
        super.updateAITasks();
    }
    
    @Override
	public EntityFlobberworm createChild(final EntityAgeable p_90011_1_) {
        return null;
    }
}
