package com.authorname.examplemod

import groovy.transform.CompileStatic
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent
import net.thesilkminer.mc.austin.api.EventBus
import net.thesilkminer.mc.austin.api.EventBusSubscriber

import static com.authorname.examplemod.ExampleMod.LOGGER

@CompileStatic
@EventBusSubscriber(bus = EventBus.MOD)
class CommonModBusEvents {
    @SubscribeEvent
    static void onLoadComplete(final FMLLoadCompleteEvent event) {
        LOGGER.info 'Hello from FMLLoadCompleteEvent'
    }
}
