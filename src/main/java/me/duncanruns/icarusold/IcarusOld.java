package me.duncanruns.icarusold;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = IcarusOld.MODID, version = IcarusOld.VERSION)
public class IcarusOld
{
    public static final String MODID = "icarusold";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(GivePlayerWingsEvent.instance);
    }
}
