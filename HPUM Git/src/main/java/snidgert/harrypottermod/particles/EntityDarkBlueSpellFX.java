package snidgert.harrypottermod.particles;

import cpw.mods.fml.relauncher.*;
import net.minecraft.client.particle.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;

@SideOnly(Side.CLIENT)
public class EntityDarkBlueSpellFX extends EntityFX
{
    private int baseTextureIndex;
    private boolean field_92054_ax;
    private boolean field_92048_ay;
    private final EffectRenderer field_92047_az;
    private float fadeColourRed;
    private float fadeColourGreen;
    private float fadeColourBlue;
    private boolean hasFadeColour;
    private static final String __OBFID = "CL_00000905";
    
    public EntityDarkBlueSpellFX(final World par1World, final double par2, final double par4, final double par6, final double par8, final double par10, final double par12, final EffectRenderer par14EffectRenderer) {
        super(par1World, par2, par4, par6);
        this.baseTextureIndex = 160;
        this.motionX = par8;
        this.motionY = par10;
        this.motionZ = par12;
        this.field_92047_az = par14EffectRenderer;
        super.particleScale *= 0.75f;
        super.particleMaxAge = 48 + this.rand.nextInt(12);
        this.noClip = false;
        super.particleRed = 0.13725491f;
        super.particleGreen = 0.38431373f;
        super.particleBlue = 0.8862745f;
    }
    
    public void setTrail(final boolean par1) {
        this.field_92054_ax = par1;
    }
    
    public void setTwinkle(final boolean par1) {
        this.field_92048_ay = par1;
    }
    
    public void setColour(final int par1) {
        final float f = ((par1 & 0xFF0000) >> 16) / 255.0f;
        final float f2 = ((par1 & 0xFF00) >> 8) / 255.0f;
        final float f3 = ((par1 & 0xFF) >> 0) / 255.0f;
        final float f4 = 1.0f;
        this.setRBGColorF(f * f4, f2 * f4, f3 * f4);
    }
    
    public void setFadeColour(final int par1) {
        this.fadeColourRed = 255.0f;
        this.fadeColourGreen = 0.0f;
        this.fadeColourBlue = 0.0f;
        this.hasFadeColour = true;
    }
    
    @Override
	public AxisAlignedBB getBoundingBox() {
        return null;
    }
    
    @Override
	public boolean canBePushed() {
        return false;
    }
    
    @Override
	public void renderParticle(final Tessellator par1Tessellator, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        if (!this.field_92048_ay || super.particleAge < super.particleMaxAge / 3 || (super.particleAge + super.particleMaxAge) / 3 % 2 == 0) {
            super.renderParticle(par1Tessellator, par2, par3, par4, par5, par6, par7);
        }
    }
    
    @Override
	public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (super.particleAge++ >= super.particleMaxAge) {
            this.setDead();
        }
        if (super.particleAge > super.particleMaxAge / 2) {
            this.setAlphaF(1.0f - (super.particleAge - super.particleMaxAge / 2) / super.particleMaxAge);
            if (this.hasFadeColour) {
                super.particleRed += (this.fadeColourRed - super.particleRed) * 0.2f;
                super.particleGreen += (this.fadeColourGreen - super.particleGreen) * 0.2f;
                super.particleBlue += (this.fadeColourBlue - super.particleBlue) * 0.2f;
            }
        }
        this.setParticleTextureIndex(this.baseTextureIndex + (7 - super.particleAge * 8 / super.particleMaxAge));
        if (this.onGround) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
        if (this.field_92054_ax && super.particleAge < super.particleMaxAge / 2 && (super.particleAge + super.particleMaxAge) % 2 == 0) {
            final EntityDarkBlueSpellFX entityfireworksparkfx = new EntityDarkBlueSpellFX(this.worldObj, this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0, this.field_92047_az);
            entityfireworksparkfx.setRBGColorF(super.particleRed, super.particleGreen, super.particleBlue);
            entityfireworksparkfx.particleAge = entityfireworksparkfx.particleMaxAge / 2;
            if (this.hasFadeColour) {
                entityfireworksparkfx.hasFadeColour = true;
                entityfireworksparkfx.fadeColourRed = this.fadeColourRed;
                entityfireworksparkfx.fadeColourGreen = this.fadeColourGreen;
                entityfireworksparkfx.fadeColourBlue = this.fadeColourBlue;
            }
            entityfireworksparkfx.field_92048_ay = this.field_92048_ay;
            this.field_92047_az.addEffect(entityfireworksparkfx);
        }
    }
    
    @Override
	public int getBrightnessForRender(final float par1) {
        return 15728880;
    }
    
    @Override
	public float getBrightness(final float par1) {
        return 1.0f;
    }
}
