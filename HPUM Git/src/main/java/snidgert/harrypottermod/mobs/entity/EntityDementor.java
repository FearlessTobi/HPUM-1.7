package snidgert.harrypottermod.mobs.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityDementor extends EntityMob
{
	private float heightOffset;
	private int heightOffsetUpdateTime;
	private int field_70846_g;

	public EntityDementor(final World par1World) {
		super(par1World);
		this.heightOffset = 0.5f;
		this.isImmuneToFire = true;
		this.experienceValue = 10;
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 2.0, false));
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
			if (this.worldObj.getBlockMetadata(j, k, l) == 0 && this.worldObj.getBiomeGenForCoords(j, l).getFloatTemperature(l, l, l) < 0.8f && Blocks.snow_layer.canPlaceBlockAt(this.worldObj, j, k, l)) {
				if (this.worldObj.getBlock(j, k, l) != Blocks.snow_layer) {
					this.setPosition(this.posX, this.posY + 0.2, this.posZ);
					this.worldObj.setBlock(j, k, l, Blocks.snow_layer);
				}
			}
			if (this.worldObj.getBlock(j + 1, k, l) == Blocks.water) {
				this.worldObj.setBlock(j + 1, k, l, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j + 2, k, l) == Blocks.water) {
				this.worldObj.setBlock(j + 2, k, l, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j - 1, k, l) == Blocks.water) {
				this.worldObj.setBlock(j - 1, k, l, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j - 2, k, l) == Blocks.water) {
				this.worldObj.setBlock(j - 2, k, l, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j, k, l - 1) == Blocks.water) {
				this.worldObj.setBlock(j, k, l - 1, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j, k, l - 2) == Blocks.water) {
				this.worldObj.setBlock(j, k, l - 2, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j, k, l + 1) == Blocks.water) {
				this.worldObj.setBlock(j, k, l + 1, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j, k, l + 2) == Blocks.water) {
				this.worldObj.setBlock(j, k, l + 2, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j + 1, k, l - 1) == Blocks.water) {
				this.worldObj.setBlock(j + 1, k, l - 1, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j + 2, k, l - 1) == Blocks.water) {
				this.worldObj.setBlock(j + 2, k, l - 1, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j - 1, k, l - 1) == Blocks.water) {
				this.worldObj.setBlock(j - 1, k, l - 1, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j - 2, k, l - 1) == Blocks.water) {
				this.worldObj.setBlock(j - 2, k, l - 1, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j - 1, k, l + 1) == Blocks.water) {
				this.worldObj.setBlock(j - 1, k, l + 1, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j - 1, k, l - 2) == Blocks.water) {
				this.worldObj.setBlock(j - 1, k, l - 2, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j + 1, k, l + 1) == Blocks.water) {
				this.worldObj.setBlock(j + 1, k, l + 1, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j - 1, k, l + 2) == Blocks.water) {
				this.worldObj.setBlock(j - 1, k, l + 2, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j - 2, k, l - 2) == Blocks.water) {
				this.worldObj.setBlock(j - 2, k, l - 2, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j + 2, k, l - 2) == Blocks.water) {
				this.worldObj.setBlock(j + 2, k, l - 2, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j - 2, k, l + 2) == Blocks.water) {
				this.worldObj.setBlock(j - 2, k, l + 2, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j + 2, k, l + 2) == Blocks.water) {
				this.worldObj.setBlock(j + 2, k, l + 2, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j + 1, k, l + 2) == Blocks.water) {
				this.worldObj.setBlock(j + 1, k, l + 2, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j + 2, k, l + 1) == Blocks.water) {
				this.worldObj.setBlock(j + 2, k, l + 1, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j + 1, k, l - 2) == Blocks.water) {
				this.worldObj.setBlock(j + 1, k, l - 2, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j - 2, k, l + 1) == Blocks.water) {
				this.worldObj.setBlock(j - 2, k, l + 1, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j, k - 1, l) == Blocks.water) {
				this.worldObj.setBlock(j, k - 1, l, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j + 1, k - 1, l) == Blocks.water) {
				this.worldObj.setBlock(j + 1, k - 1, l, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j + 2, k - 1, l) == Blocks.water) {
				this.worldObj.setBlock(j + 2, k - 1, l, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j - 1, k - 1, l) == Blocks.water) {
				this.worldObj.setBlock(j - 1, k - 1, l, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j - 2, k - 1, l) == Blocks.water) {
				this.worldObj.setBlock(j - 2, k - 1, l, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j, k - 1, l - 1) == Blocks.water) {
				this.worldObj.setBlock(j, k - 1, l - 1, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j, k - 1, l - 2) == Blocks.water) {
				this.worldObj.setBlock(j, k - 1, l - 2, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j, k - 1, l + 1) == Blocks.water) {
				this.worldObj.setBlock(j, k - 1, l + 1, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j, k - 1, l + 2) == Blocks.water) {
				this.worldObj.setBlock(j, k - 1, l + 2, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j + 1, k - 1, l - 1) == Blocks.water) {
				this.worldObj.setBlock(j + 1, k - 1, l - 1, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j + 2, k - 1, l - 1) == Blocks.water) {
				this.worldObj.setBlock(j + 2, k - 1, l - 1, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j - 1, k - 1, l - 1) == Blocks.water) {
				this.worldObj.setBlock(j - 1, k - 1, l - 1, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j - 2, k - 1, l - 1) == Blocks.water) {
				this.worldObj.setBlock(j - 2, k - 1, l - 1, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j - 1, k - 1, l + 1) == Blocks.water) {
				this.worldObj.setBlock(j - 1, k - 1, l + 1, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j - 1, k - 1, l - 2) == Blocks.water) {
				this.worldObj.setBlock(j - 1, k - 1, l - 2, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j + 1, k - 1, l + 1) == Blocks.water) {
				this.worldObj.setBlock(j + 1, k - 1, l + 1, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j - 1, k - 1, l + 2) == Blocks.water) {
				this.worldObj.setBlock(j - 1, k - 1, l + 2, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j - 2, k - 1, l - 2) == Blocks.water) {
				this.worldObj.setBlock(j - 2, k - 1, l - 2, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j + 2, k - 1, l - 2) == Blocks.water) {
				this.worldObj.setBlock(j + 2, k - 1, l - 2, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j - 2, k - 1, l + 2) == Blocks.water) {
				this.worldObj.setBlock(j - 2, k - 1, l + 2, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j + 2, k - 1, l + 2) == Blocks.water) {
				this.worldObj.setBlock(j + 2, k - 1, l + 2, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j + 1, k - 1, l + 2) == Blocks.water) {
				this.worldObj.setBlock(j + 1, k - 1, l + 2, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j + 2, k - 1, l + 1) == Blocks.water) {
				this.worldObj.setBlock(j + 2, k - 1, l + 1, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j + 1, k - 1, l - 2) == Blocks.water) {
				this.worldObj.setBlock(j + 1, k - 1, l - 2, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j - 2, k - 1, l + 1) == Blocks.water) {
				this.worldObj.setBlock(j - 2, k - 1, l + 1, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j, k + 1, l) == Blocks.water) {
				this.worldObj.setBlock(j, k + 1, l, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j + 1, k + 1, l) == Blocks.water) {
				this.worldObj.setBlock(j + 1, k + 1, l, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j + 2, k + 1, l) == Blocks.water) {
				this.worldObj.setBlock(j + 2, k + 1, l, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j - 1, k + 1, l) == Blocks.water) {
				this.worldObj.setBlock(j - 1, k + 1, l, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j - 2, k + 1, l) == Blocks.water) {
				this.worldObj.setBlock(j - 2, k + 1, l, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j, k + 1, l - 1) == Blocks.water) {
				this.worldObj.setBlock(j, k + 1, l - 1, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j, k + 1, l - 2) == Blocks.water) {
				this.worldObj.setBlock(j, k + 1, l - 2, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j, k + 1, l + 1) == Blocks.water) {
				this.worldObj.setBlock(j, k + 1, l + 1, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j, k + 1, l + 2) == Blocks.water) {
				this.worldObj.setBlock(j, k + 1, l + 2, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j + 1, k + 1, l - 1) == Blocks.water) {
				this.worldObj.setBlock(j + 1, k + 1, l - 1, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j + 2, k + 1, l - 1) == Blocks.water) {
				this.worldObj.setBlock(j + 2, k + 1, l - 1, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j - 1, k + 1, l - 1) == Blocks.water) {
				this.worldObj.setBlock(j - 1, k + 1, l - 1, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j - 2, k + 1, l - 1) == Blocks.water) {
				this.worldObj.setBlock(j - 2, k + 1, l - 1, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j - 1, k + 1, l + 1) == Blocks.water) {
				this.worldObj.setBlock(j - 1, k + 1, l + 1, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j - 1, k + 1, l - 2) == Blocks.water) {
				this.worldObj.setBlock(j - 1, k + 1, l - 2, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j + 1, k + 1, l + 1) == Blocks.water) {
				this.worldObj.setBlock(j + 1, k + 1, l + 1, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j - 1, k + 1, l + 2) == Blocks.water) {
				this.worldObj.setBlock(j - 1, k + 1, l + 2, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j - 2, k + 1, l - 2) == Blocks.water) {
				this.worldObj.setBlock(j - 2, k + 1, l - 2, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j + 2, k + 1, l - 2) == Blocks.water) {
				this.worldObj.setBlock(j + 2, k + 1, l - 2, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j - 2, k + 1, l + 2) == Blocks.water) {
				this.worldObj.setBlock(j - 2, k + 1, l + 2, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j + 2, k + 1, l + 2) == Blocks.water) {
				this.worldObj.setBlock(j + 2, k + 1, l + 2, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j + 1, k + 1, l + 2) == Blocks.water) {
				this.worldObj.setBlock(j + 1, k + 1, l + 2, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j + 2, k + 1, l + 1) == Blocks.water) {
				this.worldObj.setBlock(j + 2, k + 1, l + 1, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j + 1, k + 1, l - 2) == Blocks.water) {
				this.worldObj.setBlock(j + 1, k + 1, l - 2, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
			if (this.worldObj.getBlock(j - 2, k + 1, l + 1) == Blocks.water) {
				this.worldObj.setBlock(j - 2, k + 1, l + 1, Blocks.ice);
				this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "harrypottermod:IceFreeze", 1.0f, 1.2f);
			}
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
