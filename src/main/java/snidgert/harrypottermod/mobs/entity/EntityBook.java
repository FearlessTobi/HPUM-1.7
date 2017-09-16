package snidgert.harrypottermod.mobs.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import snidgert.harrypottermod.projectiles.StupefyProjectile;

public class EntityBook extends EntityMob
{
	private float heightOffset;
	private int heightOffsetUpdateTime;
	private int field_70846_g;

	public EntityBook(final World par1World) {
		super(par1World);
		this.heightOffset = 0.5f;
		this.experienceValue = 10;
	}

	public EntityBook(final World par1World, final double par2, final double par4, final double par6) {
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
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0);
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte)0));
	}

	@Override
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
		}
		if (!this.onGround && this.motionY < 0.0) {
			this.motionY *= 0.6;
		}
		super.onLivingUpdate();
	}

	@Override
	protected void attackEntity(final Entity par1Entity, final float par2) {
		if (this.attackTime <= 0 && par2 < 2.0f && par1Entity.boundingBox.maxY > this.boundingBox.minY && par1Entity.boundingBox.minY < this.boundingBox.maxY) {
			this.attackTime = 20;
			this.attackEntityAsMob(par1Entity);
		}
		else if (par2 < 30.0f) {
			final double var3 = par1Entity.posX - this.posX;
			final double var4 = par1Entity.boundingBox.minY + par1Entity.height / 2.0f - (this.posY + this.height / 2.0f);
			final double var5 = par1Entity.posZ - this.posZ;
			if (this.attackTime == 0) {
				++this.field_70846_g;
				if (this.field_70846_g == 1) {
					this.attackTime = 60;
					this.func_70844_e(true);
				}
				else if (this.field_70846_g <= 4) {
					this.attackTime = 6;
				}
				else {
					this.attackTime = 100;
					this.field_70846_g = 0;
					this.func_70844_e(false);
				}
				if (this.field_70846_g > 1) {
					final float var6 = MathHelper.sqrt_float(par2) * 0.5f;
					this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1009, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
					for (int var7 = 0; var7 < 1; ++var7) {
						final StupefyProjectile var8 = new StupefyProjectile(this.worldObj, this, var3 + this.rand.nextGaussian() * var6, var4, var5 + this.rand.nextGaussian() * var6);
						var8.posY = this.posY + this.height / 2.0f + 0.5;
						this.worldObj.spawnEntityInWorld(var8);
					}
				}
			}
			this.rotationYaw = (float)(Math.atan2(var5, var3) * 180.0 / 3.141592653589793) - 90.0f;
			this.hasAttacked = true;
		}
	}

	@Override
	protected void fall(final float par1) {
	}

	public boolean func_70845_n() {
		return (this.dataWatcher.getWatchableObjectByte(16) & 0x1) != 0x0;
	}

	public void func_70844_e(final boolean par1) {
		byte var2 = this.dataWatcher.getWatchableObjectByte(16);
		if (par1) {
			var2 |= 0x1;
		}
		else {
			var2 &= 0xFFFFFFFE;
		}
		this.dataWatcher.updateObject(16, var2);
	}

	@Override
	protected boolean isValidLightLevel() {
		return true;
	}
}
