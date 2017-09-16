package snidgert.harrypottermod.mobs.render;

import net.minecraft.util.*;
import snidgert.harrypottermod.mobs.*;
import snidgert.harrypottermod.mobs.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.entity.*;

public class RenderRedCap extends RenderLiving
{
    public static final ResourceLocation EntityTexture;
    protected RedCap model;
    
    public RenderRedCap(final ModelBase p_i1262_1_, final float p_i1262_2_) {
        super(p_i1262_1_, p_i1262_2_);
        this.model = (RedCap)this.mainModel;
    }
    
    public void renderRedCap(final EntityRedCap entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        super.doRender(entity, par2, par4, par6, par8, par9);
    }
    
    public void doRenderLiving(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.renderRedCap((EntityRedCap)par1EntityLiving, par2, par4, par6, par8, par9);
    }
    
    @Override
	public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.renderRedCap((EntityRedCap)par1Entity, par2, par4, par6, par8, par9);
    }
    
    @Override
	protected ResourceLocation getEntityTexture(final Entity entity) {
        return RenderRedCap.EntityTexture;
    }
    
    static {
        EntityTexture = new ResourceLocation("harrypottermod:textures/mobs/RedCap.png");
    }
}
