package snidgert.harrypottermod.mobs.entity;

import net.minecraft.entity.monster.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class EntityBoggartDementor extends EntityMob
{
    private float heightOffset;
    private int heightOffsetUpdateTime;
    private int field_70846_g;
    
    public EntityBoggartDementor(final World par1World) {
        super(par1World);
        this.heightOffset = 0.5f;
        this.isImmuneToFire = true;
        this.experienceValue = 10;
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 2.0, false));
    }
    
    public EntityBoggartDementor(final World par1World, final double par2, final double par4, final double par6) {
        this(par1World);
        this.setPosition(par2, par4 + this.yOffset, par6);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.prevPosX = par2;
        this.prevPosY = par4;
        this.prevPosZ = par6;
    }
    
    @Override
	protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.43000000417232515);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0);
    }
    
    @Override
	protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
    }
    
    @Override
	@SideOnly(Side.CLIENT)
    public int getBrightnessForRender(final float par1) {
        return 15728880;
    }
    
    @Override
	public float getBrightness(final float par1) {
        return 1.0f;
    }
    
    @Override
	public void onLivingUpdate() {
        if (!this.worldObj.isRemote) {
            if (this.isWet()) {
                this.attackEntityFrom(DamageSource.drown, 1.0f);
            }
            --this.heightOffsetUpdateTime;
            if (this.heightOffsetUpdateTime <= 0) {
                this.heightOffsetUpdateTime = 100;
                this.heightOffset = 0.5f + (float)this.rand.nextGaussian() * 3.0f;
            }
            if (this.getEntityToAttack() != null && this.getEntityToAttack().posY + this.getEntityToAttack().getEyeHeight() > this.posY + this.getEyeHeight() + this.heightOffset) {
                this.motionY += (0.30000001192092896 - this.motionY) * 0.30000001192092896;
            }
            final int i = MathHelper.floor_double(this.posX);
            int j = MathHelper.floor_double(this.posZ);
            j = MathHelper.floor_double(this.posX + (i % 2 * 2 - 1) * 0.25f);
            final int k = MathHelper.floor_double(this.posY);
            final int l = MathHelper.floor_double(this.posZ + (i / 2 % 2 * 2 - 1) * 0.25f);
        }
        super.onLivingUpdate();
    }
    
    @Override
	protected void fall(final float par1) {
    }
    
    public boolean func_70845_n() {
        return (this.dataWatcher.getWatchableObjectByte(16) & 0x1) != 0x0;
    }
    
    public void func_70844_e(final boolean par1) {
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);
        if (par1) {
            b0 |= 0x1;
        }
        else {
            b0 &= 0xFFFFFFFE;
        }
        this.dataWatcher.updateObject(16, b0);
    }
    
    @Override
	protected boolean isValidLightLevel() {
        return true;
    }
}
