package com.authorname.examplemod

import com.matyrobbrt.gml.GMod
import groovy.transform.CompileStatic
import groovy.transform.PackageScope
import groovy.util.logging.Slf4j
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.CreativeModeTabs
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.material.Material
import net.minecraftforge.event.CreativeModeTabEvent
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject

/**
 * The main mod class - this is the entry point for your mod.
 *
 * <p>Note: Don't reference client-only classes here (such as KeyMapping or Screen) - doing so will cause a crash
 * on dedicated servers!</p>
 *
 * <p>If you need to reference client-only things, do it in a separate class and rely on {@code @EventBusSubscriber} or
 * put the {@code xBus.addListener()} call behind an {@code if (FMLEnvironment.dist.isClient())} check.</p>
 */
@Slf4j
@GMod(MOD_ID)
@CompileStatic
class ExampleMod {
    @PackageScope static final String MOD_ID = 'examplemod' // The value here should match an entry in the mods.groovy file

    // create Deferred Registers to hold Blocks and Items respectively which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.MOD_ID)
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MOD_ID)

    // create a new Block with the id "examplemod:example_block", combining the namespace and path
    public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register('example_block') {
        return new Block(BlockBehaviour.Properties.of(Material.STONE))
    }

    // create a new BlockItem for the EXAMPLE_BLOCK so that it can be accessed from the creative inventory
    public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register('example_block') {
        return new BlockItem(EXAMPLE_BLOCK.get(), new Item.Properties()) as Item
    }

    ExampleMod() {
        log.info "${MOD_ID.capitalize()} starting"

        // register the Deferred Registers to the modBus so that blocks and items get registered
        BLOCKS.register(modBus)
        ITEMS.register(modBus)

        // add an event listener to the modBus to add the EXAMPLE_BLOCK_ITEM to the creative inventory
        modBus.addListener { CreativeModeTabEvent.BuildContents event ->
            if (event.tab === CreativeModeTabs.BUILDING_BLOCKS)
                event.accept(EXAMPLE_BLOCK_ITEM.get())
        }

        // see client/ClientForgeBusEvents.groovy for an example of how to use the @EventBusSubscriber annotation

        // modBus and forgeBus are non-static properties of type IEventBus that are dynamically added by the @GMod annotation.
        // For IDE support, either install the EnhancedGroovy IntelliJ plugin or change `class ExampleMod` to `class ExampleMod implements BaseGMod`
    }
}
