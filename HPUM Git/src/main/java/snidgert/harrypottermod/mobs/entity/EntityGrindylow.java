package snidgert.harrypottermod.mobs.entity;

import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityGrindylow extends EntityMob implements IMob
{
    public float squidPitch;
    public float prevSquidPitch;
    public float squidYaw;
    public float prevSquidYaw;
    public float squidRotation;
    public float prevSquidRotation;
    public float tentacleAngle;
    public float lastTentacleAngle;
    private float randomMotionSpeed;
    private float rotationVelocity;
    private float field_70871_bB;
    private float randomMotionVecX;
    private float randomMotionVecY;
    private float randomMotionVecZ;
    
    public EntityGrindylow(final World p_i1695_1_) {
        super(p_i1695_1_);
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0, true));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0, true));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, false));
        this.rotationVelocity = 1.0f / (this.rand.nextFloat() + 1.0f) * 0.2f;
    }
    
    @Override
	protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.0);
    }
    
    @Override
	protected Entity findPlayerToAttack() {
        final EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0);
        return (entityplayer != null && this.canEntityBeSeen(entityplayer)) ? entityplayer : null;
    }
    
    @Override
	public void onCollideWithPlayer(final EntityPlayer p_70100_1_) {
        p_70100_1_.attackEntityFrom(DamageSource.magic, 5.0f);
    }
    
    @Override
	public boolean attackEntityFrom(final DamageSource p_70097_1_, final float p_70097_2_) {
        if (this.isEntityInvulnerable()) {
            return false;
        }
        if (!super.attackEntityFrom(p_70097_1_, p_70097_2_)) {
            return false;
        }
        final Entity entity = p_70097_1_.getEntity();
        if (this.riddenByEntity != entity && this.ridingEntity != entity) {
            if (entity != this) {
                this.entityToAttack = entity;
            }
            return true;
        }
        return true;
    }
    
    @Override
	public boolean attackEntityAsMob(final Entity p_70652_1_) {
        float f = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
        int i = 0;
        if (p_70652_1_ instanceof EntityLivingBase) {
            f += EnchantmentHelper.getEnchantmentModifierLiving((EntityLivingBase)this, (EntityLivingBase)p_70652_1_);
            i += EnchantmentHelper.getKnockbackModifier((EntityLivingBase)this, (EntityLivingBase)p_70652_1_);
        }
        final boolean flag = p_70652_1_.attackEntityFrom(DamageSource.causeMobDamage(this), f);
        if (flag) {
            if (i > 0) {
                p_70652_1_.addVelocity(-MathHelper.sin(this.rotationYaw * 3.1415927f / 180.0f) * i * 0.5f, 0.1, MathHelper.cos(this.rotationYaw * 3.1415927f / 180.0f) * i * 0.5f);
                this.motionX *= 0.6;
                this.motionZ *= 0.6;
            }
            final int j = EnchantmentHelper.getFireAspectModifier(this);
            if (j > 0) {
                p_70652_1_.setFire(j * 4);
            }
            if (p_70652_1_ instanceof EntityLivingBase) {
                EnchantmentHelper.func_151384_a((EntityLivingBase)p_70652_1_, (Entity)this);
            }
            EnchantmentHelper.func_151385_b(this, p_70652_1_);
        }
        return flag;
    }
    
    @Override
	protected void attackEntity(final Entity p_70785_1_, final float p_70785_2_) {
        if (this.attackTime <= 0 && p_70785_2_ < 2.0f && p_70785_1_.boundingBox.maxY > this.boundingBox.minY && p_70785_1_.boundingBox.minY < this.boundingBox.maxY) {
            this.attackTime = 20;
            this.attackEntityAsMob(p_70785_1_);
        }
    }
    
    @Override
	protected void updateEntityActionState() {
        ++this.entityAge;
        if (this.entityAge > 100) {
            final float randomMotionVecX = 0.0f;
            this.randomMotionVecZ = randomMotionVecX;
            this.randomMotionVecY = randomMotionVecX;
            this.randomMotionVecX = randomMotionVecX;
        }
        else if (this.rand.nextInt(50) == 0 || !this.inWater || (this.randomMotionVecX == 0.0f && this.randomMotionVecY == 0.0f && this.randomMotionVecZ == 0.0f)) {
            final float f = this.rand.nextFloat() * 3.1415927f * 2.0f;
            this.randomMotionVecX = MathHelper.cos(f) * 0.2f;
            this.randomMotionVecY = -0.1f + this.rand.nextFloat() * 0.2f;
            this.randomMotionVecZ = MathHelper.sin(f) * 0.2f;
        }
        final EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0);
        if (entityplayer != null) {
            this.faceEntity(entityplayer, 10.0f, 20.0f);
        }
        this.despawnEntity();
    }
    
    @Override
	public void onLivingUpdate() {
        super.onLivingUpdate();
        this.prevSquidPitch = this.squidPitch;
        this.prevSquidYaw = this.squidYaw;
        this.prevSquidRotation = this.squidRotation;
        this.lastTentacleAngle = this.tentacleAngle;
        this.squidRotation += this.rotationVelocity;
        if (this.squidRotation > 6.2831855f) {
            this.squidRotation -= 6.2831855f;
            if (this.rand.nextInt(10) == 0) {
                this.rotationVelocity = 1.0f / (this.rand.nextFloat() + 1.0f) * 0.2f;
            }
        }
        if (this.isInWater()) {
            if (this.squidRotation < 3.1415927f) {
                final float f = this.squidRotation / 3.1415927f;
                this.tentacleAngle = MathHelper.sin(f * f * 3.1415927f) * 3.1415927f * 0.25f;
                if (f > 0.75) {
                    this.randomMotionSpeed = 1.0f;
                    this.field_70871_bB = 1.0f;
                }
                else {
                    this.field_70871_bB *= 0.8f;
                }
            }
            else {
                this.tentacleAngle = 0.0f;
                this.randomMotionSpeed *= 0.9f;
                this.field_70871_bB *= 0.99f;
            }
            if (!this.worldObj.isRemote) {
                this.motionX = this.randomMotionVecX * this.randomMotionSpeed;
                this.motionY = this.randomMotionVecY * this.randomMotionSpeed;
                this.motionZ = this.randomMotionVecZ * this.randomMotionSpeed;
            }
            final float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.renderYawOffset += (-(float)Math.atan2(this.motionX, this.motionZ) * 180.0f / 3.1415927f - this.renderYawOffset) * 0.1f;
            this.rotationYaw = this.renderYawOffset;
            this.squidYaw += 3.1415927f * this.field_70871_bB * 1.5f;
            this.squidPitch += (-(float)Math.atan2(f, this.motionY) * 180.0f / 3.1415927f - this.squidPitch) * 0.1f;
        }
        else {
            this.tentacleAngle = MathHelper.abs(MathHelper.sin(this.squidRotation)) * 3.1415927f * 0.25f;
            if (!this.worldObj.isRemote) {
                this.motionX = 0.0;
                this.motionY -= 0.08;
                this.motionY *= 0.9800000190734863;
                this.motionZ = 0.0;
            }
            this.squidPitch += (float)((-90.0f - this.squidPitch) * 0.02);
        }
    }
    
    @Override
	public boolean canBreatheUnderwater() {
        return true;
    }
    
    @Override
	public boolean getCanSpawnHere() {
        return this.worldObj.checkNoEntityCollision(this.boundingBox);
    }
    
    @Override
	public int getTalkInterval() {
        return 120;
    }
    
    @Override
	protected boolean canDespawn() {
        return true;
    }
    
    @Override
	protected int getExperiencePoints(final EntityPlayer p_70693_1_) {
        return 1 + this.worldObj.rand.nextInt(3);
    }
    
    @Override
	public void onEntityUpdate() {
        int i = this.getAir();
        super.onEntityUpdate();
        if (this.isEntityAlive() && !this.isInWater()) {
            --i;
            this.setAir(i);
            if (this.getAir() == -20) {
                this.setAir(0);
                this.attackEntityFrom(DamageSource.drown, 2.0f);
            }
        }
        else {
            this.setAir(300);
        }
    }
    
    @Override
	public boolean isInWater() {
        return this.worldObj.handleMaterialAcceleration(this.boundingBox.expand(0.0, -0.6000000238418579, 0.0), Material.water, this);
    }
}
