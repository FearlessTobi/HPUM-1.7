package snidgert.harrypottermod.items;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import java.util.*;
import net.minecraft.util.*;

public class TridentClass extends ItemSword
{
    public TridentClass(final Item.ToolMaterial toolMaterial) {
        super(toolMaterial);
        this.setTextureName("harrypottermod:Trident");
        this.setMaxStackSize(1);
    }
    
    @Override
	public ItemStack onItemRightClick(final ItemStack itemstack, final World world, final EntityPlayer entityplayer) {
        final String s = EnumChatFormatting.getTextWithoutFormattingCodes(itemstack.getDisplayName());
        if (s.equals("The Trident of Poseidon")) {
            final float f = 1.0f;
            final float f2 = ((Entity)entityplayer).prevRotationPitch + (((Entity)entityplayer).rotationPitch - ((Entity)entityplayer).prevRotationPitch) * f;
            final float f3 = ((Entity)entityplayer).prevRotationYaw + (((Entity)entityplayer).rotationYaw - ((Entity)entityplayer).prevRotationYaw) * f;
            final double d0 = ((Entity)entityplayer).prevPosX + (((Entity)entityplayer).posX - ((Entity)entityplayer).prevPosX) * f;
            final double d2 = ((Entity)entityplayer).prevPosY + (((Entity)entityplayer).posY - ((Entity)entityplayer).prevPosY) * f + 1.62 - ((Entity)entityplayer).yOffset;
            final double d3 = ((Entity)entityplayer).prevPosZ + (((Entity)entityplayer).posZ - ((Entity)entityplayer).prevPosZ) * f;
            final Vec3 vec3 = Vec3.createVectorHelper(d0, d2, d3);
            final float f4 = MathHelper.cos(-f3 * 0.017453292f - 3.1415927f);
            final float f5 = MathHelper.sin(-f3 * 0.017453292f - 3.1415927f);
            final float f6 = -MathHelper.cos(-f2 * 0.017453292f);
            final float f7 = MathHelper.sin(-f2 * 0.017453292f);
            final float f8 = f5 * f6;
            final float f9 = f4 * f6;
            final double d4 = 5.0;
            final Vec3 vec4 = vec3.addVector(f8 * d4, f7 * d4, f9 * d4);
            final MovingObjectPosition movingobjectposition = world.rayTraceBlocks(vec3, vec4, true);
            if (movingobjectposition == null) {
                return itemstack;
            }
            final Vec3 vec5 = entityplayer.getLook(f);
            boolean flag = false;
            final float f10 = 1.0f;
            final List list = world.getEntitiesWithinAABBExcludingEntity(entityplayer, ((Entity)entityplayer).boundingBox.addCoord(vec5.xCoord * d4, vec5.yCoord * d4, vec5.zCoord * d4).expand(f10, f10, f10));
            for (int i = 0; i < list.size(); ++i) {
                final Entity entity = (Entity) list.get(i);
                if (entity.canBeCollidedWith()) {
                    final float f11 = entity.getCollisionBorderSize();
                    final AxisAlignedBB axisalignedbb = entity.boundingBox.expand(f11, f11, f11);
                    if (axisalignedbb.isVecInside(vec3)) {
                        flag = true;
                    }
                }
            }
            if (flag) {
                return itemstack;
            }
            if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                final int h = movingobjectposition.blockX;
                final int j = movingobjectposition.blockY;
                final int k = movingobjectposition.blockZ;
                if (world.isAirBlock(h, j + 1, k)) {
                    world.setBlock(h, j + 1, k, Blocks.flowing_water);
                }
            }
        }
        return itemstack;
    }
}
