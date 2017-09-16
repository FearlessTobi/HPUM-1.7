package snidgert.harrypottermod.mobs.entity;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.ai.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.pathfinding.*;
import net.minecraftforge.event.entity.living.*;
import snidgert.harrypottermod.*;
import snidgert.harrypottermod.projectiles.*;
import net.minecraftforge.common.*;
import cpw.mods.fml.common.eventhandler.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;

public class EntityHouseElf extends EntityWolf implements IRangedAttackMob
{
    private int field_70846_g;
    
    public EntityHouseElf(final World par1World) {
        super(par1World);
        this.setSize(1.0f, 1.0f);
        this.getNavigator().setAvoidsWater(true);
        this.getNavigator().setAvoidsWater(true);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAIArrowAttack(this, 1.25, 20, 10.0f));
        this.tasks.addTask(2, new EntityAIWander(this, 1.0));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        this.tasks.addTask(4, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityLiving.class, 0, true, false, IMob.mobSelector));
    }
    
    public EntityHouseElf(final World par1World, final double par2, final double par4, final double par6) {
        this(par1World);
        this.setPosition(par2, par4, par6);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.prevPosX = par2;
        this.prevPosY = par4;
        this.prevPosZ = par6;
    }
    
    protected boolean teleportRandomly() {
        final double d0 = this.posX + (this.rand.nextDouble() - 0.5) * 64.0;
        final double d2 = this.posY + (this.rand.nextInt(64) - 32);
        final double d3 = this.posZ + (this.rand.nextDouble() - 0.5) * 64.0;
        return this.teleportTo(d0, d2, d3);
    }
    
    @Override
	public void onLivingUpdate() {
        if (this.isWet() || this.isBurning()) {
            this.entityToAttack = null;
            this.teleportRandomly();
        }
        this.isJumping = false;
        if (this.entityToAttack != null) {
            this.faceEntity(this.entityToAttack, 100.0f, 100.0f);
        }
        if (!this.worldObj.isRemote && this.isEntityAlive() && this.entityToAttack != null && this.entityToAttack.getDistanceSqToEntity(this) < 16.0) {
            this.teleportRandomly();
        }
        super.onLivingUpdate();
    }
    
    @Override
	protected void func_145780_a(final int p_145780_1_, final int p_145780_2_, final int p_145780_3_, final Block p_145780_4_) {
        this.playSound("mob.zombie.step", 0.15f, 1.0f);
    }
    
    @Override
	protected String getLivingSound() {
        return null;
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
	protected float getSoundVolume() {
        return 0.4f;
    }
    
    @Override
	public boolean interact(final EntityPlayer par1EntityPlayer) {
        final ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();
        if (this.isTamed()) {
            if (itemstack != null) {
                if (itemstack.getItem() instanceof ItemFood) {
                    final ItemFood itemfood = (ItemFood)itemstack.getItem();
                    if (itemfood.isWolfsFavoriteMeat() && this.dataWatcher.getWatchableObjectFloat(18) < 20.0f) {
                        if (!par1EntityPlayer.capabilities.isCreativeMode) {
                            final ItemStack itemStack = itemstack;
                            --itemStack.stackSize;
                        }
                        this.heal(itemfood.func_150905_g(itemstack));
                        if (itemstack.stackSize <= 0) {
                            par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
                        }
                        return true;
                    }
                }
                else if (itemstack.getItem() == Items.dye) {
                    final int i = BlockColored.func_150032_b(itemstack.getItemDamage());
                    if (i != this.getCollarColor()) {
                        this.setCollarColor(i);
                        if (!par1EntityPlayer.capabilities.isCreativeMode) {
                            final ItemStack itemStack2 = itemstack;
                            if (--itemStack2.stackSize <= 0) {
                                par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
                            }
                        }
                        return true;
                    }
                }
            }
            if (par1EntityPlayer.getCommandSenderName().equalsIgnoreCase(this.func_152113_b()) && !this.worldObj.isRemote && !this.isBreedingItem(itemstack)) {
                this.aiSit.setSitting(!this.isSitting());
                this.isJumping = false;
                this.setPathToEntity((PathEntity)null);
                this.setTarget((Entity)null);
                this.setAttackTarget((EntityLivingBase)null);
            }
        }
        else if (itemstack != null && itemstack.getItem() == MainClass.Sock && !this.isAngry()) {
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                final ItemStack itemStack3 = itemstack;
                --itemStack3.stackSize;
            }
            if (itemstack.stackSize <= 0) {
                par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
            }
            if (!this.worldObj.isRemote) {
                if (this.rand.nextInt(3) == 0) {
                    this.setTamed(true);
                    this.setPathToEntity((PathEntity)null);
                    this.setAttackTarget((EntityLivingBase)null);
                    this.aiSit.setSitting(true);
                    this.setHealth(20.0f);
                    this.func_152115_b(par1EntityPlayer.getCommandSenderName());
                    this.playTameEffect(true);
                    this.worldObj.setEntityState(this, (byte)7);
                }
                else {
                    this.playTameEffect(false);
                    this.worldObj.setEntityState(this, (byte)6);
                }
            }
            return true;
        }
        return true;
    }
    
    protected boolean teleportToEntity(final Entity par1Entity) {
        Vec3 vec3 = Vec3.createVectorHelper(this.posX - par1Entity.posX, this.boundingBox.minY + this.height / 2.0f - par1Entity.posY + par1Entity.getEyeHeight(), this.posZ - par1Entity.posZ);
        vec3 = vec3.normalize();
        final double d0 = 16.0;
        final double d2 = this.posX + (this.rand.nextDouble() - 0.5) * 8.0 - vec3.xCoord * d0;
        final double d3 = this.posY + (this.rand.nextInt(16) - 8) - vec3.yCoord * d0;
        final double d4 = this.posZ + (this.rand.nextDouble() - 0.5) * 8.0 - vec3.zCoord * d0;
        return this.teleportTo(d2, d3, d4);
    }
    
    protected boolean teleportTo(final double par1, final double par3, final double par5) {
        final EnderTeleportEvent event = new EnderTeleportEvent(this, par1, par3, par5, 0.0f);
        if (MinecraftForge.EVENT_BUS.post(event)) {
            return false;
        }
        final double d3 = this.posX;
        final double d4 = this.posY;
        final double d5 = this.posZ;
        this.posX = event.targetX;
        this.posY = event.targetY;
        this.posZ = event.targetZ;
        boolean flag = false;
        final int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.posY);
        final int k = MathHelper.floor_double(this.posZ);
        if (this.worldObj.blockExists(i, j, k)) {
            boolean flag2 = false;
            while (!flag2 && j > 0) {
                final Block block = this.worldObj.getBlock(i, j - 1, k);
                if (block.getMaterial().blocksMovement()) {
                    flag2 = true;
                }
                else {
                    --this.posY;
                    --j;
                }
            }
            if (flag2) {
                this.setPosition(this.posX, this.posY, this.posZ);
                if (this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox)) {
                    flag = true;
                }
            }
        }
        if (!flag) {
            this.setPosition(d3, d4, d5);
            return false;
        }
        final short short1 = 128;
        for (int l = 0; l < short1; ++l) {
            final double d6 = l / (short1 - 1.0);
            final float f = (this.rand.nextFloat() - 0.5f) * 0.2f;
            final float f2 = (this.rand.nextFloat() - 0.5f) * 0.2f;
            final float f3 = (this.rand.nextFloat() - 0.5f) * 0.2f;
            final double d7 = d3 + (this.posX - d3) * d6 + (this.rand.nextDouble() - 0.5) * this.width * 2.0;
            final double d8 = d4 + (this.posY - d4) * d6 + this.rand.nextDouble() * this.height;
            final double d9 = d5 + (this.posZ - d5) * d6 + (this.rand.nextDouble() - 0.5) * this.width * 2.0;
            this.worldObj.spawnParticle("portal", d7, d8, d9, f, f2, f3);
        }
        this.worldObj.playSoundEffect(d3, d4, d5, "mob.endermen.portal", 1.0f, 1.0f);
        this.playSound("mob.endermen.portal", 1.0f, 1.0f);
        return true;
    }
    
    @Override
	public void attackEntityWithRangedAttack(final EntityLivingBase par1EntityLivingBase, final float par2) {
        final double d0 = ((Entity)par1EntityLivingBase).posX - this.posX;
        final double d2 = ((Entity)par1EntityLivingBase).posY + par1EntityLivingBase.getEyeHeight() - 1.100000023841858 - ((Entity)par1EntityLivingBase).posY;
        final double d3 = ((Entity)par1EntityLivingBase).posZ - this.posZ;
        final float f1 = MathHelper.sqrt_double(d0 * d0 + d3 * d3) * 0.2f;
        final StupefyProjectile entitysnowball = new StupefyProjectile(this.worldObj, this, d0 + this.rand.nextGaussian() * f1, d2, d3 + this.rand.nextGaussian() * f1);
        entitysnowball.posY = this.posY + this.height / 2.0f + 0.5;
        this.worldObj.spawnEntityInWorld(entitysnowball);
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
	public boolean isAIEnabled() {
        return true;
    }
    
    @Override
	public EntityWolf createChild(final EntityAgeable var1) {
        return null;
    }
}
