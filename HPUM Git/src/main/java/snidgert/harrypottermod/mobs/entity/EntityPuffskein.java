package snidgert.harrypottermod.mobs.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;

public class EntityPuffskein extends EntityLiving implements IMob
{
	public float squishAmount;
	public float squishFactor;
	public float prevSquishFactor;
	private int slimeJumpDelay;
	private static final String __OBFID = "CL_00001698";

	public EntityPuffskein(final World p_i1742_1_) {
		super(p_i1742_1_);
		final int i = 1 << this.rand.nextInt(3);
		this.yOffset = 0.0f;
		this.slimeJumpDelay = this.rand.nextInt(20) + 10;
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte)1));
	}

	public int getSlimeSize() {
		return this.dataWatcher.getWatchableObjectByte(16);
	}

	@Override
	public void writeEntityToNBT(final NBTTagCompound p_70014_1_) {
		super.writeEntityToNBT(p_70014_1_);
		p_70014_1_.setInteger("Size", this.getSlimeSize() - 1);
	}

	protected String getSlimeParticle() {
		return "slime";
	}

	protected String getJumpSound() {
		return "mob.slime." + ((this.getSlimeSize() > 1) ? "big" : "small");
	}

	@Override
	public void onUpdate() {
		if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL && this.getSlimeSize() > 0) {
			this.isDead = true;
		}
		this.squishFactor += (this.squishAmount - this.squishFactor) * 0.5f;
		this.prevSquishFactor = this.squishFactor;
		final boolean flag = this.onGround;
		super.onUpdate();
		if (this.onGround && !flag) {
			for (int i = this.getSlimeSize(), j = 0; j < i * 8; ++j) {
				final float f = this.rand.nextFloat() * 3.1415927f * 2.0f;
				final float f2 = this.rand.nextFloat() * 0.5f + 0.5f;
				final float f3 = MathHelper.sin(f) * i * 0.5f * f2;
				final float f4 = MathHelper.cos(f) * i * 0.5f * f2;
			}
			if (this.makesSoundOnLand()) {
				this.playSound(this.getJumpSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f) / 0.8f);
			}
			this.squishAmount = -0.5f;
		}
		else if (!this.onGround && flag) {
			this.squishAmount = 1.0f;
		}
		this.alterSquishAmount();
		if (this.worldObj.isRemote) {
			final int i = this.getSlimeSize();
			this.setSize(0.6f * i, 0.6f * i);
		}
	}

	@Override
	protected void updateEntityActionState() {
		this.despawnEntity();
		final EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0);
		if (entityplayer != null) {
			this.faceEntity(entityplayer, 10.0f, 20.0f);
		}
		if (this.onGround && this.slimeJumpDelay-- <= 0) {
			this.slimeJumpDelay = this.getJumpDelay();
			if (entityplayer != null) {
				this.slimeJumpDelay /= 3;
			}
			this.isJumping = true;
			if (this.makesSoundOnJump()) {
				this.playSound(this.getJumpSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f) * 0.8f);
			}
			this.moveStrafing = 1.0f - this.rand.nextFloat() * 2.0f;
			this.moveForward = 1 * this.getSlimeSize();
		}
		else {
			this.isJumping = false;
			if (this.onGround) {
				final float n = 0.0f;
				this.moveForward = n;
				this.moveStrafing = n;
			}
		}
	}

	protected void alterSquishAmount() {
		this.squishAmount *= 0.6f;
	}

	protected int getJumpDelay() {
		return this.rand.nextInt(20) + 10;
	}

	protected EntityPuffskein createInstance() {
		return new EntityPuffskein(this.worldObj);
	}

	@Override
	public void onCollideWithPlayer(final EntityPlayer p_70100_1_) {
		if (this.canDamagePlayer()) {
			final int i = this.getSlimeSize();
			if (this.canEntityBeSeen(p_70100_1_) && this.getDistanceSqToEntity(p_70100_1_) < 0.6 * i * 0.6 * i && p_70100_1_.attackEntityFrom(DamageSource.causeMobDamage(this), this.getAttackStrength())) {
				this.playSound("mob.attack", 1.0f, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
			}
		}
	}

	protected boolean canDamagePlayer() {
		return this.getSlimeSize() > 1;
	}

	protected int getAttackStrength() {
		return this.getSlimeSize();
	}

	@Override
	protected String getHurtSound() {
		return "mob.slime." + ((this.getSlimeSize() > 1) ? "big" : "small");
	}

	@Override
	protected String getDeathSound() {
		return "mob.slime." + ((this.getSlimeSize() > 1) ? "big" : "small");
	}

	@Override
	public boolean getCanSpawnHere() {
		final Chunk chunk = this.worldObj.getChunkFromBlockCoords(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posZ));
		if (this.worldObj.getWorldInfo().getTerrainType().handleSlimeSpawnReduction(this.rand, this.worldObj)) {
			return false;
		}
		if (this.getSlimeSize() == 1 || this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
			final BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posZ));
			if (biomegenbase == BiomeGenBase.swampland && this.posY > 50.0 && this.posY < 70.0 && this.rand.nextFloat() < 0.5f && this.rand.nextFloat() < this.worldObj.getCurrentMoonPhaseFactor() && this.worldObj.getBlockLightValue(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) <= this.rand.nextInt(8)) {
				return super.getCanSpawnHere();
			}
			if (this.rand.nextInt(10) == 0 && chunk.getRandomWithSeed(987234911L).nextInt(10) == 0 && this.posY < 40.0) {
				return super.getCanSpawnHere();
			}
		}
		return false;
	}

	@Override
	protected float getSoundVolume() {
		return 0.4f * this.getSlimeSize();
	}

	@Override
	public int getVerticalFaceSpeed() {
		return 0;
	}

	protected boolean makesSoundOnJump() {
		return this.getSlimeSize() > 0;
	}

	protected boolean makesSoundOnLand() {
		return this.getSlimeSize() > 2;
	}
}
