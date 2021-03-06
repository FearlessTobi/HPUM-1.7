package snidgert.harrypottermod.mobs;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class Locket extends ModelBase
{
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    
    public Locket() {
        super.textureWidth = 128;
        super.textureHeight = 128;
        (this.Shape1 = new ModelRenderer(this, 0, 9)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 3);
        this.Shape1.setRotationPoint(0.0f, 23.0f, 0.0f);
        this.Shape1.setTextureSize(128, 128);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0.0f, 0.0f, 0.0f);
        (this.Shape2 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 2);
        this.Shape2.setRotationPoint(-0.5f, 23.0f, 0.5f);
        this.Shape2.setTextureSize(128, 128);
        this.Shape2.mirror = true;
        this.setRotation(this.Shape2, 0.0f, 0.0f, 0.0f);
    }
    
    @Override
	public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.Shape1.render(f5);
        this.Shape2.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void renderModel(final float f) {
        this.Shape1.render(f);
        this.Shape2.render(f);
    }
    
    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
    }
}
