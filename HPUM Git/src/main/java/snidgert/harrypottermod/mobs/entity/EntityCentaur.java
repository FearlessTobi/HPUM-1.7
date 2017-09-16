package snidgert.harrypottermod.mobs.entity;

import java.util.Calendar;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderHell;

public class EntityCentaur extends EntityCreature implements IRangedAttackMob
{
	private EntityAIArrowAttack aiArrowAttack;
	private EntityAIAttackOnCollide aiAttackOnCollide;
	private static final String __OBFID = "CL_00001697";
	private int field_110285_bP;
	private String field_110286_bQ;

	public EntityCentaur(final World p_i1741_1_) {
		super(p_i1741_1_);
		this.aiArrowAttack = new EntityAIArrowAttack(this, 1.0, 20, 60, 15.0f);
		this.aiAttackOnCollide = new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.2, false);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(5, new EntityAIWander(this, 1.0));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityMob.class, 0, true));
		this.setSize(1.4f, 2.0f);
		if (p_i1741_1_ != null && !p_i1741_1_.isRemote) {
			this.setCombatTask();
		}
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.4);
	}

	@Override
	protected void func_145780_a(final int p_145780_1_, final int p_145780_2_, final int p_145780_3_, final Block p_145780_4_) {
		Block.SoundType soundtype = p_145780_4_.stepSound;
		if (this.worldObj.getBlock(p_145780_1_, p_145780_2_ + 1, p_145780_3_) == Blocks.snow_layer) {
			soundtype = Blocks.snow_layer.stepSound;
		}
		if (!p_145780_4_.getMaterial().isLiquid()) {
			if (this.field_110285_bP > 5 && this.field_110285_bP % 3 == 0) {
				this.playSound("mob.horse.gallop", soundtype.getVolume() * 0.15f, soundtype.getPitch());
			}
			if (this.field_110285_bP <= 5) {
				this.playSound("mob.horse.wood", soundtype.getVolume() * 0.15f, soundtype.getPitch());
			}
			if (soundtype == Block.soundTypeWood) {
				this.playSound("mob.horse.wood", soundtype.getVolume() * 0.15f, soundtype.getPitch());
			}
			else {
				this.playSound("mob.horse.soft", soundtype.getVolume() * 0.15f, soundtype.getPitch());
			}
		}
	}

	@Override
	protected void fall(final float p_70069_1_) {
		if (p_70069_1_ > 1.0f) {
			this.playSound("mob.horse.land", 0.4f, 1.0f);
		}
		final int i = MathHelper.ceiling_float_int(p_70069_1_ * 0.5f - 3.0f);
		if (i > 0) {
			this.attackEntityFrom(DamageSource.fall, i);
			if (this.riddenByEntity != null) {
				this.riddenByEntity.attackEntityFrom(DamageSource.fall, i);
			}
			final Block block = this.worldObj.getBlock(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY - 0.2 - this.prevRotationYaw), MathHelper.floor_double(this.posZ));
			if (block.getMaterial() != Material.air) {
				final Block.SoundType soundtype = block.stepSound;
				this.worldObj.playSoundAtEntity(this, soundtype.getStepResourcePath(), soundtype.getVolume() * 0.5f, soundtype.getPitch() * 0.75f);
			}
		}
	}

	@Override
	protected void entityInit() {
		final Random rnd = new Random();
		final int two = rnd.nextInt(4);
		super.entityInit();
		this.dataWatcher.addObject(13, new Byte((byte)0));
		this.getDataWatcher().addObject(25, 5);
		this.dataWatcher.updateObject(25, two);
	}

	public int getTextureType() {
		return this.dataWatcher.getWatchableObjectInt(25);
	}

	@Override
	public boolean isAIEnabled() {
		return true;
	}

	@Override
	protected String getDeathSound() {
		return "mob.horse.death";
	}

	@Override
	protected String getHurtSound() {
		return "mob.horse.hit";
	}

	@Override
	protected String getLivingSound() {
		return "mob.horse.idle";
	}

	protected String getAngrySoundName() {
		return "mob.horse.angry";
	}

	@Override
	public boolean attackEntityAsMob(final Entity p_70652_1_) {
		if (super.attackEntityAsMob(p_70652_1_)) {
			if (this.getSkeletonType() == 1 && p_70652_1_ instanceof EntityLivingBase) {
				((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.wither.id, 200));
			}
			return true;
		}
		return false;
	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
	}

	@Override
	public void onDeath(final DamageSource p_70645_1_) {
		super.onDeath(p_70645_1_);
		if (p_70645_1_.getSourceOfDamage() instanceof EntityArrow && p_70645_1_.getEntity() instanceof EntityPlayer) {
			final EntityPlayer entityplayer = (EntityPlayer)p_70645_1_.getEntity();
			final double d0 = ((Entity)entityplayer).posX - this.posX;
			final double d2 = ((Entity)entityplayer).posZ - this.posZ;
		}
	}

	protected Item func_146068_u() {
		return Items.arrow;
	}

	@Override
	protected void dropFewItems(final boolean p_70628_1_, final int p_70628_2_) {
		this.dropItem(Items.arrow, 1);
	}

	@Override
	protected void addRandomArmor() {
		super.addRandomArmor();
		this.setCurrentItemOrArmor(0, new ItemStack(Items.bow));
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_110161_1_) {
		p_110161_1_ = super.onSpawnWithEgg(p_110161_1_);
		if (this.worldObj.provider instanceof WorldProviderHell && this.getRNG().nextInt(5) > 0) {
			this.tasks.addTask(4, this.aiAttackOnCollide);
			this.setSkeletonType(1);
			this.setCurrentItemOrArmor(0, new ItemStack(Items.stone_sword));
			this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0);
		}
		else {
			this.tasks.addTask(4, this.aiArrowAttack);
			this.addRandomArmor();
			this.enchantEquipment();
		}
		this.setCanPickUpLoot(this.rand.nextFloat() < 0.55f * this.worldObj.func_147462_b(this.posX, this.posY, this.posZ));
		if (this.getEquipmentInSlot(4) == null) {
			final Calendar calendar = this.worldObj.getCurrentDate();
			if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31 && this.rand.nextFloat() < 0.25f) {
				this.setCurrentItemOrArmor(4, new ItemStack((this.rand.nextFloat() < 0.1f) ? Blocks.lit_pumpkin : Blocks.pumpkin));
				this.equipmentDropChances[4] = 0.0f;
			}
		}
		return p_110161_1_;
	}

	public void setCombatTask() {
		this.tasks.removeTask(this.aiAttackOnCollide);
		this.tasks.removeTask(this.aiArrowAttack);
		final ItemStack itemstack = this.getHeldItem();
		if (itemstack != null && itemstack.getItem() == Items.bow) {
			this.tasks.addTask(4, this.aiArrowAttack);
		}
		else {
			this.tasks.addTask(4, this.aiAttackOnCollide);
		}
	}

	@Override
	public void attackEntityWithRangedAttack(final EntityLivingBase p_82196_1_, final float p_82196_2_) {
		final EntityArrow entityarrow = new EntityArrow(this.worldObj, this, p_82196_1_, 1.6f, 14 - this.worldObj.difficultySetting.getDifficultyId() * 4);
		final int i = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, this.getHeldItem());
		final int j = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, this.getHeldItem());
		entityarrow.setDamage(p_82196_2_ * 2.0f + this.rand.nextGaussian() * 0.25 + this.worldObj.difficultySetting.getDifficultyId() * 0.11f);
		if (i > 0) {
			entityarrow.setDamage(entityarrow.getDamage() + i * 0.5 + 0.5);
		}
		if (j > 0) {
			entityarrow.setKnockbackStrength(j);
		}
		if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, this.getHeldItem()) > 0 || this.getSkeletonType() == 1) {
			entityarrow.setFire(100);
		}
		this.playSound("random.bow", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
		this.worldObj.spawnEntityInWorld(entityarrow);
	}

	public int getSkeletonType() {
		return this.dataWatcher.getWatchableObjectByte(13);
	}

	public void setSkeletonType(final int p_82201_1_) {
		this.dataWatcher.updateObject(13, (byte)p_82201_1_);
		this.isImmuneToFire = (p_82201_1_ == 1);
		if (p_82201_1_ == 1) {
			this.setSize(0.72f, 2.34f);
		}
		else {
			this.setSize(0.6f, 1.8f);
		}
	}

	@Override
	public void readEntityFromNBT(final NBTTagCompound p_70037_1_) {
		super.readEntityFromNBT(p_70037_1_);
		if (p_70037_1_.hasKey("SkeletonType", 99)) {
			final byte b0 = p_70037_1_.getByte("SkeletonType");
			this.setSkeletonType(b0);
		}
		this.setCombatTask();
	}

	@Override
	public void writeEntityToNBT(final NBTTagCompound p_70014_1_) {
		super.writeEntityToNBT(p_70014_1_);
		p_70014_1_.setByte("SkeletonType", (byte)this.getSkeletonType());
	}

	@Override
	public double getYOffset() {
		return super.getYOffset() - 0.5;
	}
}
