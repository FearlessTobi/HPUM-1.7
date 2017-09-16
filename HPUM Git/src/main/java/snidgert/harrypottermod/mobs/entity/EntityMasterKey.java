package snidgert.harrypottermod.mobs.entity;

import net.minecraft.entity.passive.*;
import net.minecraft.world.*;
import snidgert.harrypottermod.*;
import net.minecraft.util.*;
import net.minecraft.nbt.*;
import java.util.*;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;

public class EntityMasterKey extends EntityAmbientCreature
{
    private ChunkCoordinates currentFlightTarget;
    
    public EntityMasterKey(final World par1World) {
        super(par1World);
        this.setSize(0.5f, 0.9f);
        this.setIsBatHanging(true);
    }
    
    public EntityMasterKey(final World par1World, final double par2, final double par4, final double par6) {
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
	public boolean canBePushed() {
        return false;
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
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(6.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(300.0);
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
        this.motionX += (Math.signum(d0) * 0.5 - this.motionX) * 0.7000000014901161;
        this.motionY += (Math.signum(d2) * 0.699999988079071 - this.motionY) * 0.7000000014901161;
        this.motionZ += (Math.signum(d3) * 0.5 - this.motionZ) * 0.7000000014901161;
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
        this.dropItem(MainClass.MasterKey, 1);
    }
    
    @Override
	public boolean interact(final EntityPlayer par1EntityPlayer) {
        par1EntityPlayer.inventory.addItemStackToInventory(new ItemStack(MainClass.MasterKey, 1));
        this.setDead();
        return true;
    }
}
