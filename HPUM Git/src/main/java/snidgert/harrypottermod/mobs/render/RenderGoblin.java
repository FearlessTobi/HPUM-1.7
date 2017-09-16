package snidgert.harrypottermod.mobs.render;

import net.minecraft.util.*;
import snidgert.harrypottermod.mobs.*;
import snidgert.harrypottermod.mobs.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.entity.*;

public class RenderGoblin extends RenderLiving
{
    public static final ResourceLocation EntityTexture;
    public static final ResourceLocation EntityTexture2;
    public static final ResourceLocation EntityTexture3;
    public static final ResourceLocation EntityTexture4;
    public static final ResourceLocation EntityTexture5;
    public static final ResourceLocation EntityTexture6;
    protected Goblin model;
    
    public RenderGoblin(final ModelBase p_i1262_1_, final float p_i1262_2_) {
        super(p_i1262_1_, p_i1262_2_);
        this.model = (Goblin)this.mainModel;
    }
    
    public void renderGoblin(final EntityGoblin entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        super.doRender(entity, par2, par4, par6, par8, par9);
    }
    
    public void doRenderLiving(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.renderGoblin((EntityGoblin)par1EntityLiving, par2, par4, par6, par8, par9);
    }
    
    @Override
	public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.renderGoblin((EntityGoblin)par1Entity, par2, par4, par6, par8, par9);
    }
    
    @Override
	protected ResourceLocation getEntityTexture(final Entity entity) {
        final EntityGoblin thisentity = (EntityGoblin)entity;
        switch (thisentity.getTextureType()) {
            case 0: {
                return RenderGoblin.EntityTexture;
            }
            case 1: {
                return RenderGoblin.EntityTexture2;
            }
            case 2: {
                return RenderGoblin.EntityTexture3;
            }
            case 3: {
                return RenderGoblin.EntityTexture4;
            }
            case 4: {
                return RenderGoblin.EntityTexture5;
            }
            case 5: {
                return RenderGoblin.EntityTexture6;
            }
            default: {
                return RenderGoblin.EntityTexture;
            }
        }
    }
    
    static {
        EntityTexture = new ResourceLocation("harrypottermod:textures/mobs/Goblin1.png");
        EntityTexture2 = new ResourceLocation("harrypottermod:textures/mobs/Goblin2.png");
        EntityTexture3 = new ResourceLocation("harrypottermod:textures/mobs/Goblin3.png");
        EntityTexture4 = new ResourceLocation("harrypottermod:textures/mobs/Goblin4.png");
        EntityTexture5 = new ResourceLocation("harrypottermod:textures/mobs/Goblin5.png");
        EntityTexture6 = new ResourceLocation("harrypottermod:textures/mobs/Goblin6.png");
    }
}
