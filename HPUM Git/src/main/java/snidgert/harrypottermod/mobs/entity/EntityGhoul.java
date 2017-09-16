package snidgert.harrypottermod.mobs.entity;

import net.minecraft.entity.passive.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class EntityGhoul extends EntityAnimal
{
    private static final String __OBFID = "CL_00001647";
    
    public EntityGhoul(final World p_i1689_1_) {
        super(p_i1689_1_);
        this.setSize(1.0f, 2.5f);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(6, new EntityAIWander(this, 1.0));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, true));
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, 1.0, true));
    }
    
    @Override
	public boolean isAIEnabled() {
        return true;
    }
    
    @Override
	public boolean attackEntityAsMob(final Entity p_70652_1_) {
        this.worldObj.setEntityState(this, (byte)4);
        final boolean flag = p_70652_1_.attackEntityFrom(DamageSource.causeMobDamage(this), 7 + this.rand.nextInt(15));
        return flag;
    }
    
    @Override
	protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.15);
    }
    
    @Override
	protected void updateAITasks() {
        super.updateAITasks();
    }
    
    @Override
	public EntityGhoul createChild(final EntityAgeable p_90011_1_) {
        return null;
    }
}
