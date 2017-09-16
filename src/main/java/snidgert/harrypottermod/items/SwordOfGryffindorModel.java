package snidgert.harrypottermod.items;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class SwordOfGryffindorModel extends ModelBase
{
    ModelRenderer Hilt;
    ModelRenderer Ruby1;
    ModelRenderer Guard;
    ModelRenderer Ruby2;
    ModelRenderer Ruby3;
    ModelRenderer Tip1;
    ModelRenderer Blade;
    ModelRenderer Tip2;
    ModelRenderer Tip3;
    
    public SwordOfGryffindorModel() {
        super.textureWidth = 128;
        super.textureHeight = 128;
        (this.Hilt = new ModelRenderer(this, 43, 49)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 6);
        this.Hilt.setRotationPoint(-6.5f, 10.0f, -2.0f);
        this.Hilt.setTextureSize(64, 32);
        this.Hilt.mirror = true;
        this.setRotation(this.Hilt, 0.0f, 0.0f, 0.55f);
        (this.Ruby1 = new ModelRenderer(this, 46, 58)).addBox(0.0f, -4.5f, 4.25f, 1, 1, 1);
        this.Ruby1.setRotationPoint(-6.5f, 10.0f, -2.0f);
        this.Ruby1.setTextureSize(64, 32);
        this.Ruby1.mirror = true;
        this.setRotation(this.Ruby1, -0.7853982f, 0.0f, 0.55f);
        (this.Guard = new ModelRenderer(this, 46, 41)).addBox(0.0f, -2.0f, -1.0f, 1, 5, 1);
        this.Guard.setRotationPoint(-6.5f, 10.0f, -2.0f);
        this.Guard.setTextureSize(64, 32);
        this.Guard.mirror = true;
        this.setRotation(this.Guard, 0.0f, 0.0f, 0.55f);
        (this.Ruby2 = new ModelRenderer(this, 57, 43)).addBox(0.0f, -1.8f, -2.5f, 1, 1, 1);
        this.Ruby2.setRotationPoint(-6.5f, 10.0f, -2.0f);
        this.Ruby2.setTextureSize(64, 32);
        this.Ruby2.mirror = true;
        this.setRotation(this.Ruby2, -0.7853982f, 0.0f, 0.55f);
        (this.Ruby3 = new ModelRenderer(this, 40, 41)).addBox(0.0f, 2.2f, 1.5f, 1, 1, 1);
        this.Ruby3.setRotationPoint(-6.5f, 10.0f, -2.0f);
        this.Ruby3.setTextureSize(64, 32);
        this.Ruby3.mirror = true;
        this.setRotation(this.Ruby3, -0.7853982f, 0.0f, 0.55f);
        (this.Tip1 = new ModelRenderer(this, 55, 20)).addBox(0.0f, -9.5f, -9.9f, 1, 1, 1);
        this.Tip1.setRotationPoint(-6.5f, 10.0f, -2.0f);
        this.Tip1.setTextureSize(64, 32);
        this.Tip1.mirror = true;
        this.setRotation(this.Tip1, 0.7853982f, 0.0f, 0.55f);
        (this.Blade = new ModelRenderer(this, 40, 23)).addBox(0.0f, -0.5f, -13.0f, 1, 2, 12);
        this.Blade.setRotationPoint(-6.5f, 10.0f, -2.0f);
        this.Blade.setTextureSize(64, 32);
        this.Blade.mirror = true;
        this.setRotation(this.Blade, 0.0f, 0.0f, 0.55f);
        (this.Tip2 = new ModelRenderer(this, 44, 20)).addBox(0.0f, -9.1f, -10.3f, 1, 1, 1);
        this.Tip2.setRotationPoint(-6.5f, 10.0f, -2.0f);
        this.Tip2.setTextureSize(64, 32);
        this.Tip2.mirror = true;
        this.setRotation(this.Tip2, 0.7853982f, 0.0f, 0.55f);
        (this.Tip3 = new ModelRenderer(this, 49, 16)).addBox(0.0f, -9.5f, -10.3f, 1, 1, 1);
        this.Tip3.setRotationPoint(-6.5f, 10.0f, -2.0f);
        this.Tip3.setTextureSize(64, 32);
        this.Tip3.mirror = true;
        this.setRotation(this.Tip3, 0.7853982f, 0.0f, 0.55f);
    }
    
    @Override
	public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Hilt.render(f5);
        this.Ruby1.render(f5);
        this.Guard.render(f5);
        this.Ruby2.render(f5);
        this.Ruby3.render(f5);
        this.Tip1.render(f5);
        this.Blade.render(f5);
        this.Tip2.render(f5);
        this.Tip3.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    @Override
	public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}
