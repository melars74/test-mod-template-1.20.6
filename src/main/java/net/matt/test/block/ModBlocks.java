package net.matt.test.block;

import net.matt.test.TestMod;
import net.matt.test.block.custom.BoxLampBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block BOX_BLOCK = registerBlock("box_block",
            new Block(AbstractBlock.Settings.copy(Blocks.SPRUCE_WOOD)));
    public static final Block BOX_LAMP_BLOCK = registerBlock("box_lamp_block",
            new BoxLampBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_WOOD)
                    .luminance(state -> state.get(BoxLampBlock.LIT) ? 15 : 0)));

    /*
        //example:
    public static final Block BOX_BLOCK = registerBlock("box_block",
            new Block(AbstractBlock.Settings.copy(Blocks.SPRUCE_WOOD).SOUNDS(BlockSoundGroup.AMETHYST_BLOCK)));
     */

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(TestMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        TestMod.LOGGER.info("Registering ModBlocks for " + TestMod.MOD_ID);
    }
}
