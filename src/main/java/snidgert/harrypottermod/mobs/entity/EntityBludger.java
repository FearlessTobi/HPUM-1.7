package snidgert.harrypottermod.mobs.entity;

import java.util.Calendar;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import snidgert.harrypottermod.MainClass;

public class EntityBludger extends EntityMob
{
	private ChunkCoordinates currentFlightTarget;

	public EntityBludger(final World par1World) {
		super(par1World);
		this.setSize(0.8f, 0.8f);
		this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0));
		this.tasks.addTask(6, new EntityAIWander(this, 1.0));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	}

	public EntityBludger(final World par1World, final double par2, final double par4, final double par6) {
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
		this.dataWatcher.addObject(16, new Byte((byte)0));
	}

	@Override
	protected String getLivingSound() {
		return "harrypottermod:Bludger";
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
	public boolean canBePushed() {
		return false;
	}

	@Override
	protected Entity findPlayerToAttack() {
		final EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 1600.0);
		return (entityplayer != null && this.canEntityBeSeen(entityplayer)) ? entityplayer : null;
	}

	@Override
	protected void collideWithEntity(final Entity par1Entity) {
	}

	@Override
	protected void collideWithNearbyEntities() {
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(10.0);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.01);
	}

	public boolean getIsBatHanging() {
		return (this.dataWatcher.getWatchableObjectByte(16) & 0x1) != 0x0;
	}

	public void setIsBatHanging(final boolean par1) {
		final byte b0 = this.dataWatcher.getWatchableObjectByte(16);
		if (par1) {
			this.dataWatcher.updateObject(16, (byte)(b0 | 0x1));
		}
		else {
			this.dataWatcher.updateObject(16, (byte)(b0 & 0xFFFFFFFE));
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
		}
		else {
			this.motionY *= 0.6000000238418579;
		}
	}

	@Override
	protected void updateAITasks() {
		super.updateAITasks();
		if (this.currentFlightTarget != null && (!this.worldObj.isAirBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ) || this.currentFlightTarget.posY < 1)) {
			this.currentFlightTarget = null;
		}
		if (this.currentFlightTarget == null || this.rand.nextInt(30) == 0 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 4.0f) {
			this.currentFlightTarget = new ChunkCoordinates((int)this.posX + this.rand.nextInt(7) - this.rand.nextInt(7), (int)this.posY + this.rand.nextInt(6) - 2, (int)this.posZ + this.rand.nextInt(7) - this.rand.nextInt(7));
		}
		final double d0 = this.currentFlightTarget.posX + 0.5 - this.posX;
		final double d2 = this.currentFlightTarget.posY + 0.1 - this.posY;
		final double d3 = this.currentFlightTarget.posZ + 0.5 - this.posZ;
		this.motionX += (Math.signum(d0) * 0.5 - this.motionX) * 0.4000000014901161;
		this.motionY += (Math.signum(d2) * 0.299999988079071 - this.motionY) * 0.4000000014901161;
		this.motionZ += (Math.signum(d3) * 0.5 - this.motionZ) * 0.4000000014901161;
		final float f = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) - 90.0f;
		final float f2 = MathHelper.wrapAngleTo180_float(f - this.rotationYaw);
		this.moveForward = 0.5f;
		this.rotationYaw += f2;
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

	@Override
	public boolean getCanSpawnHere() {
		final int i = MathHelper.floor_double(this.boundingBox.minY);
		if (i >= 63) {
			return false;
		}
		final int j = MathHelper.floor_double(this.posX);
		final int k = MathHelper.floor_double(this.posZ);
		final int l = this.worldObj.getBlockLightValue(j, i, k);
		byte b0 = 4;
		final Calendar calendar = this.worldObj.getCurrentDate();
		if ((calendar.get(2) + 1 != 10 || calendar.get(5) < 20) && (calendar.get(2) + 1 != 11 || calendar.get(5) > 3)) {
			if (this.rand.nextBoolean()) {
				return false;
			}
		}
		else {
			b0 = 7;
		}
		return l <= this.rand.nextInt(b0) && super.getCanSpawnHere();
	}

	@Override
	protected void dropFewItems(final boolean par1, final int par2) {
		this.dropItem(MainClass.Bludger, 1);
	}

	@Override
	public boolean interact(final EntityPlayer par1EntityPlayer) {
		par1EntityPlayer.inventory.addItemStackToInventory(new ItemStack(MainClass.Bludger, 1));
		this.setDead();
		return true;
	}
}
