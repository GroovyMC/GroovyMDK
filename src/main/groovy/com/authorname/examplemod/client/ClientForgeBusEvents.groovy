package com.authorname.examplemod.client

import com.matyrobbrt.gml.bus.EventBusSubscriber
import com.matyrobbrt.gml.bus.type.ForgeBus
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import net.minecraft.client.gui.screens.TitleScreen
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.client.event.ScreenEvent
import net.minecraftforge.eventbus.api.SubscribeEvent

@Slf4j
@CompileStatic
@EventBusSubscriber(value = ForgeBus, dist = Dist.CLIENT) // make sure you use com.matyrobbrt.gml.bus.EventBusSubscriber
class ClientForgeBusEvents {
    @SubscribeEvent
    static void onScreenOpen(final ScreenEvent.Opening event) {
        if (event.screen instanceof TitleScreen)
            log.info "${SV(event.screen.title.string)}"
    }
}
