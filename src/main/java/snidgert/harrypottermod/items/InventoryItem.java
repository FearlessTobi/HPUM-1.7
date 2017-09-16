package snidgert.harrypottermod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class InventoryItem implements IInventory
{
    private String name;
    public static final int INV_SIZE = 8;
    private ItemStack[] inventory;
    private final ItemStack invItem;
    
    public InventoryItem(final ItemStack stack) {
        this.name = "Inventory Item";
        this.inventory = new ItemStack[8];
        this.invItem = stack;
        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        }
        this.readFromNBT(stack.getTagCompound());
    }
    
    @Override
	public int getSizeInventory() {
        return this.inventory.length;
    }
    
    @Override
	public ItemStack getStackInSlot(final int slot) {
        return this.inventory[slot];
    }
    
    @Override
	public ItemStack decrStackSize(final int slot, final int amount) {
        ItemStack stack = this.getStackInSlot(slot);
        if (stack != null) {
            if (stack.stackSize > amount) {
                stack = stack.splitStack(amount);
                this.markDirty();
            }
            else {
                this.setInventorySlotContents(slot, null);
            }
        }
        return stack;
    }
    
    @Override
	public ItemStack getStackInSlotOnClosing(final int slot) {
        final ItemStack stack = this.getStackInSlot(slot);
        if (stack != null) {
            this.setInventorySlotContents(slot, null);
        }
        return stack;
    }
    
    @Override
	public void setInventorySlotContents(final int slot, final ItemStack itemstack) {
        this.inventory[slot] = itemstack;
        if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()) {
            itemstack.stackSize = this.getInventoryStackLimit();
        }
        this.markDirty();
    }
    
    @Override
	public String getInventoryName() {
        return this.name;
    }
    
    @Override
	public int getInventoryStackLimit() {
        return 64;
    }
    
    @Override
	public void markDirty() {
        for (int i = 0; i < this.getSizeInventory(); ++i) {
            if (this.getStackInSlot(i) != null && this.getStackInSlot(i).stackSize == 0) {
                this.inventory[i] = null;
            }
        }
        this.writeToNBT(this.invItem.getTagCompound());
    }
    
    @Override
	public boolean isUseableByPlayer(final EntityPlayer player) {
        return player.getHeldItem() == this.invItem;
    }
    
    @Override
	public boolean isItemValidForSlot(final int slot, final ItemStack itemstack) {
        return !(itemstack.getItem() instanceof ItemStoreClass);
    }
    
    public void readFromNBT(final NBTTagCompound tagcompound) {
        final NBTTagList items = tagcompound.getTagList("ItemInventory", 10);
        for (int i = 0; i < items.tagCount(); ++i) {
            final NBTTagCompound item = items.getCompoundTagAt(i);
            final byte slot = item.getByte("Slot");
            if (slot >= 0 && slot < this.getSizeInventory()) {
                this.inventory[slot] = ItemStack.loadItemStackFromNBT(item);
            }
        }
    }
    
    public void writeToNBT(final NBTTagCompound tagcompound) {
        final NBTTagList items = new NBTTagList();
        for (int i = 0; i < this.getSizeInventory(); ++i) {
            if (this.getStackInSlot(i) != null) {
                final NBTTagCompound item = new NBTTagCompound();
                item.setInteger("Slot", i);
                this.getStackInSlot(i).writeToNBT(item);
                items.appendTag(item);
            }
        }
        tagcompound.setTag("ItemInventory", items);
    }

	@Override
	public boolean hasCustomInventoryName() {
		return this.name.length() > 0;
	}

	@Override
	public void openInventory() {
	}

	@Override
	public void closeInventory() {
	}
}
