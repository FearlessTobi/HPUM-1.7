package snidgert.harrypottermod.mobs.render;

import net.minecraft.util.*;
import snidgert.harrypottermod.mobs.*;
import snidgert.harrypottermod.mobs.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.entity.*;

public class RenderCatForm extends RenderLiving
{
    public static final ResourceLocation EntityTexture;
    public static final ResourceLocation EntityTexture2;
    public static final ResourceLocation EntityTexture3;
    protected CatForm model;
    
    public RenderCatForm(final ModelBase p_i1262_1_, final float p_i1262_2_) {
        super(p_i1262_1_, p_i1262_2_);
        this.model = (CatForm)this.mainModel;
    }
    
    public void renderCatForm(final EntityCatForm entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        super.doRender(entity, par2, par4, par6, par8, par9);
    }
    
    public void doRenderLiving(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.renderCatForm((EntityCatForm)par1EntityLiving, par2, par4, par6, par8, par9);
    }
    
    @Override
	public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.renderCatForm((EntityCatForm)par1Entity, par2, par4, par6, par8, par9);
    }
    
    @Override
	protected ResourceLocation getEntityTexture(final Entity entity) {
        final EntityCatForm thisentity = (EntityCatForm)entity;
        switch (thisentity.getTextureType()) {
            case 0: {
                return RenderCatForm.EntityTexture;
            }
            case 1: {
                return RenderCatForm.EntityTexture2;
            }
            case 2: {
                return RenderCatForm.EntityTexture3;
            }
            default: {
                return RenderCatForm.EntityTexture;
            }
        }
    }
    
    static {
        EntityTexture = new ResourceLocation("harrypottermod:textures/mobs/Cat1.png");
        EntityTexture2 = new ResourceLocation("harrypottermod:textures/mobs/Cat2.png");
        EntityTexture3 = new ResourceLocation("harrypottermod:textures/mobs/Cat3.png");
    }
}
