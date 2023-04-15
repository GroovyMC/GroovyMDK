package com.authorname.examplemod

import groovy.transform.CompileStatic
import groovy.transform.PackageScope
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.material.Material
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import net.thesilkminer.mc.austin.api.Mojo
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Mojo(MOD_ID)
@CompileStatic
class ExampleMod {
    @PackageScope static final String MOD_ID = "examplemod" // The value here should match an entry in the mods.groovy file
    static final Logger LOGGER = LoggerFactory.getLogger(ExampleMod)

    // create Deferred Registers to hold Blocks and Items respectively which will all be registered under the "examplemod" namespace
    static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID)
    static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID)

    // create a new Block with the id "examplemod:example_block", combining the namespace and path
    static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE)))

    // create a new BlockItem for the EXAMPLE_BLOCK so that it can be accessed from the creative inventory
    static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block", () ->
            new BlockItem(EXAMPLE_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)) as Item)

    ExampleMod() {
        LOGGER.info "${MOD_ID.capitalize()} starting"

        // register the Deferred Registers to the modBus so that blocks and items get registered
        BLOCKS.register(modBus)
        ITEMS.register(modBus)

        // add an event listener to the modBus for the FMLCommonSetupEvent
        // see client/ClientForgeBusEvents.groovy for an example of how to use the EventBusSubscriber
        modBus.addListener { FMLCommonSetupEvent event ->
            LOGGER.info "Hello from FMLCommonSetupEvent"
        }

        // modBus and forgeBus are non-static properties of type IEventBus that are dynamically added by the @Mojo annotation.
        // For IDE support, either install the EnhancedGroovy IntelliJ plugin or change `class ExampleMod` to `class ExampleMod implements BaseMojo`
    }
}
