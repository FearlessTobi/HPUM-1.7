package snidgert.harrypottermod.items;

import net.minecraft.item.*;
import net.minecraft.world.*;
import snidgert.harrypottermod.mobs.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;

import java.util.*;
import net.minecraft.util.*;

public class Motercycle2Class extends Item
{
    public Motercycle2Class() {
        this.setTextureName("harrypottermod:MCWS");
        this.setMaxStackSize(1);
    }
    
    @Override
	public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        final float f = 1.0f;
        final float f2 = ((Entity)par3EntityPlayer).prevRotationPitch + (((Entity)par3EntityPlayer).rotationPitch - ((Entity)par3EntityPlayer).prevRotationPitch) * f;
        final float f3 = ((Entity)par3EntityPlayer).prevRotationYaw + (((Entity)par3EntityPlayer).rotationYaw - ((Entity)par3EntityPlayer).prevRotationYaw) * f;
        final double d0 = ((Entity)par3EntityPlayer).prevPosX + (((Entity)par3EntityPlayer).posX - ((Entity)par3EntityPlayer).prevPosX) * f;
        final double d2 = ((Entity)par3EntityPlayer).prevPosY + (((Entity)par3EntityPlayer).posY - ((Entity)par3EntityPlayer).prevPosY) * f + 1.62 - ((Entity)par3EntityPlayer).yOffset;
        final double d3 = ((Entity)par3EntityPlayer).prevPosZ + (((Entity)par3EntityPlayer).posZ - ((Entity)par3EntityPlayer).prevPosZ) * f;
        final Vec3 vec3 = Vec3.createVectorHelper(d0, d2, d3);
        final float f4 = MathHelper.cos(-f3 * 0.017453292f - 3.1415927f);
        final float f5 = MathHelper.sin(-f3 * 0.017453292f - 3.1415927f);
        final float f6 = -MathHelper.cos(-f2 * 0.017453292f);
        final float f7 = MathHelper.sin(-f2 * 0.017453292f);
        final float f8 = f5 * f6;
        final float f9 = f4 * f6;
        final double d4 = 5.0;
        final Vec3 vec4 = vec3.addVector(f8 * d4, f7 * d4, f9 * d4);
        final MovingObjectPosition movingobjectposition = par2World.rayTraceBlocks(vec3, vec4, true);
        if (movingobjectposition == null) {
            return par1ItemStack;
        }
        final Vec3 vec5 = par3EntityPlayer.getLook(f);
        boolean flag = false;
        final float f10 = 1.0f;
        final List list = par2World.getEntitiesWithinAABBExcludingEntity(par3EntityPlayer, ((Entity)par3EntityPlayer).boundingBox.addCoord(vec5.xCoord * d4, vec5.yCoord * d4, vec5.zCoord * d4).expand(f10, f10, f10));
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
            return par1ItemStack;
        }
        if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
            final int i = movingobjectposition.blockX;
            int j = movingobjectposition.blockY;
            final int k = movingobjectposition.blockZ;
            if (par2World.getBlock(i, j, k) == Blocks.snow_layer) {
                --j;
            }
            final EntityMotorbike2 entityboat = new EntityMotorbike2(par2World, i + 0.5f, j + 1.0f, k + 0.5f);
            ((Entity)entityboat).rotationYaw = ((MathHelper.floor_double(((Entity)par3EntityPlayer).rotationYaw * 4.0f / 360.0f + 0.5) & 0x3) - 1) * 90;
            if (!par2World.getCollidingBoundingBoxes(entityboat, ((Entity)entityboat).boundingBox.expand(-0.1, -0.1, -0.1)).isEmpty()) {
                return par1ItemStack;
            }
            if (!par2World.isRemote) {
                par2World.spawnEntityInWorld(entityboat);
            }
            if (!par3EntityPlayer.capabilities.isCreativeMode) {
                --par1ItemStack.stackSize;
            }
        }
        return par1ItemStack;
    }
}
