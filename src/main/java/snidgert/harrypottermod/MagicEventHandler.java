package snidgert.harrypottermod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import snidgert.harrypottermod.mobs.entity.EntityNagini;
import snidgert.harrypottermod.mobs.entity.EntityWerewolf;
import snidgert.harrypottermod.wands.DPSWandClass;
import snidgert.harrypottermod.wands.SupportWandClass;
import snidgert.harrypottermod.wands.TankWandClass;

public class MagicEventHandler {
	public static boolean DPS;
	public static boolean Tank;
	public static boolean Support;

	@SubscribeEvent
	public void onLivingUpdateEvent(final LivingEvent.LivingUpdateEvent event) {
		if (event.entity instanceof EntityPlayer) {
			final EntityPlayer player = (EntityPlayer) event.entity;
			final ItemStack heldItem = player.getHeldItem();
			if (heldItem != null && heldItem.getItem() instanceof DPSWandClass) {
				player.capabilities.allowFlying = true;
			}
			if (heldItem != null && heldItem.getItem() instanceof TankWandClass) {
				player.capabilities.allowFlying = true;
			}
			if (heldItem != null && heldItem.getItem() instanceof SupportWandClass) {
				player.capabilities.allowFlying = true;
			}
			if (player.getCurrentArmor(1) != null && player.getCurrentArmor(1).getItem() == MainClass.DeathEaterLegs
					&& player.getCurrentArmor(0) != null
					&& player.getCurrentArmor(0).getItem() == MainClass.DeathEaterShoes
					&& player.getCurrentArmor(2) != null
					&& player.getCurrentArmor(2).getItem() == MainClass.DeathEaterChest
					&& player.getCurrentArmor(3) != null
					&& player.getCurrentArmor(3).getItem() == MainClass.DeathEaterHat) {
				if (heldItem != null && player.getHeldItem().getItem() == MainClass.DPSWandClass) {
					DPSWandClass.Evil = true;
				} else if (heldItem != null && player.getHeldItem().getItem() == MainClass.TankWandClass) {
					TankWandClass.Evil = true;
				} else if (heldItem != null && player.getHeldItem().getItem() == MainClass.SupportWandClass) {
					SupportWandClass.Evil = true;
				} else {
					SupportWandClass.Evil = false;
					TankWandClass.Evil = false;
					DPSWandClass.Evil = false;
				}
			}
			if (player.isRiding() && ((Entity) player).ridingEntity instanceof EntityWerewolf) {
				player.setInvisible(true);
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 5, 10));
				player.addPotionEffect(new PotionEffect(Potion.resistance.id, 5, 10));
			}
		}
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void preRender(RenderPlayerEvent.Pre event) {
		if (event.entity.isInvisible() && event.entity.ridingEntity instanceof EntityHorse
				&& event.entity.ridingEntity.getClass() != EntityHorse.class)
			event.setCanceled(true);

		if (event.entity.isInvisible() && ((EntityPlayer) event.entity).inventory.armorItemInSlot(2) != null) {
			ItemStack armorItem = (((EntityPlayer) event.entity).inventory.armorItemInSlot(2));
			ItemStack invisibilityCloak = new ItemStack(MainClass.InvisibilityCloak);

			if (armorItem.isItemEqual(invisibilityCloak))
				event.setCanceled(true);
		}

	}

	@SubscribeEvent
	public void onEntityHurt(final LivingHurtEvent event) {
		if (event.entityLiving instanceof EntityNagini && event.isCancelable()) {
			event.setCanceled(true);
		}
		if (event.entityLiving.isPotionActive(MainClass.ShieldEffect)) {
			event.setCanceled(true);
		}
	}

	@SubscribeEvent
	public void onEntityConstructing(final EntityEvent.EntityConstructing event) {
		if (event.entity instanceof EntityPlayer && ExtendedPlayer.get((EntityPlayer) event.entity) == null) {
			ExtendedPlayer.register((EntityPlayer) event.entity);
		}
		if (event.entity instanceof EntityPlayer && event.entity.getExtendedProperties("ExtendedPlayer") == null) {
			event.entity.registerExtendedProperties("ExtendedPlayer", new ExtendedPlayer((EntityPlayer) event.entity));
		}
	}

	@SubscribeEvent
	public void onLivingFallEvent(final LivingFallEvent event) {
		if (event.entity instanceof EntityPlayer) {
			final ExtendedPlayer props = ExtendedPlayer.get((EntityPlayer) event.entity);
			if (event.distance > 3.0f && props.getCurrentMana() > 0.0f) {
				System.out.println("[EVENT] Fall distance: " + event.distance);
				System.out.println("[EVENT] Current mana: " + props.getCurrentMana());
				final float reduceby = (props.getCurrentMana() < event.distance - 3.0f) ? props.getCurrentMana()
						: (event.distance - 3.0f);
				event.distance -= reduceby;
				props.consumeMana((int) reduceby);
				System.out.println("[EVENT] Adjusted fall distance: " + event.distance);
			}
		}
	}

	static {
		MagicEventHandler.DPS = false;
		MagicEventHandler.Tank = false;
		MagicEventHandler.Support = false;
	}
}
