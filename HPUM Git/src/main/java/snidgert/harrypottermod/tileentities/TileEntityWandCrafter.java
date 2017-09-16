package snidgert.harrypottermod.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import snidgert.harrypottermod.MainClass;
import snidgert.harrypottermod.blocks.WandCrafterClass;
import snidgert.harrypottermod.blocks.WandCraftingRecipes;

public class TileEntityWandCrafter extends TileEntity implements ISidedInventory
{
	private ItemStack[] slots;
	private String customName;
	public int dualCookTime;
	public int dualPower;
	public static final int maxPower = 1000;
	public static final int craftingSpeed = 100;
	private static final int[] slots_top;
	private static final int[] slots_bottom;
	private static final int[] slots_side;

	public TileEntityWandCrafter() {
		this.slots = new ItemStack[4];
	}

	@Override
	public int getSizeInventory() {
		return this.slots.length;
	}

	@Override
	public ItemStack getStackInSlot(final int i) {
		return this.slots[i];
	}

	@Override
	public ItemStack decrStackSize(final int i, final int j) {
		if (this.slots[i] == null) {
			return null;
		}
		if (this.slots[i].stackSize <= j) {
			final ItemStack itemstack = this.slots[i];
			this.slots[i] = null;
			return itemstack;
		}
		final ItemStack itemstack2 = this.slots[i].splitStack(j);
		if (this.slots[i].stackSize == 0) {
			this.slots[i] = null;
		}
		return itemstack2;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(final int i) {
		if (this.slots[i] != null) {
			final ItemStack itemstack = this.slots[i];
			this.slots[i] = null;
			return itemstack;
		}
		return null;
	}

	@Override
	public void setInventorySlotContents(final int i, final ItemStack itemstack) {
		this.slots[i] = itemstack;
		if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()) {
			itemstack.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public String getInventoryName() {
		return "Wand Crafting Table";
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(final EntityPlayer player) {
		return super.worldObj.getTileEntity(super.xCoord, super.yCoord, super.zCoord) == this && player.getDistanceSq(super.xCoord + 0.5, super.yCoord + 0.5, super.zCoord + 0.5) <= 64.0;
	}

	@Override
	public boolean isItemValidForSlot(final int i, final ItemStack itemstack) {
		return i != 2 && (i != 1 || this.hasItemPower(itemstack));
	}

	public boolean hasItemPower(final ItemStack itemstack) {
		return getItemPower(itemstack) > 0;
	}

	private static int getItemPower(final ItemStack itemstack) {
		if (itemstack == null) {
			return 0;
		}
		final Item item = itemstack.getItem();
		if (item == MainClass.MagicPower) {
			return 10;
		}
		return 0;
	}

	@Override
	public void readFromNBT(final NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		final NBTTagList list = nbt.getTagList("Items", 10);
		this.slots = new ItemStack[this.getSizeInventory()];
		for (int i = 0; i < list.tagCount(); ++i) {
			final NBTTagCompound nbt2 = list.getCompoundTagAt(i);
			final byte b0 = nbt2.getByte("Slot");
			if (b0 >= 0 && b0 < this.slots.length) {
				this.slots[b0] = ItemStack.loadItemStackFromNBT(nbt2);
			}
		}
		this.dualPower = nbt.getShort("PowerTime");
		this.dualCookTime = nbt.getShort("CookTime");
	}

	@Override
	public void writeToNBT(final NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setShort("PowerTime", (short)this.dualPower);
		nbt.setShort("CookTime", (short)this.dualCookTime);
		final NBTTagList list = new NBTTagList();
		for (int i = 0; i < this.slots.length; ++i) {
			if (this.slots[i] != null) {
				final NBTTagCompound nbt2 = new NBTTagCompound();
				nbt2.setByte("Slot", (byte)i);
				this.slots[i].writeToNBT(nbt2);
				list.appendTag(nbt2);
			}
		}
		nbt.setTag("Items", list);
	}

	@Override
	public boolean canInsertItem(final int i, final ItemStack itemstack, final int j) {
		return this.isItemValidForSlot(i, itemstack);
	}

	@Override
	public boolean canExtractItem(final int i, final ItemStack itemstack, final int j) {
		return j != 0 || i != 1 || itemstack.getItem() == Items.bucket;
	}

	public int getCrafterProgressScaled(final int i) {
		return this.dualCookTime * i / 100;
	}

	public int getPowerRemainingScaled(final int i) {
		return this.dualPower * i / 1000;
	}

	private boolean canCraft() {
		if (this.slots[0] == null || this.slots[1] == null) {
			return false;
		}
		final ItemStack itemstack = WandCraftingRecipes.getWand(this.slots[0].getItem(), this.slots[1].getItem());
		return itemstack != null && (this.slots[3] == null || (this.slots[3].isItemEqual(itemstack) && ((this.slots[3].stackSize < this.getInventoryStackLimit() && this.slots[3].stackSize < this.slots[3].getMaxStackSize()) || this.slots[3].stackSize < itemstack.getMaxStackSize())));
	}

	public void craftWand() {
		if (this.canCraft()) {
			final ItemStack itemstack = WandCraftingRecipes.getWand(this.slots[0].getItem(), this.slots[1].getItem());
			if (this.slots[3] == null) {
				this.slots[3] = itemstack.copy();
			}
			else if (this.slots[3].isItemEqual(itemstack)) {
				final ItemStack itemStack = this.slots[3];
				itemStack.stackSize += itemstack.stackSize;
			}
			for (int i = 0; i < 2; ++i) {
				if (this.slots[i].stackSize <= 0) {
					this.slots[i] = new ItemStack(this.slots[i].getItem().setFull3D());
				}
				else {
					final ItemStack itemStack2 = this.slots[i];
					--itemStack2.stackSize;
				}
				if (this.slots[i].stackSize <= 0) {
					this.slots[i] = null;
				}
			}
		}
	}

	public boolean hasPower() {
		return this.dualPower > 0;
	}

	public boolean craftingWand() {
		return this.dualCookTime > 0;
	}

	@Override
	public void updateEntity() {
		final boolean flag = this.hasPower();
		boolean flag2 = false;
		if (this.hasPower() && this.craftingWand()) {
			--this.dualPower;
		}
		if (!super.worldObj.isRemote) {
			if (this.hasItemPower(this.slots[2]) && this.dualPower < 1000 - getItemPower(this.slots[2])) {
				this.dualPower += getItemPower(this.slots[2]);
				if (this.slots[2] != null) {
					flag2 = true;
					final ItemStack itemStack = this.slots[2];
					--itemStack.stackSize;
					if (this.slots[2].stackSize == 0) {
						this.slots[2] = this.slots[2].getItem().getContainerItem(this.slots[2]);
					}
				}
			}
			if (this.hasPower() && this.canCraft()) {
				++this.dualCookTime;
				if (this.dualCookTime == 100) {
					this.dualCookTime = 0;
					this.craftWand();
					flag2 = true;
				}
			}
			else {
				this.dualCookTime = 0;
			}
			if (flag != this.hasPower()) {
				flag2 = true;
				WandCrafterClass.updateBlockState(this.craftingWand(), super.worldObj, super.xCoord, super.yCoord, super.zCoord);
			}
		}
		if (flag2) {
			this.markDirty();
		}
	}

	static {
		slots_top = new int[] { 0, 1 };
		slots_bottom = new int[] { 3 };
		slots_side = new int[] { 2 };
	}

	@Override
	public boolean hasCustomInventoryName() {
		return this.customName != null && this.customName.length() > 0;
	}

	@Override
	public void openInventory() {
	}

	@Override
	public void closeInventory() {
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
		return null;
	}
}
