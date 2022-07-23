package com.authorname.examplemod.client

import com.authorname.examplemod.Configs
import groovy.transform.CompileStatic
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent
import net.thesilkminer.mc.austin.api.EventBus
import net.thesilkminer.mc.austin.api.EventBusSubscriber

import static com.authorname.examplemod.ExampleMod.*

@CompileStatic
@EventBusSubscriber(modId = MOD_ID, bus = EventBus.MOD)
class CommonModBusEvents {
    @SubscribeEvent
    static void onLoadComplete(final FMLLoadCompleteEvent event) {
        LOGGER.info 'Hello from FMLLoadCompleteEvent'
        Configs.Common.runCounter = Configs.Common.runCounter + 1 as short
        LOGGER.info SV(Configs.Common.runCounter)
    }
}
