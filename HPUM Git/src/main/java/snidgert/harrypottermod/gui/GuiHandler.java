package snidgert.harrypottermod.gui;

import cpw.mods.fml.common.network.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import snidgert.harrypottermod.*;
import snidgert.harrypottermod.blocks.*;
import snidgert.harrypottermod.items.*;
import snidgert.harrypottermod.tileentities.TileEntityWandCrafter;
import net.minecraft.tileentity.*;

public class GuiHandler implements IGuiHandler
{
    @Override
	public Object getServerGuiElement(final int ID, final EntityPlayer player, final World world, final int x, final int y, final int z) {
        final TileEntity entity = world.getTileEntity(x, y, z);
        if (ID == MainClass.GUI_ITEM_INV) {
            return new ContainerItem(player, player.inventory, new InventoryItem(player.getHeldItem()));
        }
        if (entity != null) {
            switch (ID) {
                case 4: {
                    if (entity instanceof TileEntityWandCrafter) {
                        return new ContainerWandCrafter(player.inventory, (TileEntityWandCrafter)entity);
                    }
                    return null;
                }
            }
        }
        return null;
    }
    
    @Override
	public Object getClientGuiElement(final int ID, final EntityPlayer player, final World world, final int x, final int y, final int z) {
        final TileEntity entity = world.getTileEntity(x, y, z);
        if (ID == MainClass.GUI_ITEM_INV) {
            return new GuiItemInventory(new ContainerItem(player, player.inventory, new InventoryItem(player.getHeldItem())));
        }
        if (entity != null) {
            switch (ID) {
                case 4: {
                    if (entity instanceof TileEntityWandCrafter) {
                        return new GUIWandCrafter(player.inventory, (TileEntityWandCrafter)entity);
                    }
                    return null;
                }
            }
        }
        return null;
    }
}
