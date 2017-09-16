package snidgert.harrypottermod.mobs.render;

import net.minecraft.util.*;
import snidgert.harrypottermod.mobs.*;
import snidgert.harrypottermod.mobs.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.entity.*;

public class RenderFairy extends RenderLiving
{
    public static final ResourceLocation EntityTexture;
    public static final ResourceLocation EntityTexture2;
    protected Fairy model;
    
    public RenderFairy(final ModelBase p_i1262_1_, final float p_i1262_2_) {
        super(p_i1262_1_, p_i1262_2_);
        this.model = (Fairy)this.mainModel;
    }
    
    public void renderFairy(final EntityFairy entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        super.doRender(entity, par2, par4, par6, par8, par9);
    }
    
    public void doRenderLiving(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.renderFairy((EntityFairy)par1EntityLiving, par2, par4, par6, par8, par9);
    }
    
    @Override
	public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.renderFairy((EntityFairy)par1Entity, par2, par4, par6, par8, par9);
    }
    
    @Override
	protected ResourceLocation getEntityTexture(final Entity entity) {
        final EntityFairy thisentity = (EntityFairy)entity;
        switch (thisentity.getTextureType()) {
            case 0: {
                return RenderFairy.EntityTexture;
            }
            case 1: {
                return RenderFairy.EntityTexture2;
            }
            default: {
                return RenderFairy.EntityTexture;
            }
        }
    }
    
    static {
        EntityTexture = new ResourceLocation("harrypottermod:textures/mobs/Fairy1.png");
        EntityTexture2 = new ResourceLocation("harrypottermod:textures/mobs/Fairy2.png");
    }
}
