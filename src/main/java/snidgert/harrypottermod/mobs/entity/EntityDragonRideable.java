package snidgert.harrypottermod.mobs.entity;

import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import snidgert.harrypottermod.*;
import snidgert.harrypottermod.projectiles.*;
import net.minecraft.block.*;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class EntityDragonRideable extends EntityHorse
{
    protected EntityPlayer rider;
    public boolean FlyUp;
    public boolean FlyDown;
    public boolean FireBreath;
    public float field_70886_e;
    public float destPos;
    public float field_70884_g;
    public float field_70888_h;
    public float field_70889_i;
    private boolean field_110294_bI;
    private int field_110285_bP;
    public boolean stationary;
    
    public EntityDragonRideable(final World par1World) {
        super(par1World);
        this.field_70889_i = 1.0f;
        this.stationary = true;
        this.setSize(10.0f, 5.0f);
    }
    
    @Override
	protected void dropFewItems(final boolean par1, final int par2) {
        this.dropItem(MainClass.DragonHeartString, 1);
    }
    
    @Override
	protected String getHurtSound() {
        return "harrypottermod:DragonRoar";
    }
    
    @Override
	protected String getDeathSound() {
        return "harrypottermod:DragonRoar";
    }
    
    @Override
	protected String getLivingSound() {
        return "harrypottermod:DragonRoar";
    }
    
    @Override
	protected String getAngrySoundName() {
        return null;
    }
    
    @Override
	protected void func_145780_a(final int p_145780_1_, final int p_145780_2_, final int p_145780_3_, final Block p_145780_4_) {
        this.playSound("mob.zombie.step", 1.0f, 1.0f);
    }
    
    @Override
	public EntityHorse createChild(final EntityAgeable var1) {
        return null;
    }
    
    @Override
	protected void fall(final float par1) {
    }
    
    @Override
	protected boolean isMovementCeased() {
        return this.stationary;
    }
    
    @Override
	protected void updateFallState(final double par1, final boolean par3) {
    }
    
    @Override
	public void onUpdate() {
        super.onUpdate();
        if (this.riddenByEntity != null) {
            if (this.FireBreath) {
                final Vec3 look = this.getLookVec();
                final IncendioProjectile fireball2 = new IncendioProjectile(this.worldObj, this, 3.0, 3.0, 3.0);
                fireball2.setPosition(this.posX + look.xCoord * 10.0, this.posY + look.yCoord * 10.0 + 2.0, this.posZ + look.zCoord * 10.0);
                fireball2.accelerationX = look.xCoord * 0.1;
                fireball2.accelerationY = look.yCoord * 0.1;
                fireball2.accelerationZ = look.zCoord * 0.1;
                this.worldObj.spawnEntityInWorld(fireball2);
            }
            if (this.FlyUp) {
                this.motionY += 0.3;
            }
            else if (!this.onGround && this.FlyDown) {
                this.motionY -= 0.3;
            }
        }
    }
    
    @Override
	public void onLivingUpdate() {
        super.onLivingUpdate();
        this.field_70888_h = this.field_70886_e;
        this.field_70884_g = this.destPos;
        this.destPos += (float)((this.onGround ? -1 : 4) * 0.3);
        if (this.riddenByEntity != null) {
            if (this.destPos < 0.0f) {
                this.destPos = 0.0f;
            }
            if (this.destPos > 1.0f) {
                this.destPos = 1.0f;
            }
            if (!this.onGround && this.field_70889_i < 1.0f) {
                this.field_70889_i = 1.0f;
            }
            this.field_70889_i *= 0.9;
            if (!this.onGround && this.motionY < 0.0) {
                this.motionY = 0.0;
            }
            this.field_70886_e += this.field_70889_i * 2.0f;
        }
        else {
            if (this.destPos < 0.0f) {
                this.destPos = 0.0f;
            }
            if (this.destPos > 1.0f) {
                this.destPos = 1.0f;
            }
            if (!this.onGround && this.field_70889_i < 1.0f) {
                this.field_70889_i = 1.0f;
            }
            this.field_70889_i *= 0.9;
            if (!this.onGround && this.motionY < 0.0) {
                this.motionY *= 0.6;
            }
            this.field_70886_e += this.field_70889_i * 2.0f;
        }
    }
    
    @Override
	public void moveEntityWithHeading(float par1, float par2) {
        if (this.riddenByEntity != null) {
            final float rotationYaw = this.riddenByEntity.rotationYaw;
            this.rotationYaw = rotationYaw;
            this.prevRotationYaw = rotationYaw;
            this.rotationPitch = this.riddenByEntity.rotationPitch * 0.5f;
            this.setRotation(this.rotationYaw, this.rotationPitch);
            final float rotationYaw2 = this.rotationYaw;
            this.renderYawOffset = rotationYaw2;
            this.rotationYawHead = rotationYaw2;
            par1 = ((EntityLivingBase)this.riddenByEntity).moveStrafing * 0.5f;
            par2 = ((EntityLivingBase)this.riddenByEntity).moveForward;
            if (par2 <= 0.0f) {
                par2 *= 0.25f;
                this.field_110285_bP = 0;
            }
            if (this.onGround && super.jumpPower == 0.0f && this.isRearing() && !this.field_110294_bI) {
                par1 = 0.0f;
                par2 = 0.0f;
            }
            if (super.jumpPower > 0.0f && !this.isHorseJumping() && this.onGround) {
                this.motionY = this.getHorseJumpStrength() * super.jumpPower;
                if (this.isPotionActive(Potion.jump)) {
                    this.motionY += (this.getActivePotionEffect(Potion.jump).getAmplifier() + 1) * 0.1f;
                }
                this.setHorseJumping(true);
                this.isAirBorne = true;
                if (par2 > 0.0f) {
                    final float f2 = MathHelper.sin(this.rotationYaw * 3.1415927f / 180.0f);
                    final float f3 = MathHelper.cos(this.rotationYaw * 3.1415927f / 180.0f);
                    this.motionX += -0.4f * f2 * super.jumpPower;
                    this.motionZ += 0.4f * f3 * super.jumpPower;
                    this.playSound("mob.horse.jump", 0.4f, 1.0f);
                }
                super.jumpPower = 0.0f;
            }
            this.stepHeight = 1.0f;
            this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1f;
            if (!this.worldObj.isRemote) {
                this.setAIMoveSpeed((float)this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue());
                super.moveEntityWithHeading(par1, par2);
            }
            if (this.onGround) {
                super.jumpPower = 0.0f;
                this.setHorseJumping(false);
            }
            this.prevLimbSwingAmount = this.limbSwingAmount;
            final double d0 = this.posX - this.prevPosX;
            final double d2 = this.posZ - this.prevPosZ;
            float f4 = MathHelper.sqrt_double(d0 * d0 + d2 * d2) * 4.0f;
            if (f4 > 1.0f) {
                f4 = 1.0f;
            }
            this.limbSwingAmount += (f4 - this.limbSwingAmount) * 0.4f;
            this.limbSwing += this.limbSwingAmount;
        }
        else {
            this.stepHeight = 0.5f;
            this.jumpMovementFactor = 0.02f;
            super.moveEntityWithHeading(par1, par2);
        }
        if (!this.onGround) {
            super.moveFlying(par1, par2, 0.1f);
        }
    }
    
    @Override
	protected boolean isAIEnabled() {
        return false;
    }
}
