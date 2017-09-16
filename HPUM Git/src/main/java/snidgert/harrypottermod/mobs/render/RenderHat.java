package snidgert.harrypottermod.mobs.render;

import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.util.*;
import snidgert.harrypottermod.mobs.*;
import net.minecraft.tileentity.*;
import org.lwjgl.opengl.*;

public class RenderHat extends TileEntitySpecialRenderer
{
    private static final ResourceLocation EntityTexture;
    private Hat model;
    
    public RenderHat() {
        this.model = new Hat();
    }
    
    public void renderAModelAt(final TileEntity tileentity, final double d, final double d1, final double d2, final float f) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.5f, (float)d1 + 1.5f, (float)d2 + 0.5f);
        final int metadata = tileentity.getBlockMetadata();
        int rotationAngle = 0;
        if (metadata % 4 == 0) {
            rotationAngle = 180;
        }
        if (metadata % 4 == 1) {
            rotationAngle = -180;
        }
        if (metadata % 4 == 2) {
            rotationAngle = 1000000000;
        }
        if (metadata % 4 == 3) {
            rotationAngle = 0;
        }
        GL11.glRotatef(180.0f, 180.0f, 0.0f, rotationAngle);
        this.bindTexture(RenderHat.EntityTexture);
        GL11.glPushMatrix();
        this.model.renderModel(0.0625f);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
    
    @Override
	public void renderTileEntityAt(final TileEntity tileentity, final double d, final double d1, final double d2, final float f) {
        this.renderAModelAt(tileentity, d, d1, d2, f);
    }
    
    static {
        EntityTexture = new ResourceLocation("harrypottermod:textures/mobs/hat.png");
    }
}
