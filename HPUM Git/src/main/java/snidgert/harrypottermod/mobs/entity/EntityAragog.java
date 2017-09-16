package snidgert.harrypottermod.mobs.entity;

import net.minecraft.entity.monster.*;
import net.minecraft.world.*;
import snidgert.harrypottermod.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.entity.*;

public class EntityAragog extends EntityCaveSpider
{
    public EntityAragog(final World arg0) {
        super(arg0);
        this.setSize(4.0f, 3.0f);
    }
    
    @Override
	protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.0);
    }
    
    @Override
	public void onLivingUpdate() {
        if (!this.worldObj.isRemote) {
            final int i = MathHelper.floor_double(this.posX);
            int j = MathHelper.floor_double(this.posZ);
            j = MathHelper.floor_double(this.posX + (i % 2 * 2 - 1) * 0.25f);
            final int k = MathHelper.floor_double(this.posY);
            final int l = MathHelper.floor_double(this.posZ + (i / 2 % 2 * 2 - 1) * 0.25f);
            if (this.worldObj.getBlockMetadata(j, k, l) == 0 && this.worldObj.getBiomeGenForCoords(j, l).getFloatTemperature(l, l, l) < 0.8f && Blocks.snow_layer.canPlaceBlockAt(this.worldObj, j, k, l)) {
                this.setPosition(this.posX, this.posY, this.posZ);
                this.worldObj.setBlock(j, k, l, MainClass.AcromantulaWeb);
            }
        }
        super.onLivingUpdate();
    }
}
