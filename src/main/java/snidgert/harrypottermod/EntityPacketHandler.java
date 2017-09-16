package snidgert.harrypottermod;

import cpw.mods.fml.common.network.*;
import net.minecraft.network.*;
import snidgert.harrypottermod.mobs.entity.*;
import snidgert.harrypottermod.wands.*;
import snidgert.harrypottermod.items.*;
import snidgert.harrypottermod.woodwands.BirchAcromantulaClass;
import snidgert.harrypottermod.woodwands.BirchAugureylass;
import snidgert.harrypottermod.woodwands.BirchBasiliskClass;
import snidgert.harrypottermod.woodwands.BirchBillywigClass;
import snidgert.harrypottermod.woodwands.BirchBoomslangClass;
import snidgert.harrypottermod.woodwands.BirchChimaeraClass;
import snidgert.harrypottermod.woodwands.BirchDemiguiseClass;
import snidgert.harrypottermod.woodwands.BirchDoxyClass;
import snidgert.harrypottermod.woodwands.BirchDragonClass;
import snidgert.harrypottermod.woodwands.BirchErumpentClass;
import snidgert.harrypottermod.woodwands.BirchFairyClass;
import snidgert.harrypottermod.woodwands.BirchFwooperClass;
import snidgert.harrypottermod.woodwands.BirchHippogriffClass;
import snidgert.harrypottermod.woodwands.BirchKelpieClass;
import snidgert.harrypottermod.woodwands.BirchPhoenixClass;
import snidgert.harrypottermod.woodwands.BirchUnicornClass;
import snidgert.harrypottermod.woodwands.BirchVeelaClass;
import snidgert.harrypottermod.woodwands.OakAcromantulaClass;
import snidgert.harrypottermod.woodwands.OakAugureyClass;
import snidgert.harrypottermod.woodwands.OakBasiliskClass;
import snidgert.harrypottermod.woodwands.OakBillywigClass;
import snidgert.harrypottermod.woodwands.OakBoomslangClass;
import snidgert.harrypottermod.woodwands.OakChimaeraClass;
import snidgert.harrypottermod.woodwands.OakDemiguiseClass;
import snidgert.harrypottermod.woodwands.OakDoxyClass;
import snidgert.harrypottermod.woodwands.OakDragonClass;
import snidgert.harrypottermod.woodwands.OakErumpentClass;
import snidgert.harrypottermod.woodwands.OakFairyClass;
import snidgert.harrypottermod.woodwands.OakFwooperClass;
import snidgert.harrypottermod.woodwands.OakHippogriffClass;
import snidgert.harrypottermod.woodwands.OakKelpieClass;
import snidgert.harrypottermod.woodwands.OakPhoenixClass;
import snidgert.harrypottermod.woodwands.OakUnicornClass;
import snidgert.harrypottermod.woodwands.OakVeelaClass;
import snidgert.harrypottermod.woodwands.RowanPhoenixClass;
import net.minecraft.entity.player.*;
import cpw.mods.fml.common.eventhandler.*;
import cpw.mods.fml.common.network.internal.*;
import net.minecraft.entity.*;
import cpw.mods.fml.relauncher.*;
import io.netty.buffer.*;

public class EntityPacketHandler
{
    public static final String CHANNEL = "Flying";
    
    @SubscribeEvent
    public void onServerPacket(final FMLNetworkEvent.ServerCustomPacketEvent event) {
        if (event.packet.channel().equals("Flying")) {
            this.handle(event.packet, ((NetHandlerPlayServer)event.handler).playerEntity);
        }
    }
    
    private void handle(final FMLProxyPacket packet, final EntityPlayer player) {
        final ByteBuf payload = packet.payload();
        final long data = payload.readLong();
        final Entity Mount = ((Entity)player).ridingEntity;
        if (Mount != null && Mount instanceof EntityDragonRideable) {
            ((EntityDragonRideable)Mount).FlyUp = false;
            ((EntityDragonRideable)Mount).FlyDown = false;
            ((EntityDragonRideable)Mount).FireBreath = false;
            if (data == 2L) {
                ((EntityDragonRideable)Mount).FlyUp = true;
            }
            else if (data == 3L) {
                ((EntityDragonRideable)Mount).FireBreath = true;
            }
            else if (data == 1L) {
                ((EntityDragonRideable)Mount).FlyDown = true;
            }
        }
        if (Mount != null && Mount instanceof EntityHippogriff) {
            ((EntityHippogriff)Mount).FlyUp = false;
            ((EntityHippogriff)Mount).FlyDown = false;
            if (data == 2L) {
                ((EntityHippogriff)Mount).FlyUp = true;
            }
            else if (data == 1L) {
                ((EntityHippogriff)Mount).FlyDown = true;
            }
        }
        if (Mount != null && Mount instanceof EntityGriffin) {
            ((EntityGriffin)Mount).FlyUp = false;
            ((EntityGriffin)Mount).FlyDown = false;
            if (data == 2L) {
                ((EntityGriffin)Mount).FlyUp = true;
            }
            else if (data == 1L) {
                ((EntityGriffin)Mount).FlyDown = true;
            }
        }
        if (Mount != null && Mount instanceof EntityFordAnglia) {
            ((EntityFordAnglia)Mount).FlyUp = false;
            ((EntityFordAnglia)Mount).FlyDown = false;
            ((EntityFordAnglia)Mount).FireBreath = false;
            if (data == 2L) {
                ((EntityFordAnglia)Mount).FlyUp = true;
            }
            else if (data == 3L) {
                ((EntityFordAnglia)Mount).FireBreath = true;
            }
            else if (data == 1L) {
                ((EntityFordAnglia)Mount).FlyDown = true;
            }
        }
        if (Mount != null && Mount instanceof EntityMotorbike) {
            ((EntityMotorbike)Mount).FlyUp = false;
            ((EntityMotorbike)Mount).FlyDown = false;
            ((EntityMotorbike)Mount).FireBreath = false;
            if (data == 2L) {
                ((EntityMotorbike)Mount).FlyUp = true;
            }
            else if (data == 3L) {
                ((EntityMotorbike)Mount).FireBreath = true;
            }
            else if (data == 1L) {
                ((EntityMotorbike)Mount).FlyDown = true;
            }
        }
        if (Mount != null && Mount instanceof EntityMotorbike2) {
            ((EntityMotorbike2)Mount).FlyUp = false;
            ((EntityMotorbike2)Mount).FlyDown = false;
            ((EntityMotorbike2)Mount).FireBreath = false;
            if (data == 2L) {
                ((EntityMotorbike2)Mount).FlyUp = true;
            }
            else if (data == 3L) {
                ((EntityMotorbike2)Mount).FireBreath = true;
            }
            else if (data == 1L) {
                ((EntityMotorbike2)Mount).FlyDown = true;
            }
        }
        if (Mount != null && Mount instanceof EntityFlyingBroomstick) {
            ((EntityFlyingBroomstick)Mount).FlyUp = false;
            ((EntityFlyingBroomstick)Mount).FlyDown = false;
            ((EntityFlyingBroomstick)Mount).FireBreath = false;
            if (data == 2L) {
                ((EntityFlyingBroomstick)Mount).FlyUp = true;
            }
            else if (data == 3L) {
                ((EntityFlyingBroomstick)Mount).FireBreath = true;
            }
            else if (data == 1L) {
                ((EntityFlyingBroomstick)Mount).FlyDown = true;
            }
        }
        if (Mount != null && Mount instanceof EntityPhoenixForm) {
            ((EntityPhoenixForm)Mount).FlyUp = false;
            ((EntityPhoenixForm)Mount).FlyDown = false;
            ((EntityPhoenixForm)Mount).FireBreath = false;
            if (data == 2L) {
                ((EntityPhoenixForm)Mount).FlyUp = true;
            }
            else if (data == 3L) {
                ((EntityPhoenixForm)Mount).FireBreath = true;
            }
            else if (data == 1L) {
                ((EntityPhoenixForm)Mount).FlyDown = true;
            }
        }
        if (Mount != null && Mount instanceof EntityRavenForm) {
            ((EntityRavenForm)Mount).FlyUp = false;
            ((EntityRavenForm)Mount).FlyDown = false;
            if (data == 2L) {
                ((EntityRavenForm)Mount).FlyUp = true;
            }
            else if (data == 1L) {
                ((EntityRavenForm)Mount).FlyDown = true;
            }
        }
        if (Mount != null && Mount instanceof EntitySnidgetForm) {
            ((EntitySnidgetForm)Mount).FlyUp = false;
            ((EntitySnidgetForm)Mount).FlyDown = false;
            if (data == 2L) {
                ((EntitySnidgetForm)Mount).FlyUp = true;
            }
            else if (data == 1L) {
                ((EntitySnidgetForm)Mount).FlyDown = true;
            }
        }
        if (Mount != null && Mount instanceof EntityFalconForm) {
            ((EntityFalconForm)Mount).FlyUp = false;
            ((EntityFalconForm)Mount).FlyDown = false;
            if (data == 2L) {
                ((EntityFalconForm)Mount).FlyUp = true;
            }
            else if (data == 1L) {
                ((EntityFalconForm)Mount).FlyDown = true;
            }
        }
        if (Mount != null && Mount instanceof EntityOwlForm) {
            ((EntityOwlForm)Mount).FlyUp = false;
            ((EntityOwlForm)Mount).FlyDown = false;
            if (data == 2L) {
                ((EntityOwlForm)Mount).FlyUp = true;
            }
            else if (data == 1L) {
                ((EntityOwlForm)Mount).FlyDown = true;
            }
        }
        if (Mount != null && Mount instanceof EntityWerewolf) {
            ((EntityWerewolf)Mount).FlyUp = false;
            if (data == 2L) {
                ((EntityWerewolf)Mount).FlyUp = true;
            }
        }
        if (Mount != null && Mount instanceof EntityStagForm) {
            ((EntityStagForm)Mount).FlyUp = false;
            if (data == 2L) {
                ((EntityStagForm)Mount).FlyUp = true;
            }
        }
        if (Mount != null && Mount instanceof EntityDogForm) {
            ((EntityDogForm)Mount).FlyUp = false;
            if (data == 2L) {
                ((EntityDogForm)Mount).FlyUp = true;
            }
        }
        if (Mount != null && Mount instanceof EntityCatForm) {
            ((EntityCatForm)Mount).FlyUp = false;
            if (data == 2L) {
                ((EntityCatForm)Mount).FlyUp = true;
            }
        }
        if (Mount != null && Mount instanceof EntityRatForm) {
            ((EntityRatForm)Mount).FlyUp = false;
            if (data == 2L) {
                ((EntityRatForm)Mount).FlyUp = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.ElderWand) {
            ((ElderWandClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((ElderWandClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((ElderWandClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((ElderWandClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.RowanPhoenix) {
            ((RowanPhoenixClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((RowanPhoenixClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((RowanPhoenixClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((RowanPhoenixClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.OakPhoenix) {
            ((OakPhoenixClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((OakPhoenixClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((OakPhoenixClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((OakPhoenixClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.BirchPhoenix) {
            ((BirchPhoenixClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((BirchPhoenixClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((BirchPhoenixClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((BirchPhoenixClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.OakHippogriff) {
            ((OakHippogriffClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((OakHippogriffClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((OakHippogriffClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((OakHippogriffClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.BirchHippogriff) {
            ((BirchHippogriffClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((BirchHippogriffClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((BirchHippogriffClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((BirchHippogriffClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.BirchDragon) {
            ((BirchDragonClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((BirchDragonClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((BirchDragonClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((BirchDragonClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.OakDragon) {
            ((OakDragonClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((OakDragonClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((OakDragonClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((OakDragonClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.BirchBasilisk) {
            ((BirchBasiliskClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((BirchBasiliskClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((BirchBasiliskClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((BirchBasiliskClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.OakBasilisk) {
            ((OakBasiliskClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((OakBasiliskClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((OakBasiliskClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((OakBasiliskClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.BirchAcromantula) {
            ((BirchAcromantulaClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((BirchAcromantulaClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((BirchAcromantulaClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((BirchAcromantulaClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.OakAcromantula) {
            ((OakAcromantulaClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((OakAcromantulaClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((OakAcromantulaClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((OakAcromantulaClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.BirchUnicorn) {
            ((BirchUnicornClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((BirchUnicornClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((BirchUnicornClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((BirchUnicornClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.OakUnicorn) {
            ((OakUnicornClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((OakUnicornClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((OakUnicornClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((OakUnicornClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.BirchBillywig) {
            ((BirchBillywigClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((BirchBillywigClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((BirchBillywigClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((BirchBillywigClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.OakBillywig) {
            ((OakBillywigClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((OakBillywigClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((OakBillywigClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((OakBillywigClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.BirchAugurey) {
            ((BirchAugureylass)player.getHeldItem().getItem()).PrevSpell = false;
            ((BirchAugureylass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((BirchAugureylass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((BirchAugureylass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.OakAugurey) {
            ((OakAugureyClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((OakAugureyClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((OakAugureyClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((OakAugureyClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.BirchFairy) {
            ((BirchFairyClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((BirchFairyClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((BirchFairyClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((BirchFairyClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.OakFairy) {
            ((OakFairyClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((OakFairyClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((OakFairyClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((OakFairyClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.BirchBoomslang) {
            ((BirchBoomslangClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((BirchBoomslangClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((BirchBoomslangClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((BirchBoomslangClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.OakBoomslang) {
            ((OakBoomslangClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((OakBoomslangClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((OakBoomslangClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((OakBoomslangClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.BirchErumpent) {
            ((BirchErumpentClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((BirchErumpentClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((BirchErumpentClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((BirchErumpentClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.OakErumpent) {
            ((OakErumpentClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((OakErumpentClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((OakErumpentClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((OakErumpentClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.BirchKelpie) {
            ((BirchKelpieClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((BirchKelpieClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((BirchKelpieClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((BirchKelpieClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.OakKelpie) {
            ((OakKelpieClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((OakKelpieClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((OakKelpieClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((OakKelpieClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.BirchDemiguise) {
            ((BirchDemiguiseClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((BirchDemiguiseClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((BirchDemiguiseClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((BirchDemiguiseClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.OakDemiguise) {
            ((OakDemiguiseClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((OakDemiguiseClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((OakDemiguiseClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((OakDemiguiseClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.BirchVeela) {
            ((BirchVeelaClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((BirchVeelaClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((BirchVeelaClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((BirchVeelaClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.OakVeela) {
            ((OakVeelaClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((OakVeelaClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((OakVeelaClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((OakVeelaClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.BirchDoxy) {
            ((BirchDoxyClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((BirchDoxyClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((BirchDoxyClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((BirchDoxyClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.OakDoxy) {
            ((OakDoxyClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((OakDoxyClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((OakDoxyClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((OakDoxyClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.BirchFwooper) {
            ((BirchFwooperClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((BirchFwooperClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((BirchFwooperClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((BirchFwooperClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.OakFwooper) {
            ((OakFwooperClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((OakFwooperClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((OakFwooperClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((OakFwooperClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.BirchChimaera) {
            ((BirchChimaeraClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((BirchChimaeraClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((BirchChimaeraClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((BirchChimaeraClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.OakChimaera) {
            ((OakChimaeraClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((OakChimaeraClass)player.getHeldItem().getItem()).NextSpell = false;
            if (data == 6L) {
                ((OakChimaeraClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((OakChimaeraClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.DPSWandClass) {
            ((DPSWandClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((DPSWandClass)player.getHeldItem().getItem()).NextSpell = false;
            ((DPSWandClass)player.getHeldItem().getItem()).Nox = false;
            ((DPSWandClass)player.getHeldItem().getItem()).Quick0 = false;
            ((DPSWandClass)player.getHeldItem().getItem()).Quick1 = false;
            ((DPSWandClass)player.getHeldItem().getItem()).Quick2 = false;
            ((DPSWandClass)player.getHeldItem().getItem()).Quick3 = false;
            ((DPSWandClass)player.getHeldItem().getItem()).Quick4 = false;
            ((DPSWandClass)player.getHeldItem().getItem()).Quick5 = false;
            ((DPSWandClass)player.getHeldItem().getItem()).Quick6 = false;
            ((DPSWandClass)player.getHeldItem().getItem()).Quick7 = false;
            ((DPSWandClass)player.getHeldItem().getItem()).Quick8 = false;
            ((DPSWandClass)player.getHeldItem().getItem()).Quick9 = false;
            if (data == 6L) {
                ((DPSWandClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((DPSWandClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
            else if (data == 3L) {
                ((DPSWandClass)player.getHeldItem().getItem()).Nox = true;
            }
            else if (data == 8L) {
                ((DPSWandClass)player.getHeldItem().getItem()).Quick0 = true;
            }
            else if (data == 9L) {
                ((DPSWandClass)player.getHeldItem().getItem()).Quick1 = true;
            }
            else if (data == 10L) {
                ((DPSWandClass)player.getHeldItem().getItem()).Quick2 = true;
            }
            else if (data == 11L) {
                ((DPSWandClass)player.getHeldItem().getItem()).Quick3 = true;
            }
            else if (data == 12L) {
                ((DPSWandClass)player.getHeldItem().getItem()).Quick4 = true;
            }
            else if (data == 13L) {
                ((DPSWandClass)player.getHeldItem().getItem()).Quick5 = true;
            }
            else if (data == 14L) {
                ((DPSWandClass)player.getHeldItem().getItem()).Quick6 = true;
            }
            else if (data == 15L) {
                ((DPSWandClass)player.getHeldItem().getItem()).Quick7 = true;
            }
            else if (data == 16L) {
                ((DPSWandClass)player.getHeldItem().getItem()).Quick8 = true;
            }
            else if (data == 17L) {
                ((DPSWandClass)player.getHeldItem().getItem()).Quick9 = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.TankWandClass) {
            ((TankWandClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((TankWandClass)player.getHeldItem().getItem()).NextSpell = false;
            ((TankWandClass)player.getHeldItem().getItem()).Nox = false;
            ((TankWandClass)player.getHeldItem().getItem()).Quick0 = false;
            ((TankWandClass)player.getHeldItem().getItem()).Quick1 = false;
            ((TankWandClass)player.getHeldItem().getItem()).Quick2 = false;
            ((TankWandClass)player.getHeldItem().getItem()).Quick3 = false;
            ((TankWandClass)player.getHeldItem().getItem()).Quick4 = false;
            ((TankWandClass)player.getHeldItem().getItem()).Quick5 = false;
            ((TankWandClass)player.getHeldItem().getItem()).Quick6 = false;
            ((TankWandClass)player.getHeldItem().getItem()).Quick7 = false;
            ((TankWandClass)player.getHeldItem().getItem()).Quick8 = false;
            ((TankWandClass)player.getHeldItem().getItem()).Quick9 = false;
            if (data == 6L) {
                ((TankWandClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((TankWandClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
            else if (data == 3L) {
                ((TankWandClass)player.getHeldItem().getItem()).Nox = true;
            }
            else if (data == 8L) {
                ((TankWandClass)player.getHeldItem().getItem()).Quick0 = true;
            }
            else if (data == 9L) {
                ((TankWandClass)player.getHeldItem().getItem()).Quick1 = true;
            }
            else if (data == 10L) {
                ((TankWandClass)player.getHeldItem().getItem()).Quick2 = true;
            }
            else if (data == 11L) {
                ((TankWandClass)player.getHeldItem().getItem()).Quick3 = true;
            }
            else if (data == 12L) {
                ((TankWandClass)player.getHeldItem().getItem()).Quick4 = true;
            }
            else if (data == 13L) {
                ((TankWandClass)player.getHeldItem().getItem()).Quick5 = true;
            }
            else if (data == 14L) {
                ((TankWandClass)player.getHeldItem().getItem()).Quick6 = true;
            }
            else if (data == 15L) {
                ((TankWandClass)player.getHeldItem().getItem()).Quick7 = true;
            }
            else if (data == 16L) {
                ((TankWandClass)player.getHeldItem().getItem()).Quick8 = true;
            }
            else if (data == 17L) {
                ((TankWandClass)player.getHeldItem().getItem()).Quick9 = true;
            }
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == MainClass.SupportWandClass) {
            ((SupportWandClass)player.getHeldItem().getItem()).PrevSpell = false;
            ((SupportWandClass)player.getHeldItem().getItem()).NextSpell = false;
            ((SupportWandClass)player.getHeldItem().getItem()).Nox = false;
            ((SupportWandClass)player.getHeldItem().getItem()).Quick0 = false;
            ((SupportWandClass)player.getHeldItem().getItem()).Quick1 = false;
            ((SupportWandClass)player.getHeldItem().getItem()).Quick2 = false;
            ((SupportWandClass)player.getHeldItem().getItem()).Quick3 = false;
            ((SupportWandClass)player.getHeldItem().getItem()).Quick4 = false;
            ((SupportWandClass)player.getHeldItem().getItem()).Quick5 = false;
            ((SupportWandClass)player.getHeldItem().getItem()).Quick6 = false;
            ((SupportWandClass)player.getHeldItem().getItem()).Quick7 = false;
            ((SupportWandClass)player.getHeldItem().getItem()).Quick8 = false;
            ((SupportWandClass)player.getHeldItem().getItem()).Quick9 = false;
            if (data == 6L) {
                ((SupportWandClass)player.getHeldItem().getItem()).NextSpell = true;
            }
            else if (data == 7L) {
                ((SupportWandClass)player.getHeldItem().getItem()).PrevSpell = true;
            }
            else if (data == 3L) {
                ((SupportWandClass)player.getHeldItem().getItem()).Nox = true;
            }
            else if (data == 8L) {
                ((SupportWandClass)player.getHeldItem().getItem()).Quick0 = true;
            }
            else if (data == 9L) {
                ((SupportWandClass)player.getHeldItem().getItem()).Quick1 = true;
            }
            else if (data == 10L) {
                ((SupportWandClass)player.getHeldItem().getItem()).Quick2 = true;
            }
            else if (data == 11L) {
                ((SupportWandClass)player.getHeldItem().getItem()).Quick3 = true;
            }
            else if (data == 12L) {
                ((SupportWandClass)player.getHeldItem().getItem()).Quick4 = true;
            }
            else if (data == 13L) {
                ((SupportWandClass)player.getHeldItem().getItem()).Quick5 = true;
            }
            else if (data == 14L) {
                ((SupportWandClass)player.getHeldItem().getItem()).Quick6 = true;
            }
            else if (data == 15L) {
                ((SupportWandClass)player.getHeldItem().getItem()).Quick7 = true;
            }
            else if (data == 16L) {
                ((SupportWandClass)player.getHeldItem().getItem()).Quick8 = true;
            }
            else if (data == 17L) {
                ((SupportWandClass)player.getHeldItem().getItem()).Quick9 = true;
            }
        }
        if (Mount != null && Mount instanceof EntityWingedHorse) {
            ((EntityWingedHorse)Mount).FlyUp = false;
            ((EntityWingedHorse)Mount).FlyDown = false;
            if (data == 2L) {
                ((EntityWingedHorse)Mount).FlyUp = true;
            }
            else if (data == 1L) {
                ((EntityWingedHorse)Mount).FlyDown = true;
            }
        }
        if (Mount != null && Mount instanceof EntityUnicorn) {
            ((EntityUnicorn)Mount).FlyUp = false;
            ((EntityUnicorn)Mount).FlyDown = false;
            if (data == 2L) {
                ((EntityUnicorn)Mount).FlyUp = true;
            }
        }
        if (Mount != null && Mount instanceof EntityThestral) {
            ((EntityThestral)Mount).FlyUp = false;
            ((EntityThestral)Mount).FlyDown = false;
            if (data == 2L) {
                ((EntityThestral)Mount).FlyUp = true;
            }
            else if (data == 1L) {
                ((EntityThestral)Mount).FlyDown = true;
            }
        }
    }
    
    public static FMLProxyPacket getPacket(final int i, final Side side) {
        final ByteBuf buffer = Unpooled.buffer();
        buffer.writeLong(i);
        final FMLProxyPacket packet = new FMLProxyPacket(buffer, "Flying");
        packet.setTarget(side);
        return packet;
    }
}
