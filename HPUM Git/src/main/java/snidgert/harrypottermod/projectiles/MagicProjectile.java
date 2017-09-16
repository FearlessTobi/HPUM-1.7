package snidgert.harrypottermod.projectiles;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public abstract class MagicProjectile extends Entity
{
	private int field_145795_e;
	private int field_145793_f;
	private int field_145794_g;
	private Block field_145796_h;
	private boolean inGround;
	public EntityLivingBase shootingEntity;
	private int ticksAlive;
	private int ticksInAir;
	public double accelerationX;
	public double accelerationY;
	public double accelerationZ;
	private static final String __OBFID = "CL_00001717";

	public MagicProjectile(final World par1World) {
		super(par1World);
		this.field_145795_e = -1;
		this.field_145793_f = -1;
		this.field_145794_g = -1;
		this.setSize(1.0f, 1.0f);
	}

	@Override
	protected void entityInit() {
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean isInRangeToRenderDist(final double par1) {
		double d1 = super.boundingBox.getAverageEdgeLength() * 4.0;
		d1 *= 64.0;
		return par1 < d1 * d1;
	}

	public MagicProjectile(final World par1World, final double par2, final double par4, final double par6, final double par8, final double par10, final double par12) {
		super(par1World);
		this.field_145795_e = -1;
		this.field_145793_f = -1;
		this.field_145794_g = -1;
		this.setSize(1.0f, 1.0f);
		this.setLocationAndAngles(par2, par4, par6, super.rotationYaw, super.rotationPitch);
		this.setPosition(par2, par4, par6);
		final double d6 = MathHelper.sqrt_double(par8 * par8 + par10 * par10 + par12 * par12);
		this.accelerationX = par8 / d6 * 0.1;
		this.accelerationY = par10 / d6 * 0.1;
		this.accelerationZ = par12 / d6 * 0.1;
	}

	public MagicProjectile(final World par1World, final EntityLivingBase par2EntityLivingBase, double par3, double par5, double par7) {
		super(par1World);
		this.field_145795_e = -1;
		this.field_145793_f = -1;
		this.field_145794_g = -1;
		this.shootingEntity = par2EntityLivingBase;
		this.setSize(1.0f, 1.0f);
		this.setLocationAndAngles(((Entity)par2EntityLivingBase).posX, ((Entity)par2EntityLivingBase).posY, ((Entity)par2EntityLivingBase).posZ, ((Entity)par2EntityLivingBase).rotationYaw, ((Entity)par2EntityLivingBase).rotationPitch);
		this.setPosition(super.posX, super.posY, super.posZ);
		super.yOffset = 0.0f;
		final double motionX = 0.0;
		super.motionZ = motionX;
		super.motionY = motionX;
		super.motionX = motionX;
		par3 += super.rand.nextGaussian() * 0.4;
		par5 += super.rand.nextGaussian() * 0.4;
		par7 += super.rand.nextGaussian() * 0.4;
		final double d3 = MathHelper.sqrt_double(par3 * par3 + par5 * par5 + par7 * par7);
		this.accelerationX = par3 / d3 * 0.1;
		this.accelerationY = par5 / d3 * 0.1;
		this.accelerationZ = par7 / d3 * 0.1;
	}

	@Override
	public void onUpdate() {
		if (!super.worldObj.isRemote && ((this.shootingEntity != null && ((Entity)this.shootingEntity).isDead) || !super.worldObj.blockExists((int)super.posX, (int)super.posY, (int)super.posZ))) {
			this.setDead();
		}
		else {
			super.onUpdate();
			if (this.inGround) {
				if (super.worldObj.getBlock(this.field_145795_e, this.field_145793_f, this.field_145794_g) == this.field_145796_h) {
					++this.ticksAlive;
					if (this.ticksAlive == 200) {
						this.setDead();
					}
					return;
				}
				this.inGround = false;
				super.motionX *= super.rand.nextFloat() * 0.2f;
				super.motionY *= super.rand.nextFloat() * 0.2f;
				super.motionZ *= super.rand.nextFloat() * 0.2f;
				this.ticksAlive = 0;
				this.ticksInAir = 0;
			}
			else {
				++this.ticksInAir;
			}
			Vec3 vec3 = Vec3.createVectorHelper(super.posX, super.posY, super.posZ);
			Vec3 vec4 = Vec3.createVectorHelper(super.posX + super.motionX, super.posY + super.motionY, super.posZ + super.motionZ);
			MovingObjectPosition movingobjectposition = super.worldObj.rayTraceBlocks(vec3, vec4);
			vec3 = Vec3.createVectorHelper(super.posX, super.posY, super.posZ);
			vec4 = Vec3.createVectorHelper(super.posX + super.motionX, super.posY + super.motionY, super.posZ + super.motionZ);
			if (movingobjectposition != null) {
				vec4 = Vec3.createVectorHelper(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
			}
			Entity entity = null;
			final List list = super.worldObj.getEntitiesWithinAABBExcludingEntity(this, super.boundingBox.addCoord(super.motionX, super.motionY, super.motionZ).expand(1.0, 1.0, 1.0));
			double d0 = 0.0;
			for (int i = 0; i < list.size(); ++i) {
				final Entity entity2 = (Entity) list.get(i);
				if (entity2.canBeCollidedWith() && (!entity2.isEntityEqual(this.shootingEntity) || this.ticksInAir >= 25)) {
					final float f = 0.3f;
					final AxisAlignedBB axisalignedbb = entity2.boundingBox.expand(f, f, f);
					final MovingObjectPosition movingobjectposition2 = axisalignedbb.calculateIntercept(vec3, vec4);
					if (movingobjectposition2 != null) {
						final double d2 = vec3.distanceTo(movingobjectposition2.hitVec);
						if (d2 < d0 || d0 == 0.0) {
							entity = entity2;
							d0 = d2;
						}
					}
				}
			}
			if (entity != null) {
				movingobjectposition = new MovingObjectPosition(entity);
			}
			if (movingobjectposition != null) {
				this.onImpact(movingobjectposition);
			}
			super.posX += super.motionX;
			super.posY += super.motionY;
			super.posZ += super.motionZ;
			final float f2 = MathHelper.sqrt_double(super.motionX * super.motionX + super.motionZ * super.motionZ);
			super.rotationYaw = (float)(Math.atan2(super.motionZ, super.motionX) * 180.0 / 3.141592653589793) + 90.0f;
			super.rotationPitch = (float)(Math.atan2(f2, super.motionY) * 180.0 / 3.141592653589793) - 90.0f;
			while (super.rotationPitch - super.prevRotationPitch < -180.0f) {
				super.prevRotationPitch -= 360.0f;
			}
			while (super.rotationPitch - super.prevRotationPitch >= 180.0f) {
				super.prevRotationPitch += 360.0f;
			}
			while (super.rotationYaw - super.prevRotationYaw < -180.0f) {
				super.prevRotationYaw -= 360.0f;
			}
			while (super.rotationYaw - super.prevRotationYaw >= 180.0f) {
				super.prevRotationYaw += 360.0f;
			}
			super.rotationPitch = super.prevRotationPitch + (super.rotationPitch - super.prevRotationPitch) * 0.2f;
			super.rotationYaw = super.prevRotationYaw + (super.rotationYaw - super.prevRotationYaw) * 0.2f;
			float f3 = this.getMotionFactor();
			if (this.isInWater()) {
				for (int j = 0; j < 4; ++j) {
					final float f4 = 0.25f;
					super.worldObj.spawnParticle("bubble", super.posX - super.motionX * f4, super.posY - super.motionY * f4, super.posZ - super.motionZ * f4, super.motionX, super.motionY, super.motionZ);
				}
				f3 = 0.8f;
			}
			super.motionX += this.accelerationX;
			super.motionY += this.accelerationY;
			super.motionZ += this.accelerationZ;
			super.motionX *= f3;
			super.motionY *= f3;
			super.motionZ *= f3;
			this.setPosition(super.posX, super.posY, super.posZ);
		}
	}

	protected float getMotionFactor() {
		return 0.95f;
	}

	protected abstract void onImpact(final MovingObjectPosition p0);

	@Override
	public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
		par1NBTTagCompound.setShort("xTile", (short)this.field_145795_e);
		par1NBTTagCompound.setShort("yTile", (short)this.field_145793_f);
		par1NBTTagCompound.setShort("zTile", (short)this.field_145794_g);
		par1NBTTagCompound.setByte("inTile", (byte)Block.getIdFromBlock(this.field_145796_h));
		par1NBTTagCompound.setByte("inGround", (byte)(this.inGround ? 1 : 0));
		par1NBTTagCompound.setTag("direction", this.newDoubleNBTList(new double[] { super.motionX, super.motionY, super.motionZ }));
	}

	@Override
	public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
		this.field_145795_e = par1NBTTagCompound.getShort("xTile");
		this.field_145793_f = par1NBTTagCompound.getShort("yTile");
		this.field_145794_g = par1NBTTagCompound.getShort("zTile");
		this.field_145796_h = Block.getBlockById(par1NBTTagCompound.getByte("inTile") & 0xFF);
		this.inGround = (par1NBTTagCompound.getByte("inGround") == 1);
		if (par1NBTTagCompound.hasKey("direction", 9)) {
			final NBTTagList nbttaglist = par1NBTTagCompound.getTagList("direction", 6);
			super.motionX = nbttaglist.func_150309_d(0);
			super.motionY = nbttaglist.func_150309_d(1);
			super.motionZ = nbttaglist.func_150309_d(2);
		}
		else {
			this.setDead();
		}
	}

	@Override
	public boolean canBeCollidedWith() {
		return true;
	}

	@Override
	public float getCollisionBorderSize() {
		return 1.0f;
	}

	@Override
	public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
		if (this.isEntityInvulnerable()) {
			return false;
		}
		this.setBeenAttacked();
		if (par1DamageSource.getEntity() != null) {
			final Vec3 vec3 = par1DamageSource.getEntity().getLookVec();
			if (vec3 != null) {
				super.motionX = vec3.xCoord;
				super.motionY = vec3.yCoord;
				super.motionZ = vec3.zCoord;
				this.accelerationX = super.motionX * 0.1;
				this.accelerationY = super.motionY * 0.1;
				this.accelerationZ = super.motionZ * 0.1;
			}
			if (par1DamageSource.getEntity() instanceof EntityLivingBase) {
				this.shootingEntity = (EntityLivingBase)par1DamageSource.getEntity();
			}
			return true;
		}
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float getShadowSize() {
		return 0.0f;
	}

	@Override
	public float getBrightness(final float par1) {
		return 1.0f;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getBrightnessForRender(final float par1) {
		return 15728880;
	}
}
