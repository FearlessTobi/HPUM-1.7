package snidgert.harrypottermod;

import cpw.mods.fml.common.network.*;

public class CommonProxy
{
    public FMLEventChannel channel;
    
    public void renderStuff() {
    }
    
    public void registerTileEntitySpecialRenderer() {
    }
    
    public void registerItemRenderers() {
    }
    
    public void preInit() {
        (this.channel = NetworkRegistry.INSTANCE.newEventDrivenChannel("Flying")).register(new EntityPacketHandler());
    }
}
