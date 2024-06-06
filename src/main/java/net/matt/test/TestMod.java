package net.matt.test;

import net.fabricmc.api.ModInitializer;

import net.matt.test.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMod implements ModInitializer {

	public static final String MOD_ID = "test-mod";
    public static final Logger LOGGER = LoggerFactory.getLogger("test-mod");

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
	}
}