package snidgert.harrypottermod.mobs.render;

import net.minecraft.client.renderer.entity.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.util.*;
import snidgert.harrypottermod.mobs.*;
import snidgert.harrypottermod.projectiles.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;

import org.lwjgl.opengl.*;

@SideOnly(Side.CLIENT)
public class RenderExpelliarmusStrongProjectile extends Render
{
    private static final ResourceLocation texture;
    private ModelBase model;
    
    public RenderExpelliarmusStrongProjectile(final int i) {
        this.model = new ModelMagicProjectile();
    }
    
    @Override
	protected ResourceLocation getEntityTexture(final Entity entity) {
        return this.getCustomTexture((ExpelliarmusProjectile)entity);
    }
    
    private ResourceLocation getCustomTexture(final ExpelliarmusProjectile entity) {
        return RenderExpelliarmusStrongProjectile.texture;
    }
    
    @Override
	public void doRender(final Entity entity, final double x, final double y, final double z, final float yaw, final float partialTick) {
        GL11.glPushMatrix();
        this.bindTexture(RenderExpelliarmusStrongProjectile.texture);
        GL11.glTranslated(x, y, z);
        this.model.render(entity, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
    }
    
    static {
        texture = new ResourceLocation("harrypottermod:textures/mobs/ExpelliarmusPrjoectile.png");
    }
}
