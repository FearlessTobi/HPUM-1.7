package snidgert.harrypottermod.armor;

import net.minecraft.world.*;
import snidgert.harrypottermod.*;
import net.minecraft.entity.player.*;
import net.minecraft.potion.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.client.model.*;

public class WerewolfArmorClass extends ItemArmor
{
    public WerewolfArmorClass(final ItemArmor.ArmorMaterial material, final int renderIndex, final int type) {
        super(material, renderIndex, type);
    }
    
    @Override
	public String getUnlocalizedName() {
        return String.format("item.%s%s", "harrypottermod", this.getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
    
    @Override
	public void onArmorTick(final World world, final EntityPlayer player, final ItemStack itemStack) {
        player.setInvisible(true);
        player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 5, 10));
        player.addPotionEffect(new PotionEffect(Potion.resistance.id, 5, 10));
    }
    
    @Override
	public String getUnlocalizedName(final ItemStack itemstack) {
        return String.format("item.%s%s", "harrypottermod", this.getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
    
    protected String getUnwrappedUnlocalizedName(final String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(46) + 1);
    }
    
    @Override
	@SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(46) + 1));
    }
    
    @Override
	@SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(final EntityLivingBase entityLiving, final ItemStack itemstack, final int armorSlot) {
        final ModelBiped armorModel = ClientProxy.armorModel.get(this);
        if (armorModel != null) {
            armorModel.isSneak = entityLiving.isSneaking();
            ((ModelBase)armorModel).isRiding = entityLiving.isRiding();
            ((ModelBase)armorModel).isChild = entityLiving.isChild();
            armorModel.heldItemRight = 0;
            armorModel.aimedBow = false;
            final EntityPlayer player = (EntityPlayer)entityLiving;
            final ItemStack held_item = player.getEquipmentInSlot(0);
            if (held_item != null) {
                armorModel.heldItemRight = 1;
                if (player.getItemInUseCount() > 0) {
                    final EnumAction enumaction = held_item.getItemUseAction();
                    if (enumaction == EnumAction.bow) {
                        armorModel.aimedBow = true;
                    }
                    else if (enumaction == EnumAction.block) {
                        armorModel.heldItemRight = 3;
                    }
                }
            }
        }
        return armorModel;
    }
    
    @Override
	public String getArmorTexture(final ItemStack stack, final Entity entity, final int slot, final String layer) {
        return "harrypottermod:textures/models/armor/WerewolfArmor.png";
    }
}
