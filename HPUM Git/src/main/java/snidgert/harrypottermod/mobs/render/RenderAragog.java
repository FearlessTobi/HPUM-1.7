package snidgert.harrypottermod.mobs.render;

import net.minecraft.util.*;
import snidgert.harrypottermod.mobs.*;
import snidgert.harrypottermod.mobs.entity.*;
import net.minecraft.client.model.*;

import org.lwjgl.opengl.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.entity.*;

public class RenderAragog extends RenderLiving
{
    public static final ResourceLocation EntityTexture;
    protected Aragog model;
    private float scale;
    
    public RenderAragog(final ModelBase par2, final float par3) {
        super(par2, par3);
        this.model = (Aragog)this.mainModel;
        this.scale = 2.5f;
    }
    
    public void renderAragog(final EntityAragog entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        super.doRender(entity, par2, par4, par6, par8, par9);
    }
    
    protected void preRenderCallback(final EntityAragog entityaragog, final float par2) {
        if (entityaragog.hasCustomNameTag()) {
            GL11.glScalef(this.scale, this.scale, this.scale);
        }
    }
    
    @Override
	protected void preRenderCallback(final EntityLivingBase par1EntityLivingBase, final float par2) {
        this.preRenderCallback((EntityAragog)par1EntityLivingBase, par2);
    }
    
    public void doRenderLiving(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.renderAragog((EntityAragog)par1EntityLiving, par2, par4, par6, par8, par9);
    }
    
    @Override
	public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.renderAragog((EntityAragog)par1Entity, par2, par4, par6, par8, par9);
    }
    
    @Override
	protected ResourceLocation getEntityTexture(final Entity entity) {
        return RenderAragog.EntityTexture;
    }
    
    static {
        EntityTexture = new ResourceLocation("harrypottermod:textures/mobs/aragog.png");
    }
}
