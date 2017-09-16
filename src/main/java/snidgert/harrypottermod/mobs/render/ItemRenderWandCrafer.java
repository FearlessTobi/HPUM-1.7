package snidgert.harrypottermod.mobs.render;

import net.minecraftforge.client.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.tileentity.*;
import net.minecraft.item.*;
import org.lwjgl.opengl.*;

public class ItemRenderWandCrafer implements IItemRenderer
{
    TileEntitySpecialRenderer render;
    private TileEntity entity;
    
    public ItemRenderWandCrafer(final TileEntitySpecialRenderer render, final TileEntity entity) {
        this.entity = entity;
        this.render = render;
    }
    
    @Override
	public boolean handleRenderType(final ItemStack item, final IItemRenderer.ItemRenderType type) {
        return true;
    }
    
    @Override
	public boolean shouldUseRenderHelper(final IItemRenderer.ItemRenderType type, final ItemStack item, final IItemRenderer.ItemRendererHelper helper) {
        return true;
    }
    
    @Override
	public void renderItem(final IItemRenderer.ItemRenderType type, final ItemStack item, final Object... data) {
        if (type == IItemRenderer.ItemRenderType.ENTITY) {
            GL11.glTranslatef(-0.5f, 0.0f, -0.5f);
        }
        this.render.renderTileEntityAt(this.entity, 0.0, 0.0, 0.0, 0.0f);
    }
}
