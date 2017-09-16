package snidgert.harrypottermod.projectiles;

import net.minecraft.world.*;
import snidgert.harrypottermod.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.block.*;

public class IncendioProjectile extends MagicProjectile
{
    private static final String __OBFID = "CL_00001721";
    
    public IncendioProjectile(final World par1World) {
        super(par1World);
        this.setSize(0.3125f, 0.3125f);
    }
    
    public IncendioProjectile(final World par1World, final EntityLivingBase par2EntityLivingBase, final double par3, final double par5, final double par7) {
        super(par1World, par2EntityLivingBase, par3, par5, par7);
        this.setSize(0.3125f, 0.3125f);
    }
    
    public IncendioProjectile(final World par1World, final double par2, final double par4, final double par6, final double par8, final double par10, final double par12) {
        super(par1World, par2, par4, par6, par8, par10, par12);
        this.setSize(0.3125f, 0.3125f);
    }
    
    @Override
    public void onUpdate() {
        super.worldObj.spawnParticle("flame", super.posX, super.posY, super.posZ, 0.0, 0.0, 0.0);
        super.onUpdate();
    }
    
    @Override
	public boolean isBurning() {
        return true;
    }
    
    @Override
    protected void onImpact(final MovingObjectPosition par1MovingObjectPosition) {
        if (!super.worldObj.isRemote) {
            if (par1MovingObjectPosition.entityHit != null && par1MovingObjectPosition.entityHit instanceof EntityLivingBase) {
                if (((EntityLivingBase)par1MovingObjectPosition.entityHit).isPotionActive(MainClass.ShieldEffect)) {
                    ((EntityLivingBase)par1MovingObjectPosition.entityHit).removePotionEffect(MainClass.ShieldEffect.id);
                }
                else if (!par1MovingObjectPosition.entityHit.isImmuneToFire() && par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.magic, 3.0f)) {
                    par1MovingObjectPosition.entityHit.setFire(5);
                }
            }
            else {
                int i = par1MovingObjectPosition.blockX;
                int j = par1MovingObjectPosition.blockY;
                int k = par1MovingObjectPosition.blockZ;
                switch (par1MovingObjectPosition.sideHit) {
                    case 0: {
                        --j;
                        break;
                    }
                    case 1: {
                        ++j;
                        break;
                    }
                    case 2: {
                        --k;
                        break;
                    }
                    case 3: {
                        ++k;
                        break;
                    }
                    case 4: {
                        --i;
                        break;
                    }
                    case 5: {
                        ++i;
                        break;
                    }
                }
                if (super.worldObj.isAirBlock(i, j, k)) {
                    super.worldObj.setBlock(i, j, k, Blocks.fire);
                }
            }
            this.setDead();
        }
    }
    
    @Override
    public boolean canBeCollidedWith() {
        return false;
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        return false;
    }
}
