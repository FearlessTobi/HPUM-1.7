package snidgert.harrypottermod.mobs.entity;

import net.minecraft.entity.passive.*;
import net.minecraft.world.*;
import snidgert.harrypottermod.*;
import net.minecraft.init.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class EntityLevitate extends EntityAnimal
{
    public EntityLevitate(final World par1World) {
        super(par1World);
        this.setSize(1.0f, 1.0f);
    }
    
    @Override
	public void onUpdate() {
        final EntityPlayer player = this.worldObj.getClosestPlayer(this.posX, this.posY, this.posZ, 9.9999999999E10);
        if (!player.isSneaking()) {
            final Vec3 look = player.getLookVec();
            this.setPosition(((Entity)player).posX + look.xCoord * 1.5, ((Entity)player).posY + look.yCoord * 1.5, ((Entity)player).posZ + look.zCoord * 1.5);
        }
        if (player.isSneaking()) {
            this.setDead();
            final int x = (int)this.lastTickPosX;
            final int y = (int)this.lastTickPosY;
            final int z = (int)this.lastTickPosZ;
            if (this.worldObj.getBlock(x, y, z) == Blocks.air) {
                this.worldObj.setBlock(x, y, z, MainClass.WingardiumLeviosaBlock);
            }
        }
    }
    
    @Override
	public boolean isAIEnabled() {
        return true;
    }
    
    @Override
	public EntityAgeable createChild(final EntityAgeable entityageable) {
        return null;
    }
}
