package snidgert.harrypottermod.mobs.entity;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import snidgert.harrypottermod.MainClass;

public class EntityPhoenixForm extends EntityHorse
{
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
    
    public EntityPhoenixForm(final World par1World) {
        super(par1World);
        this.field_70889_i = 1.0f;
        this.setHorseTamed(this.stationary = true);
        this.setSize(1.0f, 1.0f);
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
	protected String getLivingSound() {
        return null;
    }
    
    @Override
	protected String getAngrySoundName() {
        return null;
    }
    
    @Override
	protected void func_145780_a(final int p_145780_1_, final int p_145780_2_, final int p_145780_3_, final Block p_145780_4_) {
        
    }
    
    @Override
	public void onUpdate() {
        super.onUpdate();
        if (this.riddenByEntity != null) {
            if (this.FireBreath) {
                this.heal(60.0f);
                final List list1 = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox(this.posX, this.posY, this.posZ, this.posX + 1.0, this.posY + 1.0, this.posZ + 1.0).expand(4.0, 4.0, 4.0));
                for (int j = 0; j < list1.size(); ++j) {
                    final EntityPlayer entityitem = (EntityPlayer) list1.get(j);
                    if (entityitem != null) {
                        entityitem.heal(60.0f);
                    }
                }
            }
            if (this.FlyUp) {
                this.motionY += 0.3;
            }
            else if (!this.onGround && this.FlyDown) {
                this.motionY -= 0.3;
            }
            if (this.riddenByEntity.isSneaking()) {
                this.setDead();
                this.riddenByEntity.noClip = false;
                this.riddenByEntity.setInvisible(false);
            }
        }
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
    
    @Override
	protected void dropFewItems(final boolean par1, final int par2) {
        this.dropItem(MainClass.Broomstick, 1);
    }
}
