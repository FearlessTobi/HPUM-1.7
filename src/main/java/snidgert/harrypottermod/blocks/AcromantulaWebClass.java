package snidgert.harrypottermod.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import snidgert.harrypottermod.MainClass;
import snidgert.harrypottermod.mobs.entity.EntityAragog;

public class AcromantulaWebClass extends Block
{
    public AcromantulaWebClass() {
        super(Material.web);
        this.setBlockTextureName("harrypottermod:AcromantulaWeb");
    }
    
    @Override
	public void onEntityCollidedWithBlock(final World p_149670_1_, final int p_149670_2_, final int p_149670_3_, final int p_149670_4_, final Entity p_149670_5_) {
        if (!(p_149670_5_ instanceof EntityAragog)) {
            p_149670_5_.setInWeb();
        }
    }
    
    @Override
	public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(final World p_149668_1_, final int p_149668_2_, final int p_149668_3_, final int p_149668_4_) {
        return null;
    }
    
    @Override
	public int getRenderType() {
        return 1;
    }
    
    @Override
	public boolean renderAsNormalBlock() {
        return false;
    }
    
    @Override
	public Item getItemDropped(final int p_149650_1_, final Random p_149650_2_, final int p_149650_3_) {
        return Item.getItemFromBlock(MainClass.AcromantulaWeb);
    }
    
    @Override
	protected boolean canSilkHarvest() {
        return true;
    }
}
