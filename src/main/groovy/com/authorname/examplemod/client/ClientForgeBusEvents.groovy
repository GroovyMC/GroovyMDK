package com.authorname.examplemod.client

import groovy.transform.CompileStatic
import net.minecraft.client.gui.screens.TitleScreen
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.client.event.ScreenEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.thesilkminer.mc.austin.api.EventBus
import net.thesilkminer.mc.austin.api.EventBusSubscriber

import static com.authorname.examplemod.ExampleMod.*

@CompileStatic
@EventBusSubscriber(modId = MOD_ID, bus = EventBus.FORGE, dist = Dist.CLIENT)
class ClientForgeBusEvents {
    @SubscribeEvent
    static void onScreenOpen(final ScreenEvent.Opening event) {
        if (event.screen instanceof TitleScreen)
            LOGGER.info "${SV(event.screen.title.string)}"
    }
}
