package com.authorname.examplemod.client

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import net.minecraft.client.gui.screens.TitleScreen
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.client.event.ScreenEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import org.groovymc.gml.bus.EventBusSubscriber
import org.groovymc.gml.bus.type.ForgeBus

@Slf4j
@CompileStatic
@EventBusSubscriber(value = ForgeBus, dist = Dist.CLIENT) // make sure you use org.groovymc.gml.bus.EventBusSubscriber
class ClientForgeBusEvents {
    @SubscribeEvent
    static void onScreenOpen(final ScreenEvent.Opening event) {
        if (event.screen instanceof TitleScreen)
            log.info "${SV(event.screen.title.string)}"
    }
}
