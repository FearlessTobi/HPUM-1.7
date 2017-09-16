package snidgert.harrypottermod.mobs;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class Runespoor extends ModelBase
{
    ModelRenderer Head;
    ModelRenderer Head2;
    ModelRenderer Head3;
    ModelRenderer Tongue;
    ModelRenderer part1;
    ModelRenderer part2;
    ModelRenderer part3;
    ModelRenderer part4;
    ModelRenderer part5;
    ModelRenderer part6;
    ModelRenderer part7;
    ModelRenderer part8;
    ModelRenderer part9;
    ModelRenderer part10;
    ModelRenderer part11;
    ModelRenderer part12;
    ModelRenderer part13;
    ModelRenderer part14;
    ModelRenderer part15;
    ModelRenderer part16;
    ModelRenderer part17;
    ModelRenderer part18;
    ModelRenderer part19;
    
    public Runespoor() {
        super.textureWidth = 128;
        super.textureHeight = 64;
        (this.Head = new ModelRenderer(this, 0, 0)).addBox(-1.5f, -1.0f, -4.0f, 3, 2, 4);
        this.Head.setRotationPoint(0.0f, 23.0f, -17.0f);
        this.Head.setTextureSize(128, 64);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.Head2 = new ModelRenderer(this, 0, 0)).addBox(-1.5f, -1.0f, -4.0f, 3, 2, 4);
        this.Head2.setRotationPoint(5.0f, 23.0f, -15.5f);
        this.Head2.setTextureSize(128, 64);
        this.Head2.mirror = true;
        this.setRotation(this.Head2, 0.0f, 0.0f, 0.0f);
        (this.Head3 = new ModelRenderer(this, 0, 0)).addBox(-1.5f, -1.0f, -4.0f, 3, 2, 4);
        this.Head3.setRotationPoint(-5.0f, 23.0f, -15.5f);
        this.Head3.setTextureSize(128, 64);
        this.Head3.mirror = true;
        this.setRotation(this.Head3, 0.0f, 0.0f, 0.0f);
        (this.Tongue = new ModelRenderer(this, 0, 14)).addBox(-0.5f, 0.0f, -2.0f, 1, 0, 2);
        this.Tongue.setRotationPoint(0.0f, 23.0f, -20.5f);
        this.Tongue.setTextureSize(128, 64);
        this.Tongue.mirror = true;
        this.setRotation(this.Tongue, 0.0f, 0.0f, 0.0f);
        (this.part1 = new ModelRenderer(this, 0, 8)).addBox(-1.0f, -1.0f, 0.0f, 2, 2, 3);
        this.part1.setRotationPoint(0.0f, 23.0f, -17.0f);
        this.part1.setTextureSize(128, 64);
        this.part1.mirror = true;
        this.setRotation(this.part1, 0.0f, 0.0523599f, 0.0f);
        (this.part2 = new ModelRenderer(this, 0, 8)).addBox(-1.0f, -1.0f, 0.0f, 2, 2, 3);
        this.part2.setRotationPoint(0.0f, 23.0f, -14.0f);
        this.part2.setTextureSize(128, 64);
        this.part2.mirror = true;
        this.setRotation(this.part2, 0.0f, -0.0523599f, 0.0f);
        (this.part3 = new ModelRenderer(this, 0, 8)).addBox(-1.0f, -1.0f, 0.0f, 2, 2, 3);
        this.part3.setRotationPoint(0.0f, 23.0f, -11.0f);
        this.part3.setTextureSize(128, 64);
        this.part3.mirror = true;
        this.setRotation(this.part3, 0.0f, 0.0523599f, 0.0f);
        (this.part4 = new ModelRenderer(this, 0, 8)).addBox(-1.0f, -1.0f, 0.0f, 2, 2, 3);
        this.part4.setRotationPoint(0.0f, 23.0f, -8.0f);
        this.part4.setTextureSize(128, 64);
        this.part4.mirror = true;
        this.setRotation(this.part4, 0.0f, -0.0523599f, 0.0f);
        (this.part5 = new ModelRenderer(this, 0, 8)).addBox(-1.0f, -1.0f, 0.0f, 2, 2, 3);
        this.part5.setRotationPoint(0.0f, 23.0f, -5.0f);
        this.part5.setTextureSize(128, 64);
        this.part5.mirror = true;
        this.setRotation(this.part5, 0.0f, 0.0523599f, 0.0f);
        (this.part6 = new ModelRenderer(this, 0, 8)).addBox(-1.0f, -1.0f, 0.0f, 2, 2, 3);
        this.part6.setRotationPoint(0.0f, 23.0f, -2.0f);
        this.part6.setTextureSize(128, 64);
        this.part6.mirror = true;
        this.setRotation(this.part6, 0.0f, -0.0523599f, 0.0f);
        (this.part7 = new ModelRenderer(this, 0, 8)).addBox(-1.0f, -1.0f, 0.0f, 2, 2, 3);
        this.part7.setRotationPoint(0.0f, 23.0f, 1.0f);
        this.part7.setTextureSize(128, 64);
        this.part7.mirror = true;
        this.setRotation(this.part7, 0.0f, 0.0523599f, 0.0f);
        (this.part8 = new ModelRenderer(this, 0, 8)).addBox(-1.0f, -1.0f, 0.0f, 2, 2, 3);
        this.part8.setRotationPoint(0.0f, 23.0f, 4.0f);
        this.part8.setTextureSize(128, 64);
        this.part8.mirror = true;
        this.setRotation(this.part8, 0.0f, -0.0523599f, 0.0f);
        (this.part9 = new ModelRenderer(this, 0, 8)).addBox(-1.0f, -1.0f, 0.0f, 2, 2, 3);
        this.part9.setRotationPoint(0.0f, 23.0f, 7.0f);
        this.part9.setTextureSize(128, 64);
        this.part9.mirror = true;
        this.setRotation(this.part9, 0.0f, 0.0523599f, 0.0f);
        (this.part10 = new ModelRenderer(this, 0, 8)).addBox(-1.0f, -1.0f, 0.0f, 2, 2, 3);
        this.part10.setRotationPoint(0.0f, 23.0f, 10.0f);
        this.part10.setTextureSize(128, 64);
        this.part10.mirror = true;
        this.setRotation(this.part10, 0.0f, -0.0523599f, 0.0f);
        (this.part11 = new ModelRenderer(this, 0, 8)).addBox(-1.0f, -1.0f, 0.0f, 2, 2, 3);
        this.part11.setRotationPoint(0.0f, 23.0f, 13.0f);
        this.part11.setTextureSize(128, 64);
        this.part11.mirror = true;
        this.setRotation(this.part11, 0.0f, 0.0523599f, 0.0f);
        (this.part12 = new ModelRenderer(this, 0, 8)).addBox(-1.0f, -1.0f, 0.0f, 2, 2, 3);
        this.part12.setRotationPoint(-5.0f, 23.0f, -15.5f);
        this.part12.setTextureSize(128, 64);
        this.part12.mirror = true;
        this.setRotation(this.part12, 0.0f, 0.0872665f, 0.0f);
        (this.part13 = new ModelRenderer(this, 0, 8)).addBox(-1.0f, -1.0f, 0.0f, 2, 2, 3);
        this.part13.setRotationPoint(-4.6f, 23.0f, -12.5f);
        this.part13.setTextureSize(128, 64);
        this.part13.mirror = true;
        this.setRotation(this.part13, 0.0f, 0.296706f, 0.0f);
        (this.part14 = new ModelRenderer(this, 0, 8)).addBox(-1.0f, -1.0f, 0.0f, 2, 2, 3);
        this.part14.setRotationPoint(-4.0f, 23.0f, -10.0f);
        this.part14.setTextureSize(128, 64);
        this.part14.mirror = true;
        this.setRotation(this.part14, 0.0f, 0.6632251f, 0.0f);
        (this.part15 = new ModelRenderer(this, 0, 8)).addBox(-1.0f, -1.0f, 0.0f, 2, 2, 3);
        this.part15.setRotationPoint(-2.5f, 23.0f, -8.0f);
        this.part15.setTextureSize(128, 64);
        this.part15.mirror = true;
        this.setRotation(this.part15, -0.0174533f, 0.6981317f, 0.0f);
        (this.part16 = new ModelRenderer(this, 0, 8)).addBox(-1.0f, -1.0f, 0.0f, 2, 2, 3);
        this.part16.setRotationPoint(5.0f, 23.0f, -15.5f);
        this.part16.setTextureSize(128, 64);
        this.part16.mirror = true;
        this.setRotation(this.part16, 0.0f, -0.0872665f, 0.0f);
        (this.part17 = new ModelRenderer(this, 0, 8)).addBox(-1.0f, -1.0f, 0.0f, 2, 2, 3);
        this.part17.setRotationPoint(4.6f, 23.0f, -12.5f);
        this.part17.setTextureSize(128, 64);
        this.part17.mirror = true;
        this.setRotation(this.part17, 0.0f, -0.296706f, 0.0f);
        (this.part18 = new ModelRenderer(this, 0, 8)).addBox(-1.0f, -1.0f, 0.0f, 2, 2, 3);
        this.part18.setRotationPoint(4.0f, 23.0f, -10.0f);
        this.part18.setTextureSize(128, 64);
        this.part18.mirror = true;
        this.setRotation(this.part18, 0.0f, -0.6632251f, 0.0f);
        (this.part19 = new ModelRenderer(this, 0, 8)).addBox(-1.0f, -1.0f, 0.0f, 2, 2, 3);
        this.part19.setRotationPoint(2.5f, 23.0f, -8.0f);
        this.part19.setTextureSize(128, 64);
        this.part19.mirror = true;
        this.setRotation(this.part19, -0.0174533f, -0.6981317f, 0.0f);
    }
    
    @Override
	public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.Head.render(f5);
        this.Head2.render(f5);
        this.Head3.render(f5);
        this.Tongue.render(f5);
        this.part1.render(f5);
        this.part2.render(f5);
        this.part3.render(f5);
        this.part4.render(f5);
        this.part5.render(f5);
        this.part6.render(f5);
        this.part7.render(f5);
        this.part8.render(f5);
        this.part9.render(f5);
        this.part10.render(f5);
        this.part11.render(f5);
        this.part12.render(f5);
        this.part13.render(f5);
        this.part14.render(f5);
        this.part15.render(f5);
        this.part16.render(f5);
        this.part17.render(f5);
        this.part18.render(f5);
        this.part19.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
    }
}
