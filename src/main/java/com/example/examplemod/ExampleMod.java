package com.example.examplemod;

import com.example.examplemod.Proxies.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = ExampleMod.MODID, name = ExampleMod.MODNAME, version = ExampleMod.VERSION, useMetadata = true)
public class ExampleMod
{
    public static final String MODID = "modtut";
    public static final String MODNAME = "Mod tutorials";
    public static final String VERSION = "0.0.1";

    @SidedProxy(clientSide = "com.example.examplemod.Proxies.ClientProxy", serverSide = "com.example.examplemod.Proxies.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static ExampleMod instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}
