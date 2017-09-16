package snidgert.harrypottermod.generation;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import snidgert.harrypottermod.MainClass;

public class WizardWorldGen implements IWorldGenerator
{
	@Override
	public void generate(final Random random, final int chunkX, final int chunkZ, final World world, final IChunkProvider chunkGenerator, final IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case 0: {
			this.generateSurface(world, random, chunkX * 16, chunkZ * 16);
		}
		case 1: {
			this.generateEnd(world, random, chunkX * 16, chunkZ * 16);
		}
		case -1: {
			this.generateNether(world, random, chunkX * 16, chunkZ * 16);
			break;
		}
		}
	}

	public void generateNether(final World world, final Random random, final int x, final int z) {
	}

	public void generateEnd(final World world, final Random random, final int x, final int z) {
	}

	public void generateSurface(final World world, final Random random, final int x, final int z) {
		this.addOreSpawn(MainClass.SilverOre, 0, world, random, x, z, 16, 16, 4 + random.nextInt(6), 16, 30, 70);
		this.addOreSpawn(MainClass.RubyOre, 0, world, random, x, z, 16, 16, 4 + random.nextInt(6), 4, 1, 12);
		this.addOreSpawn(MainClass.Marble, 0, world, random, x, z, 16, 16, 4 + random.nextInt(6), 20, 40, 100);
		this.addOreSpawn(MainClass.BlackMarble, 0, world, random, x, z, 16, 16, 4 + random.nextInt(6), 20, 40, 100);
		this.addOreSpawn(MainClass.MagicPowerOre, 0, world, random, x, z, 16, 16, 4 + random.nextInt(6), 17, 10, 80);
		final BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(x, z);
		if (biome == BiomeGenBase.plains) {
			for (int a = 0; a < 1; ++a) {
				final int i = x + random.nextInt(256);
				final int j = z + random.nextInt(256);
				final int k = world.getHeightValue(i, j);
				new StructurePlatform().generate(world, random, i, k, j);
			}
		}
	}

	private void addOreSpawn(final Block block, final int meta, final World world, final Random random, final int blockX, final int blockZ, final int maxX, final int maxZ, final int maxSize, final int chance, final int minY, final int maxY) {
		for (int i = 0; i < chance; ++i) {
			final int posX = blockX + random.nextInt(maxX);
			final int posY = minY + random.nextInt(maxY - minY);
			final int posZ = blockZ + random.nextInt(maxZ);
			new WorldGenMinable(block, meta, maxSize, Blocks.stone).generate(world, random, posX, posY, posZ);
		}
	}
}
