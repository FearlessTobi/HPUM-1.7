package snidgert.harrypottermod.mobs.entity;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.nbt.*;
import java.util.*;
import net.minecraft.block.*;

public class EntityBird extends EntityGolem
{
    private ChunkCoordinates currentFlightTarget;
    
    public EntityBird(final World par1World) {
        super(par1World);
        this.setSize(0.5f, 0.5f);
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, 1.0, true));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityLiving.class, 0, false, true, IMob.mobSelector));
    }
    
    @Override
	protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
        final Random rnd = new Random();
        final int two = rnd.nextInt(8);
        this.getDataWatcher().addObject(25, 5);
        this.dataWatcher.updateObject(25, two);
    }
    
    public EntityBird(final World par1World, final double par2, final double par4, final double par6) {
        this(par1World);
        this.setPosition(par2, par4 + this.yOffset, par6);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.prevPosX = par2;
        this.prevPosY = par4;
        this.prevPosZ = par6;
    }
    
    public int getTextureType() {
        return this.dataWatcher.getWatchableObjectInt(25);
    }
    
    @Override
	public boolean canBePushed() {
        return false;
    }
    
    @Override
	protected void collideWithEntity(final Entity par1Entity) {
        if (par1Entity instanceof IMob) {
            this.setAttackTarget((EntityLivingBase)par1Entity);
            par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), 7 + this.rand.nextInt(15));
        }
        super.collideWithEntity(par1Entity);
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
        final EntityPlayer player = this.worldObj.getClosestPlayer(this.posX, this.posY, this.posZ, 9.9999999999E10);
        final List list1 = this.worldObj.getEntitiesWithinAABB(EntityLiving.class, AxisAlignedBB.getBoundingBox(this.posX, this.posY, this.posZ, this.posX + 1.0, this.posY + 1.0, this.posZ + 1.0).expand(1.0, 1.0, 1.0));
        for (int j1 = 0; j1 < list1.size(); ++j1) {
            final EntityLiving entityitem = (EntityLiving) list1.get(j1);
            if (entityitem instanceof IMob) {
                entityitem.attackEntityFrom(DamageSource.causeMobDamage(this), 2 + this.rand.nextInt(15));
            }
        }
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
                this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1015, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
            }
        }
        else {
            if (this.currentFlightTarget != null && (!this.worldObj.isAirBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ) || this.currentFlightTarget.posY < 1)) {
                this.currentFlightTarget = null;
            }
            if (this.currentFlightTarget == null || this.rand.nextInt(30) == 0 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 4.0f) {
                this.currentFlightTarget = new ChunkCoordinates((int)this.posX + this.rand.nextInt(7) - this.rand.nextInt(7), (int)this.posY + this.rand.nextInt(6) - 2, (int)this.posZ + this.rand.nextInt(7) - this.rand.nextInt(7));
            }
            final double d0 = this.currentFlightTarget.posX + 0.5 - this.posX;
            final double d2 = this.currentFlightTarget.posY + 0.1 - this.posY;
            final double d3 = this.currentFlightTarget.posZ + 0.5 - this.posZ;
            this.motionX += (Math.signum(d0) * 0.5 - this.motionX) * 0.10000000149011612;
            this.motionY += (Math.signum(d2) * 0.699999988079071 - this.motionY) * 0.10000000149011612;
            this.motionZ += (Math.signum(d3) * 0.5 - this.motionZ) * 0.10000000149011612;
            final float f = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) - 90.0f;
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
	protected void func_145780_a(final int p_145780_1_, final int p_145780_2_, final int p_145780_3_, final Block p_145780_4_) {
        
    }
}
