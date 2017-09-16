package snidgert.harrypottermod.mobs.entity;

import net.minecraft.entity.monster.*;
import net.minecraft.world.*;
import net.minecraft.block.*;
import net.minecraft.entity.*;

public class EntityNagini extends EntityMob
{
    public EntityNagini(final World par1World) {
        super(par1World);
    }
    
    @Override
	protected String getLivingSound() {
        return "harrypottermod:Hiss1";
    }
    
    @Override
	protected String getDeathSound() {
        return "harrypottermod:hiss2";
    }
    
    protected String getAngrySoundName() {
        return null;
    }
    
    @Override
	protected String getHurtSound() {
        return "harrypottermod:hiss2";
    }
    
    @Override
	protected void func_145780_a(final int p_145780_1_, final int p_145780_2_, final int p_145780_3_, final Block p_145780_4_) {
        
    }
    
    @Override
	protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.9);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0);
    }
}
