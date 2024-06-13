package net.matt.test.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.matt.test.TestMod;
import net.matt.test.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    /*
        Add any item groups here. Kinda confusing but just roll w it, make sure
        to add translation for group name and set icon as desired
     */

    public static final ItemGroup BOX_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TestMod.MOD_ID, "box"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.box"))
                    .icon(() -> new ItemStack(ModItems.BOX)).entries(((displayContext, entries) -> {
                        /*
                            Add item entries for this group here:

                            Note that order will be maintained.
                         */

                        //items
                        entries.add(ModItems.BOX);
                        entries.add(ModItems.CARDBOARD);
                        //blocks
                        entries.add(ModBlocks.BOX_BLOCK);

                    })).build());

    public static void registerItemGroups() {
        TestMod.LOGGER.info("Registering Mod");
    }
}
