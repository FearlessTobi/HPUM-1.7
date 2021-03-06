package snidgert.harrypottermod;

import java.util.HashMap;
import java.util.Map;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import snidgert.harrypottermod.food.TileEntityEveryFlavourBeans;
import snidgert.harrypottermod.mobs.Aragog;
import snidgert.harrypottermod.mobs.Augurey;
import snidgert.harrypottermod.mobs.Basilisk;
import snidgert.harrypottermod.mobs.Billywig;
import snidgert.harrypottermod.mobs.Bird;
import snidgert.harrypottermod.mobs.Bludger;
import snidgert.harrypottermod.mobs.BoggartDementor;
import snidgert.harrypottermod.mobs.Book;
import snidgert.harrypottermod.mobs.Bowtruckle;
import snidgert.harrypottermod.mobs.Bundimun;
import snidgert.harrypottermod.mobs.CatForm;
import snidgert.harrypottermod.mobs.Centaur;
import snidgert.harrypottermod.mobs.Chizpurfle;
import snidgert.harrypottermod.mobs.Clabbert;
import snidgert.harrypottermod.mobs.Dementor;
import snidgert.harrypottermod.mobs.Demiguise;
import snidgert.harrypottermod.mobs.DogForm;
import snidgert.harrypottermod.mobs.Dugbog;
import snidgert.harrypottermod.mobs.Fairy;
import snidgert.harrypottermod.mobs.FalconForm;
import snidgert.harrypottermod.mobs.FiendFyreDragon;
import snidgert.harrypottermod.mobs.FireCrab;
import snidgert.harrypottermod.mobs.Flobberworm;
import snidgert.harrypottermod.mobs.Fluffy;
import snidgert.harrypottermod.mobs.FlyingBroomstick;
import snidgert.harrypottermod.mobs.FordAnglia;
import snidgert.harrypottermod.mobs.Fwooper;
import snidgert.harrypottermod.mobs.Ghost;
import snidgert.harrypottermod.mobs.Ghoul;
import snidgert.harrypottermod.mobs.Gnome;
import snidgert.harrypottermod.mobs.Goblin;
import snidgert.harrypottermod.mobs.GoldenSnitch;
import snidgert.harrypottermod.mobs.Graphorn;
import snidgert.harrypottermod.mobs.Griffin;
import snidgert.harrypottermod.mobs.Grindylow;
import snidgert.harrypottermod.mobs.Hippocampus;
import snidgert.harrypottermod.mobs.Hippogriff;
import snidgert.harrypottermod.mobs.Horklump;
import snidgert.harrypottermod.mobs.Horntail;
import snidgert.harrypottermod.mobs.HouseElf;
import snidgert.harrypottermod.mobs.Imp;
import snidgert.harrypottermod.mobs.ImperioMob;
import snidgert.harrypottermod.mobs.Jarvey;
import snidgert.harrypottermod.mobs.Jobberknoll;
import snidgert.harrypottermod.mobs.Kelpie;
import snidgert.harrypottermod.mobs.Key;
import snidgert.harrypottermod.mobs.Knarl;
import snidgert.harrypottermod.mobs.Kneazle;
import snidgert.harrypottermod.mobs.Leprechaun;
import snidgert.harrypottermod.mobs.Levitate;
import snidgert.harrypottermod.mobs.MasterKey;
import snidgert.harrypottermod.mobs.Mermaid;
import snidgert.harrypottermod.mobs.ModelAurorArmour;
import snidgert.harrypottermod.mobs.ModelDeathEaterArmor;
import snidgert.harrypottermod.mobs.Moke;
import snidgert.harrypottermod.mobs.MonsterBook;
import snidgert.harrypottermod.mobs.Motorbike;
import snidgert.harrypottermod.mobs.Motorbike2;
import snidgert.harrypottermod.mobs.Nagini;
import snidgert.harrypottermod.mobs.Nogtail;
import snidgert.harrypottermod.mobs.Nundu;
import snidgert.harrypottermod.mobs.Occamy;
import snidgert.harrypottermod.mobs.OwlForm;
import snidgert.harrypottermod.mobs.Patronus;
import snidgert.harrypottermod.mobs.Phoenix;
import snidgert.harrypottermod.mobs.PhoenixForm;
import snidgert.harrypottermod.mobs.Pixie;
import snidgert.harrypottermod.mobs.Puffskein;
import snidgert.harrypottermod.mobs.Quaffle;
import snidgert.harrypottermod.mobs.Quintaped;
import snidgert.harrypottermod.mobs.Ramora;
import snidgert.harrypottermod.mobs.RatFrom;
import snidgert.harrypottermod.mobs.RavenForm;
import snidgert.harrypottermod.mobs.RedCap;
import snidgert.harrypottermod.mobs.Reem;
import snidgert.harrypottermod.mobs.Runespoor;
import snidgert.harrypottermod.mobs.Shield;
import snidgert.harrypottermod.mobs.Snake;
import snidgert.harrypottermod.mobs.Snidget;
import snidgert.harrypottermod.mobs.SnidgetForm;
import snidgert.harrypottermod.mobs.StagForm;
import snidgert.harrypottermod.mobs.StoneSoldier;
import snidgert.harrypottermod.mobs.Tebo;
import snidgert.harrypottermod.mobs.Thestral;
import snidgert.harrypottermod.mobs.Troll;
import snidgert.harrypottermod.mobs.UkaranianIronbelly;
import snidgert.harrypottermod.mobs.Unicorn;
import snidgert.harrypottermod.mobs.Veela;
import snidgert.harrypottermod.mobs.Werewolf;
import snidgert.harrypottermod.mobs.WerewolfArmor;
import snidgert.harrypottermod.mobs.WerewolfMob;
import snidgert.harrypottermod.mobs.WingedHorse;
import snidgert.harrypottermod.mobs.entity.EntityAragog;
import snidgert.harrypottermod.mobs.entity.EntityAugurey;
import snidgert.harrypottermod.mobs.entity.EntityBasilisk;
import snidgert.harrypottermod.mobs.entity.EntityBillywig;
import snidgert.harrypottermod.mobs.entity.EntityBird;
import snidgert.harrypottermod.mobs.entity.EntityBludger;
import snidgert.harrypottermod.mobs.entity.EntityBoggartDementor;
import snidgert.harrypottermod.mobs.entity.EntityBook;
import snidgert.harrypottermod.mobs.entity.EntityBowtruckle;
import snidgert.harrypottermod.mobs.entity.EntityBundimun;
import snidgert.harrypottermod.mobs.entity.EntityCatForm;
import snidgert.harrypottermod.mobs.entity.EntityCentaur;
import snidgert.harrypottermod.mobs.entity.EntityChizpurfle;
import snidgert.harrypottermod.mobs.entity.EntityClabbert;
import snidgert.harrypottermod.mobs.entity.EntityDementor;
import snidgert.harrypottermod.mobs.entity.EntityDemiguise;
import snidgert.harrypottermod.mobs.entity.EntityDogForm;
import snidgert.harrypottermod.mobs.entity.EntityDugbog;
import snidgert.harrypottermod.mobs.entity.EntityFairy;
import snidgert.harrypottermod.mobs.entity.EntityFalconForm;
import snidgert.harrypottermod.mobs.entity.EntityFiendfyreDragon;
import snidgert.harrypottermod.mobs.entity.EntityFireCrab;
import snidgert.harrypottermod.mobs.entity.EntityFlobberworm;
import snidgert.harrypottermod.mobs.entity.EntityFluffy;
import snidgert.harrypottermod.mobs.entity.EntityFlyingBroomstick;
import snidgert.harrypottermod.mobs.entity.EntityFordAnglia;
import snidgert.harrypottermod.mobs.entity.EntityFwooper;
import snidgert.harrypottermod.mobs.entity.EntityGhost;
import snidgert.harrypottermod.mobs.entity.EntityGhoul;
import snidgert.harrypottermod.mobs.entity.EntityGnome;
import snidgert.harrypottermod.mobs.entity.EntityGoblin;
import snidgert.harrypottermod.mobs.entity.EntityGoldenSnitch;
import snidgert.harrypottermod.mobs.entity.EntityGraphorn;
import snidgert.harrypottermod.mobs.entity.EntityGriffin;
import snidgert.harrypottermod.mobs.entity.EntityGrindylow;
import snidgert.harrypottermod.mobs.entity.EntityHippocampus;
import snidgert.harrypottermod.mobs.entity.EntityHippogriff;
import snidgert.harrypottermod.mobs.entity.EntityHorklump;
import snidgert.harrypottermod.mobs.entity.EntityHorntail;
import snidgert.harrypottermod.mobs.entity.EntityHouseElf;
import snidgert.harrypottermod.mobs.entity.EntityImp;
import snidgert.harrypottermod.mobs.entity.EntityImperioMob;
import snidgert.harrypottermod.mobs.entity.EntityJarvey;
import snidgert.harrypottermod.mobs.entity.EntityJobberknoll;
import snidgert.harrypottermod.mobs.entity.EntityKelpie;
import snidgert.harrypottermod.mobs.entity.EntityKey;
import snidgert.harrypottermod.mobs.entity.EntityKnarl;
import snidgert.harrypottermod.mobs.entity.EntityKneazle;
import snidgert.harrypottermod.mobs.entity.EntityLeprechaun;
import snidgert.harrypottermod.mobs.entity.EntityLevitate;
import snidgert.harrypottermod.mobs.entity.EntityMasterKey;
import snidgert.harrypottermod.mobs.entity.EntityMermaid;
import snidgert.harrypottermod.mobs.entity.EntityMoke;
import snidgert.harrypottermod.mobs.entity.EntityMonsterBook;
import snidgert.harrypottermod.mobs.entity.EntityMotorbike;
import snidgert.harrypottermod.mobs.entity.EntityMotorbike2;
import snidgert.harrypottermod.mobs.entity.EntityNagini;
import snidgert.harrypottermod.mobs.entity.EntityNogtail;
import snidgert.harrypottermod.mobs.entity.EntityNundu;
import snidgert.harrypottermod.mobs.entity.EntityOccamy;
import snidgert.harrypottermod.mobs.entity.EntityOwlForm;
import snidgert.harrypottermod.mobs.entity.EntityPatronus;
import snidgert.harrypottermod.mobs.entity.EntityPhoenix;
import snidgert.harrypottermod.mobs.entity.EntityPhoenixForm;
import snidgert.harrypottermod.mobs.entity.EntityPixie;
import snidgert.harrypottermod.mobs.entity.EntityPuffskein;
import snidgert.harrypottermod.mobs.entity.EntityQuaffle;
import snidgert.harrypottermod.mobs.entity.EntityQuintaped;
import snidgert.harrypottermod.mobs.entity.EntityRamora;
import snidgert.harrypottermod.mobs.entity.EntityRatForm;
import snidgert.harrypottermod.mobs.entity.EntityRavenForm;
import snidgert.harrypottermod.mobs.entity.EntityRedCap;
import snidgert.harrypottermod.mobs.entity.EntityReem;
import snidgert.harrypottermod.mobs.entity.EntityRunespoor;
import snidgert.harrypottermod.mobs.entity.EntityShield;
import snidgert.harrypottermod.mobs.entity.EntitySnake;
import snidgert.harrypottermod.mobs.entity.EntitySnidget;
import snidgert.harrypottermod.mobs.entity.EntitySnidgetForm;
import snidgert.harrypottermod.mobs.entity.EntityStagForm;
import snidgert.harrypottermod.mobs.entity.EntityStoneSoldier;
import snidgert.harrypottermod.mobs.entity.EntityTebo;
import snidgert.harrypottermod.mobs.entity.EntityThestral;
import snidgert.harrypottermod.mobs.entity.EntityTroll;
import snidgert.harrypottermod.mobs.entity.EntityUkaranianIronbelly;
import snidgert.harrypottermod.mobs.entity.EntityUnicorn;
import snidgert.harrypottermod.mobs.entity.EntityVeela;
import snidgert.harrypottermod.mobs.entity.EntityWerewolf;
import snidgert.harrypottermod.mobs.entity.EntityWerewolfMob;
import snidgert.harrypottermod.mobs.entity.EntityWingedHorse;
import snidgert.harrypottermod.mobs.render.*;
import snidgert.harrypottermod.projectiles.AraniaExumaiProjectile;
import snidgert.harrypottermod.projectiles.AvadakedavraProjectile;
import snidgert.harrypottermod.projectiles.ConfringoProjectile;
import snidgert.harrypottermod.projectiles.ConfringoStrongProjectile;
import snidgert.harrypottermod.projectiles.ConfundoProjectile;
import snidgert.harrypottermod.projectiles.ConfundoStrongProjectile;
import snidgert.harrypottermod.projectiles.CrucioProjectile;
import snidgert.harrypottermod.projectiles.CrucioStrongProjectile;
import snidgert.harrypottermod.projectiles.ExpelliarmusProjectile;
import snidgert.harrypottermod.projectiles.ExpelliarmusStrongProjectile;
import snidgert.harrypottermod.projectiles.ImperioProjectile;
import snidgert.harrypottermod.projectiles.IncendioProjectile;
import snidgert.harrypottermod.projectiles.LevicorpusProjectile;
import snidgert.harrypottermod.projectiles.LevicorpusStrongProjectile;
import snidgert.harrypottermod.projectiles.PatronusProjectile;
import snidgert.harrypottermod.projectiles.PatronusStrongProjectile;
import snidgert.harrypottermod.projectiles.ReductoProjectile;
import snidgert.harrypottermod.projectiles.ReductoStrongProjectile;
import snidgert.harrypottermod.projectiles.SectumsempraProjectile;
import snidgert.harrypottermod.projectiles.SectumsempraStrongProjectile;
import snidgert.harrypottermod.projectiles.StunProjectile;
import snidgert.harrypottermod.projectiles.StunStrongProjectile;
import snidgert.harrypottermod.projectiles.StupefyProjectile;
import snidgert.harrypottermod.projectiles.StupefyStrongProjectile;
import snidgert.harrypottermod.tileentities.TileEntityBoggartChestLocked;
import snidgert.harrypottermod.tileentities.TileEntityBoggartChestOpen;
import snidgert.harrypottermod.tileentities.TileEntityCabinet;
import snidgert.harrypottermod.tileentities.TileEntityCrystalball;
import snidgert.harrypottermod.tileentities.TileEntityCup;
import snidgert.harrypottermod.tileentities.TileEntityDarkMarkClass;
import snidgert.harrypottermod.tileentities.TileEntityDiadem;
import snidgert.harrypottermod.tileentities.TileEntityDiary;
import snidgert.harrypottermod.tileentities.TileEntityGOF;
import snidgert.harrypottermod.tileentities.TileEntityGoldenEgg;
import snidgert.harrypottermod.tileentities.TileEntityGoldenEggOpen;
import snidgert.harrypottermod.tileentities.TileEntityHand;
import snidgert.harrypottermod.tileentities.TileEntityHat;
import snidgert.harrypottermod.tileentities.TileEntityLocket;
import snidgert.harrypottermod.tileentities.TileEntityMirror;
import snidgert.harrypottermod.tileentities.TileEntityPensieve;
import snidgert.harrypottermod.tileentities.TileEntityPensievePlane;
import snidgert.harrypottermod.tileentities.TileEntityRing;
import snidgert.harrypottermod.tileentities.TileEntityStoneSoldierBlock;
import snidgert.harrypottermod.tileentities.TileEntityTriCup;
import snidgert.harrypottermod.tileentities.TileEntityWandCrafter;

public class ClientProxy extends CommonProxy {
	public static int KEY_DOWN;
	public static int KEY_UP;
	public static int KEY_SPECIAL;
	public static int KEY_PREVWAND;
	public static int KEY_NEXTWAND;
	public static int KEY_Quick0;
	public static int KEY_Quick1;
	public static int KEY_Quick2;
	public static int KEY_Quick3;
	public static int KEY_Quick4;
	public static int KEY_Quick5;
	public static int KEY_Quick6;
	public static int KEY_Quick7;
	public static int KEY_Quick8;
	public static int KEY_Quick9;
	public static final Map<Item, ModelBiped> armorModel;

	@Override
	public void preInit() {
		super.preInit();
		FMLCommonHandler.instance().bus()
		.register(new KeyHandler(ClientProxy.KEY_UP, ClientProxy.KEY_DOWN, ClientProxy.KEY_SPECIAL, ClientProxy.KEY_PREVWAND, ClientProxy.KEY_NEXTWAND, ClientProxy.KEY_Quick0,
				ClientProxy.KEY_Quick1, ClientProxy.KEY_Quick2, ClientProxy.KEY_Quick3, ClientProxy.KEY_Quick4, ClientProxy.KEY_Quick5, ClientProxy.KEY_Quick6, ClientProxy.KEY_Quick7,
				ClientProxy.KEY_Quick8, ClientProxy.KEY_Quick9));
	}

	@Override
	public void renderStuff() {
		RenderingRegistry.registerEntityRenderingHandler(ExpelliarmusProjectile.class, new RenderExpelliarmusProjectile(0));
		RenderingRegistry.registerEntityRenderingHandler(AvadakedavraProjectile.class, new RenderAvadakedavraProjectile(0));
		RenderingRegistry.registerEntityRenderingHandler(PatronusProjectile.class, new RenderPatronusProjectile(0));
		RenderingRegistry.registerEntityRenderingHandler(StupefyProjectile.class, new RenderStupefyProjectile(0));
		RenderingRegistry.registerEntityRenderingHandler(ConfringoProjectile.class, new RenderConfringoProjectile(0));
		RenderingRegistry.registerEntityRenderingHandler(ReductoProjectile.class, new RenderReductoProjectile(0));
		RenderingRegistry.registerEntityRenderingHandler(CrucioProjectile.class, new RenderCrucioProjectile(0));
		RenderingRegistry.registerEntityRenderingHandler(ImperioProjectile.class, new RenderImperioProjectile(0));
		RenderingRegistry.registerEntityRenderingHandler(AraniaExumaiProjectile.class, new RenderAraniaExumaiProjectile(0));
		RenderingRegistry.registerEntityRenderingHandler(SectumsempraProjectile.class, new RenderSectumsempraProjectile(0));
		RenderingRegistry.registerEntityRenderingHandler(LevicorpusProjectile.class, new RenderLevicorpusProjectile(0));
		RenderingRegistry.registerEntityRenderingHandler(IncendioProjectile.class, new RenderIncendioProjectile(0));
		RenderingRegistry.registerEntityRenderingHandler(StunProjectile.class, new RenderStunProjectile(0));
		RenderingRegistry.registerEntityRenderingHandler(ConfundoProjectile.class, new RenderConfundoProjectile(0));
		RenderingRegistry.registerEntityRenderingHandler(PatronusStrongProjectile.class, new RenderPatronusStrongProjectile(0));
		RenderingRegistry.registerEntityRenderingHandler(ExpelliarmusStrongProjectile.class, new RenderExpelliarmusStrongProjectile(0));
		RenderingRegistry.registerEntityRenderingHandler(StupefyStrongProjectile.class, new RenderStupefyStrongProjectile(0));
		RenderingRegistry.registerEntityRenderingHandler(ConfringoStrongProjectile.class, new RenderConfringoStrongProjectile(0));
		RenderingRegistry.registerEntityRenderingHandler(ReductoStrongProjectile.class, new RenderReductoStrongProjectile(0));
		RenderingRegistry.registerEntityRenderingHandler(CrucioStrongProjectile.class, new RenderCrucioStrongProjectile(0));
		RenderingRegistry.registerEntityRenderingHandler(SectumsempraStrongProjectile.class, new RenderSectumsempraStrongProjectile(0));
		RenderingRegistry.registerEntityRenderingHandler(LevicorpusStrongProjectile.class, new RenderLevicorpusStrongProjectile(0));
		RenderingRegistry.registerEntityRenderingHandler(StunStrongProjectile.class, new RenderStunStrongProjectile(0));
		RenderingRegistry.registerEntityRenderingHandler(ConfundoStrongProjectile.class, new RenderConfundoStrongProjectile(0));
		final TileEntitySpecialRenderer render1 = new RenderCup();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCup.class, render1);
		final TileEntitySpecialRenderer render2 = new RenderTriCup();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTriCup.class, render2);
		final TileEntitySpecialRenderer render3 = new RenderDiadem();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDiadem.class, render3);
		final TileEntitySpecialRenderer render4 = new RenderDiary();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDiary.class, render4);
		final TileEntitySpecialRenderer render5 = new RenderGoldenEgg();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGoldenEgg.class, render5);
		final TileEntitySpecialRenderer render6 = new RenderGoldenEggOpen();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGoldenEggOpen.class, render6);
		final TileEntitySpecialRenderer render7 = new RenderPensievePlane();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPensievePlane.class, render7);
		final TileEntitySpecialRenderer render8 = new RenderPensieve();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPensieve.class, render8);
		final TileEntitySpecialRenderer render9 = new RenderLocket();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLocket.class, render9);
		final TileEntitySpecialRenderer render10 = new RenderRing();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRing.class, render10);
		final TileEntitySpecialRenderer render11 = new RenderHand();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHand.class, render11);
		final TileEntitySpecialRenderer render12 = new RenderMirror();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMirror.class, render12);
		final TileEntitySpecialRenderer render13 = new RenderGOF();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGOF.class, render13);
		final TileEntitySpecialRenderer render14 = new RenderCabinet();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCabinet.class, render14);
		final TileEntitySpecialRenderer render15 = new RenderEveryFlavourBeans();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEveryFlavourBeans.class, render15);
		final TileEntitySpecialRenderer render16 = new RenderHat();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHat.class, render16);
		final TileEntitySpecialRenderer render17 = new RenderBoggartChestLocked();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBoggartChestLocked.class, render17);
		final TileEntitySpecialRenderer render18 = new RenderBoggartChestOpen();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBoggartChestOpen.class, render18);
		final TileEntitySpecialRenderer render19 = new RenderWandCrafter();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWandCrafter.class, render19);
		final TileEntitySpecialRenderer render20 = new RenderCrystalball();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCrystalball.class, render20);
		final TileEntitySpecialRenderer render21 = new RenderDarkMark();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDarkMarkClass.class, render21);
		final TileEntitySpecialRenderer render22 = new RenderStoneSoldierBlock();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStoneSoldierBlock.class, render22);


		RenderingRegistry.registerEntityRenderingHandler(EntityHorntail.class, new RenderHorntail(new Horntail(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityBasilisk.class, new RenderBasilisk(new Basilisk(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityFluffy.class, new RenderFluffy(new Fluffy(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityWerewolfMob.class, new RenderWerewolfMob(new WerewolfMob(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityHippogriff.class, new RenderHippogriff(new Hippogriff(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityPhoenix.class, new RenderPhoenix(new Phoenix(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityDementor.class, new RenderDementor(new Dementor(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityBook.class, new RenderBook(new Book(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntitySnake.class, new RenderSnake(new Snake(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityShield.class, new RenderShield(new Shield(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityPatronus.class, new RenderPatronus(new Patronus(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityBird.class, new RenderBird(new Bird(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityImperioMob.class, new RenderImperioMob(new ImperioMob(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityMonsterBook.class, new RenderMonsterBook(new MonsterBook(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityLevitate.class, new RenderLevitate(new Levitate(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityGoldenSnitch.class, new RenderGoldenSnitch(new GoldenSnitch(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityQuaffle.class, new RenderQuaffle(new Quaffle(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityBludger.class, new RenderBludger(new Bludger(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityFordAnglia.class, new RenderFordAnglia(new FordAnglia(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityMotorbike.class, new RenderMotorbike(new Motorbike(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityMotorbike2.class, new RenderMotorbike2(new Motorbike2(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityFlyingBroomstick.class, new RenderFlyingBroomstick(new FlyingBroomstick(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityWerewolf.class, new RenderWerewolf(new Werewolf(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityStagForm.class, new RenderStagForm(new StagForm(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityDogForm.class, new RenderDogForm(new DogForm(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityCatForm.class, new RenderCatForm(new CatForm(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityRatForm.class, new RenderRatForm(new RatFrom(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityAragog.class, new RenderAragog(new Aragog(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityPhoenixForm.class, new RenderPhoenixForm(new PhoenixForm(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityRavenForm.class, new RenderRavenForm(new RavenForm(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntitySnidgetForm.class, new RenderSnidgetForm(new SnidgetForm(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityFalconForm.class, new RenderFalconForm(new FalconForm(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityOwlForm.class, new RenderOwlForm(new OwlForm(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityNagini.class, new RenderNagini(new Nagini(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityKey.class, new RenderKey(new Key(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityMasterKey.class, new RenderMasterKey(new MasterKey(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityGhost.class, new RenderGhost(new Ghost(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityFiendfyreDragon.class, new RenderFiendfyreDragon(new FiendFyreDragon(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityHouseElf.class, new RenderHouseElf(new HouseElf(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityBoggartDementor.class, new RenderBoggartDementor(new BoggartDementor(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityWingedHorse.class, new RenderWingedHorse(new WingedHorse(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityUnicorn.class, new RenderUnicorn(new Unicorn(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityThestral.class, new RenderThestral(new Thestral(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityBillywig.class, new RenderBillywig(new Billywig(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityGriffin.class, new RenderGriffin(new Griffin(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityGrindylow.class, new RenderGrindylow(new Grindylow(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityHippocampus.class, new RenderHippocampus(new Hippocampus(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityPuffskein.class, new RenderPuffskein(new Puffskein(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityNogtail.class, new RenderNogtail(new Nogtail(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityRunespoor.class, new RenderRunespoor(new Runespoor(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityTroll.class, new RenderTroll(new Troll(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityRedCap.class, new RenderRedCap(new RedCap(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityBowtruckle.class, new RenderBowtruckle(new Bowtruckle(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityPixie.class, new RenderPixie(new Pixie(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityGoblin.class, new RenderGoblin(new Goblin(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityFairy.class, new RenderFairy(new Fairy(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityAugurey.class, new RenderAugurey(new Augurey(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityUkaranianIronbelly.class, new RenderUkaranianIronbelly(new UkaranianIronbelly(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityClabbert.class, new RenderClabbert(new Clabbert(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityBundimun.class, new RenderBundimun(new Bundimun(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityChizpurfle.class, new RenderChizpurfle(new Chizpurfle(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityMermaid.class, new RenderMermaid(new Mermaid(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityCentaur.class, new RenderCentaur(new Centaur(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityDugbog.class, new RenderDugbog(new Dugbog(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityGnome.class, new RenderGnome(new Gnome(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityTebo.class, new RenderTebo(new Tebo(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityRamora.class, new RenderRamora(new Ramora(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityMoke.class, new RenderMoke(new Moke(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityJobberknoll.class, new RenderJobberknoll(new Jobberknoll(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntitySnidget.class, new RenderSnidget(new Snidget(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityDemiguise.class, new RenderDemiguise(new Demiguise(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityFireCrab.class, new RenderFireCrab(new FireCrab(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityFlobberworm.class, new RenderFlobberworm(new Flobberworm(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityFwooper.class, new RenderFwooper(new Fwooper(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityGhoul.class, new RenderGhoul(new Ghoul(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityGraphorn.class, new RenderGraphorn(new Graphorn(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityHorklump.class, new RenderHorklump(new Horklump(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityImp.class, new RenderImp(new Imp(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityJarvey.class, new RenderJarvey(new Jarvey(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityKelpie.class, new RenderKelpie(new Kelpie(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityKnarl.class, new RenderKnarl(new Knarl(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityKneazle.class, new RenderKneazle(new Kneazle(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityNundu.class, new RenderNundu(new Nundu(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityOccamy.class, new RenderOccamy(new Occamy(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityQuintaped.class, new RenderQuintaped(new Quintaped(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityReem.class, new RenderReem(new Reem(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityVeela.class, new RenderVeela(new Veela(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityLeprechaun.class, new RenderLeprechaun(new Leprechaun(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityStoneSoldier.class, new RenderStoneSoldier(new StoneSoldier(), 0.3f));


		final ModelAurorArmour auror_armor = new ModelAurorArmour(0.5f);
		final ModelAurorArmour auror_legs = new ModelAurorArmour(0.5f);
		final WerewolfArmor werewolf_armor = new WerewolfArmor(0.5f);
		final WerewolfArmor werewolf_legs = new WerewolfArmor(0.5f);
		final ModelDeathEaterArmor deatheater_armor = new ModelDeathEaterArmor(0.5f);
		final ModelDeathEaterArmor deatheater_legs = new ModelDeathEaterArmor(0.5f);
		ClientProxy.armorModel.put(MainClass.AurorChest, auror_armor);
		ClientProxy.armorModel.put(MainClass.AurorHat, auror_armor);
		ClientProxy.armorModel.put(MainClass.AurorLegs, auror_legs);
		ClientProxy.armorModel.put(MainClass.AurorShoes, auror_armor);
		ClientProxy.armorModel.put(MainClass.DeathEaterChest, deatheater_armor);
		ClientProxy.armorModel.put(MainClass.DeathEaterHat, deatheater_armor);
		ClientProxy.armorModel.put(MainClass.DeathEaterLegs, deatheater_legs);
		ClientProxy.armorModel.put(MainClass.DeathEaterShoes, deatheater_armor);
		ClientProxy.armorModel.put(MainClass.WerewolfChest, werewolf_armor);
		ClientProxy.armorModel.put(MainClass.WerewolfHead, werewolf_armor);
		ClientProxy.armorModel.put(MainClass.WerewolfLegs, werewolf_legs);
		ClientProxy.armorModel.put(MainClass.WerewolfFeet, werewolf_armor);
	}

	@Override
	public void registerItemRenderers() {
		MinecraftForgeClient.registerItemRenderer(MainClass.SwordofGryffindor, new RenderSwordOfGryffindor());
	}

	@Override
	public void registerTileEntitySpecialRenderer() {
	}

	static {
		ClientProxy.KEY_DOWN = 46;
		ClientProxy.KEY_UP = 19;
		ClientProxy.KEY_SPECIAL = 33;
		ClientProxy.KEY_PREVWAND = 47;
		ClientProxy.KEY_NEXTWAND = 34;
		ClientProxy.KEY_Quick0 = 82;
		ClientProxy.KEY_Quick1 = 79;
		ClientProxy.KEY_Quick2 = 80;
		ClientProxy.KEY_Quick3 = 81;
		ClientProxy.KEY_Quick4 = 75;
		ClientProxy.KEY_Quick5 = 76;
		ClientProxy.KEY_Quick6 = 77;
		ClientProxy.KEY_Quick7 = 71;
		ClientProxy.KEY_Quick8 = 72;
		ClientProxy.KEY_Quick9 = 73;
		armorModel = new HashMap<Item, ModelBiped>();
	}
}
