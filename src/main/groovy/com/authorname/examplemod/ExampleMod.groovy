package com.authorname.examplemod

import groovy.transform.CompileStatic
import groovy.transform.PackageScope
import groovy.util.logging.Slf4j
import net.minecraft.core.registries.Registries
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.CreativeModeTabs
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.material.MapColor
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import org.groovymc.gml.GMod

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

    // create Deferred Registers to hold Blocks, Items and CreativeModeTabs respectively which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.MOD_ID)
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MOD_ID)
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExampleMod.MOD_ID)

    // create a new Block with the id "examplemod:example_block", combining the namespace and path
    public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register('example_block') {
        return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE))
    }

    // create a new BlockItem for the EXAMPLE_BLOCK so that it can be accessed from the creative inventory
    public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register('example_block') {
        return new BlockItem(EXAMPLE_BLOCK.get(), new Item.Properties()) as Item
    }

    // create a new food Item with the id "examplemod:example_food", nutrition 1, saturation 2 and no effects
    public static final RegistryObject<Item> EXAMPLE_FOOD = ITEMS.register('example_food') {
        return new Item(new Item.Properties().food(new FoodProperties.Builder()
                .alwaysEat().nutrition(1).saturationMod(2f).build()
        ))
    }

    // create a new custom CreativeModeTab for the EXAMPLE_FOOD that is placed after the combat tab
    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register('example_tab') {
        return CreativeModeTab.builder()
                .withTabsBefore(CreativeModeTabs.COMBAT)
                .icon(() -> EXAMPLE_FOOD.get().defaultInstance)
                .displayItems((CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output output) -> {
                    // Add the example food item to the tab. For your own tabs, this method is preferred over the BuildCreativeModeTabContentsEvent
                    output.accept(EXAMPLE_FOOD.get())
                })
                .build()
    }

    ExampleMod() {
        log.info "${MOD_ID.capitalize()} starting"

        // register the Deferred Registers to the modBus so that blocks, items and tabs get registered
        BLOCKS.register(modBus)
        ITEMS.register(modBus)
        CREATIVE_MODE_TABS.register(modBus)

        // add an event listener to the modBus to add the EXAMPLE_BLOCK_ITEM to the creative inventory
        modBus.addListener { BuildCreativeModeTabContentsEvent event ->
            if (event.tabKey === CreativeModeTabs.BUILDING_BLOCKS)
                event.accept(EXAMPLE_BLOCK_ITEM.get())
        }

        // see client/ClientForgeBusEvents.groovy for an example of how to use the @EventBusSubscriber annotation

        // modBus and forgeBus are non-static properties of type IEventBus that are dynamically added by the @GMod annotation.
        // For IDE support, either install the EnhancedGroovy IntelliJ plugin or change `class ExampleMod` to `class ExampleMod implements BaseGMod`
    }
}
