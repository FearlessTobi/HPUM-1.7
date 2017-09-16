package snidgert.harrypottermod.generation;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeLondon extends BiomeGenBase
{
    private static final BiomeGenBase.Height biomeHeight;
    
    public BiomeLondon(final int id) {
        super(id);
        this.setHeight(BiomeLondon.biomeHeight);
        this.setColor(2590532);
        this.setTemperatureRainfall(0.9f, 1.0f);
        super.waterColorMultiplier = 1969384;
    }
    
    @Override
	public int getBiomeGrassColor(final int x, final int y, final int z) {
        return 2590532;
    }
    
    @Override
	public int getBiomeFoliageColor(final int x, final int y, final int z) {
        return 5729038;
    }
    
    @Override
	public int getSkyColorByTemp(final float par1) {
        return 0;
    }
    
    static {
        biomeHeight = new BiomeGenBase.Height(0.1f, 0.2f);
    }
}
