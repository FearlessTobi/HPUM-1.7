package snidgert.harrypottermod.mobs.entity;

import net.minecraft.entity.passive.*;
import net.minecraft.world.*;
import snidgert.harrypottermod.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.*;
import net.minecraft.util.*;

import java.util.*;
import net.minecraft.entity.*;

public class EntityDemiguise extends EntityAnimal
{
    private static final String __OBFID = "CL_00001647";
    
    public EntityDemiguise(final World p_i1689_1_) {
        super(p_i1689_1_);
        this.setSize(0.9f, 0.9f);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(6, new EntityAIWander(this, 1.0));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, 1.0, true));
        this.tasks.addTask(4, new EntityAIAvoidEntity(this, EntityPlayer.class, 16.0f, 0.8, 1.33));
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
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25);
    }
    
    @Override
	protected void updateAITasks() {
        super.updateAITasks();
    }
    
    @Override
	public void onUpdate() {
        this.setInvisible(true);
        if (this.worldObj.isRaining()) {
            this.setInvisible(false);
        }
        super.onUpdate();
    }
    
    @Override
	protected void dropFewItems(final boolean par1, final int par2) {
        this.dropItem(MainClass.DemiguiseHair, 3);
    }
    
    @Override
	protected void entityInit() {
        final Random rnd = new Random();
        final int two = rnd.nextInt(6);
        this.dataWatcher.addObject(16, (byte)0);
        this.getDataWatcher().addObject(25, 5);
        this.dataWatcher.updateObject(25, two);
        super.entityInit();
    }
    
    public int getTextureType() {
        return this.dataWatcher.getWatchableObjectInt(25);
    }
    
    @Override
	public EntityDemiguise createChild(final EntityAgeable p_90011_1_) {
        return null;
    }
}
