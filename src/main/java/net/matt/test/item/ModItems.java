package net.matt.test.item;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.matt.test.TestMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    /*
        Add any new items here. Follow CAPS_UNDERSCORE naming convention. Usually
        will want default settings from 'Item'
     */
    public static final Item BOX = registerItem("box", new Item(new Item.Settings()));
    public static final Item CARDBOARD = registerItem("cardboard", new Item(new Item.Settings()));

    /*
        This is how to add to an already existing item group, see registerModItems()
     */
    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(BOX);
        entries.add(CARDBOARD);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TestMod.LOGGER.info("Registering Mod Items for " + TestMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
