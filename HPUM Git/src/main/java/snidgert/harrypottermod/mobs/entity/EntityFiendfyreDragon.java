package snidgert.harrypottermod.mobs.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityFiendfyreDragon extends EntityMob {
	private float heightOffset;
	private int heightOffsetUpdateTime;
	private int field_70846_g;
	private ChunkCoordinates currentFlightTarget;

	public EntityFiendfyreDragon(final World par1World) {
		super(par1World);
		this.heightOffset = 0.5f;
		this.setSize(4.0f, 4.0f);
		this.experienceValue = 10;
	}

	public EntityFiendfyreDragon(final World par1World, final double par2, final double par4, final double par6) {
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
	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte) 0));
	}

	@Override
	public boolean isBurning() {
		return true;
	}

	@Override
	protected void attackEntity(final Entity par1Entity, final float par2) {
		if (this.attackTime <= 0 && par2 < 2.0f && par1Entity.boundingBox.maxY > this.boundingBox.minY && par1Entity.boundingBox.minY < this.boundingBox.maxY) {
			this.attackTime = 20;
			this.attackEntityAsMob(par1Entity);
		} else if (par2 < 30.0f) {
			final double var3 = par1Entity.posX - this.posX;
			final double var4 = par1Entity.boundingBox.minY + par1Entity.height / 2.0f - (this.posY + this.height / 2.0f);
			final double var5 = par1Entity.posZ - this.posZ;
			if (this.attackTime == 0) {
				++this.field_70846_g;
				if (this.field_70846_g == 1) {
					this.attackTime = 60;
					this.func_70844_e(true);
				} else if (this.field_70846_g <= 4) {
					this.attackTime = 6;
				} else {
					this.attackTime = 100;
					this.field_70846_g = 0;
					this.func_70844_e(false);
				}
				if (this.field_70846_g > 1) {
					final float var6 = MathHelper.sqrt_float(par2) * 0.5f;
					this.worldObj.playAuxSFXAtEntity((EntityPlayer) null, 1009, (int) this.posX, (int) this.posY, (int) this.posZ, 0);
					for (int var7 = 0; var7 < 1; ++var7) {
						final EntitySmallFireball var8 = new EntitySmallFireball(this.worldObj, this, var3 + this.rand.nextGaussian() * var6, var4, var5 + this.rand.nextGaussian() * var6);
						((Entity) var8).posY = this.posY + this.height / 2.0f + 0.5;
						this.worldObj.spawnEntityInWorld(var8);
					}
				}
			}
			this.rotationYaw = (float) (Math.atan2(var5, var3) * 180.0 / 3.141592653589793) - 90.0f;
			this.hasAttacked = true;
		}
	}

	public void func_70844_e(final boolean par1) {
		byte var2 = this.dataWatcher.getWatchableObjectByte(16);
		if (par1) {
			var2 |= 0x1;
		} else {
			var2 &= 0xFFFFFFFE;
		}
		this.dataWatcher.updateObject(16, var2);
	}

	public boolean func_70845_n() {
		return (this.dataWatcher.getWatchableObjectByte(16) & 0x1) != 0x0;
	}

	@Override
	public boolean canBePushed() {
		return false;
	}

	@Override
	protected void collideWithNearbyEntities() {
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(6.0);
	}

	public boolean getIsBatHanging() {
		return (this.dataWatcher.getWatchableObjectByte(16) & 0x1) != 0x0;
	}

	public void setIsBatHanging(final boolean par1) {
		final byte b0 = this.dataWatcher.getWatchableObjectByte(16);
		if (par1) {
			this.dataWatcher.updateObject(16, (byte) (b0 | 0x1));
		} else {
			this.dataWatcher.updateObject(16, (byte) (b0 & 0xFFFFFFFE));
		}
	}

	@Override
	protected boolean isAIEnabled() {
		return true;
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		if (this.getIsBatHanging()) {
			final double motionX = 0.0;
			this.motionZ = motionX;
			this.motionY = motionX;
			this.motionX = motionX;
			this.posY = MathHelper.floor_double(this.posY) + 1.0 - this.height;
		} else {
			this.motionY *= 0.6000000238418579;
		}
		final EntityPlayer player = this.worldObj.getClosestPlayer(this.posX, this.posY, this.posZ, 9.9999999999E10);
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

	protected String getAngrySoundName() {
		return null;
	}

	@Override
	protected void func_145780_a(final int p_145780_1_, final int p_145780_2_, final int p_145780_3_, final Block p_145780_4_) {
	}

	@Override
	protected void updateAITasks() {
		super.updateAITasks();
		if (this.getIsBatHanging()) {
			if (this.rand.nextInt(200) == 0) {
				this.rotationYawHead = this.rand.nextInt(360);
			}
			if (this.worldObj.getClosestPlayerToEntity(this, 4.0) != null) {
				this.setIsBatHanging(false);
				this.worldObj.playAuxSFXAtEntity((EntityPlayer) null, 1015, (int) this.posX, (int) this.posY, (int) this.posZ, 0);
			}
		} else {
			if (this.currentFlightTarget != null
					&& (!this.worldObj.isAirBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ) || this.currentFlightTarget.posY < 1)) {
				this.currentFlightTarget = null;
			}
			if (this.currentFlightTarget == null || this.rand.nextInt(30) == 0 || this.currentFlightTarget.getDistanceSquared((int) this.posX, (int) this.posY, (int) this.posZ) < 4.0f) {
				this.currentFlightTarget = new ChunkCoordinates((int) this.posX + this.rand.nextInt(7) - this.rand.nextInt(7), (int) this.posY + this.rand.nextInt(6) - 2,
						(int) this.posZ + this.rand.nextInt(7) - this.rand.nextInt(7));
			}
			final double d0 = this.currentFlightTarget.posX + 0.5 - this.posX;
			final double d2 = this.currentFlightTarget.posY + 0.1 - this.posY;
			final double d3 = this.currentFlightTarget.posZ + 0.5 - this.posZ;
			this.motionX += (Math.signum(d0) * 0.5 - this.motionX) * 0.10000000149011612;
			this.motionY += (Math.signum(d2) * 0.699999988079071 - this.motionY) * 0.10000000149011612;
			this.motionZ += (Math.signum(d3) * 0.5 - this.motionZ) * 0.10000000149011612;
			final float f = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) - 90.0f;
			final float f2 = MathHelper.wrapAngleTo180_float(f - this.rotationYaw);
			this.moveForward = 0.5f;
			this.rotationYaw += f2;
		}
	}

	@Override
	protected boolean canTriggerWalking() {
		return false;
	}

	@Override
	protected void fall(final float par1) {
	}

	@Override
	protected void updateFallState(final double par1, final boolean par3) {
	}

	@Override
	public boolean doesEntityNotTriggerPressurePlate() {
		return true;
	}

	@Override
	public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
		if (this.isEntityInvulnerable()) {
			return false;
		}
		if (!this.worldObj.isRemote && this.getIsBatHanging()) {
			this.setIsBatHanging(false);
		}
		return super.attackEntityFrom(par1DamageSource, par2);
	}

	@Override
	public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);
		this.dataWatcher.updateObject(16, par1NBTTagCompound.getByte("BatFlags"));
	}

	@Override
	public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setByte("BatFlags", this.dataWatcher.getWatchableObjectByte(16));
	}
}
