package snidgert.harrypottermod.armor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import snidgert.harrypottermod.MainClass;

public class InvisibilityCloakArmorClass extends ItemArmor
{
    public InvisibilityCloakArmorClass(final ItemArmor.ArmorMaterial material, final int id, final int placement) {
        super(material, id, placement);
        this.setCreativeTab(CreativeTabs.tabCombat);
        if (placement == 1) {
            this.setTextureName("harrypottermod:InvisibilityCloak");
        }
    }
    
    @Override
	public String getArmorTexture(final ItemStack itemstack, final Entity entity, final int slot, final String type) {
        if (itemstack.getItem() == MainClass.InvisibilityCloak) {
            return "harrypottermod:textures/models/armor/clean_layer_1.png";
        }
        return null;
    }
    
    @Override
	public void onArmorTick(final World world, final EntityPlayer player, final ItemStack itemStack) {
        player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 5, 1, false));
    }
}
