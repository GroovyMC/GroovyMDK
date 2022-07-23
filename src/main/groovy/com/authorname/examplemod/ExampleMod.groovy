package com.authorname.examplemod

import net.thesilkminer.mc.austin.api.Mojo
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Mojo(MOD_ID)
class ExampleMod {
    static final String MOD_ID = "examplemod" // The value here should match an entry in the META-INF/mods.toml file
    static final Logger LOGGER = LoggerFactory.getLogger(ExampleMod)

    ExampleMod() {
        LOGGER.info "${MOD_ID.capitalize()} starting up"
        LOGGER.info SV(GroovySystem.version)

        // for dynamic Groovy, you can use the following:
//        modBus.addListener { FMLCommonSetupEvent event ->
//            LOGGER.info "Hello from FMLCommonSetupEvent"
//        }

        // modBus and forgeBus are non-static properties of type IEventBus that are dynamically added by the @Mojo annotation.
        // For IDE support, in IntelliJ right click modBus/forgeBus -> click lightbulb -> "Add dynamic property..." -> set type to
        // net.minecraftforge.eventbus.api.IEventBus -> uncheck "Static" -> click Ok

        // see client/ClientForgeBusEvents.groovy for an example of how to use the EventBusSubscriber, which also works with @CompileStatic
    }
}
