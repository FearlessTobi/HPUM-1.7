package snidgert.harrypottermod.mobs;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class Aragog extends ModelBase
{
    ModelRenderer Head;
    ModelRenderer Neck;
    ModelRenderer Body;
    ModelRenderer RearEnd;
    ModelRenderer Leg1L;
    ModelRenderer Leg1Lpart2;
    ModelRenderer Leg2L;
    ModelRenderer Leg2Lpart2;
    ModelRenderer Leg3L;
    ModelRenderer Leg3Lpart2;
    ModelRenderer Leg4L;
    ModelRenderer Leg4Lpart2;
    ModelRenderer Leg1R;
    ModelRenderer Leg1Rpart2;
    ModelRenderer Leg2R;
    ModelRenderer Leg2Rpart2;
    ModelRenderer Leg3R;
    ModelRenderer Leg3Rpart2;
    ModelRenderer Leg4R;
    ModelRenderer Leg4Rpart2;
    ModelRenderer FangR;
    ModelRenderer FangL;
    
    public Aragog() {
        super.textureWidth = 256;
        super.textureHeight = 128;
        (this.Head = new ModelRenderer(this, 0, 0)).addBox(-6.0f, -4.5f, -8.0f, 12, 9, 8);
        this.Head.setRotationPoint(0.0f, 12.5f, -5.0f);
        this.Head.setTextureSize(256, 128);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.1745329f, 0.0f, 0.0f);
        (this.Neck = new ModelRenderer(this, 0, 19)).addBox(-4.0f, -3.5f, -4.0f, 8, 7, 4);
        this.Neck.setRotationPoint(0.0f, 12.0f, -2.0f);
        this.Neck.setTextureSize(256, 128);
        this.Neck.mirror = true;
        this.setRotation(this.Neck, 0.0f, 0.0f, 0.0f);
        (this.Body = new ModelRenderer(this, 55, 0)).addBox(-7.0f, -6.0f, -7.0f, 14, 12, 14);
        this.Body.setRotationPoint(0.0f, 12.0f, 5.0f);
        this.Body.setTextureSize(256, 128);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0f, 0.0f, 0.0f);
        (this.RearEnd = new ModelRenderer(this, 0, 39)).addBox(-10.0f, -8.0f, 0.0f, 20, 16, 25);
        this.RearEnd.setRotationPoint(0.0f, 12.0f, 11.0f);
        this.RearEnd.setTextureSize(256, 128);
        this.RearEnd.mirror = true;
        this.setRotation(this.RearEnd, 0.0872665f, 0.0f, 0.0f);
        (this.Leg1L = new ModelRenderer(this, 0, 85)).addBox(-1.0f, -1.5f, -1.5f, 14, 3, 3);
        this.Leg1L.setRotationPoint(7.0f, 15.0f, -1.0f);
        this.Leg1L.setTextureSize(256, 128);
        this.Leg1L.mirror = true;
        this.setRotation(this.Leg1L, 0.0f, 0.3490659f, -0.6108652f);
        (this.Leg1Lpart2 = new ModelRenderer(this, 0, 92)).addBox(-1.5f, 0.0f, -1.5f, 3, 19, 3);
        this.Leg1Lpart2.setRotationPoint(16.0f, 7.0f, -4.0f);
        this.Leg1Lpart2.setTextureSize(256, 128);
        this.Leg1Lpart2.mirror = true;
        this.setRotation(this.Leg1Lpart2, 0.0698132f, 0.3839724f, -0.4363323f);
        (this.Leg2L = new ModelRenderer(this, 0, 85)).addBox(-1.0f, -1.5f, -1.5f, 14, 3, 3);
        this.Leg2L.setRotationPoint(7.0f, 15.0f, 3.0f);
        this.Leg2L.setTextureSize(256, 128);
        this.Leg2L.mirror = true;
        this.setRotation(this.Leg2L, 0.0f, 0.1745329f, -0.6108652f);
        (this.Leg2Lpart2 = new ModelRenderer(this, 0, 92)).addBox(-1.5f, 0.0f, -1.5f, 3, 19, 3);
        this.Leg2Lpart2.setRotationPoint(16.0f, 7.0f, 1.5f);
        this.Leg2Lpart2.setTextureSize(256, 128);
        this.Leg2Lpart2.mirror = true;
        this.setRotation(this.Leg2Lpart2, 0.0349066f, 0.0698132f, -0.4363323f);
        (this.Leg3L = new ModelRenderer(this, 0, 85)).addBox(-1.0f, -1.5f, -1.5f, 14, 3, 3);
        this.Leg3L.setRotationPoint(7.0f, 15.0f, 6.0f);
        this.Leg3L.setTextureSize(256, 128);
        this.Leg3L.mirror = true;
        this.setRotation(this.Leg3L, 0.0f, -0.1745329f, -0.6108652f);
        (this.Leg3Lpart2 = new ModelRenderer(this, 0, 92)).addBox(-1.5f, 0.0f, -1.5f, 3, 19, 3);
        this.Leg3Lpart2.setRotationPoint(16.0f, 7.0f, 7.5f);
        this.Leg3Lpart2.setTextureSize(256, 128);
        this.Leg3Lpart2.mirror = true;
        this.setRotation(this.Leg3Lpart2, -0.0349066f, -0.2094395f, -0.4363323f);
        (this.Leg4L = new ModelRenderer(this, 0, 85)).addBox(-1.0f, -1.5f, -1.5f, 14, 3, 3);
        this.Leg4L.setRotationPoint(7.0f, 15.0f, 10.0f);
        this.Leg4L.setTextureSize(256, 128);
        this.Leg4L.mirror = true;
        this.setRotation(this.Leg4L, 0.0f, -0.3490659f, -0.6108652f);
        (this.Leg4Lpart2 = new ModelRenderer(this, 0, 92)).addBox(-1.5f, 0.0f, -1.5f, 3, 19, 3);
        this.Leg4Lpart2.setRotationPoint(16.0f, 7.0f, 13.3f);
        this.Leg4Lpart2.setTextureSize(256, 128);
        this.Leg4Lpart2.mirror = true;
        this.setRotation(this.Leg4Lpart2, -0.0523599f, -0.4712389f, -0.4363323f);
        (this.Leg1R = new ModelRenderer(this, 0, 85)).addBox(-13.0f, -1.5f, -1.5f, 14, 3, 3);
        this.Leg1R.setRotationPoint(-7.0f, 15.0f, -1.0f);
        this.Leg1R.setTextureSize(256, 128);
        this.Leg1R.mirror = true;
        this.setRotation(this.Leg1R, 0.0f, -0.3490659f, 0.6108652f);
        (this.Leg1Rpart2 = new ModelRenderer(this, 0, 92)).addBox(-1.5f, 0.0f, -1.5f, 3, 19, 3);
        this.Leg1Rpart2.setRotationPoint(-16.0f, 7.0f, -4.0f);
        this.Leg1Rpart2.setTextureSize(256, 128);
        this.Leg1Rpart2.mirror = true;
        this.setRotation(this.Leg1Rpart2, -0.0698132f, -0.3839724f, 0.4363323f);
        (this.Leg2R = new ModelRenderer(this, 0, 85)).addBox(-13.0f, -1.5f, -1.5f, 14, 3, 3);
        this.Leg2R.setRotationPoint(-7.0f, 15.0f, 3.0f);
        this.Leg2R.setTextureSize(256, 128);
        this.Leg2R.mirror = true;
        this.setRotation(this.Leg2R, 0.0f, -0.1745329f, 0.6108652f);
        (this.Leg2Rpart2 = new ModelRenderer(this, 0, 92)).addBox(-1.5f, 0.0f, -1.5f, 3, 19, 3);
        this.Leg2Rpart2.setRotationPoint(-16.0f, 7.0f, 1.5f);
        this.Leg2Rpart2.setTextureSize(256, 128);
        this.Leg2Rpart2.mirror = true;
        this.setRotation(this.Leg2Rpart2, -0.0349066f, -0.0698132f, 0.4363323f);
        (this.Leg3R = new ModelRenderer(this, 0, 85)).addBox(-13.0f, -1.5f, -1.5f, 14, 3, 3);
        this.Leg3R.setRotationPoint(-7.0f, 15.0f, 6.0f);
        this.Leg3R.setTextureSize(256, 128);
        this.Leg3R.mirror = true;
        this.setRotation(this.Leg3R, 0.0f, 0.1745329f, 0.6108652f);
        (this.Leg3Rpart2 = new ModelRenderer(this, 0, 92)).addBox(-1.5f, 0.0f, -1.5f, 3, 19, 3);
        this.Leg3Rpart2.setRotationPoint(-16.0f, 7.0f, 7.5f);
        this.Leg3Rpart2.setTextureSize(256, 128);
        this.Leg3Rpart2.mirror = true;
        this.setRotation(this.Leg3Rpart2, 0.0349066f, 0.1396263f, 0.4363323f);
        (this.Leg4R = new ModelRenderer(this, 0, 85)).addBox(-13.0f, -1.5f, -1.5f, 14, 3, 3);
        this.Leg4R.setRotationPoint(-7.0f, 15.0f, 10.0f);
        this.Leg4R.setTextureSize(256, 128);
        this.Leg4R.mirror = true;
        this.setRotation(this.Leg4R, 0.0f, 0.3490659f, 0.6108652f);
        (this.Leg4Rpart2 = new ModelRenderer(this, 0, 92)).addBox(-1.5f, 0.0f, -1.5f, 3, 19, 3);
        this.Leg4Rpart2.setRotationPoint(-16.0f, 7.0f, 13.0f);
        this.Leg4Rpart2.setTextureSize(256, 128);
        this.Leg4Rpart2.mirror = true;
        this.setRotation(this.Leg4Rpart2, 0.0698132f, 0.3490659f, 0.4363323f);
        (this.FangR = new ModelRenderer(this, 41, 0)).addBox(-1.5f, -1.0f, -3.0f, 3, 5, 3);
        this.FangR.setRotationPoint(-2.5f, 16.0f, -11.3f);
        this.FangR.setTextureSize(256, 128);
        this.FangR.mirror = true;
        this.setRotation(this.FangR, 0.1745329f, 0.0f, 0.0f);
        (this.FangL = new ModelRenderer(this, 41, 0)).addBox(-1.5f, -1.0f, -3.0f, 3, 5, 3);
        this.FangL.setRotationPoint(2.5f, 16.0f, -11.3f);
        this.FangL.setTextureSize(256, 128);
        this.FangL.mirror = true;
        this.setRotation(this.FangL, 0.1745329f, 0.0f, 0.0f);
    }
    
    @Override
	public void render(final Entity par1Entity, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        this.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
        this.Head.render(par7);
        this.Neck.render(par7);
        this.Body.render(par7);
        this.RearEnd.render(par7);
        this.Leg1L.render(par7);
        this.Leg1Lpart2.render(par7);
        this.Leg2L.render(par7);
        this.Leg2Lpart2.render(par7);
        this.Leg3L.render(par7);
        this.Leg3Lpart2.render(par7);
        this.Leg4L.render(par7);
        this.Leg4Lpart2.render(par7);
        this.Leg1R.render(par7);
        this.Leg1Rpart2.render(par7);
        this.Leg2R.render(par7);
        this.Leg2Rpart2.render(par7);
        this.Leg3R.render(par7);
        this.Leg3Rpart2.render(par7);
        this.Leg4R.render(par7);
        this.Leg4Rpart2.render(par7);
        this.FangR.render(par7);
        this.FangL.render(par7);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    @Override
	public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
        this.Leg1L.rotateAngleX = -MathHelper.cos(par1 * 0.6222f) * 2.0f * par2 * 0.5f;
        this.Leg1Lpart2.rotateAngleX = -MathHelper.cos(par1 * 0.6222f) * 2.0f * par2 * 0.5f;
        this.Leg1R.rotateAngleX = MathHelper.cos(par1 * 0.6222f) * 2.0f * par2 * 0.5f;
        this.Leg1Rpart2.rotateAngleX = MathHelper.cos(par1 * 0.6222f) * 2.0f * par2 * 0.5f;
        this.Leg2L.rotateAngleX = -MathHelper.cos(par1 * 0.6222f) * 2.0f * par2 * 0.5f;
        this.Leg2Lpart2.rotateAngleX = -MathHelper.cos(par1 * 0.6222f) * 2.0f * par2 * 0.5f;
        this.Leg2R.rotateAngleX = MathHelper.cos(par1 * 0.6222f) * 2.0f * par2 * 0.5f;
        this.Leg2Rpart2.rotateAngleX = MathHelper.cos(par1 * 0.6222f) * 2.0f * par2 * 0.5f;
        this.Leg3L.rotateAngleX = -MathHelper.cos(par1 * 0.6222f) * 2.0f * par2 * 0.5f;
        this.Leg3Lpart2.rotateAngleX = -MathHelper.cos(par1 * 0.6222f) * 2.0f * par2 * 0.5f;
        this.Leg3R.rotateAngleX = MathHelper.cos(par1 * 0.6222f) * 2.0f * par2 * 0.5f;
        this.Leg3Rpart2.rotateAngleX = MathHelper.cos(par1 * 0.6222f) * 2.0f * par2 * 0.5f;
        this.Leg4L.rotateAngleX = -MathHelper.cos(par1 * 0.6222f) * 2.0f * par2 * 0.5f;
        this.Leg4Lpart2.rotateAngleX = -MathHelper.cos(par1 * 0.6222f) * 2.0f * par2 * 0.5f;
        this.Leg4R.rotateAngleX = MathHelper.cos(par1 * 0.6222f) * 2.0f * par2 * 0.5f;
        this.Leg4Rpart2.rotateAngleX = MathHelper.cos(par1 * 0.6222f) * 2.0f * par2 * 0.5f;
    }
}
