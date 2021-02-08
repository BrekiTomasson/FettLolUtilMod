package net.brekitomasson.fettlol;

import net.brekitomasson.fettlol.base.ConfigurationMixinConditions;
import net.brekitomasson.fettlol.config.UtilModConfig;
import net.brekitomasson.fettlol.init.*;
import net.brekitomasson.fettlol.util.RegistryHelper;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UtilMod implements ModInitializer {

    public static final UtilModConfig CONFIG = ConfigurationMixinConditions.CONFIG;

    public static final String MOD_ID = "fettlol";

    public static Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static ItemGroup ITEMGROUP = FabricItemGroupBuilder.create(RegistryHelper.makeId(MOD_ID))
        .icon(() -> new ItemStack(net.minecraft.item.Items.ZOMBIE_HEAD))
        .build();

    @Override
    public void onInitialize() {
        LOGGER.info("Starting FettLol Utility Mod.");

        // Initialize our entites!
        Entities.init();

        // Initialize our enchantments!
        Enchants.init();

        // Initialize our items!
        Items.init();

        // Initialize our loot tables!
        LootTables.init();

        // Initialize our custom mod integrations!
        ModIntegrations.init();

        // And, finally, initialize all our little tweaks and adjustments!
        Tweaks.init();

    }
}
