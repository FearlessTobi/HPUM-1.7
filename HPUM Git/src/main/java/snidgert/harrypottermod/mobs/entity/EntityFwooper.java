package snidgert.harrypottermod.mobs.entity;

import net.minecraft.entity.passive.*;
import net.minecraft.world.*;
import snidgert.harrypottermod.*;
import net.minecraft.block.*;
import java.util.*;

public class EntityFwooper extends EntityBat
{
    public EntityFwooper(final World p_i1680_1_) {
        super(p_i1680_1_);
    }
    
    @Override
	protected String getHurtSound() {
        return null;
    }
    
    @Override
	protected String getDeathSound() {
        return null;
    }
    
    @Override
	protected void dropFewItems(final boolean par1, final int par2) {
        this.dropItem(MainClass.FwooperFeather, 4);
    }
    
    @Override
	protected String getLivingSound() {
        return "mob.endermen.death";
    }
    
    protected String getAngrySoundName() {
        return null;
    }
    
    @Override
	protected void func_145780_a(final int p_145780_1_, final int p_145780_2_, final int p_145780_3_, final Block p_145780_4_) {
        
    }
    
    @Override
	protected void entityInit() {
        final Random rnd = new Random();
        final int two = rnd.nextInt(7);
        super.entityInit();
        this.getDataWatcher().addObject(25, 5);
        this.dataWatcher.updateObject(25, two);
    }
    
    public int getTextureType() {
        return this.dataWatcher.getWatchableObjectInt(25);
    }
}
