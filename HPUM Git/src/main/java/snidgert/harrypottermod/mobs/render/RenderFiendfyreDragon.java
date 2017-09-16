package snidgert.harrypottermod.mobs.render;

import net.minecraft.util.*;
import snidgert.harrypottermod.mobs.*;
import snidgert.harrypottermod.mobs.entity.*;
import net.minecraft.client.model.*;
import org.lwjgl.opengl.*;

import net.minecraft.entity.*;
import net.minecraft.client.renderer.entity.*;

public class RenderFiendfyreDragon extends RenderLiving
{
    public static final ResourceLocation EntityTexture;
    protected FiendFyreDragon model;
    private float scale;
    
    public RenderFiendfyreDragon(final ModelBase p_i1262_1_, final float p_i1262_2_) {
        super(p_i1262_1_, p_i1262_2_);
        this.model = (FiendFyreDragon)this.mainModel;
        this.scale = 2.0f;
    }
    
    protected void preRenderCallback(final EntityHorntail entityhorntail, final float par2) {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }
    
    public void renderFiendfyreDragon(final EntityFiendfyreDragon entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        super.doRender(entity, par2, par4, par6, par8, par9);
    }
    
    public void doRenderLiving(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.renderFiendfyreDragon((EntityFiendfyreDragon)par1EntityLiving, par2, par4, par6, par8, par9);
    }
    
    @Override
	public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.renderFiendfyreDragon((EntityFiendfyreDragon)par1Entity, par2, par4, par6, par8, par9);
    }
    
    @Override
	protected ResourceLocation getEntityTexture(final Entity entity) {
        return RenderFiendfyreDragon.EntityTexture;
    }
    
    static {
        EntityTexture = new ResourceLocation("harrypottermod:textures/mobs/FiendfyreDragon.png");
    }
}
