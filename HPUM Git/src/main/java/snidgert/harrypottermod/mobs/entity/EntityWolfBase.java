package snidgert.harrypottermod.mobs.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityWolfBase extends EntityTameable
{
	public float field_70926_e;
	public float field_70924_f;
	/** true is the wolf is wet else false */
	public boolean isShaking;
	public boolean field_70928_h;
	/** This time increases while wolf is shaking and emitting water particles. */
	public float timeWolfIsShaking;
	public float prevTimeWolfIsShaking;

	public EntityWolfBase(World p_i1696_1_)
	{
		super(p_i1696_1_);
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896D);

		if (this.isTamed())
		{
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		}
		else
		{
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(8.0D);
		}
	}

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	@Override
	public boolean isAIEnabled()
	{
		return true;
	}

	/**
	 * Sets the active target the Task system uses for tracking
	 */
	@Override
	public void setAttackTarget(EntityLivingBase p_70624_1_)
	{
		super.setAttackTarget(p_70624_1_);

		if (p_70624_1_ == null)
		{
			this.setAngry(false);
		}
		else if (!this.isTamed())
		{
			this.setAngry(true);
		}
	}

	/**
	 * main AI tick function, replaces updateEntityActionState
	 */
	@Override
	protected void updateAITick()
	{
		this.dataWatcher.updateObject(18, Float.valueOf(this.getHealth()));
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	@Override
	public void writeEntityToNBT(NBTTagCompound p_70014_1_)
	{
		super.writeEntityToNBT(p_70014_1_);
		p_70014_1_.setBoolean("Angry", this.isAngry());
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	@Override
	public void readEntityFromNBT(NBTTagCompound p_70037_1_)
	{
		super.readEntityFromNBT(p_70037_1_);
		this.setAngry(p_70037_1_.getBoolean("Angry"));
	}

	@Override
	protected Item getDropItem()
	{
		return Item.getItemById(-1);
	}

	/**
	 * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
	 * use this to react to sunlight and start to burn.
	 */
	@Override
	public void onLivingUpdate()
	{
		super.onLivingUpdate();

		if (!this.worldObj.isRemote && this.isShaking && !this.field_70928_h && !this.hasPath() && this.onGround)
		{
			this.field_70928_h = true;
			this.timeWolfIsShaking = 0.0F;
			this.prevTimeWolfIsShaking = 0.0F;
			this.worldObj.setEntityState(this, (byte)8);
		}
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	@Override
	public void onUpdate()
	{
		super.onUpdate();
		this.field_70924_f = this.field_70926_e;

		if (this.func_70922_bv())
		{
			this.field_70926_e += (1.0F - this.field_70926_e) * 0.4F;
		}
		else
		{
			this.field_70926_e += (0.0F - this.field_70926_e) * 0.4F;
		}

		if (this.func_70922_bv())
		{
			this.numTicksToChaseTarget = 10;
		}

		if (this.isWet())
		{
			this.isShaking = true;
			this.field_70928_h = false;
			this.timeWolfIsShaking = 0.0F;
			this.prevTimeWolfIsShaking = 0.0F;
		}
		else if ((this.isShaking || this.field_70928_h) && this.field_70928_h)
		{
			if (this.timeWolfIsShaking == 0.0F)
			{
				this.playSound("mob.wolf.shake", this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
			}

			this.prevTimeWolfIsShaking = this.timeWolfIsShaking;
			this.timeWolfIsShaking += 0.05F;

			if (this.prevTimeWolfIsShaking >= 2.0F)
			{
				this.isShaking = false;
				this.field_70928_h = false;
				this.prevTimeWolfIsShaking = 0.0F;
				this.timeWolfIsShaking = 0.0F;
			}

			if (this.timeWolfIsShaking > 0.4F)
			{
				float f = (float)this.boundingBox.minY;
				int i = (int)(MathHelper.sin((this.timeWolfIsShaking - 0.4F) * (float)Math.PI) * 7.0F);

				for (int j = 0; j < i; ++j)
				{
					float f1 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
					float f2 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
					this.worldObj.spawnParticle("splash", this.posX + f1, f + 0.8F, this.posZ + f2, this.motionX, this.motionY, this.motionZ);
				}
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public boolean getWolfShaking()
	{
		return this.isShaking;
	}

	/**
	 * Used when calculating the amount of shading to apply while the wolf is shaking.
	 */
	@SideOnly(Side.CLIENT)
	public float getShadingWhileShaking(float p_70915_1_)
	{
		return 0.75F + (this.prevTimeWolfIsShaking + (this.timeWolfIsShaking - this.prevTimeWolfIsShaking) * p_70915_1_) / 2.0F * 0.25F;
	}

	@SideOnly(Side.CLIENT)
	public float getShakeAngle(float p_70923_1_, float p_70923_2_)
	{
		float f2 = (this.prevTimeWolfIsShaking + (this.timeWolfIsShaking - this.prevTimeWolfIsShaking) * p_70923_1_ + p_70923_2_) / 1.8F;

		if (f2 < 0.0F)
		{
			f2 = 0.0F;
		}
		else if (f2 > 1.0F)
		{
			f2 = 1.0F;
		}

		return MathHelper.sin(f2 * (float)Math.PI) * MathHelper.sin(f2 * (float)Math.PI * 11.0F) * 0.15F * (float)Math.PI;
	}

	@Override
	public float getEyeHeight()
	{
		return this.height * 0.8F;
	}

	@SideOnly(Side.CLIENT)
	public float getInterestedAngle(float p_70917_1_)
	{
		return (this.field_70924_f + (this.field_70926_e - this.field_70924_f) * p_70917_1_) * 0.15F * (float)Math.PI;
	}

	/**
	 * The speed it takes to move the entityliving's rotationPitch through the faceEntity method. This is only currently
	 * use in wolves.
	 */
	@Override
	public int getVerticalFaceSpeed()
	{
		return this.isSitting() ? 20 : super.getVerticalFaceSpeed();
	}

	/**
	 * Called when the entity is attacked.
	 */
	@Override
	public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_)
	{
		if (this.isEntityInvulnerable())
		{
			return false;
		}
		else
		{
			Entity entity = p_70097_1_.getEntity();
			this.aiSit.setSitting(false);

			if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow))
			{
				p_70097_2_ = (p_70097_2_ + 1.0F) / 2.0F;
			}

			return super.attackEntityFrom(p_70097_1_, p_70097_2_);
		}
	}

	@Override
	public boolean attackEntityAsMob(Entity p_70652_1_)
	{
		int i = this.isTamed() ? 4 : 2;
		p_70652_1_.motionX += 10.400000005960464;
		p_70652_1_.motionZ += 10.400000005960464;
		return p_70652_1_.attackEntityFrom(DamageSource.causeMobDamage(this), i);
	}

	@Override
	public void setTamed(boolean p_70903_1_)
	{
		super.setTamed(p_70903_1_);

		if (p_70903_1_)
		{
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		}
		else
		{
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(8.0D);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void handleHealthUpdate(byte p_70103_1_)
	{
		if (p_70103_1_ == 8)
		{
			this.field_70928_h = true;
			this.timeWolfIsShaking = 0.0F;
			this.prevTimeWolfIsShaking = 0.0F;
		}
		else
		{
			super.handleHealthUpdate(p_70103_1_);
		}
	}

	@SideOnly(Side.CLIENT)
	public float getTailRotation()
	{
		return this.isAngry() ? 1.5393804F : (this.isTamed() ? (0.55F - (20.0F - this.dataWatcher.getWatchableObjectFloat(18)) * 0.02F) * (float)Math.PI : ((float)Math.PI / 5F));
	}

	/**
	 * Will return how many at most can spawn in a chunk at once.
	 */
	@Override
	public int getMaxSpawnedInChunk()
	{
		return 8;
	}

	/**
	 * Determines whether this wolf is angry or not.
	 */
	public boolean isAngry()
	{
		return (this.dataWatcher.getWatchableObjectByte(16) & 2) != 0;
	}

	/**
	 * Sets whether this wolf is angry or not.
	 */
	public void setAngry(boolean p_70916_1_)
	{
		byte b0 = this.dataWatcher.getWatchableObjectByte(16);

		if (p_70916_1_)
		{
			this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 2)));
		}
		else
		{
			this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & -3)));
		}
	}

	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_)
	{
		EntityWolfBase entitywolf = new EntityWolfBase(this.worldObj);
		String s = this.func_152113_b();

		if (s != null && s.trim().length() > 0)
		{
			entitywolf.func_152115_b(s);
			entitywolf.setTamed(true);
		}

		return entitywolf;
	}

	public void func_70918_i(boolean p_70918_1_)
	{
		if (p_70918_1_)
		{
			this.dataWatcher.updateObject(19, Byte.valueOf((byte)1));
		}
		else
		{
			this.dataWatcher.updateObject(19, Byte.valueOf((byte)0));
		}
	}

	/**
	 * Returns true if the mob is currently able to mate with the specified mob.
	 */
	@Override
	public boolean canMateWith(EntityAnimal p_70878_1_)
	{
		if (p_70878_1_ == this)
		{
			return false;
		}
		else if (!this.isTamed())
		{
			return false;
		}
		else if (!(p_70878_1_ instanceof EntityWolfBase))
		{
			return false;
		}
		else
		{
			EntityWolfBase entitywolf = (EntityWolfBase)p_70878_1_;
			return !entitywolf.isTamed() ? false : (entitywolf.isSitting() ? false : this.isInLove() && entitywolf.isInLove());
		}
	}

	public boolean func_70922_bv()
	{
		return this.dataWatcher.getWatchableObjectByte(19) == 1;
	}

	/**
	 * Determines if an entity can be despawned, used on idle far away entities
	 */
	@Override
	protected boolean canDespawn()
	{
		return !this.isTamed() && this.ticksExisted > 2400;
	}

	@Override
	public boolean func_142018_a(EntityLivingBase p_142018_1_, EntityLivingBase p_142018_2_)
	{
		if (!(p_142018_1_ instanceof EntityCreeper) && !(p_142018_1_ instanceof EntityGhast))
		{
			if (p_142018_1_ instanceof EntityWolfBase)
			{
				EntityWolfBase entitywolf = (EntityWolfBase)p_142018_1_;

				if (entitywolf.isTamed() && entitywolf.getOwner() == p_142018_2_)
				{
					return false;
				}
			}

			return p_142018_1_ instanceof EntityPlayer && p_142018_2_ instanceof EntityPlayer && !((EntityPlayer)p_142018_2_).canAttackPlayer((EntityPlayer)p_142018_1_) ? false : !(p_142018_1_ instanceof EntityHorse) || !((EntityHorse)p_142018_1_).isTame();
		}
		else
		{
			return false;
		}
	}
}