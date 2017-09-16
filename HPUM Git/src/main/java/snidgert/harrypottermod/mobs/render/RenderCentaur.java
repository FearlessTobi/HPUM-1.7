package snidgert.harrypottermod.mobs.render;

import net.minecraft.client.model.*;
import org.lwjgl.opengl.*;
import net.minecraftforge.client.*;
import snidgert.harrypottermod.mobs.*;
import snidgert.harrypottermod.mobs.entity.*;
import net.minecraft.block.*;
import net.minecraft.client.renderer.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import java.util.*;
import com.mojang.authlib.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.nbt.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.entity.*;

public class RenderCentaur extends RenderLiving
{
    public static final ResourceLocation EntityTexture;
    public static final ResourceLocation EntityTexture2;
    public static final ResourceLocation EntityTexture3;
    public static final ResourceLocation EntityTexture4;
    protected Centaur model;
    
    public RenderCentaur(final ModelBiped p_i1262_1_, final float p_i1262_2_) {
        super(p_i1262_1_, p_i1262_2_);
        this.model = (Centaur)this.mainModel;
    }
    
    protected void renderEquippedItems(final EntityLiving p_77029_1_, final float p_77029_2_) {
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        super.renderEquippedItems(p_77029_1_, p_77029_2_);
        final ItemStack itemstack = p_77029_1_.getHeldItem();
        final ItemStack itemstack2 = p_77029_1_.func_130225_q(3);
        if (itemstack2 != null) {
            GL11.glPushMatrix();
            this.model.Head.postRender(0.0625f);
            final Item item = itemstack2.getItem();
            final IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack2, IItemRenderer.ItemRenderType.EQUIPPED);
            final boolean is3D = customRenderer != null && customRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, itemstack2, IItemRenderer.ItemRendererHelper.BLOCK_3D);
            if (item instanceof ItemBlock) {
                if (is3D || RenderBlocks.renderItemIn3d(Block.getBlockFromItem(item).getRenderType())) {
                    final float f1 = 0.625f;
                    GL11.glTranslatef(0.0f, -0.25f, 0.0f);
                    GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                    GL11.glScalef(f1, -f1, -f1);
                }
                this.renderManager.itemRenderer.renderItem(p_77029_1_, itemstack2, 0);
            }
            else if (item == Items.skull) {
                final float f1 = 1.0625f;
                GL11.glScalef(f1, -f1, -f1);
                GameProfile gameprofile = null;
                if (itemstack2.hasTagCompound()) {
                    final NBTTagCompound nbttagcompound = itemstack2.getTagCompound();
                    if (nbttagcompound.hasKey("SkullOwner", 10)) {
                        gameprofile = NBTUtil.func_152459_a(nbttagcompound.getCompoundTag("SkullOwner"));
                    }
                    else if (nbttagcompound.hasKey("SkullOwner", 8) && !StringUtils.isNullOrEmpty(nbttagcompound.getString("SkullOwner"))) {
                        gameprofile = new GameProfile((UUID)null, nbttagcompound.getString("SkullOwner"));
                    }
                }
                TileEntitySkullRenderer.field_147536_b.func_152674_a(-0.5f, 0.0f, -0.5f, 1, 180.0f, itemstack2.getItemDamage(), gameprofile);
            }
            GL11.glPopMatrix();
        }
        if (itemstack != null && itemstack.getItem() != null) {
            final Item item = itemstack.getItem();
            GL11.glPushMatrix();
            if (this.mainModel.isChild) {
                final float f1 = 0.5f;
                GL11.glTranslatef(0.0f, 0.625f, 0.0f);
                GL11.glRotatef(-20.0f, -1.0f, 0.0f, 0.0f);
                GL11.glScalef(f1, f1, f1);
            }
            this.model.ArmR.postRender(0.0625f);
            GL11.glTranslatef(-0.0625f, 0.4375f, 0.0625f);
            final IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack, IItemRenderer.ItemRenderType.EQUIPPED);
            final boolean is3D = customRenderer != null && customRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, itemstack, IItemRenderer.ItemRendererHelper.BLOCK_3D);
            if (item instanceof ItemBlock && (is3D || RenderBlocks.renderItemIn3d(Block.getBlockFromItem(item).getRenderType()))) {
                float f1 = 0.5f;
                GL11.glTranslatef(0.0f, 0.1875f, -0.3125f);
                f1 *= 0.75f;
                GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(-f1, -f1, f1);
            }
            else if (item == Items.bow) {
                final float f1 = 0.625f;
                GL11.glTranslatef(0.0f, 0.125f, 0.3125f);
                GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(f1, -f1, f1);
                GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            }
            else if (item.isFull3D()) {
                final float f1 = 0.625f;
                if (item.shouldRotateAroundWhenRendering()) {
                    GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
                    GL11.glTranslatef(0.0f, -0.125f, 0.0f);
                }
                this.func_82422_c();
                GL11.glScalef(f1, -f1, f1);
                GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            }
            else {
                final float f1 = 0.375f;
                GL11.glTranslatef(0.25f, 0.1875f, -0.1875f);
                GL11.glScalef(f1, f1, f1);
                GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
            }
            if (itemstack.getItem().requiresMultipleRenderPasses()) {
                for (int i = 0; i < itemstack.getItem().getRenderPasses(itemstack.getItemDamage()); ++i) {
                    final int j = itemstack.getItem().getColorFromItemStack(itemstack, i);
                    final float f2 = (j >> 16 & 0xFF) / 255.0f;
                    final float f3 = (j >> 8 & 0xFF) / 255.0f;
                    final float f4 = (j & 0xFF) / 255.0f;
                    GL11.glColor4f(f2, f3, f4, 1.0f);
                    this.renderManager.itemRenderer.renderItem(p_77029_1_, itemstack, i);
                }
            }
            else {
                final int i = itemstack.getItem().getColorFromItemStack(itemstack, 0);
                final float f5 = (i >> 16 & 0xFF) / 255.0f;
                final float f2 = (i >> 8 & 0xFF) / 255.0f;
                final float f3 = (i & 0xFF) / 255.0f;
                GL11.glColor4f(f5, f2, f3, 1.0f);
                this.renderManager.itemRenderer.renderItem(p_77029_1_, itemstack, 0);
            }
            GL11.glPopMatrix();
        }
    }
    
    @Override
	public void doRender(final EntityLiving p_76986_1_, final double p_76986_2_, final double p_76986_4_, final double p_76986_6_, final float p_76986_8_, final float p_76986_9_) {
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        final ItemStack itemstack = p_76986_1_.getHeldItem();
        double d3 = p_76986_4_ - ((Entity)p_76986_1_).yOffset;
        if (p_76986_1_.isSneaking()) {
            d3 -= 0.125;
        }
    }
    
    protected int shouldRenderPass(final EntityLiving p_77032_1_, final int p_77032_2_, final float p_77032_3_) {
        final ItemStack itemstack = p_77032_1_.func_130225_q(3 - p_77032_2_);
        if (itemstack != null) {
            final Item item = itemstack.getItem();
            if (item instanceof ItemArmor) {
                final ItemArmor itemarmor = (ItemArmor)item;
                final int j = itemarmor.getColor(itemstack);
                if (j != -1) {
                    final float f1 = (j >> 16 & 0xFF) / 255.0f;
                    final float f2 = (j >> 8 & 0xFF) / 255.0f;
                    final float f3 = (j & 0xFF) / 255.0f;
                    GL11.glColor3f(f1, f2, f3);
                    if (itemstack.isItemEnchanted()) {
                        return 31;
                    }
                    return 16;
                }
                else {
                    GL11.glColor3f(1.0f, 1.0f, 1.0f);
                    if (itemstack.isItemEnchanted()) {
                        return 15;
                    }
                    return 1;
                }
            }
        }
        return -1;
    }
    
    protected void func_82422_c() {
        GL11.glTranslatef(0.0f, 0.1875f, 0.0f);
    }
    
    @Override
	protected void renderEquippedItems(final EntityLivingBase p_77029_1_, final float p_77029_2_) {
        this.renderEquippedItems((EntityLiving)p_77029_1_, p_77029_2_);
    }
    
    public void renderCentaur(final EntityCentaur entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        super.doRender(entity, par2, par4, par6, par8, par9);
    }
    
    public void doRenderLiving(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.renderCentaur((EntityCentaur)par1EntityLiving, par2, par4, par6, par8, par9);
    }
    
    @Override
	public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.renderCentaur((EntityCentaur)par1Entity, par2, par4, par6, par8, par9);
    }
    
    @Override
	protected ResourceLocation getEntityTexture(final Entity entity) {
        final EntityCentaur thisentity = (EntityCentaur)entity;
        switch (thisentity.getTextureType()) {
            case 0: {
                return RenderCentaur.EntityTexture;
            }
            case 1: {
                return RenderCentaur.EntityTexture2;
            }
            case 2: {
                return RenderCentaur.EntityTexture3;
            }
            case 3: {
                return RenderCentaur.EntityTexture4;
            }
            default: {
                return RenderCentaur.EntityTexture;
            }
        }
    }
    
    static {
        EntityTexture = new ResourceLocation("harrypottermod:textures/mobs/Centaur1.png");
        EntityTexture2 = new ResourceLocation("harrypottermod:textures/mobs/Centaur2.png");
        EntityTexture3 = new ResourceLocation("harrypottermod:textures/mobs/Centaur3.png");
        EntityTexture4 = new ResourceLocation("harrypottermod:textures/mobs/Centaur4.png");
    }
}
