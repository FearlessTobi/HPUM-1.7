package snidgert.harrypottermod.items;

import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import snidgert.harrypottermod.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.entity.*;

public class PutOuterClass extends Item
{
    public boolean PrevSpell;
    public boolean NextSpell;
    
    public PutOuterClass() {
        this.setCreativeTab(CreativeTabs.tabCombat);
        this.setTextureName("harrypottermod:PutOuter");
        this.setMaxStackSize(1);
    }
    
    @Override
	public ItemStack onItemRightClick(final ItemStack itemstack, final World world, final EntityPlayer entityplayer) {
        final int i = MathHelper.floor_double(Minecraft.getMinecraft().objectMouseOver.blockX);
        int j = MathHelper.floor_double(Minecraft.getMinecraft().objectMouseOver.blockZ);
        j = MathHelper.floor_double(Minecraft.getMinecraft().objectMouseOver.blockX + (i % 2 * 2 - 1) * 0.25f);
        final int k = MathHelper.floor_double(Minecraft.getMinecraft().objectMouseOver.blockY);
        final int l = MathHelper.floor_double(Minecraft.getMinecraft().objectMouseOver.blockZ + (i / 2 % 2 * 2 - 1) * 0.25f);
        world.playSoundEffect(((Entity)entityplayer).posX + 0.5, ((Entity)entityplayer).posY + 0.5, ((Entity)entityplayer).posZ + 0.5, "harrypottermod:Deluminator", 1.0f, Item.itemRand.nextFloat() * 0.4f + 0.8f);
        if (world.getBlock(j, k, l) == Blocks.torch) {
            world.setBlock(j, k, l, MainClass.TorchOff);
        }
        if (world.getBlock(j + 1, k, l) == Blocks.torch) {
            world.setBlock(j + 1, k, l, MainClass.TorchOff);
        }
        if (world.getBlock(j + 2, k, l) == Blocks.torch) {
            world.setBlock(j + 2, k, l, MainClass.TorchOff);
        }
        if (world.getBlock(j - 1, k, l) == Blocks.torch) {
            world.setBlock(j - 1, k, l, MainClass.TorchOff);
        }
        if (world.getBlock(j - 2, k, l) == Blocks.torch) {
            world.setBlock(j - 2, k, l, MainClass.TorchOff);
        }
        if (world.getBlock(j, k, l - 1) == Blocks.torch) {
            world.setBlock(j, k, l - 1, MainClass.TorchOff);
        }
        if (world.getBlock(j, k, l - 2) == Blocks.torch) {
            world.setBlock(j, k, l - 2, MainClass.TorchOff);
        }
        if (world.getBlock(j, k, l + 1) == Blocks.torch) {
            world.setBlock(j, k, l + 1, MainClass.TorchOff);
        }
        if (world.getBlock(j, k, l + 2) == Blocks.torch) {
            world.setBlock(j, k, l + 2, MainClass.TorchOff);
        }
        if (world.getBlock(j + 1, k, l - 1) == Blocks.torch) {
            world.setBlock(j + 1, k, l - 1, MainClass.TorchOff);
        }
        if (world.getBlock(j + 2, k, l - 1) == Blocks.torch) {
            world.setBlock(j + 2, k, l - 1, MainClass.TorchOff);
        }
        if (world.getBlock(j - 1, k, l - 1) == Blocks.torch) {
            world.setBlock(j - 1, k, l - 1, MainClass.TorchOff);
        }
        if (world.getBlock(j - 2, k, l - 1) == Blocks.torch) {
            world.setBlock(j - 2, k, l - 1, MainClass.TorchOff);
        }
        if (world.getBlock(j - 1, k, l + 1) == Blocks.torch) {
            world.setBlock(j - 1, k, l + 1, MainClass.TorchOff);
        }
        if (world.getBlock(j - 1, k, l - 2) == Blocks.torch) {
            world.setBlock(j - 1, k, l - 2, MainClass.TorchOff);
        }
        if (world.getBlock(j + 1, k, l + 1) == Blocks.torch) {
            world.setBlock(j + 1, k, l + 1, MainClass.TorchOff);
        }
        if (world.getBlock(j - 1, k, l + 2) == Blocks.torch) {
            world.setBlock(j - 1, k, l + 2, MainClass.TorchOff);
        }
        if (world.getBlock(j - 2, k, l - 2) == Blocks.torch) {
            world.setBlock(j - 2, k, l - 2, MainClass.TorchOff);
        }
        if (world.getBlock(j + 2, k, l - 2) == Blocks.torch) {
            world.setBlock(j + 2, k, l - 2, MainClass.TorchOff);
        }
        if (world.getBlock(j - 2, k, l + 2) == Blocks.torch) {
            world.setBlock(j - 2, k, l + 2, MainClass.TorchOff);
        }
        if (world.getBlock(j + 2, k, l + 2) == Blocks.torch) {
            world.setBlock(j + 2, k, l + 2, MainClass.TorchOff);
        }
        if (world.getBlock(j + 1, k, l + 2) == Blocks.torch) {
            world.setBlock(j + 1, k, l + 2, MainClass.TorchOff);
        }
        if (world.getBlock(j + 2, k, l + 1) == Blocks.torch) {
            world.setBlock(j + 2, k, l + 1, MainClass.TorchOff);
        }
        if (world.getBlock(j + 1, k, l - 2) == Blocks.torch) {
            world.setBlock(j + 1, k, l - 2, MainClass.TorchOff);
        }
        if (world.getBlock(j - 2, k, l + 1) == Blocks.torch) {
            world.setBlock(j - 2, k, l + 1, MainClass.TorchOff);
        }
        if (world.getBlock(j, k - 1, l) == Blocks.torch) {
            world.setBlock(j, k - 1, l, MainClass.TorchOff);
        }
        if (world.getBlock(j + 1, k - 1, l) == Blocks.torch) {
            world.setBlock(j + 1, k - 1, l, MainClass.TorchOff);
        }
        if (world.getBlock(j + 2, k - 1, l) == Blocks.torch) {
            world.setBlock(j + 2, k - 1, l, MainClass.TorchOff);
        }
        if (world.getBlock(j - 1, k - 1, l) == Blocks.torch) {
            world.setBlock(j - 1, k - 1, l, MainClass.TorchOff);
        }
        if (world.getBlock(j - 2, k - 1, l) == Blocks.torch) {
            world.setBlock(j - 2, k - 1, l, MainClass.TorchOff);
        }
        if (world.getBlock(j, k - 1, l - 1) == Blocks.torch) {
            world.setBlock(j, k - 1, l - 1, MainClass.TorchOff);
        }
        if (world.getBlock(j, k - 1, l - 2) == Blocks.torch) {
            world.setBlock(j, k - 1, l - 2, MainClass.TorchOff);
        }
        if (world.getBlock(j, k - 1, l + 1) == Blocks.torch) {
            world.setBlock(j, k - 1, l + 1, MainClass.TorchOff);
        }
        if (world.getBlock(j, k - 1, l + 2) == Blocks.torch) {
            world.setBlock(j, k - 1, l + 2, MainClass.TorchOff);
        }
        if (world.getBlock(j + 1, k - 1, l - 1) == Blocks.torch) {
            world.setBlock(j + 1, k - 1, l - 1, MainClass.TorchOff);
        }
        if (world.getBlock(j + 2, k - 1, l - 1) == Blocks.torch) {
            world.setBlock(j + 2, k - 1, l - 1, MainClass.TorchOff);
        }
        if (world.getBlock(j - 1, k - 1, l - 1) == Blocks.torch) {
            world.setBlock(j - 1, k - 1, l - 1, MainClass.TorchOff);
        }
        if (world.getBlock(j - 2, k - 1, l - 1) == Blocks.torch) {
            world.setBlock(j - 2, k - 1, l - 1, MainClass.TorchOff);
        }
        if (world.getBlock(j - 1, k - 1, l + 1) == Blocks.torch) {
            world.setBlock(j - 1, k - 1, l + 1, MainClass.TorchOff);
        }
        if (world.getBlock(j - 1, k - 1, l - 2) == Blocks.torch) {
            world.setBlock(j - 1, k - 1, l - 2, MainClass.TorchOff);
        }
        if (world.getBlock(j + 1, k - 1, l + 1) == Blocks.torch) {
            world.setBlock(j + 1, k - 1, l + 1, MainClass.TorchOff);
        }
        if (world.getBlock(j - 1, k - 1, l + 2) == Blocks.torch) {
            world.setBlock(j - 1, k - 1, l + 2, MainClass.TorchOff);
        }
        if (world.getBlock(j - 2, k - 1, l - 2) == Blocks.torch) {
            world.setBlock(j - 2, k - 1, l - 2, MainClass.TorchOff);
        }
        if (world.getBlock(j + 2, k - 1, l - 2) == Blocks.torch) {
            world.setBlock(j + 2, k - 1, l - 2, MainClass.TorchOff);
        }
        if (world.getBlock(j - 2, k - 1, l + 2) == Blocks.torch) {
            world.setBlock(j - 2, k - 1, l + 2, MainClass.TorchOff);
        }
        if (world.getBlock(j + 2, k - 1, l + 2) == Blocks.torch) {
            world.setBlock(j + 2, k - 1, l + 2, MainClass.TorchOff);
        }
        if (world.getBlock(j + 1, k - 1, l + 2) == Blocks.torch) {
            world.setBlock(j + 1, k - 1, l + 2, MainClass.TorchOff);
        }
        if (world.getBlock(j + 2, k - 1, l + 1) == Blocks.torch) {
            world.setBlock(j + 2, k - 1, l + 1, MainClass.TorchOff);
        }
        if (world.getBlock(j + 1, k - 1, l - 2) == Blocks.torch) {
            world.setBlock(j + 1, k - 1, l - 2, MainClass.TorchOff);
        }
        if (world.getBlock(j - 2, k - 1, l + 1) == Blocks.torch) {
            world.setBlock(j - 2, k - 1, l + 1, MainClass.TorchOff);
        }
        if (world.getBlock(j, k + 1, l) == Blocks.torch) {
            world.setBlock(j, k + 1, l, MainClass.TorchOff);
        }
        if (world.getBlock(j + 1, k + 1, l) == Blocks.torch) {
            world.setBlock(j + 1, k + 1, l, MainClass.TorchOff);
        }
        if (world.getBlock(j + 2, k + 1, l) == Blocks.torch) {
            world.setBlock(j + 2, k + 1, l, MainClass.TorchOff);
        }
        if (world.getBlock(j - 1, k + 1, l) == Blocks.torch) {
            world.setBlock(j - 1, k + 1, l, MainClass.TorchOff);
        }
        if (world.getBlock(j - 2, k + 1, l) == Blocks.torch) {
            world.setBlock(j - 2, k + 1, l, MainClass.TorchOff);
        }
        if (world.getBlock(j, k + 1, l - 1) == Blocks.torch) {
            world.setBlock(j, k + 1, l - 1, MainClass.TorchOff);
        }
        if (world.getBlock(j, k + 1, l - 2) == Blocks.torch) {
            world.setBlock(j, k + 1, l - 2, MainClass.TorchOff);
        }
        if (world.getBlock(j, k + 1, l + 1) == Blocks.torch) {
            world.setBlock(j, k + 1, l + 1, MainClass.TorchOff);
        }
        if (world.getBlock(j, k + 1, l + 2) == Blocks.torch) {
            world.setBlock(j, k + 1, l + 2, MainClass.TorchOff);
        }
        if (world.getBlock(j + 1, k + 1, l - 1) == Blocks.torch) {
            world.setBlock(j + 1, k + 1, l - 1, MainClass.TorchOff);
        }
        if (world.getBlock(j + 2, k + 1, l - 1) == Blocks.torch) {
            world.setBlock(j + 2, k + 1, l - 1, MainClass.TorchOff);
        }
        if (world.getBlock(j - 1, k + 1, l - 1) == Blocks.torch) {
            world.setBlock(j - 1, k + 1, l - 1, MainClass.TorchOff);
        }
        if (world.getBlock(j - 2, k + 1, l - 1) == Blocks.torch) {
            world.setBlock(j - 2, k + 1, l - 1, MainClass.TorchOff);
        }
        if (world.getBlock(j - 1, k + 1, l + 1) == Blocks.torch) {
            world.setBlock(j - 1, k + 1, l + 1, MainClass.TorchOff);
        }
        if (world.getBlock(j - 1, k + 1, l - 2) == Blocks.torch) {
            world.setBlock(j - 1, k + 1, l - 2, MainClass.TorchOff);
        }
        if (world.getBlock(j + 1, k + 1, l + 1) == Blocks.torch) {
            world.setBlock(j + 1, k + 1, l + 1, MainClass.TorchOff);
        }
        if (world.getBlock(j - 1, k + 1, l + 2) == Blocks.torch) {
            world.setBlock(j - 1, k + 1, l + 2, MainClass.TorchOff);
        }
        if (world.getBlock(j - 2, k + 1, l - 2) == Blocks.torch) {
            world.setBlock(j - 2, k + 1, l - 2, MainClass.TorchOff);
        }
        if (world.getBlock(j + 2, k + 1, l - 2) == Blocks.torch) {
            world.setBlock(j + 2, k + 1, l - 2, MainClass.TorchOff);
        }
        if (world.getBlock(j - 2, k + 1, l + 2) == Blocks.torch) {
            world.setBlock(j - 2, k + 1, l + 2, MainClass.TorchOff);
        }
        if (world.getBlock(j + 2, k + 1, l + 2) == Blocks.torch) {
            world.setBlock(j + 2, k + 1, l + 2, MainClass.TorchOff);
        }
        if (world.getBlock(j + 1, k + 1, l + 2) == Blocks.torch) {
            world.setBlock(j + 1, k + 1, l + 2, MainClass.TorchOff);
        }
        if (world.getBlock(j + 2, k + 1, l + 1) == Blocks.torch) {
            world.setBlock(j + 2, k + 1, l + 1, MainClass.TorchOff);
        }
        if (world.getBlock(j + 1, k + 1, l - 2) == Blocks.torch) {
            world.setBlock(j + 1, k + 1, l - 2, MainClass.TorchOff);
        }
        if (world.getBlock(j - 2, k + 1, l + 1) == Blocks.torch) {
            world.setBlock(j - 2, k + 1, l + 1, MainClass.TorchOff);
        }
        if (world.getBlock(j, k - 2, l) == Blocks.torch) {
            world.setBlock(j, k - 2, l, MainClass.TorchOff);
        }
        if (world.getBlock(j + 1, k - 2, l) == Blocks.torch) {
            world.setBlock(j + 1, k - 2, l, MainClass.TorchOff);
        }
        if (world.getBlock(j + 2, k - 2, l) == Blocks.torch) {
            world.setBlock(j + 2, k - 2, l, MainClass.TorchOff);
        }
        if (world.getBlock(j - 1, k - 2, l) == Blocks.torch) {
            world.setBlock(j - 1, k - 2, l, MainClass.TorchOff);
        }
        if (world.getBlock(j - 2, k - 2, l) == Blocks.torch) {
            world.setBlock(j - 2, k - 2, l, MainClass.TorchOff);
        }
        if (world.getBlock(j, k - 2, l - 1) == Blocks.torch) {
            world.setBlock(j, k - 2, l - 1, MainClass.TorchOff);
        }
        if (world.getBlock(j, k - 2, l - 2) == Blocks.torch) {
            world.setBlock(j, k - 2, l - 2, MainClass.TorchOff);
        }
        if (world.getBlock(j, k - 2, l + 1) == Blocks.torch) {
            world.setBlock(j, k - 2, l + 1, MainClass.TorchOff);
        }
        if (world.getBlock(j, k - 2, l + 2) == Blocks.torch) {
            world.setBlock(j, k - 2, l + 2, MainClass.TorchOff);
        }
        if (world.getBlock(j + 1, k - 2, l - 1) == Blocks.torch) {
            world.setBlock(j + 1, k - 2, l - 1, MainClass.TorchOff);
        }
        if (world.getBlock(j + 2, k - 2, l - 1) == Blocks.torch) {
            world.setBlock(j + 2, k - 2, l - 1, MainClass.TorchOff);
        }
        if (world.getBlock(j - 1, k - 2, l - 1) == Blocks.torch) {
            world.setBlock(j - 1, k - 2, l - 1, MainClass.TorchOff);
        }
        if (world.getBlock(j - 2, k - 2, l - 1) == Blocks.torch) {
            world.setBlock(j - 2, k - 2, l - 1, MainClass.TorchOff);
        }
        if (world.getBlock(j - 1, k - 2, l + 1) == Blocks.torch) {
            world.setBlock(j - 1, k - 2, l + 1, MainClass.TorchOff);
        }
        if (world.getBlock(j - 1, k - 2, l - 2) == Blocks.torch) {
            world.setBlock(j - 1, k - 2, l - 2, MainClass.TorchOff);
        }
        if (world.getBlock(j + 1, k - 2, l + 1) == Blocks.torch) {
            world.setBlock(j + 1, k - 2, l + 1, MainClass.TorchOff);
        }
        if (world.getBlock(j - 1, k - 2, l + 2) == Blocks.torch) {
            world.setBlock(j - 1, k - 2, l + 2, MainClass.TorchOff);
        }
        if (world.getBlock(j - 2, k - 2, l - 2) == Blocks.torch) {
            world.setBlock(j - 2, k - 2, l - 2, MainClass.TorchOff);
        }
        if (world.getBlock(j + 2, k - 2, l - 2) == Blocks.torch) {
            world.setBlock(j + 2, k - 2, l - 2, MainClass.TorchOff);
        }
        if (world.getBlock(j - 2, k - 2, l + 2) == Blocks.torch) {
            world.setBlock(j - 2, k - 2, l + 2, MainClass.TorchOff);
        }
        if (world.getBlock(j + 2, k - 2, l + 2) == Blocks.torch) {
            world.setBlock(j + 2, k - 2, l + 2, MainClass.TorchOff);
        }
        if (world.getBlock(j + 1, k - 2, l + 2) == Blocks.torch) {
            world.setBlock(j + 1, k - 2, l + 2, MainClass.TorchOff);
        }
        if (world.getBlock(j + 2, k - 2, l + 1) == Blocks.torch) {
            world.setBlock(j + 2, k - 2, l + 1, MainClass.TorchOff);
        }
        if (world.getBlock(j + 1, k - 2, l - 2) == Blocks.torch) {
            world.setBlock(j + 1, k - 2, l - 2, MainClass.TorchOff);
        }
        if (world.getBlock(j - 2, k - 2, l + 1) == Blocks.torch) {
            world.setBlock(j - 2, k - 2, l + 1, MainClass.TorchOff);
        }
        if (world.getBlock(j, k + 2, l) == Blocks.torch) {
            world.setBlock(j, k + 2, l, MainClass.TorchOff);
        }
        if (world.getBlock(j + 1, k + 2, l) == Blocks.torch) {
            world.setBlock(j + 1, k + 2, l, MainClass.TorchOff);
        }
        if (world.getBlock(j + 2, k + 2, l) == Blocks.torch) {
            world.setBlock(j + 2, k + 2, l, MainClass.TorchOff);
        }
        if (world.getBlock(j - 1, k + 2, l) == Blocks.torch) {
            world.setBlock(j - 1, k + 2, l, MainClass.TorchOff);
        }
        if (world.getBlock(j - 2, k + 2, l) == Blocks.torch) {
            world.setBlock(j - 2, k + 2, l, MainClass.TorchOff);
        }
        if (world.getBlock(j, k + 2, l - 1) == Blocks.torch) {
            world.setBlock(j, k + 2, l - 1, MainClass.TorchOff);
        }
        if (world.getBlock(j, k + 2, l - 2) == Blocks.torch) {
            world.setBlock(j, k + 2, l - 2, MainClass.TorchOff);
        }
        if (world.getBlock(j, k + 2, l + 1) == Blocks.torch) {
            world.setBlock(j, k + 2, l + 1, MainClass.TorchOff);
        }
        if (world.getBlock(j, k + 2, l + 2) == Blocks.torch) {
            world.setBlock(j, k + 2, l + 2, MainClass.TorchOff);
        }
        if (world.getBlock(j + 1, k + 2, l - 1) == Blocks.torch) {
            world.setBlock(j + 1, k + 2, l - 1, MainClass.TorchOff);
        }
        if (world.getBlock(j + 2, k + 2, l - 1) == Blocks.torch) {
            world.setBlock(j + 2, k + 2, l - 1, MainClass.TorchOff);
        }
        if (world.getBlock(j - 1, k + 2, l - 1) == Blocks.torch) {
            world.setBlock(j - 1, k + 2, l - 1, MainClass.TorchOff);
        }
        if (world.getBlock(j - 2, k + 2, l - 1) == Blocks.torch) {
            world.setBlock(j - 2, k + 2, l - 1, MainClass.TorchOff);
        }
        if (world.getBlock(j - 1, k + 2, l + 1) == Blocks.torch) {
            world.setBlock(j - 1, k + 2, l + 1, MainClass.TorchOff);
        }
        if (world.getBlock(j - 1, k + 2, l - 2) == Blocks.torch) {
            world.setBlock(j - 1, k + 2, l - 2, MainClass.TorchOff);
        }
        if (world.getBlock(j + 1, k + 2, l + 1) == Blocks.torch) {
            world.setBlock(j + 1, k + 2, l + 1, MainClass.TorchOff);
        }
        if (world.getBlock(j - 1, k + 2, l + 2) == Blocks.torch) {
            world.setBlock(j - 1, k + 2, l + 2, MainClass.TorchOff);
        }
        if (world.getBlock(j - 2, k + 2, l - 2) == Blocks.torch) {
            world.setBlock(j - 2, k + 2, l - 2, MainClass.TorchOff);
        }
        if (world.getBlock(j + 2, k + 2, l - 2) == Blocks.torch) {
            world.setBlock(j + 2, k + 2, l - 2, MainClass.TorchOff);
        }
        if (world.getBlock(j - 2, k + 2, l + 2) == Blocks.torch) {
            world.setBlock(j - 2, k + 2, l + 2, MainClass.TorchOff);
        }
        if (world.getBlock(j + 2, k + 2, l + 2) == Blocks.torch) {
            world.setBlock(j + 2, k + 2, l + 2, MainClass.TorchOff);
        }
        if (world.getBlock(j + 1, k + 2, l + 2) == Blocks.torch) {
            world.setBlock(j + 1, k + 2, l + 2, MainClass.TorchOff);
        }
        if (world.getBlock(j + 2, k + 2, l + 1) == Blocks.torch) {
            world.setBlock(j + 2, k + 2, l + 1, MainClass.TorchOff);
        }
        if (world.getBlock(j + 1, k + 2, l - 2) == Blocks.torch) {
            world.setBlock(j + 1, k + 2, l - 2, MainClass.TorchOff);
        }
        if (world.getBlock(j - 2, k + 2, l + 1) == Blocks.torch) {
            world.setBlock(j - 2, k + 2, l + 1, MainClass.TorchOff);
        }
        if (world.getBlock(j, k, l) == Blocks.redstone_lamp) {
            world.setBlock(j, k, l, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k, l) == Blocks.redstone_lamp) {
            world.setBlock(j + 1, k, l, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k, l) == Blocks.redstone_lamp) {
            world.setBlock(j + 2, k, l, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k, l) == Blocks.redstone_lamp) {
            world.setBlock(j - 1, k, l, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k, l) == Blocks.redstone_lamp) {
            world.setBlock(j - 2, k, l, MainClass.LampOff);
        }
        if (world.getBlock(j, k, l - 1) == Blocks.redstone_lamp) {
            world.setBlock(j, k, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j, k, l - 2) == Blocks.redstone_lamp) {
            world.setBlock(j, k, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j, k, l + 1) == Blocks.redstone_lamp) {
            world.setBlock(j, k, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j, k, l + 2) == Blocks.redstone_lamp) {
            world.setBlock(j, k, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k, l - 1) == Blocks.redstone_lamp) {
            world.setBlock(j + 1, k, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k, l - 1) == Blocks.redstone_lamp) {
            world.setBlock(j + 2, k, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k, l - 1) == Blocks.redstone_lamp) {
            world.setBlock(j - 1, k, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k, l - 1) == Blocks.redstone_lamp) {
            world.setBlock(j - 2, k, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k, l + 1) == Blocks.redstone_lamp) {
            world.setBlock(j - 1, k, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k, l - 2) == Blocks.redstone_lamp) {
            world.setBlock(j - 1, k, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k, l + 1) == Blocks.redstone_lamp) {
            world.setBlock(j + 1, k, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k, l + 2) == Blocks.redstone_lamp) {
            world.setBlock(j - 1, k, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k, l - 2) == Blocks.redstone_lamp) {
            world.setBlock(j - 2, k, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k, l - 2) == Blocks.redstone_lamp) {
            world.setBlock(j + 2, k, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k, l + 2) == Blocks.redstone_lamp) {
            world.setBlock(j - 2, k, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k, l + 2) == Blocks.redstone_lamp) {
            world.setBlock(j + 2, k, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k, l + 2) == Blocks.redstone_lamp) {
            world.setBlock(j + 1, k, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k, l + 1) == Blocks.redstone_lamp) {
            world.setBlock(j + 2, k, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k, l - 2) == Blocks.redstone_lamp) {
            world.setBlock(j + 1, k, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k, l + 1) == Blocks.redstone_lamp) {
            world.setBlock(j - 2, k, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j, k - 1, l) == Blocks.redstone_lamp) {
            world.setBlock(j, k - 1, l, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k - 1, l) == Blocks.redstone_lamp) {
            world.setBlock(j + 1, k - 1, l, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k - 1, l) == Blocks.redstone_lamp) {
            world.setBlock(j + 2, k - 1, l, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k - 1, l) == Blocks.redstone_lamp) {
            world.setBlock(j - 1, k - 1, l, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k - 1, l) == Blocks.redstone_lamp) {
            world.setBlock(j - 2, k - 1, l, MainClass.LampOff);
        }
        if (world.getBlock(j, k - 1, l - 1) == Blocks.redstone_lamp) {
            world.setBlock(j, k - 1, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j, k - 1, l - 2) == Blocks.redstone_lamp) {
            world.setBlock(j, k - 1, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j, k - 1, l + 1) == Blocks.redstone_lamp) {
            world.setBlock(j, k - 1, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j, k - 1, l + 2) == Blocks.redstone_lamp) {
            world.setBlock(j, k - 1, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k - 1, l - 1) == Blocks.redstone_lamp) {
            world.setBlock(j + 1, k - 1, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k - 1, l - 1) == Blocks.redstone_lamp) {
            world.setBlock(j + 2, k - 1, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k - 1, l - 1) == Blocks.redstone_lamp) {
            world.setBlock(j - 1, k - 1, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k - 1, l - 1) == Blocks.redstone_lamp) {
            world.setBlock(j - 2, k - 1, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k - 1, l + 1) == Blocks.redstone_lamp) {
            world.setBlock(j - 1, k - 1, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k - 1, l - 2) == Blocks.redstone_lamp) {
            world.setBlock(j - 1, k - 1, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k - 1, l + 1) == Blocks.redstone_lamp) {
            world.setBlock(j + 1, k - 1, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k - 1, l + 2) == Blocks.redstone_lamp) {
            world.setBlock(j - 1, k - 1, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k - 1, l - 2) == Blocks.redstone_lamp) {
            world.setBlock(j - 2, k - 1, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k - 1, l - 2) == Blocks.redstone_lamp) {
            world.setBlock(j + 2, k - 1, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k - 1, l + 2) == Blocks.redstone_lamp) {
            world.setBlock(j - 2, k - 1, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k - 1, l + 2) == Blocks.redstone_lamp) {
            world.setBlock(j + 2, k - 1, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k - 1, l + 2) == Blocks.redstone_lamp) {
            world.setBlock(j + 1, k - 1, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k - 1, l + 1) == Blocks.redstone_lamp) {
            world.setBlock(j + 2, k - 1, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k - 1, l - 2) == Blocks.redstone_lamp) {
            world.setBlock(j + 1, k - 1, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k - 1, l + 1) == Blocks.redstone_lamp) {
            world.setBlock(j - 2, k - 1, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j, k + 1, l) == Blocks.redstone_lamp) {
            world.setBlock(j, k + 1, l, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k + 1, l) == Blocks.redstone_lamp) {
            world.setBlock(j + 1, k + 1, l, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k + 1, l) == Blocks.redstone_lamp) {
            world.setBlock(j + 2, k + 1, l, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k + 1, l) == Blocks.redstone_lamp) {
            world.setBlock(j - 1, k + 1, l, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k + 1, l) == Blocks.redstone_lamp) {
            world.setBlock(j - 2, k + 1, l, MainClass.LampOff);
        }
        if (world.getBlock(j, k + 1, l - 1) == Blocks.redstone_lamp) {
            world.setBlock(j, k + 1, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j, k + 1, l - 2) == Blocks.redstone_lamp) {
            world.setBlock(j, k + 1, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j, k + 1, l + 1) == Blocks.redstone_lamp) {
            world.setBlock(j, k + 1, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j, k + 1, l + 2) == Blocks.redstone_lamp) {
            world.setBlock(j, k + 1, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k + 1, l - 1) == Blocks.redstone_lamp) {
            world.setBlock(j + 1, k + 1, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k + 1, l - 1) == Blocks.redstone_lamp) {
            world.setBlock(j + 2, k + 1, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k + 1, l - 1) == Blocks.redstone_lamp) {
            world.setBlock(j - 1, k + 1, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k + 1, l - 1) == Blocks.redstone_lamp) {
            world.setBlock(j - 2, k + 1, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k + 1, l + 1) == Blocks.redstone_lamp) {
            world.setBlock(j - 1, k + 1, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k + 1, l - 2) == Blocks.redstone_lamp) {
            world.setBlock(j - 1, k + 1, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k + 1, l + 1) == Blocks.redstone_lamp) {
            world.setBlock(j + 1, k + 1, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k + 1, l + 2) == Blocks.redstone_lamp) {
            world.setBlock(j - 1, k + 1, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k + 1, l - 2) == Blocks.redstone_lamp) {
            world.setBlock(j - 2, k + 1, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k + 1, l - 2) == Blocks.redstone_lamp) {
            world.setBlock(j + 2, k + 1, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k + 1, l + 2) == Blocks.redstone_lamp) {
            world.setBlock(j - 2, k + 1, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k + 1, l + 2) == Blocks.redstone_lamp) {
            world.setBlock(j + 2, k + 1, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k + 1, l + 2) == Blocks.redstone_lamp) {
            world.setBlock(j + 1, k + 1, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k + 1, l + 1) == Blocks.redstone_lamp) {
            world.setBlock(j + 2, k + 1, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k + 1, l - 2) == Blocks.redstone_lamp) {
            world.setBlock(j + 1, k + 1, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k + 1, l + 1) == Blocks.redstone_lamp) {
            world.setBlock(j - 2, k + 1, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j, k - 2, l) == Blocks.redstone_lamp) {
            world.setBlock(j, k - 2, l, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k - 2, l) == Blocks.redstone_lamp) {
            world.setBlock(j + 1, k - 2, l, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k - 2, l) == Blocks.redstone_lamp) {
            world.setBlock(j + 2, k - 2, l, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k - 2, l) == Blocks.redstone_lamp) {
            world.setBlock(j - 1, k - 2, l, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k - 2, l) == Blocks.redstone_lamp) {
            world.setBlock(j - 2, k - 2, l, MainClass.LampOff);
        }
        if (world.getBlock(j, k - 2, l - 1) == Blocks.redstone_lamp) {
            world.setBlock(j, k - 2, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j, k - 2, l - 2) == Blocks.redstone_lamp) {
            world.setBlock(j, k - 2, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j, k - 2, l + 1) == Blocks.redstone_lamp) {
            world.setBlock(j, k - 2, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j, k - 2, l + 2) == Blocks.redstone_lamp) {
            world.setBlock(j, k - 2, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k - 2, l - 1) == Blocks.redstone_lamp) {
            world.setBlock(j + 1, k - 2, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k - 2, l - 1) == Blocks.redstone_lamp) {
            world.setBlock(j + 2, k - 2, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k - 2, l - 1) == Blocks.redstone_lamp) {
            world.setBlock(j - 1, k - 2, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k - 2, l - 1) == Blocks.redstone_lamp) {
            world.setBlock(j - 2, k - 2, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k - 2, l + 1) == Blocks.redstone_lamp) {
            world.setBlock(j - 1, k - 2, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k - 2, l - 2) == Blocks.redstone_lamp) {
            world.setBlock(j - 1, k - 2, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k - 2, l + 1) == Blocks.redstone_lamp) {
            world.setBlock(j + 1, k - 2, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k - 2, l + 2) == Blocks.redstone_lamp) {
            world.setBlock(j - 1, k - 2, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k - 2, l - 2) == Blocks.redstone_lamp) {
            world.setBlock(j - 2, k - 2, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k - 2, l - 2) == Blocks.redstone_lamp) {
            world.setBlock(j + 2, k - 2, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k - 2, l + 2) == Blocks.redstone_lamp) {
            world.setBlock(j - 2, k - 2, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k - 2, l + 2) == Blocks.redstone_lamp) {
            world.setBlock(j + 2, k - 2, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k - 2, l + 2) == Blocks.redstone_lamp) {
            world.setBlock(j + 1, k - 2, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k - 2, l + 1) == Blocks.redstone_lamp) {
            world.setBlock(j + 2, k - 2, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k - 2, l - 2) == Blocks.redstone_lamp) {
            world.setBlock(j + 1, k - 2, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k - 2, l + 1) == Blocks.redstone_lamp) {
            world.setBlock(j - 2, k - 2, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j, k + 2, l) == Blocks.redstone_lamp) {
            world.setBlock(j, k + 2, l, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k + 2, l) == Blocks.redstone_lamp) {
            world.setBlock(j + 1, k + 2, l, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k + 2, l) == Blocks.redstone_lamp) {
            world.setBlock(j + 2, k + 2, l, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k + 2, l) == Blocks.redstone_lamp) {
            world.setBlock(j - 1, k + 2, l, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k + 2, l) == Blocks.redstone_lamp) {
            world.setBlock(j - 2, k + 2, l, MainClass.LampOff);
        }
        if (world.getBlock(j, k + 2, l - 1) == Blocks.redstone_lamp) {
            world.setBlock(j, k + 2, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j, k + 2, l - 2) == Blocks.redstone_lamp) {
            world.setBlock(j, k + 2, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j, k + 2, l + 1) == Blocks.redstone_lamp) {
            world.setBlock(j, k + 2, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j, k + 2, l + 2) == Blocks.redstone_lamp) {
            world.setBlock(j, k + 2, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k + 2, l - 1) == Blocks.redstone_lamp) {
            world.setBlock(j + 1, k + 2, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k + 2, l - 1) == Blocks.redstone_lamp) {
            world.setBlock(j + 2, k + 2, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k + 2, l - 1) == Blocks.redstone_lamp) {
            world.setBlock(j - 1, k + 2, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k + 2, l - 1) == Blocks.redstone_lamp) {
            world.setBlock(j - 2, k + 2, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k + 2, l + 1) == Blocks.redstone_lamp) {
            world.setBlock(j - 1, k + 2, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k + 2, l - 2) == Blocks.redstone_lamp) {
            world.setBlock(j - 1, k + 2, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k + 2, l + 1) == Blocks.redstone_lamp) {
            world.setBlock(j + 1, k + 2, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k + 2, l + 2) == Blocks.redstone_lamp) {
            world.setBlock(j - 1, k + 2, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k + 2, l - 2) == Blocks.redstone_lamp) {
            world.setBlock(j - 2, k + 2, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k + 2, l - 2) == Blocks.redstone_lamp) {
            world.setBlock(j + 2, k + 2, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k + 2, l + 2) == Blocks.redstone_lamp) {
            world.setBlock(j - 2, k + 2, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k + 2, l + 2) == Blocks.redstone_lamp) {
            world.setBlock(j + 2, k + 2, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k + 2, l + 2) == Blocks.redstone_lamp) {
            world.setBlock(j + 1, k + 2, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k + 2, l + 1) == Blocks.redstone_lamp) {
            world.setBlock(j + 2, k + 2, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k + 2, l - 2) == Blocks.redstone_lamp) {
            world.setBlock(j + 1, k + 2, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k + 2, l + 1) == Blocks.redstone_lamp) {
            world.setBlock(j - 2, k + 2, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j, k, l) == Blocks.glowstone) {
            world.setBlock(j, k, l, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 1, k, l) == Blocks.glowstone) {
            world.setBlock(j + 1, k, l, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 2, k, l) == Blocks.glowstone) {
            world.setBlock(j + 2, k, l, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 1, k, l) == Blocks.glowstone) {
            world.setBlock(j - 1, k, l, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 2, k, l) == Blocks.glowstone) {
            world.setBlock(j - 2, k, l, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j, k, l - 1) == Blocks.glowstone) {
            world.setBlock(j, k, l - 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j, k, l - 2) == Blocks.glowstone) {
            world.setBlock(j, k, l - 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j, k, l + 1) == Blocks.glowstone) {
            world.setBlock(j, k, l + 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j, k, l + 2) == Blocks.glowstone) {
            world.setBlock(j, k, l + 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 1, k, l - 1) == Blocks.glowstone) {
            world.setBlock(j + 1, k, l - 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 2, k, l - 1) == Blocks.glowstone) {
            world.setBlock(j + 2, k, l - 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 1, k, l - 1) == Blocks.glowstone) {
            world.setBlock(j - 1, k, l - 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 2, k, l - 1) == Blocks.glowstone) {
            world.setBlock(j - 2, k, l - 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 1, k, l + 1) == Blocks.glowstone) {
            world.setBlock(j - 1, k, l + 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 1, k, l - 2) == Blocks.glowstone) {
            world.setBlock(j - 1, k, l - 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 1, k, l + 1) == Blocks.glowstone) {
            world.setBlock(j + 1, k, l + 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 1, k, l + 2) == Blocks.glowstone) {
            world.setBlock(j - 1, k, l + 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 2, k, l - 2) == Blocks.glowstone) {
            world.setBlock(j - 2, k, l - 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 2, k, l - 2) == Blocks.glowstone) {
            world.setBlock(j + 2, k, l - 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 2, k, l + 2) == Blocks.glowstone) {
            world.setBlock(j - 2, k, l + 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 2, k, l + 2) == Blocks.glowstone) {
            world.setBlock(j + 2, k, l + 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 1, k, l + 2) == Blocks.glowstone) {
            world.setBlock(j + 1, k, l + 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 2, k, l + 1) == Blocks.glowstone) {
            world.setBlock(j + 2, k, l + 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 1, k, l - 2) == Blocks.glowstone) {
            world.setBlock(j + 1, k, l - 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 2, k, l + 1) == Blocks.glowstone) {
            world.setBlock(j - 2, k, l + 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j, k - 1, l) == Blocks.glowstone) {
            world.setBlock(j, k - 1, l, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 1, k - 1, l) == Blocks.glowstone) {
            world.setBlock(j + 1, k - 1, l, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 2, k - 1, l) == Blocks.glowstone) {
            world.setBlock(j + 2, k - 1, l, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 1, k - 1, l) == Blocks.glowstone) {
            world.setBlock(j - 1, k - 1, l, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 2, k - 1, l) == Blocks.glowstone) {
            world.setBlock(j - 2, k - 1, l, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j, k - 1, l - 1) == Blocks.glowstone) {
            world.setBlock(j, k - 1, l - 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j, k - 1, l - 2) == Blocks.glowstone) {
            world.setBlock(j, k - 1, l - 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j, k - 1, l + 1) == Blocks.glowstone) {
            world.setBlock(j, k - 1, l + 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j, k - 1, l + 2) == Blocks.glowstone) {
            world.setBlock(j, k - 1, l + 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 1, k - 1, l - 1) == Blocks.glowstone) {
            world.setBlock(j + 1, k - 1, l - 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 2, k - 1, l - 1) == Blocks.glowstone) {
            world.setBlock(j + 2, k - 1, l - 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 1, k - 1, l - 1) == Blocks.glowstone) {
            world.setBlock(j - 1, k - 1, l - 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 2, k - 1, l - 1) == Blocks.glowstone) {
            world.setBlock(j - 2, k - 1, l - 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 1, k - 1, l + 1) == Blocks.glowstone) {
            world.setBlock(j - 1, k - 1, l + 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 1, k - 1, l - 2) == Blocks.glowstone) {
            world.setBlock(j - 1, k - 1, l - 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 1, k - 1, l + 1) == Blocks.glowstone) {
            world.setBlock(j + 1, k - 1, l + 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 1, k - 1, l + 2) == Blocks.glowstone) {
            world.setBlock(j - 1, k - 1, l + 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 2, k - 1, l - 2) == Blocks.glowstone) {
            world.setBlock(j - 2, k - 1, l - 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 2, k - 1, l - 2) == Blocks.glowstone) {
            world.setBlock(j + 2, k - 1, l - 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 2, k - 1, l + 2) == Blocks.glowstone) {
            world.setBlock(j - 2, k - 1, l + 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 2, k - 1, l + 2) == Blocks.glowstone) {
            world.setBlock(j + 2, k - 1, l + 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 1, k - 1, l + 2) == Blocks.glowstone) {
            world.setBlock(j + 1, k - 1, l + 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 2, k - 1, l + 1) == Blocks.glowstone) {
            world.setBlock(j + 2, k - 1, l + 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 1, k - 1, l - 2) == Blocks.glowstone) {
            world.setBlock(j + 1, k - 1, l - 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 2, k - 1, l + 1) == Blocks.glowstone) {
            world.setBlock(j - 2, k - 1, l + 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j, k + 1, l) == Blocks.glowstone) {
            world.setBlock(j, k + 1, l, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 1, k + 1, l) == Blocks.glowstone) {
            world.setBlock(j + 1, k + 1, l, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 2, k + 1, l) == Blocks.glowstone) {
            world.setBlock(j + 2, k + 1, l, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 1, k + 1, l) == Blocks.glowstone) {
            world.setBlock(j - 1, k + 1, l, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 2, k + 1, l) == Blocks.glowstone) {
            world.setBlock(j - 2, k + 1, l, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j, k + 1, l - 1) == Blocks.glowstone) {
            world.setBlock(j, k + 1, l - 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j, k + 1, l - 2) == Blocks.glowstone) {
            world.setBlock(j, k + 1, l - 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j, k + 1, l + 1) == Blocks.glowstone) {
            world.setBlock(j, k + 1, l + 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j, k + 1, l + 2) == Blocks.glowstone) {
            world.setBlock(j, k + 1, l + 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 1, k + 1, l - 1) == Blocks.glowstone) {
            world.setBlock(j + 1, k + 1, l - 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 2, k + 1, l - 1) == Blocks.glowstone) {
            world.setBlock(j + 2, k + 1, l - 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 1, k + 1, l - 1) == Blocks.glowstone) {
            world.setBlock(j - 1, k + 1, l - 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 2, k + 1, l - 1) == Blocks.glowstone) {
            world.setBlock(j - 2, k + 1, l - 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 1, k + 1, l + 1) == Blocks.glowstone) {
            world.setBlock(j - 1, k + 1, l + 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 1, k + 1, l - 2) == Blocks.glowstone) {
            world.setBlock(j - 1, k + 1, l - 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 1, k + 1, l + 1) == Blocks.glowstone) {
            world.setBlock(j + 1, k + 1, l + 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 1, k + 1, l + 2) == Blocks.glowstone) {
            world.setBlock(j - 1, k + 1, l + 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 2, k + 1, l - 2) == Blocks.glowstone) {
            world.setBlock(j - 2, k + 1, l - 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 2, k + 1, l - 2) == Blocks.glowstone) {
            world.setBlock(j + 2, k + 1, l - 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 2, k + 1, l + 2) == Blocks.glowstone) {
            world.setBlock(j - 2, k + 1, l + 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 2, k + 1, l + 2) == Blocks.glowstone) {
            world.setBlock(j + 2, k + 1, l + 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 1, k + 1, l + 2) == Blocks.glowstone) {
            world.setBlock(j + 1, k + 1, l + 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 2, k + 1, l + 1) == Blocks.glowstone) {
            world.setBlock(j + 2, k + 1, l + 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 1, k + 1, l - 2) == Blocks.glowstone) {
            world.setBlock(j + 1, k + 1, l - 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 2, k + 1, l + 1) == Blocks.glowstone) {
            world.setBlock(j - 2, k + 1, l + 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j, k - 2, l) == Blocks.glowstone) {
            world.setBlock(j, k - 2, l, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 1, k - 2, l) == Blocks.glowstone) {
            world.setBlock(j + 1, k - 2, l, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 2, k - 2, l) == Blocks.glowstone) {
            world.setBlock(j + 2, k - 2, l, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 1, k - 2, l) == Blocks.glowstone) {
            world.setBlock(j - 1, k - 2, l, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 2, k - 2, l) == Blocks.glowstone) {
            world.setBlock(j - 2, k - 2, l, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j, k - 2, l - 1) == Blocks.glowstone) {
            world.setBlock(j, k - 2, l - 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j, k - 2, l - 2) == Blocks.glowstone) {
            world.setBlock(j, k - 2, l - 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j, k - 2, l + 1) == Blocks.glowstone) {
            world.setBlock(j, k - 2, l + 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j, k - 2, l + 2) == Blocks.glowstone) {
            world.setBlock(j, k - 2, l + 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 1, k - 2, l - 1) == Blocks.glowstone) {
            world.setBlock(j + 1, k - 2, l - 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 2, k - 2, l - 1) == Blocks.glowstone) {
            world.setBlock(j + 2, k - 2, l - 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 1, k - 2, l - 1) == Blocks.glowstone) {
            world.setBlock(j - 1, k - 2, l - 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 2, k - 2, l - 1) == Blocks.glowstone) {
            world.setBlock(j - 2, k - 2, l - 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 1, k - 2, l + 1) == Blocks.glowstone) {
            world.setBlock(j - 1, k - 2, l + 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 1, k - 2, l - 2) == Blocks.glowstone) {
            world.setBlock(j - 1, k - 2, l - 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 1, k - 2, l + 1) == Blocks.glowstone) {
            world.setBlock(j + 1, k - 2, l + 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 1, k - 2, l + 2) == Blocks.glowstone) {
            world.setBlock(j - 1, k - 2, l + 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 2, k - 2, l - 2) == Blocks.glowstone) {
            world.setBlock(j - 2, k - 2, l - 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 2, k - 2, l - 2) == Blocks.glowstone) {
            world.setBlock(j + 2, k - 2, l - 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 2, k - 2, l + 2) == Blocks.glowstone) {
            world.setBlock(j - 2, k - 2, l + 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 2, k - 2, l + 2) == Blocks.glowstone) {
            world.setBlock(j + 2, k - 2, l + 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 1, k - 2, l + 2) == Blocks.glowstone) {
            world.setBlock(j + 1, k - 2, l + 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 2, k - 2, l + 1) == Blocks.glowstone) {
            world.setBlock(j + 2, k - 2, l + 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 1, k - 2, l - 2) == Blocks.glowstone) {
            world.setBlock(j + 1, k - 2, l - 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 2, k - 2, l + 1) == Blocks.glowstone) {
            world.setBlock(j - 2, k - 2, l + 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j, k + 2, l) == Blocks.glowstone) {
            world.setBlock(j, k + 2, l, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 1, k + 2, l) == Blocks.glowstone) {
            world.setBlock(j + 1, k + 2, l, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 2, k + 2, l) == Blocks.glowstone) {
            world.setBlock(j + 2, k + 2, l, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 1, k + 2, l) == Blocks.glowstone) {
            world.setBlock(j - 1, k + 2, l, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 2, k + 2, l) == Blocks.glowstone) {
            world.setBlock(j - 2, k + 2, l, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j, k + 2, l - 1) == Blocks.glowstone) {
            world.setBlock(j, k + 2, l - 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j, k + 2, l - 2) == Blocks.glowstone) {
            world.setBlock(j, k + 2, l - 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j, k + 2, l + 1) == Blocks.glowstone) {
            world.setBlock(j, k + 2, l + 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j, k + 2, l + 2) == Blocks.glowstone) {
            world.setBlock(j, k + 2, l + 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 1, k + 2, l - 1) == Blocks.glowstone) {
            world.setBlock(j + 1, k + 2, l - 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 2, k + 2, l - 1) == Blocks.glowstone) {
            world.setBlock(j + 2, k + 2, l - 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 1, k + 2, l - 1) == Blocks.glowstone) {
            world.setBlock(j - 1, k + 2, l - 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 2, k + 2, l - 1) == Blocks.glowstone) {
            world.setBlock(j - 2, k + 2, l - 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 1, k + 2, l + 1) == Blocks.glowstone) {
            world.setBlock(j - 1, k + 2, l + 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 1, k + 2, l - 2) == Blocks.glowstone) {
            world.setBlock(j - 1, k + 2, l - 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 1, k + 2, l + 1) == Blocks.glowstone) {
            world.setBlock(j + 1, k + 2, l + 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 1, k + 2, l + 2) == Blocks.glowstone) {
            world.setBlock(j - 1, k + 2, l + 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 2, k + 2, l - 2) == Blocks.glowstone) {
            world.setBlock(j - 2, k + 2, l - 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 2, k + 2, l - 2) == Blocks.glowstone) {
            world.setBlock(j + 2, k + 2, l - 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 2, k + 2, l + 2) == Blocks.glowstone) {
            world.setBlock(j - 2, k + 2, l + 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 2, k + 2, l + 2) == Blocks.glowstone) {
            world.setBlock(j + 2, k + 2, l + 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 1, k + 2, l + 2) == Blocks.glowstone) {
            world.setBlock(j + 1, k + 2, l + 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 2, k + 2, l + 1) == Blocks.glowstone) {
            world.setBlock(j + 2, k + 2, l + 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j + 1, k + 2, l - 2) == Blocks.glowstone) {
            world.setBlock(j + 1, k + 2, l - 2, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j - 2, k + 2, l + 1) == Blocks.glowstone) {
            world.setBlock(j - 2, k + 2, l + 1, MainClass.GlowstoneOff);
        }
        if (world.getBlock(j, k, l) == Blocks.lit_redstone_lamp) {
            world.setBlock(j, k, l, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k, l) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 1, k, l, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k, l) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 2, k, l, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k, l) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 1, k, l, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k, l) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 2, k, l, MainClass.LampOff);
        }
        if (world.getBlock(j, k, l - 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j, k, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j, k, l - 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j, k, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j, k, l + 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j, k, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j, k, l + 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j, k, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k, l - 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 1, k, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k, l - 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 2, k, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k, l - 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 1, k, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k, l - 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 2, k, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k, l + 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 1, k, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k, l - 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 1, k, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k, l + 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 1, k, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k, l + 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 1, k, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k, l - 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 2, k, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k, l - 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 2, k, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k, l + 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 2, k, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k, l + 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 2, k, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k, l + 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 1, k, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k, l + 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 2, k, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k, l - 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 1, k, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k, l + 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 2, k, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j, k - 1, l) == Blocks.lit_redstone_lamp) {
            world.setBlock(j, k - 1, l, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k - 1, l) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 1, k - 1, l, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k - 1, l) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 2, k - 1, l, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k - 1, l) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 1, k - 1, l, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k - 1, l) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 2, k - 1, l, MainClass.LampOff);
        }
        if (world.getBlock(j, k - 1, l - 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j, k - 1, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j, k - 1, l - 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j, k - 1, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j, k - 1, l + 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j, k - 1, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j, k - 1, l + 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j, k - 1, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k - 1, l - 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 1, k - 1, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k - 1, l - 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 2, k - 1, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k - 1, l - 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 1, k - 1, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k - 1, l - 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 2, k - 1, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k - 1, l + 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 1, k - 1, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k - 1, l - 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 1, k - 1, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k - 1, l + 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 1, k - 1, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k - 1, l + 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 1, k - 1, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k - 1, l - 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 2, k - 1, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k - 1, l - 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 2, k - 1, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k - 1, l + 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 2, k - 1, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k - 1, l + 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 2, k - 1, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k - 1, l + 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 1, k - 1, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k - 1, l + 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 2, k - 1, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k - 1, l - 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 1, k - 1, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k - 1, l + 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 2, k - 1, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j, k + 1, l) == Blocks.lit_redstone_lamp) {
            world.setBlock(j, k + 1, l, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k + 1, l) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 1, k + 1, l, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k + 1, l) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 2, k + 1, l, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k + 1, l) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 1, k + 1, l, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k + 1, l) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 2, k + 1, l, MainClass.LampOff);
        }
        if (world.getBlock(j, k + 1, l - 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j, k + 1, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j, k + 1, l - 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j, k + 1, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j, k + 1, l + 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j, k + 1, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j, k + 1, l + 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j, k + 1, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k + 1, l - 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 1, k + 1, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k + 1, l - 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 2, k + 1, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k + 1, l - 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 1, k + 1, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k + 1, l - 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 2, k + 1, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k + 1, l + 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 1, k + 1, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k + 1, l - 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 1, k + 1, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k + 1, l + 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 1, k + 1, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k + 1, l + 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 1, k + 1, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k + 1, l - 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 2, k + 1, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k + 1, l - 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 2, k + 1, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k + 1, l + 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 2, k + 1, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k + 1, l + 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 2, k + 1, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k + 1, l + 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 1, k + 1, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k + 1, l + 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 2, k + 1, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k + 1, l - 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 1, k + 1, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k + 1, l + 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 2, k + 1, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j, k - 2, l) == Blocks.lit_redstone_lamp) {
            world.setBlock(j, k - 2, l, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k - 2, l) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 1, k - 2, l, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k - 2, l) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 2, k - 2, l, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k - 2, l) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 1, k - 2, l, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k - 2, l) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 2, k - 2, l, MainClass.LampOff);
        }
        if (world.getBlock(j, k - 2, l - 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j, k - 2, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j, k - 2, l - 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j, k - 2, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j, k - 2, l + 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j, k - 2, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j, k - 2, l + 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j, k - 2, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k - 2, l - 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 1, k - 2, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k - 2, l - 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 2, k - 2, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k - 2, l - 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 1, k - 2, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k - 2, l - 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 2, k - 2, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k - 2, l + 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 1, k - 2, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k - 2, l - 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 1, k - 2, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k - 2, l + 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 1, k - 2, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k - 2, l + 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 1, k - 2, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k - 2, l - 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 2, k - 2, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k - 2, l - 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 2, k - 2, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k - 2, l + 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 2, k - 2, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k - 2, l + 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 2, k - 2, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k - 2, l + 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 1, k - 2, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k - 2, l + 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 2, k - 2, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k - 2, l - 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 1, k - 2, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k - 2, l + 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 2, k - 2, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j, k + 2, l) == Blocks.lit_redstone_lamp) {
            world.setBlock(j, k + 2, l, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k + 2, l) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 1, k + 2, l, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k + 2, l) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 2, k + 2, l, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k + 2, l) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 1, k + 2, l, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k + 2, l) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 2, k + 2, l, MainClass.LampOff);
        }
        if (world.getBlock(j, k + 2, l - 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j, k + 2, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j, k + 2, l - 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j, k + 2, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j, k + 2, l + 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j, k + 2, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j, k + 2, l + 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j, k + 2, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k + 2, l - 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 1, k + 2, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k + 2, l - 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 2, k + 2, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k + 2, l - 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 1, k + 2, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k + 2, l - 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 2, k + 2, l - 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k + 2, l + 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 1, k + 2, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k + 2, l - 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 1, k + 2, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k + 2, l + 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 1, k + 2, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j - 1, k + 2, l + 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 1, k + 2, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k + 2, l - 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 2, k + 2, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k + 2, l - 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 2, k + 2, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k + 2, l + 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 2, k + 2, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k + 2, l + 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 2, k + 2, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k + 2, l + 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 1, k + 2, l + 2, MainClass.LampOff);
        }
        if (world.getBlock(j + 2, k + 2, l + 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 2, k + 2, l + 1, MainClass.LampOff);
        }
        if (world.getBlock(j + 1, k + 2, l - 2) == Blocks.lit_redstone_lamp) {
            world.setBlock(j + 1, k + 2, l - 2, MainClass.LampOff);
        }
        if (world.getBlock(j - 2, k + 2, l + 1) == Blocks.lit_redstone_lamp) {
            world.setBlock(j - 2, k + 2, l + 1, MainClass.LampOff);
        }
        return new ItemStack(MainClass.Deluminator);
    }
}
