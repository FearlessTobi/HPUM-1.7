package snidgert.harrypottermod;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import snidgert.harrypottermod.items.ContainerItem;
import snidgert.harrypottermod.items.InventoryItem;

public class GuiItemInventory extends GuiContainer
{
	private float xSize_lo;
	private float ySize_lo;
	private static final ResourceLocation iconLocation;
	private final InventoryItem inventory;

	public GuiItemInventory(final ContainerItem containerItem) {
		super(containerItem);
		this.inventory = containerItem.inventory;
	}

	@Override
	public void drawScreen(final int par1, final int par2, final float par3) {
		super.drawScreen(par1, par2, par3);
		this.xSize_lo = par1;
		this.ySize_lo = par2;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(final int par1, final int par2) {
		final String s = this.inventory.hasCustomInventoryName() ? this.inventory.getInventoryName() : I18n.format(this.inventory.getInventoryName(), new Object[0]);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(final float par1, final int par2, final int par3) {
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(GuiItemInventory.iconLocation);
		final int k = (this.width - super.xSize) / 2;
		final int l = (this.height - super.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, super.xSize, super.ySize);
		drawPlayerModel(k + 51, l + 75, 30, k + 51 - this.xSize_lo, l + 75 - 50 - this.ySize_lo, this.mc.thePlayer);
	}

	public static void drawPlayerModel(final int x, final int y, final int scale, final float yaw, final float pitch, final EntityLivingBase entity) {
		GL11.glEnable(2903);
		GL11.glPushMatrix();
		GL11.glTranslatef(x, y, 50.0f);
		GL11.glScalef((-scale), scale, scale);
		GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
		final float f2 = entity.renderYawOffset;
		final float f3 = ((Entity)entity).rotationYaw;
		final float f4 = ((Entity)entity).rotationPitch;
		final float f5 = entity.prevRotationYawHead;
		final float f6 = entity.rotationYawHead;
		GL11.glRotatef(135.0f, 0.0f, 1.0f, 0.0f);
		RenderHelper.enableStandardItemLighting();
		GL11.glRotatef(-135.0f, 0.0f, 1.0f, 0.0f);
		GL11.glRotatef(-(float)Math.atan(pitch / 40.0f) * 20.0f, 1.0f, 0.0f, 0.0f);
		entity.renderYawOffset = (float)Math.atan(yaw / 40.0f) * 20.0f;
		((Entity)entity).rotationYaw = (float)Math.atan(yaw / 40.0f) * 40.0f;
		((Entity)entity).rotationPitch = -(float)Math.atan(pitch / 40.0f) * 20.0f;
		entity.rotationYawHead = ((Entity)entity).rotationYaw;
		entity.prevRotationYawHead = ((Entity)entity).rotationYaw;
		GL11.glTranslatef(0.0f, ((Entity)entity).yOffset, 0.0f);
		RenderManager.instance.playerViewY = 180.0f;
		RenderManager.instance.renderEntityWithPosYaw(entity, 0.0, 0.0, 0.0, 0.0f, 1.0f);
		entity.renderYawOffset = f2;
		((Entity)entity).rotationYaw = f3;
		((Entity)entity).rotationPitch = f4;
		entity.prevRotationYawHead = f5;
		entity.rotationYawHead = f6;
		GL11.glPopMatrix();
		RenderHelper.disableStandardItemLighting();
		GL11.glDisable(32826);
		OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
		GL11.glDisable(3553);
		OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
	}

	static {
		iconLocation = new ResourceLocation("harrypottermod:textures/gui/inventoryitem.png");
	}
}
