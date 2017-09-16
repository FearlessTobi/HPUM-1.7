package snidgert.harrypottermod.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockTorch;
import net.minecraft.world.World;

public class TorchOffClass extends BlockTorch {
	public TorchOffClass() {
		super();
		this.setTickRandomly(true);
		this.setBlockTextureName("harrypottermod:TorchOff");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_){
	}

}
