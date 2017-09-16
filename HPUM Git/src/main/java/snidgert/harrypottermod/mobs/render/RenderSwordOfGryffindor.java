package snidgert.harrypottermod.mobs.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import snidgert.harrypottermod.items.SwordOfGryffindorModel;

public class RenderSwordOfGryffindor implements IItemRenderer
{
    SwordOfGryffindorModel swordmodel;
    private static final ResourceLocation texture;
    private static final ResourceLocation texture2;
    
    public RenderSwordOfGryffindor() {
        this.swordmodel = new SwordOfGryffindorModel();
    }
    
    @Override
	public void renderItem(final IItemRenderer.ItemRenderType type, final ItemStack item, final Object... data) {
        switch (type) {
            case EQUIPPED: {
                GL11.glPushMatrix();
                Minecraft.getMinecraft().renderEngine.bindTexture(RenderSwordOfGryffindor.texture);
                final float scale = 1.2f;
                GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(-120.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScalef(scale, scale, scale);
                GL11.glTranslatef(0.075f, -0.125f, 0.175f);
                this.swordmodel.render((Entity)data[1], 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
                GL11.glPopMatrix();
                break;
            }
            case EQUIPPED_FIRST_PERSON: {
                GL11.glPushMatrix();
                Minecraft.getMinecraft().renderEngine.bindTexture(RenderSwordOfGryffindor.texture);
                final float scale2 = 500.0f;
                GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(-120.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScalef(scale2, scale2, scale2);
                GL11.glTranslatef(-0.3f, -0.3f, 0.675f);
                this.swordmodel.render((Entity)data[1], 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
                GL11.glPopMatrix();
                break;
            }
            case ENTITY: {
                GL11.glPushMatrix();
                final float scale3 = 1.2f;
                GL11.glScalef(scale3, scale3, scale3);
                Minecraft.getMinecraft().renderEngine.bindTexture(RenderSwordOfGryffindor.texture);
                GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 0.0f, 1.0f);
                GL11.glTranslatef(-0.2f, 1.0f, 0.0f);
                this.swordmodel.render((Entity)data[1], 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
                GL11.glPopMatrix();
                break;
            }
		default:
			break;
        }
    }
    
    @Override
	public boolean handleRenderType(final ItemStack item, final IItemRenderer.ItemRenderType type) {
        switch (type) {
            case EQUIPPED: {
                return true;
            }
            case EQUIPPED_FIRST_PERSON: {
                return true;
            }
            case ENTITY: {
                return true;
            }
            default: {
                return false;
            }
        }
    }
    
    @Override
	public boolean shouldUseRenderHelper(final IItemRenderer.ItemRenderType type, final ItemStack item, final IItemRenderer.ItemRendererHelper helper) {
        return false;
    }
    
    static {
        texture = new ResourceLocation("harrypottermod:textures/mobs/SwordOfGryffindor.png");
        texture2 = new ResourceLocation("harrypottermod:textures/items/SwordofGryffindor.png");
    }
}
